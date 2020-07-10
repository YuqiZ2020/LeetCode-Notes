# Linked Lists

## <font color=#7F71D9>Two Pointers: </font>

### 2. Add Two Numbers
**<font color=#C8A1E6> Linked Lists</font>**

#### 解法一：两个指针分别遍历，直接相加

有两个链表，长度可能不同，当任意一个还没有走到结尾的时候就可以继续操作。
1. 两个链表当前点的数值初始化为0，如果任意一个指针还没有指向nullptr，则取得这个点的数值，并将指针后移。
2. 加上之前的进位进行计算，确定是否有进位，进位用一个变量表示。
3. 储存在新的结点中

注意由于一开始的初始化，一开始会**多出一个头结点**，返回值的时候返回头结点之后的结点即可。

---

### 19. Remove Nth Node From End of List

#### 解法一：Two Pointers

[参考](https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/)

第一个Pointers先往前走k步，之后两个Pointer一起往前，直到第一个Pointer走到最后一个结点为止。这个时候让两个Pointer一起向前，最后第一个Pointer走到最后一个点的时候，第二个Pointer在第倒数k + 1个结点（两个指针之间相差k步）这个时候就可以进行删除结点的操作。

![](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200601215939.png)

---

### 21. Merge Two Sorted Lists
**<font color=#C8A1E6> Linked Lists; Two Pointers; Recursion </font>**

#### 解法一：Two Pointers
和[第88题 Merge Two Sorted Arrays](../0-Arrays/88-Merge-Sorted-Arrays/88-Merge-Sorted-Arrays-pointers.java)解法类似，先确定开头的第一个元素是哪个List的小，让这个List作开头，接下来有两个Pointer分别遍历两组元素，比较大小，小的接上并指针后移。

#### 解法二：Three Pointers，简化
首先可以做一个假的头结点，这样两个List的头结点不需要额外判断。而且也不需要建立新的结点，只需要每次把想要的链表接过来并移动Pointer确定当前位置即可。

#### [解法三](21-Merge-Two-Sorted-Lists/21-Merge-Two-Sorted-Lists-Recursion.cpp)：递归
当其中一个链表为null的时候直接返回另一个链表。否则对两个链表的头元素进行比较，如果其中一个的元素小则让这个元素的后继元素成为merge（后继元素，另一个列表）最后返回这个结点的指针。

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

### 160. Intersection of Two Linked Lists

#### [解法一](160-Intersection-of-Two-Linked-Lists.cpp)：Two Pointers

