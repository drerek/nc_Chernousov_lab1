package com.analyzer;

import com.fillers.GenerationArray;
import com.reflect.Reflect;
import com.sorters.OurMethod;
import com.sorters.Sort;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.area.AreaLineChart03;
import org.knowm.xchart.style.Styler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;


/**
 * class for writing conclusion information in xls
 * Use {@link org.apache.poi}
 * Use {@link com.reflect.Reflect}
 * Use {@link com}
 *
 * @author Chernousov
 */
public class Analyzer {
    /**
     * Method that write picture in XLS file
     * @param workSheet sheet of xls in which write
     * @param bImage Buffered image
     * @param col number of column
     * @param row number of row
     */
    private static void  writePicturePOI(Sheet workSheet, BufferedImage bImage, int col, int row) {
        try {
            Drawing drawing = null;
            ClientAnchor anchor = null;

            drawing = null;
            anchor = null;
            ByteArrayOutputStream byteArrayImg = new ByteArrayOutputStream();
            ImageIO.write(bImage, "JPEG", byteArrayImg);
            int pictureIdx =workSheet.getWorkbook().addPicture(byteArrayImg.toByteArray(),
                    workSheet.getWorkbook().PICTURE_TYPE_JPEG);

            short s1=5, s2=5;
            anchor = new HSSFClientAnchor(0, 0, 0, 0, s1, 5, s2, 5);
            anchor.setCol1(col);
            anchor.setRow1(row);

            drawing = workSheet.createDrawingPatriarch();
            Picture pict = drawing.createPicture(anchor, pictureIdx);
            pict.resize();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Method that get all methods, calculate time of sorting and write at XLS
     * @param maxlength max length of generation arrays, step *10

     */
    @SuppressWarnings("deprecation")
    public void analyzer(int maxlength) throws InvocationTargetException, IllegalAccessException, InstantiationException, IOException {

//        HSSFWorkbook ExcelBook = new HSSFWorkbook(new FileInputStream("Template.xls"));
        HSSFWorkbook ExcelBook = new HSSFWorkbook();
        Set<Method> sorters = Reflect.getAllSubMethods("com.sorters",Sort.class, OurMethod.class);
        Set<Method> fillers = Reflect.getAnnotationMethods("com.fillers.Fillers", GenerationArray.class);
        int iterations = 0;
        int maxlength1 = maxlength;
        while (maxlength1!=1){
            maxlength1 = maxlength1/10;
            iterations++;
        }

        for (Method sort:sorters){

            XYChart chart = new XYChartBuilder().width(800).height(600).title(sort.getDeclaringClass().getName().substring(12)).xAxisTitle("Length").yAxisTitle("Time").build();
            chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
            chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
            chart.getStyler().setYAxisDecimalPattern("ms #");
            chart.getStyler().setPlotMargin(0);
            chart.getStyler().setPlotContentSize(.95);


            Sheet sheet = ExcelBook.createSheet(sort.getDeclaringClass().getName().substring(12));
            assert fillers != null;
            int rowIndex=1;

            for (Method fill: fillers){

                double xdata[] = new double[iterations];
                double ydata[] = new double[iterations];
                Row row0 = sheet.createRow(0);
                Row row = sheet.createRow(rowIndex);

                rowIndex++;

                Cell name = row.createCell(0);
                name.setCellValue(fill.getName());

                int cellIndex=1;
                int plotIndex=0;

                for (int n=10;n<=maxlength;n*=10) {

                    Cell length = row0.createCell(cellIndex);
                    length.setCellValue(n);
                    Cell data = row.createCell(cellIndex);
                    cellIndex++;
                    long startTime = System.currentTimeMillis();
                    int[] array = (int[]) fill.invoke(null, n);
                    sort.invoke(sort.getDeclaringClass().newInstance(), (Object) array);
                    long endTime = System.currentTimeMillis();

                    ydata[plotIndex] = n;
                    xdata[plotIndex] = endTime - startTime;

                    data.setCellValue(endTime - startTime);
                    plotIndex++;
                }

                for (int p=0;p<=cellIndex;p++)
                    sheet.autoSizeColumn(p);

                chart.addSeries(fill.getName(), ydata, xdata);
            }

            ExampleChart<XYChart> exampleChart = new AreaLineChart03();
            BitmapEncoder.saveBitmap(chart,".\\img", BitmapEncoder.BitmapFormat.JPG);
            writePicturePOI(sheet,ImageIO.read(new File(".\\img.jpg")),0,fillers.size()+1);
        }


        ExcelBook.write(new FileOutputStream(""+System.currentTimeMillis()+".xls"));
        ExcelBook.close();
    }

    public static void main(String[] args) throws Exception {
        new Analyzer().analyzer(10000);
    }
}
