package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import controllers.HomeController;
import models.AuthModel;

public class AuthView extends JFrame {

	private static final long serialVersionUID = 3677354243222270225L;
	
	private ImageIcon imageIcon;
	private Image image;
	private String username = "", userEmail = "", newPassword = "", confPassword = "", passTxt;
	private String name = "", surname = "", company = "", companyField = "", position = "";
	private boolean passwordVisible = false;
	private JFrame frame;
	private AuthModel functions;
	HomeController homeController;
	
	private String ambitos[] = {"Salud", "Comercio", "Tecnología", "Educación", "Otro"};
	
 	public AuthView() {
 		functions = new AuthModel(); //crear objeto de tipo AuthModel para realizar validaciones en métodos
 	}

	public void login() {
		frame = new JFrame();
 		frame.setTitle("Modelo MVC"); //crear JFrame y colocar título a la ventana
 		frame.setResizable(true); //redimensionar la ventana
		
		imageIcon = new ImageIcon(AuthView.class.getResource("/images/vortexIcon.png"));
		frame.setIconImage(imageIcon.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		frame.setSize(1000, 850); //colocar tamaño predeterminado
		frame.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		frame.setMinimumSize(new Dimension(1000, 850));
		frame.setResizable(true);
		
		JPanel loginBckGrndPnl = new JPanel();
		loginBckGrndPnl.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		loginBckGrndPnl.setSize(1000, 850);
		loginBckGrndPnl.setLocation(0, 0);
		frame.setContentPane(loginBckGrndPnl);
		
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
		imageIcon  = new ImageIcon(AuthView.class.getResource("/images/windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		loginBckGrndPnl.add(backgroundLbl);
		
		
		//elementos del loginPnl
		//cabecera
		image = new ImageIcon(AuthView.class.getResource("/images/vortexIcon.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
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
		
		image = new ImageIcon(AuthView.class.getResource("/images/userIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
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
		JPanel passwordPnl = new JPanel();
		passwordPnl.setOpaque(false);
		passwordPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setForeground(Color.white); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordPnl.add(passwordLbL, BorderLayout.NORTH);
		
		image = new ImageIcon(AuthView.class.getResource("/images/lockIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon  = new ImageIcon(image);
		JLabel lockIcon = new JLabel(imageIcon);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		passwordPnl.add(lockIcon, BorderLayout.WEST);
		
		
		//panel con el campo para escribir la contraseña y el botón para mostrarla u ocultarla
		JPanel fieldPnl = new JPanel();
		fieldPnl.setBackground(Color.WHITE);
		//borde para crear la ilusión de que el campo de texto y el botón con icono de ojo son uno mismo
		fieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		fieldPnl.setLayout(new BorderLayout());
		
		JPasswordField passwordFld = new JPasswordField(5);
		passwordFld.setEchoChar('*');
		passwordFld.setBorder(null); //quitar borde por defecto
		passwordFld.setForeground(Color.decode("#1B313F")); //color de letra
		passwordFld.setOpaque(true); //tiene fondo o no
		passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
		fieldPnl.add(passwordFld, BorderLayout.CENTER);
		
		image = new ImageIcon(AuthView.class.getResource("/images/eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
		imageIcon  = new ImageIcon(image);
		JButton seeBttn = new JButton();
		seeBttn.setIcon(imageIcon);
		seeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		seeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		seeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		fieldPnl.add(seeBttn, BorderLayout.EAST);
		
		//botón para mostrar u ocultar la contraseña
		seeBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//mostrar contraseña
				if(!passwordVisible) {
					passwordFld.setEchoChar((char)0); //representar los caracteres de la contraseña con letras 'ABCdario'	
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(AuthView.class.getResource("/images/eyeSeesIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = true;
				}else {
					//ocultar contraseña
					passwordFld.setEchoChar('*'); //representar los caracteres de la contraseña con asteriscos '*'				
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(AuthView.class.getResource("/images/eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = false;
				}
				
			}
			
		});
		
		passwordPnl.add(fieldPnl, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 3; //posición
		loginPnl.add(passwordPnl, c);
		
		
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
		
		/*forgotPssWrdBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				manejadorVentanas(0);
			}
			
		});*/
		
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
				windowManager(2);
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
					userEmail = userEmailTxtFld.getText();
					flag1 = true;
				}
				
				
				//contraseña vacía
				String passTxt = new String(passwordFld.getPassword());
				if(passTxt.equals("")) {
					fieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				}else { 
					fieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completada
					flag2 = true;
				}
				
				
				//validar si los dos campos han sido completados
				if(flag1 && flag2) {
					boolean userAuth = functions.access(userEmail,passTxt); 
					
					//cuando ambos campos coinciden con los datos de la cuenta del usuario
					if(userAuth) {
						String message = "Hola, bienvenido";
						JOptionPane.showMessageDialog(null, message, "Datos correctos", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
						frame.dispose();
						homeController = new HomeController();
						homeController.home();
					}
					else {
						//cuando alguno de los dos campos no es correcto
						userEmailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						fieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						
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

		frame.setVisible(true);
	}
	
	
	public void registerCompanyInfo() {
		frame = new JFrame();
 		frame.setTitle("Modelo MVC"); //crear JFrame y colocar título a la ventana
 		frame.setResizable(true); //redimensionar la ventana
		
		imageIcon = new ImageIcon(AuthView.class.getResource("/images/vortexIcon.png"));
		frame.setIconImage(imageIcon.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		frame.setSize(1000, 850); //colocar tamaño predeterminado
		frame.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		frame.setMinimumSize(new Dimension(1000, 850));
		frame.setResizable(true);
		
		JPanel registerPersonalInfo = new JPanel();
		registerPersonalInfo.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		registerPersonalInfo.setSize(1000, 850);
		registerPersonalInfo.setLocation(0, 0);
		frame.setContentPane(registerPersonalInfo);
		
		JPanel registerPnl = new JPanel(); 
		registerPnl.setSize(500, 600);
		registerPnl.setLocation(250, 100);
		registerPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		registerPnl.setBackground(Color.decode("#1B313F"));
		registerPnl.setOpaque(true); //tiene fondo o no
		registerPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		registerPersonalInfo.add(registerPnl, BorderLayout.CENTER);
	
		//imagen de fondo
		imageIcon = new ImageIcon(AuthView.class.getResource("/images/windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		registerPersonalInfo.add(backgroundLbl);
		
		
		//elementos del signinPnl
		JLabel registroLbl = new JLabel("Registro");
		registroLbl.setForeground(Color.white); //color de letra
		registroLbl.setOpaque(false); //tiene fondo o no
		registroLbl.setHorizontalAlignment(JLabel.CENTER);
		registroLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 30, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		registerPnl.add(registroLbl, c);
		
		
		//panel de nombre
		JPanel namePnl = new JPanel();
		namePnl.setOpaque(false);
		namePnl.setLayout(new GridLayout(2, 2, 10, 0));
		
		//nombre/s
		JLabel nameLbl = new JLabel("Nombre/s:");
		nameLbl.setForeground(Color.white); //color de letra
		nameLbl.setOpaque(false); //tiene fondo o no
		nameLbl.setHorizontalAlignment(JLabel.LEFT);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		namePnl.add(nameLbl);
		
		//apellido/s
		JLabel surnameLbl = new JLabel("Apellido/s:");
		surnameLbl.setForeground(Color.white); //color de letra
		surnameLbl.setOpaque(false); //tiene fondo o no
		surnameLbl.setHorizontalAlignment(JLabel.LEFT);
		surnameLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		namePnl.add(surnameLbl);
		
		JTextField nameTxtFld = new JTextField();
		nameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F")));
		nameTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		nameTxtFld.setOpaque(true); //tiene fondo o no
		nameTxtFld.setHorizontalAlignment(JLabel.LEFT);
		nameTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		namePnl.add(nameTxtFld);
		
		JTextField surnameTxtFld = new JTextField();
		surnameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F")));
		surnameTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		surnameTxtFld.setOpaque(true); //tiene fondo o no
		surnameTxtFld.setHorizontalAlignment(JLabel.LEFT);
		surnameTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		namePnl.add(surnameTxtFld);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 30, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		registerPnl.add(namePnl, c);
		
		
		//compañía
		JLabel companyLbl = new JLabel("Compañía:");
		companyLbl.setForeground(Color.white); //color de letra
		companyLbl.setOpaque(false); //tiene fondo o no
		companyLbl.setHorizontalAlignment(JLabel.LEFT);
		companyLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		registerPnl.add(companyLbl, c);
		
		JTextField companyTxtFld = new JTextField();
		companyTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F")));
		companyTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		companyTxtFld.setOpaque(true); //tiene fondo o no
		companyTxtFld.setHorizontalAlignment(JLabel.LEFT);
		companyTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 30, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		registerPnl.add(companyTxtFld, c);
		
		
		//ámbito de la empresaa
		JLabel companyFieldLbl = new JLabel("Ámbito:");
		companyFieldLbl.setForeground(Color.white); //color de letra
		companyFieldLbl.setOpaque(false); //tiene fondo o no
		companyFieldLbl.setHorizontalAlignment(JLabel.LEFT);
		companyFieldLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 4;
		registerPnl.add(companyFieldLbl, c);
				
		JComboBox<String> fieldsCmbBx = new JComboBox<>(ambitos);
		fieldsCmbBx.setBackground(Color.white); 
		fieldsCmbBx.setForeground(Color.decode("#1B313F")); //color de letra
		fieldsCmbBx.setFont(new Font("Tahoma", Font.BOLD, 15));//fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 30, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 5;
		registerPnl.add(fieldsCmbBx, c);
		
		
		//cargo
		JLabel positionLbl = new JLabel("Cargo:");
		positionLbl.setForeground(Color.white); //color de letra
		positionLbl.setOpaque(false); //tiene fondo o no
		positionLbl.setHorizontalAlignment(JLabel.LEFT);
		positionLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 6;
		registerPnl.add(positionLbl, c);
		
		JTextField positionTxtFld = new JTextField();
		positionTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F")));
		positionTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		positionTxtFld.setOpaque(true); //tiene fondo o no
		positionTxtFld.setHorizontalAlignment(JLabel.LEFT);
		positionTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 30, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 7;
		registerPnl.add(positionTxtFld, c);
		
		
		//panel de botones 
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 2, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(AuthView.class.getResource("/images/returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
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
				windowManager(1);
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(AuthView.class.getResource("/images/returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon  = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	image = new ImageIcon(AuthView.class.getResource("/images/returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
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

				//nombre vacío
				if(nameTxtFld.getText().equals("")) {
					nameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					name = nameTxtFld.getText();
					nameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
				
				//apellido vacío
				if(surnameTxtFld.getText().equals("")) {
					surnameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					surname = surnameTxtFld.getText();
					surnameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
				
				//compañía vacía
				if(companyTxtFld.getText().equals("")) {
					companyTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					company = companyTxtFld.getText();
					companyTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
				
				//cargo vacío
				if(positionTxtFld.getText().equals("")) {
					positionTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					position = positionTxtFld.getText();
					positionTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
				
				//validar si los campos han sido completados
				if(counter==4) {
					boolean companyInfo = functions.registerCompany(name, surname, company, position); 
					
					//cuando los campos coinciden son correctos en formato
					if(companyInfo) {
						companyField = fieldsCmbBx.getSelectedItem().toString();
						windowManager(3);
						String message = "Información registrada correctamente";
						JOptionPane.showMessageDialog(null, message, "Datos correctos", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
					}
					else {
						//cuando alguno de los dos campos no es correcto
						nameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						surnameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						companyTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						positionTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						name = ""; surname = ""; company = ""; position = ""; //reestablecer datos
						
						String message = "datos incorrectos. \n Por favor, inténtelo otra vez.";
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
		c.gridy = 8;
		c.ipady = 20;
		registerPnl.add(actionBttnsPnl, c);
		
		frame.setVisible(true);
	}
	
	
	public void registerUserInfo() {
		frame = new JFrame();
 		frame.setTitle("Modelo MVC"); //crear JFrame y colocar título a la ventana
 		frame.setResizable(true); //redimensionar la ventana
		
		imageIcon = new ImageIcon(AuthView.class.getResource("/images/vortexIcon.png"));
		frame.setIconImage(imageIcon.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		frame.setSize(1000, 850); //colocar tamaño predeterminado
		frame.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		frame.setMinimumSize(new Dimension(1000, 850));
		frame.setResizable(true);
		
		JPanel registerUserInfo = new JPanel();
		registerUserInfo.setLayout(new BorderLayout()); //colocar layout dentro del panel que cubre toda la pantalla
		registerUserInfo.setSize(1000, 850);
		registerUserInfo.setLocation(0, 0);
		frame.setContentPane(registerUserInfo);
		
		JPanel registerPnl = new JPanel(); 
		registerPnl.setSize(500, 600);
		registerPnl.setLocation(250, 100);
		registerPnl.setBorder(new LineBorder(Color.white, 2)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		registerPnl.setBackground(Color.decode("#1B313F"));
		registerPnl.setOpaque(true); //tiene fondo o no
		registerPnl.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		registerUserInfo.add(registerPnl, BorderLayout.CENTER);
	
		//imagen de fondo
		imageIcon = new ImageIcon(AuthView.class.getResource("/images/windowBackground.png"));
		JLabel backgroundLbl = new JLabel(imageIcon); 
		backgroundLbl.setSize(1000, 850);
		backgroundLbl.setLocation(0, 0);
		backgroundLbl.setOpaque(true);
		registerUserInfo.add(backgroundLbl);
		
		
		//elementos del signinPnl
		JLabel registroLbl = new JLabel("Registro");
		registroLbl.setForeground(Color.white); //color de letra
		registroLbl.setOpaque(false); //tiene fondo o no
		registroLbl.setHorizontalAlignment(JLabel.CENTER);
		registroLbl.setFont(new Font("Tahoma", Font.BOLD, 34)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 30, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		registerPnl.add(registroLbl, c);
		
		
		//nombre de usuario
		JLabel usernameLbl = new JLabel("Nombre de usuario:");
		usernameLbl.setForeground(Color.white); //color de letra
		usernameLbl.setOpaque(false); //tiene fondo o no
		usernameLbl.setHorizontalAlignment(JLabel.LEFT);
		usernameLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		registerPnl.add(usernameLbl, c);
		
		JTextField usernameTxtFld = new JTextField();
		usernameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F")));
		usernameTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		usernameTxtFld.setOpaque(true); //tiene fondo o no
		usernameTxtFld.setHorizontalAlignment(JLabel.LEFT);
		usernameTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 30, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		registerPnl.add(usernameTxtFld, c);
		
		
		//email
		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setForeground(Color.white); //color de letra
		emailLbl.setOpaque(false); //tiene fondo o no
		emailLbl.setHorizontalAlignment(JLabel.LEFT);
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		registerPnl.add(emailLbl, c);
		
		JTextField emailTxtFld = new JTextField();
		emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F")));
		emailTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		emailTxtFld.setOpaque(true); //tiene fondo o no
		emailTxtFld.setHorizontalAlignment(JLabel.LEFT);
		emailTxtFld.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 30, 0); //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 4;
		registerPnl.add(emailTxtFld, c);
		
		
		//CONTRASEÑA
		//elementos de contraseña
		JPanel passwordPnl = new JPanel();
		passwordPnl.setOpaque(false);
		passwordPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setForeground(Color.white); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordPnl.add(passwordLbL, BorderLayout.NORTH);
		
		image = new ImageIcon(AuthView.class.getResource("/images/lockIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel lockIcon = new JLabel(imageIcon);
		lockIcon.setOpaque(false); //tiene fondo o no
		lockIcon.setHorizontalAlignment(JLabel.LEFT);
		passwordPnl.add(lockIcon, BorderLayout.WEST);
		
		
		//panel con el campo para escribir la contraseña y el botón para mostrarla u ocultarla
		JPanel fieldPnl = new JPanel();
		fieldPnl.setBackground(Color.WHITE);
		//borde para crear la ilusión de que el campo de texto y el botón con icono de ojo son uno mismo
		fieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		fieldPnl.setLayout(new BorderLayout());
		
		JPasswordField passwordFld = new JPasswordField(5);
		passwordFld.setEchoChar('*');
		passwordFld.setBorder(null); //quitar borde por defecto
		passwordFld.setForeground(Color.decode("#1B313F")); //color de letra
		passwordFld.setOpaque(true); //tiene fondo o no
		passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
		fieldPnl.add(passwordFld, BorderLayout.CENTER);
		
		image = new ImageIcon(AuthView.class.getResource("/images/eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton seeBttn = new JButton();
		seeBttn.setIcon(imageIcon);
		seeBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		seeBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		seeBttn.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		fieldPnl.add(seeBttn, BorderLayout.EAST);
		
		//botón para mostrar u ocultar la contraseña
		seeBttn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//mostrar contraseña
				if(!passwordVisible) {
					passwordFld.setEchoChar((char)0); //representar los caracteres de la contraseña con letras 'ABCdario'	
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(AuthView.class.getResource("/images/eyeSeesIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = true;
				}else {
					//ocultar contraseña
					passwordFld.setEchoChar('*'); //representar los caracteres de la contraseña con asteriscos '*'				
					passwordFld.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(AuthView.class.getResource("/images/eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn.setIcon(imageIcon);
					passwordVisible = false;
				}
				
			}
			
		});
		
		passwordPnl.add(fieldPnl, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 5; //posición
		registerPnl.add(passwordPnl, c);
		
		
		//CONFIRMACIÓN DE CONTRASEÑA
		//elementos de contraseña
		JPanel passwordConfPnl = new JPanel();
		passwordConfPnl.setOpaque(false);
		passwordConfPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel confLbl = new JLabel("Contraseña");
		confLbl.setForeground(Color.white); //color de letra
		confLbl.setOpaque(false); //tiene fondo o no
		confLbl.setHorizontalAlignment(JLabel.LEFT);
		confLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordConfPnl.add(confLbl, BorderLayout.NORTH);
		
		image = new ImageIcon(AuthView.class.getResource("/images/lockIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel lockIcon2 = new JLabel(imageIcon);
		lockIcon2.setOpaque(false); //tiene fondo o no
		lockIcon2.setHorizontalAlignment(JLabel.LEFT);
		passwordConfPnl.add(lockIcon2, BorderLayout.WEST);
		
		
		//panel con el campo para escribir la contraseña y el botón para mostrarla u ocultarla
		JPanel confFieldPnl = new JPanel();
		confFieldPnl.setBackground(Color.WHITE);
		//borde para crear la ilusión de que el campo de texto y el botón con icono de ojo son uno mismo
		confFieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#33627F"))); 
		confFieldPnl.setLayout(new BorderLayout());
		
		JPasswordField passwordFld2 = new JPasswordField(5);
		passwordFld2.setEchoChar('*');
		passwordFld2.setBorder(null); //quitar borde por defecto
		passwordFld2.setForeground(Color.decode("#1B313F")); //color de letra
		passwordFld2.setOpaque(true); //tiene fondo o no
		passwordFld2.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
		confFieldPnl.add(passwordFld2, BorderLayout.CENTER);
		
		image = new ImageIcon(AuthView.class.getResource("/images/eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton seeBttn2 = new JButton();
		seeBttn2.setIcon(imageIcon);
		seeBttn2.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		seeBttn2.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		seeBttn2.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		confFieldPnl.add(seeBttn2, BorderLayout.EAST);
		
		//botón para mostrar u ocultar la contraseña
		seeBttn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//mostrar contraseña
				if(!passwordVisible) {
					passwordFld2.setEchoChar((char)0); //representar los caracteres de la contraseña con letras 'ABCdario'	
					passwordFld2.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(AuthView.class.getResource("/images/eyeSeesIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn2.setIcon(imageIcon);
					passwordVisible = true;
				}else {
					//ocultar contraseña
					passwordFld2.setEchoChar('*'); //representar los caracteres de la contraseña con asteriscos '*'				
					passwordFld2.setFont(new Font("Tahoma", Font.BOLD, 14)); //fuente, tipo y tamaño
					image = new ImageIcon(AuthView.class.getResource("/images/eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					seeBttn2.setIcon(imageIcon);
					passwordVisible = false;
				}
				
			}
			
		});
		
		passwordConfPnl.add(confFieldPnl, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(40, 0, 0, 0);  //relleno en la parte de arriba
		c.gridx = 0; //posición
		c.gridy = 6; //posición
		registerPnl.add(passwordConfPnl, c);
		
		
		//panel de botones 
		JPanel actionBttnsPnl = new JPanel();
		actionBttnsPnl.setOpaque(false);
		actionBttnsPnl.setLayout(new GridLayout(1, 2, 20, 10));
		
		//botón para regresar al inicio
		image = new ImageIcon(AuthView.class.getResource("/images/returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
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
				windowManager(2);
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		returnHomeBttn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	image = new ImageIcon(AuthView.class.getResource("/images/returnHomeIcon2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				imageIcon  = new ImageIcon(image);
				returnHomeBttn.setIcon(imageIcon);
		    	returnHomeBttn.setForeground(Color.decode("#BFE4FF"));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	image = new ImageIcon(AuthView.class.getResource("/images/returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
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
				if(usernameTxtFld.getText().equals("")) {
					usernameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					username = usernameTxtFld.getText();
					usernameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
					
				
				//correo electrónico vacío
				if(emailTxtFld.getText().equals("")) {
					emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					userEmail = emailTxtFld.getText();
					emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completado
					counter++;
				}
				
				//contraseña vacía
				passTxt = new String(passwordFld.getPassword());
				if(passTxt.equals("")) {
					fieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				}else { 
					newPassword = passTxt.toString();
					fieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completada
					counter++;
				}
				
				//confirmación vacía
				passTxt = new String(passwordFld2.getPassword());
				if(passTxt.equals("")) {
					confFieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				}else { 
					confPassword = passTxt.toString();
					confFieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completada
					counter++;
				}
				
				
				//validar si los campos han sido completados
				if(counter==4) {
					boolean userInfo = functions.registerUser(username, userEmail, newPassword, confPassword); 
					
					//cuando los campos coinciden son correctos en formato
					if(userInfo) {
						functions.register(name, surname, company, companyField, position, username, userEmail, confPassword);
						String message = "Información registrada correctamente";
						JOptionPane.showMessageDialog(null, message, "Datos correctos", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
					}
					else {
						//cuando alguno de los dos campos no es correcto
						usernameTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						fieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						confFieldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						username = ""; userEmail = ""; company = ""; position = ""; //reestablecer datos
						String message = "datos incorrectos. \n Por favor, inténtelo otra vez.";
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
		c.gridy = 7;
		c.ipady = 20;
		registerPnl.add(actionBttnsPnl, c);
		
		frame.setVisible(true);
	}
	
	
	//manejador de ventanas
	public void windowManager(int target){
		frame.getContentPane().removeAll();
		
		if(target==1){ //login
			login();
		}
		else if(target==2){ //información personal
			registerCompanyInfo();
		}
		else if(target==3){ //información usuario
			registerUserInfo();
		}
		
		frame.repaint();
		frame.revalidate();
	}
	
}
