import java.util.*;
public class BrickWall {
    private static int findWidth(List<Integer> wallRow){
        //return wallRow.isEmpty() ? 0 : wallRow.get(0) + findWidth(wallRow.subList(1, wallRow.size()));
        int totalWidth = 0;
        for(int i=0; i<wallRow.size(); i++){
            totalWidth+= wallRow.get(i);
        }
        return totalWidth;
    }

    public static int leastBricks(List<List<Integer>> wall) {
        //HashMap<Integer, Integer> hashmap = new HashMap<>();
        int totalWidth = findWidth(wall.get(0));
        System.out.println(totalWidth);
        int[] counts = new int[totalWidth];

        for(int i=0; i<wall.size(); i++){
            List<Integer> row  = wall.get(i);
            System.out.println("its here");
            if(row.size() == 1 && i == wall.size()-1){
                return wall.size();
            }
            else if(row.size()!=1) break;
//            else if(row.size() ==1) continue;
        }

        for(int i=0; i< wall.size(); i++){
            List<Integer> row = wall.get(i);
            int sum = 0;
            if(row.size() == 0) return 0;
                // else if(row.size() == 1) return wall.size();
            else if(row.size() >1){
                for(int j=0; j<row.size()-1; j++){
                    sum += row.get(j);
                    counts[sum]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0; i<counts.length; i++){
            if(counts[i] > max){
                max = counts[i];
                index = i;
            }
        }

        int minRows = 0;
        for(int i=0; i<wall.size(); i++){
            List<Integer> row = wall.get(i);
            int sum = 0;
            for(int j=0; j< row.size()-1; j++){
                sum += row.get(j);
                if(sum == index){
                    minRows+=1;
                }
            }
        }

        return wall.size() - minRows;

    }

    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(100000000);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(100000000);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(100000000);

        List<List<Integer>> newList = new ArrayList<>();
        int answer = leastBricks(newList);
        System.out.println(answer);
    }
}
