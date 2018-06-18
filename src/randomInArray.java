import java.util.*;
public class randomInArray {
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        int num = (int) (Math.random()*array.length);


        int[] newArray = Arrays.copyOfRange(array, 1,5);
        System.out.println("Number is: " + array[num]);
        System.out.println(Arrays.toString(newArray));
    }
}
