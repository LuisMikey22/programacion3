package application;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class AplicacionDibujo extends JFrame implements MouseListener, MouseMotionListener {

	private JFrame frame;
	
	private PaintPanel panel;
	
	Color color;
	
	 ArrayList<PointCuztom> puntos = new ArrayList<PointCuztom>();
	
	int grosorSlider;
 	
 	List<List<PointCuztom>> listaDePuntos = new ArrayList<>(); 
 	
 	
 	int puntoX, puntoY;
	
 	 Graphics2D g2;

	
	private  AplicacionDibujo() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 255));
		frame.setBackground(new Color(0, 0, 255));
		frame.setBounds(100, 100, 1005, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new PaintPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel.setBounds(30, 199, 934, 504);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel_1.setBounds(30, 10, 934, 179);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tools");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 10, 45, 13);
		panel_2.add(lblNewLabel);
		
		JButton Pincel = new JButton();
		Pincel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Pincel.setBackground(new Color(255, 255, 255));
		Pincel.setBounds(28, 37, 50, 50);
		panel_2.add(Pincel);
		
		JButton Borrador = new JButton();
		Borrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.white;
			}
		});
		Borrador.setBackground(new Color(255, 255, 255));
		Borrador.setBounds(88, 37, 50, 50);
		panel_2.add(Borrador);
		
		JButton Regresar = new JButton();
		Regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Regresar.setBackground(new Color(255, 255, 255));
		Regresar.setBounds(165, 37, 50, 50);
		panel_2.add(Regresar);
		
		JButton LimpiaPantalla = new JButton();
		LimpiaPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDePuntos.clear();
		        puntos.clear();
		        panel.repaint();
			}
		});
		LimpiaPantalla.setBackground(new Color(255, 255, 255));
		LimpiaPantalla.setBounds(225, 37, 50, 50);
		panel_2.add(LimpiaPantalla);
		
		JSlider Grosor = new JSlider();
		Grosor.setValue(1);
		Grosor.setMaximum(20);
		Grosor.setBounds(52, 107, 200, 26);
		// ChangeListener sirve para actualizar el valor del grosor
		Grosor.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                grosorSlider = Grosor.getValue();
                
            }
        });
		panel_2.add(Grosor);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText("Figures");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(134, 10, 45, 13);
		panel_3.add(lblNewLabel_1);
		
		JButton Rectangulo = new JButton();
		Rectangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Rectangulo.setBackground(new Color(255, 255, 255));
		Rectangulo.setBounds(58, 40, 50, 50);
		panel_3.add(Rectangulo);
		
		JButton Cuadrado = new JButton();
		Cuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Cuadrado.setBackground(new Color(255, 255, 255));
		Cuadrado.setBounds(209, 40, 50, 50);
		panel_3.add(Cuadrado);
		
		JButton Circulo = new JButton();
		Circulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Circulo.setBackground(new Color(255, 255, 255));
		Circulo.setBounds(58, 100, 50, 50);
		panel_3.add(Circulo);
		
		JButton Linea = new JButton();
		Linea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Linea.setBackground(new Color(255, 255, 255));
		Linea.setBounds(209, 100, 50, 50);
		panel_3.add(Linea);
		
		JButton Flecha = new JButton();
		Flecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Flecha.setBackground(new Color(255, 255, 255));
		Flecha.setBounds(134, 100, 50, 50);
		panel_3.add(Flecha);
		
		JButton Triangulo = new JButton();
		Triangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Triangulo.setBackground(new Color(255, 255, 255));
		Triangulo.setBounds(134, 40, 50, 50);
		panel_3.add(Triangulo);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Colors");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(140, 10, 45, 13);
		panel_4.add(lblNewLabel_2);
		
		JButton ColorNegro = new JButton();
		ColorNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = new Color(0, 0, 0);
			}
		});
		ColorNegro.setBackground(new Color(0, 0, 0));
		ColorNegro.setBounds(42, 42, 50, 50);
		panel_4.add(ColorNegro);
		
		JButton ColorRojo = new JButton();
		ColorRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = new Color(255, 0, 0);
			}
		});
		ColorRojo.setBackground(new Color(255, 0, 0));
		ColorRojo.setBounds(102, 42, 50, 50);
		panel_4.add(ColorRojo);
		
		JButton ColorAzul = new JButton();
		ColorAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = new Color(0, 0, 255);
			}
		});
		ColorAzul.setBackground(new Color(0, 0, 255));
		ColorAzul.setBounds(164, 42, 50, 50);
		panel_4.add(ColorAzul);
		
		JButton ColorRosa = new JButton();
		ColorRosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = new Color(255, 128, 255);
			}
		});
		ColorRosa.setBackground(new Color(255, 128, 255));
		ColorRosa.setBounds(224, 42, 50, 50);
		panel_4.add(ColorRosa);
		
		JButton ColorAmarillo = new JButton();
		ColorAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = new Color(255, 255, 0);
			}
		});
		ColorAmarillo.setBackground(new Color(255, 255, 0));
		ColorAmarillo.setBounds(102, 99, 50, 50);
		panel_4.add(ColorAmarillo);
		
		JButton ColorVerde = new JButton();
		ColorVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = new Color(0, 255, 0);
			}
		});
		ColorVerde.setBackground(new Color(0, 255, 0));
		ColorVerde.setBounds(42, 99, 50, 50);
		panel_4.add(ColorVerde);
		
		JButton ColorNaranja = new JButton();
		ColorNaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = new Color(255, 128, 0);
			}
		});
		ColorNaranja.setBackground(new Color(255, 128, 0));
		ColorNaranja.setBounds(164, 99, 50, 50);
		panel_4.add(ColorNaranja);
		
		JButton ColorBlanco = new JButton();
		ColorBlanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = new Color(255, 255, 255);
			}
		});
		ColorBlanco.setBackground(new Color(255, 255, 255));
		ColorBlanco.setBounds(224, 99, 50, 50);
		panel_4.add(ColorBlanco);
		
		panel.addMouseListener(this);
 		panel.addMouseMotionListener(this);
	}

	public static void main(String[] args) {
		new AplicacionDibujo();
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//crear una copia de los puntos
 		@SuppressWarnings("rawtypes")
		ArrayList ArrList2  = (ArrayList)puntos.clone();
 		
 		//se guarda en el historial de dibujos
 		listaDePuntos.add(ArrList2);
 		
 		//limpiamos el trazo actual
 		puntos.clear();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hola");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Adios");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		panel.repaint(); 
		puntoX = e.getX();
		puntoY = e.getY();
		listaDePuntos.add(new PointCuztom(puntoX, puntoY, color, grosorSlider));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("serial")
	class PaintPanel extends JPanel{
		
 		public PaintPanel()
 		{
 			this.setBackground(Color.white);
 		}
 		
 		@Override
 	   public void paintComponent(Graphics g) {
 	       super.paintComponent(g);
 	      
 	       g2 = (Graphics2D) g; 
 	       
 	       //cambiar el color depende el color que se selecciona
 	       g2.setColor(color);
 	       
 	       //cambia el grosor segun se seleccione en el slider
 	       g2.setStroke(new BasicStroke(grosorSlider)); 
 		   
 	       //dibujar la trayectoria de puntos 
 	       //solo cuando tengo más de 2 puntos
 	       if(puntos.size()>1) {
 	    	   
 	    	   for (int i = 1; i < puntos.size(); i++) {
 	    		   
 	    		  PointCuztom p1 = puntos.get(i-1);
 	    		 PointCuztom p2 = puntos.get(i);
 	    		   
 	    		   g2.drawLine(p1.x,p1.y,p2.x,p2.y);
 	    		   
 	    		   
 	    	   }
 	    	   
 	       }
 	       
 	       for (@SuppressWarnings("rawtypes")
 	       	Iterator iterator = listaDePuntos.iterator(); iterator.hasNext();) {
 			@SuppressWarnings("unchecked")
			List<PointCuztom> trazo = (List<PointCuztom>) iterator.next();
 			
 			
 				if(trazo.size()>1) {
 		    	   
 		    	   for (int i = 1; i < trazo.size(); i++) {
 		    		   
 		    		   PointCuztom p1 = trazo.get(i-1);
 		    		  PointCuztom p2 = trazo.get(i);
 		    		   
 		    		   g2.drawLine(p1.x,p1.y,p2.x,p2.y);
 		    	   }
 		    	   
 		       }
 			
 	       }
 	       
 	   }
 				
 	}
	
	class PointCuztom{
		
		public int y;
		public int x;
		private Color color;
		private int grosor;
		
		public PointCuztom(int x, int y, Color color, int grosor) {
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

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public int getGrosor() {
			return grosor;
		}

		public void setGrosor(int grosor) {
			this.grosor = grosor;
		}

		public void nuevoTrazo(int p1X, int p1Y, int p2X, int p2Y, Graphics2D g2) {
			g2.setColor(color);
			g2.setStroke(new BasicStroke(grosor));
			g2.drawLine(p1X, p1Y, p2X,p2Y);
		}
		
	}
	
}
