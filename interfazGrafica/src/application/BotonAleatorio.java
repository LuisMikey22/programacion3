package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BotonAleatorio extends JFrame{
	public BotonAleatorio(String title){
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("vortexIcon.png");
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1000, 850); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(1000, 850));
		//this.setMaximumSize(new Dimension(1100, 950));
		this.setResizable(isMaximumSizeSet());

		this.add(this.interfaz(), BorderLayout.CENTER);
		
		this.validate();
		this.revalidate();
		this.repaint();
	}
	
	public JPanel interfaz() {
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.pink);
		fondo.setLocation(0, 0);
		fondo.setSize(1000, 850);
		
		JButton agregar = new JButton("Agregar");
		agregar.setBackground(Color.orange);
		agregar.setLocation(400, 500);
		agregar.setSize(150, 50);
		fondo.add(agregar);
		
		agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Random rand = new Random();
				
				JButton nuevoBoton = new JButton("Click Me");
				nuevoBoton.setBackground(new Color(rand.nextInt(250), rand.nextInt(250), rand.nextInt(250)));
				nuevoBoton.setLocation(rand.nextInt(1000), rand.nextInt(1000));
				nuevoBoton.setSize(150, 50);
				fondo.add(nuevoBoton);
				
				fondo.repaint();
			}
			
		});
		
		return fondo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BotonAleatorio interfaz = new BotonAleatorio("Botones random 2");
	}
	
}
