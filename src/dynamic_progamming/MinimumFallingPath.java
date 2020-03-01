package dynamic_progamming;

import java.util.*;

public class MinimumFallingPath {

    /**
     *
     * Leetcode problem: https://leetcode.com/problems/minimum-falling-path-sum/
     *
     */

    /*
    {1,3,1}
    {1,5,6}
    {4,2,1}

     */

    static int fallingPathSumFinder(int[][] input, int x, int y, int[][] memo){
        //base cases
        if(x == input.length) return 0;
        if(y < 0 || y == input[0].length) return Integer.MAX_VALUE;

        if(memo[x][y] == -101){
            memo[x][y] = input[x][y] + Math.min(fallingPathSumFinder(input, x+1, y-1, memo),
                                                Math.min(fallingPathSumFinder(input, x+1, y, memo), fallingPathSumFinder(input, x+1, y+1, memo)));
        }

        return memo[x][y];

    }

    static int fallingPathSumFinder(int[][] input, int start, int[][] memo){

        return input[0][start] + Math.min(fallingPathSumFinder(input, 1, start-1, memo),
                                          Math.min(fallingPathSumFinder(input, 1, start, memo),
                                          fallingPathSumFinder(input, 1, start+1, memo)));
    }

    static int minFallingPathSum(int[][] input){

        int[][] memo = new int[input.length][input[0].length];
        for(int[] arr : memo){ Arrays.fill(arr, -101); }

        int min_sum = Integer.MAX_VALUE;
        for(int i = 0; i < input[0].length; i++){
            int falling_path_sum = fallingPathSumFinder(input, i, memo);
            if(falling_path_sum < min_sum) { min_sum = falling_path_sum; }
        }

        return min_sum;
    }

    public static void main(String[] args){
        int[] row1 = new int[] {0,2,3};
        int[] row2 = new int[] {4,0,6};
        int[] row3 = new int[] {7,9,0};
        int[] row4 = new int[] {2,7,1};

        int[][] matrix = new int[][] {row1};
        System.out.println(minFallingPathSum(matrix));

    }
}
