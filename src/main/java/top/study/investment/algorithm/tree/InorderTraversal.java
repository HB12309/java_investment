package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/9 10:15 上午
 * @Version 1.0
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

    /**
     * 2021年06月09日10:24:33
     * 重大发现。。我之前太蠢了啊
     * 中序就是: res.add(root.val); 在中间啊。后序就是在后面啊，前序就是在前面啊我日
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree();
        List<Integer> list = inorderTraversal(root);
        System.out.println(list.get(1));
    }
}
