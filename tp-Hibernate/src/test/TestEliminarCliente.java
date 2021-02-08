package test;

import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idEliminar = 2;
		ClienteABM cliente = new ClienteABM();
		try{
		cliente.eliminar(idEliminar);
		System.out.println("Cliente eliminado con éxito");}
		catch(Exception e){
			System.out.println("Error al querer eliminar un cliente: " + e.getMessage());
		}
		
		/*
		int idelim = 1;
		ContactoABM contacto = new ContactoABM();
		try{
			
			contacto.eliminar(idelim);
			
		}catch(Exception e){
			System.out.println("Error al querer eliminar un cliente: " + e.getMessage());
		}*/
		
		
		
		
	}

}
