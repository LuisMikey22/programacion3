package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame{
	
	public Login(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		this.setLayout(null); //desactivar los contenedores por defecto
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(500, 610); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(300, 400));
		this.setMaximumSize(new Dimension(800, 900)); 
		this.setResizable(isMaximumSizeSet());

		this.add(this.login());
		
		JMenuBar barra = new JMenuBar(); //barra de munus
		
		JMenu menu1 = new JMenu("Archivo");
		JMenu menu2 = new JMenu("Ayuda");
		
		JMenuItem opNew = new JMenuItem("Nuevo");
		JMenuItem opOpen = new JMenuItem("Abrir");
		JMenuItem opSave = new JMenuItem("Guardar");
		JMenuItem opClose = new JMenuItem("Cerrar");
		
		menu1.add(opNew);
		menu1.add(opOpen);
		menu1.add(opSave);
		menu1.add(opClose);
		
		JRadioButtonMenuItem opHelp = new JRadioButtonMenuItem("Manual de Usuario: ");
		JCheckBoxMenuItem opSupport = new JCheckBoxMenuItem("Soporte tecnico: ");

		menu2.add(opHelp);
		menu2.add(opSupport);
		
		barra.add(menu1);
		barra.add(menu2);

		this.setJMenuBar(barra);
		
		
		this.repaint();
	}
	
	public JPanel login() {
		JPanel loginPnl = new JPanel(); 
		loginPnl.setSize(500, 610);
		loginPnl.setLocation(0, 0);
		loginPnl.setBackground(Color.decode("#BFE4FF"));
		loginPnl.setOpaque(true);
		
		
		Image imageLogo = new ImageIcon("vortex.png").getImage().getScaledInstance(208, 70, Image.SCALE_SMOOTH);
		ImageIcon imageLogoIcon = new ImageIcon(imageLogo);
		JLabel logo = new JLabel(imageLogoIcon);
		logo.setSize(208, 70);
		logo.setLocation(138, 20);
		logo.setOpaque(false); //tiene fondo o no
		logo.setHorizontalAlignment(JLabel.LEFT);
		this.add(logo);
		
		JLabel loginLbl = new JLabel("Iniciar sesión");
		loginLbl.setSize(240, 40);
		loginLbl.setLocation(124, 130);
		loginLbl.setForeground(Color.decode("#1B313F")); //color de letra
		loginLbl.setOpaque(false); //tiene fondo o no
		loginLbl.setHorizontalAlignment(JLabel.CENTER);
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		this.add(loginLbl);
		
		ImageIcon imageHdr = new ImageIcon("pestaña vortex.png");
		JLabel header = new JLabel(imageHdr);
		header.setSize(500, 340);
		header.setLocation(0, 0);
		header.setOpaque(false); //tiene fondo o no
		header.setHorizontalAlignment(JLabel.LEFT);
		this.add(header);
		
		JLabel userLbl = new JLabel("Nombre de usuario");
		userLbl.setSize(300, 40); 
		userLbl.setLocation(92, 186);
		userLbl.setForeground(Color.decode("#1B313F")); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.LEFT);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(userLbl);
		
		Image imageUser = new ImageIcon("personaIcon.png").getImage().getScaledInstance(12, 22, Image.SCALE_SMOOTH);
		ImageIcon imageUserIcon = new ImageIcon(imageUser);
		JLabel userIcon = new JLabel(imageUserIcon);
		userIcon.setSize(14, 26);
		userIcon.setLocation(108, 220);
		userIcon.setOpaque(false); //tiene fondo o no
		userIcon.setHorizontalAlignment(JLabel.LEFT);
		this.add(userIcon);
		
		JTextField userTxtFld = new JTextField();
		userTxtFld.setSize(260, 30);
		userTxtFld.setLocation(132, 220);
		userTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userTxtFld.setOpaque(true); //tiene fondo o no
		userTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		this.add(userTxtFld);
		
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setSize(300, 40);
		passwordLbL.setLocation(92, 256);
		passwordLbL.setForeground(Color.decode("#1B313F")); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(passwordLbL);
		
		Image imageLock = new ImageIcon("candadoIcon.png").getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		ImageIcon imageLockIcon = new ImageIcon(imageLock);
		JLabel lockIcon = new JLabel(imageLockIcon);
		lockIcon.setSize(20, 26);
		lockIcon.setLocation(106, 290);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		this.add(lockIcon);
		
		Image imageEye = new ImageIcon("contraIcon.png").getImage().getScaledInstance(30, 16, Image.SCALE_SMOOTH);
		ImageIcon imageEyeIcon = new ImageIcon(imageEye);
		JLabel eyeIcon = new JLabel(imageEyeIcon);
		eyeIcon.setSize(30, 16);
		eyeIcon.setLocation(362, 296);
		eyeIcon.setOpaque(false); //tiene fondo o no
		eyeIcon.setHorizontalAlignment(JLabel.LEFT);
		this.add(eyeIcon);
		
		JPasswordField PasswordFld = new JPasswordField();
		PasswordFld.setSize(226, 30);
		PasswordFld.setLocation(132, 290);
		PasswordFld.setForeground(Color.decode("#1B313F")); //color de letra
		PasswordFld.setOpaque(true); //tiene fondo o no
		PasswordFld.setHorizontalAlignment(JLabel.LEFT);
		PasswordFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		this.add(PasswordFld);
		
		JButton olvidarBttn = new JButton("¿Olvidó su contraseña?");
		olvidarBttn.setSize(146, 20);
		olvidarBttn.setLocation(245, 345);
		olvidarBttn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#1B313F")));
		olvidarBttn.setForeground(Color.decode("#1B313F")); //color de letra
		olvidarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		olvidarBttn.setContentAreaFilled(false);
		olvidarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		olvidarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		olvidarBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		this.add(olvidarBttn);
		
		JCheckBox recordarChkBx = new JCheckBox("Recordar nombre");
		recordarChkBx.setSize(240, 20);
		recordarChkBx.setLocation(88, 345);
		recordarChkBx.setOpaque(false); //tiene fondo o no
		recordarChkBx.setForeground(Color.decode("#1B313F")); //color de letra
		recordarChkBx.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		recordarChkBx.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		recordarChkBx.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		recordarChkBx.setHorizontalAlignment(SwingConstants.LEFT); // centrar texto del check box
		recordarChkBx.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		this.add(recordarChkBx);
		
		JButton ingresarBttn = new JButton("Ingresar");
		ingresarBttn.setSize(300, 50);
		ingresarBttn.setLocation(92, 390);
		ingresarBttn.setBackground(Color.decode("#1B313F"));
		ingresarBttn.setForeground(Color.white); //color de letra
		ingresarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		ingresarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		ingresarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		ingresarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		ingresarBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		this.add(ingresarBttn);
		
		JButton cuentaBttn = new JButton("Crear Cuenta");
		cuentaBttn.setSize(300, 50);
		cuentaBttn.setLocation(92, 490);
		cuentaBttn.setBackground(Color.decode("#1B313F"));
		cuentaBttn.setForeground(Color.white); //color de letra
		cuentaBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		cuentaBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		cuentaBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		cuentaBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		cuentaBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		this.add(cuentaBttn);
		
		JLabel cuentaLbl = new JLabel("¿No tiene una cuenta?");
		cuentaLbl.setSize(180, 20); 
		cuentaLbl.setLocation(160, 458);
		cuentaLbl.setForeground(Color.decode("#1B313F")); //color de letra
		cuentaLbl.setOpaque(false); //tiene fondo o no
		cuentaLbl.setHorizontalAlignment(JLabel.LEFT);
		cuentaLbl.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		this.add(cuentaLbl);
		
		return loginPnl; //añadir panel al marco (JFrame)
	}

}