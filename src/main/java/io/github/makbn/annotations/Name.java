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
public @interface Name {

    Gender gender();


    enum Gender{
        Male,
        Female
    }

    enum Type{
        FirstName,
        LastName,
        FullName

    }
}
