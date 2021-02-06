package test;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class TestEliminarClienteAEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clientes = new ClienteABM();
		
		EventoABM eventos = new EventoABM();
		
		Cliente cliente = null;

		long idEvento = 7;
		
		
		try {
			cliente = clientes.traer(42000000);			
			
			eventos.eliminar(idEvento, cliente);
			
			System.out.println("Cliente removido del evento.");
			
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		
	}

}
