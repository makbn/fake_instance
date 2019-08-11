package io.github.makbn.utils;

import io.github.makbn.annotations.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Mehdi AKbarian-astaghi 8/11/19
 */
public class NameUtils {

    private static ArrayList<String> male = new ArrayList<>();
    private static ArrayList<String> female = new ArrayList<>();
    private static ArrayList<String> funnyNames = new ArrayList<>();
    private static Random random = new Random();


    static {
        male.addAll(Arrays.asList("Liam",
                "Noah",
                "William",
                "James",
                "Oliver",
                "Mehdi",
                "Mahyar",
                "Arvin",
                "Ali",
                "Elijah",
                "Lucas"));


        female.addAll(Arrays.asList("Emma",
                "Olivia",
                "Ava",
                "Isabella",
                "Sophia",
                "Sara",
                "Zahra",
                "Maryam",
                "Charlotte",
                "Mia",
                "Amelia"));

        funnyNames.addAll(Arrays.asList(
                "ragingpuma",
                "statutoryape",
                "lolikillyou",
                "judgeofwings",
                "dontkillme",
                "Chiclet",
                "Babushka",
                "Bagel",
                "Wilma",
                "Fritzie",
                "Fuzzkins",
                "Butters",
                "Goose",
                "Hermione"
        ));
    }


    public static String getRandom(Name.Gender gender){
        if(gender == null){
            int index = random.nextInt(male.size() + female.size());
            return index >= male.size() ? female.get(index-male.size()) : male.get(index);
        }else if(gender == Name.Gender.Male){
            return male.get(random.nextInt(male.size()));
        }else {
            return male.get(random.nextInt(female.size()));
        }
    }

    public static String getRandomFunnyName(){
        return funnyNames.get(random.nextInt(funnyNames.size()));
    }
}
