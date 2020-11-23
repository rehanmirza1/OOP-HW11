package oophw11;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Display {
ArrayList<PersonData>PL  =new ArrayList<PersonData>();
	public JFrame Frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display win = new Display();
					win.Frame.setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
	}

	public Display() {
		initialize();
	}

	private void initialize() {
		Frame = new JFrame();
		Frame.setBounds(100, 100, 703, 424);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setLayout(null);
		
		JEditorPane editPane = new JEditorPane();
		editPane.setBounds(10, 89, 140, 217);
		Frame.getContentPane().add(editPane);
		
		JEditorPane editPane1 = new JEditorPane();
		editPane1.setBounds(168, 89, 140, 217);
		Frame.getContentPane().add(editPane1);
		
		JEditorPane editPane2 = new JEditorPane();
		editPane2.setBounds(334, 89, 150, 217);
		Frame.getContentPane().add(editPane2);
		
		JEditorPane editPane3 = new JEditorPane();
		editPane3.setBounds(512, 89, 165, 217);
		Frame.getContentPane().add(editPane3);
		
		JLabel lbl = new JLabel("Name");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl.setBounds(45, 37, 105, 25);
		Frame.getContentPane().add(lbl);
		
		JLabel Phone = new JLabel("Phone Number");
		Phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Phone.setBounds(168, 37, 150, 25);
		Frame.getContentPane().add(Phone);
		
		JLabel DateBirth = new JLabel("Date Of Birth");
		DateBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DateBirth.setBounds(344, 37, 140, 25);
		Frame.getContentPane().add(DateBirth);
		
		JLabel Email = new JLabel("Email Address");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Email.setBounds(512, 37, 140, 25);
		Frame.getContentPane().add(Email);
		
		JButton Button = new JButton("Return To Main Menu");
		Button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				serialization test =new serialization();
				Frame.setVisible(false);
		        test.Frame.setVisible(true);
			}
		});
		Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button.setBounds(224, 340, 250, 34);
		
		Frame.getContentPane().add(Button);
		PersonData test=new PersonData();
		PL = test.ReadData();
		
		for(int i=0; i<PL.size(); i++)
		{
			PersonData temp=PL.get(i);
			System.out.println("Name :"+temp.GetName());
			editPane.setText(	editPane.getText()+temp.GetName()+"\n");
			editPane1.setText(	editPane1.getText()+temp.GetNumber()+"\n");
			editPane2.setText(	editPane2.getText()+temp.DOB()+"\n");
			editPane3.setText(	editPane3.getText()+temp.EmailAddress()+"\n");
		}	
	}
}
