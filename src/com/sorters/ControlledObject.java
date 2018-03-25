package com.sorters;

import java.lang.annotation.*;

/**
 * Annotation for class
 * @author Chernousov
 */
@Inherited
@Target(value= ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ControlledObject {
    String name();
}
