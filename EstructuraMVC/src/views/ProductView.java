package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProductView {
	
	JFrame frame;
	ImageIcon imageIcon;
	
	public ProductView() {
		
	}
	public void product(/*JSONArray data*/) {
		frame = new JFrame();
		frame.setTitle("Home"); //crear JFrame y colocar título a la ventana
		frame.setResizable(true); //redimensionar la ventana
		
		imageIcon = new ImageIcon(AuthView.class.getResource("/images/vortexIcon.png"));
		frame.setIconImage(imageIcon.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		frame.setSize(1000, 850); //colocar tamaño predeterminado
		frame.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		frame.setMinimumSize(new Dimension(1000, 850));
		frame.setResizable(true);
		
		JPanel homeBckGrndPnl = new JPanel();
		homeBckGrndPnl.setLayout(new BorderLayout()); 
		homeBckGrndPnl.setBackground(Color.decode("#1B313F"));
		homeBckGrndPnl.setSize(1000, 850);
		homeBckGrndPnl.setLocation(0, 0);
		frame.setContentPane(homeBckGrndPnl);
		
		/*int x = 70;
 		
 		for (Object product1 : data) {
 			
 			JSONObject product = (JSONObject) product1;
 			System.out.println(product.get("title"));
 			
 			JLabel lblNewLabel2 = new JLabel((String) product.get("title"));
 			lblNewLabel2.setForeground(new Color(0, 0, 0));
 			//lblNewLabel2.setFont(new Font("Kefa", Font.PLAIN, 24));
 			lblNewLabel2.setBounds(107, x, 210, 26);
 			lblNewLabel2.setHorizontalAlignment(JLabel.CENTER);
 			panel.add(lblNewLabel2);
 			
 			x+=35;
 			
 		}*/
 		
 		//data.forEach( emp -> parseTestData( (JSONObject) emp ) );
 		 
 	}
 	
 	/*private static void parseTestData(JSONObject product) {
 		
 		// Obtener valores directamente del objeto producto
 	    String title = (String) product.get("title");   
 	    System.out.println("Title: " + title);
 	      
 	    String description = (String) product.get("description");   
 	    System.out.println("Description: " + description);
 	      
 	    String category = (String) product.get("category"); 
 	    System.out.println("Category: " + category); 
 	    
     }*/
}
