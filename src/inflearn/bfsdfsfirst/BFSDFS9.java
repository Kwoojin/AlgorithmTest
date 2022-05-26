package inflearn.bfsdfsfirst;

import java.util.Queue;
import java.util.LinkedList;

public class BFSDFS9 {
    Node root;

    public int BFS(Node node){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);
        int L=0;
        while(!Q.isEmpty()){
            int len= Q.size();
            for(int i=0; i<len; i++){
                Node cur = Q.poll();
                if(cur.lt == null && cur.rt == null) return L;
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }

    public int DFS(int L,Node node){
        if(node.lt == null && node.rt == null) return L;
        else return Math.min(DFS(L+1, node.lt),DFS(L+1, node.rt));
    }


    public static void main(String[] args) {
        BFSDFS9 tree = new BFSDFS9();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.rt = new Node(6);

        System.out.print(tree.BFS(tree.root));
        //System.out.print(tree.DFS(0,tree.root));
    }
}
