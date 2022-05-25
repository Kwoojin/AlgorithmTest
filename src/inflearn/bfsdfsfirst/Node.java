package inflearn.bfsdfsfirst;

public class Node {
    int data;
    Node lt, rt;
    public Node(int val){
        this.data = val;
        lt=rt=null;
    }
}