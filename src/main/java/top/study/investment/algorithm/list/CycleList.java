package algorithm.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author qhb
 * @Date 2021/5/31 6:51 下午
 * @Version 1.0
 * 判断是否是环形链表
 */
public class CycleList {
    public static void main(String[] args) {
        ListNode one = new ListNode(11, null);
        ListNode two = new ListNode(22, null);
        ListNode three = new ListNode(33, null);
        ListNode four = new ListNode(44, null);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

//        boolean result = hasCycle2(one);
        int result = getCycleIndex(one);

        System.out.println(result);
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * @param head
     * @return
     *
     * 第一想法：拿着Set add，新增后，如果有环，说明 value相同，得到 value 的 index，通过 map 来存啦
     */
    private static int getCycleIndex(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }

        Set<ListNode> seen = new HashSet<>();
        Map<Integer, Integer> indexValueMap = new HashMap<>();
        int count = 0;
        while (head != null) {
            // 添加失败，说明存在，说明有环
            boolean result = seen.add(head);
            if (!result) {
                // 有环了
                return indexValueMap.get(head.val);
            } else {
                indexValueMap.put(head.val, ++count);
            }

            head = head.next;
        }

        return 0;
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

    /**
     * 牛逼，主要是要明白 @see HashSet 可以 add后又 boolean 这个API
     * @see HashSet
     * @param node
     * @return
     */
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
