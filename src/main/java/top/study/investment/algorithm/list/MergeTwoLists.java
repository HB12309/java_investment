package algorithm.list;

import java.util.Comparator;

/**
 * @Author qhb
 * @Date 2021/6/4 10:00 上午
 * @Version 1.0
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    /**
     * @time 2021年06月04日10:01:07
     * 第一想法：
     * 1、前缀判断，如果都是空，直接返回。
     * 2、l1  l2 哪个为空，则返回另外一个。
     * 3、merge成一个数组，在数组里面排序，然后组装成链表【太粗暴了哈哈】{@link java.util.ArrayList#sort(Comparator)}
     *
     * 3、直接把 l1->l2，合成一个，然后用总的l3排序。{@link SortList#sortList(ListNode)}
     *
     * @param l1
     * @param l2
     * @return
     *
     * 2021年06月04日10:14:51
     * 1、看了答案后，需要画个图。嗯嗯对，l1 l2 本身是有顺序的，这个可以利用。
     * 2、我的前置边界判断，应该也可以加上，就不需要while了啊。
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        /**
         * 2021年06月04日15:25:16
         * 哎，这里是 && 耶。
         */
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        /**
         * 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
         * 因为只要有一个是 null，这里就判定走完了。这个就不需要前置边界判断了。20210604上午说的就可以推翻，以20210604下午
         * 说的为准。这个更高效简洁
         */
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {

    }
}
