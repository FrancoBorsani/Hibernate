package negocio;
import java.util.List;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;
public class ContactoABM {
	ContactoDao dao = new ContactoDao();
	public Contacto traer( long idContacto ) {
		Contacto c = dao .traer( idContacto );
		return c ;
	}
	
	
	//TRAER CONTACTO POR EMAIL
	public Contacto traer(String email){
		Contacto c = dao.traer(email);
		return c;
	}
	
	
	
	
	public int agregar(String email , String movil, String fijo, Cliente cliente) throws Exception {
		// consultar si existe un contacto con el mismo email , si existe arrojar la
		// Excepcion
		if(traer(email) != null){
			throw new Exception("Ya existe un contacto con ese mail.");
		}
		
		
		Contacto c = new Contacto( email , movil , fijo , cliente );
		return dao .agregar( c );
	}
	
	public void modificar(Contacto c ) throws Exception {
		// implementar antes de actualizar que no exista un contacto con el mismo
		// email a modificar, lanzar la Exception
		if(traer(c.getEmail()) != null) {
			throw new Exception ("Ya hay otro contacto con ese email.");
		}
		
		
		dao .actualizar( c );
	}
	
	public void eliminar( long idContacto ) throws Exception {
		//en este caso es física en gral . no se se aplicaría este caso de uso , si
		// se hiciera habría que validar que el cliente no tenga dependencias
		Contacto c = dao .traer( idContacto );
		// Implementar que si es null que arroje la excepción la Excepción	
		if(traer(idContacto) == null) {
			throw new Exception ("No existe ningun contacto con ese ID");
		}
		
		dao .eliminar( c );
	}

	
	public List<Contacto> traerContactos(){
		return dao.traerContactos();
	}
	
	
	
	
}