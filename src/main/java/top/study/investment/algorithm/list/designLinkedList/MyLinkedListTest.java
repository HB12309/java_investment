package algorithm.list.designLinkedList;

/**
 * @Author qhb
 * @Date 2021/6/4 9:16 上午
 * @Version 1.0
 */
public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(8);
        myLinkedList.addAtHead(7);
        int val = myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList);
    }
}
