package algorithm.list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author qhb
 * @Date 2021/6/4 10:59 上午
 * @Version 1.0
 * https://leetcode-cn.com/problems/add-two-numbers/
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers {
    /**
     * 逆序两数相加
     *
     * @param l1
     * @param l2
     * @return
     *
     * 2021年06月04日11:03:10
     * 第一想法：
     * 1、先去除边界条件
     * 2、迭代，拿一个变量去存储，值，然后做加法，往下走。只要一个ListNode迭代完成，再把另外一个接上。继续迭代（因为要判断是否继续，后面那个是9999这样下去）
     * 3、自己构造一个去add吧。。不要复用l1 l2 了
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int MOD = 10;
        int sum = 0;
        int nextAdd = 0;
        ListNode addNode = new ListNode(0);
        ListNode addNodeTemp = addNode;
        while (l1 != null || l2 != null) {
            sum = l1.val + l2.val;
            int value = sum % MOD;
            //
            ListNode node = new ListNode(value+nextAdd);
            nextAdd = sum / MOD;
            addNodeTemp.next = node;
            // 迭代
            addNodeTemp = addNodeTemp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        //l1 == null ? (addNode.next = l2) : (addNode.next = l1);

        return addNode.next;
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     * 2021年06月04日11:26:46
     * 相比于我自己的，这里有几个亮点：
     * 1、while继续的地方有 carry，l1 l2 就算断了，carry进制没结束，就算没结束
     * 2、int carry = 0, newVal = 0; 放外面我也是这样
     * 3、newVal 判断null的操作，就可以继续，不需要我在那样接尾巴了。
     * 4、newVal carry 的判断。。原来是这样。
     *
     * 2021年06月04日13:47:05
     * 来自于词典：n. 运载；[计] 进位；射程  == carry
     * 噢噢，addTwoNumbers2计算的顺序和next指向是相同的，这就简单。addTwoNumbers3方向相反，就麻烦一些
     *
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0, newVal = 0;
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0: p1.val) + (p2 == null ? 0: p2.val) + carry;
            carry = newVal / 10;
            newVal %= 10;
            p.next = new ListNode(newVal);
            p1 = p1 == null? null: p1.next;
            p2 = p2 == null? null: p2.next;
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 相比于{@link AddTwoNumbers#addTwoNumbers2(ListNode, ListNode)},这里是倒着来的
     * 并且不推荐用{@link ReverseList#reverseList2(ListNode)} 来 reverse，所以要用其他办法
     * 即：如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     * 本题的主要难点在于链表中数位的顺序与我们做加法的顺序是相反的，为了逆序处理所有数位，我们可以使用栈：把所有数字压入栈中，再依次取出相加。计算过程中需要注意进位的情况。
     *
     * 逆序，可以想到 stack or list
     *
     * @param l1
     * @param l2
     * @return
     *
     * 2021年06月04日13:57:04
     * 用Diagram看{@link LinkedList} 然后 Deque<Integer> stack1 ，看，命名完全不同，我一开始是懵逼的。然后想了想，
     * 牛逼，LinkedList的 Node 节点底层是一个双向链表，同样在 public interface Deque<E> 文档里面，清楚地写着: Queue methods
     * Stack methods Collection methods，也就是说双向链表的数据结构，是可以实现这么多方法的，这里只是用了栈的特性，先进后出。
     * 同样的，只要愿意，LinkedList 也可以像队列一样先进先出的。
     * 这就是：Deque<Integer> stack1 = new LinkedList<Integer>();
     *
     */
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();
        // 入栈
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode ans = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int newVal = a + b + carry;
            carry = newVal / 10;
            newVal %= 10;
            ListNode newNode = new ListNode(newVal);
            newNode.next = ans;
            ans = newNode;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
