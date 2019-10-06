package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReverseVowelsInString {
    // Leetcode problem number 345 - Reverse vowels of a String

    // Time out on the below solution! Implement a faster solution.

    // Test Cases: 'leetcode', 'aebdou', 'aroju', 'bergh',



    //Accepted solution!!
    static String optimalReverseVowels(String s){
        Character[] vowels = new Character[] {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList(vowels));

        char[] charArray = s.toCharArray();

        for(int i = 0, j = s.length()-1; i <= j; i++){
            if(vowelsSet.contains(charArray[i])){
                   while(!vowelsSet.contains(charArray[j])){
                       j--;
                   }
                   char temp = charArray[j];
                   charArray[j] = charArray[i];
                   charArray[i] = temp;
                   j--;
            }
        }

        return new String(charArray);
    }

    static String newReverseVowels(String s) {
        Character[] vowels = new Character[] {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList(vowels));
        Stack<Character> vowelsInString = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(vowelsSet.contains(s.charAt(i))){
                vowelsInString.push(s.charAt(i));
            }
        }

        String result = "";

        for(int i = 0; i < s.length(); i++){
            if(vowelsSet.contains(s.charAt(i))){
                result += vowelsInString.pop();
            }
            else result += s.charAt(i);
        }

        return result;
    }

    static String reverseVowels(String s) {

        Character[] vowels = new Character[] {'a', 'e', 'i', 'o', 'u'};
//        Set<Character> vowelSet = new HashSet<>(Arrays.asList(vowels));

        Stack<Character> vowelsInString = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(Arrays.asList(vowels).contains(s.charAt(i))) {
                System.out.println(s.charAt(i));
                vowelsInString.push(s.charAt(i));
            }
        }

        String result = "";

        for(int i=0; i < s.length(); i++) {
            if(Arrays.asList(vowels).contains(s.charAt(i))) {
                result += vowelsInString.pop();
            }
            else result += s.charAt(i);
        }

        return result;

    }

    public static void main(String[] args) {
        String leetcode = "leetcode";
        System.out.println(reverseVowels(leetcode));

        System.out.println(newReverseVowels(leetcode));

        String aroju = "bergh";
        System.out.println(optimalReverseVowels(aroju));
    }
}
