class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int end = 0;
        int count = 0;
        int ans = 0;
        for (int front = 0; front < nums.size(); ++front)
        {
            if (nums[front] == 0)
                count++;
            while (count > 1)
            {
                if (nums[end] == 0)
                    count--;
                end++;
            }
            ans = max(ans, front - end);
        }
        return ans;
    }
};

/**
 * Notes: Sliding window with at most one zero in the window region. 
 * The front pointer will increase the counter when meeting a zero
 * and once we have too much zero we have to shrink the end of the 
 * window. Each time we store the longest length of the window. 
 * */