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
public @interface Email {

    Provider provider() default Provider.Gmail;


    enum Provider{

        Gmail("gmail.com"),
        Yahoo("yahoo.com"),
        Hotmail("hotmail.com"),
        Outlook("outlook.com"),
        Zoho("zoho.com"),
        Aol("aol.com");

        private String domain;

        Provider(String s) {
            this.domain = s;
        }

        public String getDomain() {
            return domain;
        }
    }
}
