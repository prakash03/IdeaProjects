package newTreePackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIdenticalBST {
    // The problem: Given 2 arrays containing keys of a BST, check if these arrays represent the same BST
    // without actually building the BST.
    // Example: https://www.techiedelight.com/check-given-keys-represents-same-bsts-not-without-building-bst/

    // Here we construct the tree starting taking the first element as the root.

    // Question: I am not sure how this approach is valid since the first element doesn't always have to be the root node of tree, take for example
    //           the case when we traverse tree inOrder.

    static boolean isSameBST(int[] x, int[] y){

        if(x.length != y.length) return false;

        return isSameBST( x, y, x.length);
    }

    private static boolean isSameBST(int[] x, int[] y, int n){

        if(n == 0) return true;

        if(x[0] != y[0]) return false;

        if(n == 1) return true;

        int[] x_mins = new int[n-1];  // This is an exciting approach where we just save elements to an array instead of a list and passover the size of array filled up instead of passing the actual size.
        int[] x_maxs = new int[n-1];
        int[] y_mins = new int[n-1];
        int[] y_maxs = new int[n-1];

        int k = 0, l = 0, m = 0, o = 0;

        for(int i = 1; i < n; i++){
            if(x[i] > x[0]){
                x_maxs[k++] = x[i];
            } else x_mins[l++] = x[i];

            if(y[i] > y[0]){
                y_maxs[m++] = y[i];
            } else y_mins[o++] = y[i];
        }

        if(k != m || l != o) return false;



        return isSameBST(x_mins, y_mins, l) &&
                isSameBST(x_maxs, y_maxs, k);
    }

    // Check if given keys represents same BSTs or not without
    // building the BST
    public static void main(String[] args)
    {
        int[] x = { 3, 5, 7, 6, 1, 0, 2 };
        int[] y = { 3, 1, 5, 2, 7, 6, 0 };

        if (isSameBST(x, y)) {
            System.out.println("Given keys represent same BSTs");
        }
        else {
            System.out.println("Given keys represent different BSTs");
        }

    }
}
