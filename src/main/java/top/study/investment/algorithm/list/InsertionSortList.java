package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/2 5:20 下午
 * @Version 1.0
 *
 * https://leetcode-cn.com/problems/insertion-sort-list
 */
public class InsertionSortList {
    /**
     * 插入排序算法：
     *
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     * @param head
     * @return
     *
     * @time 2021年06月03日13:49:51
     * 排序：都需要明白数组和链表之间的异同
     *
     * 插入排序的基本思想是，维护一个有序序列，初始时有序序列只有一个元素，每次将一个新的元素插入到有序序列中，将有序序列的长度增加 11，直到全部元素都加入到有序序列中。
     *
     * 如果是数组的插入排序，则数组的前面部分是有序序列，每次找到有序序列后面的第一个元素（待插入元素）的插入位置，将有序序列中的插入位置后面的元素都往后移动一位，然后将待插入元素置于插入位置。
     *
     * 对于链表而言，插入元素时只要更新相邻节点的指针即可，不需要像数组一样将插入位置后面的元素往后移动，因此插入操作的时间复杂度是 O(1)O(1)，但是找到插入位置需要遍历链表中的节点，时间复杂度是 O(n)O(n)，因此链表插入排序的总时间复杂度仍然是 O(n^2)O(n
     * 2)，其中 nn 是链表的长度。
     *
     * @time 2021年06月03日14:14:55
     * 1、重点是理解插入排序的思想。
     * 2、根据思想定义好字段，（命名直接可以决定这道题是否做得出来）
     * 3、根据思想想好有几个 while
     * 4、对curr的插入
     */
    public static ListNode insertionSortList(ListNode head) {
        // 1. 首先判断给定的链表是否为空，若为空，则不需要进行排序，直接返回。
        if(head == null){
            return head;
        }

        // 2. 链表初始化操作
        ListNode dummyHead = new ListNode(0); // 引入哑节点
        dummyHead.next = head;                // 目的是在head之前插入节点
        ListNode lastSorted = head;           // 维护lastSorted为链表已经排好序的最后一个节点并初始化
        ListNode curr = head.next;            // 维护curr 为待插入的元素并初始化

        // 3. 插入排序
        while(curr != null) {
            if(lastSorted.val <= curr.val){     // 说明curr应该位于lastSorted之后
                lastSorted = lastSorted.next;   // 将lastSorted后移一位,curr变成新的lastSorted
            } else {                              // 否则,从链表头结点开始向后遍历链表中的节点
                ListNode prev = dummyHead;      // 从链表头开始遍历 prev是插入节点curr位置的前一个节点
                while(prev.next.val <= curr.val){ // 循环退出的条件是找到curr应该插入的位置
                    prev = prev.next;
                }
                // 以下三行是为了完成对curr的插入（配合题解动图可以直观看出）
                /**
                 * 个人认为：这里很难理解，需要画图理解，给个案例，谁指向谁，先切断谁，再指向谁，有几个步骤
                 */
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            /**
             * 往下走
             */
            curr = lastSorted.next; // 此时 curr 为下一个待插入的元素
        }
        // 返回排好序的链表
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
