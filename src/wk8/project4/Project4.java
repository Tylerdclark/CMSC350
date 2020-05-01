package wk8.project4;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Project4 {

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        int userChoice = JOptionPane.showConfirmDialog(null, "Would you like to select a file?",
                "Project 4", JOptionPane.YES_NO_CANCEL_OPTION);
        while(userChoice == 0 ){
            //JFileChooser showDialog was giving me issues on OSX, so this allowed it to execute in the right thread
            EventQueue.invokeAndWait(Project4::fromFile);//chose method reference over lambda expression
            userChoice = JOptionPane.showConfirmDialog(null, "Would you like to select a file?",
                    "Project 4", JOptionPane.YES_NO_CANCEL_OPTION);
        }
    }
    public static void fromFile() {
        //Create JFileChooser
        JFileChooser chooser = new JFileChooser();
        //Show both directories and files
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //use current directory for ease
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int response = chooser.showOpenDialog(chooser.getParent());
        if (response == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            try {
                Scanner fileIn = new Scanner(file);
                if  (file.isFile()){
                    while (fileIn.hasNextLine()){
                        Scanner lineScanner = new Scanner(fileIn.nextLine());
                        while (lineScanner.hasNext()){
                            System.out.println(lineScanner.next());
                        }
                    }
                }
            }catch (NoSuchElementException nse){
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"File is empty!");
            }catch(FileNotFoundException fne){
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"File is not found!");
            }
        }
    }
}
