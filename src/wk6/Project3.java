package wk6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//TODO: Scanner object to read from textfield String  and create tree object

public class Project3 extends JFrame {

    private JTextField input = new JTextField(20), output = new JTextField(30);
    private final JButton makeTree = new JButton("Make Tree");
    private final JButton isBalanced = new JButton("Is Balanced?");
    private final JButton isFull = new JButton("Is Full?");
    private final JButton isProper = new JButton("Is Proper?");
    private final JButton height = new JButton("Height");
    private final JButton nodes = new JButton("Nodes");
    private final JButton inOrder = new JButton("Inorder");
    private static BinaryTree inputTree;

    public static void main(String[] args) {
        Project3 frame = new Project3();
        frame.setVisible(true);
    }


    public Project3() {
        super("Binary Tree Categorizer");
        setSize(715, 175);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        JComponent[] inputComponents = {new JLabel("Enter Expression"),
                input};
        makeFlowPanel(inputComponents);
        JComponent[] buttonComponents = {makeTree, isBalanced, isFull, isProper, height, nodes, inOrder };
        makeFlowPanel(buttonComponents);
        JComponent[] outputComponents = {new JLabel("Result"), output};
        makeFlowPanel(outputComponents);
        output.setEditable(false);
        makeTree.addActionListener(treeListener);
        isBalanced.addActionListener(treeListener);
        isFull.addActionListener(treeListener);
        isProper.addActionListener(treeListener);
    }

    private void makeFlowPanel(JComponent[] components) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for (Component component: components)
            panel.add(component);
        add(panel);
    }
    
    private final ActionListener treeListener = event -> {
        try {
            switch ((event.getActionCommand())){
                case "Make Tree":
                    inputTree = new BinaryTree(input.getText());
                    output.setText(inputTree.toString());
                    break;
                case "Is Balanced?":
                    System.out.println(inputTree.checkBalanced());
                    break;
                case "Is Full?":
                    System.out.println(inputTree.checkFull());
                    break;
                case "Is Proper?":
                    System.out.println(inputTree.isProper());
                    break;
                case "Height":
                    System.out.println(inputTree.height());
                    break;
                case "Nodes":
                    System.out.println(inputTree.nodes());
                    break;
                case "Inorder":
                    System.out.println(inputTree.inOrder());
                    break;
            }
            //get input / set output
        } catch (Exception except) {
            System.out.println(except.getMessage());
        }
    };
}
