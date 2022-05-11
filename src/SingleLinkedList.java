public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T>{
        T data;
        Node next=null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }

    public boolean delNode(T data) {
        if(this.head == null) return false;
        else {
            Node<T> node = this.head;
            if(node.data == data){
                this.head = node.next;
                return true;
            }
            while(node.next != null){
                if(node.next.data == data) {
                    node.next = node.next.next;
                    return true;
                }
                node = node.next;
            }
            return false;
        }
    }

    public void printAll(){
        if(head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public void addNodeInside(T data, T isData){
        Node<T> searchedNode = search(isData);
        if(searchedNode == null){
            addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }

    public Node search(T data) {
        if(this.head == null) {
            return null;
        }
        else {
            Node<T> node = this.head;
            while(node != null){
                if(node.data == data) return node;
                node = node.next;
            }
        }
        return null;
    }
}
