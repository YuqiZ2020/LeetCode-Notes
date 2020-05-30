class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length == 0) 
            return ans;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        ans.add(temp);
        for (int i = 1; i < nums.length; ++i)
        {
            List<List<Integer>> newAns = new ArrayList<List<Integer>>(); 
            for (List<Integer> k : ans)
            {
                for (int j = 0; j < i + 1; ++j)
                {
                    List<Integer> newList = new ArrayList<Integer>(k);
                    newList.add(j, nums[i]);
                    newAns.add(newList);
                } 
            }
            ans = newAns;
        }
        return ans;
    }
}

/**
 * Utlize iteration. Each time for every element in the 
 * ans, we want to add a new character in all the possible position. 
 * E.g. For {2, 1} and {1, 2} we want to add 3. Then we do 
 * {3, 2, 1}, {2, 3, 1} and {2, 1, 3} for the first one. We also do
 * {3, 1, 2}, {1, 3, 2} and {1, 2, 3} for the second one. 
 * First we insert the first one in one answer array. 
 * Then we need a loop from 1 to n - 1 to insert all the elements 
 * beside the first one. Inside each iteration, we first create
 * another answer list. For the old one we iterate through each
 * ans to insert the nums[i] in all possible position and store
 * them in the new answer list. 
 * Then we update the answer list. 
 */