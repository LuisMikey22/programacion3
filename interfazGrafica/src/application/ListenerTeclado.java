package application;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ListenerTeclado implements KeyListener{

	private JFrame frame;
	
	PaintPanel panelCentro;
	Graphics2D g2;
	BufferedImage characterImage;
	
	Jugador jugador = null;
	ArrayList<Jugador> obstaculos = new ArrayList<Jugador>(); //SEGMENTOS
	
	JLabel tiempoValorLbl;
	Timer temporizador;
	boolean tempActivo = false;
	int hor, min, seg, cen;

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
		
		//crear jugador y obstáculos
		jugador = new Jugador(240-5, 320-5, 38, 64, Color.decode("#00A2E8"));
		obstaculos.add(new Jugador(280, 360, 50, 50, Color.orange));
		
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
				//reiniciar valores de X y Y
				jugador.x = 240;
				jugador.y = 320;
				
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

	@Override
	public void keyTyped(KeyEvent e) {
	}


	@Override
	public void keyPressed(KeyEvent e) {
		reanudarTemp();
		
		System.out.println(e.getKeyCode());
		
		Boolean m = false;
		for(Jugador obst: obstaculos) {
			if(jugador.colision(obst)) { //si existe colisión
				m = true;
				System.out.println("Colisión");
			}
		}
		
		//W, FLECHA ARRIBA
		if(e.getKeyCode()==87 || e.getKeyCode()==38) { 
			System.out.println(e.getKeyCode() + " Arriba");
			//si Y es menor al límite del  JFrame se teletransporta a Y = 750
			//colisión
			if(m) { //SI COLISIONA
				 jugador.y += 7;
			}else {
				if(jugador.y>0) {
					jugador.y -= 5;
				}
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
			//colisión
			if(m) {
				jugador.x += 7;
			}else {
				if(jugador.x>0) {
					jugador.x -= 5;
				}
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
			//colisión
			if(m) {
				jugador.y -= 7;
			}else {
				if(jugador.y<590) {
					jugador.y += 5;
				}
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
			//colisión
			if(m) {
				jugador.x-=7;
			}else {
				if(jugador.x<500) {
					jugador.x += 5;
				}
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
	
	//clase PaintPanel
	class PaintPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		
		public PaintPanel() {
			 this.setBackground(Color.decode("#00A2E8"));
		 }
		 public void paintComponent(Graphics g) {
			 super.paintComponent(g);
			 g2 = (Graphics2D) g;
			 
			 //jugador
			 g2.setColor(jugador.color);
			 g2.fillRect(jugador.x, jugador.y, jugador.w, jugador.h); //hitbox
			 g2.drawImage(characterImage, jugador.x, jugador.y, jugador.w, jugador.h, null, null); //imagen de personaje
			 
			 //paredes y obstáculos
			 for(Jugador obst: obstaculos) {
				 g2.setColor(obst.color);
				 g2.fillRect(obst.x, obst.y, obst.w, obst.h);
			 }
			 
			 //g2.drawImage(characterImage, jugador.x , y, 38, 64, null, null); 
			 
		 }
	}
	
	//colisión
	class Jugador extends JPanel{
		private static final long serialVersionUID = -6849931942729399650L;

		private int x;
		private int y;
		private int w;
		private int h;
		private Color color;
		
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getW() {
			return w;
		}

		public void setW(int w) {
			this.w = w;
		}

		public int getH() {
			return h;
		}

		public void setH(int h) {
			this.h = h;
		}
		
		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
		
		public Jugador(int x, int y, int w, int h, Color color) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
		}
		
		public boolean colision(Jugador blanco) {
			
			if(this.x + 5 < blanco.x + blanco.w && //X
		       this.x + 5 + this.w > blanco.x &&
		       this.y + 5 < blanco.y + blanco.h && //Y
		       this.y + 5 + this.h > blanco.y)
				return true;
			
			//else
			return false;
			
		}

	}

}
