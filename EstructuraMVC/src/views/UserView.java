package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controllers.*;
import customClasses.User;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import models.UserModel;

public class UserView {
	
	JFrame frame;
	UserModel um;
	UserController uc;
	HomeController hm;
	
	public UserView() {
		frame = new JFrame();
		frame.setTitle("Usuarios BD");
		frame.setBounds(0, 0, 700, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void users(String [] column, ArrayList<User> users) {
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
		
	    String[][] rows = new String[users.size()][7]; //registros de la base de datos y 7 campos
	    if(users!=null) {
	    	 for(int i=0; i<users.size(); i++) { //recorrer el ArrayList y obtener los valores
	    		 rows[i][0] = String.valueOf(users.get(i).getId());
	    		 rows[i][1] = String.valueOf(users.get(i).getName());
	    		 rows[i][2] = String.valueOf(users.get(i).getEmail());
			 	 rows[i][3] = String.valueOf(users.get(i).getRole());
		     	 rows[i][4] = String.valueOf(users.get(i).getPhone());
		     	 rows[i][5] = String.valueOf(users.get(i).getCreatedAt());
		     	 rows[i][6] = String.valueOf(users.get(i).getUpdatedAt());
			 }
	    }
	    
	    DefaultTableModel tableModel = new DefaultTableModel(rows, column);
		JTable usersTable = new JTable(tableModel);
	    usersTable.setOpaque(false);
	    usersTable.setDefaultEditor(Object.class, null);
	    usersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    usersTable.getTableHeader().setReorderingAllowed(false);
	    usersTable.getTableHeader().setResizingAllowed(false);
	    
	    JScrollPane scrollPane = new JScrollPane(usersTable);
	    scrollPane.setOpaque(false);
	    backgroundPnl.add(scrollPane, BorderLayout.CENTER);
	    
	    //panel de botones
	    JPanel buttonPnl = new JPanel();
	    buttonPnl.setOpaque(false);
	    buttonPnl.setLayout(new GridLayout(1, 4, 20, 0));
	    backgroundPnl.add(buttonPnl, BorderLayout.SOUTH);
	    
	    JButton backBttn = new JButton("Back");
	    backBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    backBttn.setBackground(Color.white);
	    backBttn.setForeground(Color.black);
		buttonPnl.add(backBttn);
		
		backBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				hm = new HomeController();
				hm.home();
			}
		});
	    
	    JButton refreshBttn = new JButton("Refresh");
	    refreshBttn.setBackground(Color.black);
	    refreshBttn.setForeground(Color.white);
	    refreshBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    buttonPnl.add(refreshBttn);
	    
