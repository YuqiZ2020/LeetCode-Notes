# Strings

### 7. Reverse Integer
**<font color=#C8A1E6> Reverse String </font>**
#### [解法一](7-Reverse-Integer.java)：一重 For 循环反向重组
---

### 151. Reverse Words in a String
**<font color=#C8A1E6> Reverse String </font>**

#### 解法一：split和trim
首先题目要求用空格分割字符串，但是会有多个空格，所以可以用特殊的Split函数格式 ```s.split("\\s{1,}");``` 一个及以上的空格都可以。最后字符尾部可能会有额外空格，用trim()去除即可。

### 392. Is Subsequence
**<font color=#C8A1E6> DP; Two Pointers </font>**

#### [解法一](392-Is-Subsequence/392-Is-Subsequence.java)：动态规划
状态定义：对于dp[i][j]，定义其为字符串s从0到i的子串是否是字符串t从0到j的子串的Subsequence。

初始化：首先判断s的第一个字符是否是t的子串的Subsequence，初始化dp数组第一行；dp数组的第一列除了dp[0][0] 其他必定是0.

状态转移方程式：
1. 如果s从0到i的子串是t从0到j - 1的子串的Subsequence，那么可以确定s从0到i的子串是t从0到j的子串的Subsequence
2. 如果不是，但是s从0到i - 1的子串是t从0到j - 1的子串的Subsequence，且s[i] == t[j]，那么也可以确定s从0到i的子串是t从0到j的子串的Subsequence

因此，

```Java
if (dp[i][j - 1])
    dp[i][j] = true;
else if (s.charAt(i) == t.charAt(j))
    dp[i][j] = dp[i - 1][j - 1];
```

#### [解法二](392-Is-Subsequence/392-Is-Subsequence-Two-Pointers.java)：Two Pointers

