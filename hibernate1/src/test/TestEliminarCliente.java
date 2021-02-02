package test;

import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM cEliminar = new ClienteABM();
		long id = 4;
		try {
		cEliminar.eliminar(id);}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		
		
		
	}

}
