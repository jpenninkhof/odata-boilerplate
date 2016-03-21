package com.penninkhof.odata.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD})
@Retention(RUNTIME)

public @interface Sap {
	boolean sortable() default false;
	boolean filterable() default false;
	boolean creatable() default false;
	boolean updatable() default false;
}