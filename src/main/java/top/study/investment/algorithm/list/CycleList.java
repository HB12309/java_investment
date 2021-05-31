package algorithm.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author qhb
 * @Date 2021/5/31 6:51 下午
 * @Version 1.0
 * 判断是否是环形链表
 */
public class CycleList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1, null);
        ListNode two = new ListNode(2, null);
        ListNode three = new ListNode(3, null);
        ListNode four = new ListNode(4, null);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        boolean result = hasCycle2(one);
        System.out.println(result);
    }

    /**
     * fast slow 快慢链表，如果fast 追上了 slow ，说明有环
     * @param node
     * @return
     */
    public static boolean hasCycle(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycle2(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        Set<ListNode> seen = new HashSet<>();
        while (node != null) {
            // 添加失败，说明存在，说明有环
            boolean result = seen.add(node);
            if (!result) {
                return true;
            }

            node = node.next;
        }

        return false;
    }
}
