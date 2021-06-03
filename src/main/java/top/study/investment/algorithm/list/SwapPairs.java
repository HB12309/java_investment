package algorithm.list;

import java.util.Arrays;

/**
 * @Author qhb
 * @Date 2021/6/3 2:46 下午
 * @Version 1.0
 */
public class SwapPairs {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head
     * @return
     *
     * 2021年06月03日15:14:27
     * 递归：一层一层解决问题
     * rest 是剩下的，newHead就是新的头，对的。第一次swap的时候，head.next 就是新的头。
     * 交换，本质就是打断之前的连接，建立新的连接。原有有几个要打断，就要接上新的几个。
     * 然后next后对于剩下的继续交换，直至退出。
     * 退出条件是结束了或者下一个没有了
     *
     * 这个算法的精妙在于：命名正确。
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rest = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(rest);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ReverseList.arrayList2linkedList(Arrays.asList(1,2,3,4));
        ListNode result = swapPairs(head);
        System.out.println(result);
    }
}
