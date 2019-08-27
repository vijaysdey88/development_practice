package challenge.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static challenge.concurrency.ConcurrencyUtils.sleepEasy;

public class CompletableFuturePractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<String> yo = CompletableFuture.supplyAsync(() -> {
            sleepEasy(100);
            return "yo thread";
        }).thenApply(s -> s + " second thread" );

        System.out.println(yo.get());
        System.out.println("yo main!");
    }
}
