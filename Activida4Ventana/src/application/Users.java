package application;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Users extends JFrame{
	
	String[] columnNames = {"ID", "Nombre", "Correo electrónico", "Edad", "Estado"};
	
	Object[][] data = {{"10001", "Adriana", "pelosDeRata123@gmail.com", 20, false},
			 		   {"10002", "Bertha", "caguamasA5pesos@gmail.com", 31, true},
			 		   {"10003", "Carlos", "ilovemoviesOMG@gmail.com", 28, false},
			 		   {"10004", "David", "odioProgramar@gmail.com",27, true},
			 		   {"10005", "Eduardo", "karaoke234@gmail.com", 44, false},
			 		   {"10006", "Fátima", "siTeacuerdasDEmi783@gmail.com", 25, false},
			 		   {"10007", "Gerardo", "jjajaJAjaj2_hola@gmail.com", 33, true},
			 		   {"10008", "Hectór", "elefantesrosas34@gmail.com", 55, false},
			 		   {"10009", "Isabella", "JAJAJeJEJIJIJUJU43@gmail.com", 23, true},
			 		   {"100010", "Jonathan", "elSOLmeQueMA29@gmail.com", 49, false},
			 		   {"100011", "Saúl", "lAnostalgiaMEsIGUE_UnU@gmail.com", 36, true},
			 		   {"100012", "Jessica", "piedrasENELARROLLO_23@gmail.com", 52, false}};
	
	public Users(String title) {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		this.setLayout(null); //desactivar los contenedores por defecto
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1000, 600); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla

		this.add(this.users());
		
		this.repaint();
	}
	
	public JPanel users() {
		JPanel usersPnl = new JPanel(); 
		usersPnl.setSize(1000, 600);
		usersPnl.setLocation(0, 0);
		usersPnl.setBackground(Color.decode("#BFE4FF"));
		usersPnl.setOpaque(true);
		
		JLabel userLbl = new JLabel("Usuarios");
		userLbl.setSize(130, 40);
		userLbl.setLocation(435, 32);
		userLbl.setForeground(Color.white); //color de letra
		userLbl.setOpaque(false); //tiene fondo o no
		userLbl.setHorizontalAlignment(JLabel.CENTER);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 28)); //fuente, tipo y tamaño
		this.add(userLbl);
		
		JLabel header = new JLabel();
		header.setSize(1000, 84);
		header.setLocation(0, 0);
		header.setOpaque(true); //tiene fondo o no
		header.setBackground(Color.decode("#33627F"));
		//cabezera.setBackground(Color.decode("#70C5FF"));
		header.setHorizontalAlignment(JLabel.LEFT);
		this.add(header);
		
		JLabel totalUsers = new JLabel("Total de usuarios: ");
		totalUsers.setSize(160, 44);
		totalUsers.setLocation(70, 140);
		totalUsers.setOpaque(false); //tiene fondo o no
		totalUsers.setForeground(Color.white);
		totalUsers.setFont(new Font("Tahoma", Font.BOLD, 14));
		//cabezera.setBackground(Color.decode("#70C5FF"));
		totalUsers.setHorizontalAlignment(JLabel.LEFT);
		this.add(totalUsers);
		
		JLabel usersWdgt = new JLabel();
		usersWdgt.setSize(190, 64);
		usersWdgt.setLocation(50, 130);
		usersWdgt.setOpaque(true); //tiene fondo o no
		usersWdgt.setBackground(Color.decode("#33627F"));
		//cabezera.setBackground(Color.decode("#70C5FF"));
		usersWdgt.setHorizontalAlignment(JLabel.LEFT);
		this.add(usersWdgt);
		
		JButton exportBttn = new JButton("Exportar");
		exportBttn.setSize(140, 50);
		exportBttn.setLocation(630, 150);
		exportBttn.setBackground(Color.decode("#1B313F"));
		exportBttn.setForeground(Color.white); //color de letra
		exportBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		exportBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		exportBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		exportBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		exportBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(exportBttn);
		
		JButton addBttn = new JButton("Añadir");
		addBttn.setSize(140, 50);
		addBttn.setLocation(790, 150);
		addBttn.setBackground(Color.decode("#1B313F"));
		addBttn.setForeground(Color.white); //color de letra
		addBttn.setBorderPainted(false); //hace invisible el borde por defecto de los botones   
		addBttn.setFocusPainted(false); //hace invisible el recuadro blanco al presionar el botón
		addBttn.setHorizontalAlignment(JLabel.LEFT); //centrar el botón
		addBttn.setHorizontalAlignment(SwingConstants.CENTER); // centrar texto del botón
		addBttn.setFont(new Font("Tahoma", Font.BOLD, 18)); //fuente, tipo y tamaño
		this.add(addBttn);
		
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(880, 200);
		scrollPane.setLocation(50, 250);
		this.add(scrollPane);
		
		return usersPnl;
	}

}