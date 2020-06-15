## Binary Search

### 35. Search Insert Position

#### [解法一](35-Search-Insert-Position.java)：二分查找
_时间复杂度：O(log(n))； 空间复杂度：O(1)_

直接二分查找，建立左闭右开的区间，这样区间内所有的数字都是有可能的，最后当左边和右边的边界到达同一个位置的时候区间的大小为0，这个时候返回low（或者high）即可，如果查找到了则是这个数字，否则就是需要插入的位置。


### 136. Single Number
### 540. Single Element in a Sorted Array

#### [解法一](540-Single-Element-in-a-Sorted-Array/540-Single-Element-in-a-Sorted-Array.java)：顺序查找
_时间复杂度：O(n)； 空间复杂度：O(1)_

找第一个和后一位不一样的数字，或是在最后一位落单的数字

#### [解法二](540-Single-Element-in-a-Sorted-Array/540-Single-Element-in-a-Sorted-Array-Binary-Search.java)：二分查找
_时间复杂度：O(log(n))； 空间复杂度：O(1)_

1. 当mid为偶数且下一位和mid位数字相同或
   mid为奇数且下一位和mid不同

   此时target在左侧

2. 其他情况

    此时target在右侧/当前位置

---

### 278. First Bad Version
#### [解法一](278-First-Bad-Version.java)：二分查找
_时间复杂度：O(log(n))； 空间复杂度：O(1)_

二分查找，如果当前找到的点是Bad Version，则往前找，否则往后找（包括当前这个）。最后当左侧pointer大于等于右侧pointer时，返回左侧pointer所指的值。

建立一个左闭右开区间，最后当区间大小为0（即left == right）的时候，判定找到了，返回left或right皆可。

### 528. Random Pick with Weight
#### [解法一](528-Random-Pick-with-Weight/528-Random-Pick-with-Weights-Binary-Search.java)：累积概率 + 二分查找

[参考](https://leetcode.com/problems/random-pick-with-weight/discuss/154044/Java-accumulated-freq-sum-and-binary-search)

因为需要每个物品被选择的概率和重量相同，但是想要让物品的权重有规律且不需要被存储，那么可以用累积概率的方式，计算整个数组的累积概率分布，这样的话整个数组是升序排列的且每两个数字之间的间隔的大小就是后一个数字被选中的权重。

![](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200615110855.png)

得到随机数之后，需要找最前面的一个累积和大于这个数值的数组Index，这个Index对应的数就是被选中的数字。

#### [解法二](528-Random-Pick-with-Weight/528-Random-Pick-with-Weight.java)：累积概率 + 顺序查找

用顺序查找来找到指定的数字。