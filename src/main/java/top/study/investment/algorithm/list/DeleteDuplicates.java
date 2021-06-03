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
     * DeleteDuplicates: [1,1,2,3,4,4] -> [1,2,3,4]
     *
     * 2021年06月02日14:22:50
     * 说：做减法就是麻烦，做加法看看吧。
     * 用了20分钟（其中包含闲聊），
     *
     * 1、做加法果然更简单，主要是有对比的基准
     * 2、ListNode result 可以：1、空的头结点。2、头结点也可用，都行，看方便。
     * 3、做加法，主要是有一个 temp 来作为最后一个节点迭代
     *
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // 边界
        if (head == null || head.next == null) {
            return head;
        }

        int baseValue = head.val;
        ListNode result = new ListNode(baseValue);
        ListNode temp = result;

        while (head != null) {
            if (head.next == null) {
                break;
            }

            if (baseValue != head.next.val) {
                ListNode node = new ListNode(head.next.val);
                // 因为比较完了，基准变了，要往下走了
                baseValue = head.next.val;
                // 接上
                temp.next = node;
                temp = node;
            }
            // 下一步
            head = head.next;
        }
        return result;
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

    /**
     * leetcode 答案
     * @param head
     * @return
     * 相比于
     * @see DeleteDuplicates#deleteDuplicates(ListNode) , 这里不需要 new node，而是通过 cur 直接 next下去
     * 对噢，好简单~
     */
    public static ListNode deleteDuplicates3(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
//        List<Integer> resultList = compressList(list);
        ListNode before = ReverseList.arrayList2linkedList(list);
        ListNode result = deleteDuplicates(before);
        System.out.println(result);
    }
}
