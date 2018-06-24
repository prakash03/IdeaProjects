package InterviewPractice;

import java.util.*;

public class RemoveVowels {

    static String removeVowels(String str){
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        String answer = "";
        for(int i=0; i<answer.length()-1; i++){
            if(vowels.contains(str.charAt(i))){
                continue;
            }
            else answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args){
        String sentence1 = "Going good! Reverse this sentence";
        String sentence2 = " ";
        System.out.println(removeVowels(sentence1));
    }
}
