package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class HomeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -616534150229589047L;
	private ImageIcon imageIcon;
	//private Image image;
	private JFrame frame;
	
	public HomeView() {
		
	}
	
	public void home() {
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
		

	    JLabel cabecera = new JLabel("Home");
		cabecera.setSize(1000, 80);
		cabecera.setLocation(0, 0);
		cabecera.setOpaque(false);
		cabecera.setForeground(Color.white);
		cabecera.setHorizontalAlignment(JLabel.CENTER);
		homeBckGrndPnl.add(cabecera, BorderLayout.NORTH);
		
		
		JPanel widgets = new JPanel();
		widgets.setOpaque(false);
		widgets.setSize(1000, 850);
		widgets.setLocation(0, 0);
		widgets.setLayout(new GridLayout(2, 2));
	    homeBckGrndPnl.add(widgets, BorderLayout.CENTER);
	    
	    JLabel usuariosRegistrados = new JLabel("<html> Usuarios registrados: <br> 100 en la última hora </html>");
	    usuariosRegistrados.setOpaque(true);
	    usuariosRegistrados.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.yellow)); 
	    usuariosRegistrados.setBackground(Color.pink);
	    usuariosRegistrados.setForeground(Color.decode("#1B313F"));
	    usuariosRegistrados.setHorizontalAlignment(SwingConstants.CENTER);
	    usuariosRegistrados.setLayout(new GridLayout(3, 1));
	    widgets.add(usuariosRegistrados);
	    
	    JLabel notificaciones = new JLabel("<html> Notificaciones: <br> +5 notificaciones y mensajes sin leer</html>");
	    notificaciones.setOpaque(true);
	    notificaciones.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.orange)); 
	    notificaciones.setBackground(Color.yellow);
	    notificaciones.setForeground(Color.decode("#1B313F"));
	    notificaciones.setHorizontalAlignment(SwingConstants.CENTER);
	    notificaciones.setLayout(new GridLayout(3, 1));
	    widgets.add(notificaciones);
	    
	    JLabel horaLocal = new JLabel();
	    horaLocal.setOpaque(true);
	    horaLocal.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.cyan)); 
	    horaLocal.setBackground(Color.orange);
	    horaLocal.setForeground(Color.decode("#1B313F"));
	    horaLocal.setHorizontalAlignment(SwingConstants.CENTER);
	    horaLocal.setLayout(new GridLayout(3, 1));
	    widgets.add(horaLocal);
	    
	    JLabel estadisticas = new JLabel("<html> Usuarios que visitan la app: <br> +60 en la última hora </html>");
	    estadisticas.setOpaque(true);
	    estadisticas.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.pink)); 
	    estadisticas.setBackground(Color.cyan);
	    estadisticas.setForeground(Color.decode("#1B313F"));
	    estadisticas.setHorizontalAlignment(SwingConstants.CENTER);
	    estadisticas.setLayout(new GridLayout(3, 1));
	    widgets.add(estadisticas);
	    
	  
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss"); //Formato de horas, minutos y segundos

	    Timer temporizador = new Timer(1000, new ActionListener() { //temporizador que se actualiza cada segundo
			@Override
			public void actionPerformed(ActionEvent e) {
				ZonedDateTime actual = ZonedDateTime.now(ZoneId.of("America/Mazatlan"));
		        horaLocal.setText("<html> Hora local: <br>" + actual.format(formato) + " La Paz BCS </html>");
			}
		});   
	    temporizador.start();

	    JPanel panelBotones = new JPanel();
	    panelBotones.setBounds(0, 60, 200, 640);
	    panelBotones.setBackground(Color.decode("#1B313F"));
	    panelBotones.setLayout(new GridLayout(3, 1));
	    homeBckGrndPnl.add(panelBotones, BorderLayout.WEST);
	    
	    JButton usuarios = new JButton("Usuarios");
	    usuarios.setBackground(Color.decode("#33627F"));
	    usuarios.setForeground(Color.white);
	    panelBotones.add(usuarios);
	    
	    usuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String message = "<html> Usted ha accedido al panel de usuarios. <br> Total de usuarios: 1,215. </html>";
				JOptionPane.showMessageDialog(null, message, "Usuarios", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
	    	
	    });
	    
	    JButton registros = new JButton("Registros");
	    registros.setBackground(Color.decode("#33627F"));
	    registros.setForeground(Color.white);
	    panelBotones.add(registros);
	    
	    registros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String message = "<html> Usted ha accedido al panel de registros. <br> El sistema abarca más de 1000 registros. </html>";
				JOptionPane.showMessageDialog(null, message, "Registros", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
	    	
	    });
	    
	    JButton confg = new JButton("Configuración");
	    confg.setBackground(Color.decode("#33627F"));
	    confg.setForeground(Color.white);
	    panelBotones.add(confg);
	    
	    confg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String message = "<html> Usted ha accedido al panel de configuración. <br> ¿Qué acción desea realizar? </html>";
				JOptionPane.showMessageDialog(null, message, "Configuración", JOptionPane.INFORMATION_MESSAGE); //ventana emergente
			}
	    	
	    });
	    
		frame.setVisible(true);
	}
}
