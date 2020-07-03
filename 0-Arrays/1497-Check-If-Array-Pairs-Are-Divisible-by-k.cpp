/**
 * Problem 1497: Check If Array Pairs Are Divisible by k
 * Prompt: Given an array of integers arr of even length
 * n and an integer k.
 * We want to divide the array into exactly n / 2 pairs 
 * such that the sum of each pair is divisible by k.
 * Return True If you can find a way to do that or False 
 * otherwise.
 * Date: 07/02/2020
 * */
class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        map<int, int> freqMap;
        for (int i = 0; i < arr.size(); ++i)
        {
            int t = arr[i] % k;
            if (t < 0)
                t = k + t;
            freqMap[t]++;
        }
        if (freqMap[0] % 2 != 0)
            return false;
        for (int i = 1; i <= k / 2; ++i)
        {
            if (freqMap[i] != freqMap[k - i])
                return false;
        }
        return true;
    }
};

/**
 * Notes: In this problem, two integers a and b can be in a pair 
 * if and only if (a + b) mod k = 0.
 * We know that (a + b) mod k = (a mod k + b mod k) mod k, so only when 
 * a's remainder plus b's remainder is multiples of k (or zero) 
 * can they satisfy the prompt.
 * However we also know that the remainder of a integer mod k can only 
 * be from 0 to k - 1 by Math definition, which means that a mod k + b
 * mod k can only be from 0 to 2k - 1, so only two conditions would satisfy 
 * the prompt: 
 * 1) a mod k + b mod k = 0 2) a mod k + b mod k = k
 * Therefore if we count the frequency of different remainders from 
 * 0 to k - 1, and we see if the frequency count of i mod k = 0 is even, 
 * and that we could find pairs for remainders.
 * Regarding remainder of negative numbers, if we want the above solution 
 * to work (which is by Math definition) we need to alter the % operation 
 * in C++. Because for example, -13 % 5 would be -3 in C++ but we actually 
 * want -13 % 5 = 2 (because -13 = -3 * 5 + 2). That's why we are altering 
 * those "negative remainders".
 * */