# Recursion

### 46. Permutation
**<font color=#C8A1E6> Permutation; Recursion </font>**

#### [解法一](46-Permutation.cpp)：交换+递归
[参考](https://leetcode.com/problems/permutations/discuss/18247/My-elegant-recursive-C%2B%2B-solution-with-inline-explanation)

任意一个长度为n数组的全排列由n个部分组成：
- A1 + 全排列（A2, ... An)
- A2 + 全排列（A1, A3, ... An)
- ...
- An + 全排列（A1, ... An-1)

因此可以做一个递归函数。每次运算某个数组子段的全排列，首先将第一个字符与之后的一个字符进行交换，然后对第二个字符开始的整个数组调用全排列；在每一次调用全排列之后将数字换回，然后进行下一次另外一个数字的调换。之后完成全部调换和全排列。全排列的base case是当没有剩余数字时，这个时候把当前数组放入ans之中。

```Cpp
class Solution {
public:
    void recPermu(vector<int>& nums, int begin, vector<vector<int>>& ans)
    {
        if (begin == nums.size())
            ans.push_back(nums);
        for (int i = begin; i < nums.size(); ++i)
        {
            swap(nums[begin], nums[i]);
            recPermu(nums, begin + 1, ans);
            swap(nums[begin], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        recPermu(nums, 0, ans);
        return ans;
    }
};
```

#### [解法二](46-Permutation-Iterative.java)：循环

[参考](https://leetcode.com/problems/permutations/discuss/18237/My-AC-simple-iterative-javapython-solution)

为了完成一个全排列，我们可以一个一个插入数字。对于已经插入k个数字的数组，我们有k + 1个位置可以插入新的数字，他们组成了k + 1个新的答案。例如，在插入1和2后，我们有{1, 2} 和 {2, 1}，现在要插入3，对于第一个数组，我们可以有{3, 2, 1}, {2, 3, 1} 和 {2, 1, 3}，而对于第二个，我们可以有{3, 1, 2}, {1, 3, 2} 和 {1, 2, 3}，这些构成了一组新的答案。

因此我们首先在插入第0个数字之后，有1到n - 1的最外层循环，负责剩下所有数字的一一插入。在每层循环内有一个遍历目前所有答案序列的循环，对于每一个答案，我们做0 - k 的循环，在每个位子插入新的数字。由此完成整个全排列。

### 78. Subsets
**<font color=#C8A1E6> Power Set; Recursion </font>**

#### [解法一](78-Subsets/78-Subsets.java)：循环，选择加元素或不加元素

对所有数组里的数字进行一重循环，每次循环针对现在答案组里已经有的数列，我们可以选择把这个元素加入，或者不加入，所以我们对当前的所有数组复制一份，把这个元素加入这些复制的数组里，然后再进入下一个循环。

#### [解法二](78-Subsets/78-Subsets.cpp)：递归

[参考](https://leetcode.com/problems/subsets/solution/)

本质也是选择加这个数字或者不加这个数字。每次得到一个新的数组，我们可以先把这个数组进行存储，接下来我们只考虑当前点后面的数字（不考虑前面的数字，因为已经都考虑过了），我们可以加入这个数字，进入下一次递归，然后退出的时候把数字去除，进入下一个循环，考虑不加这个数字，加后面的数字。这样把所有情况都枚举一遍。