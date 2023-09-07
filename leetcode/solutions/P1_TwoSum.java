package solutions;

public class P1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] oArr = {0, 1};

        //we know nums.length will be >= 2 from the constraints; so return default answer array if only length of 2
        if (nums.length == 2) {
            return oArr; 
        }

        //otherwise, loop through w/nested for loop and 2 pointers to check for target sum
        int tSum = 0; 
        for (int i = 0; i<nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j) {
                    tSum = nums[i] + nums[j]; 
                    if (tSum == target) {
                        oArr[0] = i; 
                        oArr[1] = j; 
                        break;
                    }
                }
            }
        }
        return oArr; 
    }
}
