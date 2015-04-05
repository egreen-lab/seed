package org.egreen.seed.kernel.api.config.annotation;

/**
 * Created by dewmal on 4/1/15.
 */
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value = {java.lang.annotation.ElementType.TYPE})
public @interface Provider {

    long id();

    Class<?> feature();


    String version();

}
