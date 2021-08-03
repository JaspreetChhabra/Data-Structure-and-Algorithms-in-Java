package Array.Easy;

import java.util.HashMap;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> characterFrequencyMap = new HashMap<>();

        for (char c: s.toCharArray()){
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c, 0)+1);

        }

        for(int i=0; i<s.length(); i++){
            if(characterFrequencyMap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("dddccdbba"));
    }
}
