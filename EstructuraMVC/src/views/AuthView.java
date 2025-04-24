package views;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import models.AuthModel;

public class AuthView extends JFrame {

	private static final long serialVersionUID = 3677354243222270225L;
	
	private ImageIcon imageIcon;
	private Image image;
	private boolean passwordVisible = false;
	private String userEmail;
	private String preferences;
	private int terms;
	private JFrame frame;
	private AuthModel functions;
	
	private String colonias[] = {"Camino Real", "Bellavista", "Progreso", "Pedregal", "Calafia", "Diana Laura",
			 "El Mezquitito", "Indeco", "La Fuente", "Las Américas", "Miramar"};
	
 	public AuthView() {
 		frame = new JFrame();
 		frame.setTitle("Modelo MVC"); //colorcar título a la ventana
		frame.setVisible(true); //hacer visible la ventana
		frame.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		imageIcon = new ImageIcon(AuthView.class.getResource("/images/vortexIcon.png"));
		frame.setIconImage(imageIcon.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		frame.setSize(1000, 850); //colocar tamaño predeterminado
		frame.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		frame.setMinimumSize(new Dimension(1000, 850));
		frame.setResizable(isMaximumSizeSet());
		frame.add(this.login());
		
 		functions = new AuthModel();
 	}

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
		JPanel passwordElementsPnl = new JPanel();
		passwordElementsPnl.setOpaque(false);
		passwordElementsPnl.setLayout(new BorderLayout(10, 5));
		
		JLabel passwordLbL = new JLabel("Contraseña");
		passwordLbL.setForeground(Color.white); //color de letra
		passwordLbL.setOpaque(false); //tiene fondo o no
		passwordLbL.setHorizontalAlignment(JLabel.LEFT);
		passwordLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		passwordElementsPnl.add(passwordLbL, BorderLayout.NORTH);
		
		image = new ImageIcon(AuthView.class.getResource("/images/lockIcon.png")).getImage().getScaledInstance(18, 22, Image.SCALE_SMOOTH);
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
		
		image = new ImageIcon(AuthView.class.getResource("/images/eyeClosedIcon.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
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
				manejadorVentanas(2);
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
					jPssWrdFldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				}else { 
					jPssWrdFldPnl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green)); //completada
					flag2 = true;
				}
				
				
				//validar si los dos campos han sido completados
				if(flag1 && flag2) {
					
					boolean userAuth = functions.access(userEmail,passTxt); 
					//cuando ambos campos coinciden con los datos de la cuenta del usuario
					if(userAuth) {
						String message = "Hola, bienvenido";
						JOptionPane.showMessageDialog(null, message, "Datos correctos", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
					}
					else {
						//cuando alguno de los dos campos no es correcto
						userEmailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
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

 		return loginBckGrndPnl;
	}
	
	public JPanel register() {
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
		imageIcon = new ImageIcon(AuthView.class.getResource("/images/windowBackground.png"));
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
		image = new ImageIcon(AuthView.class.getResource("/images/returnHomeIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
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
				manejadorVentanas(1);
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
				if(emailTxtFld.getText().equals("")) {
					emailTxtFld.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					counter = 0;
				}else {
					userEmail = emailTxtFld.getText();
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
					terms = aceptoRBttn.isSelected()?1:0;
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
					preferences = dulceChckBx.isSelected()?dulceChckBx.getText():(saladoChckBx.isSelected()?saladoChckBx.getText():saludableChckBx.getText());
					counter++;
				}
				
				//solo si todos los campos han sido completados se abrirá la ventana de login
				if(counter==4) {
					String neighborhood = coloniasCmbBx.getSelectedItem().toString();
					String userInfo = functions.register(userEmail, bioTxtArea.getText(), preferences, terms, neighborhood); 
					System.out.println(userInfo);
					manejadorVentanas(1);
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
		
 		return signinBckGrndPnl;
	}
	
	//manejador de ventanas
	public void manejadorVentanas(int ventanaBlanco){
		frame.getContentPane().removeAll();
		
		if(ventanaBlanco==1){ //laberinto 1 / nivel 1
			frame.add(this.login());
		}
		else if(ventanaBlanco==2){ //laberinto 2 / nivel 2
			frame.add(this.register());
		}
		
		frame.repaint();
		frame.revalidate();
	}
}
