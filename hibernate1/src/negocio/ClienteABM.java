package negocio;
import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;
public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	public Cliente traer( long idCliente ) {
		Cliente c = dao .traer( idCliente );
		return c ;
	}
	public Cliente traer( int dni ) {
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
	public void eliminar( long idCliente ) throws Exception {
		//en este caso es f�sica en gral . no se se aplicar�a este caso de uso , si
		// se hiciera habr�a que validar que el cliente no tenga dependencias
		Cliente c = dao .traer( idCliente );
		// Implementar que si es null que arroje la excepci�n la Excepci�n
		if(c == null) {
			throw new Exception("El cliente con ese ID no existe");
		}
		
		
		
		dao .eliminar( c );
	}
	public List<Cliente> traer() {
		return dao .traer();
	}
}