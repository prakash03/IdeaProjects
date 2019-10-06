package string;

public class StringClass {

    static void reverseString(String s_1, String s_2){
        String concat_string = s_1.concat(s_2);
        int length = concat_string.length();
        for(int i=length-1;i>=0;i--){
            System.out.print(concat_string.charAt(i));
        }
        System.out.println(" ");

    }

    public static void main(String[] args) {
        String s_1 = "Prakash is feeling sleepy";
        String s_2 = "He doesn't have to go to work tomorrow.";
        String s_3 = "Prak ordered a new order in amazon orders";
        String s_4 = "prakash is feeling sleepy";


        System.out.println("String 1: "+ s_1);
        System.out.println("String 2: "+ s_2);

        System.out.println("Length of String 1 is: "+ s_1.length());
        System.out.println("Length of String 2 is: "+ s_2.length());

        System.out.println("Character at index 4 is: "+ s_1.charAt(4));
        System.out.println("Character at index 2 is: "+ s_2.charAt(2));

        System.out.println("Substring from 5: "+ s_1.substring(5));
        System.out.println("Substring from 4 to 8 is: "+ s_2.substring(4,9));

        System.out.println("The combined string would be: " + s_1.concat(s_2));

        System.out.println("Index of the first occurrence of 'order' is: "+ s_3.indexOf("order"));

        System.out.println("Comparing the 2 strings lexicographically: "+ s_1.compareTo(s_2));

        System.out.println("Are the 2 strings equal? "+ s_1.equals(s_2));

        System.out.println("Are 1 and 4 strings equal? "+ s_1.equalsIgnoreCase(s_4));

        System.out.println("PRAKASH".toLowerCase());
        System.out.println("fcking awesome".toUpperCase());
        System.out.println("   Lets remove the spaces at the ends, not in between  :".trim());
        System.out.println("Replaces all the characters as required:".replace('a','f'));


        reverseString(s_1,s_2);


    }
}
