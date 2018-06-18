package Stacks;
import java.util.*;

public class ParenthesisCheck {
    private static int indexOf(char[] array, char chr){
        for(int i=0; i<array.length; i++){
            if(array[i] == chr)return i;
        }
        return -1;
    }
    public  static boolean isValid(String s) {
        char[] openings = {'{','[','('};
        char[] closings = {'}',']',')'};
        char[] givenString = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if(givenString.length %2 != 0) return false;
        for(int i = 0; i<givenString.length; i++){
            if(givenString[i] == '{' || givenString[i]== '(' || givenString[i] == '['){
                stack.push(givenString[i]);
            }
            else if(givenString[i] == '}' || givenString[i]== ')' || givenString[i] == ']'){
                if(stack.empty()) return false;
                if(indexOf(closings, givenString[i]) != indexOf(openings, stack.pop()) ){
                    return false;
                }
            }
        }
        if(stack.empty())return true;  //At the end Stack has to be empty.
        else return false;
    }

    public static void main(String[] args) {
        String s= "()";
        String s1 = "{[]()}";
        String s2 = "((";
        String s3 = "))";
        String s4 = "{}()[";
        System.out.println("String is : " + isValid(s));
        System.out.println("String is : " + isValid(s1));
        System.out.println("String is : " + isValid(s2));
        System.out.println("String is : " + isValid(s3));
        System.out.println("String is : " + isValid(s4));
    }
}
