package tip;

import java.util.Random;

/**
 * 只有通过真实的随机事件产生的随机数才是真随机！！比如，通过机器的硬件噪声产生随机数、通过大气噪声产生随机数
 *这意味着：如果知道了种子，或者已经产生的随机数，都可能获得接下来随机数序列的信息（可预测性）
 *
 * 虽然二者都是伪随机，
 * 1 无参数构造方法（不设置种子）具有更强的随机性，能够满足一般统计上的随机数要求。
 * 2、使用有参的构造方法（设置种子）无论你生成多少次，每次生成的随机序列都相同，名副其实的伪随机！！
 */
public class RandomTest {
    public static void main(String[] args) {
        RandomTest rt = new RandomTest();
        rt.testRandom();
    }

    public void testRandom(){
        System.out.println("Random不设置种子：");
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(100) + ", ");
            }
            System.out.println("");
        }

        System.out.println("");

        System.out.println("Random设置种子：");
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            random.setSeed(100);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(100) + ", ");
            }
            System.out.println("");
        }
    }
}
