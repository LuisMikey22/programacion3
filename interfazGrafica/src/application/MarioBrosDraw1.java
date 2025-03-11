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

public class MarioBrosDraw1 extends JFrame{
	
	public MarioBrosDraw1(String title) {
		this.setTitle(title); //colocar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon MarioCharacter = new ImageIcon("MarioBros3.png");
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
		g2.setColor(new Color(179, 238, 254));
		g2.fillRect(0, 0, 1400, 950);

		
		//caja 1
		g2.setColor(new Color(255,145,94)); //color
		g2.fillRect(343, 73, 114, 114);
		g2.setColor(new Color(4, 10, 6));
		//detalles puntos
		g2.fillRect(353, 83, 10, 10); 
		g2.fillRect(437, 83, 10, 10);
		g2.fillRect(353, 167, 10, 10);
		g2.fillRect(437, 167, 10, 10);
		g2.setColor(new Color(4, 10, 6)); 
		g2.fillOval(350, 100, 36, 28); //sombra de detalles color salmón
		g2.fillOval(420, 95, 36, 18);
		g2.setColor(new Color(255,195,184)); 
		g2.fillOval(350, 100, 32, 22); //detalles color salmón
		g2.fillOval(420, 95, 32, 12);
		g2.setColor(new Color(4, 10, 6));
		g2.setStroke(new BasicStroke(7)); //borde
		g2.drawRect(340, 70, 120, 120);
		
		
		//caja 2
		g2.setColor(new Color(255, 145, 94)); //color
		g2.fillRect(463, 73, 114, 114);
		g2.setColor(new Color(4, 10, 6)); 
		//detalles puntos
		g2.fillRect(472, 83, 10, 10); 
		g2.fillRect(556, 83, 10, 10); 
		g2.fillRect(472, 167, 10, 10);
		g2.fillRect(556, 167, 10, 10);
		g2.setStroke(new BasicStroke(7)); //borde
		g2.drawRect(460, 70, 120, 120);
		
		
		//caja 3
		g2.setColor(new Color(255, 145, 94)); //color
		g2.fillRect(103, 333, 114, 114);
		g2.setColor(new Color(4, 10, 6)); 
		//detalles puntos
		g2.fillRect(113, 343, 10, 10); 
		g2.fillRect(197, 343, 10, 10); 
		g2.fillRect(113, 427, 10, 10); 
		g2.fillRect(197, 427, 10, 10);
		g2.setStroke(new BasicStroke(7)); //borde
		g2.drawRect(100, 330, 120, 120);
		
		
		//caja 4
		g2.setColor(new Color(255, 145, 94)); //color
		g2.fillRect(1203, 183, 114, 114);
		g2.setColor(new Color(4, 10, 6)); 
		//detalles puntos
		g2.fillRect(1213, 193, 10, 10);
		g2.fillRect(1297, 193, 10, 10);
		g2.fillRect(1213, 277, 10, 10);
		g2.fillRect(1297, 277, 10, 10);
		g2.setColor(new Color(4, 10, 6)); 
		g2.fillOval(1210, 210, 36, 28); //sombra de detalles color salmón
		g2.fillOval(1280, 205, 36, 18);
		g2.setColor(new Color(255, 195, 184)); 
		g2.fillOval(1210, 210, 32, 22); //detalles color salmón
		g2.fillOval(1280, 205, 32, 12);
		g2.setColor(new Color(4, 10, 6)); 
		g2.setStroke(new BasicStroke(7)); //borde
		g2.drawRect(1200, 180, 120, 120);
		
		
		//arbusto
		g2.setColor(new Color(4, 10, 6)); //borde
		g2.fillOval(45, 615, 130, 130);
		g2.fillOval(85, 575, 90, 130);
		g2.fillOval(125, 635, 90, 130);
		g2.setColor(new Color(27, 136, 5)); //color verder
		g2.fillOval(50, 620, 120, 120);
		g2.fillOval(90, 580, 80, 120);
		g2.fillOval(130, 640, 80, 120);
		g2.setColor(new Color(92, 219, 122)); // color ver claro
		g2.fillOval(60, 630, 100, 100); 
		g2.fillOval(100, 590, 60, 100);
		g2.fillOval(140, 650, 60, 100);
		g2.setColor(new Color(170, 255, 207)); //destellos
		g2.fillOval(70, 670, 40, 10);
		g2.fillOval(85, 655, 10, 40);
		g2.fillOval(110, 620, 40, 10);
		g2.fillOval(125, 605, 10, 40);
		g2.fillOval(140, 680, 40, 10);
		g2.fillOval(155, 665, 10, 40);
		
		
		//piso
		g2.setColor(new Color(61, 30, 32)); //segundo color
		g2.fillRect(0, 780, 1400, 110);
		g2.setColor(new Color(252, 199, 185)); //primer color
		g2.fillRect(0, 720, 1400, 85);
		
		//detalles del piso color arena
		for(int i=-30; i<1400; i+=40) {
			g2.setColor(new Color(243,155,112));
			g2.setStroke(new BasicStroke(15));
			g2.drawLine(i, 785, i+60, 865);
			
			/*g2.fillRect(i, 785, 30, 40);
			g2.fillRect(i+30, 825, 30, 40);*/
		}
		
		g2.setColor(new Color(4, 10, 6)); //borde líneas
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(0, 720, 1400, 720);
		g2.drawLine(0, 780, 1400, 780);
		
		
		//sombra de cuadro azul
		g2.setColor(new Color(4, 10, 6));
		g2.fillRoundRect(660, 405, 170, 320, 10, 30);
		
		//cuadrado azul
		g2.setColor(new Color(4, 10, 6));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRoundRect(500, 350, 270, 370, 30, 30); 
		g2.setColor(new Color(51, 134, 202)); //sombra color azul oscuro
		g2.fillRoundRect(500, 351, 266, 365, 30, 30);
		g2.setColor(new Color(131, 192, 252)); //color
		g2.fillRoundRect(505, 355, 250, 350, 30, 30);
		
		
		//sombra de cuadro salmón
		g2.setColor(new Color(4, 10, 6));
		g2.fillRoundRect(575, 510, 130, 210, 10, 30);
		
		//cuadrado salmón
		g2.setColor(new Color(4, 10, 6));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRoundRect(380, 460, 270, 260, 30, 30);
		g2.setColor(new Color(243, 155, 112)); //sombra color salmón
		g2.fillRoundRect(382, 462, 266, 254, 30, 30);
		g2.setColor(new Color(255, 195, 184)); //color
		g2.fillRoundRect(385, 465, 250, 240, 30, 30);
			
		
		//cuadrado verde
		g2.setColor(new Color(4, 10, 6));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRoundRect(1220, 460, 300, 260, 30, 30);
		g2.setColor(new Color(43, 138, 55)); //sombra color verde oscuro
		g2.fillRoundRect(1222, 464, 292, 253, 30, 30);
		g2.setColor(new Color(81, 217, 107)); //color
		g2.fillRoundRect(1227, 468, 278, 238, 30, 30);
		
		//tornillos de cuadro salmón
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(390, 470, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(395, 475, 20, 20, 20, -305);
	
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(610, 470, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(615, 475, 20, 20, 20, -305);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(390, 680, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(395, 685, 20, 20, 20, -305);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(610, 680, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(615, 685, 20, 20, 20, -305);
		
		
		//tornillos de cuadro azul
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(510, 360, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(515, 365, 20, 20, 20, -305);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(725, 360, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(730, 365, 20, 20, 20, -305);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(725, 680, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(730, 685, 20, 20, 20, -305);
		
		
		//tornillos de cuadro verde
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(1230, 470, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(1235, 475, 20, 20, 20, -305);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillArc(1230, 680, 30, 30, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.fillArc(1235, 685, 20, 20, 20, -305);
		
		
		//planta
		g2.setColor(new Color(5, 4, 2)); //bordes
		g2.fillRect(1040, 295, 30, 172); 
		g2.fillArc(1000, 335, 60, 40, 0, -250); 
		g2.fillArc(1050, 335, 60, 40, 180, 250);
		g2.fillArc(1000, 385, 60, 40, 0, 250);
		g2.fillArc(1050, 385, 60, 40, 180, -250);
		g2.fillArc(1000, 245, 90, 80, 0, 360);
		g2.fillArc(1005, 235, 90, 90, 180, -300);
		//estructura
		g2.setColor(new Color(92, 219, 122));
		g2.fillRect(1045, 300, 20, 162); //tallo
		g2.fillArc(1005, 340, 50, 30, 0, -250); //hojas
		g2.fillArc(1055, 340, 50, 30, 180, 250);
		g2.fillArc(1005, 390, 50, 30, 0, 250);
		g2.fillArc(1055, 390, 50, 30, 180, -250);
		g2.setColor(new Color(255, 255, 255)); 
		g2.fillArc(1005, 250, 80, 70, 200, -340); //boca
		g2.setColor(new Color(200, 43, 24)); 
		g2.fillArc(1010, 240, 80, 80, 180, -300); //cabeza roja
		g2.setColor(new Color(255, 255, 255));
		g2.fillOval(1028, 256, 17, 12); //detalles puntos en cabeza
		g2.fillOval(1055, 248, 17, 12);
		g2.fillOval(1063, 275, 17, 12);
		g2.fillOval(1048, 298, 17, 12);
		g2.setColor(new Color(4, 10, 6));//bordes interiores
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(1020, 340, 1028, 352);
		g2.drawLine(1028, 352, 1038, 352);
		g2.drawLine(1090, 340, 1080, 352);
		g2.drawLine(1068, 352, 1078, 352);
		g2.drawLine(1020, 420, 1028, 404);
		g2.drawLine(1030, 402, 1042, 402);
		g2.drawLine(1090, 418, 1080, 404);
		g2.drawLine(1068, 402, 1078, 402);
		
		//bola
		g2.setColor(new Color(214, 57, 101)); 
		g2.fillArc(900, 480, 40, 40, 150, -320);
		g2.setColor(new Color(255, 255, 255)); 
		g2.fillOval(918, 488, 17, 12);
		
		BufferedImage characterImage;
		try {
			characterImage = ImageIO.read(new File("MarioBros3.png"));
			g2.drawImage(characterImage, 725 , 557, 100, 160, null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dibujarPipaVerde(g2);
	
	}
	
	public void dibujarPipaVerde(Graphics2D g2) {
		g2.setColor(new Color(27, 136, 5)); //color base
		g2.fillRect(990, 477, 130, 238);
		g2.setColor(new Color(5, 4, 2)); //color negro 
		g2.fillRect(990, 477, 5, 238);
		g2.setColor(new Color(79, 216, 107)); //color menta
		g2.fillRect(1005, 477, 5, 238);
		g2.fillRect(1015, 477, 10, 238);
		g2.fillRect(1035, 477, 5, 238);
		g2.fillRect(1055, 477, 10, 238);
		g2.fillRect(1010, 477, 5, 238);
		g2.fillRect(1015, 477, 5, 238);
		g2.setColor(new Color(1, 67, 1)); //color verde oscuro
		g2.fillRect(1060, 477, 10, 238);
		g2.fillRect(1080, 477, 10, 238);
		g2.setColor(new Color(5, 4, 2)); //color negro 
		g2.fillRect(1090, 477, 30, 238);
		g2.setColor(new Color(79, 216, 107)); //color menta
		g2.fillRect(1105, 477, 5, 238);

		g2.setColor(new Color(5, 4, 2)); //borde
		g2.fillRect(965, 457, 180, 70);
		g2.setColor(new Color(27, 136, 5)); //color base, parte de arriba
		g2.fillRect(970, 462, 170, 60);
		g2.setColor(new Color(79, 216, 107)); //color menta
		g2.fillRect(980, 462, 5, 60);
		g2.fillRect(1005, 462, 10, 60);
		g2.fillRect(1025, 462, 5, 60);
		g2.fillRect(1045, 462, 10, 60);
		g2.fillRect(1000, 462, 5, 60);
		g2.fillRect(1005, 462, 5, 60);
		g2.setColor(new Color(1, 67, 1)); //color verde oscuro
		g2.fillRect(1050, 462, 10, 60);
		g2.fillRect(1070, 462, 10, 60);
		g2.setColor(new Color(5, 4, 2)); //color negro 
		g2.fillRect(1100, 462, 30, 60);
		g2.setColor(new Color(79, 216, 107)); //color menta
		g2.fillRect(1115, 462, 5, 60);
	}

	public static void main(String[] args) {
		MarioBrosDraw1 draw1 = new MarioBrosDraw1("Marios Bros escena 1");	
	}
}