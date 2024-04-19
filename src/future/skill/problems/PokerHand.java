package future.skill.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokerHand {
    /**
     * Given the input parameter 'hand' (a list of strings) check for flush
     * only - return true if the hand is a flush and false otherwise.
     * Each string in the list 'hand' represents a card. Each string is two
     * characters, first a char for the rank (10 is given as T, Jack as J,
     * Queen as Q, King as K and Ace as A) and a char for the suite (c for
     * clubs, d for diamond, h for hearts and s for spades).
     * For example, the Ace of diamonds is given as "Ad". The five cards are
     * sent as a 5-long list of such strings.
     */
    public boolean level1IsFlush(List<String> hand) {
        // Write your code here
        return hand.stream().map(s -> s.charAt(1)).distinct().count() == 1;
    }

    /**
     * Given the input parameter 'hand' (a list of strings) check for
     * straight only - return true if the hand is a straight and false
     * otherwise.
     * Each string in the list 'hand' represents a card. Each string is two
     * characters, first a char for the rank (10 is given as T, Jack as J,
     * Queen as Q, King as K and Ace as A) and a char for the suite (c for
     * clubs, d for diamond, h for hearts and s for spades).
     * For example, the Ace of diamonds is given as "Ad". The five cards are
     * sent as a 5-long list of such strings.
     */
    public boolean level2IsStraight(List<String> hand) {
        // Write your code here
        return hand.stream()
                .map(s -> {
                    char rank = s.charAt(0);
                    if (rank < 'A') {
                        return rank - 48;
                    }

                    switch (rank) {
                        case 'T':
                            return 10;
                        case 'J':
                            return 11;
                        case 'Q':
                            return 12;
                        case 'K':
                            return 13;
                        default:
                            return 0;
                    }
                })
                .filter(n -> n != 0)
                .sorted()
                .reduce((prev, curr) -> (prev == 0 || curr == prev + 1) ? curr : -1).orElse(-1) != -1;
    }

    /**
     * Given the input parameter 'hand' (a list of strings) check for Royal
     * straight flush only - return true if the hand is a Royal straight
     * flush and false otherwise.
     * Each string in the list 'hand' represents a card. Each string is two
     * characters, first a char for the rank (10 is given as T, Jack as J,
     * Queen as Q, King as K and Ace as A) and a char for the suite (c for
     * clubs, d for diamond, h for hearts and s for spades).
     * For example, the Ace of diamonds is given as "Ad". The five cards are
     * sent as a 5-long list of such strings.
     */
    public boolean level3IsRoyalStraightFlush(List<String> hand) {
        // Write your code here
        Set<Character> rankSet = new HashSet<>();
        char firstSuite = hand.get(0).charAt(1);
        for (String s : hand) {
            char suite = s.charAt(1);
            if (suite != firstSuite) return false;
            char rank = s.charAt(0);
            if (!List.of('T', 'J', 'Q', 'K', 'A').contains(rank)) return false;
            if (rankSet.contains(rank)) return false;
            rankSet.add(rank);
        }
        return true;
    }
}
