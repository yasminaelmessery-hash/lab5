package javaapplication18;
public class Student  {
    
    private static int nextId = 1000;
    private int studentId;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    public Student(String fullName, int age, String gender, String department, double gpa){
        this.studentId = nextId; 
        nextId++;              
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }
    public int getStudentId() {
        return studentId;
    }
    public String getFullName() {
        return fullName;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getDepartment() {
        return department;
    }
    public double getGpa() {
        return gpa;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String toString() {
        return  "ID=" + studentId +", Name='" + fullName +", Age=" + age +", Dept='" + department  + ", GPA=" + gpa;
    }
}