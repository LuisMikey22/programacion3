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

public class MarioBros1 extends JFrame{
	
	//los puntos se van dibujando en sentido contrario al reloj (hacia la izquierda)
	int xFrente[] = {450,    300,        300,       600,       600};
	int yFrente[] = {300,    500,        700,       725,       525};
				   //arriba, arriba izq, abajo izq, abajo der, arriba der
	
	int xTejadoIzq[] = {440, 590, 1015, 800};
	int yTejadoIzq[] = {295, 545, 560, 360};
	
	
	
	
	public MarioBros1(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("MarioBros3.png");
		this.setIconImage(vortexIcon.getImage());
		
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
		g2.setColor(new Color(255,195,184)); 
		g2.fillOval(350, 100, 36, 28); //detalles color salmón
		g2.fillOval(420, 95, 36, 18);
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
		g2.setColor(new Color(255, 195, 184)); 
		g2.fillOval(1210, 210, 36, 28); //detalles color salmón
		g2.fillOval(1280, 205, 36, 18);
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
		g2.setColor(new Color(252, 199, 185)); //primer color
		g2.fillRect(0, 720, 1400, 65);
		g2.setColor(new Color(61, 30, 32)); //segundo color
		g2.fillRect(0, 780, 1400, 110);
		g2.setColor(new Color(4, 10, 6)); //borde líneas
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(0, 720, 1400, 720);
		g2.drawLine(0, 780, 1400, 780);
		
		dibujarDetallesPiso(g2);
		
		//sombra de cuadro azul
		g2.setColor(new Color(4, 10, 6));
		g2.fillRoundRect(660, 405, 200, 320, 10, 30);
		
		//cuadrado azul
		g2.setColor(new Color(4, 10, 6));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRoundRect(500, 350, 300, 370, 30, 30); 
		g2.setColor(new Color(51, 134, 202)); //sombra color azul oscuro
		g2.fillRoundRect(500, 351, 296, 365, 30, 30);
		g2.setColor(new Color(131, 192, 252)); //color
		g2.fillRoundRect(505, 355, 280, 350, 30, 30);
		
		//sombra de cuadro salmón
		g2.setColor(new Color(4, 10, 6));
		g2.fillRoundRect(515, 510, 200, 210, 10, 30);
		
		//cuadrado salmón
		g2.setColor(new Color(4, 10, 6));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRoundRect(350, 460, 300, 260, 30, 30);
		g2.setColor(new Color(243, 155, 112)); //sombra color salmón
		g2.fillRoundRect(352, 462, 296, 254, 30, 30);
		g2.setColor(new Color(255, 195, 184)); //color
		g2.fillRoundRect(355, 465, 280, 240, 30, 30);
			
		//cuadrado verde
		g2.setColor(new Color(4, 10, 6));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRoundRect(1200, 460, 300, 260, 30, 30);
		g2.setColor(new Color(43, 138, 55)); //sombra color verde oscuro
		g2.fillRoundRect(1202, 464, 292, 253, 30, 30);
		g2.setColor(new Color(81, 217, 107)); //color
		g2.fillRoundRect(1207, 468, 278, 238, 30, 30);
		
		//tornillos de cuadro salmón
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(365, 475, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(370, 480, 5, 5, 200, 90);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(615, 475, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(620, 480, 5, 5, 200, 90);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(365, 675, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(370, 680, 5, 5, 200, 90);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(615, 675, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(620, 680, 5, 5, 200, 90);
		
		//tornillos de cuadro azul
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(515, 365, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(520, 370, 5, 5, 200, 90);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(765, 365, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(770, 370, 5, 5, 200, 90);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(765, 675, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(770, 680, 5, 5, 200, 90);
		
		//tornillos de cuadro verde
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(1215, 475, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(1220, 480, 5, 5, 200, 90);
		
		g2.setColor(new Color(5, 4, 2)); //borde
		g2.drawArc(1215, 675, 15, 15, 0, 360);
		g2.setColor(new Color(206, 222, 225)); //metal
		g2.drawArc(1220, 680, 5, 5, 200, 90);
		
		//planta
		g2.setColor(new Color(5, 4, 2)); //bordes
		g2.fillRect(1040, 295, 30, 172); 
		g2.fillArc(1000, 335, 60, 40, 0, -250); 
		g2.fillArc(1050, 335, 60, 40, 180, 250);
		g2.fillArc(1000, 385, 60, 40, 0, 250);
		g2.fillArc(1050, 385, 60, 40, 180, -250);
		g2.fillArc(1000, 245, 90, 80, 200, -340);
		g2.fillArc(1005, 235, 90, 90, 180, -300);

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
		g2.fillOval(1028, 256, 17, 12); //detalle puntos en cabeza
		g2.fillOval(1055, 248, 17, 12);
		g2.fillOval(1063, 275, 17, 12);
		g2.fillOval(1048, 298, 17, 12);
		
		//bola
		g2.setColor(new Color(214, 57, 101)); 
		g2.fillArc(900, 480, 40, 40, 150, -320);
		g2.setColor(new Color(255, 255, 255)); 
		g2.fillOval(918, 488, 17, 12);
		
		BufferedImage dogImage;
		
		try {
			dogImage = ImageIO.read(new File("MarioBros3.png"));
			g2.drawImage(dogImage, 780 , 557, 120, 160, null, null);
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
	
	public void dibujarDetallesPiso(Graphics2D g2) {
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(0, 785, 30, 40);
		g2.fillRect(30, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(60, 785, 30, 40);
		g2.fillRect(90, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(120, 785, 30, 40);
		g2.fillRect(150, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(180, 785, 30, 40);
		g2.fillRect(210, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(240, 785, 30, 40);
		g2.fillRect(270, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(300, 785, 30, 40);
		g2.fillRect(330, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(360, 785, 30, 40);
		g2.fillRect(390, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(420, 785, 30, 40);
		g2.fillRect(450, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(480, 785, 30, 40);
		g2.fillRect(510, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(540, 785, 30, 40);
		g2.fillRect(570, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(600, 785, 30, 40);
		g2.fillRect(630, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(660, 785, 30, 40);
		g2.fillRect(690, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(720, 785, 30, 40);
		g2.fillRect(750, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(780, 785, 30, 40);
		g2.fillRect(810, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(840, 785, 30, 40);
		g2.fillRect(870, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(900, 785, 30, 40);
		g2.fillRect(930, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(960, 785, 30, 40);
		g2.fillRect(990, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(1020, 785, 30, 40);
		g2.fillRect(1050, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(1080, 785, 30, 40);
		g2.fillRect(1110, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(1140, 785, 30, 40);
		g2.fillRect(1170, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(1200, 785, 30, 40);
		g2.fillRect(1230, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(1260, 785, 30, 40);
		g2.fillRect(1290, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(1320, 785, 30, 40);
		g2.fillRect(1350, 825, 30, 40);
		
		g2.setColor(new Color(243,155,112)); //detalles color arena
		g2.fillRect(1380, 785, 30, 40);
		g2.fillRect(1410, 825, 30, 40);
	}
	
}