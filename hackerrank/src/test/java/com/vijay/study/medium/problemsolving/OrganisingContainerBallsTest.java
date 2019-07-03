package com.vijay.study.medium.problemsolving;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static com.vijay.study.medium.problemsolving.OrganisingContainerBalls.organizingContainers;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class OrganisingContainerBallsTest {

   @Test
   public void shouldEvaluateToPossibleFor2By2Matrix(){
    int[][] input = {{1, 1},
                     {1, 1}};


       assertThat(organizingContainers(input), equalTo("Possible"));
   }

   @Test
   public void shouldEvaluateToImPossibleFor2By2Matrix(){
    int[][] input = {{0, 2},
                     {1, 1}};


       assertThat(organizingContainers(input), equalTo("Impossible"));
   }

   @Test
   public void shouldEvaluateToImPossibleFor3By3Matrix(){
    int[][] input = {{1,3,1},
                     {2, 1, 2},
                     {3, 3, 3}};


       assertThat(organizingContainers(input), equalTo("Impossible"));
   }

}