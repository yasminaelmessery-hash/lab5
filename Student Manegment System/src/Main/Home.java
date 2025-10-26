package Main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Home extends javax.swing.JFrame {

        private final List<Student> students = new ArrayList<>();
        private final StudentManagement manager = new StudentManagement();

        public Home() {
                initComponents();
                refreshTables(manager.getAllStudents());
              

                update.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateActionPerformed(evt);
                        }
                });
                delete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                deleteActionPerformed(evt);
                        }
                });
                javax.swing.JPanel menuPanel = new javax.swing.JPanel();
                javax.swing.JButton toUpdateBtn = new javax.swing.JButton("Update/Search");
                javax.swing.JButton toDeleteBtn = new javax.swing.JButton("Delete");
                javax.swing.JButton toAddBtn = new javax.swing.JButton("Add Student");
                javax.swing.JButton toViewBtn = new javax.swing.JButton("View Student");
                
                toUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                goToUpdateSearch();
                        }
                });
                toDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                goToDeleteTab();
                        }
                });
                toAddBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                goToAdd();
                        }
                });
                 toViewBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                goToView();
                        }
                });
                jTabbedPane1.insertTab("Menu", null, menuPanel, null, 0);
                menuPanel.add(toUpdateBtn);
                menuPanel.add(toDeleteBtn);
                menuPanel.add(toAddBtn);
                menuPanel.add(toViewBtn);

                javax.swing.JPanel addPanel = new javax.swing.JPanel(new java.awt.GridLayout(7, 2, 6, 6));
                addPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
                addPanel.add(new javax.swing.JLabel("Student ID:"));
                final javax.swing.JTextField idField = new javax.swing.JTextField();
                addPanel.add(idField);
                addPanel.add(new javax.swing.JLabel("Full Name:"));
                final javax.swing.JTextField nameField = new javax.swing.JTextField();
                addPanel.add(nameField);
                addPanel.add(new javax.swing.JLabel("Age:"));
                final javax.swing.JTextField ageField = new javax.swing.JTextField();
                addPanel.add(ageField);
                addPanel.add(new javax.swing.JLabel("Gender:"));
                final javax.swing.JTextField genderField = new javax.swing.JTextField();
                addPanel.add(genderField);
                addPanel.add(new javax.swing.JLabel("Department:"));
                final javax.swing.JTextField deptField = new javax.swing.JTextField();
                addPanel.add(deptField);
                addPanel.add(new javax.swing.JLabel("GPA:"));
                final javax.swing.JTextField gpaField = new javax.swing.JTextField();
                addPanel.add(gpaField);
                final javax.swing.JButton addBtn = new javax.swing.JButton("Add");
                addPanel.add(addBtn);
                addBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                try {
                                        int id = Integer.parseInt(idField.getText().trim());
                                        String name = nameField.getText().trim();
                                        int age = Integer.parseInt(ageField.getText().trim());
                                        String gender = genderField.getText().trim();
                                        String dept = deptField.getText().trim();
                                        double gpa = Double.parseDouble(gpaField.getText().trim());
                                        Student s = new Student(id, name, age, gender, dept, gpa);
                                        String err = manager.addStudent(s);
                                        if (err != null) {
                                                javax.swing.JOptionPane.showMessageDialog(Home.this, err);
                                                return;
                                        }
                                        refreshTables(manager.getAllStudents());
                                        idField.setText(""); nameField.setText(""); ageField.setText("");
                                        genderField.setText(""); deptField.setText(""); gpaField.setText("");
                                        javax.swing.JOptionPane.showMessageDialog(Home.this, "Student added.");
                                } catch (NumberFormatException ex) {
                                        javax.swing.JOptionPane.showMessageDialog(Home.this, "ID/Age must be integers and GPA a number.");
                                }
                        }
                });
                jTabbedPane1.addTab("Add Student", addPanel);

               
                javax.swing.JPanel viewPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
                final javax.swing.table.DefaultTableModel viewModel = new javax.swing.table.DefaultTableModel(
                        new String[]{"Student ID","Full Name","Gender","Departement","Age","GPA"}, 0) {
                        public boolean isCellEditable(int r,int c){return false;}
                };
                final javax.swing.JTable viewTable = new javax.swing.JTable(viewModel);
                javax.swing.JScrollPane viewScroll = new javax.swing.JScrollPane(viewTable);
                javax.swing.JButton viewRefresh = new javax.swing.JButton("Refresh");
                java.awt.event.ActionListener loadView = new java.awt.event.ActionListener(){
                        public void actionPerformed(java.awt.event.ActionEvent e){
                                viewModel.setRowCount(0);
                                for (Student s : manager.getAllStudents()) {
                                        viewModel.addRow(new Object[]{s.getStudentID(), s.getFullName(), s.getGender(), s.getDepartment(), s.getAge(), s.getGpa()});
                                }
                        }
                };
                viewRefresh.addActionListener(loadView);
                viewPanel.add(viewScroll, java.awt.BorderLayout.CENTER);
                viewPanel.add(viewRefresh, java.awt.BorderLayout.SOUTH);
                jTabbedPane1.addTab("View Student", viewPanel);
                loadView.actionPerformed(null);

                jTabbedPane1.setSelectedIndex(0);       
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jTabbedPane1 = new javax.swing.JTabbedPane();
                jPanel3 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                Search = new javax.swing.JButton();
                refresh = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                Students = new javax.swing.JTable();
                jPanel5 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jTextField2 = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                jComboBox1 = new javax.swing.JComboBox<>();
                jLabel5 = new javax.swing.JLabel();
                jTextField3 = new javax.swing.JTextField();
                jLabel6 = new javax.swing.JLabel();
                jTextField4 = new javax.swing.JTextField();
                jLabel7 = new javax.swing.JLabel();
                jTextField5 = new javax.swing.JTextField();
                update = new javax.swing.JButton();
                jLabel8 = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                Students1 = new javax.swing.JTable();
                delete = new javax.swing.JButton();
                jButton1 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));

                jPanel2.setBackground(new java.awt.Color(204, 204, 204));

                jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
                jLabel1.setText("STUDENT MANEGMENT SYSTEM");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(41, 41, 41)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                657,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                70,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(15, Short.MAX_VALUE)));

                jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

                jPanel3.setBackground(new java.awt.Color(255, 255, 255));

                jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
                jLabel2.setText("Search Student (ID or Name):");

                jTextField1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField1ActionPerformed(evt);
                        }
                });

                Search.setBackground(new java.awt.Color(0, 0, 0));
                Search.setForeground(new java.awt.Color(255, 255, 255));
                Search.setText("Search");
                Search.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                SearchActionPerformed(evt);
                        }
                });

                refresh.setBackground(new java.awt.Color(0, 0, 0));
                refresh.setForeground(new java.awt.Color(255, 255, 255));
                refresh.setText("Refresh");
                refresh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                refreshActionPerformed(evt);
                        }
                });

                Students.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Student ID", "Full Name", "Gender", "Departement", "Age", "GPA"
                                }) {
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane1.setViewportView(Students);

                jPanel5.setBackground(java.awt.SystemColor.activeCaption);

                jLabel3.setText("Full Name:");

                jLabel4.setText("Gender:");

                jComboBox1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

                jLabel5.setText("Departement:");

                jLabel6.setText("Age:");

                jTextField4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField4ActionPerformed(evt);
                        }
                });

                jLabel7.setText("GPA:");

                update.setBackground(new java.awt.Color(0, 0, 0));
                update.setForeground(new java.awt.Color(255, 255, 255));
                update.setText("Save Changes");

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addGroup(jPanel5Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jLabel7,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                37,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel6,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                37,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField2)
                                                                                .addComponent(jLabel4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                69,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                84,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                79,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField3)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                126,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField4)
                                                                                .addComponent(jTextField5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                230,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap(46, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(update)
                                                                .addGap(92, 92, 92)));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jComboBox1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(54, 54, 54)
                                                                .addComponent(update)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
                jLabel8.setText("Update section:");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                663,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel2)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                302,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(Search)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(refresh)))
                                                                .addGap(127, 127, 127)
                                                                .addGroup(jPanel3Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jPanel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLabel8,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap(315, Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                36,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(Search)
                                                                                .addComponent(refresh)
                                                                                .addComponent(jLabel8,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                36,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                506,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(21, 21, 21)));

                jTabbedPane1.addTab("Update/Search", jPanel3);

                jPanel4.setBackground(new java.awt.Color(255, 255, 255));

                Students1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Student ID", "Full Name", "Gender", "Departement", "Age", "GPA"
                                }) {
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane3.setViewportView(Students1);

                delete.setBackground(new java.awt.Color(0, 0, 0));
                delete.setForeground(new java.awt.Color(255, 255, 255));
                delete.setText("Delete");

                jButton1.setBackground(new java.awt.Color(0, 0, 0));
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("Refresh");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(jScrollPane3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                663,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(516, 516, 516)
                                                                                                .addComponent(delete)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(jButton1)))
                                                                .addContainerGap(731, Short.MAX_VALUE)));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(delete)
                                                                                .addComponent(jButton1))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                512, Short.MAX_VALUE)
                                                                .addGap(22, 22, 22)));

                jTabbedPane1.addTab("Delete", jPanel4);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jTabbedPane1)
                                                                                .addComponent(jPanel2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTabbedPane1)
                                                                .addContainerGap()));

                jTabbedPane1.getAccessibleContext().setAccessibleName("Update/Search");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField4ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jTextField4ActionPerformed

        private void refreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshActionPerformed
                jTextField1.setText("");
                refreshTables(manager.getAllStudents());
        }// GEN-LAST:event_refreshActionPerformed

        private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
                // TODO add your handling code here:
        }

        private void SearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SearchActionPerformed

                String q = jTextField1.getText().trim().toLowerCase();
                if (q.isEmpty()) {
                        refreshTables(manager.getAllStudents());
                        return;
                }
                List<Student> filtered = new ArrayList<>();
                List<Student> source = manager.getAllStudents();
                Integer qId = null;
                try { qId = Integer.parseInt(q); } catch (NumberFormatException ign) { }
                for (Student s : source) {
                        if ((qId != null && s.getStudentID() == qId) || s.getFullName().toLowerCase().contains(q)) {
                                filtered.add(s);
                        }
                }
                refreshTables(filtered);
        }

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                jTextField1.setText("");
                refreshTables(manager.getAllStudents());
        }

        private void updateActionPerformed(java.awt.event.ActionEvent evt) {
                int row = Students.getSelectedRow();
                if (row < 0) {
                        JOptionPane.showMessageDialog(this, "Select a student in the table to update.");
                        return;
                }
                String name = jTextField2.getText().trim();
                String gender = (String) jComboBox1.getSelectedItem();
                String dept = jTextField3.getText().trim();
                String ageStr = jTextField4.getText().trim();
                String gpaStr = jTextField5.getText().trim();
                int age;
                double gpa;
                try {
                        age = Integer.parseInt(ageStr);
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Age must be an integer.");
                        return;
                }
                try {
                        gpa = Double.parseDouble(gpaStr);
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "GPA must be a number.");
                        return;
                }
                if (name.isEmpty() || !name.matches("[A-Za-z ]+")) {
                        JOptionPane.showMessageDialog(this,
                                        "Name must contain only letters and spaces, and cannot be empty.");
                        return;
                }
                if (dept.isEmpty() || !dept.matches("[A-Za-z ]+")) {
                        JOptionPane.showMessageDialog(this,
                                        "Department must contain only letters and spaces, and cannot be empty.");
                        return;
                }
                if (age < 18 || age > 90) {
                        JOptionPane.showMessageDialog(this, "Age must be between 18 and 90.");
                        return;
                }
                if (gpa < 0.0 || gpa > 4.0) {
                        JOptionPane.showMessageDialog(this, "GPA must be between 0.0 and 4.0.");
                        return;
                }
                Object idObj = Students.getValueAt(row, 0);
                int id = Integer.parseInt(idObj.toString());
                Student updated = new Student(id, name, age, gender, dept, gpa);
                String err = manager.updateStudent(updated);
                if (err != null) {
                        JOptionPane.showMessageDialog(this, err);
                        return;
                }
                refreshTables(manager.getAllStudents());
        }

        private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
                int row = Students1.getSelectedRow();
                if (row < 0) {
                        JOptionPane.showMessageDialog(this, "Select a student to delete.");
                        return;
                }
                Object idObj = Students1.getValueAt(row, 0);
                String id = idObj.toString();
                String name = (String) Students1.getValueAt(row, 1);
                int choice = JOptionPane.showConfirmDialog(
                                this,
                                "Delete student " + name + " (ID: " + id + ")?",
                                "Confirm Delete",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);
                if (choice != JOptionPane.YES_OPTION) {
                        return;
                }
                String err = manager.deleteStudent(Integer.parseInt(id));
                if (err != null) {
                        JOptionPane.showMessageDialog(this, err);
                        return;
                }
                refreshTables(manager.getAllStudents());
                JOptionPane.showMessageDialog(this, "Student deleted.");
        }

        private void initData() {
                students.clear();
                students.add(new Student(1001, "Alice Johnson", 20, "Female", "CS", 3.7));
                students.add(new Student(1002, "Bob Smith", 22, "Male", "EE", 3.2));
                students.add(new Student(1003, "Carol White", 21, "Female", "Math", 3.9));
        }

        private void refreshTables(List<Student> list) {
                DefaultTableModel m1 = (DefaultTableModel) Students.getModel();
                DefaultTableModel m2 = (DefaultTableModel) Students1.getModel();
                m1.setRowCount(0);
                m2.setRowCount(0);
                for (Student s : list) {
                        Object[] row = new Object[] { s.getStudentID(), s.getFullName(), s.getGender(),
                                        s.getDepartment(), s.getAge(),
                                        s.getGpa() };
                        m1.addRow(row);
                        m2.addRow(row);
                }
        }

        private int getTabIndexByTitle(String title) {

                if(title==null)
                {
                        return -1;
                }
                for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
                        if (title.equals(jTabbedPane1.getTitleAt(i))) {
                                return i;
                        }
                }
                return -1;
        }

        public void goToUpdateSearch() {
                int idx = getTabIndexByTitle("Update/Search");
                if (idx >= 0)
                        jTabbedPane1.setSelectedIndex(idx);
        }
         public void goToAdd() {
                int idx = getTabIndexByTitle("Add Student");
                if (idx >= 0)
                        jTabbedPane1.setSelectedIndex(idx);
        }
         public void goToView() {
                int idx = getTabIndexByTitle("View Student");
                if (idx >= 0)
                        jTabbedPane1.setSelectedIndex(idx);
        }

        public void goToMenu() {
                int idx = getTabIndexByTitle("Menu");
                if (idx >= 0)
                        jTabbedPane1.setSelectedIndex(idx);
        }

        public void goToDeleteTab() {
                int idx = getTabIndexByTitle("Delete");
                if (idx >= 0)
                        jTabbedPane1.setSelectedIndex(idx);
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton Search;
        private javax.swing.JTable Students;
        private javax.swing.JTable Students1;
        private javax.swing.JButton delete;
        private javax.swing.JButton jButton1;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JTabbedPane jTabbedPane1;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JTextField jTextField3;
        private javax.swing.JTextField jTextField4;
        private javax.swing.JTextField jTextField5;
        private javax.swing.JButton refresh;
        private javax.swing.JButton update;
        // End of variables declaration//GEN-END:variables
}
