package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author qhb
 * @Date 2021/6/16 1:56 下午
 * @Version 1.0
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {
    /**
     * 2021年06月16日13:57:48
     *
     * 倒置来的，底下的先出来，优先考虑 Deque<Integer> stack = new LinkedList<>()
     *
     * hah, {@link LevelOrder#levelOrder(TreeNode)} 这个数组 reverse 不就好了？但这个蛋疼。。没必要吧
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            /**
             * 主要是这一句惊到我了，可以一直 add index 同一个啊。这样的话，之前的add的数据就会被往后推？测一下
             * 2021年06月17日09:21:52
             * 我日，真的啊。看{@link LevelOrderBottom#testLinkedList()}
             */
            levelOrder.add(0, level);
        }
        return levelOrder;
    }

    public static List<Integer> testLinkedList() {
        List<Integer> list = new LinkedList<>();
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        list.add(0, 4);
        return list;
    }
    public static void main(String[] args) {
        testLinkedList();
    }
}