[参考](https://leetcode.com/problems/intersection-of-two-linked-lists/solution/)

一个很巧妙的解法，因为必须要遍历，但是又不知道两个链表在左边多出来的长度分别是多少，所以不确定两个指针相遇的地方是否是相交的起始点。

所以当一个指针走到尽头的时候就让他去向另一个链表的开头并继续向前，当两个指针第一次相遇的时候则是交叉的起始点。

1. 两个链表左边多余长度一样，则直接相遇
2. 两个指针分别走完了自己的长度加上对方的前半段，这两个长度是一样的
3. 两个指针没有相交，最后会同时达到nullptr。

---

### 234. Palindrome Linked List
**<font color=#C8A1E6> Linked Lists; Two Pointers</font>**

#### [解法一](234-Parlindrome-Linked-List/234-Palindrome-Linked-List.cpp)：翻转比较

直接把整个链表翻转（需要deep copy复制一份新的），然后比较原有链表和翻转后的链表是否是一样的，如果一样则是回文。

#### [解法二](234-Parlindrome-Linked-List/234-Palindrome-Linked-List.java)：Two Pointers确定中点+原位翻转

[参考](https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand)

可以用两个Pointer来确定链表的中间位置。让一个Pointer以两倍速度，一个Pointer以正常速度往前。Fast Pointer走到中点的时候Slow Pointer正好走到中间。

1. 如果是偶数个元素则Fast会走到null，slow会走到后半段的开始。
2. 如果是奇数个元素则Fast会走到最后一个元素，slow会走到正中间。

Slow一边走一边对前半段进行翻转，翻转只**改变指针方向**，不引入新元素，翻转停止于slow前一个元素（用prev保存），接下来根据Fast的位置来判断奇偶。一个指针从prev开始

1. 如果是偶数个元素，另一个指针从slow开始
2. 如果是奇数个元素，另一个指针从slow的下一个元素开始（跳过正中间的元素）

进行比较判断是否是回文。

![图示](https://raw.githubusercontent.com/YuqiZ2020/PicBed/master/img/20200604161547.png)

```Java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) 
        {
            fast = fast.next.next;
            
            ListNode nextTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextTemp;
        }
        if (fast != null)
            slow = slow.next;
        ListNode cur2 = prev;
        while (slow != null)
        {
            if (slow.val != cur2.val)
                return false;
            slow = slow.next;
            cur2 = cur2.next;
        }
        return true;
    }
}
```

---

### 328. Odd Even Linked Lists
**<font color=#C8A1E6> Linked Lists; Two Pointers</font>**

#### [解法一](328-Odd-Even-Linked-List.java)：Two Pointer 移动

和数组的Two Pointer解法差不多，一个Pointer确定链表尾端，做标记，另一个Pointer读取偶数点，让前一个pointer在表尾把这些点加入。之后读取Pointer在原处删除这些偶数点。需要注意对标记点的处理，偶数长度和奇数长度的处理有些不同。

现在的处理方式是，当读取Pointer确定下一位指向的是mark之后，做完操作之后就退出循环，避免对后续（已经挪动过的）链表再进行重复操作。

---

## <font color=#7F71D9>Others: </font>

### 203. Remove Linked List Elements
**<font color=#C8A1E6> Linked Lists; Recursion</font>**

#### [解法一](203-Remove-Linked-List-Elements/203-Remove-Linked-List-Elements.cpp)：遍历检测

首先，因为通常删除都是需要在前一个结点进行删除，头结点的处理会有所不同，需要单独做一个循环。如果元素数值是要删除的数值，则直接将头结点改到下一个结点。之后判断每个节点的后面那个是否是要删除的值，如果是则执行删除操作。

#### [解法二](203-Remove-Linked-List-Elements/203-Remove-Linked-List-Elements-Recursion.java)：递归

[参考](https://leetcode.com/problems/remove-linked-list-elements/discuss/57306/3-line-recursive-solution)

Base Case是当指针指向null的时候返回null。调用递归对当前结点的下一结点进行处理，对于当前结点，如果当前结点的值是需要删除的数值则直接返回下一个结点的指针，否则还是返回当前结点。

---

### 206. Reverse Linked Lists
**<font color=#C8A1E6> Linked Lists; Recursion</font>**

#### 解法一：循环+建立新结点
[Java](206-Reverse-Linked-Lists/206-Reverse-Linked-Lists-Iterative.java)

[C++](206-Reverse-Linked-Lists/206-Reverse-Linked-Lists-Iterative.cpp)

先遍历整个链表找到结尾并标注。接下来从头开始对于每个结点，复制一个新的结点放在标注的结点之后，最后返回标注的结点。

#### [解法二](206-Reverse-Linked-Lists/206-Reverse-Linked-Lists-Iterative.cpp)：递归
Base case是当前结点为nullptr或者之后没有结点的时候，直接返回当前结点的指针。否则先递归调用将这个结点之后的链表翻转。对于当前结点，我们改变这个结点指向后方的指针，将后方结点的next改变为指向这个结点，这个结点指向nullptr。最后返回的指针是翻转链表的头指针。

#### 解法三：调转指针方向

[参考](https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution)

对于每个结点，先保存下一个结点的地址，然后把当前点的next指向前一个结点（事先保存），接下来去下一个结点重复操作，调转所有指针方向。

---

### 237. Delete Node in a Linked List
**<font color=#C8A1E6> Linked Lists</font>**

---

### 430. Flatten a Multilevel Doubly Linked List
**<font color=#C8A1E6> Linked Lists; Recursion</font>**

#### [解法一](430-Flatten-a-Multilevel-Doubly-Linked-List.java)：Recursion
首先找到最近的有child的结点，然后先把这个结点的后续结点保存，把child结点链接到这个结点之后，然后对child结点进行recursive call处理。然后找到linked list的末端，把之前保存的后续结点重新链接回来。

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