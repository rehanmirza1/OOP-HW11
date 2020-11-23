package oophw11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeData {
	int index;
	boolean found;
	ArrayList<PersonData>PL  =new ArrayList<PersonData>();
	public JFrame frame1;
	public JFrame frame2;
	JLabel Label1;
	JLabel Label2;
	JLabel Label3;
	JLabel Label4;
	private JTextField text_Field;
	private JLabel NewLabel_2;
	private JTextField text_Field1;
	private JTextField text_Field2;
	private JTextField text_Field3;
	private JTextField text_Field4;
	private JTextField text_Field5;
	private JTextField text_Field6;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeData win = new ChangeData();
					win.frame2.setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
	}

	public ChangeData() {
		initialize();
	}
	
	private void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame2 = new JFrame();
		frame2.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame2.setBounds(100, 100, 793, 491);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("Enter Email Address of Person that you want to modify");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl.setBounds(153, 33, 535, 29);
		frame2.getContentPane().add(lbl);
		
		text_Field = new JTextField();
		text_Field.setBounds(294, 85, 152, 29);
		frame2.getContentPane().add(text_Field);
		text_Field.setColumns(10);
		
		JButton btn = new JButton("Retrieve Information");
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				 found=false;
				  index=-1;
				  
				String Email=text_Field.getText();
				PersonData test =new PersonData();
				PL=test.ReadData();
				
				for(int r=0; r<PL.size(); r++)
				{
					if(PL.get(r).EmailAddress().equals(Email))
					{
						found=true;
						index=r;
						
					}
				}
				text_Field.setText("");
				if(found)
				{ 
					lbl.setText("                          User Found");
					lbl.setForeground(Color.GREEN);
					
					
					Label1.setText(PL.get(index).GetName());
					Label2.setText(PL.get(index).GetNumber());
					 Label3.setText(PL.get(index).DOB());
					 Label4.setText(PL.get(index).EmailAddress());
					
					
					
					
					
					
				}
				else
				{
					lbl.setText("                    User Not Found Try Again ");
					lbl.setForeground(Color.RED);
					text_Field.setText("");
				}
				
			}
				
		});
		btn.setBounds(153, 343, 176, 38);
		frame2.getContentPane().add(btn);
		
		 Label1 = new JLabel("");
		Label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label1.setBounds(31, 164, 152, 20);
		frame2.getContentPane().add(Label1);
		
		 Label2 = new JLabel("");
		Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label2.setBounds(223, 164, 110, 20);
		frame2.getContentPane().add(Label2);
		
		 Label3 = new JLabel("");
		Label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label3.setBounds(389, 164, 110, 20);
		frame2.getContentPane().add(Label3);
		
		 Label4 = new JLabel("");
		Label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label4.setBounds(569, 164, 198, 20);
		frame2.getContentPane().add(Label4);
		
		JButton DeleteUser = new JButton("Edit Account");
		DeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				if(found)
				{
					String N=text_Field1.getText();
					String num=text_Field2.getText();
					String Db=text_Field3.getText()+"/"+text_Field4.getText()+"/"+text_Field5.getText();
					String Email=text_Field6.getText();
					if(!N.equals(""))
					{
						PL.get(index).SetName(N);
					}
					if(!num.equals(""))
					{
						PL.get(index).SetNumber(num);
					}
					if(!Db.equals("//"))
					{
						PL.get(index).SetDOB(Db);
					}
					if(!Email.equals(""))
					{
						PL.get(index).SetEmail(Email);
					}
					
					PersonData test =new PersonData();
					test.WriteData(PL);
					lbl.setText("       	          User account was edited");
					lbl.setForeground(Color.GREEN);
					
					Label1.setText("");
					Label2.setText("");
					 Label3.setText("");
					 Label4.setText("");
				}
				else
				{
					lbl.setText(" First retrieve the user then click on edit");
					lbl.setForeground(Color.RED);
				}
							
				text_Field1.setText("");
				text_Field2.setText("");
				text_Field3.setText("");
				text_Field4.setText("");
				text_Field5.setText("");
				text_Field6.setText("");
				
			}
		});
		DeleteUser.setBounds(377, 343, 186, 38);
		frame2.getContentPane().add(DeleteUser);
		
		JButton btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				serialization test=new serialization();
				
				frame2.setVisible(false);
			    
		        test.Frame.setVisible(true);
			}
		});
		
		btnBack.setBounds(294, 403, 133, 38);
		frame2.getContentPane().add(btnBack);
		
		NewLabel_2 = new JLabel("After Retrieval fill in the info in the blanks that you want to change");
		NewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NewLabel_2.setBounds(81, 228, 633, 29);
		frame2.getContentPane().add(NewLabel_2);
		
		text_Field1 = new JTextField();
		text_Field1.setColumns(10);
		text_Field1.setBounds(31, 283, 152, 29);
		frame2.getContentPane().add(text_Field1);
		
		text_Field2 = new JTextField();
		text_Field2.setColumns(10);
		text_Field2.setBounds(209, 283, 152, 29);
		frame2.getContentPane().add(text_Field2);
		
		text_Field3 = new JTextField();
		text_Field3.setColumns(10);
		text_Field3.setBounds(389, 283, 38, 29);
		frame2.getContentPane().add(text_Field3);
		
		text_Field4 = new JTextField();
		text_Field4.setColumns(10);
		text_Field4.setBounds(456, 283, 38, 29);
		frame2.getContentPane().add(text_Field4);
		
		text_Field5 = new JTextField();
		text_Field5.setColumns(10);
		text_Field5.setBounds(525, 283, 38, 29);
		frame2.getContentPane().add(text_Field5);
		
		text_Field6 = new JTextField();
		text_Field6.setColumns(10);
		text_Field6.setBounds(591, 283, 152, 29);
		frame2.getContentPane().add(text_Field6);
	}
	

}
