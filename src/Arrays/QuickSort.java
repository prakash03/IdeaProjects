package Arrays;

import java.util.Arrays;

public class QuickSort {

    int[] swap(int i, int j){
        int[] newArray = new int[2];
        int temp = j;
        j = i;
        i = temp;
        newArray[0] = i;
        newArray[1] = j;
        return newArray;
    }

    static int partition(int[] array, int low, int high){
        int i= low-1;
        int pivot = array[high];
        System.out.println("Pivot is : " + pivot);
        for(int j=low; j<high; j++){
            if(array[j]<=pivot){
                i++;
                System.out.println("Swapping : "+ array[i] + " " + array[j]);
                int temp = array[i];
                array[i] = array[j];
                array[j] = array[i];
                System.out.println(Arrays.toString(array));
            }
        }

        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }

    static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }

    static void quickSort(int[] array, int low, int high){
        if(low < high){
            int pi = partition(array, low, high);

            quickSort(array, low, pi-1);
            quickSort(array, pi+1,high);

        }
    }

    public static void main(String[] args){
        int[] array = {2,5,7,3,1,8,3,0,21};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
