package algorithm;

/**
 * @Author qhb
 * @Date 2021/6/3 3:31 下午
 * @Version 1.0
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        // 长度是在里面啊。[0,0,.....0]
        // 如果是 new int[]{8} -> [8,8,8...8]
        int[] res = new int[length];
        // 只需要比较 length - 1就好了，然后最后一个默认是0，这里省略了一个循环
        for (int i = 0; i < length - 1; i++) {
            for (int j =  i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    // 就是这里，间距== j-i
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] temperatures = {73};
        int[] result = dailyTemperatures(temperatures);
        System.out.println(result);

    }
}
