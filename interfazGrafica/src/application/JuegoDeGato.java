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
	String jugador = "X";
	boolean turno;
	boolean ganador;
	
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

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
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 3, 3));
		
		btn1 = new JButton();
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setForeground(new Color(0, 0, 0));
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn1);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					btn1.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn1.setBackground(Color.blue);
				}
				btn1.setForeground(new Color(255, 255, 255));
				btn1.setText(jugador);
				btn1.setEnabled(false);
				validarLineas();
			}
			
		});
		
		
		btn2 = new JButton();
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setForeground(new Color(0, 0, 0));
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn2);
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				if(turno) {
					turno = false;
					jugador = "X";
					btn2.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn2.setBackground(Color.blue);
				}
				btn2.setForeground(new Color(255, 255, 255));
				btn2.setText(jugador);
				btn2.setEnabled(false);
				validarLineas();
			}
			
		});
		
		
		btn3 = new JButton();
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setForeground(new Color(0, 0, 0));
		btn3.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn3);
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					btn3.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn3.setBackground(Color.blue);
				}
				btn3.setForeground(new Color(255, 255, 255));
				btn3.setText(jugador);
				btn3.setEnabled(false);
				validarLineas();
			}
			
		});
		
		
		btn4 = new JButton();
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setForeground(new Color(0, 0, 0));
		btn4.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn4);
		
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					btn4.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn4.setBackground(Color.blue);
				}
				btn4.setForeground(new Color(255, 255, 255));
				btn4.setText(jugador);
				btn4.setEnabled(false);
				validarLineas();
			}
			
		});
		
		
		btn5 = new JButton();
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setForeground(new Color(0, 0, 0));
		btn5.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn5);
		
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					btn5.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn5.setBackground(Color.blue);
				}
				btn5.setForeground(new Color(255, 255, 255));
				btn5.setText(jugador);
				btn5.setEnabled(false);
				validarLineas();
			}
			
		});
		
		
		btn6 = new JButton();
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setForeground(new Color(0, 0, 0));
		btn6.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn6);
		
		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					btn6.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn6.setBackground(Color.blue);
				}
				btn6.setForeground(new Color(255, 255, 255));
				btn6.setText(jugador);
				btn6.setEnabled(false);
				validarLineas();
			}
			
		});
		
		
		btn7 = new JButton();
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setForeground(new Color(0, 0, 0));
		btn7.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn7);
		
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					btn7.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn7.setBackground(Color.blue);
				}
				btn7.setForeground(new Color(255, 255, 255));
				btn7.setText(jugador);
				btn7.setEnabled(false);
				validarLineas();
			}
			
		});
		
		
		btn8 = new JButton();
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setForeground(new Color(0, 0, 0));
		btn8.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn8);
		
		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					btn8.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn8.setBackground(Color.blue);
				}
				btn8.setForeground(new Color(255, 255, 255));
				btn8.setText(jugador);
				btn8.setEnabled(false);
				validarLineas();
			}
			
		});
		
		
		btn9 = new JButton();
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setForeground(new Color(0, 0, 0));
		btn9.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		panel.add(btn9);
		
		btn9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno) {
					turno = false;
					jugador = "X";
					btn9.setBackground(Color.red);
				}else {
					turno = true;
					jugador = "O";
					btn9.setBackground(Color.blue);
				}
				btn9.setForeground(new Color(255, 255, 255));
				btn9.setText(jugador);
				btn9.setEnabled(false);
				validarLineas();
			}
			
		});
		
	}
	
	public void validarLineas() {
		//líneas horizontales
		//línea 1 horizontal
		if(!btn1.getText().equals("") && btn1.getText().equals(btn2.getText()) &
		   !btn2.getText().equals("") && btn2.getText().equals(btn3.getText())){
			if(jugador.equals("X")) {
				String message = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				String message = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		//línea 2 hprizontal
		if(!btn4.getText().equals("") && btn4.getText().equals(btn5.getText()) &
		   !btn5.getText().equals("") && btn5.getText().equals(btn6.getText())){
			if(jugador.equals("X")) {
				String message = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				String message = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		//línea 3 hprizontal
		if(!btn7.getText().equals("") && btn7.getText().equals(btn8.getText()) &
		   !btn8.getText().equals("") && btn8.getText().equals(btn9.getText())){
			if(jugador.equals("X")) {
				String message = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				String message = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		
		//líneas verticales
		//línea 1 vertical
		if(!btn1.getText().equals("") && btn1.getText().equals(btn4.getText()) &
		   !btn4.getText().equals("") && btn4.getText().equals(btn7.getText())){
			if(jugador.equals("X")) {
				String message = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				String message = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		//línea 2 vertical
		if(!btn2.getText().equals("") && btn2.getText().equals(btn5.getText()) &
		   !btn5.getText().equals("") && btn5.getText().equals(btn8.getText())){
			if(jugador.equals("X")) {
				String message = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				String message = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		//línea 3 vertical
		if(!btn3.getText().equals("") && btn3.getText().equals(btn6.getText()) &
		   !btn6.getText().equals("") && btn6.getText().equals(btn9.getText())){
			if(jugador.equals("X")) {
				String message = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				String message = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		
		//líneas diagonales
		//línea hacia la derecha
		if(!btn1.getText().equals("") && btn1.getText().equals(btn5.getText()) &
		   !btn5.getText().equals("") && btn5.getText().equals(btn9.getText())){
			if(jugador.equals("X")) {
				String message = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				String message = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		//línea hacia la izquierda
		if(!btn3.getText().equals("") && btn3.getText().equals(btn5.getText()) &
		   !btn5.getText().equals("") && btn5.getText().equals(btn7.getText())){
			if(jugador.equals("X")) {
				String message = "El Jugador X ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}else{
				String message = "El Jugador O ganó. :D"; 
				JOptionPane.showMessageDialog(null, message, "Ganador", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
			ganador = true;
		}
		
		if(ganador) {
			btn1.setEnabled(false);btn2.setEnabled(false);btn3.setEnabled(false);
			btn4.setEnabled(false);btn5.setEnabled(false);btn6.setEnabled(false);
			btn7.setEnabled(false);btn8.setEnabled(false);btn9.setEnabled(false);
		}
	}

}
