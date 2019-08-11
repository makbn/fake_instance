package io.github.makbn;

import io.github.makbn.annotations.*;
import io.github.makbn.annotations.Number;
import io.github.makbn.utils.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.*;

/**
 * Mehdi Akbarian-Rastaghi 8/11/19
 */
public class FakeInstance {

    private static Random random = new Random();
    private HashMap<String, Object> values;


    public static FakeInstance get() {
        return new FakeInstance();
    }


    private FakeInstance() {
        this.values = new HashMap<>();
    }


    public <T> T createAndFill(Class<T> clazz, int depth) {
        T instance = null;
        if (clazz.equals(Set.class))
            instance = (T) new HashSet<>();
        else if (clazz.equals(List.class) || clazz.equals(Collection.class))
            instance = (T) new ArrayList<>();
        else if (clazz.equals(Map.class))
            instance = (T) new HashMap<>();
        else {
            try {
                instance = clazz.newInstance();
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value = getRandomValueForField(field, depth);
                    field.set(instance, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private Object getRandomValueForField(Field field, int depth) {
        Class<?> type = field.getType();
        return getRandomValueForField(field, type, depth);
    }

    private Object getRandomValueForField(Field field, Class<?> type, int depth) {

        if (type.equals(Integer.TYPE) || type.equals(Integer.class)
                || type.equals(Long.TYPE) || type.equals(Long.class)
                || type.equals(Double.TYPE) || type.equals(Double.class)
                || type.equals(Float.TYPE) || type.equals(Float.class)) {
            return numberGenerator(field, type);
        } else if (type.equals(String.class)) {
            return textGenerator(field, type);
        } else if (type.equals(BigInteger.class)) {
            return BigInteger.valueOf(random.nextInt());
        } else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
            return random.nextInt() % 2 == 0;
        } else if ((type.equals(List.class) || type.equals(ArrayList.class)) && depth < 3) {
            try {
                ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
                Class<?> generic = (Class<?>) stringListType.getActualTypeArguments()[0];
                return getGenericList(getRandomValueForField(null, generic, depth));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (type.equals(Date.class)) {
            return Calendar.getInstance().getTime();
        } else if (type.equals(Enum.class) || type.isEnum()) {
            return UserEnumUtils.randomLetter(type.asSubclass(Enum.class));
        }
        if (depth > 3)
            return null;

        type.isEnum();
        return createAndFill(type, ++depth);
    }

    private Object textGenerator(Field field, Class<?> type) {
        Annotation[] annotations = field.getAnnotations();

        for (Annotation ann : annotations) {
            if (ann instanceof Address) {
                return LocationUtils.getRandomAddress();
            } else if (ann instanceof City) {
                return LocationUtils.getRandomCity();
            } else if (ann instanceof Country) {
                return LocationUtils.getRandomCountry(((Country) ann).shortNameForm());
            } else if (ann instanceof Name) {
                if (values.containsKey("name")) {
                    return values.get("name");
                } else {
                    String name = NameUtils.getRandom(((Name) ann).gender());
                    values.put("name", name);
                    return name;
                }
            } else if (ann instanceof Password) {
                Password pAnn = ((Password) ann);
                return CredentialUtils.getRandom(pAnn.len(), pAnn.isPalindrome(), pAnn.includeAmbiguousChars(),
                        pAnn.includeUppercaseChars(), pAnn.includeNumbers());
            } else if (ann instanceof Text) {
                return TextUtils.getRandom(((Text) ann).equalOrShorterThan());
            } else if (ann instanceof Username) {
                String name = null;
                if (values.containsKey("name")) {
                    name = (String) values.get("name");
                }
                return CredentialUtils.getRandomUsername(name, ((Username) ann).containsNumber());
            } else if (ann instanceof Email) {
                String name = null;
                if (values.containsKey("name")) {
                    name = (String) values.get("name");
                }
                return Contactutils.getRandomEmail(name, ((Email) ann).provider());
            } else if (ann instanceof Phone) {
                return Contactutils.getRandomPhone(((Phone) ann).format());
            } else {
                return UUID.randomUUID().toString();
            }
        }
        return null;
    }

    private Object numberGenerator(Field field, Class<?> type) {
        Annotation ann = field.getAnnotation(Number.class);
        boolean positive;
        boolean negative;
        int len;
        String nt = null;
        if (ann != null) {
            positive = ((Number) ann).positive();
            negative = ((Number) ann).negative();
            len = ((Number) ann).len() >= 1 ? ((Number) ann).len() : 1;
            nt = NumberUtils.GenerateRandomNumber(len);

            if (negative)
                nt = "-" + nt;

            else if (!positive) {
                nt = (random.nextInt(10) % 2 == 0 ? "-" : "") + nt;
            }
        }

        if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return nt != null ? Integer.valueOf(nt) : Math.abs(random.nextInt());
        } else if (type.equals(Long.TYPE) || type.equals(Long.class)) {
            return nt != null ? Long.valueOf(nt) : Math.abs(random.nextLong());
        } else if (type.equals(Double.TYPE) || type.equals(Double.class)) {
            return nt != null ? Double.valueOf(nt) : random.nextDouble();
        } else if (type.equals(Float.TYPE) || type.equals(Float.class)) {
            return nt != null ? Float.valueOf(nt) : random.nextFloat();
        }

        return null;
    }

    private static <Type> List<Type> getGenericList(Object... params) {
        List<Type> l = new ArrayList<Type>();
        for (int i = 0; i < params.length; i++) {
            l.add((Type) params[i]);
        }
        return l;
    }


    public static class Person {

        @Username(containsNumber = true)
        private String username;

        @Email(provider = Email.Provider.Hotmail)
        private String email;

        @Name(gender = Name.Gender.Male)
        private String name;

        @Phone
        private String phone;

        @Password
        private String password;

        @Number(negative = true)
        private int num;

        @Number(len = 2, positive = true)
        private double num3;

        @Address
        private String address;

        @Text(equalOrShorterThan = 30)
        private String text;

        @City
        private String city;

        @Country
        private String country;


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{\n" +
                    "username='" + username + '\'' + "\n" +
                    ", email='" + email + '\'' + "\n" +
                    ", name='" + name + '\'' + "\n" +
                    ", phone='" + phone + '\'' + "\n" +
                    ", password='" + password + '\'' + "\n" +
                    ", num=" + num + "\n" +
                    ", num3=" + num3 + "\n" +
                    ", address='" + address + '\'' + "\n" +
                    ", text='" + text + '\'' + "\n" +
                    ", city='" + city + '\'' + "\n" +
                    ", country='" + country + '\'' + "\n" +
                    '}';
        }
    }


    public static void main(String[] args) {
        Person p = FakeInstance.get().createAndFill(Person.class, 1);

        System.out.println(p);

        p = FakeInstance.get().createAndFill(Person.class, 1);

        System.out.println(p);
    }

}
