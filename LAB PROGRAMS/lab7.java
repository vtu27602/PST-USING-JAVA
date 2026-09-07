import java.util.*;

public class HashtagFrequency {
    public static void main(String[] args) {
        String text = "#java #coding #java #programming #coding #java";

        String[] words = text.split(" ");
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (word.startsWith("#")) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

OUTPUT :
#programming : 1
#coding : 2
#java : 3
