package io.github.makbn.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Mehdi Akbarian-Rastaghi 8/11/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Phone {

    Format format() default Format.Local;


     enum Format{

        /*example : 754-3010*/
        Local("754-3010"),

        /*example : (541) 754-3010*/
        Domestic("(541) 754-3010"),

        /*example : +1-541-754-3010*/
        International("+1-541-754-3010"),

        /*example : 1-541-754-3010*/
        US("1-541-754-3010"),

        /*example : 001-541-754-3010*/
        Germany("001-541-754-3010"),

        /*example : 191 541 754 3010*/
        France("191 541 754 3010");

        private String example;

         Format(String example) {
             this.example = example;
         }

         public String getExample() {
             return example;
         }
     }
}
