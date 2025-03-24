package application;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class JuegoDeGato {

	private JFrame frame;
	int x = 0, y = 0;
	
	int contadorFichas;
	int jugarDeNuevo;
	String mensaje;
	
	String jugador = "X";
	boolean turno;
	boolean ganador;
	int puntosX, puntosO;
	
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	JLabel puntosXLbl, puntosXLblNum, puntosOLbl, puntosOLblNum;
	
	Image imageNeedle = new ImageIcon(getClass().getResource("knittingNeedlesIcon.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon imageNeedleIcon = new ImageIcon(imageNeedle);
	Image imageYarn = new ImageIcon(getClass().getResource("ballOfYarnIcon.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon imageYarnIcon = new ImageIcon(imageYarn);

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
		
		ImageIcon estambreIcon = new ImageIcon(getClass().getResource("ballOfYarnIcon.png")); //ícono de la ventana
		frame.setIconImage(estambreIcon.getImage());
		
		frame.setTitle("Juego del gato");
		frame.setBounds(500, 200, 600, 650);
		frame.setResizable(false);
 		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMatriz = new JPanel();
		frame.getContentPane().add(panelMatriz, BorderLayout.CENTER);
		panelMatriz.setBackground(Color.black);
		panelMatriz.setLayout(new GridLayout(3, 3, 6, 6));
		
		JButton botonReiniciar = new JButton("REINICIAR");
		botonReiniciar.setBackground(Color.decode("#EBA834"));
		botonReiniciar.setForeground(Color.black);
		botonReiniciar.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		botonReiniciar.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		frame.getContentPane().add(botonReiniciar, BorderLayout.SOUTH);
		
		JPanel panelEtiquetas = new JPanel();
		panelEtiquetas.setBackground(Color.decode("#EBA834"));
		frame.getContentPane().add(panelEtiquetas, BorderLayout.NORTH);
		panelEtiquetas.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		puntosXLbl = new JLabel("Puntos de X: ");
		puntosXLbl.setForeground(Color.black);
		puntosXLbl.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		panelEtiquetas.add(puntosXLbl);
		
		puntosXLblNum = new JLabel("0");
		puntosXLblNum.setForeground(Color.black);
		puntosXLblNum.setHorizontalAlignment(SwingConstants.LEFT);
		puntosXLblNum.setFont(new Font("Kefe", Font.BOLD, 18)); //fuente, tipo y tamaño
		panelEtiquetas.add(puntosXLblNum);
		
		puntosOLbl = new JLabel("Puntos de O: ");
		puntosOLbl.setForeground(Color.black);
		puntosOLbl.setFont(new Font("Kefe", Font.BOLD, 20)); //fuente, tipo y tamaño
		panelEtiquetas.add(puntosOLbl);
		
		puntosOLblNum = new JLabel("0");
		puntosOLblNum.setForeground(Color.black);
		puntosOLblNum.setHorizontalAlignment(SwingConstants.LEFT);
		puntosOLblNum.setFont(new Font("Kefe", Font.BOLD, 18)); //fuente, tipo y tamaño
		panelEtiquetas.add(puntosOLblNum);
		
		
		btn1 = new JButton();
 		btn1.setBackground(new Color(255, 255, 255));
 		btn1.setForeground(new Color(255, 255, 255));
 		btn1.setHorizontalAlignment(SwingConstants.CENTER);
 		btn1.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn1.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn1);
 		
 		btn1.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(btn1.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn1.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn1.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn1.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		
 		btn2 = new JButton();
 		btn2.setBackground(new Color(255, 255, 255));
 		btn2.setForeground(new Color(255, 255, 255));
 		btn2.setHorizontalAlignment(SwingConstants.CENTER);
 		btn2.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn2.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn2);
 		
 		btn2.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub	
 				if(btn2.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn2.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn2.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn2.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		
 		btn3 = new JButton();
 		btn3.setBackground(new Color(255, 255, 255));
 		btn3.setForeground(new Color(255, 255, 255));
 		btn3.setHorizontalAlignment(SwingConstants.CENTER);
 		btn3.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn3.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn3);
 		
 		btn3.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(btn3.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn3.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn3.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn3.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		
 		btn4 = new JButton();
 		btn4.setBackground(new Color(255, 255, 255));
 		btn4.setForeground(new Color(255, 255, 255));
 		btn4.setHorizontalAlignment(SwingConstants.CENTER);
 		btn4.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn4.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn4);
 		
 		btn4.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(btn4.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn4.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn4.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn4.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		
 		btn5 = new JButton();
 		btn5.setBackground(new Color(255, 255, 255));
 		btn5.setForeground(new Color(255, 255, 255));
 		btn5.setHorizontalAlignment(SwingConstants.CENTER);
 		btn5.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn5.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn5);
 		
 		btn5.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(btn5.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn5.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn5.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn5.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		
 		btn6 = new JButton();
 		btn6.setBackground(new Color(255, 255, 255));
 		btn6.setForeground(new Color(255, 255, 255));
 		btn6.setHorizontalAlignment(SwingConstants.CENTER);
 		btn6.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn6.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn6);
 		
 		btn6.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(btn6.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn6.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn6.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn6.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		
 		btn7 = new JButton();
 		btn7.setBackground(new Color(255, 255, 255));
 		btn7.setForeground(new Color(255, 255, 255));
 		btn7.setHorizontalAlignment(SwingConstants.CENTER);
 		btn7.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn7.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn7);
 		
 		btn7.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(btn7.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn7.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn7.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn7.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		
 		btn8 = new JButton();
 		btn8.setBackground(new Color(255, 255, 255));
 		btn8.setForeground(new Color(255, 255, 255));
 		btn8.setHorizontalAlignment(SwingConstants.CENTER);
 		btn8.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn8.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn8);
 		
 		btn8.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(btn8.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn8.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn8.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn8.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		
 		btn9 = new JButton();
 		btn9.setBackground(new Color(255, 255, 255));
 		btn9.setForeground(new Color(255, 255, 255));
 		btn9.setHorizontalAlignment(SwingConstants.CENTER);
 		btn9.setFont(new Font("Kefe", Font.BOLD, 1)); //fuente, tipo y tamaño
 		btn9.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 		panelMatriz.add(btn9);
 		
 		btn9.addActionListener(new ActionListener() {
 
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(btn9.getText().equals("")) { //solo si el botón no tiene ficha asignada
 					contadorFichas++; //fichas ocupadas
 					if(turno) {
 	 					turno = false;
 	 					jugador = "X";
 	 					btn9.setIcon(imageNeedleIcon);
 	 				}else {
 	 					turno = true;
 	 					jugador = "O";
 	 					btn9.setIcon(imageYarnIcon);
 	 				}
 					System.out.println("fichas ocupadas: " + contadorFichas);
 	 				btn9.setText(jugador);
 	 				validarLineas();
 				}
 			}
 			
 		});
 		
 		botonReiniciar.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ganador || contadorFichas==9) {
					//quitar las imágenes de los botones
					btn1.setIcon(null);btn2.setIcon(null);btn3.setIcon(null);
		 			btn4.setIcon(null);btn5.setIcon(null);btn6.setIcon(null);
		 			btn7.setIcon(null);btn8.setIcon(null);btn9.setIcon(null);
		 			
		 			//quitar las imágenes de los botones
		 			btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");
		 			btn5.setText("");btn6.setText("");btn7.setText("");btn8.setText("");
		 			btn9.setText("");
		 			
		 			//deactivar los botones
					btn1.setEnabled(true);btn2.setEnabled(true);btn3.setEnabled(true);
		 			btn4.setEnabled(true);btn5.setEnabled(true);btn6.setEnabled(true);
		 			btn7.setEnabled(true);btn8.setEnabled(true);btn9.setEnabled(true);
		 			
		 			ganador = false;
		 			contadorFichas = 0;
				}
			}
 		});
		
	}
	
	/*void agregarAccion(final JButton boton, final int y, final int x) { //dentro del parenteesis obtiene las ubicaciones correspondientes
        boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(matrizBotones[y][x].getText().equals("")) { //solo si el botón no tiene ficha asignada
					contadorFichas++; //contar ficha ocupada
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
					System.out.println("fichas ocupadas: " + contadorFichas);
					matrizBotones[y][x].setText(jugador);
					validarLineas(); //método para validar las líneas de manera horizontal, vertical y diagonal
				}	
			}
        	
        });
	 }*/
	
	
	public void validarLineas() {
		//líneas horizontales----------
 		//línea 1 horizontal
 		if(!btn1.getText().equals("") && btn1.getText().equals(btn2.getText()) &
 		   !btn2.getText().equals("") && btn2.getText().equals(btn3.getText())){
 			if(jugador.equals("X")) {
 				puntosX++;
 				puntosXLblNum.setText(""+puntosX);
 				mensaje = "El Jugador X ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}else{
 				puntosO++;
 				puntosOLblNum.setText(""+puntosO);
 				mensaje = "El Jugador O ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}
 			ganador = true;
 		}
 		
 		//línea 2 hprizontal
 		if(!btn4.getText().equals("") && btn4.getText().equals(btn5.getText()) &
 		   !btn5.getText().equals("") && btn5.getText().equals(btn6.getText())){
 			if(jugador.equals("X")) {
 				puntosX++;
 				puntosXLblNum.setText(""+puntosX);
 				mensaje = "El Jugador X ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}else{
 				puntosO++;
 				puntosOLblNum.setText(""+puntosO);
 				mensaje = "El Jugador O ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}
 			ganador = true;
 		}
 		
 		//línea 3 hprizontal
 		if(!btn7.getText().equals("") && btn7.getText().equals(btn8.getText()) &
 		   !btn8.getText().equals("") && btn8.getText().equals(btn9.getText())){
 			if(jugador.equals("X")) {
 				puntosX++;
 				puntosXLblNum.setText(""+puntosX);
 				mensaje = "El Jugador X ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}else{
 				puntosO++;
 				puntosOLblNum.setText(""+puntosO);
 				mensaje = "El Jugador O ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}
 			ganador = true;
 		}
 		
 		
 		//líneas verticales
 		//línea 1 vertical
 		if(!btn1.getText().equals("") && btn1.getText().equals(btn4.getText()) &
 		   !btn4.getText().equals("") && btn4.getText().equals(btn7.getText())){
 			if(jugador.equals("X")) {
 				puntosX++;
 				puntosXLblNum.setText(""+puntosX);
 				mensaje = "El Jugador X ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}else{
 				puntosO++;
 				puntosOLblNum.setText(""+puntosO);
 				mensaje = "El Jugador O ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}
 			ganador = true;
 		}
 		
 		//línea 2 vertical
 		if(!btn2.getText().equals("") && btn2.getText().equals(btn5.getText()) &
 		   !btn5.getText().equals("") && btn5.getText().equals(btn8.getText())){
 			if(jugador.equals("X")) {
 				puntosX++;
 				puntosXLblNum.setText(""+puntosX);
 				mensaje = "El Jugador X ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}else{
 				puntosO++;
 				puntosOLblNum.setText(""+puntosO);
 				mensaje = "El Jugador O ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}
 			ganador = true;
 		}
 		
 		//línea 3 vertical
 		if(!btn3.getText().equals("") && btn3.getText().equals(btn6.getText()) &
 		   !btn6.getText().equals("") && btn6.getText().equals(btn9.getText())){
 			if(jugador.equals("X")) {
 				puntosX++;
 				puntosXLblNum.setText(""+puntosX);
 				mensaje = "El Jugador X ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}else{
 				puntosO++;
 				puntosOLblNum.setText(""+puntosO);
 				mensaje = "El Jugador O ganó. :D"; 
 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 			}
 			ganador = true;
 		}
 		
 		
 		//if para solo contar una línea en el caso de que una línea diagonal y otra línea se cruzen creando: _\ o bien /_
 		if(!ganador) {
 			//líneas diagonales
 	 		//línea hacia la derecha
 	 		if(!btn1.getText().equals("") && btn1.getText().equals(btn5.getText()) &
 	 		   !btn5.getText().equals("") && btn5.getText().equals(btn9.getText())){
 	 			if(jugador.equals("X")) {
 	 				puntosX++;
 	 				puntosXLblNum.setText(""+puntosX);
 	 				mensaje = "El Jugador X ganó. :D"; 
 	 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 	 			}else{
 	 				puntosO++;
 	 				puntosOLblNum.setText(""+puntosO);
 	 				mensaje = "El Jugador O ganó. :D"; 
 	 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 	 			}
 	 			ganador = true;
 	 		}
 	 		
 	 		//línea hacia la izquierda
 	 		if(!btn3.getText().equals("") && btn3.getText().equals(btn5.getText()) &
 	 		   !btn5.getText().equals("") && btn5.getText().equals(btn7.getText())){
 	 			if(jugador.equals("X")) {
 	 				puntosX++;
 	 				puntosXLblNum.setText(""+puntosX);
 	 				mensaje = "El Jugador X ganó. :D"; 
 	 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 	 			}else{
 	 				puntosO++;
 	 				puntosOLblNum.setText(""+puntosO);
 	 				mensaje = "El Jugador O ganó. :D"; 
 	 				JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
 	 			}
 	 			ganador = true;
 	 		}
 		}
 		
 		
 		//si existe ganador
 		if(ganador) {
 			btn1.setEnabled(false);btn2.setEnabled(false);btn3.setEnabled(false);
 			btn4.setEnabled(false);btn5.setEnabled(false);btn6.setEnabled(false);
 			btn7.setEnabled(false);btn8.setEnabled(false);btn9.setEnabled(false);
 		}
 		
		//si existe empate
		if(!ganador & contadorFichas==9) {
			btn1.setEnabled(false);btn2.setEnabled(false);btn3.setEnabled(false);
 			btn4.setEnabled(false);btn5.setEnabled(false);btn6.setEnabled(false);
 			btn7.setEnabled(false);btn8.setEnabled(false);btn9.setEnabled(false);
			String mensaje = "Existe un empate entre ambos jugadores \n ¿Desea jugar otra vez?"; 
			JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
		}
	}

}
