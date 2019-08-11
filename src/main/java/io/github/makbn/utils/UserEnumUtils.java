package io.github.makbn.utils;

import java.util.Random;

/**
 * Mehdi AKbarian-astaghi 8/11/19
 */
public class UserEnumUtils {

    public static <T extends Enum> Object randomLetter(Class<T> enumClass) {
        int len = enumClass.getFields().length;
        Object t = Enum.valueOf(enumClass, enumClass.getFields()[new Random().nextInt(len)].getName());
        return  t;
    }

}
