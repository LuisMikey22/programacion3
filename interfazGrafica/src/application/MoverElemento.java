package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.AplicacionDibujo.Figura;
import application.AplicacionDibujo.PuntoSegmento;
import application.AplicacionDibujo.Triangulo;

public class MoverElemento extends JFrame implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//constructor
	private int x = 180, y = 280;
	PaintPanel panelCentro;
	
	public MoverElemento(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		
		ImageIcon paintIcon = new ImageIcon(getClass().getResource("rectShapeIcon.png"));
		this.setIconImage(paintIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(550, 750); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(550, 750));
		this.setResizable(isMaximumSizeSet());

		this.add(this.interfaz(), BorderLayout.CENTER);
		
		this.setFocusable(true);
		this.validate();
		this.revalidate();
		this.repaint();
	}
		
	
	public JPanel interfaz() {
	
		JPanel panelDeFondo = new JPanel();
		panelDeFondo.setBackground(Color.decode("#303030"));
		panelDeFondo.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.decode("#303030")));
		panelDeFondo.setLayout(new BorderLayout(10, 10));
		panelDeFondo.setLocation(0, 0);
		panelDeFondo.setSize(950, 750);
		panelDeFondo.addKeyListener(this);
		
		JLabel temporizadorLbl = new JLabel("00:00:00");
		panelDeFondo.add(temporizadorLbl, BorderLayout.NORTH);
		
		panelCentro = new PaintPanel();
		panelCentro.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.decode("#303030")));
		panelCentro.setFocusable(true);
		panelCentro.addKeyListener(this);
		panelCentro.setLayout(new BorderLayout(10, 10));
		panelCentro.setLocation(0, 0);
		panelCentro.setOpaque(false);
		panelCentro.setSize(950, 750);
		panelDeFondo.add(panelCentro);
		
		JButton reiniciarBtn = new JButton("REINICIAR");
		panelDeFondo.add(reiniciarBtn, BorderLayout.SOUTH);
		
		reiniciarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelCentro.repaint();
				reiniciar();
			}
		});
		
		return panelDeFondo;
	}
	
	
	public void reiniciar() { //JFrame
		this.requestFocus();
		this.setFocusable(true);
	}
	
	
	//clase PaintPanel
	class PaintPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1278175958603073892L;

		public PaintPanel() {
			this.setBackground(Color.white);
		}
		
		@Override
 	    public void paintComponent(Graphics g) {
			System.out.println("Pongan sza");
			super.paintComponent(g);
	       
			Graphics2D g2 = (Graphics2D)g; 
	        
			g2.setColor(Color.decode("#7448CC"));
	        g2.fillRect(x, y, 40, 40);
	        
		}
		
	}
	
	
	//main que ejecuta la ventana
	public static void main(String[] args) {
		new MoverElemento("Mover cuadrado con WASD");
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==87) { //W
			y -= 5;
		}
		if(e.getKeyCode()==65) { //A
			x -= 5;
		}
		if(e.getKeyCode()==83) { //S
			x += 5;
		}
		if(e.getKeyCode()==68) { //D
			y += 5;
		}
		panelCentro.repaint();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
