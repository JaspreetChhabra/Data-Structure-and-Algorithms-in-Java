package Array.Medium;

//  Given a Collection of strings , group the anagrams together and return the number of groups formed.
//
//  Example 1:
//
//  Input: strs = ["cat","listen","silent","salient","kitten"]
//  Output: 4

import java.util.*;

public class GroupAnagrams2 {
    public static int groupAnagrams(List<String> words) {
        Map<String, Integer> map = new HashMap<>();

        for (String sword : words) {
            char[] str = sword.toCharArray();
            Arrays.sort(str);
            String newStr = new String(str);

            if (map.containsKey(newStr)) {
                int val = map.get(newStr);
                map.put(newStr, val+1);
            }
            else {
                map.put(newStr, 1);
            }
        }
        return map.size();
    }

    public static void main(String[] args){
        List<String> strs = Arrays.asList("cat","listen","silent","salient","kitten");

        int groupedAnagrams = groupAnagrams(strs);
        System.out.println(groupedAnagrams);
        //output: 4
    }
}
