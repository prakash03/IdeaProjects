package tree.practice.amazonQuestions;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int row = 0;
        int column = matrix[0].length -1;
        while(column >= 0 &&  row <= matrix.length -1){
            if(target == matrix[row][column])
                return true;
            if(target > matrix[row][column])
                row++;
            else
                column--;
        }
        return false;
    }
}
