package test;

import negocio.ContactoABM;

public class TestEliminarContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactoABM cEliminar = new ContactoABM();
		long id = 1;
		try {
		cEliminar.eliminar(id);}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		
		
		
	}

}
