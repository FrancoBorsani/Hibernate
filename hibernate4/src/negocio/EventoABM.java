package negocio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import dao.EventoDao;
import datos.Cliente;
import datos.Evento;
public class EventoABM {
	EventoDao dao = new EventoDao();
	
	
	public Evento traer( long idEvento ) throws Exception {
		Evento c = dao .traer( idEvento );
		return c ;
	}
	
	
	public Evento traer( String evento ) throws Exception {
		Evento c = dao .traer( evento );
		return c ;
	}
	
	

	public int agregar(String evento, LocalDate fecha, LocalTime hora) throws Exception {
		if(traer(evento) != null) {
			throw new Exception("Ya existe un evento con el mismo nombre");
		}
		Evento c = new Evento(evento, fecha, hora);
		return dao.agregar(c);
	}
	
	public void modificar(Evento c ) throws Exception {
		if(traer(c.getEvento()) != null) {
			throw new Exception ("Ya existe un evento con ese mismo nombre");
			
		}
		
		
		
		dao .actualizar( c );
	}
	public void eliminar( long idEvento ) throws Exception {
		Evento c = dao .traer( idEvento );
		// Implementar que si es null que arroje la excepción la Excepción
		if(c == null) {
			throw new Exception("El evento con ese ID no existe");
		}
		
		dao .eliminar( c );
	}
	
	public List<Evento> traer() {
		return dao .traer();
	}
	
	
	public void eliminar(long idEvento, Cliente cliente) throws Exception{
		Evento e =	dao.traerEventoYClientes(idEvento);
		if(e == null) {
			throw new Exception ("El evento no existe.");
		}
		
		for(Cliente c: e.getClientes()) {
			if(c.getIdCliente() == cliente.getIdCliente()) {
				e.eliminar(c);
				dao.actualizar(e);
			}
		}
	}
	

	
	public void agregarClienteAEvento(Evento e, Cliente c) throws Exception{
		
		if(c==null) {
			throw new Exception("El cliente que quiere agregar al evento no existe");
		}
		
		if(e == null) {
			throw new Exception("El cliente que quiere agregar al evento no existe");
		}

		e.agregar(c);
		
		dao.actualizar(e);
	}
	

	
	

		
	}
