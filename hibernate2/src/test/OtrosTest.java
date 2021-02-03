package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class OtrosTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM c = new ClienteABM();
		Cliente cliente = c.traer(14000000);
		
		
		
		
		System.out.println(cliente);
		
		
		System.out.println("Contacto desde Cliente: " + cliente.getContacto());
		
		
		
		System.out.println("CLIENTE + CONTACTO: " + c.traerClienteYContacto(1).getContacto());
		
		
		
		
		ContactoABM contactoABM = new ContactoABM();
		//Contacto contacto = c.traer(ajaramillo@unla.edu.ar);
		
		
		
	}

}
