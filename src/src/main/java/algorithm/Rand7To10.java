package algorithm;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 有个 rand7(), 根据此来个 rand10
 * rand7() 需要自己构造。
 *
 * 心路历程：
 * 1、rand7 构造花费了一些精力，都怪平时copy太多，随机数要回手写，种子seek的含义是什么？[1,100]
 * 2、想的是 rand7*rand7 % 10，这没用，因为个位数为 8 9 的不一定出的来，要保证0-10都有，那还有什么思路呢？
 *
 *
 * 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
 * 关于seed的坑，随机数的坑
 * @see tip.RandomTest
 *
 * leetcode原题，没懂。需要查询什么叫做拒绝采样
 *
 */
public class Rand7To10 {

    /**
     * 这样为什么没有 max 呢？
     * 我发现这个东西，在0和负数之间是没用的，我草我草
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max) {
        if (min == 0 && max == 0) {
            return 0;
        }

        try {
            Random random = SecureRandom.getInstance("SHA1PRNG");
            return random.nextInt(max) % (max - min + 1) + min;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int rand7() {
        return getRandom(1, 7);
    }

    public static int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            int result = rand10();
            System.out.println(result);
        }
    }
}
