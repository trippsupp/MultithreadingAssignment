import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Creates a new window with the formatted contents of a text file
 * 
 * @author Vance Field
 * @version 5-Apr-2016
 */
public class OutputWindow {
    
    private JFrame frame;
    private JPanel panel;
    private JTextPane pane;
    public String output;
    
    /**
     * Creates a new frame
     * 
     * @param _s contents of the text file
     * @param _title name of the text file
     */
    public void createWindow(String _s, String _title){
        frame = new JFrame();
        panel = new JPanel();
        pane = new JTextPane();
        
        output = _s;
        
        pane.setPreferredSize(new Dimension(690,660));
        pane.setEditable(false);
        pane.setText(output);
        
        panel.add(pane);
        
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setTitle(_title);
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
