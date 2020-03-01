package Arrays.Practice;

import java.util.*;

public class MatrixSpiralCopy {

    /**
     * Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy that copies inputMatrix’s values into a 1D array in a spiral order, clockwise.
     * Your function then should return that array. Analyze the time and space complexities of your solution.
     *
     * Example:
     *
     * Input:
     * inputMatrix  = [ [1,    2,   3,  4,    5],
     *                  [6,    7,   8,  9,   10],
     *                  [11,  12,  13,  14,  15],
     *                  [16,  17,  18,  19,  20] ]
     *
     *
     * output:
     * [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
     */

    /*
    easier with a smaller input?

    input = [[1, 2, 4],
             [5, 6, 7],
             [2, 0, 11]]


    input_2 = [[1,3]]

     */

    static int[] spiralCopy(int[][] inputMatrix){
        int[] output = new int[inputMatrix.length * inputMatrix[0].length ];

        int start_row = 0;
        int end_row = inputMatrix.length - 1; // 0

        int start_column = 0;
        int end_column = inputMatrix[0].length - 1 ; // 1

        int index = 0;

        while(start_row <= end_row && start_column <= end_column){
            for(int i = start_column; i <= end_column; i++){
                output[index] = inputMatrix[start_row][i];
                index++;
            }
            start_row++;

            for(int i = start_row; i<= end_row ; i++){
                output[index] = inputMatrix[i][end_column];
                index++;
            }
            end_column--;

            if(start_row <= end_row){
                for(int i=end_column; i >= start_column; i--){
                    output[index] = inputMatrix[end_row][i];
                    index++;
                }
                end_row--;
            }

            if(start_column <= end_column){
                for(int i = end_row; i >= start_row; i--){
                    output[index] = inputMatrix[i][start_column];
                    index++;
                }
                start_column++;
            }
        }


//        while(start_row <= end_row && start_column <= end_column){
////            System.out.println(Arrays.toString(output));
//
//            while(current_column <= end_column){
//                output[index] = inputMatrix[current_row][current_column];
//                current_column += 1;
//                index += 1;
//            }
//            start_row += 1; //2
//            current_row = start_row; //2
//            current_column -= 1; //3
//
//
//            while(current_row <= end_row){
//                output[index] = inputMatrix[current_row][current_column];
//                current_row += 1;
//                index += 1;
//            }
//            end_column -= 1; //2
//            current_column = end_column; //2
//            current_row -= 1; //2
//
//            //20
//
//            while(current_column >= start_column && start_row <= end_row){
//                output[index] = inputMatrix[current_row][current_column];
//                current_column -= 1;
//                index += 1;
//            }
//            end_row -= 1; //2
//            current_row = end_row; //2
//            current_column += 1; //0
//
//            //16
//
//            while(current_row >= start_row && start_column <= end_column){
//                output[index] = inputMatrix[current_row][current_column];
//                current_row -= 1;
//                index += 1;
//            }
//            start_column += 1; //1
//            current_column = start_column;  //1
//            current_row += 1;  //1
//        }

        return output;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
        };

        System.out.println(spiralCopy(input).length);
        System.out.println(Arrays.toString(spiralCopy(input)));

        int[][] input_2 = new int[][]{
                {1, 2, 4}
//                {5, 6, 7},
//                {2, 0, 11}
        };
        System.out.println(Arrays.toString(spiralCopy(input_2)));

        int[][] input_3 = new int[][]{
                {1},{2},{3}
        };

        System.out.println(Arrays.toString(spiralCopy(input_3)));
    }
}
