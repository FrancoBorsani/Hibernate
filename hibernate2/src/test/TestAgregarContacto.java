package test;
import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;
public class TestAgregarContacto {
	public static void main(String[] args ) {
		ClienteABM abmCliente = new ClienteABM();
		long idCliente =4;
		Cliente cliente = abmCliente .traer( idCliente );
		System. out .println( cliente );
		ContactoABM abmContacto = new ContactoABM();
		try {
		
		abmContacto .agregar( "ajaramillo2@unla.edu.ar" , "11-1111-1111" , "011-1111-1111" , cliente );
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
}