import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class ViewStudentCode {

    public static void loadStudents(DefaultTableModel tableModel) {

        // Remove all old rows from the table
        tableModel.setRowCount(0);

        // The file that contains the student data
        String fileName = "students.txt";

        // Declare objects first so we can close them safely later
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Step 1: Open the file for reading
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            // Step 2: Read one line at a time
            String line = bufferedReader.readLine();

            while (line != null) {

                // Step 3: Split the line into parts (separated by commas)
                String[] studentData = line.split(",");

                // Step 4: Check if we have exactly 6 pieces of data before adding
                if (studentData.length == 6) {
                    tableModel.addRow(studentData);
                }

                // Step 5: Move to the next line
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            // Step 6: If there’s a problem (like file not found), show an error message
            System.out.println("Error reading the student file: " + e.getMessage());
        } finally {
            // Step 7: Always close the file when done to free system resources
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}
