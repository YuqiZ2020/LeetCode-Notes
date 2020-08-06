/**
 * Problem 1535: Find the Winner of an Array Game
 * Prompt: Given an integer array arr of distinct integers 
 * and an integer k.
 * A game will be played between the first two elements of 
 * the array (i.e. arr[0] and arr[1]). In each round of the 
 * game, we compare arr[0] with arr[1], the larger integer 
 * wins and remains at position 0 and the smaller integer 
 * moves to the end of the array. The game ends when an 
 * integer wins k consecutive rounds.
 * Return the integer which will win the game.
 * It is guaranteed that there will be a winner of the game.
 * Date: 08/01/2020
 */
class Solution {
    public int getWinner(int[] arr, int k) {
        int maxN = arr[0];
        int counter = 0;
        for (int i = 1; i < arr.length; ++i)
        {
            if (arr[i] > maxN)
            {
                maxN = arr[i];
                counter = 1;
            }
            else
                counter++;
            if (counter >= k)
                return maxN;
        }
        return maxN;
        
    }
}

/**
 * Notes: For a integer to win k consequtive times it 
 * need to be the biggest amoung the following k - 1
 * numbers. 
 */