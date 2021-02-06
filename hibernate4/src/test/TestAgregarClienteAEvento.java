package test;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class TestAgregarClienteAEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		EventoABM eventoABM = new EventoABM();
		
		Cliente cliente = null;
		Evento evento = null;
		
		try {
			cliente = clienteABM.traer(42043432);
			evento = eventoABM.traer("Club Media Fest");
			eventoABM.agregarClienteAEvento(evento, cliente);
			System.out.println("Cliente agregado al evento");
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		
	}

}
