package com.vijay.study.easy.implementation;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class KangarooUmpsTest {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        final Circus circus = new Circus(x1, v1, x2, v2).init();
        return makeKangaroosJumpAndCheckIfTheyMeet(circus.getFaster(), circus.getSlower());
    }

    private static String makeKangaroosJumpAndCheckIfTheyMeet(final Kangaroo faster, final Kangaroo slower) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            faster.jump();
            slower.jump();
            if(faster.distanceCovered() == slower.distanceCovered()) {
                return "YES";
            }
            if(faster.distanceCovered() > slower.distanceCovered()) {
                return "NO";
            }
        }
        return "NO";
    }

    private static class Kangaroo {
        int startingPoint;
        int jumpDist;
        int jumpCount;

        Kangaroo(final int startingPoint, final int jumpDist) {
            this.startingPoint = startingPoint;
            this.jumpDist = jumpDist;
        }

        int distanceCovered() {
            return startingPoint + jumpDist * jumpCount;
        }

        void jump() {
            jumpCount++;
        }
    }

    @Test
    public void kangaroosShouldMeetWhenBothStartTogetherAndHaveTheSameSpeed() {
        assertThat(kangaroo(0, 1, 0, 1), equalTo("YES"));
    }

    @Test
    public void shouldNotMeetWhenFirstKangarooIsFasterAndStartTogether() {
        assertThat(kangaroo(0, 2, 0, 1), equalTo("NO"));
    }

    @Test
    public void shouldNotMeetWhenSecondKangarooIsFasterAndStartTogether() {
        assertThat(kangaroo(0, 1, 0, 2), equalTo("NO"));
    }

    @Test
    public void shouldMeetWhenFirstIsFasterAndStartsBehindSecondWithSingleJump() {
        assertThat(kangaroo(0, 2, 1, 1), equalTo("YES"));
    }

    @Test
    public void shouldMeetWhenSecondIsFasterAndStartsBehindFirstWithSingleJump() {
        assertThat(kangaroo(1, 1, 0, 2), equalTo("YES"));
    }

    @Test
    public void shouldMeetWhenFasterKangarooCatchesUpInMultipleJumps() {
        assertThat(kangaroo(0, 2, 2, 1), equalTo("YES"));
        assertThat(kangaroo(2, 1, 0, 2), equalTo("YES"));
    }

    @Test
    public void shouldNotMeetWhenFasterOVertakesSlowerWithoutConverging() {
        assertThat(kangaroo(0, 4, 3, 2), equalTo("NO"));
    }

    @Test
    public void testHRInputs() {
        assertThat(kangaroo(0, 3, 4, 2), equalTo("YES"));
        assertThat(kangaroo(0, 2, 5, 3), equalTo("NO"));
    }

    private static class Circus {
        private final int x1;
        private final int v1;
        private final int x2;
        private final int v2;
        private Kangaroo faster;
        private Kangaroo slower;

        public Circus(final int x1, final int v1, final int x2, final int v2) {
            this.x1 = x1;
            this.v1 = v1;
            this.x2 = x2;
            this.v2 = v2;
        }

        public Kangaroo getFaster() {
            return faster;
        }

        public Kangaroo getSlower() {
            return slower;
        }

        public Circus init() {
            if(v1 > v2) {
                faster = new Kangaroo(x1, v1);
                slower = new Kangaroo(x2, v2);
            } else {
                faster = new Kangaroo(x2, v2);
                slower = new Kangaroo(x1, v1);
            }
            return this;
        }
    }
}
