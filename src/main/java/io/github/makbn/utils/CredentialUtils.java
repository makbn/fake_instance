package io.github.makbn.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Stack;

/**
 * Mehdi AKbarian-astaghi 8/11/19
 */
public class CredentialUtils {

    private static SecureRandom rand = new SecureRandom();
    private static Random random = new Random();


    public static String getRandom(int len, boolean palindrome, boolean specials, boolean upperCase, boolean numbers){
        char[] password = new char[len];

        if (palindrome){
            int length = password.length;
            Stack<Character> otherHalf = new Stack<Character>();
            int i = 0;
            while (i < length / 2){
                char placement = (char) ranSeq(specials, upperCase, numbers);
                password[i] = placement;
                otherHalf.push(placement);
                i++;
            }
            if (length % 2 == 1){
                otherHalf.push((char) ranSeq(specials, upperCase, numbers));
            }
            while (!otherHalf.isEmpty()){
                password[i] = otherHalf.pop();
                i++;
            }
        }else{
            for (int i = 0; i < password.length; i++){
                char placement = (char) ranSeq(specials, upperCase, numbers);
                password[i] = placement;
            }
        }

        return String.copyValueOf(password);
    }

    private static int ranSeq(boolean specials, boolean upperCase, boolean numbers){

        int placement = (rand.nextInt(94) + 33);
        if (!specials){
            if (placement >= 33 && placement <= 47 || placement >=58 && placement <= 64 || placement >= 91 && placement <= 96 || placement >= 123 && placement <= 126){
                return ranSeq(false, upperCase, numbers);
            }
        }
        if (!upperCase){
            if (placement >= 65 && placement <= 90){
                return ranSeq(specials, false, numbers);
            }
        }
        if (!numbers){
            if (placement >= 48 && placement <= 57){
                return ranSeq(specials, upperCase, false);
            }
        }
        return placement;
    }

    public static String getRandomUsername(String name, boolean numeric){
        String username = null;
        if(name != null && name.length()>0){
            username = name + String.valueOf(random.nextInt(100 * username.length()));
        } else {
            String funnyName = NameUtils.getRandomFunnyName();
            username = funnyName + String.valueOf(random.nextInt(100 * funnyName.length()));
        }

        return username;
    }
}
