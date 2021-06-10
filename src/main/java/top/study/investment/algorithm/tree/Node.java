package algorithm.tree;

import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/9 10:32 上午
 * @Version 1.0
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int value) {
        val = value;
    }

    public Node(int value, List<Node> childrens) {
        val = value;
        children = childrens;
    }
}
