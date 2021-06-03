package algorithm.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author qhb
 * @Date 2021/6/2 4:35 下午
 * @Version 1.0
 * {@link CycleList#getCycleIndex(ListNode)}
 * @see CycleList#getCycleIndex(ListNode)
 * https://leetcode-cn.com/problems/linked-list-cycle-ii
 */
public class DetectCycle {
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * @param head
     * @return
     */
    private static ListNode deleteCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }

            pos = pos.next;
        }

        return null;
    }

    /**
     * 这个很精妙啊。。。
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            // 没有环，走人
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            // 一定会相遇的
            if (fast == slow) {
                break;
            }
        }
        // 构建第二轮开始
        fast = head;
        // 第二轮相遇，step步进一致，
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {

    }
}
