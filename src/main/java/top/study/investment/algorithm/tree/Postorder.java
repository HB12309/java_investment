package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/9 10:33 上午
 * @Version 1.0
 */
public class Postorder {
    /**
     * 后序遍历
     * 应该也是遍历，只是要for一下
     * 2021年06月09日11:04:09
     * 这个不行啊。先打到最底层，再回溯。。
     * @param root
     * @return
     */
    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderInner(root, res);
        return res;
    }

    /**
     * 2021年06月09日11:15:11
     * 用了10分钟，草草草。原来是这样。可以参考二叉树。后续就是最后再add
     * 但这里判断不一样。如果children==null了，就要直接add了 return了
     * 如果可以继续迭代，就要迭代完，在迭代完的外面 add 噢
     *
     * @param root
     * @param res
     */
    public static void postorderInner(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.children == null) {
            res.add(root.val);
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            Node node = root.children.get(i);
            postorderInner(node, res);
        }

        res.add(root.val);
    }

    public static void main(String[] args) {
        Node root = TreeUtil.buildNTree();
        List<Integer> res = postorder(root);
        System.out.println(res.get(0));
    }
}
