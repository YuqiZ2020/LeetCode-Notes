class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = (N - 1) % 14 + 1;
        for (int i = 1; i <= N; ++i)
        {
            int[] temp = new int[8];
            for (int j = 1; j < 7; ++j)
            {
                if (cells[j - 1] == cells[j + 1])
                    temp[j] = 1;
                else
                    temp[j] = 0;
            }
            cells = temp;
        }
        return cells;
    }
}

/**
 * Notes: 
 * We note that cell 1 and 8 will not change after the first day, 
 * and that cell 2, 4, 6 would determine cell 3, 5, 7 for the next
 * day and vice versa. Then we would realize that cell 2, 4, 6
 * will determine the values for themselves after two days. This
 * pattern is same for cell 3, 5, 7. So we have 3 bits to alter
 * and two days a cycle. 2^3 is 8 and we could have a max 16 steps
 * for a cycle. Then with trial and error we found that the cycle
 * is 14. 
 */