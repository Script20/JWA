import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class main extends JOptionPane {

    public static void main(String[] args) throws IOException {

        //Instances
        File file = new File("data.txt");
        myFrame frame = new myFrame();
        List<String> result = Files.readAllLines(Path.of("data.txt"));

        // Creating file if needed.
        try {
            if (!file.exists() && file.isDirectory()) {
                System.out.println("[main.java:16] File created: " + file.getName());
                System.out.println("[myFrame.java:17] File location: " + file.getAbsolutePath());
                file.createNewFile();
            } else {
                System.out.println("[myFrame.java:20] File already exists.");
                System.out.println("[myFrame.java:21] File location: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error has occurred", "File Error", ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}