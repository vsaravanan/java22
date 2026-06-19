package com.saravanjs.java24.console.codex;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class PostCommentAggregation {

    private static final String POSTS_URL =
        "https://coderbyte.com/api/challenges/json/all-posts";

    private static final String COMMENTS_URL =
        "https://coderbyte.com/api/challenges/json/all-comments";

    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    record Post(int userId, int id) {}

    record Comment(int postId, int id) {}

    public static List<Post> fetchPosts() {
        return fetchList(POSTS_URL, Post[].class);
    }

    public static List<Comment> fetchComments() {
        return fetchList(COMMENTS_URL, Comment[].class);
    }

    private static <T> List<T> fetchList(
            String url,
            Class<T[]> responseType
    ) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = HTTP_CLIENT.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() != 200) {
                throw new IllegalStateException(
                        "GET " + url + " returned HTTP " + response.statusCode()
                );
            }

            T[] data = GSON.fromJson(response.body(), responseType);
            return Arrays.asList(data);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Request interrupted", e);
        } catch (IOException e) {
            throw new RuntimeException("Unable to fetch " + url, e);
        }
    }

    public static List<Map<String, Integer>> aggregateComments(
        List<Post> posts,
        List<Comment> comments
    ) {
        Map<Integer, Integer> commentCount = new HashMap<>();

        for (Comment c : comments) {
            commentCount.put(c.postId, commentCount.getOrDefault(c.postId, 0) + 1);
        }


        List<Map<String, Integer>> result = new ArrayList<>();
        for (Post p : posts) {
            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("postId", p.id);
            map.put("numberOfComments", commentCount.getOrDefault(p.id, 0));
            result.add(map);
        }

        result.sort(
                Comparator.comparingInt((Map<String, Integer> m) -> m.get("numberOfComments"))
                        .reversed()
                        .thenComparing(
                                Comparator.comparingInt((Map<String, Integer> m) -> m.get("postId"))
                                        .reversed()
                        )
        );

        return result;

    }

    public static void main(String[] args) {
        List<Post> posts = fetchPosts();
        List<Comment> comments = fetchComments();

        List<Map<String, Integer>> aggregatedComments =
            aggregateComments(posts, comments);

        System.out.println(aggregatedComments);
    }
}


