import java.io.FileNotFoundException;
import java.io.IOException;

public class FileWriter {
    public void writeReportToFile(String filename, String report) {
        java.io.FileWriter fw;
        try {
            fw = new java.io.FileWriter(filename);
            fw.write(report);
            fw.close();
        }
        catch (FileNotFoundException fnf) {
            System.out.println(filename + " not found ");
            System.exit(0);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }
    }
}
