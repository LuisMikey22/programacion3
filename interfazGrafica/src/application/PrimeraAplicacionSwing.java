package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

public class PrimeraAplicacionSwing {

	private JFrame frame;
	
	String nationalities[] = {"México", "Perú", "Argentina", "Guatemala", "Brasil", "Colombia",
			 				  "Venezuela", "Bolivia", "Paraguay", "Uruguay", "El Salvador", "Panamá",
			 				  "Chile","Honduras", "Ecuador", "Cuba", "Costa Rica", "Belice", "Nicaragua",
			 				  "Jamaica"};
	
	String preferences[] = {"Tejer", "Senderismo", "Pintar", "Películas", "Leer", "Nadar",
			 				"Escribir", "Programar", "Ejercicio", "Caminar", "Fotografías", 
			 				"Música", "Bordar", "Cerámica", "Bisutería", "Cocinar", "Costura",
			 				"Yoga", "Escultura", "Oratoria", "Ajedrez", "Paracaidismo", "Viajar",
			 				"Jardinería", "Cultivar", };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeraAplicacionSwing window = new PrimeraAplicacionSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrimeraAplicacionSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImageIcon vortexIcon = new ImageIcon(getClass().getResource("vortexIcon.png"));
		frame.setIconImage(vortexIcon.getImage());
		frame.setBounds(100, 100, 800, 650);
		frame.setMinimumSize(new Dimension(800, 650));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel generalPnl = new JPanel();
		generalPnl.setBorder(new LineBorder(new Color(255, 255, 255), 20)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		generalPnl.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(generalPnl, BorderLayout.CENTER);
		generalPnl.setLayout(new BorderLayout(10, 10));
		
		JLabel userRegisterLbl = new JLabel("Registro de usuarios");
		userRegisterLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		userRegisterLbl.setBackground(Color.pink);
		userRegisterLbl.setForeground(Color.black); 
		generalPnl.add(userRegisterLbl, BorderLayout.NORTH);
		
		JPanel InformationPnl= new JPanel();
		InformationPnl.setBackground(new Color(255, 255, 255));
		InformationPnl.setLayout(new GridLayout(2, 1, 10, 10));
		generalPnl.add(InformationPnl, BorderLayout.WEST);
		
		//panel con elementos de la información del usuario
		JPanel generalInfPnl = new JPanel();
		generalInfPnl.setBackground(new Color(135, 206, 250));
		generalInfPnl.setBorder(BorderFactory.createTitledBorder(null, "Datos generales", 0, 0, null, Color.black));
		generalInfPnl.setLayout(new GridLayout(6, 2, 40, 15));
		InformationPnl.add(generalInfPnl);
		
		JLabel nameLbl = new JLabel("Nombre:");
		nameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLbl.setForeground(Color.black);
		generalInfPnl.add(nameLbl);
		
		JTextField nameTxtFld = new JTextField();
		nameTxtFld.setColumns(10);
		generalInfPnl.add(nameTxtFld);
		
		JLabel surname1Lbl = new JLabel("Apellido paterno:");
		surname1Lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		surname1Lbl.setForeground(Color.black);
		generalInfPnl.add(surname1Lbl);
		
		JTextField surname1TxtFld = new JTextField();
		surname1TxtFld.setColumns(10);
		generalInfPnl.add(surname1TxtFld);
		
		JLabel surname2Lbl = new JLabel("Apellido materno:");
		surname2Lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		surname2Lbl.setForeground(Color.black);
		generalInfPnl.add(surname2Lbl);
		
		JTextField surname2TxtFld = new JTextField();
		surname2TxtFld.setColumns(10);
		generalInfPnl.add(surname2TxtFld);
		
		JLabel birthDateLbl = new JLabel("Fecha de nacimiento:");
		birthDateLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		birthDateLbl.setForeground(Color.black);
		generalInfPnl.add(birthDateLbl);
		
		JTextField birthDateTxtFld= new JTextField();
		birthDateTxtFld.setColumns(10);
		generalInfPnl.add(birthDateTxtFld);
		
		JLabel sexLbl = new JLabel("Sexo:");
		sexLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		sexLbl.setForeground(Color.black);
		generalInfPnl.add(sexLbl);
		
		
		//panel de sexos biológicos
		JPanel sexesPnl = new JPanel();
		sexesPnl.setOpaque(false);
		sexesPnl.setLayout(new GridLayout(1, 2, 0, 0));
		generalInfPnl.add(sexesPnl);
		
		ButtonGroup sexesBttnGrp = new ButtonGroup();
		
		JRadioButton femenineRdBttn = new JRadioButton("Femenino");
		femenineRdBttn.setOpaque(false);
		femenineRdBttn.setHorizontalAlignment(JRadioButton.CENTER);
		femenineRdBttn.setForeground(Color.black);
		sexesPnl.add(femenineRdBttn);
		
		JRadioButton masculineRdBttn = new JRadioButton("Masculino");
		masculineRdBttn.setOpaque(false);
		masculineRdBttn.setHorizontalAlignment(JRadioButton.CENTER);
		masculineRdBttn.setForeground(Color.black);
		sexesPnl.add(masculineRdBttn);
		
		sexesBttnGrp.add(femenineRdBttn);
		sexesBttnGrp.add(masculineRdBttn);
		
		
		JLabel nationality = new JLabel("Nacionalidad:");
		nationality.setHorizontalAlignment(SwingConstants.RIGHT);
		nationality.setForeground(Color.black);
		generalInfPnl.add(nationality);
		
		JComboBox<String>nationalitiesCmbBx = new JComboBox<>(nationalities);
		nationalitiesCmbBx.setBackground(Color.white);
		nationalitiesCmbBx.setForeground(Color.black);
		generalInfPnl.add(nationalitiesCmbBx);
	
		
		//panel con elementos de información opcional del usuario
		JPanel optionalInfPnl = new JPanel();
		optionalInfPnl.setBackground(new Color(135, 206, 250));
		optionalInfPnl.setBorder(BorderFactory.createTitledBorder(null, "Datos opcionales", 0, 0, null, Color.black));
		optionalInfPnl.setLayout(new GridLayout(2, 2, 20, 0));
		InformationPnl.add(optionalInfPnl);
		
		JLabel descLbl = new JLabel("Descripción:");
		descLbl.setHorizontalAlignment(SwingConstants.LEFT);
		descLbl.setForeground(Color.black);
		optionalInfPnl.add(descLbl);
		
		JLabel preferencesLbl = new JLabel("Actividades/Pasatiempos:");
		preferencesLbl.setHorizontalAlignment(SwingConstants.LEFT);
		preferencesLbl.setForeground(Color.black);
		optionalInfPnl.add(preferencesLbl);
		
		
		JTextArea descTxtArea = new JTextArea();
		optionalInfPnl.add(descTxtArea);
		descTxtArea.setColumns(10);
		
		JScrollPane descScrllPn = new JScrollPane(descTxtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		optionalInfPnl.add(descScrllPn);
		
		
		JList<String>preferencesList = new JList<>(preferences);
		optionalInfPnl.add(preferencesList);
		
		JScrollPane preferencesScrllPn = new JScrollPane(preferencesList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		optionalInfPnl.add(preferencesScrllPn);
		
		
		//panel con elementos del perfil del usuario
		JPanel userProfilePnl = new JPanel();
		userProfilePnl.setBackground(new Color(255, 192, 203));
		userProfilePnl.setBorder(BorderFactory.createTitledBorder(null, "Perfil de usuario", 0, 0, null, Color.black));
		userProfilePnl.setLayout(new BorderLayout(0, 0));
		generalPnl.add(userProfilePnl, BorderLayout.CENTER);
				
		Image imageUser = new ImageIcon(getClass().getResource("baldProfilePicture.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon imageUserIcon = new ImageIcon(imageUser);
		JLabel userImageLbl = new JLabel(imageUserIcon);
		userProfilePnl.add(userImageLbl, BorderLayout.NORTH);
				
		JPanel showOptionsPnl = new JPanel();
		showOptionsPnl.setOpaque(false);
		showOptionsPnl.setLayout(new GridLayout(2, 1, 0, 0));
		userProfilePnl.add(showOptionsPnl, BorderLayout.CENTER);
				
		JCheckBox showProfilePicChckBx = new JCheckBox("Mostrar foto de perfil               ");
		showProfilePicChckBx.setOpaque(false);
		showProfilePicChckBx.setHorizontalAlignment(JLabel.CENTER);
		showProfilePicChckBx.setForeground(Color.black);
		showOptionsPnl.add(showProfilePicChckBx);
				
		JCheckBox showBirthdateChckBx = new JCheckBox("Mostrar fecha de nacimiento");
		showBirthdateChckBx.setOpaque(false);
		showBirthdateChckBx.setHorizontalAlignment(JLabel.CENTER);
		showBirthdateChckBx.setVerticalAlignment(JLabel.TOP);
		showBirthdateChckBx.setForeground(Color.black);
		showOptionsPnl.add(showBirthdateChckBx);
		
		
		//panel con elementos de botones para realizar acciones
		JPanel buttonOptionsPnl = new JPanel();
		buttonOptionsPnl.setBackground(new Color(255, 255, 255));
		buttonOptionsPnl.setLayout(new GridLayout(1, 3));
		generalPnl.add(buttonOptionsPnl, BorderLayout.SOUTH);
		
		JButton newUserBttn = new JButton("Nuevo");
		Image newImage = new ImageIcon(getClass().getResource("addIcon.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH); //redimensionar la imagen
		ImageIcon newImageIcon = new ImageIcon(newImage);
		newUserBttn.setIcon(newImageIcon);
		newUserBttn.setBorder(new LineBorder(new Color(255, 255, 255), 20)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		newUserBttn.setHorizontalAlignment(SwingConstants.CENTER);
		newUserBttn.setHorizontalAlignment(JButton.CENTER);
		newUserBttn.setBackground(Color.decode("#001D33"));
		newUserBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		newUserBttn.setForeground(Color.white);
		buttonOptionsPnl.add(newUserBttn);
		
		JButton saveInfBttn = new JButton("Guardar");
		Image saveImage = new ImageIcon(getClass().getResource("saveIcon.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH); //redimensionar la imagen
		ImageIcon saveImageIcon = new ImageIcon(saveImage);
		saveInfBttn.setIcon(saveImageIcon);
		saveInfBttn.setBorder(new LineBorder(new Color(255, 255, 255), 20)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		saveInfBttn.setHorizontalAlignment(SwingConstants.CENTER);
		saveInfBttn.setHorizontalAlignment(JButton.CENTER);
		saveInfBttn.setBackground(Color.decode("#001D33"));
		saveInfBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		saveInfBttn.setForeground(Color.white);
		buttonOptionsPnl.add(saveInfBttn);
		
		JButton closeBttn = new JButton("Salir");
		Image returnImage = new ImageIcon(getClass().getResource("returnHomeIcon.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH); //redimensionar la imagen
		ImageIcon returnImageIcon = new ImageIcon(returnImage);
		closeBttn.setIcon(returnImageIcon);
		closeBttn.setBorder(new LineBorder(new Color(255, 255, 255), 20)); //borde del color del panel padre para crear ilusion de un elemento más pequeño
		closeBttn.setHorizontalAlignment(SwingConstants.CENTER);
		closeBttn.setHorizontalAlignment(JButton.CENTER);
		closeBttn.setBackground(Color.decode("#001D33"));
		closeBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		closeBttn.setForeground(Color.white);
		buttonOptionsPnl.add(closeBttn);
	}

}
