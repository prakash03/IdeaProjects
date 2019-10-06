package string;

import java.util.HashMap;

public class CountCharacters {

    static HashMap<Character, Integer> characterCounter(String inputString){
        HashMap<Character, Integer> countKeeper = new HashMap<>();

        for(int i = 0; i < inputString.length(); i++){
            if(countKeeper.containsKey(inputString.charAt(i))){
                countKeeper.replace(inputString.charAt(i), countKeeper.get(inputString.charAt(i)) + 1); // May not need the if condition here?
            } else countKeeper.put(inputString.charAt(i), 1);
        }
        return countKeeper;
    }

    public static void main(String[] args){
        String firstString = "Well...planet earth is not safe anymore.";

        HashMap<Character, Integer> map = characterCounter(firstString);
        map.entrySet().forEach(characterIntegerEntry -> {
           System.out.println(characterIntegerEntry.getKey() + " : "+ characterIntegerEntry.getValue());
        });
    }
}
