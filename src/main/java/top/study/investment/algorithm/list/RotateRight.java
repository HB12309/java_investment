package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author qhb
 * @Date 2021/6/2 4:03 下午
 * @Version 1.0
 * @see: leetcode 61
 */
public class RotateRight {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * @param head
     * @param k
     * @return
     * [1,2,3,4] -> [4,1,2,3] -> [3,4,1,2]
     *
     * 第一想法：可以从尾巴再回到头上。这是一个有界的嘛。
     * 转化为数组，resultIndex = (currentIndex + k) % listSize，这样找到真正的位置
     */
    private static ListNode rotateRight(ListNode head, int k) {
        return null;
    }

    /**
     * 数组都好说~
     * @param list
     * @param k
     * @return
     */
    private static List<Integer> rotateRightList(List<Integer> list, int k) {
        int size = list.size();
        if (list == null || size == 1) {
            return list;
        }

        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            int currentIndex = (i + k) % size;
            // key: newIndex, value: currentValue，所以一个是 currentIndex，一个是 i
            indexMap.put(currentIndex, list.get(i));
        }
        List<Integer> resultList = new ArrayList<>(size);
        indexMap.forEach((index, value) -> {
            resultList.add(index, value);
        });
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> resultList = rotateRightList(Arrays.asList(11,22,33,44), 2);
        System.out.println(resultList.size());
    }
}
