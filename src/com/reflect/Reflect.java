package com.reflect;

import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for getting methods by annotations
 * use {@link org.reflections.Reflections}
 *
 * @author Chernousov
 */
public class Reflect {

    /**
     * Method that return set of methods consists in some Class by Annotation {@link java.lang.annotation.Annotation}
     * @param nameClass name of class in which we search
     * @param annotationClass class of annotation
     * @return set of Methods
     */
    public static Set<Method> getAnnotationMethods(String nameClass, Class annotationClass) {
        Method[] methods;
        try {
            Class cl = Class.forName(nameClass);
            methods = cl.getMethods();
            Set<Method> methodSet = new HashSet<>();
            for (Method m : methods) {
                if (m.isAnnotationPresent(annotationClass)) {
                    methodSet.add(m);
                }
            }
            return methodSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method that return all methods of subclasses some Class by annotation
     * @param namePackage name of package in which search
     * @param abstractClass name of class from which it is inherited
     * @param annotationClass name of annotation on which search
     * @return set of methods
     */
    public static Set<Method> getAllSubMethods(String namePackage, Class abstractClass, Class annotationClass) {
        Set<Class<?>> allSubClasses = getAllSubClasses(namePackage, abstractClass);
        Set<Method> methodSet = new HashSet<>();
        for (Class oneClass : allSubClasses) {
            methodSet.addAll(getAnnotationMethods(oneClass.getName(), annotationClass));
        }
        return methodSet;
    }

    /**
     * Method that return all sub classes from class in package
     * @param namePackage name of package in which we search
     * @param abstractClass name of class from which it is inherited
     * @return set of inherited classes
     */
    private static Set<Class<?>> getAllSubClasses(String namePackage, Class abstractClass) {
        Reflections reflections = new Reflections(namePackage);
        return reflections.getSubTypesOf(abstractClass);
    }
}
