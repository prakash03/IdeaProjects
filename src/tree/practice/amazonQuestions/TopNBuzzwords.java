package tree.practice.amazonQuestions;

import java.util.*;

public class TopNBuzzwords {
    private static class WordStats {
        String word;
        int countTimes;
        Set<Integer> quotesIds;
        public WordStats(String word, int countTimes) {
            this.word = word;
            this.countTimes = countTimes;
            this.quotesIds = new HashSet<>();
        }
    }

    private static List<String> topNBuzzwords(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        List<String> res = new ArrayList<>();
        Set<String> setToys = new HashSet<>();
        Map<String, WordStats> mapWords = new HashMap<>();

        for (int i = 0; i < numToys; i++)
            setToys.add(toys[i]);

        for (int i = 0; i < numQuotes; i++)
        {
            String q = quotes[i];
            q = q.replaceAll("[\\!?,;.]", "").toLowerCase();
            String[] words = q.split(" ");

            for (int w = 0; w < words.length; w++)
            {
                String word = words[w];
                if (setToys.contains(word))
                {
                    WordStats stats;
                    if (mapWords.containsKey(word))
                        stats = mapWords.get(word);
                    else
                        stats = new WordStats(word, 0);
                    stats.countTimes++;
                    stats.quotesIds.add(i);
                    mapWords.put(word, stats);
                }
            }
        }

        PriorityQueue<WordStats> pq = new PriorityQueue<WordStats>(new Comparator<WordStats>() {
            @Override
            public int compare(WordStats o1, WordStats o2) {
                if (o1.countTimes != o2.countTimes)
                    return Integer.compare(o2.countTimes, o1.countTimes);
                else if (o1.quotesIds.size() != o2.quotesIds.size())
                    return Integer.compare(o2.quotesIds.size(), o1.quotesIds.size());
                else
                    return o1.word.compareTo(o2.word);
            }
        });
        pq.addAll(mapWords.values());

        if (topToys > pq.size())
            for (int i = 0; i < numToys && !pq.isEmpty(); i++)
                res.add(pq.poll().word);
        else
            for (int i = 0; i < pq.size(); i++)
                res.add(pq.poll().word);

        return res;
    }

    public static void main(String[] args){
        int numToys = 6;
        int topToys = 2;
        String[] toys = new String [] {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = new String[] {
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!", "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"};

//        System.out.println(.toArray().toString());
        List<String> result = topNBuzzwords(numToys, topToys, toys, numQuotes, quotes);

        for(String word : result){
            System.out.println(word);
        }

    }

    // for each toy, we maintain the number of occurences in all quotes  and also the number of times it occurred  in a quote



//    private static List<String> findMostPopularToys(HashMap<String, Integer> toysCount, int topToys){
//        // #all in this is new
//        ArrayList<Integer> occurenceCount = new ArrayList<>();
//        for(Map.Entry<String, Integer> entry: toysCount.entrySet()){
//            occurenceCount.add(entry.getValue());
//        }
//
//        Collections.sort(occurenceCount);
//        Collections.reverse(occurenceCount); // or Collections.sort(arraylist, Collections.reverseOrder());
//
//        for(int i = 0; i< topToys; i++){
//            for(Integer count: occurenceCount){
//
//            }
//        }
//
//    }
//
//    // Return a list of strings of the most popular N toys in order of most to least frequently mentioned
//    static List<String> topPopularToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes){
//
//        List<String> answer = new ArrayList<>();
//        HashMap<String, Integer> toysCount = new HashMap<>();
//        Set<String> toyListings = new HashSet<>();
//        for (String toy:toys){
//            toyListings.add(toy);
//        }
//
//        for (String quote: quotes){
//            for(String word: quote.split(" ")){
//                if(toyListings.contains(word)){
////                    toysCount.containsKey(word) ? toysCount.put(word, toysCount.get(word) + 1) : toysCount.put(word, 1); # this should be common and re-occurring.
//                    if(toysCount.containsKey(word)){
//                        toysCount.put(word, toysCount.get(word) + 1);
//                    } else toysCount.put(word, 1);
//                }
//            }
//        }
//
//        return answer;
//    }
}
