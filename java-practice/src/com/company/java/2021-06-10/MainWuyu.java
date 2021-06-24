
// Act as a manager, to control how to interact with other defined class
public class MainWuyu {
    public static void main(String[] args){
        System.out.println("leo");
        
        // primitive type
        // int float string boolean
        // + - * 

        int a = 1;
        int b = a;
        
        Number n1 = 1;
        Number n2 = 1.2;
//        Number s2 = new MyNumber();
        a++;
        
        System.out.println(b); //  2
        
        
        // object type
        // Integer Boolean String
        
        // procedure programming
        
        // object oriented
        Student s1 = new Student(18, "leo1"); // @123
        Student s2 = new Student(19, "leo2"); // @124
        Student s3 = s1;
        
//        s1.name = "leo3";
//        System.out.println(s1);
//        System.out.println(s3);

        System.out.println(s1.canPlayPingPong());
        System.out.println(s2.canPlayPingPong());
        
        // instantiation
//        Account a1 = new Account('1');
        OCBCAccount o1 = new OCBCAccount("id-1");
        // generic type
        Account o2 = new DBSAccount("id-2");
        processAccount(o1);
        processAccount(o2);
        
        o1.getAccountId();
        o1.getType();

        // static is associated with class factory
        // only been initialized once
        System.out.println(Student.schoolName);
        
        // null-static function/fields will belong the the instance
        // which means, will been initialized at the time the instance constructed
    }


    /**
     * 
     * @param account should be an Account type
     */
    // oop: abstraction oriented 
    static void processAccount(Account account){
        if(account.getType() == "DBS"){
            account.canBeenProcessed = true;
        }else {
            account.canBeenProcessed = false;
        }
    }
}

// Single responsibility 
// Factory -> instance

// We can encapsulate all the logics related with student to the Student class
// Should be registered to run time pool, @100
class Student {
    // private fields
    private int _age;
    String name;
    
    static String schoolName = "swjtu";
    
    // Construction 
    Student(int age, String name){
        // @123
        this._age = age;
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name + " " + this._age;
    }
    
    boolean canPlayPingPong(){
        if(this._age > 18) {
            return true;
        }
        
        return false;
    }
}

// define the abstraction
abstract class Account {
    String accountId;
    boolean canBeenProcessed;

    Account(String accountId){
        this.accountId = accountId;
    }
    
    String getAccountId(){
        System.out.println("account id" + this.accountId);
        return this.accountId;
    }
    
    // define the behaviours of the account
    // define the protocol
    abstract String getType();
}

// inherit
// implementation
class OCBCAccount extends Account{
    String accountType;

    OCBCAccount(String accountId) {
        super(accountId);
        this.accountType = "OCBC";
    }
    
    @Override
    String getType(){
        return this.accountType;
    }
    
}

class DBSAccount extends Account{
    String accountType;

    DBSAccount(String accountId) {
        super(accountId);
        this.accountType = "DBS";
    }

    @Override
    String getType(){
        return this.accountType;
    }

}

class MyNumber extends Number{

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}