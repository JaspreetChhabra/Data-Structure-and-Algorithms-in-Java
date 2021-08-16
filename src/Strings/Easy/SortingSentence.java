package Strings.Easy;

import java.util.Arrays;
import java.util.Comparator;

public class SortingSentence {

    public static String sortSentence(String s) {
        String[] unsortedArr = s.split(" ");

        Arrays.sort(unsortedArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int firstStr = Integer.valueOf(o1.substring(o1.length()-1));
                int secondStr = Integer.valueOf(o2.substring(o2.length()-1));

                return firstStr - secondStr;
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String str : unsortedArr){
            stringBuilder.append(str.substring(0, str.length()-1) + " ");
        }

        return stringBuilder.toString().trim();
    }

    public static void main(String[] args){
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));
    }
}
