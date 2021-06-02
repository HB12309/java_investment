package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/2 3:39 下午
 * @Version 1.0
 * @see: leetcode 86
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
     */
    private static ListNode partition(ListNode head, int x) {
        return null;
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
