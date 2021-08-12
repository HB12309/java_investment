package algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author qhb
 * @Date 2021/6/16 1:52 下午
 * @Version 1.0
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzaLevelOrder {
    /**
     * 2021年06月16日13:55:06
     * 参考 {@link LevelOrder#levelOrder(TreeNode) } 层序遍历，并且判断奇数偶数，如果奇数就从左往右，偶数从右往左
     * @param root
     * @return
     *
     * 为了满足题目要求的返回值为「先从左往右，再从右往左」交替输出的锯齿形，我们可以利用「双端队列」的数据结构来维护当前层节点值输出的顺序。
     * 双端队列是一个可以在队列任意一端插入元素的队列。
     */
    public static List<List<Integer>> zigzaLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            /**
             * 双端队列，Deque，这个可以作为 stack 也可以作为队列啊。牛逼。就看怎么命名怎么用了
             */
            Deque<Integer> levelList = new LinkedList<Integer>();
            /**
             * levelList.addFirst();
             * levelList.offerFirst();
             * 好家伙，这两个API是一样的，返回值不同，我可以理解为 add 是 list 喜欢用的， offer 是
             */
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                    /**
                     * public interface Deque<E> extends Queue<E>
                     * 所以这里也有不同啊。。
                     * levelList.addFirst(curNode.val);
                     */
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }

            ans.add(new LinkedList<Integer>(levelList));
            /**
             * 好家伙，直接取反，对啊。这样就不需要 % 2 算奇数偶数了。
             */
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
