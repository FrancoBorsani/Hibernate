package test;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class TestAgregarEventoACliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		EventoABM eventoABM = new EventoABM();
		
		Cliente cliente = null;
		Evento evento = null;
		
		try {
			evento = eventoABM.traer("Club Media Fest");
		
			cliente = clienteABM.traer(43000000);
			
			clienteABM.agregarEventoACliente(evento, cliente);
		
			System.out.println("Evento agregado al cliente");
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
	}

}
