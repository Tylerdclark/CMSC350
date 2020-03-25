/* File: ProjectOne.java
 * Date: 20 March 2020
 * Author: Tyler D Clark
 * Description: The main file where the GUI is created and where the users are given the opportunity to enter
 * expressions */

package wk2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProjectOne extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel enterExpression = new JLabel("Enter Expression");
	private JTextField expressionField = new JTextField(20);
	private JButton prefixToPostfix = new JButton("Prefix to Postfix");
	private JButton postfixToPrefix = new JButton("Postfix to Prefix");
	private JLabel resultLabel = new JLabel("Result");
	private JTextField resultTextField = new JTextField(20);

	//main here
	public static void main(String[] args) {
		ProjectOne frame = new ProjectOne();
		frame.setVisible(true);
	}
	//constructor
	public ProjectOne() {
		super("Expression Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(topPanel(), BorderLayout.NORTH);
		contentPane.add(middlePanel(), BorderLayout.CENTER);
		contentPane.add(bottomPanel(), BorderLayout.SOUTH);
		setContentPane(contentPane);
	}
	//Split into separate panels which will be flowLayout
	public JPanel topPanel(){
		JPanel topPanel = new JPanel();
		topPanel.add(enterExpression);
		topPanel.add(expressionField);
		return topPanel;
	}
	public JPanel middlePanel(){
		JPanel midPanel = new JPanel();
		midPanel.add(prefixToPostfix);
		midPanel.add(postfixToPrefix);
		prefixToPostfix.addActionListener(this);
		postfixToPrefix.addActionListener(this);
		return midPanel;
	}
	public JPanel bottomPanel(){
		JPanel botPanel = new JPanel();
		botPanel.add(resultLabel);
		botPanel.add(resultTextField) ;
		resultTextField.setEditable(false);
		return botPanel;
	}
	// using this class implemented method
	public void actionPerformed(ActionEvent e){
		try {
			String expressionString = expressionField.getText();
			String converted = Convert.fromPostfixToPrefix(expressionString);
			resultTextField.setText(converted);

		} catch (NullPointerException | IOException | SyntaxError ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}
}