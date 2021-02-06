package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.EventoABM;

public class TestEliminarEventoACliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clientes = new ClienteABM();

		long idEvento = 7;
		long idCliente = 5;
		
		try {
			
			clientes.eliminarEventoACliente(idEvento, idCliente);
			
			System.out.println("Evento removido del cliente.");
			
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
