package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class NumberUtil {
    /**
     * 这样为什么没有 max 呢？
     * 我发现这个东西，在0和负数之间是没用的，我草我草
     * @param min
     * @param max
     * @return
     */
    private static int getRandomWithoutZero(int min, int max) {
        try {
            Random random = SecureRandom.getInstance("SHA1PRNG");
            return random.nextInt(max) % (max - min + 1) + min;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int getRandomWithZero(int min, int max) {
        try {
            Random random = SecureRandom.getInstance("SHA1PRNG");
            return random.nextInt(max) % (max - min) + min + 1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getRandom(int min, int max) {
        if (max < min) {
            return 0;
        }

        if (min > 0) {
            return getRandomWithoutZero(min, max);
        }
        if (min == 0) {
            return getRandomWithZero(min, max);
        }
        if (max == 0) {
            return -getRandomWithZero(max, -min);
        }
        if (max < 0) {
            return -getRandomWithZero(-max, -min);
        }
        if (min < 0 && max > 0) {

        }


        return 0;
    }

}
