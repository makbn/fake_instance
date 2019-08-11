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
public @interface Password {

    int len() default  16;
    boolean includeNumbers() default true;
    boolean isPalindrome() default false;
    boolean includeUppercaseChars() default false;
    boolean includeAmbiguousChars() default false;

}
