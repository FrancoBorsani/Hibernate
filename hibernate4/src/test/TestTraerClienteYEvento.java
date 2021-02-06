package test;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;

public class TestTraerClienteYEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ClienteABM clientes = new ClienteABM();
				Cliente cliente = null;
				
				int dni = 42043432;
				
				try {
					cliente = clientes.traer(dni);
							
					System.out.println(cliente);
					
					for(Evento e : clientes.traer(dni).getEventos()) {
						System.out.println("\n--->" + e);
					}
					
					
					
				}catch(Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
	}

}
