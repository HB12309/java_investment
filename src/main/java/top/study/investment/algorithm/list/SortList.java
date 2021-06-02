package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/2 3:16 下午
 * @Version 1.0
 * @see: leetcode 148
 */
public class SortList {
    /**
     * 排序列表
     * @param head
     * @return
     * 第一想法：linked -> list -> bubbo sort -> linked，这个有毒，不应该是这样，好麻烦
     * 推荐 O(nlogn)复杂度。
     */
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
