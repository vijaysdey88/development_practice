package com.vijay.study.core.functional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicFunctionsTest {

    @Test
    public void testReduceToSum(){

        final List<Integer> list = IntStream.range(0, 5)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("formula:" + list.stream()
                .reduce((i1, i2) -> i1  + i2).get());

        final List<Person> p = Arrays.asList(new Person(1, "a"), new Person(2, "b"));

        final OptionalInt minage = p.stream().mapToInt(Person::getAge).reduce((a1, a2) -> a1 > a2 ? a2 : a1);
        System.out.println("Min age: " + minage.getAsInt() );
    }

    @Test
    public void mapTest(){
        final Optional<Object> empty = Optional.empty();
        System.out.println(empty.map(Object::toString));

        System.out.println(Optional.of("test").map(s -> s.replace('t', 'T')));
    }

    @Test
    public void testFlatMap(){
        final Stream<List<Person>> personStream = Arrays.asList(
                Arrays.asList(new Person(1, "a"), new Person(2, "b")),
                Arrays.asList(new Person(1, "c"), new Person(2, "d")),
                Arrays.asList(new Person(1, "e"), new Person(2, "f"))
        ).stream();
        final Stream<Person> flattenedPersonStream = personStream
                .flatMap(l -> l.stream());

        flattenedPersonStream.forEach(System.out::println);

        System.out.println("flatenning already flattened");
        Arrays.asList(new Person(1, "a"), new Person(2, "b"))
                .stream()
                .flatMap(p -> Arrays.asList(p).stream())
                .forEach(System.out::println);


        System.out.println("flatenning words");
        Arrays.asList("line1 has some words", "line2 has more words")
                .stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .forEach(System.out::println);

        System.out.println("mapping words");
        System.out.println(Optional.of("string this that and more")
                                    .map(s -> s.toLowerCase()).get());

        System.out.println(Optional.of("string this that and more")
                                    .flatMap(s -> Optional.of(s.split(" "))).get());
    }


    private static class Person {
        final int age;
        final String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}