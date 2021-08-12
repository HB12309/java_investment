package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author qhb
 * @Date 2021/6/17 11:07 上午
 * @Version 1.0
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveDuplicates {
    /**
     * 可以用栈，最后要转化为字符串。。这
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {
        int len = s.length();
        if (s == null || len <= 1) {
            return s;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            Character character = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(character);
                continue;
            }
            // 比较，相同则移除
            Character beforeChar = stack.peek();
            if (character.equals(beforeChar)) {
                stack.pop();
                continue;
            }

            // 不相同
            stack.push(character);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.removeLast());
        }
        return stringBuilder.toString();
    }

    public String removeDuplicates2(String s) {
        /**
         * 2021年06月17日11:25:36 最神奇的就是，StringBuffer 本身就有定位，还有 deleteCharAt 等功能
         * 这个感觉比我的更快
         *
         * 如果还要更快，就不要用 StringBuffer 啦
         */
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }


    public static void main(String[] args) {
        String result = removeDuplicates("aabbbc");
        result.length();
    }
}
