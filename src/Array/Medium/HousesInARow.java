package Array.Medium;

import java.util.Scanner;

public class HousesInARow {

    //Edge - first and last assumed to be 0
    //if j == 1 is 1 - j (0) = 0
    //else it will be 1
    //If both sides same then 0 else 1
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String state = s.nextLine();
        int days = s.nextInt();
        System.out.println(changeState(state, days));

    }

    public static String changeState(String state, int days) {
        int len = state.length();
        int[] stateArr = new int[len];

        for (int i = 0; i < len; i++) {
            stateArr[i] = Integer.valueOf(state.charAt(i));
        }

        for (int day = 0; day < days; day++) {

            int[] temp = new int[len];

            for (int j = 1; j < len - 1; j++) {
                if (j == 1) {
                    if (stateArr[j] == 48)
                        temp[0] = 0;
                    else temp[0] = 1;
                }

                if (stateArr[j - 1] == stateArr[j + 1]) {
                    temp[j] = 0;
                } else temp[j] = 1;


                if (j == len - 1) {
                    if (stateArr[j + 1] == 48)
                        temp[j + 1] = 0;
                    else temp[j + 1] = 1;
                }
            }

            stateArr = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(stateArr[i]);
        }
        return sb.toString();
    }
}
