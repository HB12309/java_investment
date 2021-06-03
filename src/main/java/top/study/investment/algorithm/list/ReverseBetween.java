package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/2 1:46 下午
 * @Version 1.0
 * @see: leetcode 92
 * @see ReverseList
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {
    /**
     * 反转链表， left <= right
     * @param head
     * @param left
     * @param right
     * @return
     * [1,2,3,4,5] , left=2, right=4 -> [1,4,3,2,5]
     *
     * 第一想法：link -> list -> list反转就容易了。 -> list + other value = new list -> link
     * 比较复杂：算了。
     *
     * 2021年06月03日09:57:45
     * 1、第3步和第5步需要想好。。会想不到的
     * 2、reverseLinkedList 方法，反正都是操作指针，不需要返回值
     * 3、pre right left curr，都是指针，图画好，next到底指向谁，就很清楚了。
     *
     */
    private static ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private static void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static void main(String[] args) {

    }
}
