package com.vijay.study.easy.problemsolving;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TimeConversionTest {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hour = Integer.parseInt(s.split(":")[0]);
        final int convertedHour = convertHourTo24HourFormat(s, hour);
        return convertToString(convertedHour) + s.substring(2, s.length() - 2);
    }

    private static int convertHourTo24HourFormat(final String s, final int hour) {
        return hour % 12 + (s.endsWith("PM") ? 12 : 0);
    }

    private static String convertToString(final int convertedHour) {
        return padZero(String.valueOf(convertedHour));
    }

    private static String padZero(final String s) {
        return s.length() == 1 ? "0" + s : s;
    }


    @Test
    public void shouldConvertMidnightToAll0sIn24HourFormat() {
        executeAndAssert("12:00:00AM", "00:00:00");
    }

    @Test
    public void shouldConvertTimeInAMTo24HourFormat() {
        executeAndAssert("01:01:01AM", "01:01:01");
        executeAndAssert("11:55:55AM", "11:55:55");
    }

    @Test
    public void shouldConvertNoonTo24HourFormat() {
        executeAndAssert("12:00:00PM", "12:00:00");
    }

    @Test
    public void shouldConvertTimeInPMTo24HourFormat() {
        executeAndAssert("01:01:01PM", "13:01:01");
        executeAndAssert("11:55:55PM", "23:55:55");
    }

    private void executeAndAssert(final String input, final String expected) {
        assertThat(timeConversion(input), equalTo(expected));
    }
}
