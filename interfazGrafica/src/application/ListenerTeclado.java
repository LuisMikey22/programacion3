package application;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.GridLayout;

public class ListenerTeclado implements KeyListener{

	private JFrame frame;
	
	PaintPanel panelLaberinto1, panelLaberinto2;
	Graphics2D g2;
	BufferedImage characterImage;
	
	Jugador jugador = null;
	Jugador sombra = null;
	ArrayList<Jugador> obstaculos1 = new ArrayList<Jugador>(); //Paredes
	ArrayList<Jugador> obstaculos2 = new ArrayList<Jugador>(); //Paredes
	
	JLabel tiempoValorLbl;
	Timer temporizador, movimientoAuto;
	int teclaPresionada = 0;
	int nivelActual = 1;
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
		frame = new JFrame();
		ImageIcon vortexIcon = new ImageIcon(getClass().getResource("vortexIcon.png"));
		frame.setIconImage(vortexIcon.getImage());
		frame.setBounds(100, 100, 550, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this.laberinto1(), BorderLayout.CENTER);
		
		ActionListener mover = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizar();
			}
			
		};
		movimientoAuto = new Timer(1, mover);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	//laberinto 1, nivel 1, hormiguero
	private JPanel laberinto1() {
		tiempoValorLbl = new JLabel("00:00:00:00");
		tiempoValorLbl.setBackground(Color.decode("#303030"));
		tiempoValorLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		tiempoValorLbl.setForeground(Color.white);
		tiempoValorLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		tiempoValorLbl.setOpaque(true);
		frame.getContentPane().add(tiempoValorLbl, BorderLayout.NORTH);
		
		//crear hormiga y obstáculos
		jugador = new Jugador(468, 590, 45, 45, Color.decode("#00A2E8"));
		sombra = new Jugador(jugador.x, jugador.y, jugador.w, jugador.h, Color.decode("#00A2E8"));
		
		obstaculos1.add(new Jugador(0, 140, 20, 517, Color.decode("#8B5728"))); //tierra
		obstaculos1.add(new Jugador(20, 638, 495, 20, Color.decode("#8B5728")));
		obstaculos1.add(new Jugador(515, 140, 20, 517, Color.decode("#8B5728")));
		obstaculos1.add(new Jugador(115, 120, 420, 20, Color.decode("#9ED33B"))); //césped
		obstaculos1.add(new Jugador(0, 120, 40, 20, Color.decode("#9ED33B")));
		
		//panel para pintar
		panelLaberinto1 = new PaintPanel();
		panelLaberinto1.setFocusable(true);
		panelLaberinto1.requestFocus();
		panelLaberinto1.addKeyListener(this);
		panelLaberinto1.setLayout(new BorderLayout(10, 10));
		panelLaberinto1.setLocation(0, 0);
		panelLaberinto1.setOpaque(true);
		panelLaberinto1.setSize(500, 500);
		frame.getContentPane().add(panelLaberinto1, BorderLayout.CENTER);
		
		//pie página con botones
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.setOpaque(false);
		frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		JButton nivel2IrBtn = new JButton("NIVEL 2");
		nivel2IrBtn.setBackground(Color.decode("#303030"));
		nivel2IrBtn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		nivel2IrBtn.setForeground(Color.white);
		panelBotones.add(nivel2IrBtn, BorderLayout.SOUTH);
		
		//ir al nivel 1
		nivel2IrBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nivelActual = 2;
				manejadorVentanas(nivelActual);
				reiniciarLaberinto();
				
			}
			
		});
		
		JButton reiniciarBtn = new JButton("REINICIAR");
		reiniciarBtn.setBackground(Color.decode("#303030"));
		reiniciarBtn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		reiniciarBtn.setForeground(Color.white);
		panelBotones.add(reiniciarBtn, BorderLayout.SOUTH);
		
		reiniciarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciarLaberinto();
			}
		});
		
		//POSICIÓN INICIAL (IMAGEN)
		try {
			characterImage = ImageIO.read(getClass().getResource("upAntImg.png"));
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return panelLaberinto1;
	}
	
	
	//laberinto 2, nivel 2, Minecraft
	private JPanel laberinto2() {
		tiempoValorLbl = new JLabel("00:00:00:00");
		tiempoValorLbl.setBackground(Color.decode("#303030"));
		tiempoValorLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		tiempoValorLbl.setForeground(Color.white);
		tiempoValorLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		tiempoValorLbl.setOpaque(true);
		frame.getContentPane().add(tiempoValorLbl, BorderLayout.NORTH);
		
		//crear Steve y obstáculos
		jugador = new Jugador(240, 320, 32, 62, Color.decode("#00A2E8"));
		sombra = new Jugador(jugador.x, jugador.y, jugador.w, jugador.h, Color.decode("#00A2E8"));
		
		obstaculos2.add(new Jugador(0, 120, 20, 750, Color.decode("#C48B54")));
		
		//panel para pintar
		panelLaberinto2 = new PaintPanel();
		panelLaberinto2.setFocusable(true);
		panelLaberinto2.requestFocus();
		panelLaberinto2.addKeyListener(this);
		panelLaberinto2.setLayout(new BorderLayout(10, 10));
		panelLaberinto2.setLocation(0, 0);
		panelLaberinto2.setOpaque(true);
		panelLaberinto2.setSize(500, 500);
		frame.getContentPane().add(panelLaberinto2, BorderLayout.CENTER);
		
		//pie página con botones
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));
		panelBotones.setOpaque(false);
		frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		JButton nivel1IrBtn = new JButton("NIVEL 1");
		nivel1IrBtn.setBackground(Color.decode("#303030"));
		nivel1IrBtn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		nivel1IrBtn.setForeground(Color.white);
		panelBotones.add(nivel1IrBtn, BorderLayout.SOUTH);
		
		//ir al nivel 1
		nivel1IrBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nivelActual = 1;
				manejadorVentanas(nivelActual);
				reiniciarLaberinto();
			}
			
		});
		
		JButton reiniciarBtn = new JButton("REINICIAR");
		reiniciarBtn.setBackground(Color.decode("#303030"));
		reiniciarBtn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		reiniciarBtn.setForeground(Color.white);
		panelBotones.add(reiniciarBtn, BorderLayout.SOUTH);
		
		reiniciarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciarLaberinto();
			}
		});
		
		//POSICIÓN INICIAL (IMAGEN)
		try {
			characterImage = ImageIO.read(getClass().getResource("idleSteveImg.png"));
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return panelLaberinto2;
	}
	
	
	//manejador de ventanas
	public void manejadorVentanas(int ventanaBlanco){
		frame.getContentPane().removeAll();
		
		if(ventanaBlanco==1){ //laberinto 1 / nivel 1
			frame.add(this.laberinto1());
		}
		else if(ventanaBlanco==2){ //laberinto 2 / nivel 2
			frame.add(this.laberinto2());
		}
		
		frame.repaint();
		frame.revalidate();
	}
	
	
	//ACTUALIZAR ETIQUETA DE TEMPORIZADOR
	public void actualizarEtiqueta() {
		String tiempo = (hor<=9?"0":"")+hor+":" + (min<=9?"0":"")+min+":" + (seg<=9?"0":"")+seg+":" + (cen<=9?"0":"")+cen;
		tiempoValorLbl.setText(tiempo);
	}
	
	
	//TEMPORIZADOR (ETIQUETA)
	public void temporizador() {
		tempActivo = true;
		
		temporizador = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		reanudarTemp(); //cronómetro de tiempo
		movimientoAuto.start(); //hilo para movimiento automático
		
		teclaPresionada = e.getKeyCode();
		
		//saber en que nivel se encuentra el jugador
		if(nivelActual==1) {
			panelLaberinto1.repaint();
		}else {
			panelLaberinto2.repaint();
		}
		
		actualizar();
	}
	
	
	public void reiniciarLaberinto() {

		teclaPresionada = 0;
		
		//saber en que nivel se encuentra el jugador
		if(nivelActual==1) {
			//reiniciar valores en X y Y
			jugador.x = 468;
			jugador.y = 590;
			sombra.x = jugador.x;
			sombra.y = jugador.y;
			
			panelLaberinto1.repaint();
			panelLaberinto1.requestFocus();
			panelLaberinto1.setFocusable(true);
			
			//POSICIÓN INICIAL (IMAGEN)
			try {
				characterImage = ImageIO.read(getClass().getResource("upAntImg.png"));
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}else {
			//reiniciar valores en X y Y
			jugador.x = 200;
			jugador.y = 200;
			sombra.x = jugador.x;
			sombra.y = jugador.y;
			
			panelLaberinto2.repaint();
			panelLaberinto2.requestFocus();
			panelLaberinto2.setFocusable(true);
			
			//POSICIÓN INICIAL (IMAGEN)
			try {
				characterImage = ImageIO.read(getClass().getResource("idleSteveImg.png"));
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		reiniciarTemp();
		movimientoAuto.stop();
	}
	
	
	public void actualizar() {
		System.out.println(teclaPresionada);
		
		Boolean m = false; //'m' de Mover
												  
		//copiar los movimientos del jugador a su sombra actuales
		sombra.x = jugador.x;
		sombra.y = jugador.y;
		
		//W, FLECHA ARRIBA
		if(teclaPresionada==87 || teclaPresionada==38) { 
			System.out.println(teclaPresionada + " Arriba");
			
			//si Y es menor al límite del JFrame choca contra la pared
			if(jugador.y>0) {
				jugador.y -= 2;
			}
			
			//saber en que nivel se encuentra el jugador
			if(nivelActual==1) {
				//cambiar imagen del personaje (Hormiga)
				try {
					BufferedImage upImg = ImageIO.read(getClass().getResource("upAntImg.png"));
					characterImage = upImg;
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				//cambiar imagen del personaje (Steve)
				try {
					BufferedImage upImg = ImageIO.read(getClass().getResource("upSteveImg.png"));
					characterImage = upImg;
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		//A, FLECHA IZQUIERDA
		else if(teclaPresionada==65 || teclaPresionada==37) { 
			System.out.println(teclaPresionada + " Izquierda");
			
			//si X es menor al límite del JFrame choca contra la pared
			if(jugador.x>0) {
				jugador.x -= 2;
			}
			
			//saber en que nivel se encuentra el jugador
			if(nivelActual==1) {
				//cambiar imagen del personaje (Hormiga)
				try {
					BufferedImage upImg = ImageIO.read(getClass().getResource("leftAntImg.png"));
					characterImage = upImg;
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				//cambiar imagen del personaje (Steve)
				try {
					BufferedImage upImg = ImageIO.read(getClass().getResource("leftSteveImg.png"));
					characterImage = upImg;
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		//S, FLECHA ABAJO
		else if(teclaPresionada==83 || teclaPresionada==40) { 
			System.out.println(teclaPresionada + " Abajo");
			
			//si Y es mayor al límite del JFrame choca contra la pared
			if(jugador.y+jugador.h<660) {
				jugador.y += 2;
			}
			
			//saber en que nivel se encuentra el jugador
			if(nivelActual==1) {
				//cambiar imagen del personaje (Hormiga)
				try {
					BufferedImage upImg = ImageIO.read(getClass().getResource("downAntImg.png"));
					characterImage = upImg;
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				//cambiar imagen del personaje (Steve)
				try {
					BufferedImage upImg = ImageIO.read(getClass().getResource("downSteveImg.png"));
					characterImage = upImg;
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		//D, FLECHA DERECHA
		else if(teclaPresionada==68 || teclaPresionada==39) { 
			System.out.println(teclaPresionada + " Derecha");
			
			//si X es mayor al límite del JFrame choca contra la pared
			if(jugador.x+jugador.w<530) {
				jugador.x += 2;
			}
			
			//saber en que nivel se encuentra el jugador
			if(nivelActual==1) {
				//cambiar imagen del personaje (Hormiga)
				try {
					BufferedImage upImg = ImageIO.read(getClass().getResource("rightAntImg.png"));
					characterImage = upImg;
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				//cambiar imagen del personaje (Steve)
				try {
					BufferedImage upImg = ImageIO.read(getClass().getResource("rightSteveImg.png"));
					characterImage = upImg;
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		//validar colisiones
		//saber en que nivel se encuentra el jugador
		if(nivelActual==1) {
			for(Jugador obst: obstaculos1) {
				if(jugador.colision(obst)) { //si existe colisión
					m = true;
					System.out.println("Colisión");
				}
			}
		}else {
			for(Jugador obst: obstaculos2) {
				if(jugador.colision(obst)) { //si existe colisión
					m = true;
					System.out.println("Colisión");
				}
			}
		}
		
		//copiar valores en X y Y
		if (!m) { //si no hay colisión
            sombra.x = jugador.x;
            sombra.y = jugador.y;
        }else { //si existe colisión
      
        	//W, FLECHA ARRIBA
        	if(teclaPresionada==87 || teclaPresionada==38) { 
        		jugador.x = sombra.x;
        		jugador.y = sombra.y+2; //rebote del jugador para indicar que chocó
        	}
        	//A, FLECHA IZQUIERDA
        	if(teclaPresionada==65 || teclaPresionada==37) { 
        		jugador.x = sombra.x+2; //rebote del jugador para indicar que chocó
        		jugador.y = sombra.y;
    		}
        	//S, FLECHA ABAJO
    		if(teclaPresionada==83 || teclaPresionada==40) { 
    			jugador.x = sombra.x;
        		jugador.y = sombra.y-2; //rebote del jugador para indicar que chocó
    		}
    		//D, FLECHA DERECHA
    		if(teclaPresionada==68 || teclaPresionada==39) { 
    			jugador.x = sombra.x-10; //rebote del jugador para indicar que chocó
        		jugador.y = sombra.y;
    		}
        }
		
		//saber en que nivel se encuentra el jugador
		if(nivelActual==1) {
			panelLaberinto1.repaint();
		}else {
			panelLaberinto2.repaint();
		}
		
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
			 
			 if(nivelActual==1) {
				 g2.setColor(Color.decode("#8BDCED")); //cielo de fondo (decoración sin colisión)
				 g2.fillRect(0, 0, 550, 120);
				 g2.setColor(Color.decode("#C18851")); //fondo de tierra (decoración sin colisión)
				 g2.fillRect(0, 120, 550, 520);
				 g2.setColor(Color.decode("#EEFCFF")); //nubes de fondo (decoración sin colisión)
				 g2.fillOval(50, 50, 50, 30); 
				 g2.fillOval(65, 30, 50, 30); 
				 g2.fillOval(80, 50, 50, 30); 
				 g2.fillOval(230, 35, 40, 20); 
				 g2.fillOval(245, 25, 40, 20); 
				 g2.fillOval(260, 35, 40, 20); 
				 g2.fillOval(430, 60, 50, 30); 
				 g2.fillOval(445, 40, 50, 30); 
				 g2.fillOval(460, 60, 50, 30); 
				 
				 //jugador hormiga
				 g2.drawImage(characterImage, jugador.x, jugador.y, jugador.w, jugador.h, null, null); //imagen de personaje
				 
				 //paredes y obstáculos hormiguero
				 for(Jugador pared: obstaculos1) {
					 g2.setColor(pared.color);
					 g2.fillRect(pared.x, pared.y, pared.w, pared.h);
				 } 
			 }else {
				 //jugador Steve
				 g2.drawImage(characterImage, jugador.x, jugador.y, jugador.w, jugador.h, null, null); //imagen de personaje
				 
				 //paredes y obstáculos minecraft
				 for(Jugador pared: obstaculos2) {
					 g2.setColor(pared.color);
					 g2.fillRect(pared.x, pared.y, pared.w, pared.h);
				 } 
			 }
		 }
	}
	
	
	//clase Jugador/Obstáculo
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
		
		public Boolean colision(Jugador blanco) {
			if (this.x < blanco.x + blanco.w &&
		            this.x + this.w > blanco.x &&
		            this.y < blanco.y + blanco.h &&
		            this.y + this.h > blanco.y) {
		            return true;
		    }else {
		    	return false;
		    }
		}

	}

}
