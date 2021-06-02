package algorithm.list;

import java.util.Arrays;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/2 9:01 上午
 * @Version 1.0
 * 是否是回文链表
 * @see: leetcode 234
 */
public class PalindromeLinkedList {

    /**
     * 单项链表，第一想法。回文链表、回文数组、回文字符串，都是一样的暴力解法，
     * 转化为数组，然后 head tail 指针循环，如果相同的就继续循环，不同的直接返回 false
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        List<Integer> list = ReverseList.linkedList2list(head);
        int length = list.size();
        boolean result = true;
        for (int i = 0; i < length; i++) {
            int j = length - i - 1;
            if (!list.get(i).equals(list.get(j))) {
                result = false;
                break;
            }
            // 后面没必要判断了。。
            if (i > j) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = ReverseList.arrayList2linkedList(Arrays.asList(1,2,2,2,2,1));
        boolean result = isPalindrome(head);
        System.out.println(result);
    }
}
