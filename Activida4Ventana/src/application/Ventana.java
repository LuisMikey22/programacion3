package application;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame{
	public Ventana(String title) {
		this.setTitle(title);
		this.setVisible(true);
		this.setResizable(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(100, 100);
		etiqueta1.setLocation(0, 0);
		etiqueta1.setBackground(Color.BLUE);
		this.add(etiqueta1);
	}
}
 