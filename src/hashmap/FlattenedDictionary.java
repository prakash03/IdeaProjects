package hashmap;

import java.util.*;

public class FlattenedDictionary {

    static HashMap<String, String> normalize_hashkey_with_value(String key, HashMap<String, Object> dict){

        HashMap<String, String> result = new HashMap<>();

        for(Map.Entry<String, Object> entry: dict.entrySet()){
            if(entry.getValue().getClass() == HashMap.class){
                HashMap<String, String> output = normalize_hashkey_with_value(entry.getKey(), (HashMap<String, Object>) entry.getValue());
                for(Map.Entry<String, String> output_entry : output.entrySet()){
                    if(key == ""){
                        result.put(output_entry.getKey(), output_entry.getValue());
                    } else {
                        if(output_entry.getKey() == "") { result.put(key + "." + output_entry.getKey(), output_entry.getValue()); }
                        else { result.put(key + "." + output_entry.getKey(), output_entry.getValue()); }
                    }

                }
            } else {
                if(key == ""){
                    result.put(entry.getKey(), entry.getValue().toString());
                } else{
                    if(entry.getKey() == "") { result.put(key, entry.getValue().toString()); }
                    else { result.put(key + "." + entry.getKey(), entry.getValue().toString()); }
                }

            }

        }

        return result;
    }

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> result = new HashMap<>();

        for(Map.Entry<String, Object> entry: dict.entrySet()){
            if(entry.getValue().getClass() == HashMap.class){
                HashMap<String, String> output = normalize_hashkey_with_value(entry.getKey(), (HashMap<String, Object>) entry.getValue());
                for(Map.Entry<String, String> output_entry : output.entrySet()){
                    result.put(output_entry.getKey(), output_entry.getValue());
                }
            } else {
                result.put(entry.getKey(), entry.getValue().toString());
            }
        }

        return result;
    }

    public static void main(String[] args){
        HashMap<String, Object> sub_dict3 = new HashMap<>();
        sub_dict3.put("", 1);

        HashMap<String, Object> sub_dict2 = new HashMap<>();
        sub_dict2.put("d", 3);
        sub_dict2.put("e", sub_dict3);


        HashMap<String, Object> sub_dict = new HashMap<>();
        sub_dict.put("a", 2);
        sub_dict.put("b", 3);
        sub_dict.put("", sub_dict2);

        HashMap<String, Object> dict = new HashMap<>();
        dict.put("Key1", 1);
        dict.put("Key2", sub_dict);

        HashMap<String, String> output = flattenDictionary(dict);

        for(Map.Entry<String, String> entry: output.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
