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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.Image;
import java.awt.RenderingHints;

public class ListenerTeclado implements KeyListener{

	private JFrame frame;
	
	PaintPanel panelLaberinto1, panelLaberinto2;
	Graphics2D g2;
	BufferedImage characterImage;
	Image image;
	ImageIcon imageIcon;
	
	Color rosa = Color.decode("#E35554");
	Color cafe = Color.decode("#8B5728");
	
	Jugador jugador = null;
	Jugador sombra = null;
	ArrayList<Jugador> obstaculos1 = new ArrayList<Jugador>(); //Paredes
	ArrayList<Jugador> obstaculos2 = new ArrayList<Jugador>(); //Paredes
	
	JLabel tiempoValorLbl;
	Timer temporizador, movimientoAuto;
	int teclaPresionada = 0;
	int nivelActual = 1;
	boolean tempActivo = false;
	int hor, min, seg;
	String mensaje;

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
		imageIcon = new ImageIcon(getClass().getResource("mazeIcon.png"));
		frame.setIconImage(imageIcon.getImage());
		frame.setTitle("Laberinto");;
		frame.setBounds(100, 100, 550, 750);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this.laberinto1(), BorderLayout.CENTER);
		
		temporizador = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seg++;
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
		
		movimientoAuto = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
    			actualizar();
			}
			
		});   
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	//laberinto 1, nivel 1, Cerebro de Mojo Jojo
	private JPanel laberinto1() {
		JPanel panelEtiquetas = new JPanel();
		panelEtiquetas.setLayout(new GridLayout(1, 2));
		panelEtiquetas.setOpaque(false);
		frame.getContentPane().add(panelEtiquetas, BorderLayout.NORTH);
		
		JLabel nivel1Lbl = new JLabel("Nivel 1: Cerebro de Mojo Jojo");
		nivel1Lbl.setBackground(Color.decode("#303030"));
		nivel1Lbl.setFont(new Font("Tahoma", Font.BOLD, 16)); //fuente, tipo y tamaño
		nivel1Lbl.setForeground(Color.white);
		nivel1Lbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		nivel1Lbl.setOpaque(true);
		panelEtiquetas.add(nivel1Lbl);
		
		tiempoValorLbl = new JLabel("00:00:00");
		tiempoValorLbl.setBackground(Color.decode("#303030"));
		tiempoValorLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		tiempoValorLbl.setForeground(Color.white);
		tiempoValorLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		tiempoValorLbl.setOpaque(true);
		panelEtiquetas.add(tiempoValorLbl, BorderLayout.NORTH);
		
		//crear neurona y obstáculos
		jugador = new Jugador(85, 205, 15, 13, Color.decode("#00A2E8"));
		sombra = new Jugador(jugador.x, jugador.y, jugador.w, jugador.h, Color.decode("#00A2E8"));
		
		obstaculos1.add(new Jugador(330, 339, 15, 13, Color.yellow)); //meta
		
		obstaculos1.add(new Jugador(72, 195, 389, 10, Color.decode("#B3A5D8"))); //bordes de metal en el cráneo
		obstaculos1.add(new Jugador(72, 195, 10, 343, Color.decode("#B3A5D8")));
		obstaculos1.add(new Jugador(75, 530, 387, 10, Color.decode("#B3A5D8")));
		obstaculos1.add(new Jugador(453, 195, 10, 345, Color.decode("#B3A5D8")));
		
		//CEREBRO
		obstaculos1.add(new Jugador(259, 204, 10, 160, rosa)); //hemisferio izquierdo
		obstaculos1.add(new Jugador(259, 383, 10, 146, rosa));
		obstaculos1.add(new Jugador(102, 224, 10, 60, rosa)); 
		obstaculos1.add(new Jugador(102, 274, 60, 10, rosa)); 
		obstaculos1.add(new Jugador(152, 274, 10, 160, rosa)); 
		obstaculos1.add(new Jugador(181, 224, 10, 70, rosa)); 
		obstaculos1.add(new Jugador(210, 253, 55, 10, rosa)); 
		obstaculos1.add(new Jugador(131, 243, 60, 10, rosa)); 
		obstaculos1.add(new Jugador(181, 354, 87, 10, rosa)); 
		obstaculos1.add(new Jugador(181, 313, 10, 50, rosa)); 
		obstaculos1.add(new Jugador(181, 313, 60, 10, rosa)); 
		obstaculos1.add(new Jugador(231, 284, 10, 50, rosa)); 
		obstaculos1.add(new Jugador(210, 284, 30, 10, rosa)); 
		obstaculos1.add(new Jugador(210, 224, 10, 38, rosa)); 
		obstaculos1.add(new Jugador(210, 224, 30, 10, rosa)); 
		obstaculos1.add(new Jugador(131, 224, 10, 28, rosa)); 
		obstaculos1.add(new Jugador(102, 303, 10, 70, rosa)); 
		obstaculos1.add(new Jugador(102, 303, 30, 10, rosa)); 
		obstaculos1.add(new Jugador(102, 363, 30, 10, rosa)); 
		obstaculos1.add(new Jugador(181, 383, 87, 10, rosa));
		obstaculos1.add(new Jugador(102, 393, 27, 10, rosa));
		obstaculos1.add(new Jugador(102, 393, 10, 118, rosa));
		obstaculos1.add(new Jugador(102, 501, 138, 10, rosa));
		obstaculos1.add(new Jugador(131, 472, 132, 10, rosa));
		obstaculos1.add(new Jugador(181, 383, 10, 70, rosa));
		obstaculos1.add(new Jugador(181, 443, 60, 10, rosa));
		obstaculos1.add(new Jugador(231, 413, 10, 40, rosa));
		obstaculos1.add(new Jugador(211, 413, 30, 10, rosa));
		obstaculos1.add(new Jugador(131, 455, 10, 25, rosa));
		
		obstaculos1.add(new Jugador(424, 224, 10, 286, rosa)); //hemisferio derecho
		obstaculos1.add(new Jugador(396, 224, 38, 10, rosa));
		obstaculos1.add(new Jugador(374, 274, 10, 160, rosa));
		obstaculos1.add(new Jugador(345, 224, 10, 70, rosa));
		obstaculos1.add(new Jugador(261, 253, 55, 10, rosa));
		obstaculos1.add(new Jugador(345, 243, 60, 10, rosa));
		obstaculos1.add(new Jugador(258, 354, 97, 10, rosa));
		obstaculos1.add(new Jugador(345, 313, 10, 50, rosa));
		obstaculos1.add(new Jugador(291, 313, 90, 10, rosa));
		obstaculos1.add(new Jugador(290, 284, 10, 50, rosa));
		obstaculos1.add(new Jugador(291, 284, 63, 10, rosa));
		obstaculos1.add(new Jugador(306, 224, 10, 38, rosa));
		obstaculos1.add(new Jugador(286, 224, 30, 10, rosa));
		obstaculos1.add(new Jugador(395, 224, 10, 28, rosa));
		obstaculos1.add(new Jugador(404, 303, 30, 10, rosa));
		obstaculos1.add(new Jugador(404, 363, 30, 10, rosa));
		obstaculos1.add(new Jugador(258, 383, 97, 10, rosa));
		obstaculos1.add(new Jugador(407, 393, 27, 10, rosa));
		obstaculos1.add(new Jugador(288, 501, 145, 10, rosa));
		obstaculos1.add(new Jugador(263, 472, 142, 10, rosa));
		obstaculos1.add(new Jugador(345, 383, 10, 70, rosa));
		obstaculos1.add(new Jugador(291, 443, 62, 10, rosa));
		obstaculos1.add(new Jugador(291, 413, 10, 40, rosa));
		obstaculos1.add(new Jugador(291, 413, 25, 10, rosa));
		obstaculos1.add(new Jugador(395, 455, 10, 25, rosa));

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
		nivel2IrBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		nivel2IrBtn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		nivel2IrBtn.setForeground(Color.white);
		panelBotones.add(nivel2IrBtn, BorderLayout.SOUTH);
		
		//ir al nivel 2
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
		reiniciarBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
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
			characterImage = ImageIO.read(getClass().getResource("neuron.png"));
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return panelLaberinto1;
	}
	
	
	//laberinto 2, nivel 2, hormiguero
	private JPanel laberinto2() {
		JPanel panelEtiquetas = new JPanel();
		panelEtiquetas.setLayout(new GridLayout(1, 2));
		panelEtiquetas.setOpaque(false);
		frame.getContentPane().add(panelEtiquetas, BorderLayout.NORTH);
		
		JLabel nivel2Lbl = new JLabel("Nivel 2: Hormiguero");
		nivel2Lbl.setBackground(Color.decode("#303030"));
		nivel2Lbl.setFont(new Font("Tahoma", Font.BOLD, 16)); //fuente, tipo y tamaño
		nivel2Lbl.setForeground(Color.white);
		nivel2Lbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		nivel2Lbl.setOpaque(true);
		panelEtiquetas.add(nivel2Lbl);
		
		tiempoValorLbl = new JLabel("00:00:00");
		tiempoValorLbl.setBackground(Color.decode("#303030"));
		tiempoValorLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		tiempoValorLbl.setForeground(Color.white);
		tiempoValorLbl.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		tiempoValorLbl.setOpaque(true);
		panelEtiquetas.add(tiempoValorLbl);
		
		//crear hormiga y obstáculos
		jugador = new Jugador(27, 50, 35, 35, Color.decode("#00A2E8"));
		sombra = new Jugador(jugador.x, jugador.y, jugador.w, jugador.h, Color.decode("#00A2E8"));
		
		obstaculos2.add(new Jugador(453, 598, 62, 40, Color.yellow)); //meta
		
		obstaculos2.add(new Jugador(0, 130, 20, 527, cafe)); //tierra bordes
		obstaculos2.add(new Jugador(-10, 638, 545, 20, cafe));
		obstaculos2.add(new Jugador(515, 130, 20, 527, cafe));
		obstaculos2.add(new Jugador(69, 119, 470, 20, cafe)); 
		obstaculos2.add(new Jugador(0, 120, 20, 20, cafe));
		obstaculos2.add(new Jugador(397, 577, 120, 20, cafe)); //paredes internas
		obstaculos2.add(new Jugador(397, 517, 20, 60, cafe));
		obstaculos2.add(new Jugador(379, 497, 38, 20, cafe));
		obstaculos2.add(new Jugador(270, 490, 20, 40, cafe));
		obstaculos2.add(new Jugador(340, 557, 20, 41, cafe));
		obstaculos2.add(new Jugador(360, 557, 40, 20, cafe));
		obstaculos2.add(new Jugador(169, 578, 172, 20, cafe));
		obstaculos2.add(new Jugador(205, 538, 20, 40, cafe));
		obstaculos2.add(new Jugador(110, 547, 20, 91, cafe));
		obstaculos2.add(new Jugador(51, 498, 20, 100, cafe));
		obstaculos2.add(new Jugador(59, 578, 62, 20, cafe));
		obstaculos2.add(new Jugador(0, 180, 121, 20, cafe));
		obstaculos2.add(new Jugador(110, 180, 20, 257, cafe));
		obstaculos2.add(new Jugador(169, 139, 20, 182, cafe));
		obstaculos2.add(new Jugador(169, 370, 20, 110, cafe));
		obstaculos2.add(new Jugador(248, 180, 228, 20, cafe));
		obstaculos2.add(new Jugador(228, 239, 248, 20, cafe));
		obstaculos2.add(new Jugador(456, 239, 20, 150, cafe));
		obstaculos2.add(new Jugador(397, 259, 20, 60, cafe));
		obstaculos2.add(new Jugador(338, 298, 20, 140, cafe));
		obstaculos2.add(new Jugador(228, 368, 70, 20, cafe));
		obstaculos2.add(new Jugador(348, 378, 60, 20, cafe));
		obstaculos2.add(new Jugador(288, 298, 70, 20, cafe));
		obstaculos2.add(new Jugador(228, 180, 20, 60, cafe));
		obstaculos2.add(new Jugador(228, 298, 20, 180,cafe));
		obstaculos2.add(new Jugador(20, 478, 290, 20, cafe));
		obstaculos2.add(new Jugador(310, 438, 20, 60, cafe));
		obstaculos2.add(new Jugador(330, 438, 146, 20, cafe));
		obstaculos2.add(new Jugador(456, 458, 20, 71, cafe));
		obstaculos2.add(new Jugador(20, 240, 50, 20, cafe));
		obstaculos2.add(new Jugador(60, 299, 50, 20, cafe));
		obstaculos2.add(new Jugador(20, 358, 50, 20, cafe));
		obstaculos2.add(new Jugador(60, 417, 50, 20, cafe));
		
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
		nivel1IrBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
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
		reiniciarBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
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
		String tiempo = (hor<=9?"0":"")+hor+":" + (min<=9?"0":"")+min+":" + (seg<=9?"0":"")+seg;
		tiempoValorLbl.setText(tiempo);
	}
	
	
	//TEMPORIZADOR (ETIQUETA)
	public void temporizador() {
		tempActivo = true; 
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
		tiempoValorLbl.setText("00:00:00");
		hor = 0; min = 0; seg = 0;
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		//indicar al jugador la meta
		if(teclaPresionada==0 && nivelActual==1) {
			image = new ImageIcon(getClass().getResource("neuron2.png")).getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(image);
			
			mensaje = "Reúnete con la neurona de color verde.";
            JOptionPane.showMessageDialog(null, mensaje, "Meta", JOptionPane.INFORMATION_MESSAGE, imageIcon); //ventana emergente
		}
		else if(teclaPresionada==0 && nivelActual==2) {
			image = new ImageIcon(getClass().getResource("grains.png")).getImage().getScaledInstance(100, 68, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(image);
		
			mensaje = "<html> Hormiga, lleva la semilla de Alpiste <br> al almacén de comida. </html>";
            JOptionPane.showMessageDialog(null, mensaje, "Meta", JOptionPane.INFORMATION_MESSAGE, imageIcon); //ventana emergente
		}
		
		teclaPresionada = e.getKeyCode(); //saber que tecla se ha presionado
		reanudarTemp(); //cronómetro de tiempo
		movimientoAuto.start(); //hilo para movimiento automático
	}
	
	
	public void reiniciarLaberinto() {
		teclaPresionada = 0;
		
		//saber en que nivel se encuentra el jugador
		if(nivelActual==1) {
			//reiniciar valores en X y Y
			jugador.x = 85;
			jugador.y = 205;
			sombra.x = jugador.x;
			sombra.y = jugador.y;
			
			panelLaberinto1.repaint();
			panelLaberinto1.requestFocus();
			panelLaberinto1.setFocusable(true);
			
		}else {
			//reiniciar valores en X y Y
			jugador.x = 27;
			jugador.y = 50;
			sombra.x = jugador.x;
			sombra.y = jugador.y;
			
			panelLaberinto2.repaint();
			panelLaberinto2.requestFocus();
			panelLaberinto2.setFocusable(true);
			

			//POSICIÓN INICIAL (IMAGEN)
			try {
				characterImage = ImageIO.read(getClass().getResource("upAntImg.png"));
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		reiniciarTemp();
		movimientoAuto.stop();
	}
	
	
	public void actualizar() {
		Boolean m = false; //'m' de Mover
												  
		//copiar los movimientos actuales del jugador a su sombra 
		sombra.x = jugador.x;
		sombra.y = jugador.y;
		
		//W, FLECHA ARRIBA
		if(teclaPresionada==87 || teclaPresionada==38) { 
			System.out.println(teclaPresionada + " Arriba");
			
			//si Y es menor al límite del JFrame choca contra la pared
			if(jugador.y>0) {
				jugador.y -= 4;
			}else {
				jugador.y += 1; //rebote del jugador para indicar que chocó con el borde
			}
			
			//saber en que nivel se encuentra el jugador
			if(nivelActual==1) {
				//cambiar imagen del personaje (Neurona)
				try {
					characterImage = ImageIO.read(getClass().getResource("neuron.png"));
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				//cambiar imagen del personaje (Hormiga)
				try {
					characterImage = ImageIO.read(getClass().getResource("upAntImg.png"));
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
				jugador.x -= 4;
			}else {
				jugador.x += 1; //rebote del jugador para indicar que chocó con el borde
			}
			
			//saber en que nivel se encuentra el jugador
			if(nivelActual==1) {
				//cambiar imagen del personaje (Neurona)
				try {
					characterImage = ImageIO.read(getClass().getResource("neuron.png"));
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				//cambiar imagen del personaje (Hormiga)
				try {
					characterImage = ImageIO.read(getClass().getResource("leftAntImg.png"));
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
				jugador.y += 4;
			}else {
				jugador.y -= 1; //rebote del jugador para indicar que chocó con el borde
			}
			
			//saber en que nivel se encuentra el jugador
			if(nivelActual==1) {
				//cambiar imagen del personaje (Neurona)
				try {
					characterImage = ImageIO.read(getClass().getResource("neuron.png"));
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				//cambiar imagen del personaje (Hormiga)
				try {
					characterImage = ImageIO.read(getClass().getResource("downAntImg.png"));
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		//D, FLECHA DERECHA
		else if(teclaPresionada==68 || teclaPresionada==39) { 
			System.out.println(teclaPresionada + " Derecha");
			
			//si X es mayor al límite del JFrame choca contra la pared
			if(jugador.x+jugador.w<535) {
				jugador.x += 4;
			}else {
				jugador.x -= 1; //rebote del jugador para indicar que chocó con el borde
			}
			
			//saber en que nivel se encuentra el jugador
			if(nivelActual==1) {
				//cambiar imagen del personaje (Neurona)
				try {
					characterImage = ImageIO.read(getClass().getResource("neuron.png"));
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else {
				//cambiar imagen del personaje (Hormiga)
				try {
					characterImage = ImageIO.read(getClass().getResource("rightAntImg.png"));
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		//VALIDAR COLISIONES
		//saber en que nivel se encuentra el jugador
		if(nivelActual==1) {
			for(Jugador obst: obstaculos1) {
				if(jugador.colision(obst)) { //si existe colisión
					m = true;
					System.out.println("Colisión");
					
					//si colisiona con la meta (neurona 2)
					if(obst.getColor().equals(Color.yellow)){
						detenerTemp();
						image = new ImageIcon(getClass().getResource("celebrationIcon.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
						imageIcon = new ImageIcon(image);
						mensaje = "<html> ¡¡Has llegado a la meta!! :D <br> Tiempo en llegar a la meta: <br> </html>" + tiempoValorLbl.getText(); 
						JOptionPane.showMessageDialog(null, mensaje, "Laberinto 1 resuelto", JOptionPane.INFORMATION_MESSAGE, imageIcon); //ventana emergente
						teclaPresionada = 0;
						reiniciarTemp();
						movimientoAuto.stop();
						reiniciarLaberinto();
					}
				}
			}
			
		}else {
			for(Jugador obst: obstaculos2) {
				if(jugador.colision(obst)) { //si existe colisión
					m = true;
					System.out.println("Colisión");
					
					//si colisiona con la meta (granos)
					if(obst.getColor().equals(Color.yellow)){
						detenerTemp();
						image = new ImageIcon(getClass().getResource("celebrationIcon.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
						imageIcon = new ImageIcon(image);
						mensaje = "<html> ¡¡Has llegado a la meta!! :D <br> Tiempo en llegar a la meta: <br> </html>" + tiempoValorLbl.getText(); 
						JOptionPane.showMessageDialog(null, mensaje, "Laberinto 2 resuelto", JOptionPane.INFORMATION_MESSAGE, imageIcon); //ventana emergente
						teclaPresionada = 0;
						reiniciarTemp();
						movimientoAuto.stop();
						reiniciarLaberinto();
					}
				}
			}
		}
		
		//COPIAR VALORES DE 'X' Y 'Y'
		if (!m) { //si no hay colisión
            sombra.x = jugador.x;
            sombra.y = jugador.y;
            
        }else { //si existe colisión
        	//W, FLECHA ARRIBA
        	if(teclaPresionada==87 || teclaPresionada==38) { 
        		jugador.x = sombra.x;
        		jugador.y = sombra.y+1; //rebote del jugador para indicar que chocó
        	}
        	//A, FLECHA IZQUIERDA
        	if(teclaPresionada==65 || teclaPresionada==37) { 
        		jugador.x = sombra.x+1; //rebote del jugador para indicar que chocó
        		jugador.y = sombra.y;
    		}
        	//S, FLECHA ABAJO
    		if(teclaPresionada==83 || teclaPresionada==40) { 
    			jugador.x = sombra.x;
        		jugador.y = sombra.y-1; //rebote del jugador para indicar que chocó
    		}
    		//D, FLECHA DERECHA
    		if(teclaPresionada==68 || teclaPresionada==39) { 
    			jugador.x = sombra.x-1; //rebote del jugador para indicar que chocó
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
			 this.setBackground(Color.decode("#3FA9E2"));
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g2 = (Graphics2D) g;
		
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //suavizar bordes
			BufferedImage meta;
			
			if(nivelActual==1) {
				//CUERPO 
				g2.setColor(Color.decode("#613453")); //capa
				g2.fillRoundRect(-10, 340, 550, 200, 150, 150);
				g2.setColor(Color.decode("#2D568C")); //fondo (decoración sin colisión)
				g2.fillOval(-60, 180, 650, 350);
				
				//BARBILLA 
				g2.setColor(Color.black); //borde
				g2.fillRoundRect(170, 34, 194, 139, 180, 180);
				g2.setColor(Color.decode("#B0E825")); //color piel
				g2.fillRoundRect(172, 36, 190, 135, 180, 180);
				
				//DIENTES
				g2.setColor(Color.black); //fondo de la boca
				g2.fillOval(204, 42, 127, 87);
				g2.setColor(Color.white); //color blanco
				g2.fillOval(215, 60, 25, 45);
				g2.fillOval(235, 48, 25, 45);
				g2.fillOval(255, 48, 25, 45);
				g2.fillOval(275, 48, 25, 45);
				g2.fillOval(295, 60, 25, 45);
				
				//BORDE DE LA NARIZ
				g2.setColor(Color.black);
				g2.fillOval(225, 60, 84, 54);
				
				//OREJAS
				g2.setColor(Color.black); //borde
				g2.fillOval(0, 298, 64, 124);
				g2.fillOval(470, 298, 64, 124);
				g2.setColor(Color.decode("#B0E825")); //color piel
				g2.fillOval(2, 300, 60, 120);
				g2.fillOval(472, 300, 60, 120);
				
				//CABEZA
				g2.setColor(Color.black); //borde
				g2.fillRoundRect(55, 83, 424, 274, 300, 300);
				g2.setColor(Color.decode("#B0E825")); //color piel
				g2.fillOval(27, 80, 480, 575);
				g2.setColor(Color.black); //borde
				g2.fillOval(25, 78, 484, 579);
				g2.setColor(Color.decode("#B0E825")); //color piel
				g2.fillRoundRect(72, 90, 390, 260, 300, 300);
				
				//NARIZ
				g2.setColor(Color.decode("#B0E825")); //color piel
				g2.fillOval(227, 62, 80, 50);
				g2.setColor(Color.black); //narinas
				g2.setStroke(new BasicStroke(2));
				g2.drawArc(226, 64, 40, 40, 0, -180);
				g2.drawArc(266, 64, 41, 40, 0, -180);
				
				//ESCLERÓTICAS
				g2.setColor(Color.black); //borde negro
				g2.fillOval(125, 128, 124, 84);
				g2.fillOval(285, 128, 124, 84);
				g2.setColor(Color.decode("#F6ACDD")); //color blanco
				g2.fillOval(127, 130, 120, 80);
				g2.fillOval(287, 130, 120, 80);
				
				//IRIS
				g2.setColor(Color.decode("#AB4D03")); //color café
				g2.fillOval(164, 145, 30, 30);
				g2.fillOval(340, 145, 30, 30);
				
				//PUPILAS
				g2.setColor(Color.black); //color negro
				g2.fillOval(169, 150, 20, 20);
				g2.fillOval(345, 150, 20, 20);
				
				//CEJAS
				g2.setColor(Color.black); //borde
				g2.setStroke(new BasicStroke(50));
				g2.drawLine(107, 210, 250, 160);
				g2.drawLine(280, 160, 423, 210);
				g2.fillRect(200, 160, 120, 210);//613453
				
				//DETALLES DEL CASCO
				g2.setColor(Color.decode("#613453")); //fondo
				g2.fillOval(140, 180, 60, 30);
				g2.fillOval(234, 180, 60, 30);
				g2.fillOval(328, 180, 60, 30);
				
				//FONDO DEL CEREBRO
				g2.setColor(Color.decode("#F6ACDD")); //fondo
				g2.fillRect(82, 203, 372, 330);
				
				//NEURONA 1 (JUGADOR)
				g2.drawImage(characterImage, jugador.x, jugador.y, jugador.w, jugador.h, null, null); //imagen de personaje
				
				//PAREDES DEL CEREBRO DE MOJO JOJO
				for(Jugador pared: obstaculos1) {
					g2.setColor(pared.color);
					g2.fillRoundRect(pared.x, pared.y, pared.w, pared.h, 10, 10);
				} 

				//META (NEURONA 2)
				try {
					meta = ImageIO.read(getClass().getResource("neuron2.png"));
					g2.drawImage(meta, 330, 339, 15, 13, Color.decode("#F6ACDD"), null); //imagen de meta
				}catch (IOException ex) {
					ex.printStackTrace();
				}
				
			}else {
				//MONTÍCULO DE TIERRA (DECORACIÓN SIN COLISIÓN)
				g2.setColor(cafe); 
				g2.fillOval(5, 87, 81, 86); 
				
				//FONDO COLOR TIERRA (DECORACIÓN SIN COLISIÓN)
				g2.setColor(Color.decode("#C18851")); 
				g2.fillOval(8, 90, 75, 80);
				g2.fillRect(0, 132, 550, 520); 
				
				//HUEVOS DE HORMIGA (DECORACIÓN SIN COLISIÓN)
				g2.setColor(Color.white);
				g2.fillOval(248, 470, 12, 7);
				g2.fillOval(260, 470, 12, 7);
				g2.fillOval(248, 463, 12, 7);
				g2.fillOval(248, 456, 12, 7);
				g2.fillOval(272, 470, 12, 7);
				g2.fillOval(260, 463, 12, 7);
				g2.fillOval(286, 470, 12, 7);
				g2.fillOval(286, 463, 12, 7);
				g2.fillOval(298, 470, 12, 7);
				g2.fillOval(298, 463, 12, 7);
				g2.fillOval(298, 456, 12, 7);
				g2.fillOval(298, 449, 12, 7);
				
				//COMIDA (DECORACIÓN SIN COLISIÓN)
				g2.setColor(Color.orange);
				g2.fillOval(248, 232, 12, 7);
				g2.fillOval(260, 232, 12, 7);
				g2.fillOval(248, 225, 12, 7);
				g2.fillOval(248, 218, 12, 7);
				g2.setColor(Color.decode("#2F5841"));
				g2.fillOval(272, 232, 12, 7);
				g2.fillOval(260, 225, 12, 7);
				g2.fillOval(286, 232, 12, 7);
				g2.fillOval(286, 225, 12, 7);
				g2.fillOval(298, 232, 12, 7);
				g2.setColor(Color.decode("#8B7728"));
				g2.fillOval(298, 225, 12, 7);
				g2.fillOval(298, 218, 12, 7);
				g2.fillOval(310, 232, 12, 7);
				g2.setColor(Color.decode("#8B5341"));
				g2.fillOval(322, 232, 12, 7);
				g2.fillOval(310, 225, 12, 7);
				g2.fillOval(334, 232, 12, 7);
				g2.fillOval(322, 225, 12, 7);
				g2.setColor(Color.decode("#2B5721"));
				g2.fillOval(348, 232, 12, 7);
				g2.fillOval(348, 225, 12, 7);
				g2.fillOval(360, 232, 12, 7);
				g2.fillOval(360, 225, 12, 7);
				g2.fillOval(360, 218, 12, 7);
				
				//ROCAS (DECORACIÓN SIN COLISIÓN)
				g2.setColor(Color.decode("#241F33"));
				g2.fill3DRect(20, 471, 12, 7, true);
				g2.fill3DRect(32, 471, 12, 7, true);
				g2.fill3DRect(20, 464, 12, 7, true);
				g2.fill3DRect(20, 457, 12, 7, true);
				g2.fill3DRect(44, 471, 12, 7, true);
				g2.fill3DRect(32, 464, 12, 7, true);
				g2.fill3DRect(56, 471, 12, 7, true);
				g2.fill3DRect(56, 464, 12, 7, true);
				g2.fill3DRect(68, 471, 12, 7, true);
				
				//NUBES DE FONDO (DECORACIÓN SIN COLISIÓN)
				g2.setColor(Color.decode("#EEFCFF")); 
				g2.fillOval(50, 40, 50, 30); 
				g2.fillOval(65, 20, 50, 30); 
				g2.fillOval(80, 40, 50, 30); 
				g2.fillOval(200, 30, 40, 20); 
				g2.fillOval(215, 20, 40, 20); 
				g2.fillOval(230, 30, 40, 20); 
				g2.fillOval(290, 75, 40, 20); 
				g2.fillOval(305, 65, 40, 20); 
				g2.fillOval(320, 75, 40, 20);
				g2.fillOval(430, 60, 50, 30); 
				g2.fillOval(445, 40, 50, 30); 
				g2.fillOval(460, 60, 50, 30); 
				
				//FLORES (DECORACIÓN SIN COLISIÓN)
				g2.setColor(Color.decode("#9ED33B")); //tallos
				g2.drawLine(154, 87, 175, 124); 
				g2.drawLine(180, 92, 165, 124);
				g2.setColor(Color.red); //pétalos
				g2.fillOval(149, 76, 10, 18);
				g2.fillOval(145, 80, 18, 10);
				g2.fillOval(179, 82, 10, 18);
				g2.fillOval(175, 86, 18, 10);
				g2.setColor(Color.decode("#FFD13A")); //centros
				g2.fillOval(149, 80, 10, 10);
				g2.fillOval(179, 86, 10, 10);
				
				g2.setColor(Color.decode("#9ED33B")); //tallos
				g2.drawLine(274, 85, 295, 122); 
				g2.drawLine(300, 90, 285, 122);
				g2.setColor(Color.decode("#B36BEA")); //pétalos
				g2.fillOval(269, 74, 10, 18);
				g2.fillOval(265, 78, 18, 10);
				g2.fillOval(299, 80, 10, 18);
				g2.fillOval(295, 84, 18, 10);
				g2.setColor(Color.decode("#FFD13A")); //centros
				g2.fillOval(269, 78, 10, 10);
				g2.fillOval(299, 84, 10, 10);
				
				g2.setColor(Color.decode("#9ED33B")); //tallos
				g2.drawLine(394, 87, 415, 124); 
				g2.drawLine(420, 92, 405, 124);
				g2.setColor(Color.decode("#FF71EB")); //pétalos
				g2.fillOval(389, 76, 10, 18);
				g2.fillOval(385, 80, 18, 10);
				g2.fillOval(419, 82, 10, 18);
				g2.fillOval(415, 86, 18, 10);
				g2.setColor(Color.decode("#FFD13A")); //centros
				g2.fillOval(389, 80, 10, 10);
				g2.fillOval(419, 86, 10, 10);
				
				
				//JUGADOR HORMIGA
				g2.drawImage(characterImage, jugador.x, jugador.y, jugador.w, jugador.h, null); //imagen de personaje
				
				//PAREDES / OBSTÁCULOS DEL HORMIGUERO
				for(Jugador pared: obstaculos2) {
					g2.setColor(pared.color);
					g2.fillRect(pared.x, pared.y, pared.w, pared.h);
				} 
				
				//CÉSPED (DECORACIÓN SIN COLISIÓN)
				g2.setColor(Color.decode("#80D33B")); 
				g2.fillOval(-30, 112, 50, 14); 
				g2.fillOval(69, 112, 50, 14);
				g2.fillOval(114, 112, 50, 14); 
				g2.fillOval(164, 112, 50, 14);
				g2.fillOval(214, 112, 50, 14);
				g2.fillOval(264, 112, 50, 14); 
				g2.fillOval(314, 112, 50, 14); 
				g2.fillOval(364, 112, 50, 14); 
				g2.fillOval(414, 112, 50, 14); 
				g2.fillOval(464, 112, 50, 14); 
				g2.fillOval(514, 112, 50, 14); 
				g2.fillRect(69, 120, 466, 8);
				g2.fillRect(0, 120, 20, 8);
				
				//META (GRANOS)
				try {
					meta = ImageIO.read(getClass().getResource("grains.png"));
					g2.drawImage(meta, 453, 598, 62, 40, Color.decode("#C18851"), null); //imagen de meta
				}catch (IOException ex) {
					ex.printStackTrace();
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
			if (this.x < blanco.x + blanco.w && this.x + this.w > blanco.x &&
		        this.y < blanco.y + blanco.h && this.y + this.h > blanco.y) {
				return true;
		    }else {
		    	return false;
		    }
		}

	}

}