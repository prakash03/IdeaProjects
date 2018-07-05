package InterviewPractice;
/*
Finding the minimum number of coins required to arrive at a given sum.
https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */
public class CoinChange2 {
    static int minumumRequired(int[] coins, int length, int sum){

        int[] tableForSum = new int[sum+1];

        tableForSum[0] = 0;

        for (int i=1;i<=sum;i++){
            tableForSum[i] = Integer.MAX_VALUE;
        }

        for(int i=1 ; i <= sum ; i++){
            for(int j=0 ; j < length ; j++){
                if(coins[j] <= i){
                    int sub_res = tableForSum[i - coins[j]];
                    if(sub_res != Integer.MAX_VALUE && sub_res+1 < tableForSum[i] ){
                        tableForSum[i] = sub_res +1;
                    }
                }
            }
        }

        return tableForSum[sum];
    }

    public static void main(String[] args) {
        int[] coins = {9,6,5,1};
        int m = coins.length;
        int sum = 13 ;
        System.out.println(minumumRequired(coins, coins.length, sum));
    }
}
