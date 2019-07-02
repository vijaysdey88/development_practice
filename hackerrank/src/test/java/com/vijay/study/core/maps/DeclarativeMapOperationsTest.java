package com.vijay.study.core.maps;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DeclarativeMapOperationsTest {

    @Test
    public void testComputeToFunctionallyAlterValues(){

    }


    private static final class Person {
        final String name;
        final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }



}