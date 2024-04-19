package future.skill;

import future.skill.problems.ChristmasSpecialGears;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> result = new ChristmasSpecialGears().gearOrder(List.of(5, 3), List.of(1, 2, 4), 2);

        System.out.println(result);
    }
}
