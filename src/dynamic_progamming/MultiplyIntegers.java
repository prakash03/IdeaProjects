package dynamic_progamming;

public class MultiplyIntegers {

    /*
    CtCI Book - Dynamic Programming - Problem - 8.4

    Write a recursive function to multiply 2 given integers without using the * operator
    U can still use addition, substractio, bit manipulation
     */

    static int multiply(int x, int y){
        int min = (x > y) ? y : x;
        int max = (x > y) ? x: y;

        int[] memo = new int[min+1];
        return multiplyMinMax(min, max, memo);
    }

    static int multiplyMinMax(int min, int max, int[] memo){
        //find min of x, y and diving i
        if(min == 1) return max;
        if(min == 0) return 0;

        if(memo[min] == 0){
            if(min % 2 == 0){
                memo[min] = multiplyMinMax(min/2, max, memo) + multiplyMinMax(min/2, max, memo);
            }
            else{
                int mid = min/2;
                memo[min] = multiplyMinMax(mid, max, memo) + multiplyMinMax(min-mid, max, memo);
            }
        }

        return memo[min];
    }

    public static void main(String[] args){
        int x = 10;
        int y = 9;

        System.out.println(multiply(x, y));
    }
}
