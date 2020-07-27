/**
 * Problem 1529: Bulb Switcher IV
 * Prompt: There is a room with n bulbs, numbered from 0 to n-1, 
 * arranged in a row from left to right. Initially all the bulbs 
 * are turned off.
 * Your task is to obtain the configuration represented by target
 * where target[i] is '1' if the i-th bulb is turned on and is '0' 
 * if it is turned off.
 * You have a switch to flip the state of the bulb, a flip 
 * operation is defined as follows:
 * Choose any bulb (index i) of your current configuration.
 * Flip each bulb from index i to n-1.
 * When any bulb is flipped it means that if it is 0 it changes 
 * to 1 and if it is 1 it changes to 0.
 * Return the minimum number of flips required to form target.
 * Date: 07/27/2020
 */
class Solution {
    public int minFlips(String target) {
        int ans = 0;
        char prev = '0';
        for (int j = 0; j < target.length(); ++j)
        {
            if (target.charAt(j) == prev)
                continue;
            else
            {
                ans++;
                prev = target.charAt(j);
            }
        }
        return ans;
    }
}
/**
 * Notes: The turning of the switch is commutative, for each 1 we need
 * odd number of switches and for each 0 we need even number of switches. 
 * In order to prevent unnecessary switches, we can start from left
 * and go towards right, for those patterns that are consecutive, we modify
 * them together and then by pass them for the next location. 
 * This would minize the operations and we just iterate over the string once. 
 */