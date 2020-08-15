/**
 * Problem 119: Pascal's Triangle II
 * Prompt: Given a non-negative index k where k ≤ 33, 
 * return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i <= rowIndex / 2; ++i)
        {
            long cur = 1;
            for (int j = 1; j <= i; ++j)
                cur = cur * (rowIndex - j + 1) / j;
            ans.add((int) cur);
        }
        int t = ans.size() - 1;
        if (rowIndex % 2 == 0)
            t--;
        for (int i = t; i >= 0; i--)
            ans.add(ans.get(i));
        return ans;
    }
}

/**
 * Notes: Each row of the triangle is symmetric, so we just
 * generate the first half. When generating the first half
 * we need to do the multiplication and division together
 * to avoid overflow. The number of multiplication and division
 * is the same, and we do division from 1 to i and multiplication
 * from rowIndex to (rowIndex - i + 1). 
 */