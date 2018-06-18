package string;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.*;


public class CharacterDuplicates {
    //returns the first duplicate occured in the string
    static char findDuplicate(String s1){

        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<s1.length(); i++){
            if(set.contains(s1.charAt(i))){
                return s1.charAt(i);
            }
            if(i == s1.length()-1 && !set.contains(s1.charAt(i))){
                System.out.println("No duplicate characters");
                return ' ';
            }
            set.add(s1.charAt(i));
        }
        return ' ';
    }

    //returns all the duplicate characters in the given  string. But doesnt return the number of times it has occured.
    static List<Character> findMultipleDuplicates(String str){
        List<Character> duplicate = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length()-1;i++){
            if(set.contains(str.charAt(i))){
                duplicate.add(str.charAt(i));
            }
            if(i==str.length()-1 && !set.contains(str.charAt(i))){
                System.out.println("No duplicates in the String");
                return duplicate;
            }
            set.add(str.charAt(i));

        }
        return duplicate;
    }


    static void findOccurences(String str){
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            if(hashmap.containsKey(str.charAt(i))){
                hashmap.put(str.charAt(i),hashmap.get(str.charAt(i))+1);
            }
            else if(!hashmap.containsKey(str.charAt(i))){
                hashmap.put(str.charAt(i), 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : hashmap.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey() + " : "+ entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("enter a string to check: ");
        Scanner in = new Scanner(System.in);
        String s_1 = in.nextLine();
        Character answer = findDuplicate(s_1);
        if(answer != ' ') System.out.println("Repeating character is : "+ answer);

        System.out.println("Enter another String : ");
        String str = in.nextLine();
        System.out.println("Duplicates are: "+ findMultipleDuplicates(str).toString());

        String str_2 = "DhabidiDhibide";
        findOccurences(str_2);

    }
}
