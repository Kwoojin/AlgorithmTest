public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = new Node<T>(data);
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;

            /*
            Node<T> node = this.head;
            while( node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
             */
        }
    }

    public void printAll() {
        if(head != null) {
            Node<T> node = this.head;
            while(node != null){
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public T searchFromHead(T isData) {
        if(this.head == null) return null;
        else {
            Node<T> node = this.head;
            while(node != null){
                if(node.data == isData) return node.data;
                node = node.next;
            }
            return null;
        }
    }

    public T searchFromTail(T isData) {
        if(this.tail == null) return null;
        else {
            Node<T> node = this.tail;
            while(node != null){
                if(node.data == isData) return node.data;
                node = node.prev;
            }
            return null;
        }
    }

    public boolean insertToFront(T existedData, T addData) {
        if(this.head == null) {
            addNode(addData);
            return true;
        }
        else if(this.head.data == existedData){
            Node<T> addDataNode = new Node<T>(addData);
            addDataNode.next = this.head;
            this.head.prev = addDataNode;

            this.head = addDataNode;
            return  true;
        }
        else {
            Node<T> node = this.head;
            while(node.next != null){
                if(node.next.data == existedData) {
                    Node<T> addDataNode = new Node<T>(addData);
                    node.next.prev = addDataNode;
                    addDataNode.next = node.next;

                    node.next = addDataNode;
                    addDataNode.prev = node;

                    return true;
                }
                node = node.next;
            }
            return false;
        }
    }
}
