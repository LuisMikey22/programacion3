package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculator extends JFrame{
	
	Font tahoma = new Font("Tahoma", Font.BOLD, 20);
	int i, j;
	
	String chars[] = {"CE", " ", " ", " ","7", "8", "9", "/", "4", "5",
					  "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
	
	JButton[] arrangementBttn = new JButton[20];
	
	public Calculator(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(465, 670); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(300, 500));
		this.setMaximumSize(new Dimension(800, 900));
		this.setResizable(isMaximumSizeSet());

		this.add(this.calculator(), BorderLayout.CENTER); //coloca el panel en el centro de la ventana
		
		this.repaint();
	}
	
	public JPanel calculator() {
		
		setLayout(new BorderLayout());
		
		JPanel calculatorPnl = new JPanel(); 
		//calculatorPnl.setSize(400, 600);
		//calculatorPnl.setLocation(0, 0);
		calculatorPnl.setBackground(Color.black);
		calculatorPnl.setOpaque(true);
		
		/*JLabel header = new JLabel("");
		header.setSize(240, 40);
		header.setLocation(60, 30);
		header.setOpaque(true); //tiene fondo o no
		header.setBorder(BorderFactory.createEtchedBorder(20, Color.decode("#1B313F"), Color.decode("#1B313F")));
		header.setBackground(Color.white);
		header.setHorizontalAlignment(JLabel.LEFT);
		this.add(header, BorderLayout.NORTH);*/
		
		JLabel loginLbl = new JLabel("365 + 1");
		//loginLbl.setSize(240, 120);
		//loginLbl.setLocation(105, 40);
		loginLbl.setForeground(Color.decode("#1B313F")); //color de letra
		loginLbl.setBorder(BorderFactory.createEtchedBorder(20, Color.decode("#1B313F"), Color.decode("#1B313F")));
		loginLbl.setBackground(Color.white);
		loginLbl.setOpaque(true); //tiene fondo o no
		loginLbl.setHorizontalAlignment(JLabel.CENTER);
		loginLbl.setFont(tahoma); //fuente, tipo y tamaño
		this.add(loginLbl, BorderLayout.NORTH);
		
		JPanel matrixPnl = new JPanel(); //crear el panel de botones
		matrixPnl.setOpaque(false);
		//matrixPnl.setSize(330, 450);
		//matrixPnl.setLocation(60, 130);
		matrixPnl.setLayout(new GridLayout(5, 4, 10, 10)); 
		this.add(matrixPnl, BorderLayout.CENTER);//agregar el panel de la matriz de botones al panel principal
		
	    for(i=0; i<arrangementBttn.length; i++) { //renglon       	
	    	arrangementBttn[i] = new JButton(chars[i]);
	    	
	    	if(chars[i].equals("CE") || chars[i].equals(" "))
	    		arrangementBttn[i].setBackground(Color.decode("#878787")); //hacer el boton de color gris oscuro
	    	else if(chars[i].equals("/") || chars[i].equals("*") || chars[i].equals("-") ||  chars[i].equals("+") || chars[i].equals("="))
	    		arrangementBttn[i].setBackground(Color.decode("#F09A37")); //hacer el boton de color naranja oscuro  
	    	else
	    		arrangementBttn[i].setBackground(Color.decode("#1B313F")); //hacer el boton de color azul oscuro  
	    	
	    	arrangementBttn[i].setForeground(Color.white);
	    	arrangementBttn[i].setBorderPainted(false); //hace invisible el borde por defecto de los botones   
	    	arrangementBttn[i].setFont(tahoma); //fuente, tipo y tamaño
	    	matrixPnl.add(arrangementBttn[i]); //agregar la matriz de botones al panel para ser visualizado en la ventana
		}
	    
	    matrixPnl.revalidate();
		return calculatorPnl; //añadir panel al marco (JFrame)
	}

}
 