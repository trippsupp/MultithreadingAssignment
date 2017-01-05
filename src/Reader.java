import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Reads and formats the contents of a text file
 * 
 * @author Vance Field
 * @version 5-Apr-2016
 */
public class Reader implements Runnable{
    
    OutputWindow ow = new OutputWindow();
    String output = "";
    String tempOutput = "";
    String fileName;
    PrintWriter pw;
    FileReader file;
    Scanner scanner;
    int wordCount = 0;
    int threadNum;
    String line;
    Scanner lineScan;
    
    /**
     * Constructor
     * 
     * @param _path path of the file
     * @param _fileName name of the file
     * @param _threadNum number of the thread
     * @throws FileNotFoundException 
     */
    public Reader(String _path, String _fileName, int _threadNum) throws FileNotFoundException{
        file = new FileReader(_path);
        scanner = new Scanner(file);
        fileName = _fileName;
        threadNum = _threadNum;
       
        File f = new File("results.txt"); // creates results text file
        pw = new PrintWriter(f);         
        
    }
    
    /**
     * Runs each time the thread is started
     */
    public void run() {        
        try {
            //System.out.println("Inside the run() method");
            while(scanner.hasNext()){ // while another line
                line = scanner.nextLine(); // take the line 
                lineScan = new Scanner(line); // scan the line
                while(lineScan.hasNext()){ // while another word in the line
                    tempOutput += lineScan.next() + " "; // add word to output
                    wordCount++; // count each word
                }
                tempOutput += "\n"; // at the end of each line add a new line
            }
            
            // formats the output
            output = "Filename: " + fileName 
                    + "\n\nThe word count is: " + wordCount 
                    + "\n\nFile contents:\n\n" + tempOutput;
            
            // creates a new window with the output of the file
            ow.createWindow(output,fileName);
            
            // formats output into results.txt
            pw.println("Thread " + threadNum + ": the file \"" + fileName +"\" has "  
                    + wordCount + " words.\n");
            
            
        } catch(Exception er){
            er.printStackTrace();
        }
    }    
}
