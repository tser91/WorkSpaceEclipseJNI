package com.lithiumhead.jni;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class HelloWorld extends JFrame {
	
	//Actions implemented in the library through jni. See 01C_HelloWorld
	//Adds two double numbers
	public native double add(double firstArg, double secondArg);
	//Substract two double numbers
	public native double minus(double firstArg, double secondArg);
	//Multiply two double numbers
	public native double mult(double firstArg, double secondArg);
	//Divide two double numbers
	public native double div(double firstArg, double secondArg);
	//Import the dll
	static {
		System.loadLibrary("HelloWorld");
	}
	
	//Frame attributes
	private JPanel contentPane;
	private JTextField textField;
	private JButton PlusButton;
	private JButton MinusButton;
	private JButton MultButton;
	private JButton DivButton;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton ClearButton;
	private JButton ResultButton;
	private JButton button_0;
	private JButton button_1;
	//Private memory attributes of calculator
	private double memory;
	private String memAction;
	//Private constants for calculator
	private final double RESET_MEM_VALUE = 0;
	private final String NO_ACT = "NA";
	private final String ADD = "add";
	private final String MINUS = "minus";
	private final String MULT = "mult";
	private final String DIV = "div";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorld frame = new HelloWorld();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Action button
	 */
	private void buttonAction() {
		double result = 0;
		if (memAction.equals(ADD)) {
			result = add(memory, Double.parseDouble(textField.getText()));
		}
		else if (memAction.equals(MINUS)) {
			result = minus(memory, Double.parseDouble(textField.getText()));
		}
		else if (memAction.equals(MULT)) {
			result = mult(memory, Double.parseDouble(textField.getText()));
		}
		else if (memAction.equals(DIV)) {
			result = div(memory, Double.parseDouble(textField.getText()));
		}
		else {
			result = Double.parseDouble(textField.getText());
		}
		textField.setText("" + result);
	}

	/**
	 * Create the frame.
	 */
	public HelloWorld() {
		memory = RESET_MEM_VALUE;
		memAction = "";
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(HelloWorld.class.getResource("/resources/calculator.png")));
		setTitle("Calculator\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 217, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 24));
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		
		PlusButton = new JButton("+");
		PlusButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				buttonAction();
				memAction = ADD;
				memory = Double.parseDouble(textField.getText());
			}
		});
		
		MinusButton = new JButton("-");
		MinusButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				buttonAction();
				memAction = MINUS;
				memory = Double.parseDouble(textField.getText());
			}
		});
		
		MultButton = new JButton("*");
		MultButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				buttonAction();
				memAction = MULT;
				memory = Double.parseDouble(textField.getText());
			}
		});
		
		DivButton = new JButton("/");
		DivButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				buttonAction();
				memAction = DIV;
				memory = Double.parseDouble(textField.getText());
			}
		});
		
		button_6 = new JButton("6");
		button_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+6));
			}
		});
		
		button_7 = new JButton("7");
		button_7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+7));
			}
		});
		
		button_8 = new JButton("8");
		button_8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+8));
			}
		});
		
		button_9 = new JButton("9");
		button_9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+9));
			}
		});
		
		button_2 = new JButton("2");
		button_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+2));
			}
		});
		
		button_3 = new JButton("3");
		button_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+3));
			}
		});
		
		button_4 = new JButton("4");
		button_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+4));
			}
		});
		
		button_5 = new JButton("5");
		button_5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+5));
			}
		});
		
		ClearButton = new JButton("C");
		ClearButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				memory = RESET_MEM_VALUE;
				memAction = NO_ACT;
				textField.setText(""+memory);
			}
		});
		
		
		ResultButton = new JButton("=");
		ResultButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				buttonAction();
				memory = Double.parseDouble(textField.getText());
			}
		});
		
		button_0 = new JButton("0");
		button_0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10));
			}
		});
		
		button_1 = new JButton("1");
		button_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(""+(Double.parseDouble(textField.getText())*10+1));
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(PlusButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(MinusButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(MultButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(DivButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(ClearButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ResultButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_0, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(PlusButton)
						.addComponent(MinusButton)
						.addComponent(MultButton)
						.addComponent(DivButton))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_6)
						.addComponent(button_7)
						.addComponent(button_8)
						.addComponent(button_9))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2)
						.addComponent(button_3)
						.addComponent(button_4)
						.addComponent(button_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ClearButton)
						.addComponent(ResultButton)
						.addComponent(button_0)
						.addComponent(button_1))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
