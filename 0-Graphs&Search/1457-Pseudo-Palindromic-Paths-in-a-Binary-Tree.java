/**
 * Problem 1457: Pseudo-Palindromic Paths in a Binary Tree
 * Prompt: Given a binary tree where node values are digits from 
 * 1 to 9. A path in the binary tree is said to be 
 * pseudo-palindromic if at least one permutation of the node 
 * values in the path is a palindrome.
 * Return the number of pseudo-palindromic paths going 
 * from the root node to leaf nodes.
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] ans = new int[1];
        Stack<Integer> stackT = new Stack<Integer>();
        dfs(root, stackT, ans);
        return ans[0];
    }
    public boolean checkPali(int[] arr)
    {
        int num[] = new int[10];
        for (int i = 0; i < arr.length; ++i)
            num[arr[i]]++;
        int flag = 0;
        for (int i = 0; i < 10; ++i)
        {
            if (num[i] % 2 == 1)
                flag++;
        }
        if (flag == 0)
            return true;
        if (arr.length % 2 != 0 && flag == 1)
            return true;
        return false;
    }
    public void dfs(TreeNode root, Stack<Integer> st, int[] ans)
    {
        st.push(root.val);
        if (root.left == null && root.right == null)
        {
            if (!st.isEmpty()) 
            {
                Object arr[] = st.toArray();
                int brr[] = new int[arr.length];
                for (int i = 0; i < arr.length; ++i)
                    brr[i] = (int) arr[i];
                if (checkPali(brr))
                    ans[0]++;
                st.pop();
            }
            return;
        }
        if (root.left != null)
            dfs(root.left, st, ans);
        if (root.right != null)
            dfs(root.right, st, ans);
        if (!st.isEmpty())
            st.pop();
    }
}

/**
 * Notes: Use stack to record the values meet in dfs. 
 * When get to the end node, turn the stack into an 
 * array and check if it is a pseudo-palindrome. 
 * 
 * To check, just make sure that only array with odd
 * length can have one odd occurance of number, 
 * otherwise can only have even occurance of number. 
 */