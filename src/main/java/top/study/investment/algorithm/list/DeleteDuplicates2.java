package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021年06月02日13:58:05
 * @Version 1.0
 * @see DeleteDuplicates
 */
public class DeleteDuplicates2 {
    /**
     * 和 DeleteDuplicates 稍有不同，DeleteDuplicates2 不保留一致的数字
     * DeleteDuplicates2: [1,1,2,3,4,4] -> [2,3]
     * DeleteDuplicates: [1,1,2,3,4,4] -> [1,2,3,4]
     *
     * 第一想法，变成数组，可以做，要实现一下。但麻烦了，不弄了。脑袋里已经实现了
     *
     */
    public static ListNode deleteDuplicates2(ListNode listNode) {
        return null;
    }

    /**
     * 小邱说，压缩数组，这个要和其他比较一下不同噢，一个是 j 跳了后就不 add，一个是不需要这个判断
     * @see DeleteDuplicates#compressList(List)
     * @param list
     * @return
     */
    public static List<Integer> removeSameValueInList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> compressList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            // 最后一个了
            if (i == list.size() - 1) {
                compressList.add(list.get(i));
                break;
            }

            int j = i+1;
            while (j < list.size() && list.get(i).equals(list.get(j))) {
                j++;
            }
            // 1、间隔，完全没有相同数字的才能 add，不同，看这里~
            if (j == i+1) {
                compressList.add(list.get(i));
            }

            i = j - 1;
        }
        return compressList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,1,2,3,4,4);
        List<Integer> resultList = removeSameValueInList(list);
//        ListNode before = ReverseList.arrayList2linkedList(list);
//        ListNode result = deleteDuplicates(before);
        System.out.println(resultList);
    }
}
