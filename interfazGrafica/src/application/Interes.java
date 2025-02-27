package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interes extends JFrame {
	public Interes(String title){
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("vortexIcon.png");
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(470, 370); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(300, 500));
		this.setMaximumSize(new Dimension(800, 900));
		this.setResizable(isMaximumSizeSet());

		this.add(this.interes(), BorderLayout.CENTER); //coloca el panel en el centro de la ventana
		
		this.repaint();
	}
	
	public JPanel interes() {
		
		JPanel interesPnl = new JPanel();
		interesPnl.setBackground(Color.white);
		interesPnl.setLayout(new BorderLayout());
		
		JLabel interesLbl = new JLabel("Interés");
		interesLbl.setForeground(Color.decode("#1B313F")); //color de letra
		interesLbl.setOpaque(true); //tiene fondo o no
		interesLbl.setHorizontalAlignment(JLabel.LEFT);
		interesLbl.setFont(new Font("Tahoma", Font.ITALIC, 20)); //fuente, tipo y tamaño
		interesPnl.add(interesLbl, BorderLayout.NORTH);
		
		
		JPanel calculatePnl = new JPanel();
		calculatePnl.setLayout(new GridLayout(4, 2, 30, 30));
		calculatePnl.setBackground(Color.decode("#BFE4FF"));
		calculatePnl.setOpaque(true);
		calculatePnl.setBorder(BorderFactory.createTitledBorder("Calcular interés"));
		interesPnl.add(calculatePnl, BorderLayout.CENTER);
		
		JLabel capitalLbl = new JLabel("Capital:");
		capitalLbl.setForeground(Color.decode("#1B313F"));
		capitalLbl.setHorizontalAlignment(JLabel.CENTER);
		capitalLbl.setFont(new Font("Tahoma", Font.BOLD, 20)); //fuente, tipo y tamaño
		calculatePnl.add(capitalLbl);
		
		JTextField capitalTxtFld = new JTextField();
		calculatePnl.add(capitalTxtFld);
		
		JLabel timeLbl = new JLabel("Tiempo:");
		timeLbl.setForeground(Color.decode("#1B313F"));
		timeLbl.setHorizontalAlignment(JLabel.CENTER);
		timeLbl.setFont(new Font("Tahoma", Font.BOLD, 20)); //fuente, tipo y tamaño
		calculatePnl.add(timeLbl);
		
		JTextField timeTxtFld = new JTextField();
		calculatePnl.add(timeTxtFld);
		
		JLabel interestMesureLbl = new JLabel("Tiempo:");
		interestMesureLbl.setForeground(Color.decode("#1B313F"));
		interestMesureLbl.setHorizontalAlignment(JLabel.CENTER);
		interestMesureLbl.setFont(new Font("Tahoma", Font.BOLD, 20)); //fuente, tipo y tamaño
		calculatePnl.add(interestMesureLbl);
		
		JTextField interestMeasureTxtFld = new JTextField();
		calculatePnl.add(interestMeasureTxtFld);
		
		JButton calculateBttn = new JButton("Calcular");
		calculatePnl.add(calculateBttn);
		
		JButton cancelBttn = new JButton("Cancelar");
		calculatePnl.add(cancelBttn);
		
		
		//pie de pagina
		JPanel footerPnl = new JPanel();
		footerPnl.setLayout(new GridLayout(2, 2, 60, 60));
		footerPnl.setBackground(Color.decode("#1B313F"));
		footerPnl.setOpaque(true);
		interesPnl.add(footerPnl, BorderLayout.SOUTH);
		
		JLabel interestFooterLbl = new JLabel("Interés:");
		interestFooterLbl.setForeground(Color.white);
		interestFooterLbl.setHorizontalAlignment(JLabel.CENTER);
		interestFooterLbl.setFont(new Font("Tahoma", Font.BOLD, 20)); //fuente, tipo y tamaño
		footerPnl.add(interestFooterLbl);
		
		JTextField interestFooterTxtFld = new JTextField();
		footerPnl.add(interestFooterTxtFld);
		
		JLabel amountFooterLbl = new JLabel("Monto:");
		amountFooterLbl.setForeground(Color.white);
		amountFooterLbl.setHorizontalAlignment(JLabel.CENTER);
		amountFooterLbl.setFont(new Font("Tahoma", Font.BOLD, 20)); //fuente, tipo y tamaño
		footerPnl.add(amountFooterLbl);
		
		JTextField amountFooterTxtFld = new JTextField();
		footerPnl.add(amountFooterTxtFld);
		
		return interesPnl;
	}
}
