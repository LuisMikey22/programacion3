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
	
	Font tahoma = new Font("Tahoma", Font.BOLD, 15);
	
	public Interes(String title){
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("vortexIcon.png");
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(500, 700); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(300, 500));
		this.setMaximumSize(new Dimension(500, 700));
		this.setResizable(isMaximumSizeSet());

		this.add(this.interes(), BorderLayout.CENTER); //coloca el panel en el centro de la ventana
		
		this.repaint();
	}
	
	public JPanel interes() {
		
		JPanel interesPnl = new JPanel();
		interesPnl.setLayout(new BorderLayout(90, 20));
		interesPnl.setBackground(Color.white);
		
		JLabel interesLbl = new JLabel("Interés");
		interesLbl.setForeground(Color.decode("#1B313F")); //color de letra
		interesLbl.setOpaque(false); //tiene fondo o no
		interesLbl.setHorizontalAlignment(JLabel.LEFT);
		interesLbl.setFont(new Font("Tahoma", Font.ITALIC, 25)); //fuente, tipo y tamaño
		interesPnl.add(interesLbl, BorderLayout.NORTH);
		
		
		//////////////////calculadora/////////////////
		JPanel calculatePnl = new JPanel();
		calculatePnl.setLayout(new GridLayout(4, 2, 50, 80));
		calculatePnl.setBackground(Color.decode("#99FF99"));
		calculatePnl.setOpaque(true);
		calculatePnl.setBorder(BorderFactory.createTitledBorder("Calcular interés"));
		interesPnl.add(calculatePnl, BorderLayout.CENTER);
		
		JLabel capitalLbl = new JLabel("Capital:");
		capitalLbl.setForeground(Color.decode("#1B313F"));
		capitalLbl.setHorizontalAlignment(JLabel.CENTER);
		capitalLbl.setFont(tahoma); //fuente, tipo y tamaño
		calculatePnl.add(capitalLbl);
		
		JTextField capitalTxtFld = new JTextField();
		calculatePnl.add(capitalTxtFld);
		
		JLabel timeLbl = new JLabel("Tiempo:");
		timeLbl.setForeground(Color.decode("#1B313F"));
		timeLbl.setHorizontalAlignment(JLabel.CENTER);
		timeLbl.setFont(tahoma); //fuente, tipo y tamaño
		calculatePnl.add(timeLbl);
		
		JTextField timeTxtFld = new JTextField();
		timeTxtFld.setForeground(Color.decode("#1B313F"));
		calculatePnl.add(timeTxtFld);
		
		JLabel interestMeasureLbl = new JLabel("Tasa interés:");
		interestMeasureLbl.setForeground(Color.decode("#1B313F"));
		interestMeasureLbl.setHorizontalAlignment(JLabel.CENTER);
		interestMeasureLbl.setFont(tahoma); //fuente, tipo y tamaño
		calculatePnl.add(interestMeasureLbl);
		
		JTextField interestMeasureTxtFld = new JTextField();
		interestMeasureTxtFld.setForeground(Color.decode("#1B313F"));
		calculatePnl.add(interestMeasureTxtFld);
		
		JButton calculateBttn = new JButton("Calcular");
		calculateBttn.setForeground(Color.white);
		calculateBttn.setFont(tahoma);
		calculateBttn.setBackground(Color.decode("#1B313F"));
		calculatePnl.add(calculateBttn);
		
		JButton cancelBttn = new JButton("Cancelar");
		cancelBttn.setForeground(Color.white);
		cancelBttn.setFont(tahoma);
		cancelBttn.setBackground(Color.decode("#1B313F"));
		calculatePnl.add(cancelBttn);
		
		
		//////////////////resultados/////////////////
		JPanel footerPnl = new JPanel();
		footerPnl.setLayout(new GridLayout(2, 2, 30, 80));
		footerPnl.setBackground(Color.decode("#FF9999"));
		footerPnl.setOpaque(true);
		interesPnl.add(footerPnl, BorderLayout.SOUTH);
		
		JLabel interestFooterLbl = new JLabel("Interés:");
		interestFooterLbl.setForeground(Color.decode("#1B313F"));
		interestFooterLbl.setHorizontalAlignment(JLabel.CENTER);
		interestFooterLbl.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		footerPnl.add(interestFooterLbl);
		
		JTextField interestFooterTxtFld = new JTextField();
		interestFooterTxtFld.setHorizontalAlignment(JLabel.CENTER);
		footerPnl.add(interestFooterTxtFld);
		
		JLabel amountFooterLbl = new JLabel("Monto:");
		amountFooterLbl.setForeground(Color.decode("#1B313F"));
		amountFooterLbl.setHorizontalAlignment(JLabel.CENTER);
		amountFooterLbl.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		footerPnl.add(amountFooterLbl);
		
		JTextField amountFooterTxtFld = new JTextField();
		amountFooterTxtFld.setHorizontalAlignment(JLabel.CENTER);
		footerPnl.add(amountFooterTxtFld);
		
		return interesPnl;
	}
}
