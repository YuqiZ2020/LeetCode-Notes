/**
 * Problem 621: Task Scheduler
 * Prompt: You are given a char array representing tasks CPU need 
 * to do. It contains capital letters A to Z where each letter 
 * represents a different task. Tasks could be done without the 
 * original order of the array. Each task is done in one unit of 
 * time. For each unit of time, the CPU could complete either one 
 * task or just be idle.
 * However, there is a non-negative integer n that represents the
 *  cooldown period between two same tasks (the same letter in the 
 * array), that is that there must be at least n units of time 
 * between any two same tasks.
 * You need to return the least number of units of times that the 
 * CPU will take to finish all the given tasks.
 * Date: 07/28/2020
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqCount = new int[26];
        for (int i = 0; i < tasks.length; ++i)
            freqCount[tasks[i] - 'A']++;
        int maxCount = 0;
        int maxIdx = 0;
        for (int i = 0; i < 26; ++i)
        {
            if (freqCount[i] > maxCount)
            {
                maxCount = freqCount[i];
                maxIdx = i;
            }      
        }
        maxCount--;
        int maxSpaces = maxCount * n;
        for (int i = 0; i < 26; ++i)
        {
            if (i != maxIdx)
                maxSpaces -= Math.min(freqCount[i], maxCount);
        }
        return tasks.length + Math.max(maxSpaces, 0);
    }
}

/**
 * Notes: The worst case happen when there is only one letter and
 * we have to fill in all gaps in between which is (maxCount - 1) * n
 * extra spaces. We can fill in those gaps with the rest of the 
 * letters. Notice that it doesn't matter which letter we use
 * we just fill them in seperate slots (so the max we can use
 * for each letter should be maxCount - 1). Then we add the extra
 * space to the original length. 
 */