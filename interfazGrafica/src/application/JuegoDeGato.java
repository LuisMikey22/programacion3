package application;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public class JuegoDeGato {

	private JFrame frame;
	int x = 0, y = 0;
	
	int contadorFichas = 0;
	int jugarDeNuevo;
	String mensaje;
	
	String jugador = "X";
	boolean turno;
	boolean ganador;
	
	private JButton matrizBotones[][];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoDeGato window = new JuegoDeGato();
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
	public JuegoDeGato() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Juego del gato");
		frame.setBounds(500, 200, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panelFondo = new JPanel();
		frame.getContentPane().add(panelFondo, BorderLayout.CENTER);
		panelFondo.setBackground(Color.black);
		
		//crear la matriz de botones
		matrizBotones = new JButton[3][3]; 
		panelFondo.setLayout(new GridLayout(3, 3, 6, 6));
		
		//crear botones
		for(y=0; y<3; y++) { //renglon       	
			for(x=0; x<3; x++) { //columna
				matrizBotones[y][x] = new JButton();
				matrizBotones[y][x].setBackground(Color.white);
				matrizBotones[y][x].setForeground(Color.white);
				matrizBotones[y][x].setBorderPainted(false); //hace invisible el borde por defecto de los botones   
				matrizBotones[y][x].setFont(new Font("Kefe", Font.BOLD, 80)); //fuente, tipo y tamaño
				agregarAccion(matrizBotones[y][x], y, x); //llamar método que agrega acción al botón
		    	panelFondo.add(matrizBotones[y][x]); //agregar la matriz de botones al panel para ser visualizado en la ventana
			}
		}
		
	}
	
	void agregarAccion(final JButton boton, final int y, final int x) { //dentro del parenteesis obtiene las ubicaciones correspondientes
        boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					System.out.println("x: " + x + ", y: " + y);
					matrizBotones[y][x].setBackground(Color.decode("#FC033D"));
				}else {
					turno = true;
					jugador = "O";
					System.out.println("x: " + x + ", y: " + y);
					matrizBotones[y][x].setBackground(Color.decode("#035AFC"));
				}
				matrizBotones[y][x].setText(jugador);
				matrizBotones[y][x].setEnabled(false);
				validarLineas(); //método para validar las líneas de manera horizontal, vertical y diagonal
				contadorFichas++;
			}
        	
        });
	 }
	
	
	public void validarLineas() {
		//líneas horizontales----------
		for(y=0; y<3; y++) {
			if(!matrizBotones[y][0].getText().equals("") & matrizBotones[y][0].getText().equals(matrizBotones[y][1].getText()) &
			    matrizBotones[y][1].getText().equals(matrizBotones[y][2].getText())){
				if(jugador.equals("X")) {
					mensaje = "El Jugador X ganó. :D"; 
					JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
				}else{
					mensaje = "El Jugador O ganó. :D"; 
					JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
				}
				ganador = true;
			}
		}
		 
		
		//líneas verticales||||||||||
		for(x=0; x<3; x++) {
			if(!matrizBotones[0][x].getText().equals("") & matrizBotones[0][x].getText().equals(matrizBotones[1][x].getText()) &
			    matrizBotones[1][x].getText().equals(matrizBotones[2][x].getText())){
				if(jugador.equals("X")) {
					mensaje = "El Jugador X ganó. :D"; 
					JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
				}else{
					mensaje = "El Jugador O ganó. :D"; 
					JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
				}
				ganador = true;
			}
		}
		
		
		
		//líneas diagonales//////////
		//línea hacia la derecha
		if(!matrizBotones[0][0].getText().equals("") & matrizBotones[0][0].getText().equals(matrizBotones[1][1].getText()) &
		    matrizBotones[1][1].getText().equals(matrizBotones[2][2].getText())){
			if(jugador.equals("X")) {
				mensaje = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				mensaje = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		//línea hacia la izquierda
		if(!matrizBotones[0][2].getText().equals("") & matrizBotones[0][2].getText().equals(matrizBotones[1][1].getText()) &
			matrizBotones[1][1].getText().equals(matrizBotones[2][0].getText())){
			if(jugador.equals("X")) {
				mensaje = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				mensaje = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		
		//si existe un ganador
		if(ganador) {
			jugarDeNuevo = 0;
			jugarDeNuevo = JOptionPane.showConfirmDialog(null, "¿Desea jugar otra vez?", "Jugar partida", JOptionPane.YES_NO_OPTION);
			
	    	if(jugarDeNuevo==0) { //volver a jugar
	    		for(y=0; y<3; y++) { //renglon       	
	    			for(x=0; x<3; x++) { //columna
	    				matrizBotones[y][x].setEnabled(true);
	    				matrizBotones[y][x].setText("");
	    				matrizBotones[y][x].setBackground(Color.white);
	    				ganador = false;
	    				contadorFichas = 0;
	    			}
	    		}
	    	}else { //si decide no volver a jugar
	    		for(y=0; y<3; y++) { //renglon       	
	    			for(x=0; x<3; x++) { //columna
	    				matrizBotones[y][x].setEnabled(false);
	    			}
	    		}
	    	}
		}
		
		
		//si existe empate
		if(contadorFichas>8) {
			mensaje = "Existe un empate entre ambos jugadores \n ¿Desea jugar otra vez?";
			
			jugarDeNuevo = 0;
			jugarDeNuevo = JOptionPane.showConfirmDialog(null, mensaje, "Jugar partida", JOptionPane.YES_NO_OPTION);
			
	    	if(jugarDeNuevo==0) { //volver a jugar
	    		for(y=0; y<3; y++) { //renglon       	
	    			for(x=0; x<3; x++) { //columna
	    				matrizBotones[y][x].setEnabled(true);
	    				matrizBotones[y][x].setText("");
	    				matrizBotones[y][x].setBackground(Color.white);
	    				ganador = false;
	    				contadorFichas = 0;
	    			}
	    		}
	    	}else { //si decide no volver a jugar
	    		for(y=0; y<3; y++) { //renglon       	
	    			for(x=0; x<3; x++) { //columna
	    				matrizBotones[y][x].setEnabled(false);
	    			}
	    		}
	    	}
		}
	}

}
