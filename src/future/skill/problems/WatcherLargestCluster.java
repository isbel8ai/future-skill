package future.skill.problems;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WatcherLargestCluster {

    /**
     * Given a list of integers as input, return the most common integer in
     * this list.
     */
    public static int level1MostCommonNumber(List<Integer> intList) {
        // Write your code here

        return intList.stream()
                .collect(Collectors.groupingBy(n -> n))
                .entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .map(Map.Entry::getKey).orElse(0);
    }

    /**
     * Given a list of integers as input, find the largest cluster of
     * consecutive numbers which are the same.
     * For example, suppose you are given the following list of integers:
     * [3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 2, 2, 1, 1, 1, 1, 1]
     * You should return the index of the start of the largest cluster of
     * consecutive numbers which are the same, in this case 4 (this is the
     * start index for the seven 5s which are in a row).
     */
    public int level2LargestCluster(List<Integer> intList) {
        // Write your code here
        int bestClusterPos = intList.get(0);
        int bestCount = 1;
        int currentClusterPos = bestClusterPos;
        int currentCount = 1;

        for (int i = 1; i < intList.size(); ++i) {
            int num = intList.get(i);

            if (num == intList.get(currentClusterPos)) {
                currentCount++;
                continue;
            }
            if (currentCount > bestCount) {
                bestClusterPos = currentClusterPos;
                bestCount = currentCount;
            }
            currentClusterPos = i;
            currentCount = 1;
        }

        return bestClusterPos;
    }
}
