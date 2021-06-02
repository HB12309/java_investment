package algorithm.list;

import java.util.Arrays;

/**
 * @Author qhb
 * @Date 2021/6/2 2:51 下午
 * @Version 1.0
 * @see: leetcode 19
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

    public static void main(String[] args) {
        ListNode head = ReverseList.arrayList2linkedList(Arrays.asList(1,2,3,4,5));
        ListNode result = removeNthFromEnd(head, 2);
        System.out.println(result.val);
    }
}
