package Strings.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

//  LeetCode 539. Minimum Time Difference https://leetcode.com/problems/minimum-time-difference/
//  GGiven a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
//
//
//    Example 1:
//
//    Input: timePoints = ["23:59","00:00"]
//    Output: 1
//    Example 2:
//
//    Input: timePoints = ["00:00","23:59","00:00"]
//    Output: 0


public class MinimumTimeDifference {
        public static int findMinDifference(List<String> timePoints) {
            Collections.sort(timePoints);

            for (int i = 1; i < timePoints.size(); i++) {
                String[] hourMin1 = timePoints.get(i - 1).split(":");
                String[] hourMin2 = timePoints.get(i).split(":");

                int hourDiff = Math.abs(Integer.parseInt(hourMin1[0]) - Integer.parseInt(hourMin2[0]));

                if (hourDiff > 1) hourDiff -= 1;
                else hourDiff = 0;

                int minDiff1 = 60 - Integer.parseInt(hourMin1[1]);

                return (hourDiff * 60) + (minDiff1 + Integer.parseInt(hourMin2[1]));
            }
            return 0;
        }


        public static int findMinDifferenceUsingJava8(List<String> timePoints) {
            int[] minutes = timePoints.stream().mapToInt((s) -> {
                String[] value = s.split(":");
                return 60 * Integer.parseInt(value[0]) + Integer.parseInt(value[1]);
            }).sorted().toArray();

            int min = IntStream.range(0, minutes.length - 1)
                    .map(i -> minutes[i + 1] - minutes[i])
                    .min()
                    .getAsInt();

            int corner = minutes[0] + (1440 - minutes[minutes.length - 1]);
            return Math.min(min, corner);
        }


    public static void main(String[] args){
        List<String> timePoints = Arrays.asList("23:59","00:00");
        System.out.println(findMinDifferenceUsingJava8(timePoints));
        System.out.println(findMinDifference(Arrays.asList("00:00","23:59","00:00")));
    }
}
