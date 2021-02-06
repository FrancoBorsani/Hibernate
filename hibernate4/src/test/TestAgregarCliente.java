package test;
import java.time.LocalDate;

import negocio.ClienteABM;
public class TestAgregarCliente {
	public static void main(String[] args ) {
		String apellido = "Max" ;
		String nombre = "Maximiliano" ;
		int documento = 43000000;
		// tu fecha de nacimiento
		LocalDate fechaDeNacimiento = LocalDate.of(1999, 1, 20);
		ClienteABM abm = new ClienteABM();

		try {
			long ultimoIdCliente = abm .agregar( apellido , nombre , documento ,
					fechaDeNacimiento );}
		catch(Exception e) {
			System.out.println(""+ e.getMessage());

		}



	}
}