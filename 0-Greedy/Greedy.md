# Greedy

### 406. Queue Reconstruction by Height
**<font color=#C8A1E6> Greedy; Sort </font>**

#### [解法一](406-Queue-Reconstruction-by-Height.java)：排序+从低到高考虑

因为只知道一个人的身高和在他前面的大于等于他身高的人，其他人都无法事先确定，但是只有身高最矮的人可以事先确定他的位置。确定了最矮的人就可以确定第二矮的人的位置，以此类推。

首先根据身高使用Java Customized Sort进行排序。从最矮的人开始，设置一个counter为这个人前面身高大于等于这个人的人数。接下来每遇到一个空位说明找到了一个符合要求的人，就counter减一，最后找到合适的index还要确定找到空位。将这个人的信息放入。以此处理得到最终结果。

![图示](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200607203047.png)

#### [解法二](406-Queue-Reconstruction-by-Height-v2.java)：从高到低考虑

[参考](https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution)

因为每个人的位置信息仅和这个人之前的比他高的人相关，如果我们已经知道了所有比这个人高的人的位置，而且这个人之前的比他高的人是i个，我们就只需要在第i个位置将这个人放入即可。

对于同样高的人，要先放入排在前面的人，否则index会out of bound。

![图示](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200607202733.png)

---

### 1029. Two City Scheduling
**<font color=#C8A1E6> Greedy; Sort </font>**

>There are 2N people a company is planning to interview. 
>The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1]. Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

#### [解法一](1029-Two-City-Scheduling.java)：分步考虑最优情况排序

需要考虑最优情况，但是又不能直接排序，因为有两个城市每个人飞去每个城市的价格不同，没有一个统一的排序手段。为了简化排序，先假设每个人都要飞到城市A，算出总的价格，接下来再考虑让哪些人飞到城市B。

现在，一个人飞到城市B的价格=飞到城市B的价格 - 飞到城市A的价格。这样只需要把这个价格进行排序，之后再把前n/2的人的价格相加加上一开始的去城市A的总价就能得到最终的价格。

#### 解法二：动态规划

[参考](https://leetcode.com/problems/two-city-scheduling/discuss/278731/Java-DP-Easy-to-Understand)

考虑前i + j个人，把i个人送到城市A并把j个人送到城市B的最小价格

---
