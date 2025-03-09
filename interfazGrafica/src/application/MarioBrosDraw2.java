package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MarioBrosDraw2 extends JFrame{
	
	//los puntos se van dibujando en sentido contrario al reloj (hacia la izquierda)
	int xCesped[] = {0,   0,   25,  50,  75,  100, 125, 150, 175, 200, 225, 250, 275,  300,  325,  350,  375,  400,  425,  450,  475,  500,  525,  550,  575,  600,  625,  650,  675,  
					 700, 725, 750, 775, 800, 825, 850, 875, 900, 925, 950, 975, 1000, 1025, 1050, 1075, 1100, 1125, 1150, 1175, 1200, 1225, 1250, 1275, 1300, 1325, 1350, 1375, 1400, 1400};
	                                     																															
	int yCesped[] = {720, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735,
					 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 735, 755, 720};
				   //arriba, arriba izq, abajo izq, abajo der, arriba der;
																																										 
	int yCespedBorde[] = {720, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745,
						  765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 745, 765, 720};
	
	int yCespedSombra[] = {720, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740,  
						   760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 740, 760, 720};
	
	
	
	
	
	public MarioBrosDraw2(String title) {
		this.setTitle(title); //colocar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon MarioCharacter = new ImageIcon("MarioWorld.png");
		this.setIconImage(MarioCharacter.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1400, 950); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(1400, 950));
		this.setResizable(isMaximumSizeSet());
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g; //convertir la variable g de tipo Graphics a Graphics2D
		
		//los puntos de los polígonos se van dibujando en sentido contrario al reloj (hacia la izquierda)
		
		//cielo
		g2.setColor(new Color(6, 101, 192));
		g2.fillRect(0, 0, 1400, 950);
		
		
		//nubes atras de las torres
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(350, 530, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(350, 530, 230, 55, 80, 80);
		
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(230, 600, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(230, 600, 230, 55, 80, 80);
		
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(350, 670, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(350, 670, 230, 55, 80, 80);
		
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(980, 190, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(980, 190, 230, 55, 80, 80);
		
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(920, 255, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(920, 255, 230, 55, 80, 80);
		
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(1120, 455, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(1120, 455, 230, 55, 80, 80);
		
		
		//torre 1 azul verdoso
		g2.setColor(new Color(156, 198, 193)); //color oscuro
		g2.fillArc(50, 250, 250, 250, 0, 360);	
		g2.fillRect(50, 375, 250, 360);
		g2.setColor(new Color(184, 221, 223)); //color medio
		g2.fillArc(50, 250, 225, 250, 0, 360);	 
		g2.fillRect(50, 375, 225, 360);
		g2.setColor(new Color(201, 225, 231)); //color claro
		g2.fillArc(50, 250, 200, 250, 0, 360);	
		g2.fillRect(50, 380, 200, 360);
		
		
		//torre 2 azul verdoso
		g2.setColor(new Color(156, 198, 193)); //color oscuro
		g2.fillArc(480, 250, 250, 250, 0, 360);	
		g2.fillRect(480, 375, 250, 360);
		g2.setColor(new Color(184, 221, 223)); //color medio
		g2.fillArc(480, 250, 225, 250, 0, 360);	
		g2.fillRect(480, 375, 225, 360);
		g2.setColor(new Color(201, 225, 231)); //color claro
		g2.fillArc(480, 250, 200, 250, 0, 360);	
		g2.fillRect(480, 380, 200, 360);
		
		
		//torre 3 azul verdoso
		g2.setColor(new Color(156, 198, 193)); //color oscuro
		g2.fillArc(730, 100, 250, 250, 0, 360);	
		g2.fillRect(730, 220, 250, 550);
		g2.setColor(new Color(184, 221, 223)); //color medio
		g2.fillArc(730, 100, 225, 225, 0, 360);	
		g2.fillRect(730, 230, 225, 510);
		g2.setColor(new Color(201, 225, 231)); //color claro
		g2.fillArc(730, 100, 200, 200, 0, 360);	
		g2.fillRect(730, 220, 200, 550);
		
		
		//nubes adelante de las torres
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(0, 360, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(0, 360, 230, 55, 80, 80);
		
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(300, 430, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(300, 430, 230, 55, 80, 80);
		
		g2.setColor(new Color(184, 221, 223)); //sombra
		g2.fillRoundRect(670, 390, 240, 65, 80, 80);
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(670, 390, 230, 55, 80, 80);
		
		
		//torre 1 azul 
		g2.setColor(new Color(24, 87, 123)); //color oscuro
		g2.fillArc(0, 500, 250, 250, 0, 360);	
		g2.fillRect(0, 625, 250, 160);
		g2.setColor(new Color(69, 131, 167)); //color medio
		g2.fillArc(10, 510, 225, 250, 0, 360);	 
		g2.fillRect(10, 630, 225, 160);
		g2.setColor(new Color(118, 178, 215)); //color claro
		g2.fillArc(10, 510, 200, 250, 0, 360);	
		g2.fillRect(10, 635, 200, 160);
		
		
		//torre 2 azul 
		g2.setColor(new Color(24, 87, 123)); //color oscuro
		g2.fillArc(480, 500, 320, 250, 0, 360);	
		g2.fillRect(480, 625, 320, 160);
		g2.setColor(new Color(69, 131, 167)); //color medio
		g2.fillArc(490, 510, 295, 250, 0, 360);	 
		g2.fillRect(490, 630, 295, 160);
		g2.setColor(new Color(118, 178, 215)); //color claro
		g2.fillArc(490, 510, 270, 250, 0, 360);	
		g2.fillRect(490, 635, 270, 160);
		
		
		//torre 3 azul 
		g2.setColor(new Color(24, 87, 123)); //color oscuro
		g2.fillArc(800, 300, 270, 250, 0, 360);	
		g2.fillRect(800, 425, 270, 360);
		g2.setColor(new Color(69, 131, 167)); //color medio
		g2.fillArc(810, 310, 245, 250, 0, 360);	 
		g2.fillRect(810, 435, 245, 360);
		g2.setColor(new Color(118, 178, 215)); //color claro
		g2.fillArc(810, 310, 220, 250, 0, 360);	
		g2.fillRect(810, 440, 220, 360);
		
		
		//torre 4 azul 
		g2.setColor(new Color(24, 87, 123)); //color oscuro
		g2.fillArc(1240, 360, 270, 250, 0, 360);	
		g2.fillRect(1240, 485, 270, 360);
		g2.setColor(new Color(69, 131, 167)); //color medio
		g2.fillArc(1250, 370, 245, 250, 0, 360);	 
		g2.fillRect(1250, 495, 245, 360);
		g2.setColor(new Color(118, 178, 215)); //color claro
		g2.fillArc(1250, 370, 220, 250, 0, 360);	
		g2.fillRect(1250, 500, 220, 360);
		
		
		//detalles de puntos en las torres
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillRoundRect(200, 310, 25, 40, 80, 80);
		g2.fillRoundRect(200, 430, 25, 40, 80, 80);
		g2.fillRoundRect(100, 455, 25, 40, 80, 80);
		g2.fillRoundRect(495, 498, 25, 40, 80, 80);
		g2.fillRoundRect(495, 370, 25, 40, 80, 80);
		g2.fillRoundRect(580, 320, 25, 40, 80, 80);
		g2.fillRoundRect(765, 310, 25, 40, 80, 80);
		g2.fillRoundRect(850, 160, 25, 40, 80, 80);
		g2.setColor(new Color(201, 225, 231)); //color menta
		g2.fillRoundRect(880, 360, 25, 40, 80, 80);
		g2.fillRoundRect(960, 560, 25, 40, 80, 80);
		
		
		//nube
		g2.setColor(new Color(239, 243, 255)); //color
		g2.fillOval(980, 620, 230, 155);
		
		
		//arbusto
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillOval(270, 650, 60, 90);		
		g2.fillOval(290, 630, 60, 110);	
		g2.fillOval(310, 650, 60, 90);	
		g2.fillOval(330, 670, 60, 70);	
		g2.fillOval(350, 650, 60, 90);	
		g2.fillOval(370, 630, 60, 110);
		g2.fillOval(390, 670, 60, 77);
		g2.setColor(new Color(21, 92, 46)); //sombra
		g2.fillOval(275, 655, 50, 80);		
		g2.fillOval(295, 635, 50, 100);	
		g2.fillOval(315, 655, 50, 80);	
		g2.fillOval(335, 675, 50, 60);	
		g2.fillOval(355, 655, 50, 80);	
		g2.fillOval(375, 635, 50, 100);
		g2.fillOval(395, 675, 50, 60);
		g2.setColor(new Color(2, 204, 0)); //color claro
		g2.fillOval(280, 660, 40, 70);		
		g2.fillOval(300, 640, 40, 90);	
		g2.fillOval(320, 660, 40, 70);	
		g2.fillOval(340, 680, 40, 50);	
		g2.fillOval(360, 660, 40, 70);	
		g2.fillOval(380, 640, 40, 90);
		g2.fillOval(400, 680, 40, 50);
		g2.setColor(new Color(239, 243, 255)); 
		g2.fillRoundRect(305, 660, 15, 25, 80, 80); //detalles en el arbusto
		g2.setColor(new Color(203, 158, 93)); 
		g2.fillRoundRect(375, 665, 15, 25, 80, 80); //detalles en el arbusto
		g2.fillRoundRect(400, 685, 15, 25, 80, 80);
		
		
		//pipas
		dibujarPipaAzul(g2);
		
		
		//bloque de piedra 1
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1100, 645, 80, 80, 40, 40);
		g2.setColor(new Color(124, 124, 126)); //color gris oscuro
		g2.fillRoundRect(1100, 645, 70, 70, 40, 40);
		g2.setColor(new Color(198, 194, 204)); //color gris claro
		g2.fillRoundRect(1100, 645, 60, 60, 40, 40);
		g2.setColor(new Color(240, 239, 246)); //luz
		g2.fillRoundRect(1100, 645, 50, 50, 40, 40);
		
		
		//bloque de piedra 2
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1100, 565, 80, 80, 40, 40);
		g2.setColor(new Color(124, 124, 126)); //color gris oscuro
		g2.fillRoundRect(1100, 565, 70, 70, 40, 40);
		g2.setColor(new Color(198, 194, 204)); //color gris claro
		g2.fillRoundRect(1100, 565, 60, 60, 40, 40);
		g2.setColor(new Color(240, 239, 246)); //luz
		g2.fillRoundRect(1100, 565, 50, 50, 40, 40);
		
		
		//bloque de piedra 3
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1100, 485, 80, 80, 40, 40);
		g2.setColor(new Color(124, 124, 126)); //color gris oscuro
		g2.fillRoundRect(1100, 485, 70, 70, 40, 40);
		g2.setColor(new Color(198, 194, 204)); //color gris claro
		g2.fillRoundRect(1100, 485, 60, 60, 40, 40);
		g2.setColor(new Color(240, 239, 246)); //luz
		g2.fillRoundRect(1100, 485, 50, 50, 40, 40);
	
		
		//bloque de piedra 4
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1100, 405, 80, 80, 40, 40);
		g2.setColor(new Color(124, 124, 126)); //color gris oscuro
		g2.fillRoundRect(1100, 405, 70, 70, 40, 40);
		g2.setColor(new Color(198, 194, 204)); //color gris claro
		g2.fillRoundRect(1100, 405, 60, 60, 40, 40);
		g2.setColor(new Color(240, 239, 246)); //luz
		g2.fillRoundRect(1100, 405, 50, 50, 40, 40);
		
		
		//bloque de piedra 5
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1340, 645, 80, 80, 40, 40);
		g2.setColor(new Color(124, 124, 126)); //color gris oscuro
		g2.fillRoundRect(1340, 645, 70, 70, 40, 40);
		g2.setColor(new Color(198, 194, 204)); //color gris claro
		g2.fillRoundRect(1340, 645, 60, 60, 40, 40);
		g2.setColor(new Color(240, 239, 246)); //luz
		g2.fillRoundRect(1340, 645, 50, 50, 40, 40);
		
		
		//bloque de piedra 6
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1340, 565, 80, 80, 40, 40);
		g2.setColor(new Color(124, 124, 126)); //color gris oscuro
		g2.fillRoundRect(1340, 565, 70, 70, 40, 40);
		g2.setColor(new Color(198, 194, 204)); //color gris claro
		g2.fillRoundRect(1340, 565, 60, 60, 40, 40);
		g2.setColor(new Color(240, 239, 246)); //luz
		g2.fillRoundRect(1340, 565, 50, 50, 40, 40);
		
		
		//bloque de piedra 7
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1340, 485, 80, 80, 40, 40);
		g2.setColor(new Color(124, 124, 126)); //color gris oscuro
		g2.fillRoundRect(1340, 485, 70, 70, 40, 40);
		g2.setColor(new Color(198, 194, 204)); //color gris claro
		g2.fillRoundRect(1340, 485, 60, 60, 40, 40);
		g2.setColor(new Color(240, 239, 246)); //luz
		g2.fillRoundRect(1340, 485, 50, 50, 40, 40);
		
		
		//bloque de piedra 8
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1340, 405, 80, 80, 40, 40);
		g2.setColor(new Color(124, 124, 126)); //color gris oscuro
		g2.fillRoundRect(1340, 405, 70, 70, 40, 40);
		g2.setColor(new Color(198, 194, 204)); //color gris claro
		g2.fillRoundRect(1340, 405, 60, 60, 40, 40);
		g2.setColor(new Color(240, 239, 246)); //luz
		g2.fillRoundRect(1340, 405, 50, 50, 40, 40);
		
		
		//bloque amarillo 1
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1180, 405, 80, 80, 40, 40);
		g2.setColor(new Color(221, 167, 27)); //color amarillo oscuro
		g2.fillRoundRect(1180, 405, 75, 70, 40, 40);
		g2.setColor(new Color(250, 222, 41)); //color amarillo claro
		g2.fillRoundRect(1180, 405, 70, 65, 40, 40);
		g2.setColor(new Color(5, 4, 2)); //ojos
		g2.fillOval(1200, 425, 8, 18);
		g2.fillOval(1225, 425, 8, 18);
		
		//bloque amarillo 2
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRoundRect(1260, 405, 80, 80, 40, 40);
		g2.setColor(new Color(221, 167, 27)); //color amarillo oscuro
		g2.fillRoundRect(1260, 405, 75, 70, 40, 40);
		g2.setColor(new Color(250, 222, 41)); //color amarillo claro
		g2.fillRoundRect(1260, 405, 70, 65, 40, 40);
		g2.setColor(new Color(5, 4, 2)); //ojos
		g2.fillOval(1280, 425, 8, 18);
		g2.fillOval(1305, 425, 8, 18);
		
		
		//planta
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(630, 395, 60, 60, -45, 270);
		g2.fillArc(625, 305, 70, 95, 45, -270);
		g2.fillArc(615, 325, 90, 90, 45, -270);
		g2.setColor(new Color(23, 186, 5)); //tallo
		g2.fillArc(635, 400, 50, 50, -45, 270);
		g2.setColor(new Color(240, 239, 246)); //boca
		g2.fillArc(630, 310, 60, 85, 45, -270);
		g2.setColor(new Color(195, 0, 1)); //cabeza
		g2.fillArc(620, 330, 80, 80, 45, -270);
		g2.setColor(new Color(240, 239, 246)); //puntos de la cabeza
		g2.fillOval(628, 364, 15, 15);
		g2.fillOval(653, 378, 15, 15);
		g2.fillOval(635, 384, 15, 15);
		g2.fillOval(675, 360, 15, 15);
		g2.fillOval(675, 380, 15, 15);
		g2.setColor(new Color(4, 10, 6));//bordes internos
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(636, 322, 660, 349);
		g2.drawLine(660, 349, 682, 322);
		g2.drawLine(628, 342, 660, 369);
		g2.drawLine(660, 369, 690, 340);
		g2.drawLine(642, 439, 660, 423);
		g2.drawLine(660, 423, 676, 439);
		
		
		//piso
		g2.setColor(new Color(203, 158, 93)); //color tierra
		g2.fillRect(0, 720, 1400, 170);
		
		//piedras color arena
		g2.setColor(new Color(240, 201, 108)); 
		for(int i=30; i<1400; i+=50) {
			g2.fillOval(i, 765, 15, 25); 
			g2.fillOval(i+30, 815, 15, 25);
		}
		
		
		//césped
		g2.setColor(new Color(65, 47, 14)); //sombra
		g2.fillPolygon(xCesped, yCespedBorde, 59);
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillPolygon(xCesped, yCespedSombra, 59);
		g2.setColor(new Color(2, 204, 0)); //color claro
		g2.fillPolygon(xCesped, yCesped, 59);
		
		g2.setColor(new Color(5, 4, 2)); //borde de piso 
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(0, 720, 1400, 720);
		
		BufferedImage characterImage;
		try {
			characterImage = ImageIO.read(new File("MarioWorld.png"));
			g2.drawImage(characterImage, 490 , 557, 90, 160, null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void dibujarPipaAzul(Graphics2D g2) {
		//pipa grande
		g2.setColor(new Color(76, 72, 151)); //color base
		g2.fillRect(590, 477, 130, 238);
		g2.setColor(new Color(5, 4, 2)); //color negro 
		g2.fillRect(590, 477, 10, 238);
		g2.setColor(new Color(147, 149, 197)); //color azul claro
		g2.fillRect(610, 477, 45, 238);
		g2.setColor(new Color(236, 242, 254)); //color blanco azulado
		g2.fillRect(620, 477, 15, 238);
		g2.setColor(new Color(113, 109, 183)); //color azul medio
		g2.fillRect(655, 477, 35, 238);
		g2.setColor(new Color(5, 4, 2)); //color negro 
		g2.fillRect(705, 477, 25, 238);
		g2.setColor(new Color(147, 149, 197)); //color azul claro
		g2.fillRect(700, 477, 10, 238);

		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRect(565, 457, 185, 70);
		g2.setColor(new Color(76, 72, 151)); //color base, parte de arriba
		g2.fillRect(580, 462, 145, 60);
		g2.setColor(new Color(147, 149, 197)); //color azul claro
		g2.fillRect(590, 462, 15, 60);
		g2.fillRect(615, 462, 30, 60);
		g2.setColor(new Color(236, 242, 254)); //color blanco azulado
		g2.fillRect(600, 462, 15, 60);
		g2.setColor(new Color(113, 109, 183)); //color azul medio
		g2.fillRect(645, 462, 35, 60);
		g2.setColor(new Color(147, 149, 197)); //color azul claro
		g2.fillRect(690, 462, 15, 60);
		
		//pipa chica
		g2.setColor(new Color(76, 72, 151)); //color base
		g2.fillRect(1190, 577, 130, 238);
		g2.setColor(new Color(5, 4, 2)); //color negro 
		g2.fillRect(1190, 577, 10, 238);
		g2.setColor(new Color(147, 149, 197)); //color azul claro
		g2.fillRect(1210, 577, 45, 238);
		g2.setColor(new Color(236, 242, 254)); //color blanco azulado
		g2.fillRect(1220, 577, 15, 238);
		g2.setColor(new Color(113, 109, 183)); //color azul medio
		g2.fillRect(1255, 577, 35, 238);
		g2.setColor(new Color(5, 4, 2)); //color negro 
		g2.fillRect(1305, 577, 25, 238);
		g2.setColor(new Color(147, 149, 197)); //color azul claro
		g2.fillRect(1300, 577, 10, 238);

		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRect(1165, 557, 185, 70);
		g2.setColor(new Color(76, 72, 151)); //color base, parte de arriba
		g2.fillRect(1180, 562, 145, 60);
		g2.setColor(new Color(147, 149, 197)); //color azul claro
		g2.fillRect(1190, 562, 15, 60);
		g2.fillRect(1215, 562, 30, 60);
		g2.setColor(new Color(236, 242, 254)); //color blanco azulado
		g2.fillRect(1200, 562, 15, 60);
		g2.setColor(new Color(113, 109, 183)); //color azul medio
		g2.fillRect(1245, 562, 35, 60);
		g2.setColor(new Color(147, 149, 197)); //color azul claro
		g2.fillRect(1290, 562, 15, 60);
	}
	
	public static void main(String[] args) {
		MarioBrosDraw2 draw2 = new MarioBrosDraw2("Marios Bros escena 2");	
	}
}