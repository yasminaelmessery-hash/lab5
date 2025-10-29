
package main;

public class Student extends Person{
    
    private String department;
    private int studentID;
    private double gpa;
    
public Student(int studentID, String fullName, int age, String gender, String department, double gpa) {

super(fullName, age, gender);
        this.studentID = studentID;
        this.department = department;
        this.gpa = gpa;
    }

    // --------- Getters and Setters ---------

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    @Override
    public String getDetails() {
        return String.format("ID: %d, Name: %s, Dept: %s, GPA: %.2f",
                studentID, getFullName(), department, gpa);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentID == student.studentID;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(studentID);
    }

}