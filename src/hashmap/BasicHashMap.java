package hashmap;

import java.util.HashMap;
import java.util.Map;

public class BasicHashMap {
    public static void main(String[] args){
        String name = "sa,djkhfliueosflkjsdfhlkhsdfiwe";

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : name.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) +1);
            } else map.put(c, 1);
        }

        System.out.println("The values are: " + map.entrySet());

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }

        System.out.println(map.keySet().contains('p'));
    }
}
