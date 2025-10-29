
package Main;

import javax.swing.*;
import java.awt.*;


public class StudentManagementGUI extends JFrame {

    private StudentManagement manager;


    private JTextField idField, nameField, ageField, genderField, deptField, gpaField;
    private JTextField deleteIdField;
    private JButton addButton, deleteButton;
    private JTextArea studentDisplayArea;
    private JLabel statusLabel;

    public StudentManagementGUI() {
        manager = new StudentManagement();

        setTitle("Student Management System");

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0, 0));

        JPanel formPanel = createFormPanel();
        JPanel displayPanel = createDisplayPanel();
        statusLabel = new JLabel("Welcome!", SwingConstants.CENTER);

        add(formPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setupActionListeners();
        updateStudentList();
    }

    private JPanel createFormPanel() {

        JPanel panel = new JPanel(new GridLayout( 3, 3, 3, 3));
        panel.setBorder(BorderFactory.createTitledBorder("Manage Students"));


        panel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Full Name:"));
        nameField = new JTextField();
        panel.add(nameField);
        
        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);
        
        panel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        panel.add(genderField);
        
        panel.add(new JLabel("Department:"));
        deptField = new JTextField();
        panel.add(deptField);
        
        panel.add(new JLabel("GPA:"));
        gpaField = new JTextField();
        panel.add(gpaField);

        addButton = new JButton("Add Student");
        panel.add(addButton);
        

        panel.add(new JLabel("")); 


        panel.add(new JLabel("ID to Delete:"));
        deleteIdField = new JTextField();
        panel.add(deleteIdField);

        deleteButton = new JButton("Delete Student");
        panel.add(deleteButton);

        return panel;
    }

    private JPanel createDisplayPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Current Students"));
        
        studentDisplayArea = new JTextArea();
        studentDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(studentDisplayArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void setupActionListeners() {
        addButton.addActionListener(e -> handleAddStudent());
        deleteButton.addActionListener(e -> handleDeleteStudent());
    }


    private void handleAddStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            String dept = deptField.getText();
            double gpa = Double.parseDouble(gpaField.getText());
            
            Student newStudent = new Student(id, name, age, gender, dept, gpa);
            
            String result = manager.addStudent(newStudent);
            
            if (result == null) {
                statusLabel.setText("Student added successfully!");

                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                genderField.setText("");
                deptField.setText("");
                gpaField.setText("");
                updateStudentList();
            } else {
                statusLabel.setText("Error: " + result);
            }
        } catch (NumberFormatException ex) {
            statusLabel.setText("Error: ID and Age must be numbers. GPA must be a decimal.");
        }
    }

    private void handleDeleteStudent() {
        try {
            int id = Integer.parseInt(deleteIdField.getText());
            
            String result = manager.deleteStudent(id);

            if (result == null) {
                statusLabel.setText("Student deleted successfully!");
                deleteIdField.setText("");
                updateStudentList();
            } else {
                statusLabel.setText("Error: " + result);
            }
        } catch (NumberFormatException ex) {
            statusLabel.setText("Error: ID must be a number.");
        }
    }


    private void updateStudentList() {
        studentDisplayArea.setText(""); 
        for (Student s : manager.getAllStudents()) {

            studentDisplayArea.append(s.getDetails() + "\n");
        }
    }
}