package InterviewPractice;

/*
Given a value N, if we want to make change for N cents and we have an infinite supply of coins.
How many ways can we make the change.

Refer: https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */

public class CoinChange {
    static int findWays(int[] coins, int length, int sum){

        if(sum == 0){
            return 1;
        }
        else if( sum < 0 ){
            return 0;
        }
        else if(length <= 0 && sum >= 1){
            return 0;
        }

        return findWays(coins, length-1, sum) + findWays(coins, length, sum - coins[length-1]);

    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 4;
        System.out.println(findWays(coins, coins.length, sum));
    }
}
