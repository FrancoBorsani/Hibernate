package negocio;
import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Evento;
public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	public Cliente traer( long idCliente ) {
		Cliente c = dao .traer( idCliente );
		return c ;
	}
	public Cliente traer( int dni ) throws Exception {
		Cliente c = dao .traer( dni );
		return c ;
	}
	public int agregar(String apellido , String nombre , int dni , LocalDate
			fechaDeNacimiento ) throws Exception {
		// consultar si existe un cliente con el mismo dni , si existe arrojar la
		// Excepcion
		if(traer(dni) != null) {
			throw new Exception("Ya existe un cliente con el mismo DNI");
		}
		Cliente c = new Cliente( apellido , nombre , dni , fechaDeNacimiento );
		return dao .agregar( c );
	}
	public void modificar(Cliente c ) throws Exception {
		// implementar antes de actualizar que no exista un cliente con el mismo
		// documento a modificar y con el mismo id, lanzar la Exception
		
		if(traer(c.getDni()) != null) {
			throw new Exception ("Ya existe un cliente con ese mismo DNI");
			
		}
		
		
		
		dao .actualizar( c );
	}
	
	public void eliminarEventoDeCliente(Cliente c ) throws Exception {
		dao .actualizar( c );
	}
	
	
	
	
	
	public void eliminar( long idCliente ) throws Exception {
		//en este caso es física en gral . no se se aplicaría este caso de uso , si
		// se hiciera habría que validar que el cliente no tenga dependencias
		Cliente c = dao .traer( idCliente );
		// Implementar que si es null que arroje la excepción la Excepción
		if(c == null) {
			throw new Exception("El cliente con ese ID no existe");
		}
		
		
		
		dao .eliminar( c );
	}
	public List<Cliente> traer() {
		return dao .traer();
	}
	
	
	public void eliminar(Cliente cliente) throws Exception{
		dao.eliminar(cliente);
	}
	
	
	
	
	
	public Cliente traerClienteYEventos(long idCliente) throws Exception{
			return	dao.traerClienteYEventos(idCliente);
		
	}
	
	
	public void agregarEventoACliente (Evento evento, Cliente cliente) throws Exception{
		if(evento == null) {
			throw new Exception ("El evento no existe.");
		}
		if(cliente == null) {
			throw new Exception ("El cliente no existe.");
		}
		
		cliente.agregar(evento);
		
		dao.actualizar(cliente);
		
		
	}
	
	
	public void eliminarEventoACliente (long idEvento, long idCliente) {
		Cliente c = dao.traerClienteYEventos(idCliente);
		
		
		for(Evento e : c.getEventos()) {
			if(e.getIdEvento() == idEvento) {
				c.eliminar(e);
				dao.actualizar(c);
			}
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}