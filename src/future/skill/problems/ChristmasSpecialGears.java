package future.skill.problems;

import java.util.ArrayList;
import java.util.List;

public class ChristmasSpecialGears {
    /**
     * Given all available gear radii on the ground, the peg distances and
     * the gear ratio to achieve, this method returns the placement of the
     * gears.
     */
    public List<Integer> gearOrder(List<Integer> pegDistances, List<Integer> gearRadii, int gearRatio) {
        // Write your code here
        int sum = 0;
        for (int i = 0; i < pegDistances.size(); ++i) {
            sum += pegDistances.get(i) * (i % 2 == 0 ? 1 :-1);
        }

        int previous = (int) (gearRatio * Math.abs(sum) / (gearRatio - Math.signum(sum)));

        List<Integer> result = new ArrayList<>();
        result.add(previous);

        for (Integer pegDistance : pegDistances) {
            previous = pegDistance - previous;
            result.add(previous);
        }

        return result;
    }
}
