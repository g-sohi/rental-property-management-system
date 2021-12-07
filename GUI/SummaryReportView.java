package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;

public class SummaryReportView extends JFrame {
    
    // variable declaration
    private JFrame frame;
    private JButton close;

    public SummaryReportView() {
        
        // creation of JFrame of certain size
        frame = new JFrame("Summary Report");
        frame.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setLayout(null); // layout set to null

        // creation of JButton of certain size and positioon
        close = new JButton("Close");
        close.setBounds(200, 400, 100, 50);

        frame.add(close);

        frame.setVisible(true);

    }

    // **for testing purposes**
    public static void main(String [] args) {
        new SummaryReportView();
    }

}
