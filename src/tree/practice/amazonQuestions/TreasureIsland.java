package tree.practice.amazonQuestions;

import java.util.*;

public class TreasureIsland {

    /**
     *
     * Amazon interview question: https://leetcode.com/discuss/interview-question/347457
     *
     * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs.
     * Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
     *
     * Assume the map area is a two dimensional grid, represented by a matrix of characters.
     * You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
     * The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner.
     * Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks.
     * You cannot leave the map area. Other areas O are safe to sail in.
     * The top-left corner is always safe. Output the minimum number of steps to get to the treasure.
     *
     */

    static int treaureIsland(char[][] input){

        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};


        queue.add(new int[]{0,0});
        queue.add(new int[]{-1, -1});
        int num_of_steps = 1;
        boolean found = false;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0] == -1 && current[1] == -1){
//                if(queue.peek()[0] == -1 && queue.peek()[1] == -1){
//                    System.out.println(Arrays.toString(queue.peek()));
//                    break;
//                }
                System.out.println(Arrays.toString(queue.peek()));
                num_of_steps += 1;
                queue.add(new int[]{-1, -1});
            }
            for(int[] direction : directions){
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];

                if(x < 0 || x == input.length || y < 0 || y == input.length || input[x][y] == 'D'){
                    continue;
                }

                if(input[x][y] == 'X') {
                    found = true;
                    return num_of_steps;
                }

                queue.add(new int[]{x, y});
            }

        }

        return found? num_of_steps : -1;
    }

    public static void main(String[] args){
        char[] row1 = new char[]{'O', 'O', 'O', 'D'};
        char[] row2 = new char[]{'D', 'O', 'D', '0'};
        char[] row3 = new char[]{'O', 'O', 'O', 'O'};
        char[] row4 = new char[]{'0', 'D', 'D', '0'};

        char[][] input = new char[][]{row1, row2, row3, row4};

        System.out.println(treaureIsland(input));

    }
}
