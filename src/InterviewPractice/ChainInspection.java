package InterviewPractice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.*;

public class ChainInspection {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("src/chain.txt"));
        String line;
        while((line = br.readLine()) != null){
            line = line.trim();
            String[] lineItems = line.split(";");

            HashMap<String, String> hashMap = new HashMap<>();
            for(String item: lineItems){
                String[] keyValue = item.split("-");
                hashMap.put(keyValue[0], keyValue[1]);
            }

            String currentKey = "BEGIN";
            int size = 0;

            while(!currentKey.equals("END")){
                if(hashMap.get(currentKey) != null){
                    currentKey = hashMap.get(currentKey);
                    size++;
                }
                else break;
                if(size > hashMap.size()) break;

            }
            System.out.println((size == lineItems.length) ? "Complete" : "Incomplete");
        }
    }
}
