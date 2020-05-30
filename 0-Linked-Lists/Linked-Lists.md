# Linked Lists

### 2. Add Two Numbers
**<font color=#C8A1E6> Linked Lists</font>**

#### 解法一：两个指针分别遍历，直接相加

有两个链表，长度可能不同，当任意一个还没有走到结尾的时候就可以继续操作。
1. 两个链表当前点的数值初始化为0，如果任意一个指针还没有指向nullptr，则取得这个点的数值，并将指针后移。
2. 加上之前的进位进行计算，确定是否有进位，进位用一个变量表示。
3. 储存在新的结点中

注意由于一开始的初始化，一开始会**多出一个头结点**，返回值的时候返回头结点之后的结点即可。

---

### 328. Odd Even Linked Lists

### 解法一：Two Pointer 移动
**<font color=#C8A1E6> Linked Lists; Two Pointers</font>**

和数组的Two Pointer解法差不多，一个Pointer确定链表尾端，做标记，另一个Pointer读取偶数点，让前一个pointer在表尾把这些点加入。之后读取Pointer在原处删除这些偶数点。需要注意对标记点的处理，偶数长度和奇数长度的处理有些不同。

现在的处理方式是，当读取Pointer确定下一位指向的是mark之后，做完操作之后就退出循环，避免对后续（已经挪动过的）链表再进行重复操作。

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