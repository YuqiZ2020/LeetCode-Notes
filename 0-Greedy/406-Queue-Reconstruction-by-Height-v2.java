class Solution {
    private static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() 
        {  
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
 
            if (entry1[col] < entry2[col]) 
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
        sortbyColumn(people, 0);
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < len; ++i)
            ans.add(people[i][1], people[i]);
        return ans.toArray(new int[len][]);
    }
}

/**
 * Notes: Since once position hint would only depend on
 * how many people in front of him are higher than him, if 
 * we positioned all the people that is higher than him, 
 * than this person can be inserted directly based on his
 * position hint. 
 * Therefore starting from the highest person with smallest
 * index value we insert them based on the index. 
 */