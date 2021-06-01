package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/5/31 7:26 下午
 * @Version 1.0
 */
public class DeleteDuplicates {
    /**
     * 第一想法：while 扫描，本身有序，如果 value 和 next.value 相等，跳过；继续
     */
    public static ListNode deleteDuplicates(ListNode listNode) {
        if (listNode == null) {
            return null;
        }

        if (listNode.next == null) {
            return listNode;
        }

        // 第一个
        ListNode result = new ListNode();
        result.val = listNode.val;
        int tempVal = listNode.val;
        while (listNode != null) {

        }


        return null;
    }

    /**
     * 压缩数组
     * @param list
     * @return
     */
    public static List<Integer> compressList(List<Integer> list) {
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
            compressList.add(list.get(i));
            i = j - 1;
        }
        return compressList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,1);
        List<Integer> resultList = compressList(list);
//        ListNode before = ReverseList.arrayList2linkedList(list);
//        ListNode result = deleteDuplicates(before);
        System.out.println(resultList);
    }
}
