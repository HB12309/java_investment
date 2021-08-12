package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/8/11 3:41 下午
 * @Version 1.0
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        /**
         * 第一次在 for 里面，看到两个变量这样的。之前一般都 ijk ，看到了这个真震惊。
         */
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        /**
         * 无论是 List 还是 int[]，其拿到的都是 [I@47089e5f 这样 print 出来的，说明拿到的是地址。但Java下，地址都是托管给 JVM 管理的
         */
        int[] array = {1,2,3,2};
        int size = removeElement(array, 2);
        System.out.println(size);
    }
}
