package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

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
    }

    public static Node buildNTree() {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        Node g = new Node(8);
        Node h = new Node(9);

        List<Node> abc = new ArrayList<>();
        abc.add(a); abc.add(b); abc.add(c);
        root.children = abc;

        List<Node> de = new ArrayList<>();
        de.add(d); de.add(e);
        a.children = de;

        List<Node> fgh = new ArrayList<>();
        fgh.add(f); fgh.add(g); fgh.add(h);
        b.children = fgh;

        return root;
    }
}
