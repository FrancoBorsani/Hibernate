package test;
import java.util.List;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;
public class TestTraerPrestamo {
	public static void main(String[] args ) {
		PrestamoABM prestamoABM = new PrestamoABM();
		long idPrestamo =1;
		System. out .println( "\n---> TraerPrestamo idPrestamo=" + idPrestamo +
				"\n\n" );
			try {
			Prestamo p = prestamoABM .traerPrestamo( idPrestamo );
			if(p != null) {
			System. out .println( p + "\nPertenece a " + p .getCliente());
				}
			else System.out.println("El cliente no tiene prestamos otorgados");
			// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
			
			
			ClienteABM clienteABM = new ClienteABM();
			int dni =14000000;
			Cliente c = clienteABM .traer( dni );
			System. out .println( "\n---> TraerPrestamos del Cliente=" + c + "\n\n" );
			List<Prestamo> prestamos = prestamoABM .traerClienteYPrestamos( c );
			// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		    if(prestamos.size() != 0) {
			for (Prestamo o : prestamos ) System. out .println( o + "\nPertenece a: " + o .getCliente());
			}
		else System.out.println("El cliente no tiene prestamos otorgados.");
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}




}