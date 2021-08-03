package com.futurecollars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class MapExampleTest
{

    //unikalne klucze
    @Test
    void shouldCreateMap2() {
        Map<Long, String> names = new HashMap<>();
        names.put(1L, "Kamil");
        System.out.println("Mapa przed nadpisaniem: " + names);
        names.put(1L, "Pablo");
        System.out.println("Mapa po nadpisaniu: " + names);
    }

    //iterowanie
    @Test
    void shouldCreateMap() {
        Map<Long, String> countries = new HashMap<>();

        countries.put(1L, "Poland");
        countries.put(2L, "Germany");

        for(Long key : countries.keySet()) {
            System.out.println("Key: " + key + ", value: " + countries.get(key));
        }

        for(Map.Entry<Long, String> entry : countries.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }



    //jezeli zalezy Ci na kolejnosci to LinkedHashMap
    @Test
    void shouldCreateMap3() {
        Map<Person, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            orderMap.put(new Person("Test" + i), i);
        }
        System.out.println("Order map: " + orderMap);


        for (int i = 10; i < 20; i++) {
            orderMap.put(new Person("Test" + i), i);
        }
        System.out.println("Order map: " + orderMap);
    }

    //klucze niemodyfikowalne
    @Test
    void immutable()
    {
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