package InterviewPractice;

public class BinaryToDecimal {
    public static void main(String[] args) {
        String binary = "11111";
        int j = 0; //j is used to raise the power of 2.
        int decimal = 0;
        for(int i=binary.length()-1; i>=0; i--){
            decimal = decimal + (int) (Math.pow(2,j) * Integer.valueOf(""+binary.charAt(i))); //Convert char to String.
            j += 1;
        }
        System.out.println("Corresponding Decimal number is: " + decimal);
    }
}
