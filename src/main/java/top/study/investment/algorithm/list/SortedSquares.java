package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/8/11 4:33 下午
 * @Version 1.0
 */
public class SortedSquares {
    /**
     * 风骚啊。双指针，可以快慢指针，还有 step ，也可以是左右指针，逼近；也可以从中间发散。。
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] sortedArray = new int[length];

        int left = 0;
        int right = length - 1;
        int index = length - 1;

        for (int i = 0; i < length; i++) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare < rightSquare) {
                sortedArray[index] = rightSquare;
                right--;
            } else {
                sortedArray[index] = leftSquare;
                left++;
            }
            index--;

            if (left > right) {
                break;
            }

        }

        return sortedArray;

    }

    public static void main(String[] args) {
        /**
         * a b 是一样的
         */
        int[] a = {-3, -1, 0, 2, 5};
        int[] b = new int[] {-3, -1, 0, 2, 5};
        int[] sortedArray = sortedSquares(a);
        System.out.println(sortedArray.length);
        /**
         * 直接放{}在参数里就不行，必须 new int[]
         * 但是，在命令 int[] a = 就可以不要new
         */

//       int[] sortedArray = sortedSquares({-3, -1, 0, 2, 5});
//        int[] sortedArray = sortedSquares(new int[] {-3, -1, 0, 2, 5});

        /**
         * 2021年08月12日16:58:47
         * 啊啊啊，下面这两个东西是同一个东西，好难记啊。
         */
        Integer cacheA [];
        Integer[] cacheB;



    }
}
