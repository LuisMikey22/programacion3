package application;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ListenerTeclado implements KeyListener{

	private JFrame frame;
	
	private int x = 240, y = 320;
	PaintPanel panelCentro;
	Graphics2D g2;
	BufferedImage characterImage;
	
	JLabel tiempoValorLbl;
	Timer temporizador;
	boolean tempActivo = false;
	private int hor, min, seg, cen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListenerTeclado window = new ListenerTeclado();
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
	public ListenerTeclado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImageIcon vortexIcon = new ImageIcon(getClass().getResource("vortexIcon.png"));
		frame.setIconImage(vortexIcon.getImage());
		frame.setBounds(100, 100, 550, 750);
		frame.setMinimumSize(new Dimension(550, 750));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tiempoValorLbl = new JLabel("00:00:00:00");
		tiempoValorLbl.setBackground(Color.decode("#303030"));
		tiempoValorLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		tiempoValorLbl.setForeground(Color.white);
		tiempoValorLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		tiempoValorLbl.setOpaque(true);
		frame.getContentPane().add(tiempoValorLbl, BorderLayout.NORTH);
		
		panelCentro = new PaintPanel();
		//panelCentro.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.decode("#303030")));
		panelCentro.setFocusable(true);
		panelCentro.addKeyListener(this);
		panelCentro.setLayout(new BorderLayout(10, 10));
		panelCentro.setLocation(0, 0);
		panelCentro.setOpaque(true);
		panelCentro.setSize(950, 750);
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		JButton reiniciarBtn = new JButton("REINICIAR");
		reiniciarBtn.setBackground(Color.decode("#303030"));
		reiniciarBtn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		reiniciarBtn.setForeground(Color.white);
		frame.getContentPane().add(reiniciarBtn, BorderLayout.SOUTH);
		
		reiniciarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x = 240; y = 320; //reiniciar valores de X y Y
				
				//POSICIÓN INICIAL (IMAGEN)
				try {
					characterImage = ImageIO.read(getClass().getResource("idleCharacterImg.png"));
				}catch (IOException ex) {
					ex.printStackTrace();
				}
				
				panelCentro.repaint();
				panelCentro.requestFocus();
				panelCentro.setFocusable(true);
				reiniciarTemp();
			}
		});
		
		//POSICIÓN INICIAL (IMAGEN)
		try {
			characterImage = ImageIO.read(getClass().getResource("idleCharacterImg.png"));
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	//ACTUALIZAR ETIQUETA DE TEMPORIZADOR
	public void actualizarEtiqueta() {
		String tiempo = (hor<=9?"0":"")+hor+":" + (min<=9?"0":"")+min+":" + (seg<=9?"0":"")+seg+":" + (cen<=9?"0":"")+cen;
		tiempoValorLbl.setText(tiempo);
	}
	
	public void temporizador() {
		tempActivo = true;
		
		temporizador = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cen++;
    			if(cen==100) {
    				cen = 0;
    				++seg;
    			}
    			if(seg==60) {
    				seg = 0;
    				++min;
    			}
    			if(min==60) {
    				min = 0;
    				++hor;
    			}
    			actualizarEtiqueta();
			}
			
		});    
		
		temporizador.start();
		
	}
	
	//REANUDAR TEMPORIZADOR
	public void reanudarTemp() {
		if(!tempActivo) {
			temporizador();
		}
	}
	
	//DETENER TEMPORIZADOR
	public void detenerTemp() {
		tempActivo = false;
		if(temporizador!=null) {
			temporizador.stop();
		}
	}
	
	//REINICIAR TEMPORIZADOR
	public void reiniciarTemp() {
		tempActivo = false;
		if(temporizador!=null) {
			temporizador.stop();
		}
		tiempoValorLbl.setText("00:00:00:00");
		hor = 0; min = 0; seg = 0; cen = 0;
	}

	
	//clase PaintPanel
	class PaintPanel extends JPanel{
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public PaintPanel() {
			 this.setBackground(Color.decode("#00A2E8"));
		 }
		 public void paintComponent(Graphics g) {
			 super.paintComponent(g);
			 g2 = (Graphics2D) g;
			 
			 g2.drawImage(characterImage, x , y, 38, 64, null, null);
		 }
	 }
		
	
	@Override
	public void keyTyped(KeyEvent e) {
	}


	@Override
	public void keyPressed(KeyEvent e) {
		reanudarTemp();
		
		System.out.println(e.getKeyCode());
		
		//W, FLECHA ARRIBA
		if(e.getKeyCode()==87 || e.getKeyCode()==38) { 
			System.out.println(e.getKeyCode() + " Arriba");
			//si Y es menor al límite del  JFrame se teletransporta a Y = 750
			if(y>0) {
				y -= 5;
			}else {
				y = 700;
			}
			
			//cambiar imagen del personaje
			try {
				BufferedImage upImg = ImageIO.read(getClass().getResource("upCharacterImg.png"));
				characterImage = upImg;
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//A, FLECHA IZQUIERDA
		else if(e.getKeyCode()==65 || e.getKeyCode()==37) { 
			System.out.println(e.getKeyCode() + " Izquierda");
			//si X es menor al límite del  JFrame se teletransporta a X = 550
			if(x>0) {
				x -= 5;
			}else {
				x = 550;
			}
			
			//cambiar imagen del personaje
			try {
				BufferedImage leftImg = ImageIO.read(getClass().getResource("leftCharacterImg.png"));
				characterImage = leftImg;
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//S, FLECHA ABAJO
		else if(e.getKeyCode()==83 || e.getKeyCode()==40) { 
			System.out.println(e.getKeyCode() + " Abajo");
			//si Y es mayor al límite del  JFrame se teletransporta a Y = 0
			if(y>750) {
				y = 0;
			}else {
				y += 5;
			}
			
			//cambiar imagen del personaje
			try {
				BufferedImage downImg = ImageIO.read(getClass().getResource("downCharacterImg.png"));
				characterImage = downImg;
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//D, FLECHA DERECHA
		else if(e.getKeyCode()==68 || e.getKeyCode()==39) { 
			System.out.println(e.getKeyCode() + " Derecha");
			//si X es mayor al límite del  JFrame se teletransporta a X = 0
			if(x>550) {
				x = 0;
			}else {
				x += 5;
			}
			
			//cambiar imagen del personaje
			try {
				BufferedImage rightImg = ImageIO.read(getClass().getResource("rightCharacterImg.png"));
				characterImage = rightImg;
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		panelCentro.repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
