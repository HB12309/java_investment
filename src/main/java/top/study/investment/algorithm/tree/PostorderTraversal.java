package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/4 3:52 下午
 * @Version 1.0
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class PostorderTraversal {

    /**
     * 后序遍历，左右中
     * @param root
     * @return
     * 2021年06月04日16:17:57
     *
     * 看了答案，我这里用 static 其实是不合适的，因为这就只能运行一次，所以要改造题目， list 可以传参进去
     */
    private static List<Integer> list = new ArrayList<>();

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }


    /**
     * 这就是官方文档，res 作为结果传入，是存的变量的指针嘛，所以开辟的空间可以放东西。
     * 话说，res到底是什么呢？res是资源吧 resource or rest ？我觉得是 resource
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }
    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree();
        List<Integer> list = postorderTraversal(root);
        System.out.println(list.get(1));
    }
}
