import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI implements ActionListener {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JList list;

    public GUI(){
        //creates the GUI screen
        frame = new JFrame();
        panel = new JPanel();

        //add button to GUI
        JButton button = new JButton("Run Web Scrapper");
        button.addActionListener(this);

        //Defining layout of GUI
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Recipe Keeper");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]){
        new GUI();

    }

    //called when button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        // runs python scrapper
        try{
            Process p = Runtime.getRuntime().exec("python src/webScrap.py");
        }catch(Exception ex) {
            System.out.println("Exception Raised" + ex.toString());
        }
        // gives time for scrapper to create file
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        try {
            displayList();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    // takes the list created by the scrapper and displays it
    public void displayList() throws IOException {
        String str;
        // file reader for created txt file
        File file = new File("recipe.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        DefaultListModel<String> myList = new DefaultListModel<>();
        while ((str = br.readLine()) != null)

            myList.addElement(str);

        // displays the list
        list = new JList<>(myList);
        frame.add(list);
        frame.setVisible(true);





    }
}
