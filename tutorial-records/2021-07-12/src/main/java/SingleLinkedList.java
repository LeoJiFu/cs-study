public class SingleLinkedList {
    MyNode head;
    
    int size;
    
    SingleLinkedList(){
        
    }
    
    private MyNode traverseToNthNode(int targetIndex){
        int curIndex = 0;
        MyNode pointer = head;
        
        while (head.next != null) {
            
            if(curIndex == targetIndex) {
                return pointer;
            }
            
            pointer = head.next;
            curIndex++;
        }
        
        return pointer;
    }

    private MyNode traverseToLastNode(){
        MyNode pointer = head;
        
        while (true) {
            if(pointer == null || pointer.next == null) {
                // found the last node
                return pointer;
            }
            
            pointer = pointer.next; 
        }
    }

    public void add(Object item){
        MyNode newNode = new MyNode(item);
        MyNode lastNode = traverseToLastNode();
        
        if(lastNode == null) {
            head = newNode;
        }else {
            lastNode.next = newNode;
        }    
        
        this.size++;
    }
    
    // TODO, fix the bug
    public Object get(int index){
        Object value = traverseToNthNode(index).item;
        System.out.println(value);
        return value;
    }
    
    public void insert(int index, Object item){
        
    }
}
