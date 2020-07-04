/**
 * Problem 957: Prison Cells After N Days
 * Prompt: There are 8 prison cells in a row, and each cell is either 
 * occupied or vacant.
 * Each day, whether the cell is occupied or vacant changes according 
 * to the following rules:
 * If a cell has two adjacent neighbors that are both occupied or both 
 * vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells 
 * in the row can't have two adjacent neighbors.)
 * We describe the current state of the prison in the following way: 
 * cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 * Given the initial state of the prison, return the state of the prison
 * after N days (and N such changes described above.)
 * Date: 07/03/2020
 */
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, Integer> states= new HashMap<>();
        boolean flag = false;
        while (N > 0)
        {
            states.put(Arrays.toString(cells), N--);
            int[] temp = new int[8];
            temp[0] = 0; temp[7] = 0;
            for (int j = 1; j < 7; ++j)
            {
                if (cells[j - 1] == cells[j + 1])
                    temp[j] = 1;
                else
                    temp[j] = 0;
            }
            cells = temp;
            if (flag)
                continue;
            String s = Arrays.toString(cells);
            if (states.containsKey(s))
            {
                int st = states.get(s);
                N = N % (st - N);
                flag = true;
            }
        }
        return cells;
    }
}

/**
 * Notes: The simple solution would have TLE so we would need
 * to find the cycle in the states. We could store the condition
 * in a string and store the index of it. Then if we find a 
 * similiar one we can skip the repetitive steps in between and 
 * go to the final one. 
 */