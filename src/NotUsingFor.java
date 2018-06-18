public class NotUsingFor {
//The Challenge is to be able to printout the name 'Prakash' many times without using any loops.

    public static void call(int value){ //Using Recursion
        String name = "Prakash";
        value = value -1;
        if( value >= 0) {
            System.out.println("Prakash");
            call(value);
        }
    }

    //This function is created to be able to print numbers from 1 to the given range without using any loops.
    public static void numberCall(int value){
//        int i = 1;
//        if( i <= value){
//            System.out.println(i);
//            i+=1;
//            numberCall(i);
//        }
          if(value>=1){
              System.out.println(value);
              value = value -1;
              numberCall(value);
          }
    }

    public static void main(String[] args) {
        String n = " Prakash ";
        String n3 = n + n + n; //
        String n10 = n3 + n3 + n3 + n;
        String n30 = n10 + n10 + n10;
        //System.out.println(n10);
        //call(10);
        numberCall(10);

    }
}
