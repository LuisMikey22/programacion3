package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register extends JFrame{
	
	String colonias[] = {"Camino Real", "Bellavista", "Progreso", "Pedregal", "Calafia", "Diana Laura",
						 "El Mezquitito", "Indeco", "La Fuente", "Las Américas", "Miramar"};
	
	public Register(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		this.setLayout(null); //desactivar los contenedores por defecto
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(500, 600); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(300, 400));
		this.setMaximumSize(new Dimension(800, 900));
		this.setResizable(isMaximumSizeSet());
		
		this.add(this.registro());
		
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
	
	public JPanel registro() {
		JPanel registroPnl = new JPanel(); 
		registroPnl.setSize(500, 600);
		registroPnl.setLocation(0, 0);
		registroPnl.setBackground(Color.decode("#BFE4FF"));
		registroPnl.setOpaque(true); //tiene fondo o no
		
		JLabel registroLbl = new JLabel("Registro");
		registroLbl.setSize(240, 40);
		registroLbl.setLocation(118, 32);
		registroLbl.setForeground(Color.white); //color de letra
		registroLbl.setOpaque(false); //tiene fondo o no
		registroLbl.setHorizontalAlignment(JLabel.CENTER);
		registroLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		this.add(registroLbl);
		
		JLabel header = new JLabel();
		header.setSize(500, 84);
		header.setLocation(0, 0);
		header.setOpaque(true); //tiene fondo o no
		header.setBackground(Color.decode("#33627F")); 
		header.setHorizontalAlignment(JLabel.LEFT);
		this.add(header);
		
		JLabel userLbl = new JLabel("Nombre de usuario:");
		userLbl.setSize(290, 40);
		userLbl.setLocation(98, 100);
		userLbl.setForeground(Color.decode("#1B313F")); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.LEFT);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(userLbl);
		
		JTextField userTxtFld = new JTextField();
		userTxtFld.setSize(290, 30);
		userTxtFld.setLocation(98, 145);
		userTxtFld.setForeground(Color.decode("#1B313F")); //color de letra
		userTxtFld.setOpaque(true); //tiene fondo o no
		userTxtFld.setHorizontalAlignment(JLabel.LEFT);
		userTxtFld.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		this.add(userTxtFld);
		
		JLabel bioLbL = new JLabel("Biografía:");
		bioLbL.setSize(290, 40);
		bioLbL.setLocation(98, 180);
		bioLbL.setForeground(Color.decode("#1B313F")); //color de letra
		bioLbL.setOpaque(false); //tiene fondo o no
		bioLbL.setHorizontalAlignment(JLabel.LEFT);
		bioLbL.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(bioLbL);
		
		JTextArea bioTxt= new JTextArea();
		bioTxt.setSize(290, 50);
		bioTxt.setLocation(98, 228);
		bioTxt.setForeground(Color.decode("#1B313F")); //color de letra
		bioTxt.setOpaque(true); //tiene fondo o no
		bioTxt.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		bioTxt.setBorder(BorderFactory.createDashedBorder(Color.decode("#1B313F"), 6, 10));
		this.add(bioTxt);
		
		JLabel preferencesLbl = new JLabel("Preferencias");
		preferencesLbl.setSize(240, 20);
		preferencesLbl.setLocation(120, 292);
		preferencesLbl.setForeground(Color.decode("#1B313F")); //color de letra
		preferencesLbl.setHorizontalAlignment(JLabel.LEFT); //centrar 
		preferencesLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto
		preferencesLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(preferencesLbl);
		
		JCheckBox dulceChckBx = new JCheckBox("Dulce");
		dulceChckBx.setSize(60, 20);
		dulceChckBx.setLocation(98, 318);
		dulceChckBx.setOpaque(false); //tiene fondo o no
		dulceChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		dulceChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		this.add(dulceChckBx);
		
		JCheckBox saladoChckBx = new JCheckBox("Salado");
		saladoChckBx.setSize(70, 20);
		saladoChckBx.setLocation(200, 318);
		saladoChckBx.setOpaque(false); //tiene fondo o no
		saladoChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		saladoChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		this.add(saladoChckBx);
		
		JCheckBox SaludableChckBx = new JCheckBox("Saludable");
		SaludableChckBx.setSize(90, 20);
		SaludableChckBx.setLocation(300, 318);
		SaludableChckBx.setOpaque(false); //tiene fondo o no
		SaludableChckBx.setForeground(Color.decode("#1B313F")); //color de letra
		SaludableChckBx.setFont(new Font("Tahoma", Font.BOLD, 13)); //fuente, tipo y tamaño
		this.add(SaludableChckBx);
		
		JLabel terminosLbl= new JLabel("Términos");
		terminosLbl.setSize(290, 30);
		terminosLbl.setLocation(98, 345); 
		terminosLbl.setForeground(Color.decode("#1B313F")); //color de letra
		terminosLbl.setHorizontalAlignment(JLabel.LEFT); //centrar 
		terminosLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto 
		terminosLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(terminosLbl);
		
		
		ButtonGroup terminosBttnGrp = new ButtonGroup();
		
		JRadioButton aceptoRBttn = new JRadioButton("Acepto términos");
		aceptoRBttn.setSize(130, 20);
		aceptoRBttn.setLocation(98, 380);
		aceptoRBttn.setOpaque(false); //tiene fondo o no
		aceptoRBttn.setForeground(Color.decode("#1B313F")); //color de letra
		aceptoRBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		this.add(aceptoRBttn);
		
		JRadioButton noAceptoRBttn = new JRadioButton("No acepto términos");
		noAceptoRBttn.setSize(150, 20);
		noAceptoRBttn.setLocation(242, 380);
		noAceptoRBttn.setOpaque(false); //tiene fondo o no
		noAceptoRBttn.setForeground(Color.decode("#1B313F")); //color de letra
		noAceptoRBttn.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		this.add(noAceptoRBttn);
		
		terminosBttnGrp.add(aceptoRBttn); // al estar agrupados solo se puede escoger un Radio Button
		terminosBttnGrp.add(noAceptoRBttn);
		
		
		JComboBox<String> coloniasCmbBx = new JComboBox<>(colonias);
		coloniasCmbBx.setSize(240, 20);
		coloniasCmbBx.setLocation(124, 425);
		coloniasCmbBx.setBackground(Color.white); 
		coloniasCmbBx.setForeground(Color.decode("#1B313F")); //color de letra
		coloniasCmbBx.setFont(new Font("Tahoma", Font.BOLD, 15));//fuente, tipo y tamaño
		this.add(coloniasCmbBx);
		
		JButton CrearBttn = new JButton("Crear Cuenta");
		CrearBttn.setSize(240, 50);
		CrearBttn.setLocation(124, 465);
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
 