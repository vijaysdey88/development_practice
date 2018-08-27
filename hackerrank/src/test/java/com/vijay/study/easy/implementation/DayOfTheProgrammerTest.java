package com.vijay.study.easy.implementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DayOfTheProgrammerTest {

    static String dayOfProgrammer(int year) {
        final LocalDate date = dayOfProgrammerDate(year);
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    static LocalDate dayOfProgrammerDate(int year) {
        return dateFunction.apply(year).apply(year);
    }


    static Predicate<Integer> IS_GREGORIAN_LEAP = (year) -> year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    static Predicate<Integer> IS_JUILIAN_LEAP = (year) -> year % 4 == 0;
    static Predicate<Integer> IS_TRANSITION_YEAR = (year) -> year == 1918;
    static Function<Integer, Predicate<Integer>> CALENDAR_TYPE_FACTORY = (year) -> year < 1918 ? IS_JUILIAN_LEAP : IS_GREGORIAN_LEAP;
    static Function<Integer, Function<Integer, LocalDate>> dateFunction = (year) -> {
        if(IS_TRANSITION_YEAR.test(year))
            return (y) -> LocalDate.of(y, 9, 26);
        else
            return (y) -> {
                final Predicate<Integer> leapYearPredicate = CALENDAR_TYPE_FACTORY.apply(year);
                final int dayOfMonth;
                if(leapYearPredicate.test(y)) {
                    dayOfMonth = 12;
                } else {
                    dayOfMonth = 13;
                }
                return LocalDate.of(y, 9, dayOfMonth);
            };
    };

    @Test
    public void shouldGiveTheDayForALeapYearInGregorianCalendar() {
        assertDayOfProgrammerDate("Year divisible by 400 is leap", 2000, 9, 12);
        assertDayOfProgrammerDate("Year divisible by 400 is leap", 2400, 9, 12);
        assertDayOfProgrammerDate("Year divisible by 4 is leap but not by 100", 1920, 9, 12);
        assertDayOfProgrammerDate("Year divisible by 4 is leap but not by 100", 2004, 9, 12);
    }

    @Test
    public void shouldGiveTheDayForANonLeapYearInGregorianCalendar() {
        assertDayOfProgrammerDate("Odd year is not leap", 2001, 9, 13);
        assertDayOfProgrammerDate("Year divisible by 4 but also by 100 is not leap", 2200, 9, 13);
    }

    @Test
    public void shouldGiveTheDayForALeapYearInJulianCalendar() {
        assertDayOfProgrammerDate("Year divisible by 4 is leap", 1916, 9, 12);
        assertDayOfProgrammerDate("Year divisible by 4 is leap", 1700, 9, 12);
    }

    @Test
    public void shouldGiveTheDayForANonLeapYearInJulianCalendar() {
        assertDayOfProgrammerDate("Year divisible by 4 is leap", 1917, 9, 13);
        assertDayOfProgrammerDate("Year divisible by 4 is leap", 1701, 9, 13);
    }

    @Test
    public void shouldGiveTheDayForTheYearOfTransitionFromJulianToGregorian() {
        assertDayOfProgrammerDate("Year of Transition", 1918, 9, 26);
    }

    @Test
    public void tsetHRInput() {
        assertThat(dayOfProgrammer(2017), equalTo("13.09.2017"));
        assertThat(dayOfProgrammer(2016), equalTo("12.09.2016"));
        assertThat(dayOfProgrammer(1800), equalTo("12.09.1800"));
    }

    private void assertDayOfProgrammerDate(final String assertionReason, final int year, final int month, final int dayOfMonth) {
        assertThat(assertionReason, dayOfProgrammerDate(year), equalTo(LocalDate.of(year, month, dayOfMonth)));
    }
}
