package inflearn.bfsdfsfirst;

public class BFSDFS5 {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        DFS(root);
    }

    public static void DFS(Node node){
        if(node.lt != null) DFS(node.lt);
        if(node.rt != null) DFS(node.rt);
        System.out.print(node.data+" ");
    }
}

