/* File: Project2.java
 * Date: 07 April 2020
 * Author: Tyler D Clark
 * Description: The description will go here :o) */

package wk4.project2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Project2 {
    //todo: populate an ArrayList with the Polynomial objects
    //todo: JOptionPane for invalid syntax
    //todo: strong order check
    //todo: weak order check
    //todo: named lambda expression implements comparable interface

    public static void main(String[] args) {
        // test
        try {
            ArrayList<String> a = fromFile();
            for (String element : a) {
                Polynomial p = new Polynomial(element);
                System.out.println(p);
            }
        }catch (InvalidPolynomialSyntax ex){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage());
        }
    }

    //===============================================================================================
    //  method: fromFile /  returns: Arraylist / complexity: O(n)
    //  description: Opens a file takes a String and tokenizes it into an ArrayList of of expressions
    //===============================================================================================

    public static ArrayList<String> fromFile() {
        //Create ArrayList and JFileChooser
        ArrayList<String> expressionList = new ArrayList<>();
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
                         String expression = fileIn.nextLine();
                         expressionList.add(expression);
                     }
                 }
             }catch (NoSuchElementException nse){
                System.err.println("File is empty!");
             }catch(FileNotFoundException fne){
                 System.err.println("File is not found!");
             }
         }
        return expressionList;
    }
}
