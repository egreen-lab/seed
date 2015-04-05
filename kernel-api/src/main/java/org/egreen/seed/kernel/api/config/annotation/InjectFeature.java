package org.egreen.seed.kernel.api.config.annotation;

import java.lang.annotation.ElementType;

/**
 * Created by dewmal on 4/3/15.
 */
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value = {ElementType.FIELD})
public @interface InjectFeature {


    long provider() default 0;


}