	    refreshBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				uc = new UserController();
				uc.users();
			}
	    });
	    
	    JButton deleteBttn = new JButton("Delete");
	    deleteBttn.setBackground(Color.decode("#EF2D2D"));
	    deleteBttn.setForeground(Color.white);
	    deleteBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    buttonPnl.add(deleteBttn);
	    
	    deleteBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Volver", "Eliminar"};
				String message = "Esta acción no se puede deshacer.";
				 
				int seletedRow = usersTable.getSelectedRow();
				if(seletedRow>=0) {
					int opc = JOptionPane.showOptionDialog(null, message, "Borrar cliente", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
					
					if(opc==1) {
						User user = users.get(seletedRow);
					
						um = new UserModel();
						if(um.deleteUser(user)) {
							tableModel.removeRow(seletedRow);
							backgroundPnl.repaint();
						}
					}
				}
			}
	    });
	    
	    JButton addBttn = new JButton("Add");
	    addBttn.setBackground(Color.decode("#2A6B01"));
	    addBttn.setForeground(Color.white);
	    addBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    buttonPnl.add(addBttn);
	    
	    addBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				uc = new UserController();
				uc.addUser();;
			}
	    });
	    
	    JButton editBttn = new JButton("Edit");
	    editBttn.setBackground(Color.decode("#CC9900"));
	    editBttn.setForeground(Color.white);
	    editBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    buttonPnl.add(editBttn);
	    
	    editBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int seletedRow = usersTable.getSelectedRow();
				if(seletedRow>=0) {
					User user = users.get(seletedRow);
					frame.dispose();
					uc = new UserController();
					uc.updateUser(user);
				}
			}
	    });
		
		frame.setVisible(true);
	}
	
	public void addUser() {
		JPanel backgroundPnl = new JPanel();
		backgroundPnl.setBackground(new Color(255, 255, 255));
		backgroundPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
		backgroundPnl.setLayout(new BorderLayout(0, 20));
		frame.setContentPane(backgroundPnl);

		JLabel addUserLbl = new JLabel("Add user");
		addUserLbl.setForeground(Color.black);
		addUserLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		addUserLbl.setHorizontalAlignment(JLabel.CENTER);
		backgroundPnl.add(addUserLbl, BorderLayout.NORTH);
		
		//panel de formulario
	    JPanel infoPnl = new JPanel();
	    infoPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
	    infoPnl.setOpaque(false);
	    infoPnl.setLayout(new GridLayout(8, 2));
	    backgroundPnl.add(infoPnl, BorderLayout.CENTER);

		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setOpaque(false);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(nameLbl);
		
		JTextField nameTxtFld = new JTextField();
		nameTxtFld.setBackground(Color.white);
		nameTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(nameTxtFld);
		
		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setOpaque(false);
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(emailLbl);
		
		JTextField emailTxtFld = new JTextField();
		emailTxtFld.setBackground(Color.white);
		emailTxtFld.setOpaque(true);
		emailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(emailTxtFld);

		JLabel roleLbl = new JLabel("Role:");
		roleLbl.setOpaque(false);
		roleLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		roleLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(roleLbl);
		
		JTextField roleTxtFld = new JTextField();
		roleTxtFld.setBackground(Color.white);
		roleTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(roleTxtFld);
		
		JLabel phoneLbl = new JLabel("Phone:");
		phoneLbl.setOpaque(false);
		phoneLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		phoneLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(phoneLbl);
		
		JTextField phoneTxtFld = new JTextField();
		phoneTxtFld.setBackground(Color.white);
		phoneTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(phoneTxtFld);
		
		 //panel de botones
	    JPanel buttonPnl = new JPanel();
	    buttonPnl.setOpaque(false);
	    buttonPnl.setLayout(new GridLayout(1, 3, 20, 0));
	    backgroundPnl.add(buttonPnl, BorderLayout.SOUTH);
	    
	    JButton backBttn = new JButton("Back");
	    backBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    backBttn.setBackground(Color.white);
	    backBttn.setForeground(Color.black);
		buttonPnl.add(backBttn);
		
		backBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				uc = new UserController();
				uc.users();
			}
		});
	    
		JButton saveBttn = new JButton("Save");
		saveBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		saveBttn.setBackground(Color.black);
		saveBttn.setForeground(Color.white);
		buttonPnl.add(saveBttn);
		
		saveBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTxtFld.getText();
				String email = emailTxtFld.getText();
				String role = roleTxtFld.getText();
				String phone = phoneTxtFld.getText();
				
				um = new UserModel();
				if(um.addUser(name, email, role, phone)) {
					frame.dispose();
					uc = new UserController();
					uc.users();
				}
				
			}
			
		});
		
		frame.setVisible(true);
		 
	}
	
	public void updateUser(User user) {
		JPanel backgroundPnl = new JPanel();
		backgroundPnl.setBackground(new Color(255, 255, 255));
		backgroundPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
		backgroundPnl.setLayout(new BorderLayout(0, 20));
		frame.setContentPane(backgroundPnl);

		JLabel addUserLbl = new JLabel("Update user");
		addUserLbl.setForeground(Color.black);
		addUserLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		addUserLbl.setHorizontalAlignment(JLabel.CENTER);
		backgroundPnl.add(addUserLbl, BorderLayout.NORTH);
		
		//panel de formulario
	    JPanel infoPnl = new JPanel();
	    infoPnl.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); 
	    infoPnl.setOpaque(false);
	    infoPnl.setLayout(new GridLayout(8, 2));
	    backgroundPnl.add(infoPnl, BorderLayout.CENTER);

		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setOpaque(false);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(nameLbl);
		
		JTextField nameTxtFld = new JTextField(user.getName());
		nameTxtFld.setBackground(Color.white);
		nameTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(nameTxtFld);
		
		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setOpaque(false);
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(emailLbl);
		
		JTextField emailTxtFld = new JTextField(user.getEmail());
		emailTxtFld.setBackground(Color.white);
		emailTxtFld.setOpaque(true);
		emailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(emailTxtFld);

		JLabel roleLbl = new JLabel("Role:");
		roleLbl.setOpaque(false);
		roleLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		roleLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(roleLbl);
		
		JTextField roleTxtFld = new JTextField(user.getRole());
		roleTxtFld.setBackground(Color.white);
		roleTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(roleTxtFld);
		
		JLabel phoneLbl = new JLabel("Phone:");
		phoneLbl.setOpaque(false);
		phoneLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		phoneLbl.setHorizontalAlignment(JLabel.CENTER);
		infoPnl.add(phoneLbl);
		
		JTextField phoneTxtFld = new JTextField(user.getPhone());
		phoneTxtFld.setBackground(Color.white);
		phoneTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		infoPnl.add(phoneTxtFld);
		
		 //panel de botones
	    JPanel buttonPnl = new JPanel();
	    buttonPnl.setOpaque(false);
	    buttonPnl.setLayout(new GridLayout(1, 3, 20, 0));
	    backgroundPnl.add(buttonPnl, BorderLayout.SOUTH);
	    
	    JButton backBttn = new JButton("Back");
	    backBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    backBttn.setBackground(Color.white);
	    backBttn.setForeground(Color.black);
		buttonPnl.add(backBttn);
		
		backBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				uc = new UserController();
				uc.users();
			}
		});
	    
		JButton updateBttn = new JButton("Update");
		updateBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		updateBttn.setBackground(Color.black);
		updateBttn.setForeground(Color.white);
		buttonPnl.add(updateBttn);
		
		updateBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTxtFld.getText();
				String email = emailTxtFld.getText();
				String role = roleTxtFld.getText();
				String phone = phoneTxtFld.getText();
				
				User updatedUser = new User(user.getId(), name, email, role, phone, user.getCreatedAt(), user.getUpdatedAt());
				um = new UserModel();
				if(um.update(updatedUser)) {
					frame.dispose();
					uc = new UserController();
					uc.users();
				}
				
			}
			
		});
		
		frame.setVisible(true);
		
	}
}
