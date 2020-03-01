package dynamic_progamming;

import java.util.*;


public class Permutations {

    static String insertInString(char character, String word, int index){

//        System.out.println("Word is: "+ word);
//        System.out.println("char is: " + character);
//        System.out.println("index is:" + index);

        String temp = "";
        for(int i = 0; i < word.length(); i++){
            if(i == index){
                temp += character;
                temp += word.charAt(i);
            }
            else temp += word.charAt(i);
        }

        if(index == word.length()) temp += character;

//        System.out.println("its returning: " + temp);
        return temp;
    }

    static List<String> findPermutation(String word){

        String temp = "" + word.charAt(0);
        List<String> combinationsAtTheLevel = new ArrayList<>();
        combinationsAtTheLevel.add(temp);

        for(int i = 1; i < word.length(); i++){
            char temp_char = word.charAt(i);
            List<String> newCombinations = new ArrayList<>();

            for(String combination : combinationsAtTheLevel){
//                System.out.println("combination is: "+ combination);
                for(int j = 0;  j <= combination.length(); j++){
//                    System.out.println(insertInString(temp_char, combination, j));
                    newCombinations.add(insertInString(temp_char, combination, j));
                }
//                System.out.println();
            }

//            System.out.println("newCombinations: " + Arrays.toString(newCombinations.toArray()));
            combinationsAtTheLevel = newCombinations;
        }

        return combinationsAtTheLevel;

    }

    public static void main(String[] args){
        String word = "abcd";

        List<String> answer = findPermutation(word);
        System.out.println("Answer is: ");
        System.out.println(Arrays.toString(answer.toArray()));

        System.out.println("No of combinations possible: " + answer.size());
//        System.out.println("start:");
//        for(String comb: answer){
//
//            System.out.println(comb);
//
//        }
//        System.out.println("end.");
    }
}
