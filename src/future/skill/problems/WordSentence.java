package future.skill.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordSentence {
    /**
     * Take a sentence as input and count the number of words and return it
     * as an int.
     */
    public int level1WordCount(String sentence) {
        // Write your code here
        return (int) Arrays.stream(sentence.split("\\W")).filter(w -> w.matches("[a-z]+")).count();
    }

    /**
     * Take a sentence as input and return a list of the words in the
     * sentence, sorted alphabetically in lowercase and without punctuation
     * (,.!?). If there are multiple occurrences of the same word, include it
     * multiple times.
     */
    public List<String> level2WordSorting(String sentence) {
        // Write your code here
        return Arrays.stream(sentence.split("\\W"))
                .filter(w -> w.matches("\\w+"))
                .map(String::toLowerCase)
                .sorted().collect(Collectors.toList());
    }

    /**
     * Take a sentence as input and sort the words in it by the number of
     * times they appear in the sentence. In the case of a tie, the words
     * should be sorted alphabetically.
     */
    public List<String> level3SortByOccurrences(String sentence) {
        // Write your code here
        return Arrays.stream(sentence.split("\\W"))
                .filter(w -> w.matches("\\w+"))
                .map(String::toLowerCase).sorted()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting())).entrySet().stream()
                .sorted((a, b) -> 1000 * Long.compare(b.getValue(), a.getValue()) + a.getKey().compareTo(b.getKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
