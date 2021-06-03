package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/3 3:23 下午
 * @Version 1.0
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class OddEvenList {

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
     * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * @param head
     * @return
     *都看懂了吧，
     * 1、先一个左正蹬，把奇数节点串一块儿，
     * 2、再一个右鞭腿，把偶数节点串一起，
     * 3、然后啪，很快啊，把两个连成一条链表，可以说是训练有素，有bear来了。
     *
     */
    private static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {

    }
}
