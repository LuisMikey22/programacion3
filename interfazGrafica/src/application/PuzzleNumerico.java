package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PuzzleNumerico {

	private JFrame frame;

	private JButton matrizBotones[][];
	int x, y;
	
	String numeros[] = {"1", "2",  "3",  "4",  "5",  "6",  "7", 
						"8", "9", "10", "11", "12", "13", "14", "15"};
	
	Random rand = new Random();
	
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
 		frame.setSize(760, 680); 
 		frame.setResizable(false);
 		frame.setLocationRelativeTo(null);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 		JPanel panelFondo = new JPanel();
		frame.getContentPane().add(panelFondo, BorderLayout.CENTER);
		panelFondo.setBackground(Color.black);
		panelFondo.setLayout(new BorderLayout());
		
		JPanel panelTablero = new JPanel();
		panelTablero.setSize(440, 440);
		panelTablero.setLocation(77, 100);
		panelTablero.setBackground(new Color(31, 18, 5, 155));
		panelTablero.setLayout(new GridLayout(4, 4, 8, 8));
		panelFondo.add(panelTablero, BorderLayout.CENTER);
		
		Image imageBoard = new ImageIcon(getClass().getResource("woodenBoard.png")).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon imageBoardIcon = new ImageIcon(imageBoard);
		JLabel tableroFondoImg = new JLabel(imageBoardIcon);
		tableroFondoImg.setLocation(200, 90);
		panelFondo.add(tableroFondoImg);
		
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(Color.black);
		barraLateral.setLayout(new GridBagLayout());;
		GridBagConstraints c = new GridBagConstraints(); //crear GridBagConstraints
		c.fill = GridBagConstraints.HORIZONTAL; //horizontal
		panelFondo.add(barraLateral, BorderLayout.EAST);
		
		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#D8A069")));
		reiniciar.setBackground(Color.decode("#3F2B18"));
		reiniciar.setForeground(Color.decode("#FFD09E"));
		reiniciar.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		reiniciar.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 20);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;
		c.ipadx = 40;
		barraLateral.add(reiniciar, c);
		
		
		//crear la matriz de botones
		matrizBotones = new JButton[4][4]; 
 		
 		//crear botones
		int numPos = 0;
 		for(y=0; y<4; y++) { //renglon       	
 			for(x=0; x<4; x++) { //columna
 				if(y==0 && x==0) { //dejar el primer espacio vacío
 					matrizBotones[y][x] = new JButton(" ");
 				}else {
 					matrizBotones[y][x] = new JButton(numeros[numPos]);
 					numPos++;
 				}
 				
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
				
			}
        	
        });
	 }

}
