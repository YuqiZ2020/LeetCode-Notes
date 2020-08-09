# Bit Manipulation

### 50 Pow(x, n)
**<font color=#C8A1E6> Recursion; Bit Manipulation</font>**

#### [解法一](50-Pow(x,n)/50-Pow(x,n).java)：二进制Bit Manipulation

[参考](https://leetcode.com/problems/powx-n/discuss/739113/2-Solution-or-Iterative-with-bitwise-operator-or-Recursive)

一个Exponent可以转化成二进制表示，而任何数的二的次方倍都可以通过把这个数不停的平方得到。比如x的9次方就可以表达成x的8次方乘x的1次方，所以我们不停地平方x并根据exponent的bit判断当前位置需不需要进行乘法操作即可。

为了解决Smallest Integer直接换成正数会Overflow的问题，可以先转化成long。

![](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200718222237.png)

#### [解法二](50-Pow(x,n)/50-Pow(x,n)-Recursive.cpp)：递归

[参考](https://leetcode.com/problems/powx-n/discuss/739113/2-Solution-or-Iterative-with-bitwise-operator-or-Recursive)

如果exponent是偶数我们可以把x平方，然后处理对应的exponent / 2，否则我们可以只乘一个x，然后exponent - 1，这样下一层递归就是偶数。Base case就是如果到0就是return 1。如果是负数的话1除以递归调用即可。

另外要额外考虑INT_MIN的情况，否则直接变成正数会Overflow。

### 136. Single Number
**<font color=#C8A1E6> Sort; HashMap; Bit Manipulation; Single Number</font>**

#### [解法一](136-Single-Number/136-Single-Number.java)：排序查找

#### [解法二](136-Single-Number/136-Single-Number.java)：HashSet保存单独数字，与全部总和比较

#### [解法三](136-Single-Number/136-Single-Number-Bit-Manip.java)：Bit Manipulation

[参考](https://leetcode.com/problems/single-number/solution/)

任何一个数字XOR自己都是0，一个数字XOR 0 得到的还是这个数字，所以如果把所有的数字都XOR的话最后得到的结果就是那个想要的Single Number。感觉Bit Manipulation真的很巧妙诶。

### 137. Single Number II
**<font color=#C8A1E6> Bit Manipulation; Single Number</font>**

#### [解法一](137-Single-Number-II.java)：Bit Manipulation

[参考](https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers)

评论区有大神介绍了这种有一个数出现k次，其他数字出现p次 (p % k != 0) 的题的通用解法。本质就是利用bit manipulation和结合律和交换律。[136.](136-Single-Number/136-Single-Number-Bit-Manip.java) Single Number中的情况，我们只需要一个counter，是因为k等于2，而2的表现形式就是00, 01, 10，而且2正好是2的次方数，所以最后XOR会把出现次数为2的数字都去除成0。

计数器可以看做是32位数每一位的记录，拼起来就是一整个数。

实际上我们需要m个，m > log2k（对应二进制的表达数量），接下来x1每次直接XOR这个数字，但是改动x2只在x1有记录的时候改，改动x3只在x2和x1均有记录的情况下改动，以此类推（类似二进制进位）。

同时我们需要一个mask，如果m不是正好是log2k的话，我们需要手动把计数器设置回0。当且仅当计数器的数量刚好是k个的时候mask需要把所有的数都调整回0。因此mask是~(?x1 & ?x2 & ?x3 ……)，每个bit前面的符号跟随k的二进制表示。这样任何有一个技术器的表达不符合k的二进制表示的时候，mask就会是1，全部符合的时候mask就是0。

这个题目里m是3，因此需要mask，且需要x1和x2。

这里有一个简单的例子（经过了排序，因为我们知道operations都是可以交换顺序的，就像排序了一样）。

![](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200707173535.png)

---

### 190. Reverse Bits
**<font color=#C8A1E6> Bit Manipulation</font>**

#### [解法一](190-Reverse-Bits.java)：移动Bits

[参考](https://leetcode.com/articles/reverse-bits/)

其实就是一一把n右边的bits推进另一个数字里。具体的方法是建立一个数字ans，然后ans每次都左移，先假设新的这个bit是1。然后用n & 1得到n最右边的bit，用 | 来确定ans最右边的bit应该是什么，也不会改动前面的bit。然后n继续右移即可，因为是判断最右边的bit。

#### 解法二：Integer.reverse(n)

[参考](https://leetcode.com/problems/reverse-bits/discuss/732133/Two-Solution-or-Bitwise-Operators-or-1-Liner-or-Detailed-Explanation)

---

### 231. Power of Two
**<font color=#C8A1E6> Bit Manipulation</font>**

#### [解法一](231-Power-of-Two/231-Power-of-Two.java)：不断除以2

#### [解法二](231-Power-of-Two/231-Power-of-Two-Binary.java)：Bit Manipulation

[参考](https://leetcode.com/problems/power-of-two/discuss/63974/Using-nand(n-1)-trick)

任何2的次方都有一个特点就是2进制是1开头后面全是0，而且这个数减去1得到的数的2进制肯定全是1，且比原来的数少一位。所以如果对两个数取&的话肯定能得到0。

---

### 260. Single Number III
**<font color=#C8A1E6> Bit Manipulation</font>**

#### [解法一](260-Single-Number-III.java)：先XOR再分类

因为XOR可以去掉重复的所有其他数字，最后会留下n1 XOR n2，我们要想办法把两个数区分开来。这个数中的某个1肯定是来自两个数中的一个，不会来自同一个，所以我们可以用 storage &= -storage来留下最右边的1。接下来的分类方法就是看数字有没有这个1，有的分一组，没有的分另一组，最后两个组里剩下的就是两个数字。

![graph](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200724170603.png)

---

### 437. Path Sum III
**<font color=#C8A1E6> Bit Manipulation; Math</font>**

#### [解法一](342-Power-of-Four/342-Power-of-Four.java)：确定2的次方，根据1出现的位置判断是否为4的次方

[参考](https://leetcode.com/problems/power-of-four/discuss/80457/Java-1-line-(cheating-for-the-purpose-of-not-using-loops))

首先可以用 [231.](231-Power-of-Two/231-Power-of-Two-Binary.java) Power of Two 的方法来确定是否是2的次方，所以这个数肯定只有一个1其他都是0。接下来就是看1出现在哪里，1只能出现在4，16，64…… 等等位置，所以我们可以用1010……1010和这个数进行AND操作，看看是否还是原来的数字，如果是的话就是4的次方。

#### [解法二](342-Power-of-Four/342-Power-of-Four.cpp)：三的倍数

[参考](https://leetcode.com/problems/power-of-four/discuss/80460/1-line-C%2B%2B-solution-without-confusing-bit-manipulations)

确定2的次方的方法是一样的，另外我们可以知道当且仅当这个数也是3的倍数的时候，他也是4的次方。

$4^n = (2^n + 1)(2^n - 1)$

三个连续整数中至少有一个是三的倍数 $2^n$不是三的倍数，所以以上两个数字中必有一个是三的倍数，所以整个数字一定是三的倍数。

---

### 461. Hamming Distance
**<font color=#C8A1E6>Bit Manipulation</font>**

#### [解法一](461-Hamming-Distance/461-Hamming-Distance.java)：XOR转二进制字符串数1的数量

#### [解法二](461-Hamming-Distance/461-Hamming-Distance.cpp)：XOR用t & (t - 1) 数1的数量