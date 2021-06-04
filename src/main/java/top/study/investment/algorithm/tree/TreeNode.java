package algorithm.tree;

/**
 * @Author qhb
 * @Date 2021/6/4 3:52 下午
 * @Version 1.0
 */
public class TreeNode {
      int val = -999;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
