package com.saravanjs.java22.console.multithreading.virtualthread.with;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Sarav on 13 Jun 2024
 * @project govtech
 * @package com.saravanjs.java22.console.multithreading.virtualthread.with
 * @class VirtualThreadDemo3
 */

public class VirtualThreadDemo3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        List<Callable<String>> callables = new ArrayList<>();
        final int ADJECTIVES = 4;
        for (int i = 1; i <= ADJECTIVES; i++)
            callables.add(() -> get("https://horstmann.com/random/adjective"));
        callables.add(() -> get("https://horstmann.com/random/noun"));
        List<String> results = new ArrayList<>();
        for (Future<String> f : service.invokeAll(callables))
            results.add(f.get());
        System.out.println(String.join(" ", results));
        service.close();
    }

    private static HttpClient client = HttpClient.newHttpClient();

    public static String get(String url) {
        try {
            var request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception ex) {
            var rex = new RuntimeException();
            rex.initCause(ex);
            throw rex;
        }
    }
}
