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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Login extends JFrame{
	
	String colonias[] = {"Camino Real", "Bellavista", "Progreso", "Pedregal", "Calafia", "Diana Laura",
			 "El Mezquitito", "Indeco", "La Fuente", "Las Américas", "Miramar"};
	
	private String contraseña = "amatista1234";
	private String correoUsuario = "llucatero_23@alu.uabcs.mx";
	private boolean passwordVisible = false;
	
	public Login(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("vortexIcon.png");
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1000, 850); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(1000, 850));
		//this.setMaximumSize(new Dimension(1100, 850));
		this.setResizable(isMaximumSizeSet());

		this.add(this.login(), BorderLayout.CENTER);
		//this.add(this.signIn(), BorderLayout.CENTER);
		
		JMenuBar barra = new JMenuBar(); //barra de munus
		
		JMenu menu1 = new JMenu("Archivo");
		JMenu menu2 = new JMenu("Ayuda");
		JMenu menu3 = new JMenu("Ventana");
		
		//primer menú
		JMenuItem opNew = new JMenuItem("Nuevo");
		JMenuItem opOpen = new JMenuItem("Abrir");
		JMenuItem opSave = new JMenuItem("Guardar");
		JMenuItem opClose = new JMenuItem("Cerrar");
		menu1.add(opNew);
		menu1.add(opOpen);
		menu1.add(opSave);
		menu1.add(opClose);
		
		//segundo menú
		JRadioButtonMenuItem opHelp = new JRadioButtonMenuItem("Manual de Usuario: ");
		JCheckBoxMenuItem opSupport = new JCheckBoxMenuItem("Soporte tecnico: ");
		menu2.add(opHelp);
		menu2.add(opSupport);
		
		//tercer menú
		JMenuItem goToLogin = new JMenuItem("Login");
		JMenuItem goToSignIn= new JMenuItem("Registro");
		menu3.add(goToLogin);
		menu3.add(goToSignIn);
		
		//agregar los menús a la barra de navegación
		barra.add(menu1);
		barra.add(menu2);
		barra.add(menu3);

		
		//agregar acción a los menus de ventana
		goToLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		goToSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("signIn");
			}
			
		});
		
		
		this.setJMenuBar(barra);
		
		this.validate();
		this.revalidate();
		this.repaint();
	}
	
	public JPanel login() {
		JPanel generalPnl1 = new JPanel();
		generalPnl1.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		generalPnl1.setSize(1000, 850);
		generalPnl1.setLocation(0, 0);
		generalPnl1.setOpaque(true);
		
		//agregar panel con los elementos interactivos para iniciar sesión al panel general
		JPanel loginPnl = new JPanel(); 
		loginPnl.setSize(500, 500);
		loginPnl.setLocation(250, 180);
		loginPnl.setBorder(new LineBorder(Color.decode("#1B313F"), 15)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		loginPnl.setBackground(Color.decode("#BFE4FF"));
		loginPnl.setOpaque(true);
		loginPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		generalPnl1.add(loginPnl, BorderLayout.CENTER);
		
		
		//imagen de fondo
		ImageIcon windowBackground = new ImageIcon("windowBackground.png");
		JLabel backgroundLbl = new JLabel(windowBackground); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		generalPnl1.add(backgroundLbl);
		
		
		//elementos del loginPnl
		//cabecera
		ImageIcon imageHdr = new ImageIcon("vortexLogoText.png");
		JLabel header = new JLabel(imageHdr);
		header.setBackground(Color.decode("#1B313F"));
		header.setOpaque(true); //tiene fondo o no
		header.setHorizontalAlignment(JLabel.CENTER);
		generalPnl1.add(header, BorderLayout.NORTH); 
		
		JLabel loginLbl = new JLabel("Iniciar sesión");
		loginLbl.setForeground(Color.decode("#1B313F")); //color de letra
		loginLbl.setOpaque(false); //tiene fondo o no
		loginLbl.setHorizontalAlignment(JLabel.CENTER); //posición del elemento
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER); //posición del texto
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		loginPnl.add(loginLbl, c); 
		
		
		//elementos de usuario
		JPanel userElementsPnl = new JPanel();
		userElementsPnl.setOpaque(false);
		userElementsPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel userEmailLbl = new JLabel("Correo electrónico");
		userEmailLbl.setForeground(Color.decode("#1B313F")); //color de letra
		userEmailLbl.setOpaque(false); //tiene fondo o no
		userEmailLbl.setHorizontalAlignment(JLabel.LEFT);
		userEmailLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		userElementsPnl.add(userEmailLbl, BorderLayout.NORTH);
		
		Image imageUser = new ImageIcon("userIcon.png").getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		ImageIcon imageUserIcon = new ImageIcon(imageUser);
		JLabel userIcon = new JLabel(imageUserIcon);
		userIcon.setOpaque(false); //tiene fondo o no
		userIcon.setHorizontalAlignment(JLabel.LEFT);
		userElementsPnl.add(userIcon, BorderLayout.WEST);
		
		JTextField userEmailTxtFld = new JTextField();
		userEmailTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userEmailTxtFld.setOpaque(true); //tiene fondo o no
		userEmailTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userEmailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		userElementsPnl.add(userEmailTxtFld, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 1; //posición
		loginPnl.add(userElementsPnl, c);
		
		
		//elementos de contraseña
		JPanel passwordElementsPnl = new JPanel();
		passwordElementsPnl.setOpaque(false);
		passwordElementsPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setForeground(Color.decode("#1B313F")); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordElementsPnl.add(passwordLbL, BorderLayout.NORTH);
		
		Image imageLock = new ImageIcon("lockIcon.png").getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		ImageIcon imageLockIcon = new ImageIcon(imageLock);
		JLabel lockIcon = new JLabel(imageLockIcon);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		passwordElementsPnl.add(lockIcon, BorderLayout.WEST);
		
		JPasswordField passwordFld = new JPasswordField();
		passwordFld.setForeground(Color.decode("#1B313F")); //color de letra
		passwordFld.setOpaque(true); //tiene fondo o no
		passwordFld.setHorizontalAlignment(JPasswordField.LEFT);
		passwordFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		passwordElementsPnl.add(passwordFld, BorderLayout.CENTER);
		
		Image imageEye = new ImageIcon("eyeClosedIcon.png").getImage().getScaledInstance(30, 16, Image.SCALE_SMOOTH);
		ImageIcon imageEyeIcon = new ImageIcon(imageEye);
		JButton seeBttn = new JButton();
		seeBttn.setIcon(imageEyeIcon);
		seeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		seeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		seeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		seeBttn.setHorizontalAlignment(JButton.LEFT); //centrar el botón
		passwordElementsPnl.add(seeBttn, BorderLayout.EAST);
		
		//botón para mostrar u ocultar la contraseña
		seeBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Image imageEyeBttn;
				ImageIcon imageEyeBttnIcon;
				
				//mostrar contraseña
				if(!passwordVisible) {
					passwordFld.setEchoChar((char)0); //representar los caracteres de la contraseña con letras 'ABCdario'	
					imageEyeBttn = new ImageIcon("eyeSeesIcon.png").getImage().getScaledInstance(30, 16, Image.SCALE_SMOOTH);
					imageEyeBttnIcon = new ImageIcon(imageEyeBttn);
					seeBttn.setIcon(imageEyeBttnIcon);
					passwordVisible = true;
				}else {
					//ocultar contraseña
					passwordFld.setEchoChar('*'); //representar los caracteres de la contraseña con asteriscos '*'				
					imageEyeBttn = new ImageIcon("eyeClosedIcon.png").getImage().getScaledInstance(30, 16, Image.SCALE_SMOOTH);
					imageEyeBttnIcon = new ImageIcon(imageEyeBttn);
					seeBttn.setIcon(imageEyeBttnIcon);
					passwordVisible = false;
				}
				
			}
			
		});
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 2; //posición
		loginPnl.add(passwordElementsPnl, c);
		
		
		//botones
		JPanel extraOptionsPnl = new JPanel();
		extraOptionsPnl.setOpaque(false);
		extraOptionsPnl.setLayout(new GridLayout(1, 2));
		
		JCheckBox recordarChkBx = new JCheckBox("Recordar nombre");
		recordarChkBx.setOpaque(false); //tiene fondo o no
		recordarChkBx.setForeground(Color.decode("#1B313F")); //color de letra
		recordarChkBx.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		recordarChkBx.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		recordarChkBx.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		recordarChkBx.setHorizontalAlignment(SwingConstants.LEFT); // centrar texto del check box
		recordarChkBx.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		extraOptionsPnl.add(recordarChkBx);
		
		JButton olvidarBttn = new JButton("¿Olvidó su contraseña?");
		olvidarBttn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#1B313F")));
		olvidarBttn.setForeground(Color.decode("#1B313F")); //color de letra
		olvidarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		olvidarBttn.setContentAreaFilled(false);
		olvidarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		olvidarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		olvidarBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		extraOptionsPnl.add(olvidarBttn);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(30, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 3; //posición
		loginPnl.add(extraOptionsPnl, c);
		
		
		//botones
		JPanel actionButtonsPnl = new JPanel();
		actionButtonsPnl.setOpaque(false);
		actionButtonsPnl.setLayout(new GridLayout(1, 2, 20, 10));
		
		JButton cuentaBttn = new JButton("Crear Cuenta");
		cuentaBttn.setBackground(Color.decode("#33627F"));
		cuentaBttn.setForeground(Color.white); //color de letra
		cuentaBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		cuentaBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		cuentaBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		cuentaBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		cuentaBttn.setFont(new Font("Tahoma", Font.BOLD, 16)); //fuente, tipo y tamaño
		actionButtonsPnl.add(cuentaBttn);
		
		//abrir ventana de registro
		cuentaBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("signIn");
			}
			
		});
		
		
		JButton ingresarBttn = new JButton("Ingresar");;
		ingresarBttn.setBackground(Color.decode("#1B313F"));
		ingresarBttn.setForeground(Color.white); //color de letra
		ingresarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		ingresarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		ingresarBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		ingresarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		ingresarBttn.setFont(new Font("Tahoma", Font.BOLD, 16)); //fuente, tipo y tamaño
		actionButtonsPnl.add(ingresarBttn);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(30, 0, 0,0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 4; //posición
		loginPnl.add(actionButtonsPnl, c);
		
		ingresarBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//banderas de campos completados
				boolean flag1 = false, flag2 = false;
				
				//correo vacío
				if(userEmailTxtFld.getText().equals("")) {
					userEmailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				}else { 
					userEmailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					flag1 = true;
				}
				
				
				//contraseña vacía
				String passTxt = new String(passwordFld.getPassword());
				if(passTxt.equals("")) {
					passwordFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				}else { 
					passwordFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completada
					flag2 = true;
				}
				
				
				//validar si los dos campos han sido completados
				if(flag1 && flag2) {
					//cuando ambos campos coinciden con los datos de la cuenta del usuario
					if(userEmailTxtFld.getText().equals(correoUsuario) && passTxt.equals(contraseña) ) {
						String message = "Hola, bienvenido";
						JOptionPane.showMessageDialog(null, message, "Datos correctos", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
					}
					else {
						//cuando alguno de los dos campos no es correcto
						if(!userEmailTxtFld.getText().equals(correoUsuario)) 
							userEmailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						if(!passTxt.equals(contraseña))
							passwordFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						
						String message = "Nombre de usuario o contraseña incorrectos. \n Por favor, inténtelo otra vez.";
						JOptionPane.showMessageDialog(null, message, "Datos incorrectos", JOptionPane.ERROR_MESSAGE); //ventana emergente
					}
				}else { 
					//uno o los dos componentes se encuentran vacíos
					String message = "Uno o más campos obligatorios se encuentran vacíos.";
					JOptionPane.showMessageDialog(null, message, "Campos vacíos", JOptionPane.WARNING_MESSAGE); //ventana emergente
				}
				
			}
			
		});

		return generalPnl1; //añadir panel al marco (JFrame)
		
	}
	

	//panel de registro
	public JPanel signIn() {
		JPanel generalPnl2 = new JPanel();
		generalPnl2.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		generalPnl2.setSize(1000, 850);
		generalPnl2.setLocation(0, 0);
		generalPnl2.setOpaque(true);
		
		JPanel registerPnl = new JPanel(); 
		registerPnl.setSize(500, 600);
		registerPnl.setLocation(250, 105);
		registerPnl.setBorder(new LineBorder(Color.decode("#1B313F"), 15)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		registerPnl.setBackground(Color.decode("#BFE4FF"));
		registerPnl.setOpaque(true); //tiene fondo o no
		registerPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		generalPnl2.add(registerPnl);
	
		//imagen de fondo
		ImageIcon windowBackground = new ImageIcon("windowBackground.png");
		JLabel backgroundLbl = new JLabel(windowBackground); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		generalPnl2.add(backgroundLbl);
		
				
		//elementos del registerPnl
		//cabecera
		ImageIcon imageHdr = new ImageIcon("vortexLogoText.png");
		JLabel header = new JLabel(imageHdr);
		header.setBackground(Color.decode("#1B313F"));
		header.setOpaque(true); //tiene fondo o no
		header.setHorizontalAlignment(JLabel.CENTER);
		generalPnl2.add(header, BorderLayout.NORTH); 
	
		
		JLabel registroLbl = new JLabel("Registro");
		registroLbl.setForeground(Color.decode("#1B313F")); //color de letra
		registroLbl.setOpaque(false); //tiene fondo o no
		registroLbl.setHorizontalAlignment(JLabel.CENTER);
		registroLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		registerPnl.add(registroLbl, c);
		
		//nombre usuario
		JLabel userLbl = new JLabel("Nombre de usuario:");
		userLbl.setForeground(Color.decode("#1B313F")); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.LEFT);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(30, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		registerPnl.add(userLbl, c);
		
		JTextField userTxtFld = new JTextField();
		userTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userTxtFld.setOpaque(true); //tiene fondo o no
		userTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		registerPnl.add(userTxtFld, c);
		
		
		//biografía
		JLabel bioLbL = new JLabel("Biografía:");
		bioLbL.setForeground(Color.decode("#1B313F")); //color de letra
		bioLbL.setOpaque(false); //tiene fondo o no
		bioLbL.setHorizontalAlignment(JLabel.LEFT);
		bioLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		registerPnl.add(bioLbL, c);
		
		JTextArea bioTxt= new JTextArea();
		bioTxt.setForeground(Color.decode("#1B313F")); //color de letra
		bioTxt.setOpaque(true); //tiene fondo o no
		bioTxt.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		bioTxt.setBorder(BorderFactory.createDashedBorder(Color.decode("#1B313F"), 16, 10));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 40;
		registerPnl.add(bioTxt, c);
		
		
		c.ipady = 0;
		
		
		//preferencias
		JLabel preferencesLbl = new JLabel("Preferencias");
		preferencesLbl.setForeground(Color.decode("#1B313F")); //color de letra
		preferencesLbl.setHorizontalAlignment(JLabel.LEFT); //centrar 
		preferencesLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto
		preferencesLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 5;
		registerPnl.add(preferencesLbl, c);
		
		JPanel preferencesPnl = new JPanel();
		preferencesPnl.setOpaque(false);
		preferencesPnl.setLayout(new GridLayout(1, 3));
		
		JCheckBox dulceChckBx = new JCheckBox("Dulce");
		dulceChckBx.setOpaque(false); //tiene fondo o no
		dulceChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		dulceChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		preferencesPnl.add(dulceChckBx);
		
		JCheckBox saladoChckBx = new JCheckBox("Salado");
		saladoChckBx.setOpaque(false); //tiene fondo o no
		saladoChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		saladoChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		preferencesPnl.add(saladoChckBx);
		
		JCheckBox saludableChckBx = new JCheckBox("Saludable");
		saludableChckBx.setOpaque(false); //tiene fondo o no
		saludableChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		saludableChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		preferencesPnl.add(saludableChckBx);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 6;
		registerPnl.add(preferencesPnl, c);
		
		
		//términos y condiciones
		JLabel terminosLbl= new JLabel("Términos"); 
		terminosLbl.setForeground(Color.decode("#1B313F")); //color de letra
		terminosLbl.setHorizontalAlignment(JLabel.LEFT); //centrar 
		terminosLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto 
		terminosLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 7;
		registerPnl.add(terminosLbl, c);
		
		JPanel termsPnl = new JPanel();
		termsPnl.setOpaque(false);
		termsPnl.setLayout(new GridLayout(1, 2));
		
		//grupo de botones que permite seleccionar uno a la vez
		ButtonGroup terminosBttnGrp = new ButtonGroup();
		
		JRadioButton aceptoRBttn = new JRadioButton("Acepto términos");
		aceptoRBttn.setOpaque(false); //tiene fondo o no
		aceptoRBttn.setForeground(Color.decode("#1B313F")); //color de letra
		aceptoRBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		termsPnl.add(aceptoRBttn);
		
		JRadioButton noAceptoRBttn = new JRadioButton("No acepto términos");

		noAceptoRBttn.setOpaque(false); //tiene fondo o no
		noAceptoRBttn.setForeground(Color.decode("#1B313F")); //color de letra
		noAceptoRBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		termsPnl.add(noAceptoRBttn);
		
		terminosBttnGrp.add(aceptoRBttn); // al estar agrupados solo se puede escoger un Radio Button
		terminosBttnGrp.add(noAceptoRBttn);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 8;
		registerPnl.add(termsPnl, c);
		
		
		//lista de colonias
		JComboBox<String> coloniasCmbBx = new JComboBox<>(colonias);
		coloniasCmbBx.setBackground(Color.white); 
		coloniasCmbBx.setForeground(Color.decode("#1B313F")); //color de letra
		coloniasCmbBx.setFont(new Font("Tahoma", Font.BOLD, 15));//fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 9;
		registerPnl.add(coloniasCmbBx, c);
		
		
		//botón para crear cuenta
		JButton crearBttn = new JButton("Crear Cuenta");
		crearBttn.setBackground(Color.decode("#1B313F"));
		crearBttn.setForeground(Color.white); //color de letra
		crearBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		crearBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		crearBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		crearBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		crearBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 40, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 10;
		
		registerPnl.add(crearBttn, c);
		
		crearBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//contador de campos completados
				int counter = 0;

				//usuario vacío
				if(userTxtFld.getText().equals("")) {
					userTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					userTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
					
				
				//contraseña vacía
				if(bioTxt.getText().equals("")) {
					bioTxt.setBorder(BorderFactory.createDashedBorder(Color.red, 16, 10));
					counter = 0;
				}else {
					bioTxt.setBorder(BorderFactory.createDashedBorder(Color.green, 16, 10));
					counter++;
				}
				
				
				//términos no seleccionados
				if(!aceptoRBttn.isSelected() && !noAceptoRBttn.isSelected()) {
					aceptoRBttn.setForeground(Color.red);
					noAceptoRBttn.setForeground(Color.red);
					counter = 0;
				}else {
					aceptoRBttn.setForeground(Color.decode("#1B313F")); //seleccionado por lo menos uno
					noAceptoRBttn.setForeground(Color.decode("#1B313F"));
					counter++;
				}
				
				
				//preferencias no seleccionadas
				if(!dulceChckBx.isSelected() && !saladoChckBx.isSelected() && !saludableChckBx.isSelected()) {
					dulceChckBx.setForeground(Color.red);
					saladoChckBx.setForeground(Color.red);
					saludableChckBx.setForeground(Color.red);
					counter = 0;
				}else {
					dulceChckBx.setForeground(Color.decode("#1B313F")); //seleccionada por lo menos una
					saladoChckBx.setForeground(Color.decode("#1B313F"));
					saludableChckBx.setForeground(Color.decode("#1B313F"));
					counter++;
				}
					
				
				//solo si todos los campos han sido completados se abrirá la ventana de login
				if(counter==4) {
					String message = "Hola, bienvenido";
					JOptionPane.showMessageDialog(null, message, "Cuenta creada", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
					windowManager("login");
				}else { 
					//existe al menos un campo vacío
					String message = "Uno o más campos obligatorios se encuentran vacíos."; 
					JOptionPane.showMessageDialog(null, message, "Campos vacíos", JOptionPane.WARNING_MESSAGE); //ventana emergente
				}
				
			}
			
		});

		return generalPnl2; //añadir panel al marco (JFrame)
		
	}
	
	
	public void windowManager(String targetWindow){
		this.getContentPane().removeAll();
		
		if(targetWindow.equals("signIn")){
			this.add(this.signIn());
		}
		if(targetWindow.equals("login")){
			this.add(this.login());
		}
		
		this.repaint();
		this.revalidate();
	}
}
