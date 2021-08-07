package Algorithms.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsetsUsingList(int[] nums){
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for(int num: nums){
            List<List<Integer>> subsets = new ArrayList<>();

            for (List<Integer> curr: output){
                 subsets.add(new ArrayList<>(curr) {{
                     add(num);
                }});
            }

            for (List<Integer> curr: subsets) {
                output.add(curr);
            }
        }
        return output;
    }

    List<List<Integer>> subsets = new ArrayList<>();
    int k;
    public List<List<Integer>> subsets(int[] nums){
        int n = nums.length;

        for (k=0; k<n+1; ++k){
            backtrack(0, nums, new ArrayList<>());
        }

        return subsets;
    }

    public void backtrack(int start, int[] nums, List<Integer> subList)
    {
        if(start == k) {
            subsets.add(new ArrayList<>(subList));
            return;
        }

        for(int i=start; i< nums.length; i++){
            subList.add(nums[i]);
            backtrack(i+1, nums, subList);
            subList.remove(subList.size()-1);
        }
    }

    public static void main(String[] args){
        SubSets subSets = new SubSets();
        subSets.subsetsUsingList(new int[]{1,2,3});
        subSets.subsets(new int[]{1,2,3});
    }
}
