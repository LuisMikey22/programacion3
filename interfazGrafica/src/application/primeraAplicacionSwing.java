package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

public class primeraAplicacionSwing {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	String colonias[] = {"Camino Real", "Bellavista", "Progreso", "Pedregal", "Calafia", "Diana Laura",
			 "El Mezquitito", "Indeco", "La Fuente", "Las Américas", "Miramar"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					primeraAplicacionSwing window = new primeraAplicacionSwing();
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
	public primeraAplicacionSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panelGeneral.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDiv4 = new JPanel();
		panelDiv4.setBackground(new Color(255, 255, 255));
		panelGeneral.add(panelDiv4, BorderLayout.CENTER);
		panelDiv4.setLayout(new GridLayout(2, 2, 10, 10));
		
		JPanel generalInfo = new JPanel();
		generalInfo.setBackground(new Color(255, 192, 203));
		generalInfo.setBorder(BorderFactory.createTitledBorder("Datos generales"));
		panelDiv4.add(generalInfo);
		generalInfo.setLayout(new GridLayout(0, 2, 0, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfo.add(lblNewLabel_1);
		
		textField = new JTextField();
		generalInfo.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido paterno:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfo.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		generalInfo.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido materno:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfo.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		generalInfo.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfo.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		generalInfo.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfo.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		generalInfo.add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		
		ButtonGroup sexos = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Femenino");
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Masculino");
		panel.add(rdbtnNewRadioButton_1);
		
		sexos.add(rdbtnNewRadioButton);
		sexos.add(rdbtnNewRadioButton_1);
		
		
		JLabel lblNewLabel_6 = new JLabel("Nacionalidad");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfo.add(lblNewLabel_6);
		
		JComboBox<String>comboBox = new JComboBox<>(colonias);
		generalInfo.add(comboBox);
		
		JPanel userProfile = new JPanel();
		userProfile.setBackground(new Color(135, 206, 250));
		panelDiv4.add(userProfile);
		userProfile.setLayout(new BorderLayout(0, 0));
		
		
		Image imageUser = new ImageIcon("userIcon.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon imageUserIcon = new ImageIcon(imageUser);
		JLabel userImageLbl = new JLabel(imageUserIcon);
		userImageLbl.setSize(250, 250);
		userProfile.add(userImageLbl, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		userProfile.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar fecha de nacimiento");
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mostrar fecha de nacimiento");
		panel_1.add(chckbxNewCheckBox_1);
		
		JPanel opcionalInfo = new JPanel();
		opcionalInfo.setBackground(new Color(135, 206, 250));
		panelDiv4.add(opcionalInfo);
		
		JPanel options = new JPanel();
		options.setBackground(new Color(255, 192, 203));
		panelDiv4.add(options);
		
		JLabel lblNewLabel = new JLabel("Registro de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		panelGeneral.add(lblNewLabel, BorderLayout.NORTH);
	}

}
