package application;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Users users = new Users("Usuarios");
		Register register = new Register("Registro");
		Login login = new Login("Acceso");
		Calculator calculator = new Calculator("Calculadora");
		Interes Interes = new Interes("Interés");
	}

}
