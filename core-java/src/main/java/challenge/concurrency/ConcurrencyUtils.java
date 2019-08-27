package challenge.concurrency;

public class ConcurrencyUtils {

    public static final void sleepEasy(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
