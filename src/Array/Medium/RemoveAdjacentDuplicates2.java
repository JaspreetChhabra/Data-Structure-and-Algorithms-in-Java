package Array.Medium;

public class RemoveAdjacentDuplicates2 {
    public static String removeDuplicates(String s) {
        int i =0;
        char[] ans = s.toCharArray();

        for (int j =0; j< s.length(); j++, ++i){
            ans[i] = ans[j];

            if (i > 0 && ans[i] == ans[i-1]) i -= 2;
        }
        return new String(ans, 0, i);
    }

    //Stack Using String builder
    public static String removeDuplicatesUsingStringBuilder(String s){
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArr = s.toCharArray();
        for (char c: charArr){
            stringBuilder.append(c);
            int last = stringBuilder.length()-1;

            if(last > 0 && stringBuilder.charAt(last) == stringBuilder.charAt(last-1)) stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args){
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicatesUsingStringBuilder("abbaca"));
    }
}
