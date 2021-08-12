package algorithm.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author qhb
 * @Date 2021/6/17 10:01 上午
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @Version 1.0
 */
public class ValidSymbol {
    public static void main(String[] args) {
        boolean result = isValid("{]{");
        System.out.println(result);
    }

    private static Character getMatch(Character character) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        map.put('}', null);
        map.put(')', null);
        map.put(']', null);
        return map.get(character);
    }

    /**
     * 2021年06月17日10:03:06
     * @param s
     * @return
     * 把字符串搞成数组压栈，下一个比较，相同则走人，不同则继续压栈，最后看看栈是否为空。
     *
     * 哎，其实我觉得双端队列也是可以的吧
     */
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return false;
        }

        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            // 没有则直接压进去，和下一个比较
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            // 比较，相同则移除
            Character beforeChar = stack.peek();
            Character match = getMatch(beforeChar);
            System.out.println("i:" + i);
            Character nowChar = chars[i];
            if (match != null && match.equals(nowChar)) {
                stack.pop();
                continue;
            }
            // 不相同
            stack.push(chars[i]);
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        int n = s.length();
        /**
         * 2021年06月17日10:49:38
         * 牛逼，对噢，只要是奇数，一定不匹配，走人
         */
        if (n % 2 == 1) {
            return false;
        }

        /**
         * 初始化的方式优雅很多嘛，参考{@link ValidSymbol#getMatch(Character)}
         */
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            /**
             * 对噢，可以直接 charAt,就不需要转化为数组啦
             */
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
