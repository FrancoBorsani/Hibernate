package test;
import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	public static void main(String[] args ) {
		ClienteABM abm = new ClienteABM();
		long id = 1;
		// traer el obj a modificar
		Cliente c = abm .traer( id );
		System. out .println( "Cliente a Modificar -->" + c );
		// modificar por set los atributos
		
			
		int dni = 42043432;
		try {
			if(abm.traer(dni) != null){
				System.out.println("Un cliente con el mismo DNI ya existe.");
			}else{
			c .setDni(dni);
			abm.modificar(c);
			
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System. out .println( "Cliente Modificado -->" + c );
		
}
}