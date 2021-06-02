package algorithm.list;

import java.util.Arrays;

/**
 * @Author qhb
 * @Date 2021/6/2 9:01 上午
 * @Version 1.0
 * 移除链表元素
 * @see: leetcode 203
 */
public class RemoveElementLinkedList {

    /**
     * 单项链表，第一想法。
     * 1、转化为数组，然后 for 循环比较，就有了新数组，再转化为链表
     * 2、第一想法很简单也很粗暴，不打算这样弄了，用新的吧。大概是 while 迭代去找和比对,
     * 问：是做增量还是做减法？先考虑增量吧
     */
    public static ListNode removeElement(ListNode head, int removeValue) {
        if (head == null) {
            return null;
        }

        // 移除头节点是 removeValue 的情况
        while (head != null) {
            if (head.val == removeValue) {
                head = head.next;
            } else {
                break;
            }
        }

        if (head == null) {
            return null;
        }

        // 构造root节点和temp用来迭代
        ListNode root = new ListNode();
        root.val = head.val;

        // root 构造好了，在这里就要走掉第一个
        ListNode temp = root;
        head = head.next;

        while (head != null) {
            // add
            if (head.val != removeValue) {
                ListNode node = new ListNode();
                node.val = head.val;
                // temp 替代进化
                temp.next = node;
                temp = node;
            }

            // 下一步
            head = head.next;
        }

        return root;
    }

    /**
     * 哈哈牛逼，对啊。第一个可以丢掉嘛。。。
     * @param head
     * @param removeValue
     * @return
     */
    public static ListNode removeElement2(ListNode head, int removeValue) {
        if (head == null) {
            return null;
        }

        // 构造root节点和temp用来迭代
        ListNode root = new ListNode();
        ListNode temp = root;

        while (head != null) {
            if (head.val != removeValue) {
                // 不相等的，加节点
                ListNode node = new ListNode(head.val);
                // temp 替代进化
                temp.next = node;
                temp = node;
            }
            // 下一步
            head = head.next;
        }

        return root.next;
    }

    public static void main(String[] args) {
        int removeValue = 2;
        ListNode head = ReverseList.arrayList2linkedList(Arrays.asList(5,2,1,2,1,3,2));
        ListNode listNode = removeElement2(head, removeValue);
        System.out.println(listNode.val);
    }
}
