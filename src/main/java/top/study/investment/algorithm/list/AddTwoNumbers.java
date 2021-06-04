package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/4 10:59 上午
 * @Version 1.0
 * https://leetcode-cn.com/problems/add-two-numbers/
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
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {

    }
}
