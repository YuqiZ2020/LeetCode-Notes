## Binary Search

### 35. Search Insert Position

#### [解法一](35-Search-Insert-Position.java)：二分查找
_时间复杂度：O(log(n))； 空间复杂度：O(1)_

直接二分查找，建立左闭右开的区间，这样区间内所有的数字都是有可能的，最后当左边和右边的边界到达同一个位置的时候区间的大小为0，这个时候返回low（或者high）即可，如果查找到了则是这个数字，否则就是需要插入的位置。

---

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

#### 解法三：XOR
_时间复杂度：O(n)； 空间复杂度：O(1)_

[参考](https://leetcode.com/problems/single-number/discuss/42997/My-O(n)-solution-using-XOR)

将所有的数字一起异或，相同的数字经过异或会变成零，最后留下的就是落单的数字

```Java
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++)
		    ans = ans ^ nums[i];
	    return ans;
    }
}
```

---

### 154. Find Minimum in Rotated Sorted Array II

#### [解法一](154-Find-Minimum-in-Rotated-Sorted-Array-II.java)：二分查找分三类

一共有两种情况，一种是中间某点有置换位置，另一种是完全没有置换位置。如果没有置换位置的话可以分两种情况，如果中间点比右边小则说明可以往左找（包括当前点），否则往右边找（不包括当前点，因为当前点比右边的大或者相等）。

但是如果中间有置换位置，则发现在两数相等的情况下需要往左找，和上一种情况中的往右找相矛盾。所以只能确定的是可以把右侧边界前移（因为前面有和这个数相同的数，所以这个数可以省去）。

![图解](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200725203018.png)

---
### 274. H-Index    
### 275. H-Index-II
#### [解法一](275-H-Index-II.java)：二分查找
_时间复杂度：O(log(n))； 空间复杂度：O(1)_

二分查找，比较当前点所代表的paper数量（len - mid，因为需要计算这张加上后面一共有多少paper）是否大于等于这个paper的citation数量。制作一个左开右闭区间。

1. 如果当前点的citation数量和paper数量一样，说明这个就是我们要找的值。例如一个人有四张paper的citation数量都大于等于4，再加paper也不可能有多的citation数量为5的paper。
2. 如果当前点的citation数量大于paper数量，说明还需要往前面找，就把high挪到当前mid
3. 否则因为1和2已经排除，说明这个点也不是正确答案，把low挪到mid + 1

---

### 278. First Bad Version
#### [解法一](278-First-Bad-Version.java)：二分查找
_时间复杂度：O(log(n))； 空间复杂度：O(1)_

二分查找，如果当前找到的点是Bad Version，则往前找，否则往后找（包括当前这个）。最后当左侧pointer大于等于右侧pointer时，返回左侧pointer所指的值。

建立一个左闭右开区间，最后当区间大小为0（即left == right）的时候，判定找到了，返回left或right皆可。

---

### 528. Random Pick with Weight
#### [解法一](528-Random-Pick-with-Weight/528-Random-Pick-with-Weights-Binary-Search.java)：累积概率 + 二分查找

[参考](https://leetcode.com/problems/random-pick-with-weight/discuss/154044/Java-accumulated-freq-sum-and-binary-search)

因为需要每个物品被选择的概率和重量相同，但是想要让物品的权重有规律且不需要被存储，那么可以用累积概率的方式，计算整个数组的累积概率分布，这样的话整个数组是升序排列的且每两个数字之间的间隔的大小就是后一个数字被选中的权重。

![](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200615110855.png)

得到随机数之后，需要找最前面的一个累积和大于等于这个数值的数组Index，这个Index对应的数就是被选中的数字。使用二分查找，建立左闭右开区间，如果找到的数比随机数要小，那low = mid + 1（因为这个数是错的，不需要再考虑）， 否则将high挪到mid处。有可能是等于（这个时候其实需要选择low，但是挪动high到此处也可以，因为最后high和low会相遇）。

#### [解法二](528-Random-Pick-with-Weight/528-Random-Pick-with-Weight.java)：累积概率 + 顺序查找

用顺序查找来找到指定的数字。

---

### 1482. Minimum Number of Days to Make m Bouquets

#### 解法一：对天数进行二分查找

[参考](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/discuss/686316/JavaC%2B%2BPython-Binary-Search)

给定一个确定的天数，我们就可以计算出连续的花开情况，从而算出最多能得到的花束的数量。因此如果我们发现花束少了我们就可以到右侧的搜索区间，否则去左侧的搜索区间。直到最后左闭右开区间的两个指针汇合为止。