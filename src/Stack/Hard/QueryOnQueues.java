package Stack.Hard;

//    Paypal | Online Coding | SE2 https://leetcode.com/discuss/interview-question/1104385/Paypal-or-Online-Coding-or-SE2-or-2-YOE
//    Reference links: https://stackoverflow.com/questions/64026440/count-segments-where-ai-is-rightmost-or-leftmost-and-is-max
//                     https://stackoverflow.com/questions/64026440/count-segments-where-ai-is-rightmost-or-leftmost-and-is-max
//    Query on Queues
//    You're given an array containing N integers and you have to answer K queries. Each query contains an integer X which is the index of the i th ( 1 based index) element of the queue
//
//    Write a program to determine the following for each query
//
//    The number of segments containing the index X as the leftmost or the rightmost element. and the number at the index X is >= each element of the first segment.
//    Example
//    Segment formation : You have 3 numbers 1, 2 and 3
//    The possible segments for 3 are [3], [3,2], [3,2,1]
//    The possible segments for 2 are [2], [2,1]
//
//    Input Format
//
//    First line : Two space seperated integers N and K
//    Second line : N space seperated integers ( denoting the elements of the queue)
//    Next K lines is the value of X
//    Function description
//
//    N : represents the size of array
//    A : represents the array
//    K : represents the size of queries
//    Q : represents the queries
//    Constrains
//
//    1 <= N,K <= 10^5
//    1 <= Each element of the queue <= 10^9
//    1 <= X <= N
//    Sample Input
//
//    Sample input 1
//    4 2
//    4 2 1 3
//    1
//    4
//
//    Sample output 1
//    4
//    3
//
//    Sample input 2
//    5 2
//    4 2 3 5 1
//    1
//    3
//
//    Sample output 2
//    3
//    2

public class QueryOnQueues {
}
