package com.vijay.study.easy.implementation;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SaveThePrisonerTest {

    static int saveThePrisoner(int prisonersCount, int sweetsCount, int distributionStart) {
        int prisoner = (distributionStart + sweetsCount - 1) % prisonersCount;
        return prisoner == 0 ? prisonersCount : prisoner;
    }

    @Test
    public void shouldGiveBadSweetToPrisonersWhenForOneSweetDistributedFromStart() {
        executeAndAssert(2, 1, 1, 1);
    }

    @Test
    public void shouldGiveBadSweetToPrisonersWhenForOneSweetDistributedFromSecond() {
        executeAndAssert(2, 1, 2, 2);
    }

    @Test
    public void shouldGiveBadSweetToPrisonerWhenSweetsEqualToPrisonerCount() {
        executeAndAssert(2, 2, 1, 2);
    }

    @Test
    public void shouldGiveBadSweetToPrisonerWhenSweetsCountLessThanToPrisonerCount() {
        executeAndAssert(3, 2, 1, 2);
        executeAndAssert(3, 2, 2, 3);
    }

    @Test
    public void shouldGiveBadSweetToPrisonerWhenCountIsGreaterThanPrisonersCount() {
//        executeAndAssert(1, 2, 1, 1);
//        executeAndAssert(2, 3, 1, 1);
//        executeAndAssert(2, 3, 2, 2);
//        executeAndAssert(2, 4, 1, 2);
        executeAndAssert(2, 4, 2, 1);
    }


    @Test
    public void testHrInput() {
        executeAndAssert(7, 19, 2, 6);
        executeAndAssert(3, 7, 3, 3);
    }


    private void executeAndAssert(final int prisonersCount, final int sweetsCount, final int distributionStart, final int expectedPrisoner) {
        assertThat(saveThePrisoner(prisonersCount, sweetsCount, distributionStart), equalTo(expectedPrisoner));
    }
}
