package com.saravanjs.java24.console.codex;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostCommentAggregation {

    private static final String POSTS_URL =
        "https://coderbyte.com/api/challenges/json/all-posts";

    private static final String COMMENTS_URL =
        "https://coderbyte.com/api/challenges/json/all-comments";

    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    private static final Pattern POST_PATTERN = Pattern.compile(
        "\\{\\s*\"userId\"\\s*:\\s*(\\d+)\\s*,"
            + "\\s*\"id\"\\s*:\\s*(\\d+)"
    );

    private static final Pattern COMMENT_PATTERN = Pattern.compile(
        "\\{\\s*\"postId\"\\s*:\\s*(\\d+)\\s*,"
            + "\\s*\"id\"\\s*:\\s*(\\d+)"
    );

    record Post(int userId, int id) {}

    record Comment(int postId, int id) {}

    public static List<Post> fetchPosts() {
        String json = get(POSTS_URL);
        List<Post> posts = new ArrayList<>();
        Matcher matcher = POST_PATTERN.matcher(json);

        while (matcher.find()) {
            posts.add(new Post(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2))
            ));
        }

        return posts;
    }

    public static List<Comment> fetchComments() {
        String json = get(COMMENTS_URL);
        List<Comment> comments = new ArrayList<>();
        Matcher matcher = COMMENT_PATTERN.matcher(json);

        while (matcher.find()) {
            comments.add(new Comment(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2))
            ));
        }

        return comments;
    }

    public static List<Map<String, Integer>> aggregateComments(
        List<Post> posts,
        List<Comment> comments
    ) {
        Map<Integer, Integer> commentCountByPost = new HashMap<>();

        comments.forEach(comment ->
            commentCountByPost.merge(comment.postId(), 1, Integer::sum)
        );

        return posts.stream()
            .map(post -> Map.entry(
                post.id(),
                commentCountByPost.getOrDefault(post.id(), 0)
            ))
            .sorted(
                Map.Entry.<Integer, Integer>comparingByValue()
                    .reversed()
                    .thenComparing(
                        Map.Entry.<Integer, Integer>comparingByKey().reversed()
                    )
            )
            .map(entry -> {
                Map<String, Integer> result = new LinkedHashMap<>();
                result.put("postId", entry.getKey());
                result.put("numberOfComments", entry.getValue());
                return result;
            })
            .toList();
    }

    private static String get(String url) {
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

            return response.body();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Request interrupted", exception);
        } catch (IOException exception) {
            throw new IllegalStateException(
                "Unable to fetch " + url,
                exception
            );
        }
    }

    public static void main(String[] args) {
        List<Post> posts = fetchPosts();
        List<Comment> comments = fetchComments();

        List<Map<String, Integer>> aggregatedComments =
            aggregateComments(posts, comments);

        System.out.println(aggregatedComments);
    }
}
