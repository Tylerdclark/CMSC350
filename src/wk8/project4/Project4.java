package wk8.project4;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Project4 {

    public static void main(String[] args) {
        fromFile();
    }

    public static void fromFile() {
        //Create JFileChooser
        JFileChooser chooser = new JFileChooser();
        //Show both directories and files
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //use current directory for ease
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int response = chooser.showOpenDialog(null);
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
