/**
 * Problem 278: First Bad Version
 * Prompt: Suppose you have n versions [1, 2, ..., n] 
 * and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize 
 * the number of calls to the API.
 * Date: 05/02/2020
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int startNum = 1;
        int endNum = n;
        int midNum = 0;
        while (startNum < endNum)
        {
            midNum = startNum + (endNum - startNum) / 2;
            if (isBadVersion(midNum))
                endNum = midNum;
            else 
                startNum = midNum + 1;
        }
        return startNum;
    }
}

/**
 * Notes: Use a binary search
 * Be careful about edge cases
 * Also notice integer overflow caused by (startNum + endNum)/2
 * startNum + (endNum - startNum) / 2 can avoid the issue
 */