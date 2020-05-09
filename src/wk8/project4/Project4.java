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
    public static <E> void fromFile() {
        //Create JFileChooser
        JFileChooser chooser = new JFileChooser();
        //Show both directories and files
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //use current directory for ease
        chooser.setCurrentDirectory(new File("."));
        int response = chooser.showOpenDialog(chooser.getParent());
        if (response == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            try { Scanner fileIn = new Scanner(file);
                //Instantiate graph
                DirectedGraph<String> graph = new DirectedGraph<>();
                //create graph
                while (fileIn.hasNextLine()){ parseVertexString(fileIn.nextLine(), graph); }
                //instantiate DFSActions objects
                DFSActions<String> parenthesizedList = new ParenthesizedList<>();
                DFSActions<String>  hierarchy = new Hierarchy<>();
                //do the DFS
                //graph.performDFS(parenthesizedList);
                graph.performDFS(hierarchy);
                //and print them
                //System.out.println(parenthesizedList);
                System.out.println(hierarchy);
                System.out.println(graph);

            }catch (NoSuchElementException nse){
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"File is empty!");
            }catch(FileNotFoundException fne){
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"File is not found!");
            }
        }
    }

    public static void parseVertexString(String fileLine, DirectedGraph<String> graph){
        String[] toArray = fileLine.split(" ");
        for (int i = 1; i < toArray.length; i++){
            graph.createEdge(toArray[0], toArray[i]);
        }
    }
}