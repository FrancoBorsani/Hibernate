package test;
import datos.Cliente;
import negocio.ClienteABM;
public class TestCliente {
	public static void main(String[] args ) {
		int idCliente =1;
		try {
		System. out .println( "+ traer(" + idCliente + ")" );
		System. out .println(ClienteABM. getInstance ().traer( idCliente ));
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		idCliente =2;
		try {
		System. out .println( "\n+ traer(" + idCliente + ")" );
		System. out .println(ClienteABM. getInstance ().traer( idCliente ));
		System. out .println( "\n+ traer()" );
		for (Cliente c : ClienteABM. getInstance ().traer()) {
			System. out .println( c );
		}
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
	}
}