package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	public Ventana(String title) {
		this.setTitle(title);
		this.setVisible(true);
		this.setResizable(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.add(this.login());
	}
	
	public JPanel login() {
		JPanel login = new JPanel(); 
		login.setSize(500, 500);
		login.setLocation(0, 0);
		login.setBackground(Color.decode("#70C5FF"));
		login.setOpaque(true);
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(160, 40);
		etiqueta1.setLocation(160, 10);
		etiqueta1.setBackground(Color.pink);
		etiqueta1.setOpaque(true);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Otro dato");
		etiqueta2.setSize(90, 30);
		etiqueta2.setLocation(60, 80);
		etiqueta2.setBackground(Color.orange);
		etiqueta2.setOpaque(true);
		
		return login;
	}
}
 