package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/4 9:47 上午
 * @Version 1.0
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
public class SplitListToParts {
    /**
     * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
     * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
     * @param root
     * @param k
     * @return
     *
     * 2021年06月04日09:52:00
     * 第一想法：
     * 1、遍历，计算链表长度 length
     * 2、length 与 k 判断，如果 k>=length，则补齐后尾的null，返回[[1],[2],...]
     * 3、length/k，得到比值和余数。
     */
    public static ListNode[] splitListToParts(ListNode root, int k) {
        return null;
    }
    public static void main(String[] args) {

    }
}
