package dynamic_progamming;

import java.util.*;

public class MinimumPathSum {
    /**
     *
     * Leetcode problem: https://leetcode.com/problems/minimum-path-sum/
     *
     */

    /*
    {1,3,1}
    {1,5,6}
    {4,2,1}

    Integer.Max_VALUE + 1 = Integer.Min_VALUE
     */
    static int minPathSum(int[][] grid, int x, int y, int[][] memo){
        // Base Cases
        if((x == grid.length && y == grid[0].length -1) || (x == grid.length-1 && y == grid[0].length)) return 0;
        if(x == grid.length || y == grid[0].length) return Integer.MAX_VALUE;



        // Recursion
        if(memo[x][y] == -1){
            memo[x][y] = grid[x][y] + Math.min(minPathSum(grid, x+1, y, memo), minPathSum(grid, x, y+1, memo));
        }

        return memo[x][y];
    }

    static int minPathSum(int[][] grid) {
        // base cases
        if(grid.length == 0) return 0;

        int[][] memo = new int[grid.length][grid[0].length];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }

        // check the element below and the element next to the first one
        return grid[0][0] + Math.min(minPathSum(grid, 0, 1, memo), minPathSum(grid, 1,0, memo));
    }

    public static void main(String[] args){
        int[] row1 = new int[] {1, 5, 2};
        int[] row2 = new int[] {1,5,6};
        int[] row3 = new int[] {4,2,1};
        int[] row4 = new int[] {2,7,1};

        int[][] matrix = new int[][] {row1, row2};

        System.out.println(minPathSum(matrix));
    }
}
