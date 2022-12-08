import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Solution {
    public void wordFrequency(String text) {
        if (text == null || text.length() == 0) {
            return;
        }

        HashMap<String, Integer> map = new HashMap<>();
        String[] words = text.split("\\s+");
        Stream<String> stream = Arrays.stream(words);

        stream.forEach(word -> {
            Integer frequency = map.getOrDefault(word, 0);
            map.put(word, frequency + 1);
        });

        Set<Entry<String, Integer>> entrySet = map.entrySet();
        List<Entry<String, Integer>> sortedList = new ArrayList<>(entrySet);
        
        Collections.sort(sortedList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        sortedList.forEach(entry -> System.out.println(entry.getValue() + " " + entry.getKey()));
    }
}