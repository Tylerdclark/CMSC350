package wk2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProjectOne extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JLabel enterExpression = new JLabel("Enter Expression");
	JTextField expressionField = new JTextField(20);
	JButton prefixToPostfix = new JButton("Prefix to Postfix");
	JButton postfixToPrefix = new JButton("Postfix to Prefix");
	JLabel resultLabel = new JLabel("Result");
	JTextField resultTextField = new JTextField(20);

	public static void main(String[] args) {
		ProjectOne frame = new ProjectOne();
		frame.setVisible(true);
	}

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
		return midPanel;
	}

	public JPanel bottomPanel(){
		JPanel botPanel = new JPanel();
		botPanel.add(resultLabel);
		botPanel.add(resultTextField) ;
		resultTextField.setEditable(false);
		return botPanel;
	}

	public void actionPerformed(ActionEvent e){

			String expressionString = expressionField.getText();

	}
}