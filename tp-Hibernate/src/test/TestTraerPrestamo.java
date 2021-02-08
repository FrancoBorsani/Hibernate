package test;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;
public class TestTraerPrestamo {
	public static void main(String[] args ) {
		PrestamoABM prestamoABM = new PrestamoABM();
		long idPrestamo =3;
		Prestamo p = null;
		//implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		try{
			System. out .println( "\n---> TraerPrestamo idPrestamo=" + idPrestamo +
					"\n\n" );
			p = prestamoABM .traerPrestamo( idPrestamo );
			System. out .println( p + "\nPertenece a " + p .getCliente());}
		catch(Exception e){
			System.out.println("Error al traer el prestamo: " + e.getMessage());
		}
		
		ClienteABM clienteABM = new ClienteABM();
		int dni =42043432;
	
		Cliente c = clienteABM .traer(p.getCliente().getIdCliente() );
		System. out .println( "\n---> TraerPrestamos del Cliente=" + c + "\n\n" );
		//implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		List<Prestamo> prestamos = null;
		try{
			prestamos = prestamoABM .traerPrestamo( c );
			for (Prestamo o : prestamos ) System. out .println( o + "\nPertenece a" + o .getCliente());}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
		finally{
			if(prestamos == null){
				System.out.println("El cliente no tiene prestamos.");
			}

		}



	}
}