[参考](https://leetcode.com/problems/is-subsequence/discuss/87254/Straight-forward-Java-simple-solution)

s字符串一个Pointer，t字符串一个Pointer，t的Pointer不断向前直到达到尾端。s的pointer只有当在t中找到对应字符才前移。一旦s移到尾端则说明是符合条件的Subsequence，否则不是。

---

### 451. Sort Characters By Frequency
**<font color=#C8A1E6> HashMap; Bucket Sort </font>**

> Given a string, sort it in decreasing 
order based on the frequency of characters.

#### [解法一](451-Sort-Characters-By-Frequency/451-Sort-Characters-By-Frequency.cpp)：Bucket Sort + Ordered Map
因为仅有256个字符，可以创建一个长度为256的数组来存储每个字符的出现频率。然后使用一个```<int, vector<char>>map```来存储出现频率为i的字符有哪些。最后使用reverse_iterator输出map即可。

``` Cpp
class Solution {
public:
    string frequencySort(string s) {
        int charMap[256];
        memset(charMap,0,sizeof(charMap));
        map<int, vector<char>> freqMap;
        for (int i = 0; i < s.length(); ++i)
            charMap[(int) s[i]]++;
        for (int i = 0; i < 255; ++i)
        {
            if (charMap[i] != 0)
                freqMap[charMap[i]].push_back((char) i);
        }
        stringstream ss;
        for (map<int, vector<char>>::reverse_iterator itr = freqMap.rbegin();
            itr != freqMap.rend(); ++itr)
        {
            for (int i = 0; i < itr->second.size(); ++i)
            ss << string(itr->first, itr->second[i]);
        }
        return ss.str();
    }
};
```

#### [解法二](451-Sort-Characters-By-Frequency/451-Sort-Characters-By-Frequency-Less-Memory.cpp)：Bucket Sort + 循环确定频率
可以不使用Map而直接使用二重循环来将频率降序排列的，从而节省Map占用的空间。

---

### 468. Validate IP Address
**<font color=#C8A1E6> Divide and Conquer </font>**

#### [解法一](468-Validate-IP-Address.java)：分类讨论

首先分两类，IPv4和IPv6，分类方式是数字符串中的'.'和':'，看个数是否确定。

1. IPv4
   1. 用'.'进行split string
   2. 对于每个子串，一共四个，检查他们是否符合要求。因为子串中不能有除了数字以外的数，所以可以先转换成整数再转换回字符串，检查和原来的字符串是否相等，其次检查数字是否在0-255之间
2. IPv6
   1. 用':'进行Split string
   2. 对于每个子串，一共八个，检查他们是否符合要求。因为子串只要是16进制数字即可，所以直接转换成数字，检查长度是否符合要求，在长度符合要求的前提下检查是否是非负数。

同时检测```NumberFormatException```，如果有就返回False

---

### 476. Number Complement
**<font color=#C8A1E6> Reverse String; Binary Arithmetic </font>**

>Given a positive integer, output its complement number.
The complement strategy is to flip the bits of its binary representation.

#### [解法一](476-Number-Complement/476-Number-Complement.cpp)：进制转换 + Reverse

##### 十进制转二进制
对于一个十进制正整数
1. 对其 mod 2 取余数
2. 将其 div 2 之后的数（如果不为0）继续重复第一步
3. 重复以上步骤直到得到0为止
4. 将所有余数反向重组成为这个数的二进制表示，可以调用C++ Reverse 函数

##### 二进制转十进制
调用C++ stoi 函数，设定进制为2

#### [解法二](476-Number-Complement/476-Number-Complement.java)：二进制减法取反
[参考](https://leetcode.com/problems/number-complement/discuss/96018/Java-very-simple-code-and-self-evident-explanation)

一个数的二进制互补数是大于该数的最小11...11减去这个数，
例如：
94 = 1011110 -> 1111111 - 1011110 = 100001 = 33
94 -> 33

``` Java
class Solution {
    public int findComplement(int num) {
        int i = 0;
        int j = 0;
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        return i - num;
    }
}
```

---

### 520. Detect Capital

#### [解法一](520-Detect-Capital.java)：分两类讨论，遍历判断大小写

---

### 1461. Check If a String Contains All Binary Codes of Size K
**<font color=#C8A1E6> Sliding Window </font>**

#### [解法一](1461-Check-If-a-String-Contains-All-Binary-Codes-of-Size-K.cpp)：Sliding Window
暴力求解会超时，而且我们可以发现题目要求的pattern长度是特定的，所以可以尝试Sliding Window。因为要求长度特定的所有二进制Pattern，所有的Pattern都是不一样的，而且我们可以计算得出所有Pattern一共有多少数量。所以在Sliding Window前进的过程中不断把遇到的Pattern存储在一个集合中，最后查看集合中元素的数量确定我们是否已经遇到了所有Pattern

---

### 1513. Number of Substrings With Only 1s

#### [解法一](1461-Check-If-a-String-Contains-All-Binary-Codes-of-Size-K.cpp)：数学求和

一个长度为k的字符串有 ```k * (k + 1) / 2``` 个子串，所以利用这个来求长度就可以了。具体实现modulo的时候要仔细。

---

### 1540. Can Convert String in K Moves

#### [解法一](1540-Can-Convert-String-in-K-Moves.cpp)：遍历记录不同距离出现的频率

首先长度不同的字符串无法完成编辑。编辑过程中每个对应位置的两个字符有一个从 ```t[i]``` 到 ```s[i]``` 之间的差值。 ```t[i] - s[i]``` 如果小于零则加26（转回来）。记录不同的差值出现的频率。建立一个长度为26的字母，每一位表示如果距离等于这个数字，这个距离能出现多少次。比如题目限制27步，则距离为1可以出现两次，1一次，27一次，其他都只能出现一次。这样遍历整个map和这个数组对应位置进行比较，看有没有不符合要求的，有则无法完成，否则可以。

---

### 1541. Minimum Insertions to Balance a Parentheses String

#### [解法一](1541-Minimum-Insertions-to-Balance-a-Parentheses-String.java)：配对左括号和右括号，失配时补充

定义一个变量来记录需要补充的括号数量，另一个记录剩余的空闲左括号数量。
1. 遇到空闲的左括号则增加
2. 遇到连续两个右括号则从左括号中减去一个配对
3. 遇到单独一个右括号则从左括号中减去一个配对，并补充一个右括号
4. 如果没有配对的左括号则需要额外配一个左括号

最后如果还有剩余的左括号需要加两倍数量的右括号。

---