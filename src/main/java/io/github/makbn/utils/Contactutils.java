package io.github.makbn.utils;

import io.github.makbn.annotations.Email;
import io.github.makbn.annotations.Phone;

/**
 * Mehdi AKbarian-astaghi 8/11/19
 */
public class Contactutils {


    public static String getRandomEmail(String name, Email.Provider provider){
        String email;
        if(name != null && name.length() > 0){
            email = name;
        } else {
            email = NameUtils.getRandomFunnyName();
        }

        return email.trim()
                .replace(" ",".")
                .replace("-",".")
                .replace("_",".") + "@" + provider.getDomain();
    }

    public static String getRandomPhone(Phone.Format format){
        return format.getExample();
    }
}
