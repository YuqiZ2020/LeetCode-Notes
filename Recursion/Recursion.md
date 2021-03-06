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

### 140. Word Break II
**<font color=#C8A1E6> HashMap; Recursion </font>**

#### [解法一](140-Word-Break-II.java)：递归并用map保存结果

[参考](https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS)

直接DFS会超时，所以用空间换时间每次检索的时候在HashMap里面保存答案，下次遇到一样的直接输出即可。搜索的过程中不能按照前缀一个一个搜索，会很慢，应该直接查找字典里面有没有单词是这个字符串的前缀，如果有的话进行下一步查找，最后合并答案，保存，输出。没有的话可以直接不操作（或者已经到字符串尾端了也不用操作），这样还做了剪枝。

其实总的来说也是个比较简单的算法，主要是细节要注意节省时间。


### 1286. Iterator for Combination
**<font color=#C8A1E6> Combination; Recursion </font>**

#### [解法一](1286-Iterator-for-Combination.java)：从前往后选择字母

因为是按字典序生成组合，所以从前往后选择字母，先将单词排序。一旦我们选择了一个字母就不能再选这个字母之前的字母，所以当前情况的循环只能从开始点一直到最后一个可能的点（不能太往后否则后面没法剩下足够的数字）。循环将放入 ```String Builder``` 之后，再次调用这个函数，然后把字母删掉，继续下一层循环。Base case是当 ```String Builder``` 里的长度等于需要的长度时，组成字符串并加入Array List之中。

调用查询的时候用一个 ```index``` 来确定当前的位置以及是否后续还有字符串。