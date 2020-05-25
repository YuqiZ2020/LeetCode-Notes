# Graphs & Search

## Graphs
### 997. Find the Town Judge
**<font color=#C8A1E6> HashMap; Vertex Degree </font>**
>In a town, there are N people labelled from 1 to N. There is a rumor that one of these people is secretly the town judge.
>
>If the town judge exists, then:
> - The town judge trusts nobody.
> - Everybody (except for the town judge) trusts the town judge. 
> - There is exactly one person that satisfies properties 1 and 2.
>
> You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.If the town judge exists and can be identified, return the label of the town judge. Otherwise, return -1.

#### [解法一](997-Find-the-Town-Judge/997-Find-the-Town-Judge.java)：HashMap
用HashMap保存每个人被他人信任的情况，每个人的编号即为一个Key，值使用ArrayList，一旦遇到有人信任这个人就加入ArrayList并在HashMap中更新。遍历所有编号，如果某个人对应的ArrayList长度是N - 1，则这个人有可能是Town Judge。

但对于此人还需检查他是否出现在别人对应的ArrayList中。

![图示](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200521205638.png)

#### [解法二](997-Find-the-Town-Judge/997-Find-the-Town-Judge-Graph-Degree.java)：Graph Vertex Degrees
[参考](https://leetcode.com/problems/find-the-town-judge/discuss/242938/JavaC%2B%2BPython-Directed-Graph)

可以把这道题目想象成一张有向图，对于每个人（结点），如果有人（结点）信任他则将两个结点相连，信任者指向被信任者。最终

每个结点的度数 = 指向其的边 - 其指向外的边

如果有结点度数为N - 1，则是Town Judge

![图示](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200521205729.png)

``` Java
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] ans = new int[N + 1];
        for (int i = 0; i < trust.length; ++i)
        {
            ans[trust[i][1]]++;
            ans[trust[i][0]]--;
        }
        for (int i = 1; i <= N; ++i)
        {
            if (ans[i] == N - 1)
                return i;
        }
        return -1;
    }
}
```

---

### 1457. Pseudo-Palindromic Paths in a Binary Tree
#### 解法一：Recursion
给定中序遍历的数组，则任意这样一个数组或是表达一个子树的数组都有第一个点为根节点，剩下分成两部分，前一部分组成左子树，后一部分组成右子树。

另外根据二分查找树的性质，左子树中所有结点必定小于根节点数值，右子树中所有结点必定小于
![图示](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200524225500.png)

---

## Search

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
