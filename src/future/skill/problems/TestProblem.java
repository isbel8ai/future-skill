package future.skill.problems;

public class TestProblem {
    /**
     * Return the day which you buy silver. The first day has number zero.
     * This method is called first, and only once.
     */
    public int getBuyDay() {
        // Write your code here
        return -2;
    }

    /**
     * Return the day to sell silver on. This day has to be after (greater
     * than) the buy day. The first day has number zero (although this is not
     * a valid sell day). This method is called second, and only once.
     */
    public int getSellDay() {
        // Write your code here
        return -2;
    }

    /** Return an array with two positions holing the best day to buy (position 0) and the best day to sell (position 1)
     * The algorithm analyzes by ranges where prices go from low to high, keeping the range with the bigger profit.
     * */

    private int[] getBestDays() {
        int buyDay = 0;
        int sellDay = 0;
        int tmpBuyDay = 0;
        int tmpSellDay = 0;

        for (int i = 1; i <= api.getNumDays(); ++i) {
            int price = i == api.getNumDays() ? 0 : api.getPriceOnDay(i);
            int tmpBuyPrice = api.getPriceOnDay(tmpBuyDay);
            int tmpSellPrice = api.getPriceOnDay(tmpSellDay);
            if (price > tmpSellPrice) {
                tmpSellDay = i;
            } else if (price < tmpBuyPrice) {
                int buyPrice = api.getPriceOnDay(buyDay);
                int sellPrice = api.getPriceOnDay(sellDay);
                if (tmpSellPrice - tmpBuyPrice > sellPrice - buyPrice) {
                    buyDay = tmpBuyDay;
                    sellDay = tmpSellDay;
                }
                tmpBuyDay = i;
                tmpSellDay = i;
            }
        }
        return new int[]{buyDay, sellDay};
}
