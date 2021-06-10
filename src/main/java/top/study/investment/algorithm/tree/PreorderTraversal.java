package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/9 10:29 上午
 * @Version 1.0
 */
public class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree();
        List<Integer> list = preorderTraversal(root);
        System.out.println(list.get(1));
    }
}
