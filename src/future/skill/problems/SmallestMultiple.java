package future.skill.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SmallestMultiple {
    /**
     * Given a list of integers, find the smallest integer which is evenly
     * divisible by all of them. X is evenly divisible by Y if X/Y gives an
     * integer answer, or in other words, there is no remainder. For example,
     * 21 is evenly divisible by 3 but not by 4 (in this case the result is
     * 5.25, and the remainder is 1).
     */
    public static int level1SmallestMultiple(List<Integer> intList) {
        // Write your code here

        Map<Integer, Integer> divisorsMap = new HashMap<>();

        for (Integer num : intList) {
            int divisor = 2;
            int count = 0;
            while (divisor <= num || count > 0) {
                if (num > 0 && num % divisor == 0) {
                    num /= divisor;
                    count++;
                    continue;
                }

                if (count > 0) {
                    int maxCount = divisorsMap.getOrDefault(divisor, 0);
                    divisorsMap.put(divisor, Integer.max(count, maxCount));
                    count = 0;
                }

                divisor++;
            }
        }

        return (divisorsMap.entrySet().stream()
                .map(e -> (int) Math.pow(e.getKey(), e.getValue())))
                .reduce(1, (a, n) -> a * n);
    }

    /**
     * Given a list of integers, find the smallest number which is evenly
     * divisible by all of them. X is evenly divisible by Y if X/Y gives an
     * integer answer, or in other words, there is no remainder. For example,
     * 21 is evenly divisible by 3 but not by 4 (in this case the result is
     * 5.25, and the remainder is 1).
     * Since we use larger numbers in Level 2 the answer should be returned
     * as a double (the number can be a lot bigger than ~2.000.000.000 which
     * is the max integer in many languages).
     */
    public double level2SmallestMultiple(List<Integer> intList) {
        // Write your code here

        Map<Integer, Integer> divisorsMap = new HashMap<>();

        for (Integer num : intList) {
            int divisor = 2;
            int count = 0;
            while (divisor <= num || count > 0) {
                if (num > 0 && num % divisor == 0) {
                    num /= divisor;
                    count++;
                    continue;
                }

                if (count > 0) {
                    int maxCount = divisorsMap.getOrDefault(divisor, 0);
                    divisorsMap.put(divisor, Integer.max(count, maxCount));
                    count = 0;
                }

                divisor++;
            }
        }

        return (divisorsMap.entrySet().stream()
                .map(e -> Math.pow(e.getKey(), e.getValue())))
                .reduce(1.0, (a, n) -> a * n);
    }
}
