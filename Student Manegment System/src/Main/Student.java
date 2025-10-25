package Main;

public class Student {
    private String id;
    private String fullName;
    private String gender;
    private String department;
    private int age;
    private double gpa;
    
    public Student() {}
    
    public Student(String id, String fullName, String gender, String department, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.department = department;
        this.age = age;
        this.gpa = gpa;
    }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
}
