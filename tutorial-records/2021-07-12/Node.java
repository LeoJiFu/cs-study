public class Node {
    Object item;
    Node next;
    
    Node(Object value){
        this.item = value;
    }

    Node(Object value, Node next){
        this.item = value;
        this.next = next;
    }
}
