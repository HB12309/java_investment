package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/2 3:39 下午
 * @Version 1.0
 * @see: leetcode 86
 * https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {
    /**
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * @param head
     * @param x
     * @return
     *
     * 第一想法：题目没看懂
     * 第二想法：还是老办法，转化为数组吧。然后存2个indexes，
     * smallIndexes: 小于3的index位置，bigIndexes， >= 3的 index 位置
     * 再拼接数组，再拼接linked【已实现】
     *
     * 第三想法。。不知道，看答案吧
     * 2021年06月03日11:10:40
     * @see PartitionList#partitionList(List, int)
     * 心里想法：第二天看答案，没想到也用了 small large 哈哈。和我写的上面的 [partitionList] 异曲同工之妙啊
     * 哑巴节点是这样的。连接一下就好了嘛。。。再尾巴处理一下
     */
    private static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        // 处理一下尾巴
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    /**
     * 参考上面的第二想法
     * @param list
     * @param x
     * @return
     */
    private static List<Integer> partitionList(List<Integer> list, int x) {
        if (list == null || list.size() == 1) {
            return list;
        }

        List<Integer> smallIndexes = new ArrayList<>();
        List<Integer> bigIndexes = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();

        // 得到 indexes
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            if (value < x) {
                smallIndexes.add(i);
            } else {
                bigIndexes.add(i);
            }
        }

        // 先处理 smallIndexes，再处理 bigIndexes
        smallIndexes.forEach(value -> {
            sortedList.add(list.get(value));
        });
        bigIndexes.forEach(value -> {
            sortedList.add(list.get(value));
        });

        return sortedList;
    }

    public static void main(String[] args) {
        List<Integer> sortedList = partitionList(Arrays.asList(1,4,3,2,5,2), 3);
        System.out.println(sortedList.size());
    }
}
