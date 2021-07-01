import java.util.ArrayList;

class MyList{
    
    // Only constructor and static methods/fields belong to MyList class
    // Others are belongs to instance, which can be accessed by this
    private static int CAPACITY = 3;
    private static int EXPAND_RADIO = 2;
    
    // fields
    private Object[] _arr;
    private int _currentLength = 0;

    // constructor -> to construct fields for the instance 
    MyList(){
        this._arr = new Object[CAPACITY];
    }
    
    // methods
    private boolean isOutOfCapacity(){
        return this._currentLength >= CAPACITY;    
    }
    
    private void expandArray(){
        Object[] tempArr = new Object[EXPAND_RADIO * this._currentLength];

        // copy over origin arr to the temp array
        for (int i=0; i<this._arr.length; i++) {
            tempArr[i] = this._arr[i];
        }

        this._arr = tempArr;
    }
    
    // O(1)
    public void add(Object item){
        if(this.isOutOfCapacity()) {
           this.expandArray();
        }
    
        this._arr[this._currentLength] = item;
        this._currentLength++;    
    }

    // O(n)
    // need to shift index
    public void insert(int index, Object item){
        
    }
    
    // O(n)
    // need to shift index
    public Object remove(int index) throws Exception {
        if(index >= this._currentLength) throw new Exception("Out of index");
        
        Object value = this.get(index);
        
        // re-index
        // shift over
        for(int i=index+1; i<this._currentLength; i++) {
            Object nextValue = this._arr[i];
            this._arr[i-1] = nextValue;
        }
        
        return value;
    }

    // O(1)
    public Object get(int index){
        return this._arr[index];
    }
    
    public int size(){
        return this._currentLength;
    }
    
} 


public class Main {
    
    public static void main(String[] args) {
        
        MyList l1 = new MyList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);

        MyList l2 = new MyList();
        l2.add(11);

        ArrayList<Object> lJava = new ArrayList<Object>();
        lJava.add(11);
        
    }
}
