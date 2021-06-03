package algorithm.list;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author qhb
 * @Date 2021/6/2 2:51 下午
 * @Version 1.0
 * @see: leetcode 19
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {
    /**
     * 删除倒数第N个
     * @param head
     * @param n
     * @return
     * [1,2,3,4,5] n = 2 -> [1,2,3,5]
     *
     * 第一想法：linked -> list -> remove -> linked
     * 哈哈，这种太麻烦了。
     *
     * 第二想法：第一遍 linked遍历 -> 得到total -> 倒数N -> 正数就是 total-n+1 -> 简单了。这就需要遍历2遍
     *
     * 第三想法：leetcode 提示说遍历一遍就得到结果。暂时没想到。实现想法2吧
     *
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        int total = 0;
        ListNode firstHead = head;
        while (firstHead != null) {
            total++;
            firstHead = firstHead.next;
        }
        int orderN = total - n + 1;
        // 不应该出现的，在逗我哈哈
        if (orderN <= 0) {
            return head;
        }

        ListNode result = new ListNode();
        ListNode temp = result;

        int count = 0;
        while (head != null) {
            count++;
            // 不需要跳过的
            if (count != orderN) {
                ListNode node = new ListNode(head.val);

                temp.next = node;
                temp = node;
            }

            head = head.next;
        }
        return result.next;
    }

    /**
     * 噢噢，明白了，所以有倒数N的题目里，就有 stack ，其实是 Deque啊，其实是 LinkedList
     * @param head
     * @param n
     * @return
     *
     * 2021年06月03日10:58:40
     * 需要深刻理解：
     * 1、prev.next = prev.next.next; // prev 没动，next 动了，相当于移除了一个人
     * 2、prev = prev.next;
     * 的不同！！这一点非常重要，非常重要！！
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next; // prev 没动，next 动了，相当于移除了一个人
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     * 2021年06月03日10:50:42
     * 噢噢，双指针，一下子明白了。
     * 1、first 先走N。
     * 2、然后first second 一起走完最后的 first。first后走的就是 second 的倒数N
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = ReverseList.arrayList2linkedList(Arrays.asList(1,2,3,4,5));
        ListNode result = removeNthFromEnd3(head, 2);
        System.out.println(result.val);
    }
}
