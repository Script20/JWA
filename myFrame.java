import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class myFrame extends JFrame implements ActionListener {

    JButton button;
    File file = new File("data.txt");
    JTextField showField;
    List<String> result = Files.readAllLines(Path.of("data.txt"));

    myFrame() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("TV Show Tracker");

        //Initialising button
        button = new JButton("Add show");
        button.addActionListener(this);
        this.add(button);

        //Reading file adding them to array
        if (file.length() == 0) {
            System.out.println("[myFrame.java:28] Nothing in file data.txt");
        } else {
            System.out.println("[myFrame.java:30] Reading file " + "for shows");
            List<String> result = Files.readAllLines(Path.of("data.txt"));
            System.out.println("[myFrame.java:32] Found " + result + " in data.txt");
        }

        for (int i=0; i < result.length; i++) {
            result.get(i)
        }

        //Frame properties
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setSize(800, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("[myFrame.java:45] Trying to start instance of addNewShowFrame\n");
            try {
                addNewShowFrame addNewShow = new addNewShowFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
