package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setMinimumSize(new Dimension(300, 400));
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
		generalPnl.setSize(1000, 750);
		generalPnl.setLocation(0, 0);
		generalPnl.setOpaque(true);
		
		//panel con los elementos interactivos para iniciar sesión
		JPanel loginPnl = new JPanel(); 
		loginPnl.setSize(500, 500);
		loginPnl.setLocation(250, 105);
		loginPnl.setBackground(Color.decode("#BFE4FF"));
		loginPnl.setOpaque(true);
		generalPnl.add(loginPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		ImageIcon windowBackground = new ImageIcon("windowBackground.png");
		JLabel backgroundLbl = new JLabel(windowBackground); 
		backgroundLbl.setSize(1000, 750);
		backgroundLbl.setLocation(0, 0);
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
		header.setSize(500, 111);
		header.setLocation(0, 0);
		header.setOpaque(false); //tiene fondo o no
		header.setHorizontalAlignment(JLabel.LEFT);
		loginPnl.add(header); //colocar elementos en norte/cabecera
		
		JLabel loginLbl = new JLabel("Iniciar sesión");
		loginLbl.setSize(240, 40);
		loginLbl.setLocation(130, 130);
		loginLbl.setForeground(Color.decode("#1B313F")); //color de letra
		loginLbl.setOpaque(false); //tiene fondo o no
		loginLbl.setHorizontalAlignment(JLabel.CENTER);
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		loginPnl.add(loginLbl); //colocar elementos en norte/cabecera
		
		
		JLabel userLbl = new JLabel("Nombre de usuario");
		userLbl.setSize(300, 40); 
		userLbl.setLocation(92, 186);
		userLbl.setForeground(Color.decode("#1B313F")); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.LEFT);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		loginPnl.add(userLbl);
		
		Image imageUser = new ImageIcon("userIcon.png").getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		ImageIcon imageUserIcon = new ImageIcon(imageUser);
		JLabel userIcon = new JLabel(imageUserIcon);
		userIcon.setSize(20, 26);
		userIcon.setLocation(92, 220);
		userIcon.setOpaque(false); //tiene fondo o no
		userIcon.setHorizontalAlignment(JLabel.LEFT);
		loginPnl.add(userIcon);
		
		JTextField userTxtFld = new JTextField();
		userTxtFld.setSize(296, 30);
		userTxtFld.setLocation(112, 220);
		userTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userTxtFld.setOpaque(true); //tiene fondo o no
		userTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		loginPnl.add(userTxtFld);
		
		
		//elementos de contraseña
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setSize(300, 40);
		passwordLbL.setLocation(92, 256);
		passwordLbL.setForeground(Color.decode("#1B313F")); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		loginPnl.add(passwordLbL);
		
		Image imageLock = new ImageIcon("lockIcon.png").getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		ImageIcon imageLockIcon = new ImageIcon(imageLock);
		JLabel lockIcon = new JLabel(imageLockIcon);
		lockIcon.setSize(20, 26);
		lockIcon.setLocation(92, 290);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		loginPnl.add(lockIcon);
		
		Image imageEye = new ImageIcon("eyeSeesIcon.png").getImage().getScaledInstance(30, 16, Image.SCALE_SMOOTH);
		ImageIcon imageEyeIcon = new ImageIcon(imageEye);
		JLabel eyeIcon = new JLabel(imageEyeIcon);
		eyeIcon.setSize(30, 16);
		eyeIcon.setLocation(362, 296);
		eyeIcon.setOpaque(false); //tiene fondo o no
		eyeIcon.setHorizontalAlignment(JLabel.LEFT);
		loginPnl.add(eyeIcon);
		
		JPasswordField PasswordFld = new JPasswordField();
		PasswordFld.setSize(296, 30);
		PasswordFld.setLocation(112, 290);
		PasswordFld.setForeground(Color.decode("#1B313F")); //color de letra
		PasswordFld.setOpaque(true); //tiene fondo o no
		PasswordFld.setHorizontalAlignment(JLabel.LEFT);
		PasswordFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		loginPnl.add(PasswordFld);
		
		
		//decisiones
		JButton olvidarBttn = new JButton("¿Olvidó su contraseña?");
		olvidarBttn.setSize(146, 20);
		olvidarBttn.setLocation(260, 345);
		olvidarBttn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#1B313F")));
		olvidarBttn.setForeground(Color.decode("#1B313F")); //color de letra
		olvidarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		olvidarBttn.setContentAreaFilled(false);
		olvidarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		olvidarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		olvidarBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		loginPnl.add(olvidarBttn);
		
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
		loginPnl.add(recordarChkBx);
		
		
		//botones
		JButton cuentaBttn = new JButton("Crear Cuenta");
		cuentaBttn.setSize(150, 50);
		cuentaBttn.setLocation(92, 390);
		cuentaBttn.setBackground(Color.decode("#33627F"));
		cuentaBttn.setForeground(Color.white); //color de letra
		cuentaBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		cuentaBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		cuentaBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		cuentaBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		cuentaBttn.setFont(new Font("Tahoma", Font.BOLD, 16)); //fuente, tipo y tamaño
		loginPnl.add(cuentaBttn);
		
		JButton ingresarBttn = new JButton("Ingresar");;
		ingresarBttn.setSize(150, 50);
		ingresarBttn.setLocation(258, 390);
		ingresarBttn.setBackground(Color.decode("#1B313F"));
		ingresarBttn.setForeground(Color.white); //color de letra
		ingresarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		ingresarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		ingresarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		ingresarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		ingresarBttn.setFont(new Font("Tahoma", Font.BOLD, 16)); //fuente, tipo y tamaño
		
		ingresarBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//usuario
				if(userTxtFld.getText().equals("")) 
					userTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				else 
					userTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));

				//contraseña
				String passTxt = new String(PasswordFld.getPassword());
				if(passTxt.equals(""))
					PasswordFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				else 
					PasswordFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
			}
			
		});
		
		loginPnl.add(ingresarBttn);
		
		/*JLabel cuentaLbl = new JLabel("¿No tiene una cuenta?");
		cuentaLbl.setSize(180, 20); 
		cuentaLbl.setLocation(160, 458);
		cuentaLbl.setForeground(Color.decode("#1B313F")); //color de letra
		cuentaLbl.setOpaque(false); //tiene fondo o no
		cuentaLbl.setHorizontalAlignment(JLabel.LEFT);
		cuentaLbl.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		loginPnl.add(cuentaLbl);*/
		
		return generalPnl; //añadir panel al marco (JFrame)
	}

}