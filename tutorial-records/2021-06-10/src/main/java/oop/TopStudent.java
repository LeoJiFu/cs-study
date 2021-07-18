package oop;

public class TopStudent extends Student{
    double gpa;
    
    public TopStudent(String name, double gpa) {
        super(name);
        this.gpa = gpa;
    }
}
