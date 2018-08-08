package com.vijay.study.easy;

import java.util.stream.IntStream;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

//https://www.hackerrank.com/challenges/grading/problem
public class GradingStudentsTest {

    @Test
    public void shouldNotRoudOffIfStudentIsFailing() {
        assertThat(gradAStudent(37), equalTo(37));
        assertThat(gradAStudent(1), equalTo(1));
    }

    @Test
    public void shouldRoundOffAStudentGrade() {
        assertThat(gradAStudent(39), equalTo(40));
        assertThat(gradAStudent(43), equalTo(45));
        assertThat(gradAStudent(44), equalTo(45));
    }

    @Test
    public void shouldNotRoundOffIfDiffGreaterThan3() {
        assertThat(gradAStudent(41), equalTo(41));
        assertThat(gradAStudent(42), equalTo(42));
    }

    @Test
    public void shouldGradeMultipleStudents() {
        assertThat(gradingStudents(new int[]{3, 40, 44}), equalTo(new int[]{3, 40, 45}));
    }

    static int[] gradingStudents(int[] grades) {
        return IntStream.of(grades)
                .map(i -> gradAStudent(i))
                .toArray();
    }

    private static int gradAStudent(final int studentGrade) {
        int computedGrade = studentGrade;
        if(computedGrade >= 38) {
            final int diffFromClosest5 = 5 - (computedGrade % 5);
            if(diffFromClosest5 < 3)
                computedGrade = studentGrade + diffFromClosest5;
        }
        return computedGrade;
    }
}
