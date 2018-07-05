package InterviewPractice;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 31;
        System.out.println("Binary format of " + decimal + " is: ");
        String binary = "";
        while(decimal!=0){
            binary = Integer.toString(decimal%2) + binary; //Important since the Binary Digits are added to the front of String.
            decimal /= 2;
        }
        System.out.println(binary);
        System.out.println(Integer.valueOf(binary));


    }
}
