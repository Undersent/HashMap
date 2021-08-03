package com.futurecollars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MapExampleTest {


    @Test
    void getValue() {
        Map<Long, String> names = new HashMap<>();
        names.put(1L, "Kamil");
        names.put(2L, null);

        String secondElement = names.get(2L);
        String thirdElement = names.get(3L);

        Assertions.assertNull(secondElement);
        Assertions.assertNull(thirdElement);

        boolean isSecondElement = names.containsKey(2L);
        boolean isThirdElement = names.containsKey(3L);

        Assertions.assertTrue(isSecondElement);
        Assertions.assertFalse(isThirdElement);
    }

    //unikalne klucze, ale wartosci moga sie powtarzac
    @Test
    void unique() {
        Map<Long, String> names = new HashMap<>();
        names.put(1L, "Kamil");
        System.out.println("Mapa przed nadpisaniem: " + names);
        names.put(1L, "Pablo");
        System.out.println("Mapa po nadpisaniu: " + names);

        Assertions.assertEquals(2, names.size());
    }

    //iterowanie
    @Test
    void iterate() {
        Map<Long, String> countries = new HashMap<>();

        countries.put(1L, "Poland");
        countries.put(2L, "Germany");

        for (Long key : countries.keySet()) {
            System.out.println("Key: " + key + ", value: " + countries.get(key));
        }

        for (Map.Entry<Long, String> entry : countries.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }


    //jezeli zalezy Ci na kolejnosci to LinkedHashMap, posortowane -> TreeMap
    @Test
    void iterate2() {
        Map<Person, Integer> people = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            people.put(new Person("Test" + i), i);
        }
        System.out.println("Order map: " + people);


        for (int i = 10; i < 20; i++) {
            people.put(new Person("Test" + i), i);
        }
        System.out.println("Order map: " + people);
    }

    //dla nulli jest specjalny bucket bo jak na nullu wywolac hashcode - zerowy bucket
    @Test
    void nullValues() {
        Map<Person, Person> people = new HashMap<>();
        Person rafal = new Person("Rafal");
        people.put(null, rafal);
        Person kasia = new Person("Kasia");
        people.put(null, kasia);

        System.out.println(people);
    }

    //klucze niemodyfikowalne
    @Test
    void immutable() {
        Person rafal = new Person("Rafal");
        Person lawro = new Person("Lawro");
        Person jan = new Person("Jan");
        Person kowalski = new Person("Kowalski");


        Map<Person, Person> people = new HashMap<>();

        people.put(rafal, lawro);
        people.put(jan, kowalski);

        System.out.println(people);
        System.out.println(people.get(rafal));
        rafal.setName("Rafaello");

        System.out.println(people);

        System.out.println(people.get(rafal));
    }


}