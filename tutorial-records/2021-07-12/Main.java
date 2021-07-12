public class Main {

    public static void main(String[] args) {
//        traverseSingleLinkedNodes();
//        traverseTwiceCircularLinkedNodes();
        useSingleLinkedList();
    }

    static void useSingleLinkedList(){
        SingleLinkedList list = new SingleLinkedList();
        list.add("Node-1");
        list.add("Node-2");
        list.add("Node-3");

        list.get(1);
        list.get(3);
        list.get(2);
    }
    
    static void traverseSingleLinkedNodes(){
        Node n1 = new Node("Node-1");
        Node n2 = new Node("Node-2");
        Node n3 = new Node("Node-3");

        n1.next = n2;
        n2.next = n3;

        // to traverse the nodes map only once

        // termination condition -> next == null
        Node pointer = n1;

        while(pointer.next != null){
            System.out.println(pointer.item);
            pointer = pointer.next;
        }

        System.out.println(pointer.item);
    }
    
    static void traverseTwiceCircularLinkedNodes(){
        Node n1 = new Node("Node-1");
        Node n2 = new Node("Node-2");
        Node n3 = new Node("Node-3");

        n1.next = n2;
        n2.next = n3;
        n3.next = n1;

        // termination condition -> 2 time of full traverse
        // cursor/point to the head node  
        Node pointer = n1;
        int counter = 0;
        
        // provide an infinite loop 
        while(pointer.next != null){
            // termination condition
            if(counter >= 2) break;
            
            System.out.println(pointer.item);
            pointer = pointer.next;
            
            // a way to measure one full traverse
            // compare with reference
            if(pointer == n1){
                counter++;
            }
        }
    }
    

}
