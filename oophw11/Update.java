package oophw11;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Update {
	
	public JFrame Frame;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JLabel Label2;
	List<PersonData> PL=new ArrayList<PersonData>();
	JLabel Label1;
	private JButton Button1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Update win = new Update();
					win.Frame.setVisible(true);
				} catch (Exception z) {
					z.printStackTrace();
				}
			}
		});
	}

	public Update() {
		
		initialize();
		PersonData test =new PersonData();
		PL=test.ReadData();
		
	    Label1 = new JLabel("");
		Label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label1.setBounds(28, 252, 396, 27);
		Frame.getContentPane().add(Label1);
		Button1 = new JButton("Back");
		Button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					serialization test =new serialization();
				
				Frame.setVisible(false);
		        test.Frame.setVisible(true);
				
			}
		});
		Button1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button1.setBounds(259, 290, 98, 25);
		Frame.getContentPane().add(Button1);
		 
	}

	private void initialize() {
		Frame = new JFrame();
		Frame.setBounds(100, 100, 450, 376);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("Enter Name");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl.setBounds(42, 78, 126, 27);
		Frame.getContentPane().add(lbl);
		
		JLabel PhoneNumber = new JLabel("Enter Phone Number");
		PhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PhoneNumber.setBounds(41, 116, 174, 27);
		Frame.getContentPane().add(PhoneNumber);
		
		JLabel EnterDate = new JLabel("Enter Date Of Birth");
		EnterDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		EnterDate.setBounds(42, 168, 151, 27);
		Frame.getContentPane().add(EnterDate);
		
		JLabel Email = new JLabel("Enter Email");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email.setBounds(42, 214, 151, 27);
		Frame.getContentPane().add(Email);
		
		textField = new JTextField();
		textField.setBounds(225, 81, 132, 25);
		Frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(225, 119, 132, 25);
		Frame.getContentPane().add(textField1);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(225, 171, 24, 25);
		Frame.getContentPane().add(textField3);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(285, 171, 27, 25);
		Frame.getContentPane().add(textField4);
		
		textField5 = new JTextField();
		textField5.setColumns(10);
		textField5.setBounds(343, 171, 63, 25);
		Frame.getContentPane().add(textField5);
		
		textField6 = new JTextField();
		textField6.setColumns(10);
		textField6.setBounds(225, 217, 132, 25);
		Frame.getContentPane().add(textField6);
		
		JButton Button = new JButton("Add User");
		Button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String n=textField.getText();
					String Phone=textField1.getText();
					String DB=textField3.getText()+"/"+textField4.getText()+"/"+textField5.getText();
					String Email=textField6.getText();
					
					PersonData test=new PersonData(n,Phone,DB,Email);
						
					PL.add(test);
					PersonData temp=new PersonData();
					temp.WriteData(PL);	
					
					Label1.setText("  The account data has been saved ");
					Label1.setForeground(Color.GREEN);
		
				}
				catch(Exception ex)
				{
					Label1.setText("Incorrect info. Try again");
					Label1.setForeground(Color.RED);		
				
				}
				finally
				{
					textField.setText("");
					textField1.setText("");
					textField3.setText("");
					textField4.setText("");
					textField5.setText("");
					textField6.setText("");
				}	
			}
		});
		
		Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button.setBounds(104, 290, 114, 23);
		Frame.getContentPane().add(Button);
	    Label2 = new JLabel("Fill in info");
		Label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label2.setBounds(129, 30, 240, 26);
		Frame.getContentPane().add(Label2);
		JLabel Label3 = new JLabel("MM");
		Label3.setBounds(259, 174, 16, 19);
		Frame.getContentPane().add(Label3);

		JLabel Label4 = new JLabel("DD");
		Label4.setBounds(322, 176, 24, 14);
		Frame.getContentPane().add(Label4);
		
		JLabel Label5 = new JLabel("YY");
		Label5.setBounds(411, 176, 46, 14);
		Frame.getContentPane().add(Label5);
	}

}
