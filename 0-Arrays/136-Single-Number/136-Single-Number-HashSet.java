import java.util.HashSet;

//Date: 05/02/2020
class Solution {
    public int singleNumber(int[] nums) {
      int sumOfSet = 0;
      int sumOfAll = 0;
      Set<Integer> numSet = new HashSet();
  
      for (int i = 0; i < nums.length; ++i)
        {
            if (!numSet.contains(nums[i]))
            {
                sumOfSet = sumOfSet + nums[i];
                numSet.add(nums[i]);
            }
            sumOfAll = sumOfAll + nums[i];
        }
        return 2 * sumOfSet - sumOfAll;
    }
  }

/**
 * Loop through the array and for each number 
 * if it is not contained in the set then add it
 * The single number is then 2 * sum of set - sum of all nums
 */