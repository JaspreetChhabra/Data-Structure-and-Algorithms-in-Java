package Array.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class UniqueNumberOccurrence {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurMap = new HashMap<>();

        for(int number: arr) {
            occurMap.put(number, 1 + occurMap.getOrDefault(number, 0));
        }

        return occurMap.size() == new HashSet<>(occurMap.values()).size();

//        Iterator iterator = occurMap.entrySet().iterator();
//
//        while(iterator.hasNext()){
//            Map.Entry entry = (Map.Entry)iterator.next();
//            int key = (int) entry.getKey();
//            int value = (int) entry.getValue();
//            occurMap.put(key, 0);
//            if(occurMap.containsValue(value)) {
//                return false;
//            }
//        }
    }

    public static void main(String[] args) {
        int[] uniqueOccurenceArray = {-3,0,1,-3,1,1,1,-3,10,0};

        System.out.println("Unique Occurrence "+ uniqueOccurrences(uniqueOccurenceArray));

        int[] NonUniqueOccurenceArray = {1,2};

        System.out.println("Unique Occurrence "+ uniqueOccurrences(NonUniqueOccurenceArray));
    }
}
