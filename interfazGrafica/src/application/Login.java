package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

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
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("vortexIcon.png");
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1000, 750); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(1000, 750));
		this.setMaximumSize(new Dimension(1000, 750)); 
		this.setResizable(isMaximumSizeSet());

		this.add(this.login(), BorderLayout.CENTER);
		
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
		JPanel generalPnl = new JPanel();
		generalPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		generalPnl.setOpaque(true);
		
		JPanel loginPnl = new JPanel(); //panel con los elementos interactivos para iniciar sesión
		loginPnl.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		loginPnl.setSize(500, 500);
		loginPnl.setLocation(250, 105);
		loginPnl.setBackground(Color.decode("#BFE4FF"));
		loginPnl.setOpaque(true);
		generalPnl.add(loginPnl, BorderLayout.CENTER);
		
		
		//imagen de fondo
		ImageIcon windowBackground = new ImageIcon("windowBackground.png");
		JLabel backgroundLbl = new JLabel(windowBackground); 
		backgroundLbl.setOpaque(true);
		generalPnl.add(backgroundLbl);
		
		//logo version anterior
		/*Image imageLogo = new ImageIcon("vortexLogo.png").getImage().getScaledInstance(208, 70, Image.SCALE_SMOOTH);
		ImageIcon imageLogoIcon = new ImageIcon(imageLogo);
		JLabel logo = new JLabel(imageLogoIcon);
		logo.setSize(208, 70);
		logo.setLocation(138, 20);
		logo.setOpaque(false); //tiene fondo o no
		logo.setHorizontalAlignment(JLabel.LEFT);
		loginPnl.add(logo);*/
		
		//cabecera
		ImageIcon imageHdr = new ImageIcon("vortexLogoHeader.png");
		JLabel header = new JLabel(imageHdr);
		header.setOpaque(false); //tiene fondo o no
		header.setHorizontalAlignment(JLabel.CENTER);
		c.anchor = GridBagConstraints.NORTH; //en la cabecera
		c.insets = new Insets(0, 0, 0, 0); //relleno hacia arriba
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3; //espacios de la cuadrícula que abarca
		c.gridx = 0;
		c.gridy = 0;
		loginPnl.add(header, c); //colocar elementos en norte/cabecera
		
		JLabel loginLbl = new JLabel("Iniciar sesión");
		loginLbl.setForeground(Color.decode("#1B313F")); //color de letra
		loginLbl.setOpaque(false); //tiene fondo o no
		loginLbl.setHorizontalAlignment(JLabel.CENTER);
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.insets = new Insets(20, 0, 0, 0); //relleno hacia arriba
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; //relleno interno entre el texto y el borde del componente
		c.weightx = 0.5; //espacio extra horizontalmente
		c.gridwidth = 3; //espacios de la cuadrícula que abarca
		c.gridx = 0;
		c.gridy = 1;
		loginPnl.add(loginLbl, c); //colocar elementos en norte/cabecera
		
		
		//elementos de usuario
		JLabel userLbl = new JLabel("Nombre de usuario");
		userLbl.setForeground(Color.decode("#1B313F")); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.LEFT);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.insets = new Insets(20, 0, 0, 0); //relleno hacia arriba
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 1;
		c.gridy = 2;
		loginPnl.add(userLbl, c);
		
		Image imageUser = new ImageIcon("userIcon.png").getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		ImageIcon imageUserIcon = new ImageIcon(imageUser);
		JLabel userIcon = new JLabel(imageUserIcon);
		userIcon.setOpaque(false); //tiene fondo o no
		userIcon.setHorizontalAlignment(JLabel.LEFT);
		c.insets = new Insets(0, 40, 0, 0); //relleno hacia la izquierda
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 0;
		c.gridy = 3;
		loginPnl.add(userIcon, c);
		
		JTextField userTxtFld = new JTextField();
		userTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userTxtFld.setOpaque(true); //tiene fondo o no
		userTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		c.insets = new Insets(0, 0, 0, 20); //relleno hacia la derecha
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 1;
		c.gridy = 3;
		loginPnl.add(userTxtFld, c);
		
		
		//elementos de contraseña	
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setForeground(Color.decode("#1B313F")); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.insets = new Insets(20, 0, 0, 0); //relleno hacia arriba
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 1;
		c.gridy = 4;
		loginPnl.add(passwordLbL, c);
		
		Image imageLock = new ImageIcon("lockIcon.png").getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		ImageIcon imageLockIcon = new ImageIcon(imageLock);
		JLabel lockIcon = new JLabel(imageLockIcon);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		c.insets = new Insets(0, 40, 0, 0); //relleno hacia la izquierda
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 0;
		c.gridy = 5;
		loginPnl.add(lockIcon, c);
		
		Image imageEye = new ImageIcon("eyeSeesIcon.png").getImage().getScaledInstance(30, 16, Image.SCALE_SMOOTH);
		ImageIcon imageEyeIcon = new ImageIcon(imageEye);
		JLabel eyeIcon = new JLabel(imageEyeIcon);
		eyeIcon.setOpaque(false); //tiene fondo o no
		eyeIcon.setHorizontalAlignment(JLabel.LEFT);
		c.insets = new Insets(0, 0, 0, 40); //relleno hacia la izquierda
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 2;
		c.gridy = 5;
		loginPnl.add(eyeIcon, c);
		
		JPasswordField PasswordFld = new JPasswordField();
		PasswordFld.setForeground(Color.decode("#1B313F")); //color de letra
		PasswordFld.setOpaque(true); //tiene fondo o no
		PasswordFld.setHorizontalAlignment(JLabel.LEFT);
		PasswordFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		c.insets = new Insets(0, 0, 0, 20); //relleno hacia la derecha
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 1;
		c.gridy = 5;
		loginPnl.add(PasswordFld, c);
		
		
		//elementos de ayuda		
		JButton olvidarBttn = new JButton("¿Olvidó su contraseña?");
		olvidarBttn.setForeground(Color.decode("#1B313F")); //color de letra
		olvidarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		olvidarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones  
		olvidarBttn.setContentAreaFilled(false);
		olvidarBttn.setHorizontalAlignment(JLabel.CENTER); //centrar el botón
		olvidarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		olvidarBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		c.insets = new Insets(20, 20, 0, 0); //relleno 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 0;
		c.gridy = 6;
		loginPnl.add(olvidarBttn, c);
		
		JCheckBox recordarChkBx = new JCheckBox("Recordar nombre");
		recordarChkBx.setOpaque(false); //tiene fondo o no
		recordarChkBx.setForeground(Color.decode("#1B313F")); //color de letra
		recordarChkBx.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		recordarChkBx.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		recordarChkBx.setHorizontalAlignment(JLabel.CENTER); //centrar el botón
		recordarChkBx.setHorizontalAlignment(SwingConstants.LEFT); // centrar texto del check box
		recordarChkBx.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		c.insets = new Insets(20, 0, 0, 20); //relleno
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 2;
		c.gridy = 6;
		loginPnl.add(recordarChkBx, c);
		
		
		//Botones de accion
		JButton cuentaBttn = new JButton("Crear Cuenta");
		cuentaBttn.setBackground(Color.decode("#33627F"));
		cuentaBttn.setForeground(Color.white); //color de letra
		cuentaBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		cuentaBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		cuentaBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		cuentaBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		cuentaBttn.setFont(new Font("Tahoma", Font.BOLD, 16)); //fuente, tipo y tamaño
		c.insets = new Insets(0, 20, 0, 0); //relleno hacia arriba
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 0;
		c.gridy = 7;
		loginPnl.add(cuentaBttn, c);
		
		JButton ingresarBttn = new JButton("Ingresar");
		ingresarBttn.setBackground(Color.decode("#1B313F"));
		ingresarBttn.setForeground(Color.white); //color de letra
		ingresarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		ingresarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		ingresarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		ingresarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		ingresarBttn.setFont(new Font("Tahoma", Font.BOLD, 16)); //fuente, tipo y tamaño
		c.insets = new Insets(0, 0, 0, 20); //relleno hacia arriba
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0; //espacio extra horizontalmente
		c.gridwidth = 1; //espacios de la cuadrícula que abarca
		c.gridx = 2;
		c.gridy = 7;
		loginPnl.add(ingresarBttn, c);
		
		return generalPnl; //añadir panel al marco (JFrame)
	}

}