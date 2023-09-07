package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

public class P26_RmDuplicates {

    public static void main(String args[]) {
        P26_RmDuplicates prob = new P26_RmDuplicates();
        int[] nums = new int[] {-3,-1,0,0,0,3,3}; 
        prob.removeDuplicates(nums);
    }

    //remove duplicates from array 
    public int removeDuplicates(int[] nums) {
        int result = 0; 
        HashSet<Integer> numSet = new HashSet<Integer>();

        for (int i : nums) {
            numSet.add(i); 
        }
        
        result = numSet.size();
        
        //Convert to list to use Collections.sort
        ArrayList<Integer> list = (ArrayList<Integer>)numSet.stream().collect(Collectors.toList());
        Collections.sort(list);
        
        int n = 0; 
        for (Integer i : list) {
            nums[n] = i;
            n++; 
        }

        System.out.println(Arrays.toString(nums)); 
        return result; 
    }
}
