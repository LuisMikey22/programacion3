package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import controllers.UserController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.UserModel;

public class UserView {
	
	JFrame frame;
	UserModel userModel;
	UserController uc;
	
	public UserView() {
		frame = new JFrame();
		frame.setTitle("Usuarios BD");
		frame.setBounds(0, 0, 700, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void users(String [] column, String [][] row) {
		JPanel backgroundPnl = new JPanel();
		backgroundPnl.setBackground(Color.pink);
		backgroundPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
		backgroundPnl.setLayout(new BorderLayout(0, 20));
		frame.setContentPane(backgroundPnl);
		
		JLabel userLbl = new JLabel("USERS");
		userLbl.setForeground(Color.black);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		userLbl.setHorizontalAlignment(JLabel.CENTER);
		userLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userLbl.setOpaque(false);
	    backgroundPnl.add(userLbl, BorderLayout.NORTH);
		
		JTable productTable = new JTable(row, column);
	    productTable.setOpaque(false);
	    
	    JScrollPane scrollPane = new JScrollPane(productTable);
	    scrollPane.setOpaque(false);
	    backgroundPnl.add(scrollPane, BorderLayout.CENTER);
	    
	    JButton refreshBttn = new JButton("Refresh");
	    refreshBttn.setBackground(Color.black);
	    refreshBttn.setForeground(Color.white);
	    refreshBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    backgroundPnl.add(refreshBttn, BorderLayout.SOUTH);
	    
	    refreshBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				uc = new UserController();
				uc.users();
			}
	    	
	    });
		
		frame.setVisible(true);
	}
}
