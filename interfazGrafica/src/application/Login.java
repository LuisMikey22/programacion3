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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Login extends JFrame{
	
	private static final long serialVersionUID = 3848116500155893383L;

	String colonias[] = {"Camino Real", "Bellavista", "Progreso", "Pedregal", "Calafia", "Diana Laura",
			 "El Mezquitito", "Indeco", "La Fuente", "Las Américas", "Miramar"};
	
	String razones[] = {"No me gustó la aplicación", "No uso la aplicación", "Encontré otra aplicación",
						"La aplicación es dificil de usar", "Otra"};
	
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
	
	Image image;
	ImageIcon imageIcon;
	
	
	public Login(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		imageIcon = new ImageIcon(getClass().getResource("vortexIcon.png"));
		this.setIconImage(imageIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1000, 850); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(1000, 850));
		//this.setMaximumSize(new Dimension(1100, 950));
		this.setResizable(isMaximumSizeSet());

		this.add(this.login(), BorderLayout.CENTER);
		
		JMenuBar barra = new JMenuBar(); //barra de menus
		barra.setBackground(Color.decode("#1B313F"));
		barra.setBorder(null);
		
		
		image = new ImageIcon(getClass().getResource("infoIcon.png")).getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JMenu menu1 = new JMenu("Cuenta");
		menu1.setIcon(imageIcon);
		menu1.setForeground(Color.white);
		
		JMenu menu2 = new JMenu("Usuarios");
		menu2.setIcon(imageIcon);
		menu2.setForeground(Color.white);
		
		JMenu menu3 = new JMenu("Ayuda");
		menu3.setIcon(imageIcon);
		menu3.setForeground(Color.white);
		
		
		//primer menú
		JMenuItem login = new JMenuItem("Login");
		JMenuItem signin = new JMenuItem("Registro");
		JMenuItem recoverAccnt = new JMenuItem("Recuperación de cuenta");
		menu1.add(login);
		menu1.add(signin);
		menu1.add(recoverAccnt);
		
		//segundo menú
		JMenuItem newUser = new JMenuItem("Alta");
		JMenuItem deleteUser = new JMenuItem("Baja");
		JMenuItem consultUser = new JMenuItem("Consultar");
		menu2.add(newUser);
		menu2.add(deleteUser);
		menu2.add(consultUser);
		
		//tercer menú
		JMenuItem howToCreateUser = new JMenuItem("¿Cómo crear un usuario?");
		JMenuItem howToAccess = new JMenuItem("¿Cómo acceder al sistema?");
		JMenuItem forgotPssWrd = new JMenuItem("¿Qué pasa si olvidé mi contraseña?");
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
		
		signin.addActionListener(new ActionListener() {

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
		
		newUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("newUser");
			}
			
		});
		
		deleteUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("deleteUser");
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
		
		//agregar panel con los elementos interactivos para iniciar sesión al panel general
		JPanel loginPnl = new JPanel(); 
		loginPnl.setSize(500, 600); 
		loginPnl.setLocation(250, 100);
		loginPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		loginPnl.setBackground(Color.decode("#1B313F"));
		loginPnl.setOpaque(true);
		loginPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		loginBckGrndPnl.add(loginPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		imageIcon  = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		loginBckGrndPnl.add(backgroundLbl);
		
		
		//elementos del loginPnl
		//cabecera
		image = new ImageIcon(getClass().getResource("vortexIcon.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel header = new JLabel(imageIcon);
		header.setOpaque(false);
		header.setHorizontalAlignment(JLabel.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		loginPnl.add(header, c); 
		
		JLabel loginLbl = new JLabel("Iniciar sesión");
		loginLbl.setForeground(Color.white); //color de letra
		loginLbl.setOpaque(false); //tiene fondo o no
		loginLbl.setHorizontalAlignment(JLabel.CENTER); //posición del elemento
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER); //posición del texto
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		loginPnl.add(loginLbl, c); 
		
		
		//elementos de usuario
		JPanel userElementsPnl = new JPanel();
		userElementsPnl.setOpaque(false);
		userElementsPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel userEmailLbl = new JLabel("Correo electrónico");
		userEmailLbl.setForeground(Color.white); //color de letra
		userEmailLbl.setOpaque(false); //tiene fondo o no
		userEmailLbl.setHorizontalAlignment(JLabel.LEFT);
		userEmailLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		userElementsPnl.add(userEmailLbl, BorderLayout.NORTH);
		
		image = new ImageIcon(getClass().getResource("userIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon  = new ImageIcon(image);
		JLabel userIcon = new JLabel(imageIcon);
		userIcon.setOpaque(false); //tiene fondo o no
		userIcon.setHorizontalAlignment(JLabel.LEFT);
		userElementsPnl.add(userIcon, BorderLayout.WEST);
		
		JTextField userEmailTxtFld = new JTextField();
		userEmailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		userEmailTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userEmailTxtFld.setOpaque(true); //tiene fondo o no
		userEmailTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userEmailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		userElementsPnl.add(userEmailTxtFld, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 2; //posición
		loginPnl.add(userElementsPnl, c);
		
		
		//elementos de contraseña
		JPanel passwordElementsPnl = new JPanel();
		passwordElementsPnl.setOpaque(false);
		passwordElementsPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setForeground(Color.white); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordElementsPnl.add(passwordLbL, BorderLayout.NORTH);
		
		image = new ImageIcon(getClass().getResource("lockIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon  = new ImageIcon(image);
		JLabel lockIcon = new JLabel(imageIcon);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		passwordElementsPnl.add(lockIcon, BorderLayout.WEST);
		
		
		//panel con el campo para escribir la contraseña y el botón para mostrarla u ocultarla
		JPanel jPssWrdFldPnl = new JPanel();
		jPssWrdFldPnl.setBackground(Color.WHITE);
		//borde para crear la ilusión de que el campo de texto y el botón con icono de ojo son uno mismo
		jPssWrdFldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		jPssWrdFldPnl.setLayout(new BorderLayout());
		
		JPasswordField passwordFld = new JPasswordField(5);
		passwordFld.setEchoChar('*');
		passwordFld.setBorder(null); //quitar borde por defecto
		passwordFld.setForeground(Color.decode("#1B313F")); //color de letra
		passwordFld.setOpaque(true); //tiene fondo o no
		passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
		jPssWrdFldPnl.add(passwordFld, BorderLayout.CENTER);
		
		image = new ImageIcon(getClass().getResource("eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
		imageIcon  = new ImageIcon(image);
		JButton seeBttn = new JButton();
		seeBttn.setIcon(imageIcon);
		seeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		seeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		seeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		jPssWrdFldPnl.add(seeBttn, BorderLayout.EAST);
		
		//botón para mostrar u ocultar la contraseña
		seeBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//mostrar contraseña
				if(!passwordVisible) {
					passwordFld.setEchoChar((char)0); //representar los caracteres de la contraseña con letras 'ABCdario'	
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(getClass().getResource("eyeSeesIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = true;
				}else {
					//ocultar contraseña
					passwordFld.setEchoChar('*'); //representar los caracteres de la contraseña con asteriscos '*'				
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(getClass().getResource("eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = false;
				}
				
			}
			
		});
		
		passwordElementsPnl.add(jPssWrdFldPnl, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 3; //posición
		loginPnl.add(passwordElementsPnl, c);
		
		
		//botones
		JPanel extraOptionsPnl = new JPanel();
		extraOptionsPnl.setOpaque(false);
		extraOptionsPnl.setLayout(new GridLayout(1, 2, 0, 0));
		
		JCheckBox rememberUserChkBx = new JCheckBox("Recordar nombre");
		rememberUserChkBx.setOpaque(false); //tiene fondo o no
		rememberUserChkBx.setForeground(Color.decode("#BFE4FF")); //color de letra
		rememberUserChkBx.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		rememberUserChkBx.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		rememberUserChkBx.setFont(new Font("Kefe", Font.BOLD, 12)); //fuente, tipo y tamaño
		extraOptionsPnl.add(rememberUserChkBx);
		
		JButton forgotPssWrdBttn = new JButton("¿Olvidó su contraseña?");
		forgotPssWrdBttn.setBorder(null);
		forgotPssWrdBttn.setForeground(Color.decode("#BFE4FF")); //color de letra
		forgotPssWrdBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		forgotPssWrdBttn.setContentAreaFilled(false);
		forgotPssWrdBttn.setHorizontalAlignment(SwingConstants.RIGHT); // centrar texto del botón
		forgotPssWrdBttn.setFont(new Font("Kefe", Font.BOLD, 12)); //fuente, tipo y tamaño
		extraOptionsPnl.add(forgotPssWrdBttn);
		
		forgotPssWrdBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("forgotPssWrd");
			}
			
		});
		
		//subrayar el texto y cambiar el color del texto a azul cuando el ratón está encima del botón
		forgotPssWrdBttn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				forgotPssWrdBttn.setText("<HTML><u>¿Olvidó su contraseña?</u></HTML>");
		    }

		    public void mouseExited(MouseEvent evt) {
		    	forgotPssWrdBttn.setText("¿Olvidó su contraseña?");
		    }
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 4; //posición
		loginPnl.add(extraOptionsPnl, c);
		
		
		//botones
		//botón 1
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 2, 20, 10));
		
		JButton cuentaBttn = new JButton("Crear cuenta");
		cuentaBttn.setBackground(Color.decode("#33627F"));
		cuentaBttn.setForeground(Color.white); //color de letra
		cuentaBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		cuentaBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		cuentaBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		cuentaBttn.setFont(new Font("Tahoma", Font.BOLD, 20)); //fuente, tipo y tamaño
		actionBttnsPnl.add(cuentaBttn);
		
		//abrir ventana de registro
		cuentaBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("signIn");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		cuentaBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	cuentaBttn.setBackground(Color.decode("#5488A8"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	cuentaBttn.setBackground(Color.decode("#33627F"));
		    }
		});
		
		//botón2
		JButton ingresarBttn = new JButton("Ingresar");;
		ingresarBttn.setBackground(Color.decode("#238600"));
		ingresarBttn.setForeground(Color.white); //color de letra
		ingresarBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		ingresarBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		ingresarBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		ingresarBttn.setFont(new Font("Tahoma", Font.BOLD, 20)); //fuente, tipo y tamaño
		actionBttnsPnl.add(ingresarBttn);
		
		//evento para validar si todos los campos han sido completados
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
					jPssWrdFldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				}else { 
					jPssWrdFldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completada
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
							jPssWrdFldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						
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
		
		//crear efecto Hover cuando el ratón está encima del botón
		ingresarBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	ingresarBttn.setBackground(Color.decode("#2FB200"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	ingresarBttn.setBackground(Color.decode("#238600"));
		    }
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 5; //posición
		c.ipady = 20;
		loginPnl.add(actionBttnsPnl, c);


		return loginBckGrndPnl; //añadir panel al marco (JFrame)
		
	}
	

	//panel de registro
	public JPanel signin() {
		JPanel signinBckGrndPnl = new JPanel();
		signinBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		signinBckGrndPnl.setSize(1000, 850);
		signinBckGrndPnl.setLocation(0, 0);
		
		JPanel registerPnl = new JPanel(); 
		registerPnl.setSize(500, 600);
		registerPnl.setLocation(250, 100);
		registerPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		registerPnl.setBackground(Color.decode("#1B313F"));
		registerPnl.setOpaque(true); //tiene fondo o no
		registerPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		signinBckGrndPnl.add(registerPnl, BorderLayout.CENTER);
	
		//imagen de fondo
		imageIcon = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		signinBckGrndPnl.add(backgroundLbl);
		
		
		//elementos del signinPnl
		JLabel registroLbl = new JLabel("Registro");
		registroLbl.setForeground(Color.white); //color de letra
		registroLbl.setOpaque(false); //tiene fondo o no
		registroLbl.setHorizontalAlignment(JLabel.CENTER);
		registroLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		registerPnl.add(registroLbl, c);
		
		//nombre usuario
		JLabel emailLbl = new JLabel("Correo electrónico:");
		emailLbl.setForeground(Color.white); //color de letra
		emailLbl.setOpaque(false); //tiene fondo o no
		emailLbl.setHorizontalAlignment(JLabel.LEFT);
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(30, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		registerPnl.add(emailLbl, c);
		
		JTextField emailTxtFld = new JTextField();
		emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F")));
		emailTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		emailTxtFld.setOpaque(true); //tiene fondo o no
		emailTxtFld.setHorizontalAlignment(JLabel.LEFT);
		emailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		registerPnl.add(emailTxtFld, c);
		
		
		//biografía
		JLabel bioLbL = new JLabel("Biografía:");
		bioLbL.setForeground(Color.white); //color de letra
		bioLbL.setOpaque(false); //tiene fondo o no
		bioLbL.setHorizontalAlignment(JLabel.LEFT);
		bioLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		registerPnl.add(bioLbL, c);
		
		JTextArea bioTxtArea = new JTextArea(10, 30);
		bioTxtArea.setLineWrap(true); //cacer que el texto se coloque en renglones
		bioTxtArea.setWrapStyleWord(true); //ajusta las palabras para que no se corten
		bioTxtArea.setForeground(Color.white); //color de letra
		bioTxtArea.setForeground(Color.decode("#1B313F")); //color de letra
		bioTxtArea.setOpaque(true); //tiene fondo o no
		bioTxtArea.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		bioTxtArea.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F")));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 40;
		registerPnl.add(new JScrollPane(bioTxtArea), c);
		
		
		c.ipady = 0; //reiniciar valor
		
		
		//preferencias
		JLabel preferencesLbl = new JLabel("Preferencias");
		preferencesLbl.setForeground(Color.white); //color de letra
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
		dulceChckBx.setForeground(Color.decode("#BFE4FF")); //color de letra
		dulceChckBx.setFont(new Font("Kefe", Font.BOLD, 13)); //fuente, tipo y tamaño
		preferencesPnl.add(dulceChckBx);
		
		JCheckBox saladoChckBx = new JCheckBox("Salado");
		saladoChckBx.setOpaque(false); //tiene fondo o no
		saladoChckBx.setForeground(Color.decode("#BFE4FF")); //color de letra
		saladoChckBx.setFont(new Font("Kefe", Font.BOLD, 13)); //fuente, tipo y tamaño
		preferencesPnl.add(saladoChckBx);
		
		JCheckBox saludableChckBx = new JCheckBox("Saludable");
		saludableChckBx.setOpaque(false); //tiene fondo o no
		saludableChckBx.setForeground(Color.decode("#BFE4FF")); //color de letra
		saludableChckBx.setFont(new Font("Kefe", Font.BOLD, 13)); //fuente, tipo y tamaño
		preferencesPnl.add(saludableChckBx);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 6;
		registerPnl.add(preferencesPnl, c);
		
		
		//términos y condiciones
		JLabel terminosLbl = new JLabel("Términos"); 
		terminosLbl.setForeground(Color.white); //color de letra
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
		aceptoRBttn.setForeground(Color.decode("#BFE4FF")); //color de letra
		aceptoRBttn.setFont(new Font("Kefe", Font.BOLD, 12)); //fuente, tipo y tamaño
		termsPnl.add(aceptoRBttn);
		
		JRadioButton noAceptoRBttn = new JRadioButton("No acepto términos");

		noAceptoRBttn.setOpaque(false); //tiene fondo o no
		noAceptoRBttn.setForeground(Color.decode("#BFE4FF")); //color de letra
		noAceptoRBttn.setFont(new Font("Kefe", Font.BOLD, 12)); //fuente, tipo y tamaño
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
		
		
		//panel de botones 
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 2, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageIcon  = new ImageIcon(image);
		JButton returnHomeBttn = new JButton("Regresar");
		returnHomeBttn.setIcon(imageIcon);
		returnHomeBttn.setForeground(Color.white);
		returnHomeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		returnHomeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		returnHomeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		returnHomeBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		actionBttnsPnl.add(returnHomeBttn);
		
		//volver a login
		returnHomeBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon  = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.white);
		    }
		});
		
		
		//botón para crear cuenta
		JButton continueBttn = new JButton("Continuar");
		continueBttn.setBackground(Color.decode("#238600"));
		continueBttn.setForeground(Color.white); //color de letra
		continueBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		continueBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		continueBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		continueBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		continueBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		actionBttnsPnl.add(continueBttn);
		
		continueBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//contador de campos completados
				int counter = 0;

				//usuario vacío
				if(emailTxtFld.getText().equals("")) {
					emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
					
				
				//contraseña vacía
				if(bioTxtArea.getText().equals("")) {
					bioTxtArea.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					bioTxtArea.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
				
				
				//términos no seleccionados
				if(!aceptoRBttn.isSelected() && !noAceptoRBttn.isSelected()) {
					aceptoRBttn.setForeground(Color.red);
					noAceptoRBttn.setForeground(Color.red);
					counter = 0;
				}else {
					aceptoRBttn.setForeground(Color.decode("#BFE4FF")); //seleccionado por lo menos uno
					noAceptoRBttn.setForeground(Color.decode("#BFE4FF"));
					counter++;
				}
				
				
				//preferencias no seleccionadas
				if(!dulceChckBx.isSelected() && !saladoChckBx.isSelected() && !saludableChckBx.isSelected()) {
					dulceChckBx.setForeground(Color.red);
					saladoChckBx.setForeground(Color.red);
					saludableChckBx.setForeground(Color.red);
					counter = 0;
				}else {
					dulceChckBx.setForeground(Color.decode("#BFE4FF")); //seleccionada por lo menos una
					saladoChckBx.setForeground(Color.decode("#BFE4FF"));
					saludableChckBx.setForeground(Color.decode("#BFE4FF"));
					counter++;
				}
					
				
				//solo si todos los campos han sido completados se abrirá la ventana de login
				if(counter==4) {
					windowManager("newUser");
				}else { 
					//existe al menos un campo vacío
					String message = "Uno o más campos obligatorios se encuentran vacíos."; 
					JOptionPane.showMessageDialog(null, message, "Campos vacíos", JOptionPane.WARNING_MESSAGE); //ventana emergente
				}
				
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		continueBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	continueBttn.setBackground(Color.decode("#2FB200"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	continueBttn.setBackground(Color.decode("#238600"));
		    }
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 40, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 10;
		c.ipady = 20;
		registerPnl.add(actionBttnsPnl, c);
		
		
		return signinBckGrndPnl; //añadir panel al marco (JFrame)
		
	}
	
	
	//panel para la recuperación de una cuenta
	public JPanel recoverAccnt() {
		JPanel recoverAccntBckGrndPnl = new JPanel();
		recoverAccntBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		recoverAccntBckGrndPnl.setSize(1000, 850);
		recoverAccntBckGrndPnl.setLocation(0, 0);
		recoverAccntBckGrndPnl.setOpaque(true);
		
		//agregar panel con los elementos interactivos para la recuperación de una cuenta
		JPanel recoverAccntPnl = new JPanel(); 
		recoverAccntPnl.setSize(600, 600); 
		recoverAccntPnl.setLocation(200, 100);
		recoverAccntPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		recoverAccntPnl.setBackground(Color.decode("#1B313F"));
		recoverAccntPnl.setOpaque(true);
		recoverAccntPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		recoverAccntBckGrndPnl.add(recoverAccntPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		imageIcon = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		recoverAccntBckGrndPnl.add(backgroundLbl);
		
		JLabel recoverAccntLbl = new JLabel("Recuperar cuenta");
		recoverAccntLbl.setForeground(Color.white); //color de letra
		recoverAccntLbl.setOpaque(false); //tiene fondo o no
		recoverAccntLbl.setHorizontalAlignment(JLabel.CENTER);
		recoverAccntLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 40, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		recoverAccntPnl.add(recoverAccntLbl, c);
				
		
		JLabel emailLbl = new JLabel("Correo electrónico:");
		emailLbl.setOpaque(false);
		emailLbl.setHorizontalAlignment(SwingConstants.LEFT);
		emailLbl.setForeground(Color.white);
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		recoverAccntPnl.add(emailLbl, c);
		
	
		JTextField emailTxtFld = new JTextField();
		emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		emailTxtFld.setHorizontalAlignment(JLabel.LEFT);
		emailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.insets = new Insets(5, 0, 20, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		recoverAccntPnl.add(emailTxtFld, c);
		
		
		//como recuperar cuenta con un correo
		String info = "<html> Si olvidó su nombre de usuario y/o contraseña <br>"
				           + "solicite un correo de activación/recuperación. <br><br>"
				           + "En caso de que la dirección de correo electrónico <br>"
				           + "proporcionada coincida con registros existentes, <br>"
			               + "recibirá un correo con la información solicitada.";
		
		JLabel createUserInfoLbl = new JLabel(info);
		createUserInfoLbl.setForeground(Color.white); //color de letra
		createUserInfoLbl.setOpaque(false); //tiene fondo o no
		createUserInfoLbl.setHorizontalAlignment(JLabel.CENTER);
		createUserInfoLbl.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 20, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		recoverAccntPnl.add(createUserInfoLbl, c);
		
		
		//panel de botones
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 2, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageIcon  = new ImageIcon(image);
		JButton returnHomeBttn = new JButton("Regresar");
		returnHomeBttn.setIcon(imageIcon);
		returnHomeBttn.setForeground(Color.white);
		returnHomeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		returnHomeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		returnHomeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		returnHomeBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		actionBttnsPnl.add(returnHomeBttn);
		
		//volver a login
		returnHomeBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.white);
		    }
		});
		
		//botón continuar
		JButton continueBttn = new JButton("Continuar");
		continueBttn.setBackground(Color.decode("#238600"));
		continueBttn.setForeground(Color.white);
		continueBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		continueBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		continueBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		continueBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		continueBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		actionBttnsPnl.add(continueBttn);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 20;
		recoverAccntPnl.add(actionBttnsPnl, c);
		

		return recoverAccntBckGrndPnl;
	}
	
	
	//panel para crear una cuenta
	public JPanel newUser() {
		JPanel newUserBckGrndPnl = new JPanel();
		newUserBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		newUserBckGrndPnl.setSize(1000, 850);
		newUserBckGrndPnl.setLocation(0, 0);
		newUserBckGrndPnl.setOpaque(true);
		
		//agregar panel con los elementos interactivos para crear una cuenta
		JPanel newUserPnl = new JPanel(); 
		newUserPnl.setSize(500, 600); 
		newUserPnl.setLocation(250, 100);
		newUserPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		newUserPnl.setBackground(Color.decode("#1B313F"));
		newUserPnl.setOpaque(true);
		newUserPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		newUserBckGrndPnl.add(newUserPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		imageIcon = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		newUserBckGrndPnl.add(backgroundLbl);
		
		JLabel newUserLbl = new JLabel("Alta de usuario");
		newUserLbl.setForeground(Color.white); //color de letra
		newUserLbl.setOpaque(false); //tiene fondo o no
		newUserLbl.setHorizontalAlignment(JLabel.CENTER);
		newUserLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 40, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		newUserPnl.add(newUserLbl, c);
		
		
		JLabel userNameLbl = new JLabel("Nombre de usuario:");
		userNameLbl.setOpaque(false);
		userNameLbl.setHorizontalAlignment(SwingConstants.LEFT);
		userNameLbl.setForeground(Color.white);
		userNameLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		newUserPnl.add(userNameLbl, c);
		
		//campo de usuario
		JTextField userNameTxtFld = new JTextField();
		userNameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		userNameTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userNameTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.insets = new Insets(5, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		newUserPnl.add(userNameTxtFld, c);
		
		
		//foto de perfil
		JLabel photoLbl = new JLabel("Foto:");
		photoLbl.setOpaque(false);
		photoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		photoLbl.setForeground(Color.white);
		photoLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		newUserPnl.add(photoLbl, c);
		
		image = new ImageIcon(getClass().getResource("baldProfilePicture.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel userPhotoImgLbl = new JLabel(imageIcon);
		userPhotoImgLbl.setHorizontalAlignment(JLabel.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(15, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 4;
		newUserPnl.add(userPhotoImgLbl, c);
		
		//boton para subir archivo JPG, PNG, etc.
		JButton examinateBttn = new JButton("Examinar");
		examinateBttn.setBackground(Color.white);
		examinateBttn.setForeground(Color.decode("#1B313F"));
		examinateBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		examinateBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		examinateBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		examinateBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		examinateBttn.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(15, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 5;
		c.ipady = 10;
		newUserPnl.add(examinateBttn, c);
		
		
		c.ipady = 0;
		
		
		//panel de botones
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 2, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton returnHomeBttn = new JButton("Regresar");
		returnHomeBttn.setIcon(imageIcon);
		returnHomeBttn.setForeground(Color.white);
		returnHomeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		returnHomeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		returnHomeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		returnHomeBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		actionBttnsPnl.add(returnHomeBttn);
		
		//volver a login
		returnHomeBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.white);
		    }
		});
			
		//botón continuar
		JButton createUserBttn = new JButton("Crear cuenta");
		createUserBttn.setBackground(Color.decode("#238600"));
		createUserBttn.setForeground(Color.white);
		createUserBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		createUserBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		createUserBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		createUserBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		createUserBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		actionBttnsPnl.add(createUserBttn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		createUserBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	createUserBttn.setBackground(Color.decode("#2FB200"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	createUserBttn.setBackground(Color.decode("#238600"));
		    }
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 6;
		c.ipady = 20;
		newUserPnl.add(actionBttnsPnl, c);
		
		
		return newUserBckGrndPnl;
	}
	
	
	//panel para eliminar una cuenta
	public JPanel deleteUser() {
		JPanel deleteUserBckGrndPnl = new JPanel();
		deleteUserBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		deleteUserBckGrndPnl.setSize(1000, 850);
		deleteUserBckGrndPnl.setLocation(0, 0);
		deleteUserBckGrndPnl.setOpaque(true);
		
		//agregar panel con los elementos interactivos para eliminar una cuenta
		JPanel deleteUserPnl = new JPanel(); 
		deleteUserPnl.setSize(500, 600); 
		deleteUserPnl.setLocation(250, 100);
		deleteUserPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		deleteUserPnl.setBackground(Color.decode("#1B313F"));
		deleteUserPnl.setOpaque(true);
		deleteUserPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		deleteUserBckGrndPnl.add(deleteUserPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		imageIcon = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		deleteUserBckGrndPnl.add(backgroundLbl);
		
		JLabel deleteUserLbl = new JLabel("Baja de usuario");
		deleteUserLbl.setForeground(Color.white); //color de letra
		deleteUserLbl.setOpaque(false); //tiene fondo o no
		deleteUserLbl.setHorizontalAlignment(JLabel.CENTER);
		deleteUserLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 20, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		deleteUserPnl.add(deleteUserLbl, c);
		
		
		//elementos de usuario
		JPanel userElementsPnl = new JPanel();
		userElementsPnl.setOpaque(false);
		userElementsPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel userEmailLbl = new JLabel("Correo electrónico");
		userEmailLbl.setForeground(Color.white); //color de letra
		userEmailLbl.setOpaque(false); //tiene fondo o no
		userEmailLbl.setHorizontalAlignment(JLabel.LEFT);
		userEmailLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		userElementsPnl.add(userEmailLbl, BorderLayout.NORTH);
		
		image = new ImageIcon(getClass().getResource("userIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel userIcon = new JLabel(imageIcon);
		userIcon.setOpaque(false); //tiene fondo o no
		userIcon.setHorizontalAlignment(JLabel.LEFT);
		userElementsPnl.add(userIcon, BorderLayout.WEST);
		
		JTextField userEmailTxtFld = new JTextField();
		userEmailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		userEmailTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userEmailTxtFld.setOpaque(true); //tiene fondo o no
		userEmailTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userEmailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		userElementsPnl.add(userEmailTxtFld, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 1; //posición
		deleteUserPnl.add(userElementsPnl, c);
		
		
		//elementos de contraseña
		JPanel passwordElementsPnl = new JPanel();
		passwordElementsPnl.setOpaque(false);
		passwordElementsPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setForeground(Color.white); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordElementsPnl.add(passwordLbL, BorderLayout.NORTH);
		
		image = new ImageIcon(getClass().getResource("lockIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel lockIcon = new JLabel(imageIcon);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		passwordElementsPnl.add(lockIcon, BorderLayout.WEST);
		
		
		//panel con el campo para escribir la contraseña y el botón para mostrarla u ocultarla
		JPanel jPssWrdFldPnl = new JPanel();
		jPssWrdFldPnl.setBackground(Color.WHITE);
		//borde para crear la ilusión de que el campo de texto y el botón con icono de ojo son uno mismo
		jPssWrdFldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		jPssWrdFldPnl.setLayout(new BorderLayout());
		
		JPasswordField passwordFld = new JPasswordField(5);
		passwordFld.setEchoChar('*');
		passwordFld.setBorder(null); //quitar borde por defecto
		passwordFld.setForeground(Color.decode("#1B313F")); //color de letra
		passwordFld.setOpaque(true); //tiene fondo o no
		passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
		jPssWrdFldPnl.add(passwordFld, BorderLayout.CENTER);
		
		image = new ImageIcon(getClass().getResource("eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton seeBttn = new JButton();
		seeBttn.setIcon(imageIcon);
		seeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		seeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		seeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		jPssWrdFldPnl.add(seeBttn, BorderLayout.EAST);
		
		//botón para mostrar u ocultar la contraseña
		seeBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//mostrar contraseña
				if(!passwordVisible) {
					passwordFld.setEchoChar((char)0); //representar los caracteres de la contraseña con letras 'ABCdario'	
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(getClass().getResource("eyeSeesIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = true;
				}else {
					//ocultar contraseña
					passwordFld.setEchoChar('*'); //representar los caracteres de la contraseña con asteriscos '*'				
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(getClass().getResource("eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = false;
				}
				
			}
			
		});
		
		passwordElementsPnl.add(jPssWrdFldPnl, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 2; //posición
		deleteUserPnl.add(passwordElementsPnl, c);
		
		
		//razones de eliminar la cuenta
		JComboBox<String> reasonsCmbBx = new JComboBox<>(razones);
		reasonsCmbBx.setBackground(Color.white); 
		reasonsCmbBx.setForeground(Color.decode("#1B313F")); //color de letra
		reasonsCmbBx.setFont(new Font("Tahoma", Font.BOLD, 15));//fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 20, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		deleteUserPnl.add(reasonsCmbBx, c);
		
		
		//panel de botones
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 2, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton returnHomeBttn = new JButton("Regresar");
		returnHomeBttn.setIcon(imageIcon);
		returnHomeBttn.setForeground(Color.white);
		returnHomeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		returnHomeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		returnHomeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		returnHomeBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		actionBttnsPnl.add(returnHomeBttn);
		
		//volver a login
		returnHomeBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		    	imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.white);
		    }
		});
		
		
		//botón borrar
		JButton deleteBttn = new JButton("Borrar cuenta");
		deleteBttn.setBackground(Color.decode("#F0243C"));
		deleteBttn.setForeground(Color.decode("#1B313F"));
		deleteBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		deleteBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		deleteBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		deleteBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		deleteBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		actionBttnsPnl.add(deleteBttn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		deleteBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	deleteBttn.setBackground(Color.decode("#f06071"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	deleteBttn.setBackground(Color.decode("#F0243C"));
		    }
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 20, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 10;
		deleteUserPnl.add(actionBttnsPnl, c);
		
		
		return deleteUserBckGrndPnl;
	}
	
	
	//panel de información de usuarios
 	public JPanel consultUser() {
		JPanel consultUserBckGrndPnl = new JPanel(); 
		consultUserBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		consultUserBckGrndPnl.setSize(1000, 850);
		consultUserBckGrndPnl.setLocation(0, 0);
		consultUserBckGrndPnl.setOpaque(true);
		
		//agregar panel con los elementos interactivos de ayuda para crear un usuario
		JPanel consultUserPnl = new JPanel(); 
		consultUserPnl.setSize(800, 600); 
		consultUserPnl.setLocation(100, 100);
		consultUserPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		consultUserPnl.setBackground(Color.decode("#1B313F"));
		consultUserPnl.setOpaque(true);
		consultUserPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		consultUserBckGrndPnl.add(consultUserPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		imageIcon = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		consultUserBckGrndPnl.add(backgroundLbl);
		
		//cabecera
		JLabel userLbl = new JLabel("Usuarios");
		userLbl.setForeground(Color.white); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.CENTER);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		consultUserPnl.add(userLbl, c);
		
		
		//panel de barra de navegación
		JPanel navPnl = new JPanel();
		navPnl.setLayout(new GridLayout(1, 2));
		navPnl.setOpaque(false);
		
		JPanel navUserPnl = new JPanel(); //subpanel de barra de navegación
		navUserPnl.setLayout(new GridLayout(1, 2));
		navUserPnl.setOpaque(false);
		
		JLabel totalUsers = new JLabel("Total de usuarios: ");
		totalUsers.setOpaque(false); //tiene fondo o no
		totalUsers.setForeground(Color.white);
		totalUsers.setFont(new Font("Tahoma", Font.BOLD, 18));
		totalUsers.setHorizontalAlignment(JLabel.LEFT);
		navUserPnl.add(totalUsers);
		
		JLabel usersWdgt = new JLabel("100");
		usersWdgt.setOpaque(false); //tiene fondo o no
		usersWdgt.setForeground(Color.white);
		usersWdgt.setFont(new Font("Tahoma", Font.BOLD, 16));
		usersWdgt.setHorizontalAlignment(JLabel.LEFT);
		navUserPnl.add(usersWdgt);
		
		navPnl.add(navUserPnl);
		
		
		JPanel navButtonsPnl = new JPanel(); //subpanel de barra de navegación
		navButtonsPnl.setLayout(new GridLayout(1, 2, 10, 0));
		navButtonsPnl.setOpaque(false);
		
		JButton exportBttn = new JButton("Exportar");
		exportBttn.setBackground(Color.decode("#DE7728"));
		exportBttn.setForeground(Color.white); //color de letra
		exportBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		exportBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		exportBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		exportBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		exportBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		navButtonsPnl.add(exportBttn);
		
		JButton addBttn = new JButton("Añadir");
		addBttn.setBackground(Color.decode("#238600"));
		addBttn.setForeground(Color.white); //color de letra
		addBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		addBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		addBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		addBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		addBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		navButtonsPnl.add(addBttn);
		
		navPnl.add(navButtonsPnl);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(60, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		consultUserPnl.add(navPnl, c);
		
		
		//tabla
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(60, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 80;
		consultUserPnl.add(scrollPane, c);
		
		//reiniciar valor
		c.ipady = 0;
		
		//botón para regresar al inicio
		image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton returnHomeBttn = new JButton("Regresar");
		returnHomeBttn.setIcon(imageIcon);
		returnHomeBttn.setForeground(Color.white);
		returnHomeBttn.setBackground(Color.decode("#1B313F"));
		returnHomeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		returnHomeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		//returnHomeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		returnHomeBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 10;
		consultUserPnl.add(returnHomeBttn, c);
		
		//volver a login
		returnHomeBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	Image imageReturn = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				ImageIcon imageReturnIcon = new ImageIcon(imageReturn);
				returnHomeBttn.setIcon(imageReturnIcon);
		    	returnHomeBttn.setForeground(Color.white);
		    }
		});
		
		
		return consultUserBckGrndPnl;
	}
	
	
 	//panel de ayuda para crear un usuario
	public JPanel howToCreateUser() {
		JPanel howToCreateUserBckGrndPnl = new JPanel();
		howToCreateUserBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		howToCreateUserBckGrndPnl.setSize(1000, 850);
		howToCreateUserBckGrndPnl.setLocation(0, 0);
		howToCreateUserBckGrndPnl.setOpaque(true);
		
		//agregar panel con los elementos interactivos de ayuda para crear un usuario
		JPanel howToCreateUserPnl = new JPanel(); 
		howToCreateUserPnl.setSize(700, 600); 
		howToCreateUserPnl.setLocation(150, 100);
		howToCreateUserPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		howToCreateUserPnl.setBackground(Color.decode("#1B313F"));
		howToCreateUserPnl.setOpaque(true);
		howToCreateUserPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		howToCreateUserBckGrndPnl.add(howToCreateUserPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		imageIcon = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		howToCreateUserBckGrndPnl.add(backgroundLbl);
		
		JLabel createUserLbl = new JLabel("Creación de un usuario");
		createUserLbl.setForeground(Color.white); //color de letra
		createUserLbl.setOpaque(false); //tiene fondo o no
		createUserLbl.setHorizontalAlignment(JLabel.CENTER);
		createUserLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 40, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		howToCreateUserPnl.add(createUserLbl, c);
		
		
		//como crear un usuario
		String info = "<html> 1.- Pique el botón de color azul de Crear Cuenta <br>"
						   + "2.- Complete todos los campos obligatorios <br>"
						   + "3.- Pique el botón de Continuar <br>"
						   + "4.- Seleccione un nombre de usuario <br>"
						   + "5.- Seleccione una foto de perfil <br>"
						   + "6.- Pique el botón de Crear cuenta <br>"
						   + "<html>";
		
		JLabel createUserInfoLbl = new JLabel(info);
		createUserInfoLbl.setForeground(Color.white); //color de letra
		createUserInfoLbl.setOpaque(false); //tiene fondo o no
		createUserInfoLbl.setHorizontalAlignment(JLabel.CENTER);
		createUserInfoLbl.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 20, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		howToCreateUserPnl.add(createUserInfoLbl, c);
		
		
		//panel de botones
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 3, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton returnHomeBttn = new JButton("Regresar");
		returnHomeBttn.setIcon(imageIcon);
		returnHomeBttn.setForeground(Color.white);
		returnHomeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		returnHomeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		returnHomeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		returnHomeBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		actionBttnsPnl.add(returnHomeBttn);
		
		//volver a login
		returnHomeBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		    	imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.white);
		    }
		});
	
		
		//botón continuar
		JButton continueBttn = new JButton("Continuar");
		continueBttn.setBackground(Color.decode("#238600"));
		continueBttn.setForeground(Color.white);
		continueBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		continueBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		continueBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		continueBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		continueBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		actionBttnsPnl.add(continueBttn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		continueBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	continueBttn.setBackground(Color.decode("#2FB200"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	continueBttn.setBackground(Color.decode("#238600"));
		    }
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(30, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 10;
		howToCreateUserPnl.add(actionBttnsPnl, c);
	
		
		return howToCreateUserBckGrndPnl;
	}
	
	
	//panel de ayuda para acceder al sistema
	public JPanel howToAccess() {
		JPanel howToAccessBckGrndPnl = new JPanel();
		howToAccessBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		howToAccessBckGrndPnl.setSize(1000, 850);
		howToAccessBckGrndPnl.setLocation(0, 0);
		howToAccessBckGrndPnl.setOpaque(true);
		
		//agregar panel con los elementos interactivos para ayudar a acceder al sistema
		JPanel howToAccessPnl = new JPanel(); 
		howToAccessPnl.setSize(700, 600); 
		howToAccessPnl.setLocation(150, 100);
		howToAccessPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		howToAccessPnl.setBackground(Color.decode("#1B313F"));
		howToAccessPnl.setOpaque(true);
		howToAccessPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		howToAccessBckGrndPnl.add(howToAccessPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		imageIcon = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		howToAccessBckGrndPnl.add(backgroundLbl);
		
		JLabel accessSystemLbl = new JLabel("Acceder al sistema");
		accessSystemLbl.setForeground(Color.white); //color de letra
		accessSystemLbl.setOpaque(false); //tiene fondo o no
		accessSystemLbl.setHorizontalAlignment(JLabel.CENTER);
		accessSystemLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 40, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		howToAccessPnl.add(accessSystemLbl, c);
		
		
		//razones de eliminar la cuenta
		String info = "<html> 1.- Coloque el correo electrónico con el que creó la cuenta <br>"
						   + "2.- Coloque la contraseña de la cuenta de forma correcta <br>"
						   + "3.- Pique el botón de Ingresar <br>"
						   + "<html>";
		
		JLabel accessSystemInfoLbl = new JLabel(info);
		accessSystemInfoLbl.setForeground(Color.white); //color de letra
		accessSystemInfoLbl.setOpaque(false); //tiene fondo o no
		accessSystemInfoLbl.setHorizontalAlignment(JLabel.CENTER);
		accessSystemInfoLbl.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 20, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		howToAccessPnl.add(accessSystemInfoLbl, c);
		
		
		//panel de botones
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 3, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton returnHomeBttn = new JButton("Regresar");
		returnHomeBttn.setIcon(imageIcon);
		returnHomeBttn.setForeground(Color.white);
		returnHomeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		returnHomeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		returnHomeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		returnHomeBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		actionBttnsPnl.add(returnHomeBttn);
		
		//volver a login
		returnHomeBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		    	imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.white);
		    }
		});
	
		
		//botón continuar
		JButton continueBttn = new JButton("Continuar");
		continueBttn.setBackground(Color.decode("#238600"));
		continueBttn.setForeground(Color.white);
		continueBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		continueBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		continueBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		continueBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		continueBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		actionBttnsPnl.add(continueBttn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		continueBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	continueBttn.setBackground(Color.decode("#2FB200"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	continueBttn.setBackground(Color.decode("#238600"));
		    }
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(30, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 10;
		howToAccessPnl.add(actionBttnsPnl, c);
		
		return howToAccessBckGrndPnl;
	}
 	
	
	//panel de ayuda para crear un usuario
	public JPanel forgotPssWrd() {
		JPanel forgotPssWrdBckGrndPnl = new JPanel();
		forgotPssWrdBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		forgotPssWrdBckGrndPnl.setSize(1000, 850);
		forgotPssWrdBckGrndPnl.setLocation(0, 0);
		forgotPssWrdBckGrndPnl.setOpaque(true);
		
		//agregar panel con los elementos interactivos para ayudar a acceder al sistema
		JPanel forgotPssWrdPnl = new JPanel(); 
		forgotPssWrdPnl.setSize(700, 600); 
		forgotPssWrdPnl.setLocation(150, 100);
		forgotPssWrdPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		forgotPssWrdPnl.setBackground(Color.decode("#1B313F"));
		forgotPssWrdPnl.setOpaque(true);
		forgotPssWrdPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		forgotPssWrdBckGrndPnl.add(forgotPssWrdPnl, BorderLayout.CENTER);
		
		//imagen de fondo
		imageIcon = new ImageIcon(getClass().getResource("windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		forgotPssWrdBckGrndPnl.add(backgroundLbl);
		
		JLabel forgotPssWrdLbl = new JLabel("Olvidé mi contraseña");
		forgotPssWrdLbl.setForeground(Color.white); //color de letra
		forgotPssWrdLbl.setOpaque(false); //tiene fondo o no
		forgotPssWrdLbl.setHorizontalAlignment(JLabel.CENTER);
		forgotPssWrdLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 40, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		forgotPssWrdPnl.add(forgotPssWrdLbl, c);
		
		
		//nueva contraseña
		//elementos de contraseña
		JPanel passwordElementsPnl = new JPanel();
		passwordElementsPnl.setOpaque(false);
		passwordElementsPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setForeground(Color.white); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordElementsPnl.add(passwordLbL, BorderLayout.NORTH);
		
		image = new ImageIcon(getClass().getResource("lockIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel lockIcon = new JLabel(imageIcon);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		passwordElementsPnl.add(lockIcon, BorderLayout.WEST);
		
		
		//panel con el campo para escribir la contraseña y el botón para mostrarla u ocultarla
		JPanel jPssWrdFldPnl = new JPanel();
		jPssWrdFldPnl.setBackground(Color.WHITE);
		//borde para crear la ilusión de que el campo de texto y el botón con icono de ojo son uno mismo
		jPssWrdFldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		jPssWrdFldPnl.setLayout(new BorderLayout());
		
		JPasswordField passwordFld = new JPasswordField(5);
		passwordFld.setEchoChar('*');
		passwordFld.setBorder(null); //quitar borde por defecto
		passwordFld.setForeground(Color.decode("#1B313F")); //color de letra
		passwordFld.setOpaque(true); //tiene fondo o no
		passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
		jPssWrdFldPnl.add(passwordFld, BorderLayout.CENTER);
		
		image = new ImageIcon(getClass().getResource("eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton seeBttn = new JButton();
		seeBttn.setIcon(imageIcon);
		seeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		seeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		seeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		jPssWrdFldPnl.add(seeBttn, BorderLayout.EAST);
		
		//botón para mostrar u ocultar la contraseña
		seeBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//mostrar contraseña
				if(!passwordVisible) {
					passwordFld.setEchoChar((char)0); //representar los caracteres de la contraseña con letras 'ABCdario'	
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(getClass().getResource("eyeSeesIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = true;
				}else {
					//ocultar contraseña
					passwordFld.setEchoChar('*'); //representar los caracteres de la contraseña con asteriscos '*'				
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(getClass().getResource("eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = false;
				}
				
			}
			
		});
		
		passwordElementsPnl.add(jPssWrdFldPnl, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 1; //posición
		forgotPssWrdPnl.add(passwordElementsPnl, c);
		
		
		//CONFIRMACIÓN DE CONTRASEÑA
		//elementos de contraseña
		JPanel passwordElementsPnl2 = new JPanel();
		passwordElementsPnl2.setOpaque(false);
		passwordElementsPnl2.setLayout(new BorderLayout(10, 5));
		
		JLabel passwordLbL2 = new JLabel("Contraseña");
		passwordLbL2.setForeground(Color.white); //color de letra
		passwordLbL2.setOpaque(false); //tiene fondo o no
		passwordLbL2.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL2.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordElementsPnl2.add(passwordLbL2, BorderLayout.NORTH);
		
		image = new ImageIcon(getClass().getResource("lockIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel lockIcon2 = new JLabel(imageIcon);
		lockIcon2.setOpaque(false); //tiene fondo o no
		lockIcon2.setHorizontalAlignment(JLabel.LEFT);
		passwordElementsPnl2.add(lockIcon2, BorderLayout.WEST);
		
		
		//panel con el campo para escribir la contraseña y el botón para mostrarla u ocultarla
		JPanel jPssWrdFldPnl2 = new JPanel();
		jPssWrdFldPnl2.setBackground(Color.WHITE);
		//borde para crear la ilusión de que el campo de texto y el botón con icono de ojo son uno mismo
		jPssWrdFldPnl2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		jPssWrdFldPnl2.setLayout(new BorderLayout());
		
		JPasswordField passwordFld2 = new JPasswordField(5);
		passwordFld2.setEchoChar('*');
		passwordFld2.setBorder(null); //quitar borde por defecto
		passwordFld2.setForeground(Color.decode("#1B313F")); //color de letra
		passwordFld2.setOpaque(true); //tiene fondo o no
		passwordFld2.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
		jPssWrdFldPnl2.add(passwordFld2, BorderLayout.CENTER);
		
		image = new ImageIcon(getClass().getResource("eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton seeBttn2 = new JButton();
		seeBttn2.setIcon(imageIcon);
		seeBttn2.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		seeBttn2.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		seeBttn2.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		jPssWrdFldPnl2.add(seeBttn2, BorderLayout.EAST);
		
		//botón para mostrar u ocultar la contraseña
		seeBttn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//mostrar contraseña
				if(!passwordVisible) {
					passwordFld2.setEchoChar((char)0); //representar los caracteres de la contraseña con letras 'ABCdario'	
					passwordFld2.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(getClass().getResource("eyeSeesIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn2.setIcon(imageIcon);
					passwordVisible = true;
				}else {
					//ocultar contraseña
					passwordFld2.setEchoChar('*'); //representar los caracteres de la contraseña con asteriscos '*'				
					passwordFld2.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(getClass().getResource("eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn2.setIcon(imageIcon);
					passwordVisible = false;
				}
				
			}
			
		});
		
		passwordElementsPnl2.add(jPssWrdFldPnl2, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 2; //posición
		forgotPssWrdPnl.add(passwordElementsPnl2, c);
		
		
		//panel de botones
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 3, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton returnHomeBttn = new JButton("Regresar");
		returnHomeBttn.setIcon(imageIcon);
		returnHomeBttn.setForeground(Color.white);
		returnHomeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		returnHomeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		returnHomeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		returnHomeBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		actionBttnsPnl.add(returnHomeBttn);
		
		//volver a login
		returnHomeBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windowManager("login");
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(getClass().getResource("returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	Image imageReturn = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				ImageIcon imageReturnIcon = new ImageIcon(imageReturn);
				returnHomeBttn.setIcon(imageReturnIcon);
		    	returnHomeBttn.setForeground(Color.white);
		    }
		});
	
		
		//botón continuar
		JButton continueBttn = new JButton("Continuar");
		continueBttn.setBackground(Color.decode("#238600"));
		continueBttn.setForeground(Color.white);
		continueBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		continueBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		continueBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		continueBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		continueBttn.setFont(new Font("Tahoma", Font.BOLD, 22)); //fuente, tipo y tamaño
		actionBttnsPnl.add(continueBttn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		continueBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	continueBttn.setBackground(Color.decode("#2FB200"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	continueBttn.setBackground(Color.decode("#238600"));
		    }
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(30, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 10;
		forgotPssWrdPnl.add(actionBttnsPnl, c);
		
		
		return forgotPssWrdBckGrndPnl;
	}
	
	
	//manejador de ventanas
	public void windowManager(String targetWindow){
		this.getContentPane().removeAll();
		
		if(targetWindow.equals("login")){ //login
			this.add(this.login());
		}
		else if(targetWindow.equals("signIn")){ //registro
			this.add(this.signin());
		}
		else if (targetWindow.equals("recoverAccnt")){ //recuperar cuenta
			this.add(this.recoverAccnt());
		}
		else if (targetWindow.equals("newUser")){ //crear cuenta
			this.add(this.newUser());
		}
		else if (targetWindow.equals("deleteUser")){ //borrar cuenta
			this.add(this.deleteUser());
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
