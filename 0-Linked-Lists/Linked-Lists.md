# Linked Lists

## <font color=#7F71D9>Two Pointers: </font>

### 19. Remove Nth Node From End of List

#### 解法一：Two Pointers

[参考](https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/)

第一个Pointers先往前走k步，之后两个Pointer一起往前，直到第一个Pointer走到最后一个结点为止。这个时候让两个Pointer一起向前，最后第一个Pointer走到最后一个点的时候，第二个Pointer在第倒数k + 1个结点（两个指针之间相差k步）这个时候就可以进行删除结点的操作。

![](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200601215939.png)

---

### 141. Linked List Cycle
**<font color=#C8A1E6> Linked Lists; Two Pointers</font>**

#### [解法一](141-Linked-List-Cycle.cpp)：Two Pointers

[参考](https://leetcode.com/problems/linked-list-cycle/solution/)

设置两个Pointers，一个走的快（走一步跳一步）另一个走得慢，如果链表中存在环路则两个Pointer最终会相遇。如果没有环路则快的那个Pointer会先走到底。

#### 解法二：HashTable保存遇到的点

[参考](https://leetcode.com/problems/linked-list-cycle/solution/)

---

### 142. Linked List Cycle II
**<font color=#C8A1E6> Linked Lists; Two Pointers</font>**

#### [解法一](141-Linked-List-Cycle.cpp)：Two Pointers

[参考](https://leetcode.com/problems/linked-list-cycle-ii/discuss/664107/Java-Simple-two-pointers-solution)

不知道其他人是怎么想到这个解法的，我一开始完全想不出来。有点小学数学题赛跑的味道。还是用第141题的方法判断是否有cycle，之后让fast pointer留在原地，slow pointer返回起点，让两个点一起正常速度往前，当两个pointer相遇的时候就是cycle开始的时候。

这个方法可以用数学来证明。当两个Pointer一开始相遇的时候，fast经过了x + 2a + b，slow经过了x + a，可以得到x = b，所以最后两个Pointer会在cycle开始点相遇。

![](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200601225143.png)

---

### 328. Odd Even Linked Lists
**<font color=#C8A1E6> Linked Lists; Two Pointers</font>**

### [解法一](328-Odd-Even-Linked-List.java)：Two Pointer 移动

和数组的Two Pointer解法差不多，一个Pointer确定链表尾端，做标记，另一个Pointer读取偶数点，让前一个pointer在表尾把这些点加入。之后读取Pointer在原处删除这些偶数点。需要注意对标记点的处理，偶数长度和奇数长度的处理有些不同。

现在的处理方式是，当读取Pointer确定下一位指向的是mark之后，做完操作之后就退出循环，避免对后续（已经挪动过的）链表再进行重复操作。

---

### 2. Add Two Numbers
**<font color=#C8A1E6> Linked Lists</font>**

#### 解法一：两个指针分别遍历，直接相加

有两个链表，长度可能不同，当任意一个还没有走到结尾的时候就可以继续操作。
1. 两个链表当前点的数值初始化为0，如果任意一个指针还没有指向nullptr，则取得这个点的数值，并将指针后移。
2. 加上之前的进位进行计算，确定是否有进位，进位用一个变量表示。
3. 储存在新的结点中

注意由于一开始的初始化，一开始会**多出一个头结点**，返回值的时候返回头结点之后的结点即可。

---

### 707. Design Linked Lists
**<font color=#C8A1E6> Linked Lists</font>**

``` Java
class Node
    {
        int val;
        Node next;
        public Node() { val = 0; }
        public Node(int x) { val = x; }
    }
    
    private Node head;
    private int size;
```

整个class里面包含一个Node class，还有两个field：head和size，head是一个Node pointer，size存储了链表的长度。

##### get
首先判定index是否合法，其次遍历整个链表直到cursor指向第index个数字，返回其数值。

##### addAtHead
建立新的结点并将next指向原来的表头，表头指向这个结点。增加长度。

##### addAtTail
判定当长度为0的时候调用addAtHead，否则需要遍历到表尾进行添加。增加长度。

##### addAtIndex
和addAtTail类似。需判断index是否合法。

##### deleteAtIndex
如果是删除表头则直接改动head。否则遍历找到**这个index的前一位**，让前一位的next直接等于后一位的后一位。长度减少。

---