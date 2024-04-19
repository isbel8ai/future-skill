package future.skill.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsecutiveNumbers {

    /**
     * Takes a non-empty list of integers as input parameter ('int list') and
     * checks if it can be rearranged to form a consecutive sequence of
     * numbers. Return the sorted list if the list is consecutive, or an
     * empty list if it's not.
     */
    public List<Integer> level1ConsecutiveCheck(List<Integer> intList) {
        // Write your code here

        List<Integer> sorted = intList.stream().sorted().collect(Collectors.toList());

        int fist = sorted.get(0);

        for(int i = 1; i < sorted.size(); ++i) {
            if (sorted.get(i) != fist + i) {
                return Collections.emptyList();
            }
        }
        return sorted;
    }

    /**
     * Takes a non-empty list of integers as input parameter ('int list') and
     * returns all the integers missing to complete a list of consecutive
     * integers (as described in Level 1). The list should be sorted in
     * ascending order. If no integer is missing, return an empty list.
     */
    public List<Integer> level2MissingNumbers(List<Integer> intList) {
        // Write your code here

        List<Integer> sorted = intList.stream().sorted().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < sorted.size() - 1; ++i) {
            for (int j = sorted.get(i) + 1; j < sorted.get(i + 1); ++j) {
                result.add(j);
            }
        }

        return result;
    }
}
