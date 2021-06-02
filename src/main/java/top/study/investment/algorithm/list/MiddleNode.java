package algorithm.list;

import java.util.Arrays;

/**
 * @Author qhb
 * @Date 2021/6/2 10:20 上午
 * @Version 1.0
 * @see: leetcode 876
 */
public class MiddleNode {

    /**
     * 找到中间节点
     * [1,2,3,4,5] -> 3
     * [1,2,3,4,5,6] -> 4
     *
     * 第一想法，直接转化为数组，牛逼。。size/2 or size/2+1
     * 有个问题就是：如果返回的变了，变成[3,4,5] or [4,5,6]，就麻烦了 -> 这个咋解决？
     * 1、如果是数组，则一样，index有了后，构造新的数组，再转化为链表
     * 2、如果不用这个，则：
     *
     * 第二想法，快慢指针，fast 的速度是 slow 的2倍，fast完成，slow就有了
     *
     */
    public static int middleNode(ListNode head) {
        // null
        if (head == null) {
            return -99;
        }

        // 就一个值
        if (head.next == null) {
            return head.val;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 偶数个
            if (fast.next == null) {
                return slow.next.val;
            }

            // 奇数个
            if (fast.next.next == null) {
                return slow.val;
            }
        }

        return 0;
    }

    /**
     *
     * [1,2,3,4,5] -> 3
     * [1,2,3,4,5,6] -> 3
     */
    public static int middleNode2(ListNode head) {
        // null
        if (head == null) {
            return -99;
        }

        // 就一个值
        if (head.next == null) {
            return head.val;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        ListNode head = ReverseList.arrayList2linkedList(Arrays.asList(1,2,3,4,5));
        int result = middleNode(head);
        System.out.println(result);
    }
}
