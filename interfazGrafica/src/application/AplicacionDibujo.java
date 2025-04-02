package application;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AplicacionDibujo extends JFrame implements MouseListener, MouseMotionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PaintPanel panelCuadroDibujo;

	private String grosores[] = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", 
						         "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", 
						         "80", "85" , "90", "95", "100", "125", "150", "175", "200", "225", "250", "275",
						         "300", "325", "350", "375", "400", "425", "450", "475 ", "500"};
	
	private String[] colores = {"#000000", "#404040", "#ED1C24", "#FF6A00",
						"#FFF200", "#22B14C", "#00A2E8", "#3F48CC",
						"#7448CC", "#FF48CC", "#FFFFFF", "#B97A57",
						"#44D5E5", "#7F0000", "#C8A3E7", "#B5E61D"};
	
	
	
	private ArrayList<PuntoSegmento> arregloDePuntos = new ArrayList<PuntoSegmento>(); //SEGMENTOS
	private List<List<PuntoSegmento>> matrizDePuntos = new ArrayList<>(); //TRAZO (SEGMENTOS EN CONJUNTO) 
	
	private ArrayList<PuntoSegmento> arregloDeLineas = new ArrayList<PuntoSegmento>(); //LÍNEAS (FORMA)
	
	private ArrayList<Figura> arregloDeFiguras = new ArrayList<Figura>(); //FIGURAS
	
	private int puntoX, puntoY;
 	
 	Graphics2D g2;
	
	private JButton matrizBotones[][];
	private int x, y;
	private int numPos;
	private int numPuntoLinea = 0; 
	
	private String herramienta = "";
	private boolean relleno;
	private String colorSeleccion = "#000000";
	private int grosorPincel = 1;

	//constructor
	public AplicacionDibujo(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		
		ImageIcon paintIcon = new ImageIcon(getClass().getResource("brushIcon.png"));
		this.setIconImage(paintIcon.getImage());
		
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
	
	
	//panel general
	public JPanel interfazDibujo() {
		JPanel panelDeFondo = new JPanel();
		panelDeFondo.setBackground(Color.decode("#303030"));
		panelDeFondo.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, Color.decode("#303030")));
		panelDeFondo.setLayout(new BorderLayout(20, 20));
		panelDeFondo.setLocation(0, 0);
		panelDeFondo.setSize(950, 750);
		
		
		//barra superior
		JPanel barraNavegacion = new JPanel();
		barraNavegacion.setBorder(BorderFactory.createTitledBorder(null, "Herramientas", 0, 0, null, Color.black));
		barraNavegacion.setBackground(Color.white);
		barraNavegacion.setLayout(new GridLayout(1, 4));;
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
		grosorLbl.setForeground(Color.black);
		nav.fill = GridBagConstraints.HORIZONTAL;
		nav.insets = new Insets(10, 0, 5, 00);  //relleno 
		nav.gridx = 0;
		nav.gridy = 0;
		nav.gridwidth = 3;
		grosorPnl.add(grosorLbl, nav);
		
		JButton disminuirBtn = new JButton("-");
		disminuirBtn.setBackground(Color.white);
		disminuirBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		disminuirBtn.setFont(new Font("Kefe", Font.BOLD, 16)); //fuente, tipo y tamaño
		disminuirBtn.setForeground(Color.black);
		nav.fill = GridBagConstraints.HORIZONTAL;
		nav.insets = new Insets(10, 0, 10, 10);  //relleno 
		nav.gridx = 0;
		nav.gridy = 1;
		nav.gridwidth = 1;
		grosorPnl.add(disminuirBtn, nav);
		
		JComboBox<String> grosoresCmbBx = new JComboBox<>(grosores);
		grosoresCmbBx.setBackground(Color.white);
		nav.fill = GridBagConstraints.HORIZONTAL;
		nav.insets = new Insets(10, 0, 10, 0);  //relleno 
		nav.gridx = 1;
		nav.gridy = 1;
		nav.gridwidth = 1;
		grosorPnl.add(grosoresCmbBx, nav);
		
		//cambiar valor a la variable de grosor cuando se selecciona 
		grosoresCmbBx.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//grosor
				if(e.getStateChange()==ItemEvent.SELECTED) { //si se cambia el elemento seleccionado
					if(!grosoresCmbBx.getSelectedItem().toString().equals(grosores[0])) {
						grosorPincel = Integer.parseInt(grosoresCmbBx.getSelectedItem().toString());
						System.out.println("grosor de pincel: " + grosorPincel);
					}
				}
			}
			
		});
		
		JButton aumentarBtn = new JButton("+");
		aumentarBtn.setBackground(Color.white);  
		aumentarBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		aumentarBtn.setFont(new Font("Kefe", Font.PLAIN, 16)); //fuente, tipo y tamaño
		aumentarBtn.setForeground(Color.black);
		nav.fill = GridBagConstraints.HORIZONTAL;
		nav.insets = new Insets(10, 10, 10, 10);  //relleno 
		nav.gridx = 2;
		nav.gridy = 1;
		nav.gridwidth = 1;
		grosorPnl.add(aumentarBtn, nav);
		
		//acción del botón de aumentar grosor 
		aumentarBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				grosorPincel += 1;//sumar en una unidad
				grosores[0] = String.valueOf(grosorPincel); 
				DefaultComboBoxModel<String> valorMod = new DefaultComboBoxModel<String>(grosores);
				grosoresCmbBx.setModel(valorMod);
				
			}
			
		});
		
		//acción del botón de disminuir grosor 
		disminuirBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(grosorPincel>1) { //si valorPersonalizado vale por lo menos 1
					grosorPincel -= 1;//sumar en una unidad
					grosores[0] = String.valueOf(grosorPincel); 
					DefaultComboBoxModel<String> valorMod = new DefaultComboBoxModel<String>(grosores);
					grosoresCmbBx.setModel(valorMod);
				}
				
				
			}
			
		});
		
		//pincel
		Image imageBrush = new ImageIcon(getClass().getResource("brushIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageBrushIcon = new ImageIcon(imageBrush);
		JButton pincelBtn = new JButton(imageBrushIcon);
		pincelBtn.setBackground(Color.white);
		pincelBtn.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.decode("#303030"))); 
		pincelBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		pincelBtn.setHorizontalAlignment(JButton.CENTER); //colocar en el centro al botón
		pincelBtn.setText("Pincel");
		barraNavegacion.add(pincelBtn);
		
		//agregar accion al botón de pincel
		pincelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				herramienta = "Pincel";
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		pincelBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	pincelBtn.setBackground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	pincelBtn.setBackground(Color.white);
		    }
		});
		
		//balde de pintura
		Image imageBucket= new ImageIcon(getClass().getResource("paintBucketIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageBucketIcon = new ImageIcon(imageBucket);
		JButton bucketBtn = new JButton(imageBucketIcon);
		bucketBtn.setBackground(Color.white);
		bucketBtn.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.decode("#303030"))); 
		bucketBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		bucketBtn.setHorizontalAlignment(JButton.CENTER); //colocar en el centro al botón
		bucketBtn.setText("Cubo de pintura");
		barraNavegacion.add(bucketBtn);
		
		//agregar acción al botón de pintar el cuadro de dibujo
		bucketBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				herramienta = "Cubo";
				panelCuadroDibujo.setBackground(Color.decode(colorSeleccion));
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		bucketBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	bucketBtn.setBackground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	bucketBtn.setBackground(Color.white);
		    }
		});
		
		//borrador
		Image imageEraser = new ImageIcon(getClass().getResource("eraserIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imageEraserIcon = new ImageIcon(imageEraser);
		JButton borradorBtn = new JButton(imageEraserIcon);
		borradorBtn.setBackground(Color.white);
		borradorBtn.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.decode("#303030")));   
		borradorBtn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		borradorBtn.setHorizontalAlignment(JButton.CENTER); //colocar en el centro al botón
		borradorBtn.setText("Borrador");
		barraNavegacion.add(borradorBtn);
		
		//agregar acción al botón de borrar
		borradorBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				herramienta = "Borrador";
			}
			
		});
		
		//crear efecto Hover cuando el ratón está encima del botón
		borradorBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	borradorBtn.setBackground(Color.gray);
		    }

		    public void mouseExited(MouseEvent evt) {
		    	borradorBtn.setBackground(Color.white);
		    }
		});
		
		
		
		//barra lateral
		JPanel barraLateral = new JPanel();
		barraLateral.setBackground(Color.white);
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
		lateral.insets = new Insets(15, 10, 20, 10);  //relleno 
		lateral.gridx = 0;
		lateral.gridy = 0;
		lateral.ipady = 100;
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
 				seleccionarColor(matrizBotones[y][x], colores[numPos]); //llamar método que agrega acción al botón
 				panelColores.add(matrizBotones[y][x]); //agregar la matriz de botones al panel para ser visualizado en la ventana
 				numPos++;
 			}
 		}
 		
 		//panel con matriz de botones de colores
		JPanel panelFormas = new JPanel();
		panelFormas.setBorder(BorderFactory.createTitledBorder(null, "Formas", 0, 0, null, Color.white));
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
		
		//agregar acción al botón que permite añadir rectángulos al cuadro de dibujo
		rectBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				herramienta = "Rectángulo";
			
	 			String mensaje = "¿Figura rellena o contorno de figura?";
	 			
	 			int rellenoOpc = 0;
	 			rellenoOpc = JOptionPane.showConfirmDialog(null, mensaje, "Jugar partida", JOptionPane.YES_NO_OPTION);
	 			
	 	    	if(rellenoOpc==0) { //volver a jugar
	 	    		relleno = true;
	 	    	}else { //si decide no volver a jugar
	 	    		relleno = false;
	 	    	}
			}
			
		});
		
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
		
		//agregar acción al botón que permite añadir círculos al cuadro de dibujo
		circBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				herramienta = "Círculo";
				
				String mensaje = "¿Figura rellena o contorno de figura?";
	 			
	 			int rellenoOpc = 0;
	 			rellenoOpc = JOptionPane.showConfirmDialog(null, mensaje, "Jugar partida", JOptionPane.YES_NO_OPTION);
	 			
	 	    	if(rellenoOpc==0) { //volver a jugar
	 	    		relleno = true;
	 	    	}else { //si decide no volver a jugar
	 	    		relleno = false;
	 	    	}
			}
			
		});
		
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
		
		//agregar acción al botón que permite añadir triángulos al cuadro de dibujo
		trianBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				herramienta = "Triángulo";
				
				String mensaje = "¿Figura rellena o contorno de figura?";
	 			
	 			int rellenoOpc = 0;
	 			rellenoOpc = JOptionPane.showConfirmDialog(null, mensaje, "Jugar partida", JOptionPane.YES_NO_OPTION);
	 			
	 	    	if(rellenoOpc==0) { //volver a jugar
	 	    		relleno = true;
	 	    	}else { //si decide no volver a jugar
	 	    		relleno = false;
	 	    	}
			}
			
		});
		
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
		
		//agregar acción al botón que permite añadir líneas al cuadro de dibujo
		lineaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				herramienta = "Línea";
			}
			
		});
		
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
		limpiarCanvas.setBackground(Color.white);
		limpiarCanvas.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#B8CFE5")));
		limpiarCanvas.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		limpiarCanvas.setFont(new Font("Kefe", Font.BOLD, 15)); //fuente, tipo y tamaño
		limpiarCanvas.setForeground(Color.black);
		lateral.fill = GridBagConstraints.HORIZONTAL;
		lateral.insets = new Insets(0, 10, 20, 10);  //relleno 
		lateral.gridx = 0;
		lateral.gridy = 2;
		lateral.ipady = 20;
		barraLateral.add(limpiarCanvas, lateral);
		
		//acción del botón de borrar todos los trazos del cuadro de dibujo
		limpiarCanvas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				matrizDePuntos.clear(); //limpiar la matriz de puntos
				arregloDeFiguras.clear();
				arregloDeLineas.clear();
				panelCuadroDibujo.setBackground(Color.white);
				panelCuadroDibujo.repaint(); //repintar el cuadro de dibujo para mostrarlo vacío de nuevo
			}
			
		});
		
		
		panelCuadroDibujo = new PaintPanel();
		panelCuadroDibujo.addMouseListener(this);
		panelCuadroDibujo.addMouseMotionListener(this);
		panelDeFondo.add(panelCuadroDibujo, BorderLayout.CENTER);
		
		
		return panelDeFondo;
	}
	
	
	//selección de color
	void seleccionarColor(final JButton boton, final String colorHexadcml) { //dentro del parenteesis obtiene las ubicaciones correspondientes
        boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				colorSeleccion = colorHexadcml; //cambiar el valor al color seleccionado
				
				switch(colorSeleccion) { //mostrar en consola el color seleccionado
					case "#000000": System.out.println("Color del botón: Negro"); break;
					case "#404040": System.out.println("Color del botón: Gris"); break; 
					case "#ED1C24": System.out.println("Color del botón: Rojo"); break; 
					case "#FF6A00": System.out.println("Color del botón: Naranja"); break; 
					
					case "#FFF200": System.out.println("Color del botón: Amarillo"); break;
					case "#22B14C": System.out.println("Color del botón: Verde oscuro"); break;
					case "#00A2E8": System.out.println("Color del botón: Azul claro"); break;
					case "#3F48CC": System.out.println("Color del botón: Azul oscuro");break;
						
					case "#7448CC": System.out.println("Color del botón: Morado"); break;
					case "#FF48CC": System.out.println("Color del botón: Rosa"); break;
					case "#FFFFFF": System.out.println("Color del botón: Blanco"); break;
					case "#B97A57": System.out.println("Color del botón: Café"); break;
							
					case "#44D5E5": System.out.println("Color del botón: Turquesa"); break;
					case "#7F0000": System.out.println("Color del botón: Guinda"); break;
					case "#C8A3E7": System.out.println("Color del botón: Lila"); break;
					case "#B5E61D": System.out.println("Color del botón: Verde limón"); break;
				}
			}
        	
        });
	}
	
	
	//main que ejecuta la ventana
	public static void main(String[] args) {
		new AplicacionDibujo("Paint");
	}


	//dar click y dibujar la figura elegida a través de los botones de formas
	@Override
	public void mouseClicked(MouseEvent e) {
		switch(herramienta) {
			case "Rectángulo":
				System.out.println("CLICKED");
				panelCuadroDibujo.repaint(); 
				puntoX = e.getX();
				puntoY = e.getY();
				arregloDeFiguras.add(new Figura(puntoX, puntoY, grosorPincel, grosorPincel, 1, relleno, colorSeleccion, grosorPincel));
			break;
			
			case "Círculo":
				System.out.println("CLICKED");
				panelCuadroDibujo.repaint(); 
				puntoX = e.getX();
				puntoY = e.getY();
				arregloDeFiguras.add(new Figura(puntoX, puntoY, grosorPincel, grosorPincel, 2, relleno, colorSeleccion, grosorPincel));
			break;
			
			case "Triángulo":
				System.out.println("CLICKED");
				panelCuadroDibujo.repaint(); 
				puntoX = e.getX();
				puntoY = e.getY();
				arregloDeFiguras.add(new Triangulo(puntoX, puntoY, grosorPincel, grosorPincel, 3, relleno, colorSeleccion, grosorPincel));
			break;
			
			case "Línea":
				System.out.println("CLICKED");
				panelCuadroDibujo.repaint(); 
				
				//segun el valor de numPuntoLinea se conoce en que punto de los dos de la línea se encuentra
				if(numPuntoLinea == 0) { //punto uno
					puntoX = e.getX();
					puntoY = e.getY();
					arregloDeLineas.add(new PuntoSegmento(puntoX, puntoY, colorSeleccion, grosorPincel));
					
				}
				if(numPuntoLinea == 1) { //punto dos
					puntoX = e.getX();
					puntoY = e.getY();
					arregloDeLineas.add(new PuntoSegmento(puntoX, puntoY, colorSeleccion, grosorPincel));
					matrizDePuntos.add(arregloDeLineas); //agregar a la matriz que después se usará para pintar
					arregloDeLineas.clear(); //limpiar para separar trazos y que no se junten
				}
				numPuntoLinea += 1; //sumar para entrar a ambas condiciones y que la línea se conforme de dos puntos
			break;
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {	
		   
	}


	//al soltar el ratón
	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(herramienta.equals("Pincel") || herramienta.equals("Borrador") || herramienta.equals("Línea")) {
			System.out.println("RELEASED");
			@SuppressWarnings("unchecked")
			ArrayList<PuntoSegmento> ArrList2  = (ArrayList<PuntoSegmento>)arregloDePuntos.clone(); //crear una copia de los puntos
			matrizDePuntos.add(ArrList2); //se guarda en el historial de dibujos
			arregloDePuntos.clear(); //limpiar para separar trazos y que no se junten
			
			numPuntoLinea = 0; //reiniciar variable para permitir pintar más formas de línea al dar click
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//MouseMotionListener
	//al arrastrar el ratón
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(herramienta.equals("Pincel")) { //solo dibujar cuando se arrastra el cursor y la herramienta es pincel
			System.out.println("DRAGGED");
			panelCuadroDibujo.repaint(); 
			puntoX = e.getX();
			puntoY = e.getY();
			arregloDePuntos.add(new PuntoSegmento(puntoX, puntoY, colorSeleccion, grosorPincel));
		}
		
		if(herramienta.equals("Borrador")) { //solo borrar cuando se arrastra el cursor y la herramienta es borrador
			System.out.println("DRAGGED");
			panelCuadroDibujo.repaint(); 
			puntoX = e.getX();
			puntoY = e.getY();
			arregloDePuntos.add(new PuntoSegmento(puntoX, puntoY, "#FFFFFF", grosorPincel));
		}
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	/////////CLASES/////////
	//clase PaintPanel
	class PaintPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1278175958603073892L;

		public PaintPanel() {
			this.setBackground(Color.white);
		}
		
		@Override
 	    public void paintComponent(Graphics g) {
			System.out.println("Pongan sza");
			super.paintComponent(g);
	       
	        g2 = (Graphics2D)g; 
	        
	        //FIGURAS
	        for(Figura fig: arregloDeFiguras) {
	        	switch(fig.getTipo()) {
					case 1:
						fig.DibujarRect(fig.getX(), fig.getY(), g2);
					break;
					
					case 2:
						fig.DibujarCirc(fig.getX(), fig.getY(), g2);
					break;
					
					case 3:
						Triangulo triangulo = (Triangulo)fig;
						triangulo.DibujarTrian(fig.getX(), fig.getY(), g2);
					break;
				}
	        	panelCuadroDibujo.repaint();
	        }
	        
	        //PINCEL
	        //primer punto
	        if(arregloDePuntos.size()>1) {
	    	    for(int i=1; i<arregloDePuntos.size(); i++) {  
	    	    	PuntoSegmento p1 = arregloDePuntos.get(i-1);
	    	    	PuntoSegmento p2 = arregloDePuntos.get(i);
	    	    	
	    	    	p1.DibujarSegmento(p1.getX(), p1.getY(), p2.getX(), p2.getY(), g2);
	    	    	panelCuadroDibujo.repaint();
	    	    }
	        }
	        
	        //FORMA DE LÍNEA
	        //primer punto
	        if(arregloDeLineas.size()>1) {
	        	for(int i=1; i<arregloDeLineas.size(); i++) {  
	    	    	PuntoSegmento p1 = arregloDeLineas.get(i-1);
	    	    	PuntoSegmento p2 = arregloDeLineas.get(i);
	    	    	
	    	    	p1.DibujarSegmento(p1.getX(), p1.getY(), p2.getX(), p2.getY(), g2);
	    	    	panelCuadroDibujo.repaint();
    	    	}
	        }
	       
	        //HISTORIAL PUNTOS
	        for(@SuppressWarnings("rawtypes") Iterator iterator = matrizDePuntos.iterator(); iterator.hasNext();) { //secuencia de puntos
	        	@SuppressWarnings("unchecked")
				List<PuntoSegmento> trazo = (List<PuntoSegmento>) iterator.next();
			
				if(trazo.size()>1) {
					for(int i=1; i<trazo.size(); i++) {
		    		   PuntoSegmento p1 = trazo.get(i-1);
		    		   PuntoSegmento p2 = trazo.get(i);
		    		   
		    		   p1.DibujarSegmento(p1.getX(), p1.getY(), p2.getX(), p2.getY(), g2);
		    		   panelCuadroDibujo.repaint();
		    	    }
		        }
			
	        }
	        
		}
		
	}
	
	
	//clase segmento de punto
	class PuntoSegmento{

		private int y;
		private int x;
		private String color;
		private int grosor;
		
		public PuntoSegmento(int x, int y, String color, int grosor) {
			this.x = x;
			this.y = y;
			this.color = color;
			this.grosor = grosor;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getX() {
			return x;  
		}

		public void setX(int x) {
			this.x = x;
		}

		public void DibujarSegmento(int p1X, int p1Y, int p2X, int p2Y, Graphics2D g2) {
			g2.setColor(Color.decode(color));
			g2.setStroke(new BasicStroke(grosor));
			g2.drawLine(p1X, p1Y, p2X, p2Y);
		}
		
	}
	
	
	//clase de figura
	class Figura{
		private int y;
		private int x;
		private int w;
		private int h;
		private int tipo;
		private boolean relleno;
		private String color;
		private int grosor;
		
		public Figura(int x, int y, int w, int h, int tipo, boolean relleno, String color, int grosor) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.tipo = tipo;
			this.relleno = relleno;
			this.setColor(color);
			this.setGrosor(grosor);
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
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
		
		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
		
		public int getGrosor() {
			return grosor;
		}

		public void setGrosor(int grosor) {
			this.grosor = grosor;
		}
		
		public boolean isRelleno() {
			return relleno;
		}
		
		public int getTipo() {
			return tipo;
		}

		public void DibujarRect(int x, int y, Graphics2D g2) {
			if(relleno) { //figura rellena o  solo contorno
				g2.setColor(Color.decode(getColor()));
				g2.setStroke(new BasicStroke(getGrosor()/6));
				g2.fillRect(x, y, w, h);
			}else {
				g2.setColor(Color.decode(getColor()));
				g2.setStroke(new BasicStroke(getGrosor()/6));
				g2.drawRect(x, y, w, h);
			}
		}
		
		public void DibujarCirc(int x, int y, Graphics2D g2) {
			if(relleno) { //figura rellena o  solo contorno
				g2.setColor(Color.decode(getColor()));
				g2.setStroke(new BasicStroke(getGrosor()/6));
				g2.fillOval(x, y, w, h);
			}else {
				g2.setColor(Color.decode(getColor()));
				g2.setStroke(new BasicStroke(getGrosor()/6));
				g2.drawOval(x, y, w, h);
			}
		}
	}
	
	
	//clase de triángulo
	class Triangulo extends Figura{
		private int[] grupoX = new int[3];
		private int[] grupoY = new int[3];

		public Triangulo(int x, int y, int w, int h, int tipo, boolean relleno, String color, int grosor) {
			super(x, y, w, h, tipo, relleno, color, grosor);
			// TODO Auto-generated constructor stub
		}
		
		public void DibujarTrian(int x, int y, Graphics2D g2) {
			if(isRelleno()) { //figura rellena o  solo contorno
				grupoX[0] = getX()-(getX()/2); 
				grupoX[1] = getX(); 
				grupoX[2] = getX()+(getX()/2);
				
				grupoY[0] = getY()+(getY()/2);
				grupoY[1] = getY();
				grupoY[2] = getY()+(getY()/2);
				
				g2.setColor(Color.decode(getColor()));
				g2.setStroke(new BasicStroke(getGrosor()/6));
				g2.fillPolygon(grupoX, grupoY, 3);
			}else {
				grupoX[0] = getX()-(getX()/2); 
				grupoX[1] = getX(); 
				grupoX[2] = getX()+(getX()/2);
				
				grupoY[0] = getY()+(getY()/2);
				grupoY[1] = getY();
				grupoY[2] = getY()+(getY()/2);
				
				g2.setColor(Color.decode(getColor()));
				g2.setStroke(new BasicStroke(getGrosor()/6));
				g2.drawPolygon(grupoX, grupoY, 3);
			}
		}
	}
	
}