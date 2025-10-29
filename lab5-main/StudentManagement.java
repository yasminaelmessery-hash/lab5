package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    
    private List <Student> students;
    
public StudentManagement() {
        this.students = new ArrayList<>();
        loadStudentsFromFile(); 
    }
    
    
   public String validateStudent(Student student, boolean isNewStudent) {
        if (student.getFullName() == null || student.getFullName().trim().isEmpty()) {
            return "Full Name cannot be empty.";
        }
        if (student.getDepartment() == null || student.getDepartment().trim().isEmpty()) {
            return "Department cannot be empty.";
        }
        if (student.getAge() <= 6) {
            return "Age must be a valid number (e.g., > 6).";
        }
        if (student.getGpa() < 0.0 || student.getGpa() > 4.0) {
            return "GPA must be a valid number between 0.0 and 4.0.";
        }
        
        if (isNewStudent && findStudentByID(student.getStudentID()) != null) {
            return "Student ID already exists.";
        }
        
        return null;
    }
    
   public String updateStudent(Student updatedStudent) {
        String validationError = validateStudent(updatedStudent, false);
        if (validationError != null) {
            return validationError;
        }
        
        Student existingStudent = findStudentByID(updatedStudent.getStudentID());
        if (existingStudent == null) {
            return "Student not found, cannot update.";
        }

        int index = students.indexOf(existingStudent);
        students.set(index, updatedStudent);
        saveStudentsToFile();
        return null; 
    }
   
   public Student findStudentByID(int S_ID)
    {
    for (int i =0 ; i < students.size() ; i++)
    if (students.get(i).getStudentID() == S_ID )
        return students.get(i);
     
    return null;
    }
   
   public boolean isNewStudent(Student student)
    {
    for (int i =0 ; i < students.size() ; i++)
    if (students.get(i).getStudentID() == student.getStudentID() )
        return false;
    
    return true;
    }
   
   public String addStudent(Student student) {
        String validationError = validateStudent(student, true);
        if (validationError != null) {
            return validationError;
        }
        
        students.add(student);
        saveStudentsToFile();
        return null;
    }
   
   public String deleteStudent (int studentID)
   {
   Student s = findStudentByID(studentID);
   
      if (s == null)
      return "This student is not Listed";
      
      students.remove(s);
      saveStudentsToFile();
      return null;
   }
   
   public List<Student> getAllStudents()
   {
   return new ArrayList<> (students);
   }
   
   public void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                String line = s.getStudentID() + "|" +
                              s.getFullName() + "|"  +
                              s.getAge() + "|"  +
                              s.getGender() + "|"  +
                              s.getDepartment() + "|"  +
                              s.getGpa();
                writer.write(line);
                writer.newLine(); 
            }
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }

   
    public void loadStudentsFromFile() {
        File file = new File("students.txt");
        if (!file.exists()) {
            students = new ArrayList<>(); 
            return;
        }
        
        students.clear();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; 
                }
                

                String[] parts = line.split("\\" + "|" );
                
                if (parts.length == 6) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        int age = Integer.parseInt(parts[2]);
                        String gender = parts[3];
                        String department = parts[4];
                        double gpa = Double.parseDouble(parts[5]);
                        
                        students.add(new Student(id, name, age, gender, department, gpa));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping corrupt line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
            students = new ArrayList<>(); 
        }
    }
    
    
}

