import java.util.*;

public class Gangsters {
    static List<int[]> findTheGang(List<String[]> inputArray){
        List<int[]> teamsList = new ArrayList<>();
        for(int i=0; i<inputArray.size(); i++){
            String[] crimesDone = inputArray.get(i);
            for(int j=0; j<crimesDone.length; j++){
                String current = crimesDone[j];
                int[] teamedUp = findPairs(current, i, inputArray);
                if(teamedUp[0]+teamedUp[1] != 0){
                    teamsList.add(teamedUp);
                }
            }
        }
        return teamsList;
    }

    static int[] findPairs(String current, int index, List<String[]> inputArray){
        int[] sameCrimes = new int[2];
        //Look for only the data after the current criminals data. No need to compare with earlier.
        for(int i=index+1; i<inputArray.size(); i++){
            String[] comparingWith = inputArray.get(i);
            for(int j=0; j<comparingWith.length; j++){
                if(comparingWith[j].equals(current)){
                    sameCrimes[0] = index+1;
                    sameCrimes[1] = i+1;
                }
            }
        }
        return sameCrimes;
    }

    static boolean isSingleGang(List<int[]> teamsList, int numberOfCriminals){
        List<Set<Integer>> setList = new ArrayList<>();
        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(teamsList.get(0)[0]);
        firstSet.add(teamsList.get(0)[1]);
        setList.add(firstSet);//Adding the first crime with common criminals into the Set list.

        for(int j=0; j<setList.size(); j++){
            for(int i=0; i<teamsList.size(); i++){
                if(setList.get(j).contains(teamsList.get(i)[0]) || setList.get(j).contains(teamsList.get(i)[1])){
                    System.out.println("Elements are: " + teamsList.get(i)[0] + teamsList.get(i)[1]);
                    System.out.println("at 1");
                    setList.get(j).add(teamsList.get(i)[0]);
                    setList.get(j).add(teamsList.get(i)[1]);
                    //System.out.println("at 2");
                }
                else{
                    //System.out.println("Elements are: " + teamsList.get(i)[0] + teamsList.get(i)[1]);
                    System.out.println("at 2");
                    Set<Integer> hashSet = new HashSet<>();
                    hashSet.add(teamsList.get(i)[0]);
                    hashSet.add(teamsList.get(i)[1]);
                    setList.add(hashSet);
                }
            }
        }

        int maxSize = 0;
        for(Set<Integer> set: setList){
            if(set.size()>maxSize){
                maxSize = set.size();
            }
        }

        if(maxSize == numberOfCriminals){
            return true;
        }
        return false;
    }

    static List<String[]> convertToArray(String[] input){
        List<String[]> inputArray = new ArrayList<>();
        for(String str : input){
            String[] array = str.split(",");
            inputArray.add(array);
        }
        return inputArray;
    }

    public static void main(String[] args){
        String[] input = {"1,2","3,1","3,4"};
        String[] input2 = {"3,2","4,1","1,4","1,2"};
        String[] input3 = {"3,4,5","1","1,4","5,2","3"};
        String[] input4 = {"1,3","2,4","3,5","6,7"};
        String[] input5 = {"1"};
//        Scanner in = new Scanner(System.in);
//        List<String[]> inputAr = new ArrayList<>();
//        while(in.hasNextLine()){
//           String next = in.nextLine();
//           String[] array = next.split(",");
//           inputAr.add(array);
//        }

        List<String[]> inputArray = convertToArray(input5);
        int numberOfCriminals = inputArray.size();
//        for(int i=0; i<answer.size(); i++){
//            System.out.println(Arrays.toString(answer.get(i)));
//        }
//        int[] sameCrimes = findPairs("3",1,inputArray);
//        System.out.println(Arrays.toString(sameCrimes));

        List<int[]> gangs = findTheGang(inputArray);
        for(int i=0; i<gangs.size(); i++){
            System.out.println(Arrays.toString(gangs.get(i)));
        }

        System.out.println(isSingleGang(gangs, numberOfCriminals));
        //findTheGang(inputArray);
    }
}
