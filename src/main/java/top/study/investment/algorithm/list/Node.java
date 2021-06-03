package algorithm.list;

/**
 * @Author qhb
 * @Date 2021/6/3 2:19 下午
 * @Version 1.0
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
