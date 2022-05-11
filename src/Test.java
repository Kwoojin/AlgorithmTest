import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        /*
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);

        linkedList.addNodeInside(4, 3);

        linkedList.delNode(1);

        linkedList.printAll();



        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.addNode(1);
        doubleLinkedList.addNode(2);
        doubleLinkedList.addNode(3);

        doubleLinkedList.insertToFront(0, 4);

        doubleLinkedList.printAll();

        Integer fromHead = doubleLinkedList.searchFromHead(4);
        Integer fromTail = doubleLinkedList.searchFromTail(2);

        System.out.println("fromHead = " + fromHead);
        System.out.println("fromTail = " + fromTail);
*/
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.addNode(6);
        MyLinkedList.printAll();
    }
}
