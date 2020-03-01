package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.*;

public class RottenOranges {

    /**
     * Leetcode problem: https://leetcode.com/problems/rotting-oranges/
     *
     */

    /**
     * Input:
     *
     * any_change : false
     *
     * copy
     * [[2,2,2],
     *  [2,2,0],
     *  [0,2,2]]
     *
     * [[2,2,2],
     *  [2,2,0],
     *  [0,2,2]]
     *
     * change_made: true
     * minutes_elapsed = 0
     *
     * while(change_made)
     *      for elements in matrix:
     *           look for a rotten orange and update a fresh orange:
     *              if(fresh_turns_rotten):
     *                  change_made: true
     *                  minutes_elapsed += 1
     *
     * [[2,2,2],
     *  [0,2,2],
     *  [1,0,2]]
     *
     *  BFS Approach:
     *      for each orange add the others into queue,
     *          increase time
     *          if queue is
     *
     */

//    static Map<Boolean, Integer[][]> update_all_directions(int[][] current_grid, int i, int j){
//
//    }
//
//    public static int orangesRotting(int[][] grid) {
//
//        boolean oranges_rotten = true;
//        int minutes_elapsed = 0;
//
//        int[][] current_grid = grid;
//
//        while(oranges_rotten){
//            int[][] temp_grid = current_grid;
//            for(int i = 0; i < grid.length; i++){
//                for(int j = 0 ; j < grid[0].length; j++){
//                    if(current_grid[i][j] == 2){
////                        int updated_matrix = update_all_directions(current_grid, i, j);
//                        Map<Boolean, Integer[][]> result = update_all_directions(current_grid, i, j);
//                        oranges_rotten = result.keySet().
//                    }
//                }
//            }
//        }
//    }

    private static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});   // add rotten oranges to queue in the first level
                }
                if (grid[i][j] == 1) {
                    freshOranges++;    // count of fresh oranges. this is useful for us (in the end) to check if all the fresh oranges have rotten or not and return the value accordingly
                }
            }
        }

        int days = 0;   // this is basically number of levels in BFS / level order traversal
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // all the possible adjacent directions of a grid value
        while (!queue.isEmpty() && freshOranges > 0) {    // continue the BFS till there are no more valid fresh oranges that can rotten
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] node = queue.poll();
                for (int[] dir : directions) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];

                    if (x < 0 || y < 0 || x >= rows || y >= columns || grid[x][y] == 0 || grid[x][y] == 2) {   // exceeded the boundary or the grid value is not a fresh orange, in that case just continue the loop
                        continue;
                    }
                    grid[x][y] = 2;    // mark the orange from fresh -> rotten
                    queue.offer(new int[]{x, y});  // add the rotten orange to queue
                    freshOranges--;
                }
            }
            days++;   // increment the level
        }
        return freshOranges == 0 ? days : -1;  // fact that there are no fresh oranges in the grid means all the fresh oranges in the grid have been rotten
    }

    public static void main(String[] args){
        int[] row1 = new int[] {2,1,1};
        int[] row2 = new int[] {1,1,0};
        int[] row3 = new int[] {0,1,1};

        int[][] input_matrix = new int[][] {row1, row2, row3};
        System.out.println(orangesRotting(input_matrix));
    }
}
