package Array.Easy;

//    Geeks https://www.geeksforgeeks.org/sieve-of-eratosthenes/
//    Leetcode https://leetcode.com/problems/count-primes/
//
//    204. Count Primes
//    Easy
//
//    3502
//
//    837
//
//    Add to List
//
//    Share
//    Count the number of prime numbers less than a non-negative number, n.
//
//
//
//    Example 1:
//
//    Input: n = 10
//    Output: 4
//    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.


public class CountPrime {

    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n+1];
        int count =0;

        for(int i=2; i<n; i++){
            if(prime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++){
                    prime[i*j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(countPrimes(30));
    }
}
