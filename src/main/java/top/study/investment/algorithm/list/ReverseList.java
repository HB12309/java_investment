package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/5/31 5:11 下午
 * @Version 1.0
 * 反转链表，数据结构看
 * @see： leetcode206
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
    public static List<Integer> linkedList2list(ListNode listNode) {
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

    /**
     * 2021年06月02日13:52:35
     * 说：迭代形的 reverse 没做很好，需要理解这个。一定要理解，因为这是 base，后面进阶的都要用到这个方法
     * @param head
     * @return
     *
     * 2021年06月02日20:29:29说对噢，好简单，反转指针，一个 prev 一个 curr，直接反转就好了，因为 linked最后一定是null
     * 这是经典的。
     * 所以我觉得：linked经典的就是 reverse 回文、还有和数组的各种操作，
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // 下一个要用的
            ListNode nextTemp = curr.next;
            // 反转
            curr.next = prev;
            // prev curr 各自往后面挪一个
            prev = curr;
            curr = nextTemp;
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
