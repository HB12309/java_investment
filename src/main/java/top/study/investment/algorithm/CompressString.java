package algorithm;

/**
 * @time: 2021年05月26日09:26:46
 *
 * @题目：字符串压缩，比如 "aaabbcccca", 变成 "a3b2c4a1"，如果压缩后新字符串更长，则返回旧串，否则返回新串
 *
 * 心路历程：
 * 1、aabcc -> [a,a,b,c,c]
 */
public class CompressString {
    public static String compressString(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        int charLength = chars.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<charLength; i++) {
            int j = i+1;
            // 最后一个了，还单着,就一个嘛说明
            if (i == charLength - 1) {
                stringBuilder.append(chars[i]);
                stringBuilder.append(1);
                break;
            }


            int count = 1;
            // 边界问题
            while (j<charLength && chars[i] == chars[j]) {
                count++;
                j++;
            }
            // 直到不同，组装字符串。i跳走，j重置
            stringBuilder.append(chars[i]);
            stringBuilder.append(String.valueOf(count));
            i = j - 1;
        }
        String newStr = stringBuilder.toString();
        // 压缩不值当
        if (newStr.length() >= s.length()) {
            return s;
        }
        return newStr;

    }

    public static void main(String[] args) {
        String s = "aaabb";
        String result = compressString(s);
        System.out.println(result);
    }
}
