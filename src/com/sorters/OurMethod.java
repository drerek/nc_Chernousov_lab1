package com.sorters;

import java.lang.annotation.*;

/**
 * Annotation for method sort
 * @author Chernousov
 */
@Inherited
@Target(value= ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface OurMethod{
}
