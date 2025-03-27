package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AplicacionDibujo extends JFrame {
	
	String grosores[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						 "15", "20", "30", "50", "100", "150", "200", "500"};
	
	String[] colores = {"#000000", "#404040", "#ED1C24", "#FF6A00",
						"#FFF200", "#22B14C", "#00A2E8", "#3F48CC",
						"#7448CC", "#FF48CC", "#FFFFFF", "#B97A57",
						"#44D5E5", "#7F0000", "#C8A3E7", "#B5E61D"};
	
	JButton matrizBotones[][];
	int x, y;
	int numPos;
	
	String colorSeleccion;
	int grosorElemento;

	public AplicacionDibujo(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		
		ImageIcon vortexIcon = new ImageIcon(getClass().getResource("brushIcon.png"));
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(950, 750); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(950, 750));
		this.setResizable(isMaximumSizeSet());

		this.add(this.interfazDibujo(), BorderLayout.CENTER);
		
		this.validate();
		this.revalidate();
		this.repaint();
	}
	
	
	public JPanel interfazDibujo() {
		JPanel panelDeFondo = new JPanel();
		panelDeFondo.setBackground(Color.decode("#303030"));
		panelDeFondo.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, Color.decode("#303030")));
		panelDeFondo.setLayout(new BorderLayout(20, 20));
		panelDeFondo.setLocation(0, 0);
		panelDeFondo.setSize(950, 750);
		
		
		//barra superior
		JPanel barraNavegacion = new JPanel();
		barraNavegacion.setBackground(Color.decode("#FFFFFF"));
		barraNavegacion.setLayout(new GridLayout(1, 3));;
		panelDeFondo.add(barraNavegacion, BorderLayout.NORTH);
		
		JPanel grosorPnl = new JPanel();
		grosorPnl.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.decode("#303030")));
		grosorPnl.setLayout(new GridBagLayout());;
		grosorPnl.setOpaque(false);
		GridBagConstraints nav = new GridBagConstraints(); //crear GridBagConstraints
		nav.fill = GridBagConstraints.HORIZONTAL; //horizontal
		barraNavegacion.add(grosorPnl, BorderLayout.WEST);
		
		JLabel grosorLbl = new JLabel("Tamaño de pincel:");
		grosorLbl.setFont(new Font("Kefe", Font.BOLD, 12)); //fuente, tipo y tamaño
		grosorLbl.setForeground(Color.decode("#000000"));
		nav.fill = GridBagConstraints.HORIZONTAL;
		nav.insets = new Insets(10, 20, 10, 10);  //relleno 
		nav.gridx = 0;
		nav.gridy = 0;
		grosorPnl.add(grosorLbl, nav);
		
		JButton disminuirBtn = new JButton("-");
		disminuirBtn.setBackground(Color.decode("#FFFFFF"));
		disminuirBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		disminuirBtn.setFont(new Font("Kefe", Font.BOLD, 16)); //fuente, tipo y tamaño
		disminuirBtn.setForeground(Color.decode("#000000"));
		nav.fill = GridBagConstraints.HORIZONTAL;
		nav.insets = new Insets(10, 0, 10, 10);  //relleno 
		nav.gridx = 1;
		nav.gridy = 0;
		grosorPnl.add(disminuirBtn, nav);
		
		JComboBox<String> grosoresCmbBx = new JComboBox<>(grosores);
		grosoresCmbBx.setBackground(Color.decode("#FFFFFF"));
		nav.fill = GridBagConstraints.HORIZONTAL;
		nav.insets = new Insets(10, 0, 10, 0);  //relleno 
		nav.gridx = 2;
		nav.gridy = 0;
		grosorPnl.add(grosoresCmbBx, nav);
		
		JButton aumentarBtn = new JButton("+");
		aumentarBtn.setBackground(Color.decode("#FFFFFF"));  
		aumentarBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		aumentarBtn.setFont(new Font("Kefe", Font.PLAIN, 16)); //fuente, tipo y tamaño
		aumentarBtn.setForeground(Color.decode("#000000"));
		nav.fill = GridBagConstraints.HORIZONTAL;
		nav.insets = new Insets(10, 10, 10, 20);  //relleno 
		nav.gridx = 3;
		nav.gridy = 0;
		grosorPnl.add(aumentarBtn, nav);
		
		//pincel
		Image imageBrush = new ImageIcon(getClass().getResource("brushIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageBrushIcon = new ImageIcon(imageBrush);
		JButton pincelBtn = new JButton(imageBrushIcon);
		pincelBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.decode("#303030"))); 
		pincelBtn.setContentAreaFilled(false); //fondo
		pincelBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		pincelBtn.setHorizontalAlignment(JButton.CENTER); //colocar en el centro al botón
		pincelBtn.setText("Pincel");
		barraNavegacion.add(pincelBtn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		pincelBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	pincelBtn.setForeground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	pincelBtn.setForeground(Color.black);
		    }
		});
		
		//borrador
		Image imageEraser = new ImageIcon(getClass().getResource("eraserIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageEraserIcon = new ImageIcon(imageEraser);
		JButton borradorBtn = new JButton(imageEraserIcon);
		//borradorBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.decode("#303030")));   
		borradorBtn.setContentAreaFilled(false); //fondo
		borradorBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		borradorBtn.setHorizontalAlignment(JButton.CENTER); //colocar en el centro al botón
		borradorBtn.setText("Borrador");
		barraNavegacion.add(borradorBtn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		borradorBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	borradorBtn.setForeground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	borradorBtn.setForeground(Color.black);
		    }
		});
		
		
		
		//barra lateral
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(Color.decode("#FFFFFF"));
		barraLateral.setLayout(new GridBagLayout());;
		GridBagConstraints lateral = new GridBagConstraints(); //crear GridBagConstraints
		lateral.fill = GridBagConstraints.HORIZONTAL; //horizontal
		panelDeFondo.add(barraLateral, BorderLayout.WEST);
		
		//panel con matriz de botones de colores
		JPanel panelColores = new JPanel();
		panelColores.setBorder(BorderFactory.createTitledBorder(null, "Colores", 0, 0, null, Color.black));
		panelColores.setLayout(new GridLayout(4, 4));
		panelColores.setOpaque(false);
		lateral.fill = GridBagConstraints.HORIZONTAL;
		lateral.insets = new Insets(0, 10, 20, 10);  //relleno 
		lateral.gridx = 0;
		lateral.gridy = 0;
		lateral.ipady = 90;
		barraLateral.add(panelColores, lateral);
		
		//crear la matriz de botones
		matrizBotones = new JButton[4][4]; 
 		
 		//crear botones
		numPos = 0; //16 valores y posiciones de los botones
 		for(y=0; y<4; y++) { //renglon       	
 			for(x=0; x<4; x++) { //columna
 				matrizBotones[y][x] = new JButton();
 				matrizBotones[y][x].setBackground(Color.decode(colores[numPos]));
 				matrizBotones[y][x].setBorderPainted(false); //hace invisible el borde por defecto de los botones   
 				matrizBotones[y][x].setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
 				agregarAccion(matrizBotones[y][x], y, x); //llamar método que agrega acción al botón
 				panelColores.add(matrizBotones[y][x]); //agregar la matriz de botones al panel para ser visualizado en la ventana
 				numPos++;
 			}
 		}
 		
 		//panel con matriz de botones de colores
		JPanel panelFormas = new JPanel();
		panelFormas.setBorder(BorderFactory.createTitledBorder(null, "Formas", 0, 0, null, Color.black));
		panelFormas.setLayout(new GridLayout(4, 1));
		panelFormas.setOpaque(false);
		lateral.fill = GridBagConstraints.HORIZONTAL;
		lateral.insets = new Insets(0, 10, 20, 10);  //relleno 
		lateral.gridx = 0;
		lateral.gridy = 1;
		lateral.ipady = 90;
		barraLateral.add(panelFormas, lateral);
		
		//rectángulo
		Image imageRect = new ImageIcon(getClass().getResource("rectShapeIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageRectIcon = new ImageIcon(imageRect);
		JButton rectBtn = new JButton(imageRectIcon);
		rectBtn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		rectBtn.setContentAreaFilled(false); //fondo
		rectBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		rectBtn.setHorizontalAlignment(JButton.LEFT); //colocar hacia la izquierda al botón
		rectBtn.setText("Rectángulo");
		panelFormas.add(rectBtn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		rectBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	rectBtn.setForeground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	rectBtn.setForeground(Color.black);
		    }
		});
		
		//círculo
		Image imageCirc = new ImageIcon(getClass().getResource("circleShapeIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageCircIcon = new ImageIcon(imageCirc);
		JButton circBtn = new JButton(imageCircIcon);
		circBtn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		circBtn.setContentAreaFilled(false); //fondo
		circBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		circBtn.setHorizontalAlignment(JButton.LEFT); //colocar hacia la izquierda al botón
		circBtn.setText("Círculo");
		panelFormas.add(circBtn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		circBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	circBtn.setForeground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	circBtn.setForeground(Color.black);
		    }
		});
		
		//triángulo
		Image imageTrian = new ImageIcon(getClass().getResource("triangleShapeIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageTrianIcon = new ImageIcon(imageTrian);
		JButton trianBtn = new JButton(imageTrianIcon);
		trianBtn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		trianBtn.setContentAreaFilled(false); //fondo
		trianBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		trianBtn.setHorizontalAlignment(JButton.LEFT); //colocar hacia la izquierda al botón
		trianBtn.setText("Tríangulo");
		panelFormas.add(trianBtn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		trianBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	trianBtn.setForeground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	trianBtn.setForeground(Color.black);
		    }
		});
		
		//línea
		Image imageLine = new ImageIcon(getClass().getResource("lineShapeIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageLineIcon = new ImageIcon(imageLine);
		JButton lineaBtn = new JButton(imageLineIcon);
		lineaBtn.setBorderPainted(false); //hace invisible el borde por defecto de los botones 
		lineaBtn.setContentAreaFilled(false); //fondo
		lineaBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		lineaBtn.setHorizontalAlignment(JButton.LEFT); //colocar hacia la izquierda al botón
		lineaBtn.setText("Línea");
		panelFormas.add(lineaBtn);
		
		//crear efecto Hover cuando el ratón está encima del botón
		lineaBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	lineaBtn.setForeground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	lineaBtn.setForeground(Color.black);
		    }
		});
		
		//panel con matriz de botones de colores
		JButton limpiarCanvas = new JButton("Limpiar canvas");
		limpiarCanvas.setBackground(Color.decode("#FFFFFF"));
		limpiarCanvas.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#B8CFE5")));
		limpiarCanvas.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		limpiarCanvas.setFont(new Font("Kefe", Font.BOLD, 15)); //fuente, tipo y tamaño
		limpiarCanvas.setForeground(Color.decode("#000000"));
		lateral.fill = GridBagConstraints.HORIZONTAL;
		lateral.insets = new Insets(0, 10, 20, 10);  //relleno 
		lateral.gridx = 0;
		lateral.gridy = 2;
		lateral.ipady = 20;
		barraLateral.add(limpiarCanvas, lateral);
		
		
		
		
		JPanel panelCuadroDibujo = new JPanel();
		panelCuadroDibujo.setBackground(Color.decode("#FFFFFF"));
		panelDeFondo.add(panelCuadroDibujo, BorderLayout.CENTER);
		
		
		
		return panelDeFondo;
	}
	
	
	void agregarAccion(final JButton boton, final int y, final int x) { //dentro del parenteesis obtiene las ubicaciones correspondientes
        boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
			}
        	
        });
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AplicacionDibujo paint = new AplicacionDibujo("Paint");
	}

}
