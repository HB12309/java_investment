package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/2 10:49 上午
 * @Version 1.0
 * @see: leetcode 143
 * https://leetcode-cn.com/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
 */
public class ReorderList {
    /**
     * 重排列表 l0,l1,l2,ln -> l0,ln, l1,ln-1, l2,ln-2
     * 并且要进行实质的交换，而不是改变值
     *
     * 第一想法：node -> list -> 交换值 -> nodelist，则不行，因为这只是改变了值
     *
     * 第二步：
     * 所以，新的想法是：拿个map来装，key=index,value=节点，好像不行啊，太浪费了
     * 第三步：
     * 噢噢，拼接的话，index有序访问，应该用 List 来装啊，TreeMap 废除
     * 第四步：
     * 把尾巴直接砍掉啊，不行，值传递是情况下，head居然只有一个。。
     *
     */
    public static ListNode reorderList(ListNode head) {
        // 边界处理
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
//        Map<Integer, ListNode> map = new TreeMap<Integer, ListNode>();
        // 太浪费了啊哈哈哈，能不能做出来呢？..对啊，把尾巴直接砍掉啊。。next == null

        // 我草。value.next = null; 影响了 head 的情况啊
        while (head != null) {
            ListNode value = head;
            value.next = null;
            list.add(value);
            head = head.next;
        }

        ListNode result = new ListNode();
        ListNode temp = result;

        int length = list.size();
        for (int i = 0; i < length/2; i++) {
            ListNode before = list.get(i);
            ListNode after = list.get(length-1);
            temp.next = before;
            before.next = after;

            temp = after;
        }
        return result.next;
    }

    /**
     * 1、真的可以 List<ListNode> list 这样啊。虽然浪费，但是也可以啊666
     * 2、重排就好了啊
     * @param head
     */
    public static void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        // 最后一句忘了处理啦啊啊啊
        list.get(i).next = null;
    }

    public static void main(String[] args) {
        ListNode head = ReverseList.arrayList2linkedList(Arrays.asList(1,2,3,4,5));
        ListNode result = reorderList(head);
        System.out.println(result.val);
    }
}
