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

注意：这里结点的值也指**以这个结点为根的整个子树**的排序值。

![图示](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200523190944.png)

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

---

### 733. Flood Fill
#### [解法一](733-Flood-Fill.java)：DFS
对于每个点，只要这个点的颜色符合要求就对上下左右四个方向进行染色，因为被染色的格子的颜色已经有变化，所以不会出现重复染色的情况。但是要注意如果初始点和要被染色的颜色一样，就不进行操作，否则会死循环。

---

### 993 Cousins in Binary Tree
#### [解法一](993-Cousins-in-Binary-Tree/993-Cousins-in-Binary-Tree.cpp)：分步DFS
首先对于两个给定的点先分别数深度。数深度的时候，如果找到该点，则返回0，如果已经走到尽头则返回-300（因为题目设定的树的深度肯定小于300）之后返回的值应该是左子树搜索值和又子树搜索值中更大的那个加1，即为该点的深度。

其次对于搜索得到的确定深度一样的点，再次判断他们是否来自同一个Parent。直接成对搜索，如果一个点左右子树都存在且值符合给的两个值，说明两个值来自同一个Parent。
1. 如果该点的Left Child和Right Child都存在，则进行数值比较，如果不成功则分别向左和向右搜索，只要两者有其一返回True则True，否则False。
2. 如果只有Left或Right Child存在，对这个方向进行搜索。
3. 否则返回False。

#### [解法二](993-Cousins-in-Binary-Tree/993-Cousins-in-Binary-Tree-DFS.cpp)：直接DFS

这个过程可以简化到直接用一个DFS完成。多Pass in两个parameter，一个记录depth，一个记录parent，只要查找到了题目给定的点就把这两个信息储存下来，最后在主程序中进行比较。

---
