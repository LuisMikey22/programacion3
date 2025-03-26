package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class PuzzleNumerico {

	private JFrame frame;

	private JButton matrizBotones[][];
	int x, y;
	int numPos;
	
	JButton continuarJuego, detenerJuego, reiniciarTablero;
	
	String[] numeros = {"1",  "2",  "3",  "4",  "5",  "6",  "7",  "8", 
						"9", " ", "10", "12", "13", "14",  "11", "15" };
	
	String[][] ordenGanador = {{ "1",  "2",  "3",  "4"},
							   { "5",  "6",  "7",  "8"},
							   { "9", "10", "11", "12"},
							   {"13", "14", "15",  " "}};
	
	Random rand = new Random();
	
	List<String> lista;
	
	JLabel tiempoValorLbl;
	String tiempoValor;
	
	Timer temporizador;
	boolean tempActivo = false;
	private int hor, min, seg, cen;
	
	String mensaje;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleNumerico window = new PuzzleNumerico();
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
	public PuzzleNumerico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		ImageIcon puzzleIcon = new ImageIcon(getClass().getResource("puzzlePieceIcon.png")); //ícono de la ventana
		frame.setIconImage(puzzleIcon.getImage());
		
 		frame.setTitle("Rompecabezas numérico");
 		frame.setSize(880, 680); 
 		frame.setResizable(false);
 		frame.setLocationRelativeTo(null);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 		JPanel panelFondo = new JPanel();
		frame.getContentPane().add(panelFondo, BorderLayout.CENTER);
		panelFondo.setBackground(Color.black);
		panelFondo.setLayout(new BorderLayout());
		
		JPanel panelTablero = new JPanel();
		panelTablero.setSize(440, 440);
		panelTablero.setLocation(89, 100);
		panelTablero.setBackground(new Color(31, 18, 5, 155));
		panelTablero.setLayout(new GridLayout(4, 4, 8, 8));
		panelFondo.add(panelTablero, BorderLayout.CENTER);
		
		Image imageBoard = new ImageIcon(getClass().getResource("woodenBoard.png")).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon imageBoardIcon = new ImageIcon(imageBoard);
		JLabel tableroFondoImg = new JLabel(imageBoardIcon);
		tableroFondoImg.setLocation(200, 90);
		panelFondo.add(tableroFondoImg);
		
		
		//barra lateral
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(Color.black);
		barraLateral.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		panelFondo.add(barraLateral, BorderLayout.EAST);
		
		
		//título
		JLabel puzzleLbl = new JLabel("<html> Rompecabezas <br> de 15 </html>");
		puzzleLbl.setForeground(Color.decode("#FFD09E"));
		puzzleLbl.setFont(new Font("Eras Demi ITC", Font.BOLD, 25)); //fuente, tipo y tamaño
		puzzleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 60);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 2;
		barraLateral.add(puzzleLbl, c);
	
		
		//temporizador
		tiempoValorLbl = new JLabel("00:00:00:00");
		tiempoValorLbl.setForeground(Color.decode("#FFD09E"));
		tiempoValorLbl.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		tiempoValorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(70, 0, 0, 60);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 20;
		barraLateral.add(tiempoValorLbl, c);
		
		
		//continuar juego / comenzar juego
		continuarJuego = new JButton("Iniciar");
		continuarJuego.setEnabled(true);
		continuarJuego.setBorder(null);
		continuarJuego.setBackground(new Color(63, 43, 24, 255));
		continuarJuego.setForeground(Color.decode("#FFD09E"));
		continuarJuego.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		continuarJuego.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(30, 0, 0, 60);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 20;
		barraLateral.add(continuarJuego, c);
		
		
		//detener juego 
		detenerJuego = new JButton("Detener");
		detenerJuego.setEnabled(false);
		detenerJuego.setBorder(null);
		detenerJuego.setBackground(new Color(63, 43, 24, 100));
		detenerJuego.setForeground(Color.decode("#FFD09E"));
		detenerJuego.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		detenerJuego.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 60);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 20;
		barraLateral.add(detenerJuego, c);
		
		
		//botón reiniciar tablero
		reiniciarTablero = new JButton("Reiniciar tablero");
		reiniciarTablero.setEnabled(false);
		reiniciarTablero.setBorder(null);
		reiniciarTablero.setBackground(new Color(63, 43, 24, 100));
		reiniciarTablero.setForeground(Color.decode("#FFD09E"));
		reiniciarTablero.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		reiniciarTablero.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		reiniciarTablero.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 60);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 20;
		barraLateral.add(reiniciarTablero, c);
		
		
		//agregar acción al botón de continuar juego
		continuarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(y=0; y<4; y++) { //renglon       	
			 		for(x=0; x<4; x++) { //columna
				 		matrizBotones[y][x].setEnabled(true);
			 		}
				}
				
				if(continuarJuego.getText().equals("Iniciar")) { //cambiar texto solo al inicio (una vez)
					continuarJuego.setText("Continuar");
				}
				
				continuarJuego.setEnabled(false);
				continuarJuego.setBackground(new Color(63, 43, 24, 100));
				
				detenerJuego.setEnabled(true);
				detenerJuego.setBackground(new Color(63, 43, 24, 255));
				
				reiniciarTablero.setEnabled(true);
				reiniciarTablero.setBackground(new Color(63, 43, 24, 255));
				
				barraLateral.validate();
				barraLateral.repaint();
				
				reanudarTemp();
			}
		});
		
		
		//agregar acción al botón de detener juego
		detenerJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(y=0; y<4; y++) { //renglon       	
			 		for(x=0; x<4; x++) { //columna
				 		matrizBotones[y][x].setEnabled(false);
			 		}
				}
				
				continuarJuego.setEnabled(true);
				continuarJuego.setBackground(new Color(63, 43, 24, 255));
				
				detenerJuego.setEnabled(false);
				detenerJuego.setBackground(new Color(63, 43, 24, 100));

				barraLateral.validate();
				barraLateral.repaint();
				
				detenerTemp();
			}
			
		});
		
		
		//agregar accion al botón de reiniciar tablero
		reiniciarTablero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				numPos = 0;
				
				//crear la secuencia desordenada para los valores de los botones/fichas
				lista = Arrays.asList(numeros); //convertir el Arreglo a Lista
				Collections.shuffle(lista); //revolver la Lista
				numeros = lista.toArray(new String[0]); //convertir la Lista a Arreglo
				
				for(y=0; y<4; y++) { //renglon       	
			 		for(x=0; x<4; x++) { //columna
				 		matrizBotones[y][x].setText(numeros[numPos]);
				 		matrizBotones[y][x].setEnabled(false);
			 			numPos++;
			 		}
				}
				
				continuarJuego.setEnabled(true);
				continuarJuego.setBackground(new Color(63, 43, 24, 255));
				continuarJuego.setText("Iniciar");
				
				detenerJuego.setEnabled(false);
				detenerJuego.setBackground(new Color(63, 43, 24, 100));
				
				reiniciarTablero.setEnabled(false);
				reiniciarTablero.setBackground(new Color(63, 43, 24, 100));
				
				barraLateral.validate();
				barraLateral.repaint();
				 
				reiniciarTemp();
			}
			
		});
		
		
		//crear la matriz de botones
		matrizBotones = new JButton[4][4]; 
 		
		
		//crear la secuencia desordenada para los valores de los botones/fichas
		lista = Arrays.asList(numeros); //convertir el Arreglo a Lista
		Collections.shuffle(lista); //revolver la Lista
		numeros = lista.toArray(new String[0]); //convertir la Lista a Arreglo

		
 		//crear botones
		numPos = 0; //16 valores y posiciones de las fichas
 		for(y=0; y<4; y++) { //renglon       	
 			for(x=0; x<4; x++) { //columna
 				matrizBotones[y][x] = new JButton(numeros[numPos]);
 				numPos++;
 				System.out.println("numPos: " + numPos);
 				
 				matrizBotones[y][x].setEnabled(false);
 				matrizBotones[y][x].setBackground(Color.decode("#FFD09E"));
 				matrizBotones[y][x].setForeground(Color.decode("#40250A"));
 				matrizBotones[y][x].setBorderPainted(false); //hace invisible el borde por defecto de los botones   
 				matrizBotones[y][x].setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 				matrizBotones[y][x].setFont(new Font("Kefe", Font.BOLD, 50)); //fuente, tipo y tamaño
 				agregarAccion(matrizBotones[y][x], y, x); //llamar método que agrega acción al botón
 				panelTablero.add(matrizBotones[y][x]); //agregar la matriz de botones al panel para ser visualizado en la ventana
 			}
 		}
 		
	}

	
	void agregarAccion(final JButton boton, final int y, final int x) { //dentro del parenteesis obtiene las ubicaciones correspondientes
        boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String aux = null; //auxiliar para realizar la triangulación de valores
				
				//si existe botón hacia la izquierda
				if(x!=0 && matrizBotones[y][x-1].getText().equals(" ")){
					aux = boton.getText();
					boton.setText(" ");
					matrizBotones[y][x-1].setText(aux);
				}
				
				//si existe botón hacia arriba
				if(y!=0 && matrizBotones[y-1][x].getText().equals(" ")){
					aux = boton.getText();
					boton.setText(" ");
					matrizBotones[y-1][x].setText(aux);
				}
				
				//si existe botón hacia la derecha
				if(x!=3 && matrizBotones[y][x+1].getText().equals(" ")){
					aux = boton.getText();
					boton.setText(" ");
					matrizBotones[y][x+1].setText(aux);
				}

				//si existe botón hacia abajo
				if(y!=3 && matrizBotones[y+1][x].getText().equals(" ")){
					aux = boton.getText();
					boton.setText(" ");
					matrizBotones[y+1][x].setText(aux);		
				}
				
				//validar partida ganada
				if(validarTablero()) {
					tiempoValor = tiempoValorLbl.getText();
					System.out.println(tiempoValorLbl.getText());
					reiniciarTemp(); //reiniciar temporizador
					
					int seguir = 0;
			    	mensaje = "<html> Has ganado, tiempo de resolución: " + tiempoValor + ", ¿Desea volver a jugar? ";
			    	seguir = JOptionPane.showConfirmDialog(null, mensaje, "Puzzle 15", JOptionPane.YES_NO_OPTION);
			    	if(seguir==0) { //si decide volver a jugar
			    		numPos = 0;
						
						//crear la secuencia desordenada para los valores de los botones/fichas
						lista = Arrays.asList(numeros); //convertir el Arreglo a Lista
						Collections.shuffle(lista); //revolver la Lista
						numeros = lista.toArray(new String[0]); //convertir la Lista a Arreglo
						
						for(int y=0; y<4; y++) { //renglon       	
					 		for(int x=0; x<4; x++) { //columna
						 		matrizBotones[y][x].setText(numeros[numPos]);
						 		matrizBotones[y][x].setEnabled(false);
					 			numPos++;
					 		}
						}
						
						continuarJuego.setEnabled(true);
						detenerJuego.setEnabled(true);
						reiniciarTablero.setEnabled(true);
			    	}
				}
			}
        	
        });
	}
	
	
	public boolean validarTablero() {
		
		int cont = 0;
		for(y=0; y<4; y++) { //renglon       	
 			for(x=0; x<4; x++) { //columna
 				if(matrizBotones[y][x].getText().equals(ordenGanador[y][x])) {
 					cont++;
 				}
 			}
 		}
		
		if(cont==16) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
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
	
	
	public void reanudarTemp() {
		if(!tempActivo) {
			temporizador();
		}
	}
	
	
	public void detenerTemp() {
		tempActivo = false;
		if(temporizador!=null) {
			temporizador.stop();
		}
	}
	
	
	public void reiniciarTemp() {
		tempActivo = false;
		if(temporizador!=null) {
			temporizador.stop();
		}
		tiempoValorLbl.setText("00:00:00:00");
		hor = 0; min = 0; seg = 0; cen = 0;
	}
	
}
