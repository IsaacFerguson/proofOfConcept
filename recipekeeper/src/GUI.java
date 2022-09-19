import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class GUI implements ActionListener {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    Process mProcess;

    public GUI(){
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("demo site ");

        JButton button = new JButton("Run Web Scrapper");
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Recipe Keeper");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]){
        new GUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Process p = Runtime.getRuntime().exec("python src/webScrap.py");
        }catch(Exception ex) {
            System.out.println("Exception Raised" + ex.toString());
        }

    }
}
