package io.github.makbn.utils;

import java.util.*;

/**
 * Mehdi AKbarian-astaghi 8/11/19
 */
public class LocationUtils {

    private static String[] locales = Locale.getISOCountries();
    private static ArrayList<String> cities = new ArrayList<>();
    private static ArrayList<String> address = new ArrayList<>();
    private static Random random = new Random();


    static {
        cities.addAll(Arrays.asList(
                "Chongqing",
                "Shanghai",
                "Mumbai",
                "Istanbul",
                "Tokyo",
                "New York City",
                "Tehran",
                "Sari",
                "Baghdad",
                "Rio de Janeiro",
                "Sydney",
                "Casablanca",
                "Melbourne",
                "Los Angeles",
                "Busan",
                "Mashhad",
                "Baku",
                "Toronto",
                "Rome",
                "Dubai",
                "Isfahan",
                "Paris",
                "Karaj",
                "Shiraz",
                "Barcelona",
                "Calgary",
                "Cologne",
                "Cartagena"
        ));

        address.addAll(Arrays.asList(
                "3857 Gerald L. Bates Drive",
                "2451 Oak Way",
                "2831 Shinn Street0",
                "3000 Limer Street",
                "1434 Duck Creek Road",
                "2488 Point Street",
                "264 Meadow Lane",
                "3285 Wildrose Lane",
                "1148 Canis Heights Drive",
                "47 Langtown Road",
                "4928 Hilltop Street",
                "568 Quarry Drive",
                "3882 Hillcrest Lane",
                "1243 Pine Tree Lane",
                "4004 Valley Drive",
                "183 Star Trek Drive",
                "1516 Morningview Lane",
                "3347 Stratford Drive",
                "496 Jadewood Drive",
                "4194 Bloomfield Way",
                "1312 Drummond Street"

        ));
    }


    /**
     * Country Code = getCountry()
     * Country Name = getDisplayCountry()
     * @return {{@link Locale}}
     */
    public static String getRandomCountry(boolean shortName){

        int index = random.nextInt(locales.length);
        Locale locale = new Locale("", locales[index]);

        if(shortName)
            return locale.getCountry();
        else
            return locale.getDisplayCountry();
    }

    public static String getRandomCity(){
        return cities.get(random.nextInt(cities.size()));
    }


    public static String getRandomAddress(){
        return address.get(random.nextInt(address.size()));
    }
}
