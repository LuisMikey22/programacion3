package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{
	public Ventana(String title) {
		this.setTitle(title);
		this.setVisible(true);
		this.setResizable(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.add(this.login());
		this.repaint();
	}
	
	public JPanel login() {
		JPanel loginPnl = new JPanel(); 
		loginPnl.setSize(500, 500);
		loginPnl.setLocation(0, 0);
		loginPnl.setBackground(Color.decode("#BFE4FF"));
		loginPnl.setOpaque(true);
		
		JLabel loginLbl = new JLabel("Iniciar sesión");
		loginLbl.setSize(240, 40);
		loginLbl.setLocation(118, 32);
		loginLbl.setForeground(Color.white);
		loginLbl.setOpaque(false);
		loginLbl.setHorizontalAlignment(JLabel.CENTER);
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 28));
		this.add(loginLbl);
		
		JLabel cabezera = new JLabel();
		cabezera.setSize(500, 84);
		cabezera.setLocation(0, 0);
		cabezera.setOpaque(true);
		cabezera.setBackground(Color.decode("#33627F"));
		//cabezera.setBackground(Color.decode("#70C5FF"));
		cabezera.setHorizontalAlignment(JLabel.LEFT);
		this.add(cabezera);
		
		JLabel userLbl = new JLabel("Nombre de usuario:");
		userLbl.setSize(240, 40);
		userLbl.setLocation(120, 90);
		userLbl.setForeground(Color.decode("#1B313F"));
		userLbl.setOpaque(false);
		userLbl.setHorizontalAlignment(JLabel.LEFT);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(userLbl);
		
		JTextField userTxtFld = new JTextField();
		userTxtFld.setSize(240, 30);
		userTxtFld.setLocation(120, 140);
		userTxtFld.setForeground(Color.decode("#1B313F"));
		userTxtFld.setOpaque(true); 
		userTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(userTxtFld);
		
		JLabel passwordLbL = new JLabel("Contraseña:");
		passwordLbL.setSize(240, 40);
		passwordLbL.setLocation(120, 178);
		passwordLbL.setForeground(Color.decode("#1B313F"));
		passwordLbL.setOpaque(false);
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(passwordLbL);
		
		JPasswordField PasswordFld = new JPasswordField();
		PasswordFld.setSize(240, 30);
		PasswordFld.setLocation(120, 228);
		PasswordFld.setForeground(Color.decode("#1B313F"));
		PasswordFld.setOpaque(true);
		PasswordFld.setHorizontalAlignment(JLabel.LEFT);
		PasswordFld.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(PasswordFld);
		
		JButton olvidarBttn = new JButton("¿Olvidó su contraseña?");
		olvidarBttn.setSize(240, 20);
		olvidarBttn.setLocation(102, 278);
		olvidarBttn.setForeground(Color.decode("#1B313F"));
		olvidarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		olvidarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		olvidarBttn.setContentAreaFilled(false);
		olvidarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		olvidarBttn.setHorizontalAlignment(SwingConstants.LEFT); // centrar texto del botón
		olvidarBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(olvidarBttn);
		
		JButton ingresarBttn = new JButton("Ingresar");
		ingresarBttn.setSize(240, 50);
		ingresarBttn.setLocation(120, 320);
		ingresarBttn.setBackground(Color.decode("#1B313F"));
		ingresarBttn.setForeground(Color.white);
		ingresarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		ingresarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		ingresarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		ingresarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		ingresarBttn.setFont(new Font("Tahoma", Font.BOLD, 22));
		this.add(ingresarBttn);
		
		JCheckBox recordarChkBx = new JCheckBox("Recordar nombre de usuario");
		recordarChkBx.setSize(240, 20);
		recordarChkBx.setLocation(116, 390);
		recordarChkBx.setOpaque(false);
		recordarChkBx.setForeground(Color.decode("#1B313F"));
		recordarChkBx.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		recordarChkBx.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		recordarChkBx.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		recordarChkBx.setHorizontalAlignment(SwingConstants.LEFT); // centrar texto del check box
		recordarChkBx.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(recordarChkBx);
		
		/*JLabel etiqueta2 = new JLabel("Otro dato");
		etiqueta2.setSize(90, 30);
		etiqueta2.setLocation(60, 80);
		etiqueta2.setBackground(Color.orange);
		etiqueta2.setOpaque(true);*/
		
		return loginPnl;
	}
}
 