# Bit Manipulation

### 136. Single Number
**<font color=#C8A1E6> Sort; HashMap; Bit Manipulation</font>**

#### [解法一](136-Single-Number/136-Single-Number.java)：排序查找

#### [解法二](136-Single-Number/136-Single-Number.java)：HashSet保存单独数字，与全部总和比较

#### [解法三](136-Single-Number/136-Single-Number-Bit-Manip.java)：Bit Manipulation

[参考](https://leetcode.com/problems/single-number/solution/)

任何一个数字XOR自己都是0，一个数字XOR 0 得到的还是这个数字，所以如果把所有的数字都XOR的话最后得到的结果就是那个想要的Single Number。感觉Bit Manipulation真的很巧妙诶。

### 137. 

### 231. Power of Two

#### [解法一](231-Power-of-Two/231-Power-of-Two.java)：不断除以2

#### [解法二](231-Power-of-Two/231-Power-of-Two-Binary.java)：Bit Manipulation

[参考](https://leetcode.com/problems/power-of-two/discuss/63974/Using-nand(n-1)-trick)

任何2的次方都有一个特点就是2进制是1开头后面全是0，而且这个数减去1得到的数的2进制肯定全是1，且比原来的数少一位。所以如果对两个数取&的话肯定能得到0。
