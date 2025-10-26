import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class ViewStudentCode {

    public static void loadStudents(DefaultTableModel tableModel) {

        tableModel.setRowCount(0);

        String fileName = "students.txt";

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {

            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {

                String[] studentData = line.split(",");

                if (studentData.length == 6) {
                    tableModel.addRow(studentData);
                }

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error reading the student file: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}
