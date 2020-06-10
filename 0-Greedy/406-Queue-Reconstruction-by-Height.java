/**
 * Problem 406: Queue Reconstruction by Height
 * Prompt: Suppose you have a random list of people standing in
 *  a queue. Each person is described by a pair of integers 
 * (h, k), where h is the height of the person and k is the 
 * number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct
 * the queue.
 * Date: 06/07/2020
 */
class Solution {
    private static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() {  
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else if (entry1[col] == entry2[col])
            {
                if (entry1[col + 1] > entry2[col + 1])
                    return 1;
                else 
                    return -1;
            }
            else
                return -1; 
          } 
        }); 
    } 
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        int[][] ans = new int[len][2];
        for (int i = 0; i < len; ++i)
            ans[i][0] = -1;
        
        sortbyColumn(people, 0);

        for (int i = 0; i < len; ++i)
        {
            int counter = people[i][1];
            int idx = 0;
            while (counter != 0)
            {
                if (ans[idx][0] == -1 || ans[idx][0] == people[i][0])
                    counter--;
                idx++;
            }
            while (ans[idx][0] != -1)
                idx++;
            ans[idx][0] = people[i][0];
            ans[idx][1] = people[i][1];
        }
        return ans;
    }
}

/**
 * Notes: First customize a sort based on the height of the people. 
 * Then start from the shortest people, we can know where he would
 * stay based on how many people are higher than him. 
 * After this, each person from short to high, we can assign a spot
 * based on the occupancy of the slot before him and the index of 
 * how many people are higher than him. 
 * For any people i, suppose there are j people that are higher than 
 * him. Then once we meet an not occupied spot, we j--, then until
 * j = 0 and the next empty spot is the desired spot. 
 */