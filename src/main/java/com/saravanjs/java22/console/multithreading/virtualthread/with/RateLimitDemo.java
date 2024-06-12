package com.saravanjs.java22.console.multithreading.virtualthread.with;

/**
 * @author Sarav on 13 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.multithreading.virtualthread.with
 * @class RateLimitDemo
 */
import java.util.*;
import java.util.concurrent.*;
import java.net.*;
import java.net.http.*;

public class RateLimitDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        List<Future<String>> futures = new ArrayList<>();
        final int TASKS = 250;
        for (int i = 1; i <= TASKS; i++)
            futures.add(service.submit(() -> get("https://horstmann.com/random/word")));
        for (Future<String> f : futures)
            System.out.print(f.get() + " ");
        System.out.println();
        service.close();
    }

    private static HttpClient client = HttpClient.newHttpClient();

    private static final Semaphore SEMAPHORE = new Semaphore(20);

    public static String get(String url) {
        try {
            var request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
            SEMAPHORE.acquire();
            try {
                Thread.sleep(100);
                return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            } finally {
                SEMAPHORE.release();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            var rex = new RuntimeException();
            rex.initCause(ex);
            throw rex;
        }
    }
}

