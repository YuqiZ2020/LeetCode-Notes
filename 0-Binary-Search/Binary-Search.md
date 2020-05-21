<font face="微软雅黑">

## Binary Search
### 540. Single Element in a Sorted Array
### 136. Single Number
#### 解法一：顺序查找
_时间复杂度：$O(n)$_
_空间复杂度：$O(1)$_

找第一个和后一位不一样的数字，或是在最后一位落单的数字

#### 解法二：二分查找
1. 当mid为偶数且下一位和mid位数字相同或
   mid为奇数且下一位和mid不同

   此时target在左侧

2. 其他情况

    此时target在右侧/当前位置

</font>