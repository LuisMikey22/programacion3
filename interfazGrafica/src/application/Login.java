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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Login extends JFrame{
	
	String colonias[] = {"Camino Real", "Bellavista", "Progreso", "Pedregal", "Calafia", "Diana Laura",
			 "El Mezquitito", "Indeco", "La Fuente", "Las Américas", "Miramar"};
	
	String[] columnNames = {"ID", "Nombre", "Correo electrónico", "Edad", "Estado"};
	
	Object[][] data = {{"10001", "Adriana", "pelosDeRata123@gmail.com", 20, false},
			 		   {"10002", "Bertha", "caguamasA5pesos@gmail.com", 31, true},
			 		   {"10003", "Carlos", "ilovemoviesOMG@gmail.com", 28, false},
			 		   {"10004", "David", "odioProgramar@gmail.com",27, true},
			 		   {"10005", "Eduardo", "karaoke234@gmail.com", 44, false},
			 		   {"10006", "Fátima", "siTeacuerdasDEmi783@gmail.com", 25, false},
			 		   {"10007", "Gerardo", "jjajaJAjaj2_hola@gmail.com", 33, true},
			 		   {"10008", "Hectór", "elefantesrosas34@gmail.com", 55, false},
			 		   {"10009", "Isabella", "JAJAJeJEJIJIJUJU43@gmail.com", 23, true},
			 		   {"100010", "Jonathan", "elSOLmeQueMA29@gmail.com", 49, false},
			 		   {"100011", "Saúl", "lAnostalgiaMEsIGUE_UnU@gmail.com", 36, true},
			 		   {"100012", "Jessica", "piedrasENELARROLLO_23@gmail.com", 52, false}};
	
	private String contraseña = "amatista1234";
	private String correoUsuario = "llucatero_23@alu.uabcs.mx";
	private boolean passwordVisible = false;
	
	//cabecera
	ImageIcon imageHdr;
	JLabel header;
	ImageIcon windowBackground;
	JLabel backgroundLbl;
	
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
		
		JMenuBar barra = new JMenuBar(); //barra de munus
		
		JMenu menu1 = new JMenu("Cuenta");
		JMenu menu2 = new JMenu("Usuarios");
		JMenu menu3 = new JMenu("Ayuda");
		
		//primer menú
		JMenuItem login = new JMenuItem("Login");
		JMenuItem signIn= new JMenuItem("Registro");
		JMenuItem recoverAccnt= new JMenuItem("Recuperación de cuenta");
		menu1.add(login);
		menu1.add(signIn);
		menu1.add(recoverAccnt);
		
		//segundo menú
		JMenuItem newAccnt = new JMenuItem("Alta");
		JMenuItem deleteAccnt = new JMenuItem("Baja");
		JMenuItem consultUser = new JMenuItem("Consultar");
		menu2.add(newAccnt);
		menu2.add(deleteAccnt);
		menu2.add(consultUser);
		
		//tercer menú
		JMenuItem howToCreateUser = new JMenuItem("¿Cómo crear un usuario?");
		JMenuItem howToAccess= new JMenuItem("¿Cómo acceder al sistema?");
		JMenuItem forgotPssWrd= new JMenuItem("¿Qué pasa si olvidé mi contraseña?");
		menu3.add(howToCreateUser);
		menu3.add(howToAccess);
		menu3.add(forgotPssWrd);
		
		//agregar los menús a la barra de navegación
		barra.add(menu1);
		barra.add(menu2);
		barra.add(menu3);

		
		//agregar acción a los menus de ventana
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		signIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("signIn");
			}
			
		});
		
		recoverAccnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("recoverAccnt");
			}
			
		});
		
		newAccnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("newAccnt");
			}
			
		});
		
		deleteAccnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("deleteAccnt");
			}
			
		});;
		
		consultUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("consultUser");
			}
			
		});
		
		howToCreateUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("howToCreateUser");
			}
			
		});
		
		howToAccess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("howToAccess");
			}
			
		});
		
		forgotPssWrd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("forgotPssWrd");
			}
			
		});
		
		
		this.setJMenuBar(barra);
	
		
		this.validate();
		this.revalidate();
		this.repaint();
	}
	
	
	//panel para iniciar sesión
	public JPanel login() {
		JPanel loginBckGrndPnl = new JPanel();
		loginBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		loginBckGrndPnl.setSize(1000, 850);
		loginBckGrndPnl.setLocation(0, 0);
		loginBckGrndPnl.setOpaque(true);
		
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
		loginBckGrndPnl.add(loginPnl, BorderLayout.CENTER);
		
		
		//imagen de fondo
		windowBackground = new ImageIcon("windowBackground.png");
		backgroundLbl = new JLabel(windowBackground); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		loginBckGrndPnl.add(backgroundLbl);
		
		
		//elementos del loginPnl
		//cabecera
		imageHdr = new ImageIcon("vortexLogoText.png");
		header = new JLabel(imageHdr);
		header.setBackground(Color.decode("#1B313F"));
		header.setOpaque(true); //tiene fondo o no
		header.setHorizontalAlignment(JLabel.CENTER);
		loginBckGrndPnl.add(header, BorderLayout.NORTH); 
		
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
		passwordFld.setEchoChar('*');
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

		return loginBckGrndPnl; //añadir panel al marco (JFrame)
		
	}
	

	//panel de registro
	public JPanel signIn() {
		JPanel signInBckGrndPnl = new JPanel();
		signInBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		signInBckGrndPnl.setSize(1000, 850);
		signInBckGrndPnl.setLocation(0, 0);
		signInBckGrndPnl.setOpaque(true);
		
		JPanel registerPnl = new JPanel(); 
		registerPnl.setSize(500, 600);
		registerPnl.setLocation(250, 105);
		registerPnl.setBorder(new LineBorder(Color.decode("#1B313F"), 15)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		registerPnl.setBackground(Color.decode("#BFE4FF"));
		registerPnl.setOpaque(true); //tiene fondo o no
		registerPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		signInBckGrndPnl.add(registerPnl);
	
		//imagen de fondo
		windowBackground = new ImageIcon("windowBackground.png");
		backgroundLbl = new JLabel(windowBackground); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		signInBckGrndPnl.add(backgroundLbl);
		
				
		//elementos del registerPnl
		//cabecera
		imageHdr = new ImageIcon("vortexLogoText.png");
		header = new JLabel(imageHdr);
		header.setBackground(Color.decode("#1B313F"));
		header.setOpaque(true); //tiene fondo o no
		header.setHorizontalAlignment(JLabel.CENTER);
		signInBckGrndPnl.add(header, BorderLayout.NORTH); 
	
		
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

		return signInBckGrndPnl; //añadir panel al marco (JFrame)
		
	}
	
	
	//panel para la recuperación de una cuenta
	public JPanel recoverAccnt() {
		JPanel recoverAccntBckGrndPnl = new JPanel();
		recoverAccntBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		recoverAccntBckGrndPnl.setSize(1000, 850);
		recoverAccntBckGrndPnl.setLocation(0, 0);
		recoverAccntBckGrndPnl.setOpaque(true);
		
		JLabel recoverAccntLbl = new JLabel("Recuperar cuenta");
		recoverAccntLbl.setForeground(Color.decode("#1B313F")); //color de letra
		recoverAccntLbl.setOpaque(false); //tiene fondo o no
		recoverAccntLbl.setHorizontalAlignment(JLabel.CENTER);
		recoverAccntLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		recoverAccntBckGrndPnl.add(recoverAccntLbl, BorderLayout.NORTH);
		
		return recoverAccntBckGrndPnl;
	}
	
	//panel para crear una cuenta
	public JPanel newAccnt() {
		JPanel newUserBckGrndPnl = new JPanel();
		newUserBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		newUserBckGrndPnl.setSize(1000, 850);
		newUserBckGrndPnl.setLocation(0, 0);
		newUserBckGrndPnl.setOpaque(true);
		
		JLabel newAccntLbl = new JLabel("Alta de usuario");
		newAccntLbl.setForeground(Color.decode("#1B313F")); //color de letra
		newAccntLbl.setOpaque(false); //tiene fondo o no
		newAccntLbl.setHorizontalAlignment(JLabel.CENTER);
		newAccntLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		newUserBckGrndPnl.add(newAccntLbl, BorderLayout.NORTH);
		
		return newUserBckGrndPnl;
	}
	
	//panel para eliminar una cuenta
	public JPanel deleteAccnt() {
		JPanel deleteAccntBckGrndPnl = new JPanel();
		deleteAccntBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		deleteAccntBckGrndPnl.setSize(1000, 850);
		deleteAccntBckGrndPnl.setLocation(0, 0);
		deleteAccntBckGrndPnl.setOpaque(true);
		
		JLabel deleteAccntLbl = new JLabel("Baja de usuario");
		deleteAccntLbl.setForeground(Color.decode("#1B313F")); //color de letra
		deleteAccntLbl.setOpaque(false); //tiene fondo o no
		deleteAccntLbl.setHorizontalAlignment(JLabel.CENTER);
		deleteAccntLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		deleteAccntBckGrndPnl.add(deleteAccntLbl, BorderLayout.NORTH);
		
		return deleteAccntBckGrndPnl;
	}
	
	
	//panel de información de usuarios
 	public JPanel consultUser() {
		JPanel consultUserBckGrndPnl = new JPanel(); 
		consultUserBckGrndPnl.setSize(1000, 600);
		consultUserBckGrndPnl.setLocation(0, 0);
		consultUserBckGrndPnl.setBackground(Color.decode("#BFE4FF"));
		consultUserBckGrndPnl.setOpaque(true);
		
		JLabel userLbl = new JLabel("Usuarios");
		userLbl.setSize(130, 40);
		userLbl.setLocation(435, 32);
		userLbl.setForeground(Color.white); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.CENTER);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		this.add(userLbl);
		
		JLabel header = new JLabel();
		header.setSize(1000, 84);
		header.setLocation(0, 0);
		header.setOpaque(true); //tiene fondo o no
		header.setBackground(Color.decode("#1B313F"));
		header.setHorizontalAlignment(JLabel.LEFT);
		this.add(header);
		
		JLabel totalUsers = new JLabel("Total de usuarios: ");
		totalUsers.setSize(160, 44);
		totalUsers.setLocation(70, 140);
		totalUsers.setOpaque(false); //tiene fondo o no
		totalUsers.setForeground(Color.white);
		totalUsers.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalUsers.setHorizontalAlignment(JLabel.LEFT);
		this.add(totalUsers);
		
		JLabel usersWdgt = new JLabel();
		usersWdgt.setSize(190, 64);
		usersWdgt.setLocation(50, 130);
		usersWdgt.setOpaque(true); //tiene fondo o no
		usersWdgt.setBackground(Color.decode("#33627F"));
		usersWdgt.setHorizontalAlignment(JLabel.LEFT);
		this.add(usersWdgt);
		
		JButton exportBttn = new JButton("Exportar");
		exportBttn.setSize(140, 50);
		exportBttn.setLocation(630, 150);
		exportBttn.setBackground(Color.decode("#1B313F"));
		exportBttn.setForeground(Color.white); //color de letra
		exportBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		exportBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		exportBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		exportBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		exportBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(exportBttn);
		
		JButton addBttn = new JButton("Añadir");
		addBttn.setSize(140, 50);
		addBttn.setLocation(790, 150);
		addBttn.setBackground(Color.decode("#1B313F"));
		addBttn.setForeground(Color.white); //color de letra
		addBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		addBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		addBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		addBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		addBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(addBttn);
		
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(880, 200);
		scrollPane.setLocation(50, 250);
		this.add(scrollPane);
		
		return consultUserBckGrndPnl;
	}
	
	
 	//panel de ayuda para crear un usuario
	public JPanel howToCreateUser() {
		JPanel howToCreateUserBckGrndPnl = new JPanel();
		howToCreateUserBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		howToCreateUserBckGrndPnl.setSize(1000, 850);
		howToCreateUserBckGrndPnl.setLocation(0, 0);
		howToCreateUserBckGrndPnl.setOpaque(true);
		
		JLabel createUserQLbl = new JLabel("¿Cómo crear un usuario?");
		createUserQLbl.setForeground(Color.decode("#1B313F")); //color de letra
		createUserQLbl.setOpaque(false); //tiene fondo o no
		createUserQLbl.setHorizontalAlignment(JLabel.CENTER);
		createUserQLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		howToCreateUserBckGrndPnl.add(createUserQLbl, BorderLayout.NORTH);
		
		return howToCreateUserBckGrndPnl;
	}
	
	
	//panel de ayuda para acceder al sistema
	public JPanel howToAccess() {
		JPanel howToAccessBckGrndPnl = new JPanel();
		howToAccessBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		howToAccessBckGrndPnl.setSize(1000, 850);
		howToAccessBckGrndPnl.setLocation(0, 0);
		howToAccessBckGrndPnl.setOpaque(true);
		
		JLabel accessSystemQLbl = new JLabel("¿Cómo acceder al sistema?");
		accessSystemQLbl.setForeground(Color.decode("#1B313F")); //color de letra
		accessSystemQLbl.setOpaque(false); //tiene fondo o no
		accessSystemQLbl.setHorizontalAlignment(JLabel.CENTER);
		accessSystemQLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		howToAccessBckGrndPnl.add(accessSystemQLbl, BorderLayout.NORTH);
		
		return howToAccessBckGrndPnl;
	}
 	
	
	//panel de ayuda para crear un usuario
	public JPanel forgotPssWrd() {
		JPanel forgotPssWrdBckGrndPnl = new JPanel();
		forgotPssWrdBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		forgotPssWrdBckGrndPnl.setSize(1000, 850);
		forgotPssWrdBckGrndPnl.setLocation(0, 0);
		forgotPssWrdBckGrndPnl.setOpaque(true);
		
		JLabel forgotPsswrdQLbl = new JLabel("Olvidé mi contraseña");
		forgotPsswrdQLbl.setForeground(Color.decode("#1B313F")); //color de letra
		forgotPsswrdQLbl.setOpaque(false); //tiene fondo o no
		forgotPsswrdQLbl.setHorizontalAlignment(JLabel.CENTER);
		forgotPsswrdQLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		forgotPssWrdBckGrndPnl.add(forgotPsswrdQLbl, BorderLayout.NORTH);
		
		return forgotPssWrdBckGrndPnl;
	}
	
	
	//manejador de ventanas
	public void windowManager(String targetWindow){
		this.getContentPane().removeAll();
		
		if(targetWindow.equals("login")){ //login
			this.add(this.login());
		}
		else if(targetWindow.equals("signIn")){ //registro
			this.add(this.signIn());
		}
		else if (targetWindow.equals("recoverAccnt")){ //recuperar cuenta
			this.add(this.recoverAccnt());
		}
		else if (targetWindow.equals("newAccnt")){ //crear cuenta
			this.add(this.newAccnt());
		}
		else if (targetWindow.equals("deleteAccnt")){ //borrar cuenta
			this.add(this.deleteAccnt());
		}
		else if (targetWindow.equals("consultUser")){ //consultar usuario/s
			this.add(this.consultUser());
		}
		else if (targetWindow.equals("howToCreateUser")){ //¿cómo crear un usuario?
			this.add(this.howToCreateUser());
		}
		else if (targetWindow.equals("howToAccess")){ //¿cómo acceder al sistema?
			this.add(this.howToAccess());
		}
		else if (targetWindow.equals("forgotPssWrd")){ //olvidé mi contraseña
			this.add(this.forgotPssWrd());
		}
		
		this.repaint();
		this.revalidate();
	}
}
