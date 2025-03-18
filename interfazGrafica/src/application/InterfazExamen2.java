package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterfazExamen2 extends JFrame{
	
	String[] columnas = {"Producto", "Cantidad", "Precio", "Sub Total"};
	
	Object[][] filas = {{"Agua", 23, 9.00, 23*9.00},
			 		    {"Leche", 40, 25.12, 40*25.12},
			 		    {"Cereal", 15, 39.50, 15*39.50},
			 		    {"Agua", 23, 9.00, 23*9.00},
			 		    {"Leche", 40, 25.12, 40*25.12},
			 		    {"Cereal", 15, 39.50, 15*39.50},
			 		    {"Agua", 23, 9.00, 23*9.00},
			 		    {"Leche", 40, 25.12, 40*25.12},
			 		    {"Cereal", 15, 39.50, 15*39.50}};

	public InterfazExamen2(String title)  {
		this.setTitle(title); //colorcar título a la ventana
		this.setVisible(true); //hacer visible la ventana
		this.setResizable(true); //redimensionar la ventana
		//this.setLayout(null); //desactivar los contenedores por defecto
		
		ImageIcon vortexIcon = new ImageIcon("vortexIcon.png");
		this.setIconImage(vortexIcon.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana si se presiona la X
		this.setSize(1000, 850); //colocar tamaño predeterminado
		this.setLocationRelativeTo(null); //colocar la ventana en el centro de la pantalla
		this.setMinimumSize(new Dimension(1000, 850));
		//this.setMaximumSize(new Dimension(1100, 950));
		this.setResizable(isMaximumSizeSet());

		this.add(this.factura(), BorderLayout.CENTER);
		
		this.validate();
		this.revalidate();
		this.repaint();
	}
	
	public JPanel factura() {
		
		JPanel panelFondo = new JPanel();
		panelFondo.setSize(1000, 850);
		panelFondo.setLocation(0, 0);
		panelFondo.setOpaque(true);
		panelFondo.setBackground(Color.white);
		panelFondo.setLayout(new BorderLayout());
		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setSize(1000, 700);
		panelGeneral.setLocation(0, 75);
		panelGeneral.setOpaque(false);
		panelGeneral.setLayout(new GridLayout(5, 1));
		panelFondo.add(panelGeneral, BorderLayout.CENTER);
		
		//panel etiquetas
		JPanel etiquetas = new JPanel();
		etiquetas.setOpaque(true);
		etiquetas.setBackground(Color.decode("#266fff"));
		etiquetas.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.decode("#266fff")));
		etiquetas.setLayout(new GridLayout(2, 1));
		
		JLabel cabecera = new JLabel("Factura en Java - NetBeans - ArrayList y POO");
		cabecera.setForeground(Color.white);
		cabecera.setOpaque(false);
		cabecera.setFont(new Font("Tahoma", Font.BOLD, 20)); //fuente, tipo y tamaño
		etiquetas.add(cabecera);
		
		JLabel cabeceraPequeña = new JLabel("[Sin base de datos]");
		cabeceraPequeña.setForeground(Color.white);
		cabeceraPequeña.setOpaque(false);
		cabeceraPequeña.setFont(new Font("Tahoma", Font.BOLD, 15)); //fuente, tipo y tamaño
		etiquetas.add(cabeceraPequeña);
		
		panelFondo.add(etiquetas, BorderLayout.NORTH);
		
		
		
		//panel con los datos del cliente
		JPanel datosCliente = new JPanel();
		datosCliente.setOpaque(true);
		datosCliente.setBackground(Color.white);
		datosCliente.setBorder(BorderFactory.createTitledBorder("Datos del cliente"));
		datosCliente.setLayout(new GridLayout(2, 4, 10, 30));
		
		JLabel documentoLbl = new JLabel("Documento:");
		documentoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		datosCliente.add(documentoLbl);
		
		JTextField documentoTxtFld = new JTextField();
		datosCliente.add(documentoTxtFld);
		
		JLabel nombreLbl = new JLabel("Nombres:");
		nombreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		datosCliente.add(nombreLbl);
		
		JTextField nombreTxtFld = new JTextField();
		datosCliente.add(nombreTxtFld);
		
		JLabel direccionLbl = new JLabel("Dirección:");
		direccionLbl.setHorizontalAlignment(SwingConstants.CENTER);
		datosCliente.add(direccionLbl);
		
		JTextField direccionTxtFld = new JTextField();
		datosCliente.add(direccionTxtFld);
		
		JLabel telefonoLbl = new JLabel("Teléfono:");
		telefonoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		datosCliente.add(telefonoLbl);
		
		JTextField telefonoTxtFld = new JTextField();
		datosCliente.add(telefonoTxtFld);
		
		panelGeneral.add(datosCliente);	
		
		
		
		//panel con los datos de la factura
		JPanel datosFactura = new JPanel();
		datosFactura.setOpaque(true);
		datosFactura.setBackground(Color.white);
		datosFactura.setBorder(BorderFactory.createTitledBorder("Datos de factura"));
		datosFactura.setLayout(new GridLayout(1, 4, 10, 10));
		
		JLabel noFacturaLbl = new JLabel("Nº de factura:");
		noFacturaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		datosFactura.add(noFacturaLbl);
		
		JLabel noFacturaLblNum = new JLabel("hverg4e5g4");
		noFacturaLblNum.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		noFacturaLblNum.setHorizontalAlignment(SwingConstants.LEFT);
		datosFactura.add(noFacturaLblNum);
		
		JLabel fechaLbl = new JLabel("Fecha:");
		fechaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		datosFactura.add(fechaLbl);
		
		JLabel fechaLblNum = new JLabel("2/6/2020");
		fechaLblNum.setFont(new Font("Tahoma", Font.BOLD, 12)); //fuente, tipo y tamaño
		fechaLblNum.setHorizontalAlignment(SwingConstants.LEFT);
		datosFactura.add(fechaLblNum);
		
		panelGeneral.add(datosFactura);
		
		
		
		//panel con botones
		JPanel botonesAccion = new JPanel();
		botonesAccion.setOpaque(true);
		botonesAccion.setBackground(Color.white);
		botonesAccion.setBorder(BorderFactory.createMatteBorder(40, 0, 40, 0, Color.white));
		botonesAccion.setLayout(new GridLayout(1, 4));
		
		//botón para ver listado de facturas
		Image image = new ImageIcon("listIcon.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		JButton listaBoton = new JButton("Ver listado de facturas                             ");
		listaBoton.setIcon(imageIcon);
		listaBoton.setBorder(null);
		listaBoton.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		botonesAccion.add(listaBoton);
		
		//botón para añadir
		image = new ImageIcon("addIcon.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton agregarBoton = new JButton("Añadir");
		agregarBoton.setIcon(imageIcon);
		agregarBoton.setBorder(null);
		agregarBoton.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		botonesAccion.add(agregarBoton);
		
		//botón para eliminar
		image = new ImageIcon("cancelIcon.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JButton eliminarBoton = new JButton("Eliminar");
		eliminarBoton.setIcon(imageIcon);
		eliminarBoton.setBorder(null);
		eliminarBoton.setContentAreaFilled(false); //hace invisible la animacion al presionar el botón
		botonesAccion.add(eliminarBoton);
	
		panelGeneral.add(botonesAccion);
		
		
		
		//panel con tabla de productos
		JTable tabla = new JTable(filas, columnas);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setSize(880, 200);		
		panelGeneral.add(scrollPane);
		
		
		
		//panel de calculos
		JPanel calculos = new JPanel();
		calculos.setOpaque(true);
		calculos.setBackground(Color.white);
		calculos.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, Color.white));
		calculos.setLayout(new GridLayout(1, 2, 80, 0));
		
		//panel izquierdo
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setOpaque(false);
		panelIzquierdo.setLayout(new GridLayout(4, 2));
		
		JLabel subtotalLbl = new JLabel("SubTotal:");
		subtotalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		panelIzquierdo.add(subtotalLbl);
		
		JLabel subtotalNum = new JLabel("1000");
		subtotalNum.setHorizontalAlignment(SwingConstants.LEFT);
		panelIzquierdo.add(subtotalNum);
		
		JLabel descuentoLbl = new JLabel("% de Descuento:");
		descuentoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		panelIzquierdo.add(descuentoLbl);
		
		JTextField descuentoTxtFld = new JTextField();
		panelIzquierdo.add(descuentoTxtFld);
		
		JLabel IVALbl = new JLabel("IVA 19%:");
		IVALbl.setHorizontalAlignment(SwingConstants.LEFT);
		panelIzquierdo.add(IVALbl);
		
		JLabel IVANum = new JLabel("10.00");
		IVANum.setHorizontalAlignment(SwingConstants.LEFT);
		panelIzquierdo.add(IVANum);
		
		JLabel facturaTotalLbl = new JLabel("Total factura:");
		facturaTotalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		panelIzquierdo.add(facturaTotalLbl);
		
		JLabel facturaTotalNum = new JLabel("1300.00");
		facturaTotalNum.setHorizontalAlignment(SwingConstants.LEFT);
		panelIzquierdo.add(facturaTotalNum);
		
		calculos.add(panelIzquierdo);
		
		
		//panel derecho
		JPanel panelDerecho = new JPanel();
		panelDerecho.setOpaque(false);
		panelDerecho.setLayout(new GridLayout(1, 2, 30, 0));
		
		JCheckBox valorDescontado = new JCheckBox("Valor descontado:");
		valorDescontado.setOpaque(false);
		panelDerecho.add(valorDescontado);
		
		JLabel valorDescontadoNum = new JLabel("545.00");
		valorDescontadoNum.setHorizontalAlignment(SwingConstants.LEFT);
		panelDerecho.add(valorDescontadoNum);
		
		calculos.add(panelDerecho);
		
		panelGeneral.add(calculos);
		
		
		//pie de página
		JPanel botonesInferiores = new JPanel();
		botonesInferiores.setOpaque(false);
		botonesInferiores.setBorder(BorderFactory.createMatteBorder(0, 700, 20, 0, Color.white));
		
		JButton finalizarFactura = new JButton("Finalizar factura");
		finalizarFactura.setBackground(Color.white);
		botonesInferiores.add(finalizarFactura);
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.setBackground(Color.white);
		botonesInferiores.add(limpiar);
	
		panelFondo.add(botonesInferiores, BorderLayout.SOUTH);
		
		
		return panelFondo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfazExamen2 interfaz = new InterfazExamen2("Examen 2");
	}

}
