# Sort：

### 75. Sort Colors
**<font color=#C8A1E6> Sort; Three Pointers </font>** 

>Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
>
>Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

#### 解法一：Three Pointers交换排序
[参考](https://leetcode.com/problems/sort-colors/discuss/26474/Sharing-C%2B%2B-solution-with-Good-Explanation)

设置三个Pointers，low，mid和high，low和mid从头开始，high从尾开始。mid遇到的数字可能有三种情况：

1. 遇到2，则和high交换，这个时候high--，high之后的所有数字都是2（如第二步）
2. 遇到0，则和low交换，这个时候low++，low之前所有的数字都是0，同时mid++，这是因为我们确定mid交换过来的数字只可能是1，因为**2已经在mid来的路上被处理过了**（如第四步）
3. 遇到1，直接mid++

这样最后当mid超过high的时候数列就处理完了，注意当mid和high相遇的时候还需要一步操作，因为我们只知道high之后的数字都是2，而不知道当前数字的情况，所以还需要一次判断。

![](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200614093810.png)

```Java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high)
        {
            if (nums[mid] == 0)
            {
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            }
            else if (nums[mid] == 2)
            {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
            else
                mid++;
        }
    }
}
```

---

### [169.](169-Majority-Element/169-Majority-Element-Sort.java) Majority Element
**<font color=#C8A1E6> Sort; HashMap </font>**

---

### 969. Pancake Sorting
**<font color=#C8A1E6> Sort; HashMap </font>**

#### [解法一](969-Pancake-Sorting.class)：记录每个数字的位置，从大到小一一翻转

因为题目说了只包含 ```1 - A.length``` 的数字，所以可以另外建立一个数组用于存储每个数字的位置。然后从大到小一一查找每个数字的位置，如果位置不符合，则先把这个数字翻转到最前面，然后把这个数字翻转到需要的位置，从后往前依次处理。

![图示](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200829170444.png)

---

### 973. K Closest Points to Origin
**<font color=#C8A1E6> Sort; Map </font>**

#### [解法一](973-K-Closest-Points-to-Origin/973-K-Closest-Points-to-Origin.cpp)：Map排序
将每个点距离远点的距离计算后作为Map的Key，对应的数值是距离为这个Key的所有点的index组成的vector。因为Map是自动排序的，最后只要按顺序直接输出前K个点即可。

#### [解法二](973-K-Closest-Points-to-Origin/973-K-Closest-Points-to-Origin-Sort.java)：Distance排序后输出
计算所有的Distance之后排序得到第K位的点的距离。之后再循环遍历所有的点把Distance小于等于这个距离的所有点输出。

---

### 977. Squares of a Sorted Array
**<font color=#C8A1E6> Sort; Two Pointers </font>**
#### 解法一：直接平方后重新排序
_时间复杂度：O(nlogn)； 空间复杂度：O(1)_

#### 解法二：Two Pointers，存储进新数组
[参考](https://leetcode.com/problems/squares-of-a-sorted-array/solution/)

_时间复杂度：O(n)； 空间复杂度：O(n)_

---

### [1051.](1051-Height-Checker.java) Height Checker
**<font color=#C8A1E6> Sort </font>**

---

### 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
**<font color=#C8A1E6> Sort; Find biggest num </font>**

#### [解法一]((1465-Maximum-Area-of-a-Piece-of-Cake-After-Horizontal-and-Vertical-Cuts.java))：排序+找最大值
首先排序，然后对于横向和纵向数组，分别找最大的间距，包括和0以及和最大边界的间距。最后两个最大值相乘。**相乘时注意分别对1000000007取余再对结果取余**，否则会溢出。

---

### 1481. Least Number of Unique Integers after K Removals
**<font color=#C8A1E6> Sort; HashMap; Greedy </font>**

#### [解法一](1481-Least-Number-of-Unique-Integers-after-K-Removals/1481-Least-Number-of-Unique-Integers-after-K-Removals.cpp)：Bucket Sort从较低出现频率的数字开始去除

因为需要最后Unique的Number最少，所以可以从出现频率最低的数字开始一个一个去除，直到不能再去除位置。可以用HashMap来保存每个数字出现的频率，再把所有频率排序（用C++的Map自动排序），然后从频率低到高一个一个减少数字，最后看还剩多少特殊的数字即可。

#### [解法二](1481-Least-Number-of-Unique-Integers-after-K-Removals/1481-Least-Number-of-Unique-Integers-after-K-Removals.java)：直接排序

[参考](https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/discuss/686376/Simple-C%2B%2B-O(N-log-N)-VIDEO-SOL)

直接在记录频率的过程中把某出现频率对应的数字存进一个数组中，将数组排序，最后从低到高进行处理即可。

---

### 1502. Can Make Arithmetic Progression From Sequence
**<font color=#C8A1E6> Sort </font>**

---

### 1509. Minimum Difference Between Largest and Smallest Value in Three Moves

#### [解法一](1509-Minimum-Difference-Between-Largest-and-Smallest-Value-in-Three-Moves.java)：排序选择最大最小

又是一道只要想清楚就非常简单的题目。因为我们改变数字其实相当于在求最大最小差值的过程中把这个数字去掉。所以我们永远是在改动最大或者最小的数字。因此经过排序之后我们只有四种可能性，分别关于如何删除数字。3 - 0， 2 - 1， 1 - 2， 0 - 3，一共四种情况，枚举选择最佳即可。