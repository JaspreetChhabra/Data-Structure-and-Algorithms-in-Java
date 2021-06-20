package Strings.Easy;

//  LeetCode 1108. Defanging an IP Address https://leetcode.com/problems/defanging-an-ip-address/
//  Given a valid (IPv4) IP address, return a defanged version of that IP address. A defanged IP address replaces every period "." with "[.]".
//
//
//    Example 1:
//
//    Input: address = "1.1.1.1"
//    Output: "1[.]1[.]1[.]1"
//    Example 2:
//
//    Input: address = "255.100.50.0"
//    Output: "255[.]100[.]50[.]0"


public class DefangingAddress {

    public static String defangingAddress(String address){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<address.length(); i++){
            if (address.charAt(i) == '.') stringBuilder.append("[.]");
            else stringBuilder.append(address.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String defangingAddressUsingReplace(String address){
        return address.replaceAll("[.]", "[.]");
    }

    public static void main(String[] args){
        String str = "1.1.1.1";
        System.out.println(defangingAddress(str)); //takes 0ms Runtime
        System.out.println(defangingAddressUsingReplace(str)); //Takes 3ms Runtime
    }
}
