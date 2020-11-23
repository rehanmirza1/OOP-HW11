/*
 * Author: Rehan Mirza
 * CPSC-24500-004
 * This program uses serialization to develop a menu
 */
package oophw11;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class serialization {
		public JFrame Frame;

		public static void main(String[] args) {
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					
					try {
						serialization Win = new serialization();
						Win.Frame.setVisible(true);
					} catch (Exception x) {
						x.printStackTrace();
					}
				}
			});
		}

		public serialization() {
			initialize();
		}

		private void initialize() {
			
			Frame = new JFrame();
			Frame.setBounds(100, 100, 450, 558);
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame.getContentPane().setLayout(null);
			
			JButton B1 = new JButton("Create Account");
			B1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Update test =new Update();
					Frame.setVisible(false);
			        test.Frame.setVisible(true);
						
				}
			});
			
			B1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			B1.setBounds(81, 76, 267, 41);
			Frame.getContentPane().add(B1);
			
			JButton B2 = new JButton("Display All Accounts");
			B2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					Display test=	new Display();
					Frame.setVisible(false); 
			        test.Frame.setVisible(true);
			        
				}
			});
			B2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			B2.setBounds(81, 180, 267, 41);
			Frame.getContentPane().add(B2);
			
			JButton B3 = new JButton("Edit Account");
			B3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					ChangeData test=new ChangeData();
					Frame.setVisible(false);   
			        test.frame2.setVisible(true);
				}
			});
			B3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			B3.setBounds(81, 281, 267, 41);
			Frame.getContentPane().add(B3);
			
			JButton B4 = new JButton("Delete Account");
			B4.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					Delete test =new Delete();
					Frame.setVisible(false);
			        test.Frame.setVisible(true);
				}
			});
			B4.setFont(new Font("Tahoma", Font.PLAIN, 16));
			B4.setBounds(81, 381, 267, 41);
			Frame.getContentPane().add(B4);
			
			JLabel Label1 = new JLabel("  Main Menu");
			Label1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			Label1.setBounds(148, 23, 162, 20);
			Frame.getContentPane().add(Label1);
			
			JButton B5 = new JButton("Exit");
			B5.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Frame.setVisible(false);
				}
			});
			B5.setFont(new Font("Tahoma", Font.PLAIN, 16));
			B5.setBounds(81, 467, 267, 41);
			Frame.getContentPane().add(B5);

	}

}
