package data.structures.array;

public class BuySellStock {


    public static double getMaximumProfit(double prices[]) {
        double min = Double.MAX_VALUE;
        double max = 0;
        for(int i=0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }

            if(prices[i] - min > max) {
                max = prices[i] - min;
            }
        }

        return max;
    }

    public static double getWorstLoss(double prices[]) {
        double buy = Double.MIN_VALUE;
        double loss = 0;
        for(int i=0; i < prices.length; i++){
            if(buy < prices[i]){ // 12 < 9
                buy = prices[i]; // buy = 12
            }
            if(buy - prices[i] > loss) { // 12-9 > 3
                loss = buy - prices[i]; //  7 = 10 - 3
            }
        }
        return loss;
    }

    public static double getWorstLossPercentage(double prices[]) {
        double buy = Double.MIN_VALUE;
        double loss = 0;
        double lossPer = 0;
        for(int i=0; i < prices.length; i++){
            if(buy < prices[i]){ // 12 < 9
                buy = prices[i]; // buy = 12
            }
            if(buy - prices[i] > loss) { // 12-9 > 3
                loss = buy - prices[i]; //  7 = 10 - 3
            }
            double per = loss/buy * 100;
            if(per > lossPer) {
                lossPer = per;
            }
        }
        return lossPer;
    }

    public static void main(String[] args) {
        double prices[] = {10,3,6,4,7,10,12,9,8,10,7,6};
        System.out.println(getMaximumProfit(prices));
        System.out.println(getWorstLoss(prices));
        System.out.println(getWorstLossPercentage(prices));
    }

}
