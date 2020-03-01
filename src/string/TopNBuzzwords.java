package string;

import java.sql.SQLOutput;
import java.util.*;

public class TopNBuzzwords {

    public class Toy{
        String name;
        int count;
        int numberOfQuotesHavingToy;

        public Toy(String name){
            this.name = name;
            this.count = 0;
            this.numberOfQuotesHavingToy = 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Toy toy = (Toy) o;
            return name.equals(toy.name);
        }
    }

    /**
     * Returns the Most high frequency `n` toys in the given list of quotes.
     *
     * Conditions:
     *      Comparision is case-insensitive
     *      Return a list of strings of the most popular N toys in order of most to least frequently mentioned
     *      If the value of topToys is more than the number of toys, return the names of only the toys mentioned in the quotes
     *      If toys are mentioned an equal number of times in quotes, sort alphabetically
     *
     */
     String[] findHighFrequencyToys(int numToys, int topToys, String[]  toys, int numQuotes, String[] quotes){

         HashMap<String, Toy> toy_frequencies = new HashMap<>();

         for(String toy  :  toys){

             toy_frequencies.put(toy.toLowerCase(), new Toy(toy.toLowerCase()));
         }

        for(String quote : quotes){
            String[] words = quote.replaceAll("[^a-zA-Z ]", "").split(" ");

            Set<String> words_considered = new HashSet<>();

            System.out.println(Arrays.toString(words));
            for(int i = 0; i < words.length; i++){

                if(toy_frequencies.containsKey(words[i].toLowerCase())) {
                    Toy toy = toy_frequencies.get(words[i].toLowerCase());
                    toy.count += 1;
                    if (!words_considered.contains(words[i].toLowerCase())) {
                        words_considered.add(words[i].toLowerCase());
                        toy.numberOfQuotesHavingToy += 1;
                    }

                    toy_frequencies.put(words[i].toLowerCase(), toy);
                }

            }
        }

        for(Map.Entry<String, Toy> entry : toy_frequencies.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().count + " , ");
        }

        // https://leetcode.com/problems/top-k-frequent-words/solution/
        return new String[1];
    }

    public static void main(String[] args){
        int numToys = 6;
        int topToys = 2;
        String[] toys = new String[] {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = new String[]{
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };

        TopNBuzzwords buzzwords = new TopNBuzzwords();

//        buzzwords.findHighFrequencyToys(numToys, topToys, toys, numQuotes, quotes);
        System.out.println("ball".compareTo("bat"));
    }
}
