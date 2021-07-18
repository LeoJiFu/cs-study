

import oop.Student;
import oop.TopStudent;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // ++a vs a++
        int n = 1;
        System.out.println(n++); // return n; print(n); 1->2; 
        int m = 1;
        m++; // ++m
        System.out.println(m); // 2->3; return n; print(n)
        
        // passing by value
        // int -> Integer 
        // bool -> Boolean
        // string -> String
        int a = 1;
        int b = a;
        
        a++;
//        ++a;
        
        System.out.println(b); //  2
        
        System.out.println("---");
        
//        Integer a1 = 1;
//        Integer b1 = a1;
//        a1++;
////        ++a1;    
//        System.out.println(b1); // 2

        String aS = "abc";
        String bS = aS;

        aS += "dsfsdf";

        System.out.println(aS);
        System.out.println(bS);


        // passing by refs
        ArrayList a1 = new ArrayList();
        a1.add(1);

        ArrayList b1 = a1;
        
        a1.add(2);
        
        System.out.println(b1);
        
        // non-primitive
        // object 
        
        
        // child type can be assigned to parent type
        // casting 
        Number num = new Integer(1);
        
        // parent type cannot be assinged to child type

        Student s1 = new Student("Leo1");
        TopStudent s2 = new TopStudent("Leo2", 4.5);
        
        System.out.println(s1);

        isAbleToPlayPingPong(s1);

        isAbleToPlayPingPong(s2);
        
        // class -> service
        // main -> client/consumer who are tyring to use our classes
        Calculator cal = new Calculator(new LinkedListArray());
        cal.add();
        cal.delete();

        Calculator cal2 = new Calculator(new ArrayArray());
        cal2.add();
        cal.delete();

    }
    
    // utility function 
    // base/parent/generic type
    public static boolean isAbleToPlayPingPong(Student student){
        return true;
    }

// vs
//    public static boolean isTopStudent(TopStudent student){
////        if(student != null) {
////            return true;
////        }
////        return false;
//    }
    
    //ADT
    // abstract data type
    
}

// interface/ abstraction
// no implementation
// interface oriented
// decouple implementation logic
// design pattern
// specification
// 1 -|-->- many
abstract class BaseArray{
    public abstract void add();
    
    void delete(){
        System.out.println("Base delete function");
    }
} 

// implementation
class LinkedListArray extends BaseArray{

    @Override
    public void add() {
        System.out.println("LinkedListArray add function");
    }
}

class ArrayArray extends BaseArray{

    @Override
    public void add() {
        System.out.println("ArrayArray add function");

    }
}
// Calculator c1 = new Calculator([1,2,3,4])
// c1.sum() => 10
// sum = 0
// this.array.forEach(item => sum += item)
// return sum 

// c1.add(5)
// this.array.add(5)
// decouple 
class Calculator{
    BaseArray array;
    
    Calculator(BaseArray array){
        this.array = array;
    }

    // overloading
//    Calculator(BaseArray array, int a){
//        this.array = array;
//    }
    
    public void add(){
        array.add();
    }

    public void delete(){
        array.delete();
    }
}

// linked list
// O -> O -> O

// array
// 



