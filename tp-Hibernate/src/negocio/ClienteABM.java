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
public Cliente traer( int dni ) throws Exception{
	Cliente c = null;
	int i = 0;
	
	while(i<traer().size() && c == null){
	if(traer().get(i).getDni() == dni){
		c = traer().get(i);
	}
	i++;	
	}
	if(c == null){
		throw new Exception("No existe un cliente con ese DNI.");
	}
	
	 c = dao .traer( dni );
return c ;
}
public int agregar(String apellido , String nombre , int dni , LocalDate
fechaDeNacimiento ) {
Cliente c = new Cliente( apellido , nombre , dni , fechaDeNacimiento );
return dao .agregar( c );
}



public void modificar(Cliente c ) throws Exception {
	// implementar antes de actualizar que no exista un cliente con el mismo
	// documento a modificar y con el mismo id, lanzar la Exception
	int i = 0;
	while(i<traer().size()){
		if(traer().get(i).getDni() == c.getDni()){
			throw new Exception("Ya existe un cliente con el mismo DNI.");
		}
		
		i++;
	}		
	dao .actualizar( c );
}




public void eliminar( long idCliente ){
Cliente c = dao .traer( idCliente );
dao .eliminar( c );
}
public List<Cliente> traer() {
return dao .traer();
}
public Cliente traerClienteYPrestamos( long idCliente ) {
return dao .traerClienteYPrestamos( idCliente );
}
}