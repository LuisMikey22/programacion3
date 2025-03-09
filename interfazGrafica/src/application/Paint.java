package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Paint extends JFrame{
	
	int equis[] = {100, 200, 300};
	int yes[] = {500, 150, 300};
	
	int equis2[] = {100, 200, 300};
	int yes2[] = {500, 150, 300};
	
	public Paint(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("vortexIcon.png");
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1000, 750); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(300, 400));
		this.setMaximumSize(new Dimension(1000, 750)); 
		this.setResizable(isMaximumSizeSet());
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g; //convertir la variable g de tipo Graphics a Graphics2D
		
		g2.setColor(Color.red);
		g2.drawRect(200, 120, 200, 200); //pintar silueta figura
		g2.fillRect(200, 120, 200, 200); //pintar relleno figura
		g2.clearRect(200, 120, 20, 20); //borrar porción de figura
		
		g2.setColor(Color.cyan);
		g2.fillRoundRect(400, 200, 800, 800, 30, 30); //rectángulo con esquinas redondeadas
		
		g2.setColor(Color.pink);
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(50, 50, 550, 550);
		
		g2.setColor(Color.decode("#BFE4FF"));
		g2.drawOval(600, 600, 400, 100);
		g2.fillOval(600, 600, 300, 100);
		
		g2.setColor(Color.decode("#AF04FE"));
		g2.drawArc(100, 400, 200, 300, 0, -180);
		g2.fillArc(100, 400, 200, 300, 0, 180);
		
		g2.setColor(new Color(0, 29, 255));
		g2.setFont(new Font("Tahoma", Font.BOLD, 300)); //fuente, tipo y tamaño
		g2.drawString("Chuu", 200, 400);
		
		g2.setColor(Color.red);
		g2.drawPolygon(equis, yes, 3);
		
		g2.setColor(Color.yellow);
		g2.fillPolygon(equis2, yes2, 3);
		
		
		/*BufferedImage image;
		
		try {
			image = ImageIO.read(new File("baldProfilePciture.png"));
			g2.drawImage(image, 700, 250, 100, 100, Color.yellow, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		
		/*Image imageUser = new ImageIcon("baldProfilePicture.png").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon imageUserIcon = new ImageIcon(imageUser);
		
		g2.drawImage(getIconImage(imageUserIcon), WIDTH, SOMEBITS, PROPERTIES, HEIGHT, FRAMEBITS, ERROR, ALLBITS, ABORT, rootPane)*/
		
		
	}
}
