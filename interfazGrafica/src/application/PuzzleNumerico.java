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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PuzzleNumerico {

	private JFrame frame;

	private JButton matrizBotones[][];
	int x, y;
	int numPos;
	
	Integer[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	
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
		panelTablero.setLocation(54, 100);
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
		
		
		//contador
		JPanel contadorPnl = new JPanel();
		contadorPnl.setOpaque(true);
		contadorPnl.setBackground(Color.decode("#FFD09E"));
		contadorPnl.setLayout(new GridLayout(1, 2));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 20);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;
		barraLateral.add(contadorPnl, c);
		
		JLabel contadorLbl = new JLabel("Contador: ");
		contadorLbl.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 0, Color.decode("#3F2B18")));
		contadorLbl.setForeground(Color.decode("#3F2B18"));
		contadorLbl.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		contadorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		contadorPnl.add(contadorLbl);
		
		JLabel contadorLblNum = new JLabel("0");
		contadorLblNum.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#3F2B18")));
		contadorLblNum.setForeground(Color.decode("#3F2B18"));
		contadorLblNum.setFont(new Font("Kefe", Font.BOLD, 16)); //fuente, tipo y tamaño
		contadorLblNum.setHorizontalAlignment(SwingConstants.CENTER);
		contadorPnl.add(contadorLblNum);
		
		
		//temporizador
		JPanel temporizadorPnl = new JPanel();
		temporizadorPnl.setOpaque(true);
		temporizadorPnl.setBackground(Color.decode("#FFD09E"));
		temporizadorPnl.setLayout(new GridLayout(1, 2));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 20);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 20;
		barraLateral.add(temporizadorPnl, c);
		
		JButton temporizadorBtn = new JButton("Temporizador: ");
		temporizadorBtn.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 0, Color.decode("#3F2B18")));
		temporizadorBtn.setBackground(Color.decode("#3F2B18"));
		temporizadorBtn.setForeground(Color.decode("#FFD09E"));
		temporizadorBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		temporizadorBtn.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		temporizadorPnl.add(temporizadorBtn);
		
		JLabel temporizadorLblNum = new JLabel("0"+"s");
		temporizadorLblNum.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#3F2B18")));
		temporizadorLblNum.setForeground(Color.decode("#3F2B18"));
		temporizadorLblNum.setFont(new Font("Kefe", Font.BOLD, 16)); //fuente, tipo y tamaño
		temporizadorLblNum.setHorizontalAlignment(SwingConstants.CENTER);
		temporizadorPnl.add(temporizadorLblNum);
		
		
		//botón reiniciar temporizador
		JButton reiniciarTempBtn = new JButton("Reiniciar Temporizador");
		reiniciarTempBtn.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#3F2B18")));
		reiniciarTempBtn.setBackground(Color.decode("#3F2B18"));
		reiniciarTempBtn.setForeground(Color.decode("#FFD09E"));
		reiniciarTempBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		reiniciarTempBtn.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		reiniciarTempBtn.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 20);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 20;
		barraLateral.add(reiniciarTempBtn, c);
		
		//botón reiniciar tablero
		JButton reiniciarTablaBtn = new JButton("Reiniciar Tablero");
		reiniciarTablaBtn.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#3F2B18")));
		reiniciarTablaBtn.setBackground(Color.decode("#3F2B18"));
		reiniciarTablaBtn.setForeground(Color.decode("#FFD09E"));
		reiniciarTablaBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		reiniciarTablaBtn.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		reiniciarTablaBtn.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 20);  //relleno en la parte de arriba
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 20;
		barraLateral.add(reiniciarTablaBtn, c);
		
		
		//crear la matriz de botones
		matrizBotones = new JButton[4][4]; 
 		
		
        List<Integer> l = Arrays.asList(numeros); //convertir el Arreglo a Lista
        Collections.shuffle(l); //revolver la Lista
        numeros = l.toArray(new Integer[0]); //convertir la Lista a Arreglo

		
 		//crear botones
		numPos = 0;
 		for(y=0; y<4; y++) { //renglon       	
 			for(x=0; x<4; x++) { //columna
 				if(y==0 && x==0) { //dejar el primer espacio vacío
 					matrizBotones[y][x] = new JButton(" ");
 				}else {
 					matrizBotones[y][x] = new JButton(""+numeros[numPos-1]);
 				}
 				numPos++;
 				System.out.println("numPos: " + numPos);
 				
 				matrizBotones[y][x].setBackground(Color.decode("#FFD09E"));
 				matrizBotones[y][x].setForeground(Color.decode("#40250A"));
 				matrizBotones[y][x].setBorderPainted(false); //hace invisible el borde por defecto de los botones   
 				matrizBotones[y][x].setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 				matrizBotones[y][x].setFont(new Font("Kefe", Font.BOLD, 50)); //fuente, tipo y tamaño
 				agregarAccion(matrizBotones[y][x], y, x); //llamar método que agrega acción al botón
 				panelTablero.add(matrizBotones[y][x]); //agregar la matriz de botones al panel para ser visualizado en la ventana
 			}
 		}
 		
 		
 		//agregar accion al botón de reiniciar tablero
 		reiniciarTablaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				numPos = 0;
				
				List<Integer> l = Arrays.asList(numeros); //convertir el Arreglo a Lista
				Collections.shuffle(l); //revolver la Lista
				numeros = l.toArray(new Integer[0]); //convertir la Lista a Arreglo
				
				 for(y=0; y<4; y++) { //renglon       	
			 		for(x=0; x<4; x++) { //columna
			 			if(y==0 && x==0) { //dejar el primer espacio vacío
		 					matrizBotones[y][x].setText(" ");
		 				}else {
				 			matrizBotones[y][x].setText(""+numeros[numPos-1]);
		 				}
			 			numPos++;
			 		}
			 	}
			}
			
		});
 		
	}

	
	void agregarAccion(final JButton boton, final int y, final int x) { //dentro del parenteesis obtiene las ubicaciones correspondientes
        boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String aux = null;
				if(x!=0 && matrizBotones[y][x-1].getText().equals(" ")){
					aux = boton.getText();
					boton.setText(" ");
					matrizBotones[y][x-1].setText(aux);
				}
				
				if(y!=0 && matrizBotones[y-1][x].getText().equals(" ")){
					aux = boton.getText();
					boton.setText(" ");
					matrizBotones[y-1][x].setText(aux);
							
				}
				
				if(x!=3 && matrizBotones[y][x+1].getText().equals(" ")){
					aux = boton.getText();
					boton.setText(" ");
					matrizBotones[y][x+1].setText(aux);
				}

				if(y!=3 && matrizBotones[y+1][x].getText().equals(" ")){
					aux = boton.getText();
					boton.setText(" ");
					matrizBotones[y+1][x].setText(aux);		
				}
			}
        	
        });
	 }

}
