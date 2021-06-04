package algorithm.list.copyRandomList;

import java.util.HashMap;

/**
 * @Author qhb
 * @Date 2021/6/3 2:18 下午
 * @Version 1.0
 */
public class CopyRandomList {

    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     *
     * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
     *
     * @return
     */
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    /**
     * 哈希表Mydic映射原有节点->新的节点
     * 原节点为空，则返回空
     * 原节点在哈希表中可以找到，则说明新的节点已生成，直接返回
     * 根据原有节点的值，创建新的节点root = Node(node.val)
     * 将原有节点和新节点的对应关系添加到哈希表中Mydic[node] = root
     * 最后参照原节点的next和random关系，创建新的next和random节点给新节点root
     * 递归整个过程
     * @param head
     * @return
     *
     * 2021年06月03日14:44:19
     * 1、原来怎么来的，copy就是怎么来的，牛逼
     * 2、居然还可以请外援 Map 放在外面，因为要递归，所以不能放里面，第一次碰到外援情况，牛逼
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // If we have already processed the current node, then we simply return the cloned version of it.
        if (visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val, null, null);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    public static void main(String[] args) {

    }
}
