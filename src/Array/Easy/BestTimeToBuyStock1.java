package Array.Easy;

public class BestTimeToBuyStock1 {

    public static int maxProfit(int[] prices){

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int n: prices){
            if(n < min) min = n;
            else if( n - min > profit) profit = n -  min;
        }

        return profit;
    }

    public static void main(String[] args){
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
