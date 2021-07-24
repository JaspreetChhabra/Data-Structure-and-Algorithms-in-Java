package Trees.Easy;

import java.util.*;

//    Geeks: https://www.geeksforgeeks.org/averages-levels-binary-tree/
//    Leetcode: 637. Average of Levels in Binary Tree https://leetcode.com/problems/average-of-levels-in-binary-tree/
//
//    Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
//
//    Example 1:
//
//    Input: root = [3,9,20,null,15,7]
//    Output: [3.00000,14.50000,11.00000]
//    Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
//    Hence return [3, 14.5, 11].

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class AverageOfLevel {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList();

        Queue<TreeNode> mainQueue = new LinkedList<>();

        mainQueue.add(root);
        while (!mainQueue.isEmpty()){
            int sum =0;
            int count = 0;
            Queue<TreeNode> tempQueue = new LinkedList<>();

            while (!mainQueue.isEmpty()){
                TreeNode node = mainQueue.remove();
                sum += node.val;
                count++;

                if(node.left != null) tempQueue.add(node.left);
                if (node.right != null) tempQueue.add(node.right);
            }
            mainQueue = tempQueue;
            average.add(sum * 1.0 / count);
        }
        return average;
    }

    public static List<Double> averageOfLevelsUsing1Queue(TreeNode root) {
        List<Double> average = new ArrayList();

        Queue<TreeNode> mainQueue = new LinkedList<>();
        mainQueue.add(root);
        while (!mainQueue.isEmpty()){
            int sum =0;
            int count = mainQueue.size();

            for (int i = 0; i<count; i++){
                TreeNode node = mainQueue.remove();
                sum += node.val;

                if(node.left != null) mainQueue.add(node.left);
                if (node.right != null) mainQueue.add(node.right);
            }
            average.add(sum * 1.0 / count);
        }
        return average;
    }

    public static void main(String[] args){
        TreeNode rLNode = new TreeNode(5);
        TreeNode rrNode = new TreeNode(7);
        TreeNode lnode = new TreeNode(2);
        TreeNode rNode = new TreeNode(9, rLNode, rrNode);
        TreeNode root = new TreeNode(4, lnode, rNode);

        System.out.println(Arrays.toString(averageOfLevels(root).toArray()));
        System.out.println(Arrays.toString(averageOfLevelsUsing1Queue(root).toArray()));
    }


}
