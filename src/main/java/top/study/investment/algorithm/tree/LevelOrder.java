package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author qhb
 * @Date 2021/6/9 11:18 上午
 * @Version 1.0
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {
    /**
     * 2021年06月09日11:26:00
     *
     * 广度优先搜索 深度优先搜索，这是什么？
     * 所以前序、中序、后序都是什么搜索？
     *
     * level 这个是广度优先搜索
     *
     * @param root
     * @return
     *
     * Queue<TreeNode> queue = new LinkedList<>();
     * List<Integer> list = new ArrayList<Integer>();
     * Deque<Integer> stack1 = new LinkedList<Integer>();
     *
     * 三种的背诵，队列、数组、栈。名称不同，底层可以相同
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree();
        List<List<Integer>> list = levelOrder(root);
        System.out.println(list.get(0));
    }
}
