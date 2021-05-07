package Strings;

//CoderBytes - HackerEarth Counting Minutes
//Have the function CountingMinutes(str) take the str parameter being passed which will be two times(each properly formatted with a colon
// and am or pm) separated by a hyphen and return the total number of minutes between the two times. The time will be in a 12 hour clock format.
// For example: if str is 9:00am-10:00am then the output should be 60. If str is 1:00pm-11:00am the output should be 1320.
//Examples
//== INPUT ==
//"1:23am-1:08am"
//<< EXPECTED OUTPUT: 1425 >>
//== INPUT ==
//"12:30pm-12:00am"
//== OUTPUT ==
//690
//== INPUT ==
//10:23am-10:20am
//== OUTPUT ==
//1437

import java.util.Scanner;

public class CountingMinutes {

    static int colonIndex, min1, hour1, hour2, min2;
    static char firstTime, secondTime;

    public static void configureVariables(String str) {

        colonIndex = str.indexOf("-");
        min1 = Integer.parseInt(str.substring(colonIndex - 4, colonIndex - 2));
        hour1 = Integer.parseInt(str.substring(0, str.indexOf(":")));

        hour2 = Integer.parseInt(str.substring(colonIndex+1, str.lastIndexOf(":")));
        min2 = Integer.parseInt(str.substring(str.length() - 4, str.length() - 2));

        firstTime = str.charAt(colonIndex - 2);
        secondTime = str.charAt(str.length() - 2);
    }
    public static String CountingMinutes(String str) {

        configureVariables(str);
        if (hour1 == hour2 && firstTime == secondTime){
            if(min1 < min2) return String.valueOf(min2 - min1);
            else return String.valueOf((24 * 60) - (min1-min2));
        }

        if (firstTime != 'p' && secondTime != 'a') {
            if (firstTime == 'p') {
                if (hour1 != 12) hour1 += 12;
            } else {
                if (hour1 == 12) hour1 = 0;
            }

            if (secondTime == 'p') {
                if (hour2 != 12) hour2 += 12;
            } else {
                if (hour2 == 12) hour2 += 12;
            }
        }
        int hourDiff = (Math.abs(hour1 - hour2));
        if (firstTime == 'p' && secondTime == 'a') hourDiff += 12;

        return String.valueOf( (hourDiff * 60) + (min2 - min1));
    }

    public static String CountingMinutes2(String str) {

        configureVariables(str);
        int totalMinutes1 = hour1 * 60 + min1;
        int totalMinutes2 = hour2 * 60 + min2;

        if (firstTime != secondTime) totalMinutes2 =+ 12 * 60;
        else if (firstTime == secondTime && totalMinutes1 > totalMinutes2) totalMinutes2 += 24 * 60;

        return String.valueOf( firstTime == 'p' && secondTime == 'a' ? (totalMinutes2 - totalMinutes1) + 11*60 : (totalMinutes2 - totalMinutes1));
    }
    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(CountingMinutes2(s.nextLine()));
    }
}
