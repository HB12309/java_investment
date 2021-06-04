package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/4 3:11 下午
 * @Version 1.0
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 */
public class MergeKLists {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * @param lists
     * @return
     *
     * 第一想法：搞成 ArrayList 暴力破解哈哈哈
     * 后来发现，本身 ListNode 有序，这个可以利用噢。
     *
     * 对，就是这样。
     * 1、先了解 {@link MergeTwoLists#mergeTwoLists(ListNode, ListNode) }
     * 2、基于这个算法，从 2 -> K，那么：本身要用到分治思想。
     *
     * 3、这个是顺序合并，也就是一个一个来。。也是最简单能够想到的
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }
        ListNode ans = null;

        for (int i = 0; i < lists.length; ++i) {
            ans = MergeTwoLists.mergeTwoLists(ans, lists[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
