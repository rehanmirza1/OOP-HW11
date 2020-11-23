package oophw11;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Delete {
	boolean found;
	int index;
	
	ArrayList<PersonData>PL  =new ArrayList<PersonData>();
	public JFrame Frame;
	JLabel Label1;
	JLabel Label2;
	JLabel Label3;
	JLabel Label4;
	private JTextField text_Field;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Delete win = new Delete();
					win.Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Delete() {
		initialize();
	}

	private void initialize() {
		Frame = new JFrame();
		Frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		Frame.setBounds(100, 100, 793, 393);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("Enter the email ID that you are trying to delete");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl.setBounds(153, 33, 535, 29);
		Frame.getContentPane().add(lbl);
		
		text_Field = new JTextField();
		text_Field.setBounds(294, 85, 152, 29);
		Frame.getContentPane().add(text_Field);
		text_Field.setColumns(10);
		
		JButton Button = new JButton("Retrieving data");
		Button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				 found=false;
				  index=-1;
				String Email=text_Field.getText();
				PersonData test=new PersonData();
				PL=test.ReadData();
				
				for(int x=0;x<PL.size();x++)
				{
					if(PL.get(x).EmailAddress().equals(Email))
					{
						found=true;
						index=x;		
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
					lbl.setText("                    Account not found try again ");
					lbl.setForeground(Color.RED);
					text_Field.setText("");
				}
				
			}
		});
		Button.setBounds(153, 239, 176, 38);
		Frame.getContentPane().add(Button);
		
		 Label1 = new JLabel("");
		Label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label1.setBounds(64, 164, 110, 20);
		Frame.getContentPane().add(Label1);
		
		 Label2 = new JLabel("");
		Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label2.setBounds(223, 164, 110, 20);
		Frame.getContentPane().add(Label2);
		
		 Label3 = new JLabel("");
		Label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label3.setBounds(389, 164, 110, 20);
		Frame.getContentPane().add(Label3);
		
		 Label4 = new JLabel("");
		Label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label4.setBounds(569, 164, 198, 20);
		Frame.getContentPane().add(Label4);
		
		JButton DeleteUser = new JButton("Delete User");
		DeleteUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(found)
				{
				
				PL.remove(index);
				PersonData test =new PersonData();
				test.WriteData(PL);
				lbl.setText("                      The Account was deleted");
				lbl.setForeground(Color.GREEN);
				text_Field.setText("");
				Label1.setText("");
				Label2.setText("");
				 Label3.setText("");
				 Label4.setText("");
				}
				else
				{
					lbl.setText(" First retrieve the account then click remove");
					lbl.setForeground(Color.RED);
				}
			}
		});
		
		DeleteUser.setBounds(374, 239, 186, 38);
		Frame.getContentPane().add(DeleteUser);
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				serialization test=new serialization();
				Frame.setVisible(false);
		        test.Frame.setVisible(true);
			}
		});
		Back.setBounds(286, 305, 133, 38);
		Frame.getContentPane().add(Back);
	}

}