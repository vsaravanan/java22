package console.collection;

import java.util.*;

/**
 * @author Sarav on 11 Jun 2024
 * @project govtech
 * @package console.collection
 * @class LetterCombinations
 */


public class LetterCombinations {

    private static final Map<Character, String> mapping = new HashMap<>();

    static {
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
    }

    public String letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return "";
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        process(queue, digits, 0);

        result.addAll(queue);
        return  String.join(",", result);
    }

    private void process(Queue<String> queue, String digits, int index) {
        if (index == digits.length()) {
            return;
        }

        String letters = mapping.get(digits.charAt(index));
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            String combination = queue.poll();

            for (char letter : letters.toCharArray()) {
                queue.add(combination + letter);
                System.out.println(" queue " + queue + "Combination " + combination + " letters " + letters + " letter " + letter + " size " + size);
            }
        }

        process(queue, digits, index + 1);
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        String combinations = lc.letterCombinations("23");
        System.out.println(combinations);  // Output: ad, ae, af, bd, be, bf, cd, ce, cf
    }
}