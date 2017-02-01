
import javax.swing.SwingUtilities;

/**
 * Contains the main method
 *
 * @author Vance Field
 * @version 5-Apr-2016
 */
public class Driver {

    /**
     * Starts the program
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.display();
            }
        });
    }
}
