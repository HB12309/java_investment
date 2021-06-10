package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/9 10:33 上午
 * @Version 1.0
 */
public class Preorder {
    /**
     * 前序遍历
     * 应该也是遍历，只是要for一下
     * @param root
     * @return
     */
    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderInner(root, res);
        return res;
    }

    public static void preorderInner(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.children == null) {
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            preorderInner(root.children.get(i), res);
        }
    }

    public static void main(String[] args) {
        Node root = TreeUtil.buildNTree();
        List<Integer> res = preorder(root);
        System.out.println(res.get(0));
    }
}
