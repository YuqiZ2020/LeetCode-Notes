/**
 * Problem 1008: Construct Binary Search Tree from Preorder Traversal
 * Prompt: Return the root node of a binary search 
 * tree that matches the given preorder traversal.
 * Date: 05/24/2020
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstHelper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode bstHelper(int[] arr, int st, int ed)
    {
        int val = arr[st];
        TreeNode root = new TreeNode(val);
        int i = st + 1;
        while (i <= ed && arr[i] < val)
            i++;
        if (st + 1 <= i - 1)
            root.left = bstHelper(arr, st + 1, i - 1);
        if (i <= ed)
            root.right = bstHelper(arr, i, ed);
        return root;
    }
}

/**
 * Notes: Preorder traversal is the one that visits root, left child and 
 * then right child.
 * For any given array (or portion of array that represents some bst), 
 * the first element is always the root. The following elements can be 
 * split into two parts: elements that form the left subtree, and the 
 * elements that form the right subtree. Left subtrees elements always 
 * come before right subtree elements, and the property of bst also tells 
 * us that any elements in the left subtree will always be smaller 
 * than the root.
 * Therefore we can iterate through the array to find the first element 
 * that is larger than the root value, which will tell us the split between 
 * left subtree element and right subtree element. Then we can construct 
 * the left and right subtrees by recursively calling the function for 
 * the corresponding subarray.
 */