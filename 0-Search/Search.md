# Search

## <font color=#7F71D9>DFS: </font>

### 230. Kth Smallest Element in a BST

>Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

![图例](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200523164355.png)
#### [解法一](230-Kth-Smallest-Element-in-a-BST.java)：DFS
_时间复杂度：O(n)； 空间复杂度：O(1)_
对于任意结点在所有结点中的排序号，
1. 如果该结点有Left Child，则需要加上Left Child的排序值
2. 如果该结点有Parent Node，则需要加上Parent Node的排序值
3. 之后再给结果加1得到该点的序号
注意：这里结点的值也指以这个结点为根的整个子树的排序值

当我们每到达一个点的时候，我们需要知道前置点Parent Node的排序值，因此需要prev参数。同时我们也要把这个点的排序值送给下一个结点。

为了知道Left Child的值，我们先对Left Child进行DFS，需要pass in 从上一个点得到的prev，将返回的值加上1之后得到这个点的值，与k进行比较，如果和k相等则存入ans中。继续Right Child的查找，需要将这个结点的值作为prev传递给接下来的搜索中。

最终遍历整棵树得到结果。

``` Java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        dfs(root, k, 0, ans);
        return ans[0];
    }
    public int dfs(TreeNode root, int k, int prev, int ans[])
    {
        if (root == null)
            return t;      
        int cur = dfs(root.left, k, prev, ans) + 1;
        if (k == cur)
            ans[0] = root.val;
        return dfs(root.right, k, cur, ans);
    }
}
```