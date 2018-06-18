public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        int i= 0;
        for (int j=0; j<y; j++){
            i= 0;
            int current = matrix[i][j];
            int k= j;
            while(i<x && k<y){
                int found = matrix[i][k];
                //System.out.println("Comparing" + current + " , " + found);
                if(current != found){
                    return false;
                }
                else{
                    i++;
                    k++;
                }
            }
            //System.out.println("i is "+ i + "j is " + j + "k is " + k);
        }
        int j= 0;
        for (i = 1; i<x ; i++){
            j = 0;
            int current = matrix[i][j];
            int k = i;
            while(k<x && j<y){
                int found = matrix[k][j];
                //System.out.println("Comparing" + current + " , " + found);
                if(current != found){
                    return false;
                }
                else{
                    k++;
                    j++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{4,1,2,3}};
        boolean answer = isToeplitzMatrix(matrix);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(answer);

    }
}
