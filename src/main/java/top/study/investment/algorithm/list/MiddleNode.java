package algorithm.list;

import java.util.Arrays;

/**
 * @Author qhb
 * @Date 2021/6/2 10:20 上午
 * @Version 1.0
 * @see: leetcode 876
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
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

    public static ListNode middleNode3(ListNode head) {
        // null
        if (head == null || head.next == null) {
            return head;
        }


        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 偶数个
            if (fast.next == null) {
                return slow.next;
            }

            // 奇数个
            if (fast.next.next == null) {
                return slow.next;
            }
        }

        return head.next;
    }

    /**
     * 我们可以继续优化方法二，用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间。
     * @param head
     * @return
     * @see MiddleNode#middleNode3(ListNode)
     * 相对于自己写的快慢指针，官方的明显简单多了。。是我想多了吧哈哈
     */
    public static ListNode middleNode6(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 链表的缺点在于不能通过下标访问对应的元素。因此我们可以考虑对链表进行遍历，同时将遍历到的元素依次放入数组 A 中。如果我们遍历到了 N 个元素，那么链表以及数组的长度也为 N，对应的中间节点即为 A[N/2]。
     * @param head
     * @return
     */
    public static ListNode middleNode4(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    /**
     * 我们可以对方法一进行空间优化，省去数组 A。
     *
     * 我们可以对链表进行两次遍历。第一次遍历时，我们统计链表中的元素个数 N；第二次遍历时，我们遍历到第 N/2 个元素（链表的首节点为第 0 个元素）时，将该元素返回即可。
     *
     * @param head
     * @return
     */
    public static ListNode middleNode5(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
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
        ListNode head = ReverseList.arrayList2linkedList(Arrays.asList(1,2));
        ListNode result = middleNode6(head);
        System.out.println(result);
    }
}
