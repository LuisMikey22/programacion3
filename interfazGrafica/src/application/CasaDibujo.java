package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CasaDibujo extends JFrame{
	
	//los puntos se van dibujando en sentido contrario al reloj (hacia la izquierda)
	int xFrente[] = {450,    300,        300,       600,       600};
	int yFrente[] = {300,    500,        700,       725,       525};
				   //arriba, arriba izq, abajo izq, abajo der, arriba der
	
	int xTejadoIzq[] = {440, 590, 1015, 800};
	int yTejadoIzq[] = {295, 545, 560, 360};
	
	int xTejadoDer[] = {275, 300, 450, 440};
	int yTejadoDer[] = {500, 500, 300, 295};
	
	int xCostado[] = {600, 600, 1000, 1000};
	int yCostado[] = {525, 725, 710, 555};

	int xPorcheTecho[] = {300, 190, 530, 610};
	int yPorcheTecho[] = {545, 600, 610, 545};
	
	int xPorchePiso[] = {300, 185, 530, 600};
	int yPorchePiso[] = {700, 730, 750, 705};
	
	int xPisoFrente[] = {185, 185, 530, 530};
	int yPisoFrente[] = {730, 750, 770, 750};
	
	int xPisoCostado[] = {530, 530, 600, 600};
	int yPisoCostado[] = {750, 770, 725, 705};
	
	int xAspa1[] = {900, 1070, 900};
	int yAspa1[] = {130, 200, 200};
	
	int xAspa2[] = {1070, 920, 960};
	int yAspa2[] = {260, 300, 380};
	
	int xAspa3[] = {1130, 1240, 1290};
	int yAspa3[] = {260, 380, 300};
	
	int xAspa4[] = {1040, 1130, 1095};
	int yAspa4[] = {55, 55, 182};
	
	int xVeleta[] = {1300, 1300, 1130};
	int yVeleta[] = {130, 200, 200};
	
	int xTorre[] = {1100, 1050, 1210};
	int yTorre[] = {260, 720, 720};
	
	int xChimenea[] = {800, 770, 830};
	int yChimenea[] = {300, 340, 340};
	
	
	public CasaDibujo(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("courage.png");
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1400, 950); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(1400, 950));
		this.setMaximumSize(new Dimension(1200, 1400)); 
		this.setResizable(isMaximumSizeSet());
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g; //convertir la variable g de tipo Graphics a Graphics2D
		
		//los puntos se van dibujando en sentido contrario al reloj (hacia la izquierda)
		
		//paisaje
		BufferedImage image;
		
		try {
			image = ImageIO.read(new File("sunsetImage.png"));
			g2.drawImage(image, 0, 0, 1400, 1000, Color.gray, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//suelo
		g2.setColor(new Color(238, 188, 137));
		g2.fillRect(0, 700, 1400, 950);	
		
		
		//estructura de la casa
		g2.setColor(new Color(79, 19, 17));
		g2.fillPolygon(xTejadoDer, yTejadoDer, 4);//tejado derecho de la casa
		
		g2.setColor(new Color(224, 91, 21)); 
		g2.fillPolygon(xFrente, yFrente, 5);//frente de la casa
		
		g2.setColor(new Color(105, 5, 7)); 
		g2.fillPolygon(xCostado, yCostado, 4);//costado izquierdo de la casa
		
		g2.setColor(new Color(175, 38, 6));
		g2.fillPolygon(xTejadoIzq, yTejadoIzq, 4); //tejado izquierdo de la casa
		
		
		//sombra de porche
		g2.setColor(new Color(85, 11, 10, 116)); //marco
		g2.fillRect(300, 545, 300, 100);
		
		
		//Ventana
		g2.setColor(new Color(120, 49, 11)); //marco
		g2.fillRect(417, 365, 50, 75);
		
		g2.setColor(new Color(252, 250, 215)); //cristal
		g2.fillRect(422, 370, 40, 65);	
		
		g2.setColor(new Color(120, 49, 11)); //madera horizontal
		g2.fillRect(417, 398, 50, 8);
		
		g2.setColor(new Color(120, 49, 11)); //madera vertical
		g2.fillRect(438, 365, 6, 75);
		
		
		//Ventana
		g2.setColor(new Color(120, 49, 11)); //marco
		g2.fillRect(397, 460, 50, 65);
				
		g2.setColor(new Color(252, 250, 215)); //cristal
		g2.fillRect(402, 465, 40, 55);	
				
		g2.setColor(new Color(120, 49, 11)); //madera horizontal
		g2.fillRect(397, 483, 50, 8);
				
		g2.setColor(new Color(120, 49, 11)); //madera vertical
		g2.fillRect(418, 460, 6, 60);
		
		//Ventana
		g2.setColor(new Color(120, 49, 11)); //marco
		g2.fillRect(347, 580, 50, 65);
						
		g2.setColor(new Color(252, 250, 215)); //cristal
		g2.fillRect(352, 585, 40, 55);	
				
		g2.setColor(new Color(120, 49, 11)); //madera horizontal
		g2.fillRect(347, 603, 50, 8);
						
		g2.setColor(new Color(120, 49, 11)); //madera vertical
		g2.fillRect(368, 580, 6, 60);
		
		//Ventana
		g2.setColor(new Color(120, 49, 11)); //marco
		g2.fillRect(497, 580, 50, 65);
								
		g2.setColor(new Color(252, 250, 215)); //cristal
		g2.fillRect(502, 585, 40, 55);	
						
		g2.setColor(new Color(120, 49, 11)); //madera horizontal
		g2.fillRect(497, 603, 50, 8);
								
		g2.setColor(new Color(120, 49, 11)); //madera vertical
		g2.fillRect(518, 580, 6, 60);
		
		//Ventana
		g2.setColor(new Color(120, 49, 11)); //marco
		g2.fillRect(737, 560, 50, 55);
						
		g2.setColor(new Color(252, 250, 215)); //cristal
		g2.fillRect(742, 565, 40, 45);	
						
		g2.setColor(new Color(120, 49, 11)); //madera horizontal
		g2.fillRect(737, 585, 50, 8);
						
		g2.setColor(new Color(120, 49, 11)); //madera vertical
		g2.fillRect(758, 560, 6, 50);
			
		//Ventana
		g2.setColor(new Color(120, 49, 11)); //marco
		g2.fillRect(837, 620, 50, 55);
						
		g2.setColor(new Color(252, 250, 215)); //cristal
		g2.fillRect(842, 625, 40, 45);	
						
		g2.setColor(new Color(120, 49, 11)); //madera horizontal
		g2.fillRect(837, 645, 50, 8);
						
		g2.setColor(new Color(120, 49, 11)); //madera vertical
		g2.fillRect(858, 620, 6, 50);
		
		
		//porche piso
		g2.setColor(new Color(229, 153, 51));
		g2.fillPolygon(xPorchePiso, yPorchePiso, 4);
		
		//porche piso frente
		g2.setColor(new Color(177, 64, 28));
		g2.fillPolygon(xPisoFrente, yPisoFrente, 4);
		
		//porche piso costado izquierdo
		g2.setColor(new Color(60, 35, 29));
		g2.fillPolygon(xPisoCostado, yPisoCostado, 4); //tejado izquierdo de la casa
				
		
		//puerta
		g2.setColor(new Color(29, 166, 100)); 
		g2.fillRect(420, 600, 50, 100);
		
		//ventana de puerta
		g2.setColor(new Color(32, 8, 46)); 
		g2.fillRect(425, 600, 40, 45);
		
		
		//vigas
		g2.setColor(new Color(89, 70, 50)); 
		g2.fillRect(190, 600, 20, 132);
		
		g2.setColor(new Color(89, 70, 50)); 
		g2.fillRect(512, 610, 20, 140);
		
		
		//porche techo
		g2.setColor(new Color(247, 57, 15));
		g2.fillPolygon(xPorcheTecho, yPorcheTecho, 4);
		

		//molino centro
		g2.setColor(new Color(57, 66, 107));
		g2.fillArc(1050, 180, 95, 95, 0, 360);
		
		//molino aspa 1
		g2.setColor(new Color(57, 66, 107));
		g2.fillPolygon(xAspa1, yAspa1, 3);
		
		//molino aspa 2
		g2.fillPolygon(xAspa2, yAspa2, 3);
		
		//molino aspa 3
		g2.fillPolygon(xAspa3, yAspa3, 3);
		
		//molino aspa 4
		g2.fillPolygon(xAspa4, yAspa4, 3);
		
		//molino veleta
		g2.fillPolygon(xVeleta, yVeleta, 3);
		
		//torre
		g2.setColor(new Color(57, 66, 107));
		g2.setStroke(new BasicStroke(10));
		g2.drawPolygon(xTorre, yTorre, 3);	
		g2.drawLine(1050, 720, 1155, 500);
		g2.drawLine(1210, 720, 1075, 500);
		g2.drawLine(1075, 500, 1130, 400);
		g2.drawLine(1155, 500, 1085, 400);
		
		//molino motor
		g2.setColor(new Color(177, 193, 209));
		g2.fillArc(1075, 205, 45, 45, 0, 360);
		
		//chimenea
		g2.setColor(new Color(118, 129, 133));
		g2.drawLine(720, 440, 770, 440);
		g2.drawLine(770, 440, 770, 380);
		g2.drawLine(770, 380, 800, 380);
		g2.drawLine(800, 380, 800, 340);
		g2.fillPolygon(xChimenea, yChimenea, 3);
		
		//barril
		g2.setColor(new Color(89, 70, 50));
		g2.fillArc(670, 645, 70, 80, 0, 360);
		
		//rueda
		g2.setColor(new Color(173, 138, 101));
		g2.setStroke(new BasicStroke(8));
		g2.drawArc(640, 670, 50, 50, 0, 360);
		
		
		BufferedImage dogImage;
		
		try {
			dogImage = ImageIO.read(new File("courage.png"));
			g2.drawImage(dogImage, 730, 630, 150, 150, null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//carro del abuelo Eustace
		//estructura
		g2.setColor(new Color(91, 78, 87));
		g2.drawLine(980, 740, 1195, 760);
		
		g2.setColor(new Color(11, 170, 169));
		g2.fillRect(890, 660, 160, 90);
		g2.drawRect(945, 600, 100, 80);
		
		//puerta de carro
		g2.setColor(new Color(118, 129, 133));
		g2.fillRect(950, 660, 90, 80);
		
		//manija
		g2.setColor(new Color(31, 28, 34));
		g2.drawLine(1005, 675, 1020, 675);
		
		//cajuela
		g2.setColor(new Color(212, 209, 73));
		g2.fillRect(1050, 665, 250, 80);
		
		//metal de llanta
		g2.setColor(new Color(118, 119, 133));
		g2.fillArc(900, 710, 90, 90, 0, 180);
		
		//llanta
		g2.setColor(new Color(31, 28, 34));
		g2.fillArc(910, 720, 70, 70, 0, 360);
		
		//rin
		g2.setColor(new Color(91, 78, 87));
		g2.fillArc(925, 735, 40, 40, 0, 360);
		
		//llanta
		g2.setColor(new Color(31, 28, 34));
		g2.fillArc(1190, 720, 70, 70, 0, 360);
				
		//rin
		g2.setColor(new Color(91, 78, 87));
		g2.fillArc(1205, 735, 40, 40, 0, 360);
		
		
	}
	
}
