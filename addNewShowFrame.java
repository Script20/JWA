import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class addNewShowFrame extends JFrame implements ActionListener {

    JTextField textField;
    JButton button2;
    List<String> result = Files.readAllLines(Path.of("data.txt"));

    addNewShowFrame() throws IOException {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("TV Show Tracker");

        button2 = new JButton("Add");
        button2.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 40));

        System.out.println("[addNewShowFrame.java:26] Found " + result +  " in data.txt");

        this.add(button2);
        this.add(textField);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setSize(300, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button2) {
            System.out.println("[addNewShowFrame.java:40] Add Button String newShow");
            System.out.println("[addNewShowFrame.java:41] Found " + result +  " in data.txt");
            String newShow = textField.getText();
            try {
                System.out.println("[addNewShowFrame.java:43] Found " + result +  " in data.txt");
                System.out.println("[addNewShowFrame.java:44] Trying to append to data.txt " + newShow);
                BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
                System.out.println("[addNewShowFrame.java:41] BufferedWriter started " + newShow );
                writer.append(newShow + "\n");
                System.out.println("[addNewShowFrame.java:41] Found " + result +  " in data.txt" + "\n");
                writer.flush();
                writer.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
