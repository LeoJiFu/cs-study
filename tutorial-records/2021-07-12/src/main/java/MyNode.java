public class MyNode {
    Object item;
    MyNode next;
    
    MyNode(Object value){
        this.item = value;
    }

    MyNode(Object value, MyNode next){
        this.item = value;
        this.next = next;
    }
}
