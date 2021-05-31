package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/5/31 5:11 下午
 * @Version 1.0
 * 反转链表，数据结构看
 * @see ListNode
 */
public class ReverseList {

    /**
     * 第一想法：1、链表->list -> reverse -> buildList
     * @param listNode
     * @return
     */
    public static ListNode reverseLinkedList(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        List<Integer> startList = linkedList2list(listNode);
        List<Integer> reverseList = reverseArrayList(startList);
        return arrayList2linkedList(reverseList);
    }

    /**
     * 链表 -> ArrayList
     * @param listNode
     * @return
     */
    private static List<Integer> linkedList2list(ListNode listNode) {
        List<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
        ListNode tempNode = listNode;
        while (tempNode != null) {
            list.add(tempNode.val);
            tempNode = tempNode.next;
        }
        return list;
    }

    /**
     * 反转数组
     */
    private static List<Integer> reverseArrayList(List<Integer> list) {
        List<Integer> reverseList = new ArrayList<Integer>();
        if (list == null) {
            return reverseList;
        }

        int size = list.size();
        for (int i=0; i<size; i++) {
            reverseList.add(list.get(size-i-1));
        }

        return reverseList;
    }

    /**
     * ArrayList -> 单项链表
     * @param list
     * @return
     */
    public static ListNode arrayList2linkedList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        ListNode root = new ListNode();
        root.val = list.get(0);
        if (list.size() == 1) {
            return root;
        }

        ListNode temp = root;

        for (int i=1; i<list.size(); i++) {
            ListNode tempNode = new ListNode();
            tempNode.val = list.get(i);

            temp.next = tempNode;
            temp = tempNode;
        }

        return root;
    }


    public static ListNode reverseList2(ListNode listNode) {
        if (listNode == null) {
            return listNode;
        }
        ListNode prev = null;
        ListNode curr = listNode;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            curr = next;


            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        ListNode beforeListNode = arrayList2linkedList(list);

        ListNode afterListNode = reverseLinkedList(beforeListNode);
        System.out.println(afterListNode.val);
    }
}
