package algorithm.list;

import java.util.Arrays;

/**
 * @Author qhb
 * @Date 2021/6/4 2:06 下午
 * @Version 1.0
 */
public class MergeInBetween {

    /**
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     *
     * 第一想法：就是老老实实构造，遍历。先构造 a 长度，然后得到 list1 的尾巴。
     * 再遍历b，得到b的尾巴，再接入。。
     * 就是得到新的 new 出来的那种
     * 害。这个的边界条件判断好麻烦。。
     *
     * 2021年06月04日15:08:06
     * 我的不足之处：while a-- >0 >=0 判断条件，不好定位来写，要debug。。费时
     */
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tempNode1 = dummyNode;

        // 接长度 a 的
        while (a-- > 0) {
            ListNode node1 = new ListNode(list1.val);
            tempNode1.next = node1;
            tempNode1 = node1;

            b--;
            list1 = list1.next;
        }
        // 接 b
        tempNode1.next = list2;
        /**
         * 走到 b 的尾巴，要留最后一个，寻找b的尾结点，一开始写的判断条件是 tempNode1 != null
         */
        while (tempNode1.next != null) {
            tempNode1 = tempNode1.next;
        }

        // 去掉 b-a 长度的
        while (b-- >= 0) {
            list1 = list1.next;
        }

        // 接a剩下的
        tempNode1.next = list1;
        return dummyNode.next;
    }

    /**
     * 提取[1,2,3,4,5,6] (2,5) -> [2,3,4,5]
     * @param head
     * @param a
     * @param b
     * @return
     */
    private static ListNode extract(ListNode head, int a, int b) {
        if (head == null) {
            return null;
        }

        // 从 a 处开始
        /**
         * 2021年06月04日14:32:44
         * --a, 先减，再判断，所以a=2进来，就只循环了一次噢，a--就是先判断再减，循环了2次噢。
         * 我觉得链表是从1开始的，当然，从0开始也ok，这里看每个人的理解啦
         *
         * 2021年06月04日15:09:37
         * 话说，现在实锤了啊。看来认知要改变，链表也要从0开始噢。
         */
        while (--a > 0) {
            b--;
            head = head.next;
        }

        ListNode newHead = head;

        while (--b > 0) {
            head = head.next;
        }
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode list1 = ReverseList.arrayList2linkedList(Arrays.asList(0, 1,2,3,4,5));
        ListNode list2 = ReverseList.arrayList2linkedList(Arrays.asList(10));

        ListNode result = mergeInBetween(list1, 3, 4, list2);
        System.out.println(result.val);
    }
}
