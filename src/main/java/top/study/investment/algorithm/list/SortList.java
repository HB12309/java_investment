package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/2 3:16 下午
 * @Version 1.0
 * @see: leetcode 148
 * https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 */
public class SortList {
    /**
     * 排序列表
     * @param head
     * @return
     * 第一想法：linked -> list -> bubbo sort -> linked，这个有毒，不应该是这样，好麻烦
     * 推荐 O(nlogn)复杂度。
     *
     * 归并排序（递归法）。
     * 2021年06月03日11:06:29
     * 所以说，先要非常熟悉 List 的排序。。才能玩转 linked 的排序，逻辑是一样的
     */
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 原来要重做 h res 啊！！！
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        // 这里要干嘛？
        h.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {

    }
}
