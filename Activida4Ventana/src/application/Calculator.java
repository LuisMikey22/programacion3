package application;

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
	JButton buttons[][];
	JPanel matrixPnl;
	
	String chars [][] = {{"CE", " ", " ", " "}, // matriz de caracteres
						  {"7", "8", "9", "/"},
						  {"4", "5", "6", "*"},
						  {"1", "2", "3", "-"},
						  {"0", ".", "=", "+"}};
	
	public Calculator(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		this.setLayout(null); //desactivar los contenedores por defecto
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(465, 670); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(300, 400));
		this.setMaximumSize(new Dimension(800, 900));
		this.setResizable(isMaximumSizeSet());

		this.add(this.calculator());
		
		this.repaint();
	}
	
	public JPanel calculator() {
		JPanel calculatorPnl = new JPanel(); 
		calculatorPnl.setSize(450, 670);
		calculatorPnl.setLocation(0, 0);
		calculatorPnl.setBackground(Color.decode("#BFE4FF"));
		calculatorPnl.setOpaque(true);
		
		JLabel loginLbl = new JLabel("365 + 1");
		loginLbl.setSize(240, 40);
		loginLbl.setLocation(105, 40);
		loginLbl.setForeground(Color.decode("#1B313F")); //color de letra
		loginLbl.setOpaque(false); //tiene fondo o no
		loginLbl.setHorizontalAlignment(JLabel.CENTER);
		loginLbl.setFont(tahoma); //fuente, tipo y tamaño
		this.add(loginLbl);
		
		JLabel header = new JLabel();
		header.setSize(330, 60);
		header.setLocation(60, 30);
		header.setOpaque(true); //tiene fondo o no
		header.setBorder(BorderFactory.createEtchedBorder(20, Color.decode("#1B313F"), Color.decode("#1B313F")));
		header.setBackground(Color.white);
		header.setHorizontalAlignment(JLabel.LEFT);
		this.add(header);
		
		matrixPnl = new JPanel(); //crear el panel de botones
		matrixPnl.setOpaque(false);
		matrixPnl.setSize(330, 450);
		matrixPnl.setLocation(60, 130);
		
		buttons= new JButton[6][7]; //Crear la matriz de botones
		matrixPnl.setLayout(new GridLayout(5, 4, 10, 10)); //(los dos 10 son el espacio entre botones, 6 y 7 son los renglones y columnas)
		
	    for(i=0; i<5; i++) { //renglon
            for(j=0; j<4; j++) { //columna         
            	buttons[i][j]= new JButton(); //crear el boton en la posicion i-j de la matriz      
            	buttons[i][j].setText(chars[i][j]);
            	buttons[i][j].setSize(100, 100);
                buttons[i][j].setBackground(Color.decode("#1B313F")); //hacer el boton de color azul oscuro  
            	buttons[i][j].setForeground(Color.white);
            	buttons[i][j].setFont(tahoma); //fuente, tipo y tamaño
            	buttons[i][j].setBorderPainted(false); //hace invisible el borde por defecto de los botones   
            	buttons[i][j].setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
                buttons[i][j].setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
                matrixPnl.add(buttons[i][j]); //agregar la matriz de botones al panel para ser visualizado en la ventana
            }
		}
	    
	    this.add(matrixPnl);//agregar el panel de la matriz de botones al panel principal
		
		return calculatorPnl; //añadir panel al marco (JFrame)
	}

}
 