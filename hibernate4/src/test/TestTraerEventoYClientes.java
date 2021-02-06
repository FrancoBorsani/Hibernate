package test;

import datos.Cliente;
import datos.Evento;
import negocio.EventoABM;

public class TestTraerEventoYClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventoABM eventos = new EventoABM();
		Evento evento = null;
		
		int idEvento = 7;
		
		try {
			evento = eventos.traer(idEvento);
			
			System.out.println(evento);
			
			for(Cliente c : eventos.traer(idEvento).getClientes()) {
				System.out.println("\n--->" + c);
				
				
			}
			
			
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
