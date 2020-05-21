<font face="微软雅黑">

## Arrays
### 1. Two Sums
**<font color=#C8A1E6> HashMap </font>** 

#### 解法一：二重循环遍历查找
_时间复杂度：$O(n^2)$_  
_空间复杂度：$O(1)$_

#### 解法二：HashMap保存Complement值
_时间复杂度：$O(n)$_  
_空间复杂度：$O(n)$_

---

### 26. Remove Duplicates From Sorted Array
**<font color=#C8A1E6> Two Pointers; In-place Modification </font>** 
#### 解法一：Three Pointers
一个pointer从 0 ~ nums.length 进行写入，两个pointer在前方不短寻找一个一个数字区间，当找到新区间或走到终点时让第一个pointer将旧区间的值写入。

#### 解法二：Two Pointers
可将此解法化简为两个pointers，一个读入一个写入。因为负责写入的pointer已经存储了数字，读入的pointer可以通过这个存储确定是否已经进入了新的数字区间，从而让第一个pointer继续写入。

---

### 27. Remove Element
**<font color=#C8A1E6> Two Pointers; In-place Modification </font>** 
#### 解法一：死算
用循环进行数字移位

#### 解法二：Two Pointers
读入pointer碰到val则跳过，否则让写入pointer写入该值。

### 88. Merge Sorted Array
**<font color=#C8A1E6> Two Pointers </font>** 

>Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
>**Note:**
>The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
>**Example:**
Input:
$nums1 = [1,2,3,0,0,0],　m = 3$
$nums2 = [2,5,6],　　　　n = 3$
Output: 
$[1,2,2,3,5,6]$
#### 解法一：死算
用循环进行数字移位

#### 解法二：Three Pointers 
[参考](https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/627921/Java-or-C%2B%2B-or-Python3-or-Easy-explanation-or-O(logn)-or-O(1))

2个pointer分别在两个数组的前方读取，一个pointer在num1里进行写入，每次写入时判断，先写小的那个。
``` Java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1;
        int cur2 = n - 1;
        int curf = m + n - 1;
        while (cur1 >= 0 && cur2 >= 0)
        {
            if (nums1[cur1] < nums2[cur2])
            {
                nums1[curf] = nums2[cur2];
                curf--;
                cur2--;
            }
            else
            {
                nums1[curf] = nums1[cur1];
                curf--;
                cur1--;
            }   
        }
        while (cur1 >= 0)
            nums1[curf--] = nums1[cur1--];
        while (cur2 >= 0)
            nums1[curf--] = nums2[cur2--];
    }
}
```

---

### 1089. Duplicate Zeros
**<font color=#C8A1E6> Two Pointers </font>** 
#### 解法一：死算
用循环进行数字移位
#### 解法二：Two Pointers
参考：不知道参考的谁的代码，很难读懂……

通过遍历查找数组中0的数量来确定数字需要移动多少位。从后往前进行写入覆盖。

假定数组可以无限长，则写入pointer从数组的理论最长位置（加上复制的0之后）开始，读入pointer从真实长度位置开始，一旦遇到0则让写入pointer多写一位。

写入pointer一直在移动，但是仅当进入数组真实长度位置后才开始正式写入。
``` Cpp
class Solution {
public:
    void duplicateZeros(vector<int>& A) {
        int n = A.size(), j = n + count(A.begin(), A.end(), 0);
        for (int i = n - 1; i >= 0; --i) {
            if (--j < n)
                A[j] = A[i];
            if (A[i] == 0 && --j < n)
                A[j] = 0;
        }
    }
};
```

---

### 941. Valid Mountain Array
</font>