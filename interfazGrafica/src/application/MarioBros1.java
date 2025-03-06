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
		
		ImageIcon vortexIcon = new ImageIcon("vortexIcon.png");
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
		
		//los puntos de los polígonos se van dibujando en sentido contrario al reloj (hacia la izquierda)
		//cielo
		g2.setColor(new Color(145, 235, 255));
		g2.fillRect(0, 0, 1400, 950);
		
		//cajas
		g2.setColor(new Color(237, 125, 88));
		g2.fillRect(345, 75, 110, 110);
		g2.setColor(new Color(0, 0, 0));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRect(340, 70, 120, 120);
		
		g2.setColor(new Color(237, 125, 88));
		g2.fillRect(465, 75, 110, 110);
		g2.setColor(new Color(0, 0, 0));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRect(460, 70, 120, 120);
		
		g2.setColor(new Color(237, 125, 88));
		g2.fillRect(105, 275, 110, 110);
		g2.setColor(new Color(0, 0, 0));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRect(100, 270, 120, 120);
		
		g2.setColor(new Color(237, 125, 88));
		g2.fillRect(1205, 275, 110, 110);
		g2.setColor(new Color(0, 0, 0));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRect(1200, 270, 120, 120);
		
		//piso
		g2.setColor(new Color(237, 187, 138));
		g2.fillRect(0, 780, 1400, 950);
		g2.setColor(new Color(128, 100, 74));
		g2.fillRect(0, 830, 1400, 950);
		
		//sombra
		g2.setColor(new Color(0, 0, 0));
		g2.fillRoundRect(660, 475, 200, 320, 10, 30);
		
		//cuadrado azul
		g2.setColor(new Color(0, 0, 0));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRoundRect(500, 380, 300, 410, 20, 120); //borde
		g2.setColor(new Color(110, 194, 240));
		g2.fillRoundRect(505, 385, 290, 400, 15, 115);
		
		//sombra
		g2.setColor(new Color(0, 0, 0));
		g2.fillRoundRect(515, 540, 200, 250, 10, 30);
		
		//cuadrado salmón
		g2.setColor(new Color(0, 0, 0));//borde
		g2.setStroke(new BasicStroke(10));
		g2.drawRoundRect(350, 500, 300, 290, 20, 120);//borde
		g2.setColor(new Color(247, 205, 190));
		g2.fillRoundRect(355, 505, 290, 280, 15, 115);
		
		
		/*BufferedImage image;
		
		try {
			image = ImageIO.read(new File("sunsetImage.png"));
			g2.drawImage(image, 0, 0, 1400, 1000, Color.gray, null);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		
		
		
	}
	
}