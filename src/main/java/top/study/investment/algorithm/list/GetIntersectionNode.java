package algorithm.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author qhb
 * @Date 2021/6/4 10:31 上午
 * @Version 1.0
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNode {
    /**
     * 判断相交的节点
     * @param headA
     * @param headB
     * @return
     * 第一想法
     * 1、用判断是否有环的方法，用 HashSet，先把 a 拆了，一个一个的；再拆b，add的时候看 result ，如果为 false 就找到相交节点了
     *
     *
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // null 则肯定没有相交
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> seen = new HashSet<>();
        while (headA != null) {
            seen.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            boolean result = seen.add(headB);
            if (!result) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }

    /**
     *
     * @param headA
     * @param headB
     * @return
     * 2021年06月04日10:55:46
     * 看了答案后，就简单了。需要画个图。
     *
     * 前提：null == null，是true，可以跳出循环。或者相交，也可以跳出循环
     *
     * 文字描述一下就是：
     * 1、lenA = 6, lenB = 3 A走的是A+B，B走的是B+A。他俩走的长度是一样的。
     * 2、如果相交，在某点就会调出来，
     * 3、如果不相交，会走到null调出来
     *
     * 精妙，简单。所以链表画图是很重要的
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode intersection = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode c = new ListNode(4);

        a1.next = intersection;
        b1.next = intersection;
        intersection.next = c;

        ListNode node = getIntersectionNode(a1, b1);
        System.out.println(node.val);
    }
}
