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

}
