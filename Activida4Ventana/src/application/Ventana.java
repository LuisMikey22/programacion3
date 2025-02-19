package application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Ventana extends JFrame{
	
	String colonias[] = {"Camino Real", "Bellavista", "Progreso", "Pedregal", "Calafia", "Diana Laura",
						 "El Mezquitito", "Indeco", "La Fuente", "Las Américas", "Miramar"};
	
	public Ventana(String title) {
		this.setTitle(title);
		this.setVisible(true);
		this.setResizable(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1050, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		this.add(this.login());
		this.add(this.registro());
		
		this.repaint();
	}
	
	public JPanel login() {
		JPanel loginPnl = new JPanel(); 
		loginPnl.setSize(500, 600);
		loginPnl.setLocation(0, 0);
		loginPnl.setBackground(Color.decode("#BFE4FF"));
		loginPnl.setOpaque(true);
		
		JLabel loginLbl = new JLabel("Iniciar sesión");
		loginLbl.setSize(240, 40);
		loginLbl.setLocation(118, 32);
		loginLbl.setForeground(Color.white); //color de letra
		loginLbl.setOpaque(false); //tiene fondo o no
		loginLbl.setHorizontalAlignment(JLabel.CENTER);
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		this.add(loginLbl);
		
		JLabel header = new JLabel();
		header.setSize(500, 84);
		header.setLocation(0, 0);
		header.setOpaque(true); //tiene fondo o no
		header.setBackground(Color.decode("#33627F"));
		//cabezera.setBackground(Color.decode("#70C5FF"));
		header.setHorizontalAlignment(JLabel.LEFT);
		this.add(header);
		
		JLabel userLbl = new JLabel("Nombre de usuario:");
		userLbl.setSize(240, 40);
		userLbl.setLocation(120, 130);
		userLbl.setForeground(Color.decode("#1B313F")); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.LEFT);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(userLbl);
		
		JTextField userTxtFld = new JTextField();
		userTxtFld.setSize(240, 30);
		userTxtFld.setLocation(120, 180);
		userTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userTxtFld.setOpaque(true); //tiene fondo o no
		userTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		this.add(userTxtFld);
		
		JLabel passwordLbL = new JLabel("Contraseña:");
		passwordLbL.setSize(240, 40);
		passwordLbL.setLocation(120, 238);
		passwordLbL.setForeground(Color.decode("#1B313F")); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(passwordLbL);
		
		JPasswordField PasswordFld = new JPasswordField();
		PasswordFld.setSize(240, 30);
		PasswordFld.setLocation(120, 288);
		PasswordFld.setForeground(Color.decode("#1B313F")); //color de letra
		PasswordFld.setOpaque(true); //tiene fondo o no
		PasswordFld.setHorizontalAlignment(JLabel.LEFT);
		PasswordFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		this.add(PasswordFld);
		
		JButton olvidarBttn = new JButton("¿Olvidó su contraseña?");
		olvidarBttn.setSize(240, 20);
		olvidarBttn.setLocation(102, 358);
		olvidarBttn.setForeground(Color.decode("#1B313F")); //color de letra
		olvidarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		olvidarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		olvidarBttn.setContentAreaFilled(false);
		olvidarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		olvidarBttn.setHorizontalAlignment(SwingConstants.LEFT); // centrar texto del botón
		olvidarBttn.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		this.add(olvidarBttn);
		
		JButton ingresarBttn = new JButton("Ingresar");
		ingresarBttn.setSize(240, 50);
		ingresarBttn.setLocation(120, 410);
		ingresarBttn.setBackground(Color.decode("#1B313F"));
		ingresarBttn.setForeground(Color.white); //color de letra
		ingresarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		ingresarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		ingresarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		ingresarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		ingresarBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		this.add(ingresarBttn);
		
		JCheckBox recordarChkBx = new JCheckBox("Recordar nombre de usuario");
		recordarChkBx.setSize(240, 20);
		recordarChkBx.setLocation(116, 480);
		recordarChkBx.setOpaque(false); //tiene fondo o no
		recordarChkBx.setForeground(Color.decode("#1B313F")); //color de letra
		recordarChkBx.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		recordarChkBx.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		recordarChkBx.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		recordarChkBx.setHorizontalAlignment(SwingConstants.LEFT); // centrar texto del check box
		recordarChkBx.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		this.add(recordarChkBx);
		
		return loginPnl; //añadir panel al marco (JFrame)
	}
	
	public JPanel registro() {
		JPanel registroPnl = new JPanel(); 
		registroPnl.setSize(500, 600);
		registroPnl.setLocation(550, 0);
		registroPnl.setBackground(Color.decode("#BFCFFF"));
		registroPnl.setOpaque(true); //tiene fondo o no
		
		JLabel registroLbl = new JLabel("Registro");
		registroLbl.setSize(240, 40);
		registroLbl.setLocation(668, 32);
		registroLbl.setForeground(Color.white); //color de letra
		registroLbl.setOpaque(false); //tiene fondo o no
		registroLbl.setHorizontalAlignment(JLabel.CENTER);
		registroLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		this.add(registroLbl);
		
		JLabel header = new JLabel();
		header.setSize(500, 84);
		header.setLocation(550, 0);
		header.setOpaque(true); //tiene fondo o no
		header.setBackground(Color.decode("#33497F")); 
		//cabezera.setBackground(Color.decode("#70C5FF"));
		header.setHorizontalAlignment(JLabel.LEFT);
		this.add(header);
		
		JLabel userLbl = new JLabel("Nombre de usuario:");
		userLbl.setSize(290, 40);
		userLbl.setLocation(648, 100);
		userLbl.setForeground(Color.decode("#1B313F")); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.LEFT);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(userLbl);
		
		JTextField userTxtFld = new JTextField();
		userTxtFld.setSize(290, 30);
		userTxtFld.setLocation(648, 145);
		userTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userTxtFld.setOpaque(true); //tiene fondo o no
		userTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		this.add(userTxtFld);
		
		JLabel bioLbL = new JLabel("Biografía:");
		bioLbL.setSize(290, 40);
		bioLbL.setLocation(648, 180);
		bioLbL.setForeground(Color.decode("#1B313F")); //color de letra
		bioLbL.setOpaque(false); //tiene fondo o no
		bioLbL.setHorizontalAlignment(JLabel.LEFT);
		bioLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(bioLbL);
		
		JTextArea bioTxt= new JTextArea();
		bioTxt.setSize(290, 50);
		bioTxt.setLocation(648, 228);
		bioTxt.setForeground(Color.decode("#1B313F")); //color de letra
		bioTxt.setOpaque(true); //tiene fondo o no
		bioTxt.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		bioTxt.setBorder(BorderFactory.createDashedBorder(Color.decode("#1B313F"), 6, 10));
		this.add(bioTxt);
		
		JLabel preferencesLbl = new JLabel("Preferencias");
		preferencesLbl.setSize(240, 20);
		preferencesLbl.setLocation(670, 292);
		preferencesLbl.setForeground(Color.decode("#1B313F")); //color de letra
		preferencesLbl.setHorizontalAlignment(JLabel.LEFT); //centrar 
		preferencesLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto
		preferencesLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(preferencesLbl);
		
		JCheckBox dulceChckBx = new JCheckBox("Dulce");
		dulceChckBx.setSize(60, 20);
		dulceChckBx.setLocation(648, 318);
		dulceChckBx.setOpaque(false); //tiene fondo o no
		dulceChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		dulceChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		this.add(dulceChckBx);
		
		JCheckBox saladoChckBx = new JCheckBox("Salado");
		saladoChckBx.setSize(70, 20);
		saladoChckBx.setLocation(750, 318);
		saladoChckBx.setOpaque(false); //tiene fondo o no
		saladoChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		saladoChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		this.add(saladoChckBx);
		
		JCheckBox SaludableChckBx = new JCheckBox("Saludable");
		SaludableChckBx.setSize(90, 20);
		SaludableChckBx.setLocation(850, 318);
		SaludableChckBx.setOpaque(false); //tiene fondo o no
		SaludableChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		SaludableChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		this.add(SaludableChckBx);
		
		JLabel terminosLbl= new JLabel("Términos");
		terminosLbl.setSize(290, 30);
		terminosLbl.setLocation(648, 345); 
		terminosLbl.setForeground(Color.decode("#1B313F")); //color de letra
		terminosLbl.setHorizontalAlignment(JLabel.LEFT); //centrar 
		terminosLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto 
		terminosLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(terminosLbl);
		
		
		ButtonGroup terminosBttnGrp = new ButtonGroup();
		
		JRadioButton aceptoRBttn = new JRadioButton("Acepto términos");
		aceptoRBttn.setSize(130, 20);
		aceptoRBttn.setLocation(648, 380);
		aceptoRBttn.setOpaque(false); //tiene fondo o no
		aceptoRBttn.setForeground(Color.decode("#1B313F")); //color de letra
		aceptoRBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		this.add(aceptoRBttn);
		
		JRadioButton noAceptoRBttn = new JRadioButton("No acepto términos");
		noAceptoRBttn.setSize(150, 20);
		noAceptoRBttn.setLocation(792, 380);
		noAceptoRBttn.setOpaque(false); //tiene fondo o no
		noAceptoRBttn.setForeground(Color.decode("#1B313F")); //color de letra
		noAceptoRBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		this.add(noAceptoRBttn);
		
		terminosBttnGrp.add(aceptoRBttn); // al estar agrupados solo se puede escoger un Radio Button
		terminosBttnGrp.add(noAceptoRBttn);
		
		
		JComboBox<String> coloniasCmbBx = new JComboBox<>(colonias);
		coloniasCmbBx.setSize(240, 20);
		coloniasCmbBx.setLocation(674, 425);
		coloniasCmbBx.setBackground(Color.white); 
		coloniasCmbBx.setForeground(Color.decode("#1B313F")); //color de letra
		coloniasCmbBx.setFont(new Font("Tahoma", Font.BOLD, 15));//fuente, tipo y tamaño
		this.add(coloniasCmbBx);
		
		JButton CrearBttn = new JButton("Crear Cuenta");
		CrearBttn.setSize(240, 50);
		CrearBttn.setLocation(674, 465);
		CrearBttn.setBackground(Color.decode("#1B313F"));
		CrearBttn.setForeground(Color.white); //color de letra
		CrearBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		CrearBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		CrearBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		CrearBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		CrearBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		this.add(CrearBttn);

		return registroPnl; //añadir panel al marco (JFrame)
	}

}
 