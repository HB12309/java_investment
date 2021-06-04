package algorithm.tree;

/**
 * @Author qhb
 * @Date 2021/6/4 3:53 下午
 * @Version 1.0
 */
public class TreeUtil {

    public static TreeNode buildTree() {
        int[] array = {1,2,3,4,5,6};
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        root.left = a; root.right = b;
        a.left = c; a.right = d;
        b.left = e;

        return root;
//        TreeNode temp = root;
//        for (int i = 0; i < array.length; i++) {
//            if (temp.val == -999) {
//                temp.val = array[i];
//            }
//
//        }
    }
}
