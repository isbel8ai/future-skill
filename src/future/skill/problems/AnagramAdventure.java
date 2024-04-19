package future.skill.problems;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramAdventure {
    /**
     * Take two strings (string1 and string2) and determine if they are
     * anagrams of each other. Your program should ignore all non-letter
     * characters such as spaces and punctuation. Also, make the comparison
     * case-insensitive. Return a Boolean value - True if they are anagrams,
     * False otherwise.
     */
    public boolean level1AnagramCheck(String string1, String string2) {
        // Write your code here

        char[] chars1 = string1.toUpperCase().replace(" ", "").toCharArray();
        char[] chars2 = string2.toUpperCase().replace(" ", "").toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    /**
     * Take the input string 'origin' and a list of 'words' (strings), then
     * generate all possible anagrams using the given list of words. Return
     * these anagrams as a list of strings, sorted alphabetically (ignoring
     * case), with spaces between the words. The words in each generated
     * anagram must also be sorted alphabetically, ignoring case (so 'a I
     * the' is correct but not 'I a the'). Note that the words in the input
     * parameter 'words' are already sorted alphabetically.
     */
    public List<String> level2AnagramGeneration(String origin, List<String> words) {
        // Write your code here

        Map<Integer, Long> originMap = origin.replaceAll("\\W", "").toLowerCase().chars().boxed().
                collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        List<Map<Integer, Long>> wordMaps = words.stream().map(w ->
                w.toLowerCase().replaceAll("\\W", "").chars().boxed()
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
        ).collect(Collectors.toList());

        long length = originMap.values().stream().reduce(0L, Long::sum);

        List<String> solution = new ArrayList<>();
        for (int i = 0; i < words.size(); ++i) {
            generateSolution(words, wordMaps, originMap, length, i, "", solution);
        }

        return solution;
    }

    private void generateSolution(List<String> words, List<Map<Integer, Long>> wordMaps, Map<Integer, Long> remainMap,
                                  long length, int pos, String prefix, List<String> solution) {
        String currentWord = words.get(pos);
        Map<Integer, Long> currentWordMap = wordMaps.get(pos);
        Map<Integer, Long> nextMap = new HashMap<>(remainMap);
        long remainCount = length;
        for (Map.Entry<Integer, Long> entry : currentWordMap.entrySet()) {
            long count = remainMap.getOrDefault(entry.getKey(), 0L) - entry.getValue();
            if (count < 0) return;
            nextMap.put(entry.getKey(), count);
            remainCount -= entry.getValue();
        }

        if (remainCount == 0) {
            solution.add(prefix + currentWord);
            return;
        }

        for (int i = pos + 1; i < words.size(); ++i) {
            generateSolution(words, wordMaps, nextMap, remainCount, i, prefix + currentWord + " ", solution);
        }
    }
}
