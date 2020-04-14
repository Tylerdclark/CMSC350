package wk6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Project3 extends JFrame {

    private JTextField input = new JTextField(20), output = new JTextField(20);
    private final JButton makeTree = new JButton("Make Tree");
    private final JButton isBalanced = new JButton("Is Balanced?");
    private final JButton isFull = new JButton("Is Full?");

    public static void main(String[] args) {
        Project3 frame = new Project3();
        frame.setVisible(true);
    }


    public Project3() {
        super("Binary Tree Categorizer");
        setSize(400, 175);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        JComponent[] inputComponents = {new JLabel("Enter Expression"),
                input};
        makeFlowPanel(inputComponents);
        JComponent[] buttonComponents = {makeTree, isBalanced, isFull };
        makeFlowPanel(buttonComponents);
        JComponent[] outputComponents = {new JLabel("Result"), output};
        makeFlowPanel(outputComponents);
        output.setEditable(false);
        makeTree.addActionListener(treeMaker);
        isBalanced.addActionListener(checkBalanced);
        isFull.addActionListener();
    }

    private void makeFlowPanel(JComponent[] components) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for (Component component: components)
            panel.add(component);
        add(panel);
    }



    // TODO: maybe just one action listener for all of the buttons w/ if statement
    private final ActionListener treeMaker = event -> {
        try {
            //get input / set output
        } catch (Exception except) {
            JOptionPane.showMessageDialog(null, except.getMessage());
        }
    };

    private final ActionListener checkBalanced = event -> {
        try {
            // get input / set output
        }catch (Exception except){
            JOptionPane.showMessageDialog(null, except.getMessage());
        }
    }
}
