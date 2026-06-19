package com.saravanjs.java24.console.codex;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * @author Sarav on 19 Jun 2026
 * @project govtech
 * @package com.saravanjs.java24.console.codex
 * @class Coderbyte
 */




public class Coderbyte {

    public static List<Post> fetchPosts() {
        String json = fetchJson("http://coderbyte.com/api/challenges/json/all-posts");
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Post>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }

    public static List<Comment> fetchComments() {
        String json = fetchJson("http://coderbyte.com/api/challenges/json/all-comments");
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Comment>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }

    // Improved fetch method
    private static String fetchJson(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("HTTP error: " + conn.getResponseCode());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line.trim());   // trim to remove any extra whitespace/newlines
            }
            in.close();
            conn.disconnect();

            String json = response.toString().trim();

            // Fix common issue: remove outer quotes if API wraps the JSON in string
            if (json.startsWith("\"") && json.endsWith("\"")) {
                json = json.substring(1, json.length() - 1)
                        .replace("\\\"", "\"")
                        .replace("\\\\", "\\");
            }

            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
    }

    public static List<Map<String, Integer>> aggregateComments(List<Post> posts, List<Comment> comments) {
        Map<Integer, Integer> commentCount = new HashMap<>();
        for (Comment c : comments) {
            commentCount.put(c.postId, commentCount.getOrDefault(c.postId, 0) + 1);
        }

        List<Map<String, Integer>> result = new ArrayList<>();
        for (Post p : posts) {
            Map<String, Integer> map = new LinkedHashMap<>(); // preserve insertion order
            map.put("postId", p.id);
            map.put("numberOfComments", commentCount.getOrDefault(p.id, 0));
            result.add(map);
        }

        // Sort: numberOfComments DESC, then postId DESC
        result.sort((a, b) -> {
            int countCompare = Integer.compare(
                    b.get("numberOfComments"),
                    a.get("numberOfComments")
            );
            if (countCompare != 0) return countCompare;
            return Integer.compare(b.get("postId"), a.get("postId"));
        });

        return result;
    }

    public static void aggregateComments() {
        List<Post> posts = fetchPosts();
        List<Comment> comments = fetchComments();
        List<Map<String, Integer>> aggregated = aggregateComments(posts, comments);
        System.out.println(aggregated);
    }

    public static void main(String[] args) {

        // Alternative way as per your structure
        List<Post> posts = fetchPosts();
        List<Comment> comments = fetchComments();
        List<Map<String, Integer>> aggregatedComments = aggregateComments(posts, comments);
        System.out.println(aggregatedComments);
    }

    // Model classes
    static class Post {
        int userId;
        int id;
        String title;
        String body;
        String created_at;
    }

    static class Comment {
        int postId;
        int id;
        String name;
        String email;
        String body;
    }
}