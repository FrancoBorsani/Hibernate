package negocio;
import java.time.LocalDate;
import java.util.List;

import dao.PrestamoDao;
import datos.Cliente;
import datos.Prestamo;
public class PrestamoABM {
	PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo( long idPrestamo )throws Exception {
		Prestamo p = dao.traer(idPrestamo);
		if(p == null) {
			throw new Exception ("No existe un prestamo con ese ID");
		}
		return p;
	}
	
	
	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas,
			Cliente cliente) throws Exception {
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		return dao .agregar( p );
	}
	
	
	public void modificar(Prestamo p ) throws Exception {
		// implementar antes de actualizar que no exista un cliente con el mismo
		// documento a modificar y con el mismo id, lanzar la Exception	
		
		dao .actualizar( p );
	}
	/*
	public void eliminar( long idCliente ) throws Exception {
		//en este caso es física en gral . no se se aplicaría este caso de uso , si
		// se hiciera habría que validar que el cliente no tenga dependencias
		Cliente c = dao .traer( idCliente );
		// Implementar que si es null que arroje la excepción la Excepción
		if(c == null) {
			throw new Exception("El cliente con ese ID no existe");
		}
		
		
		
		dao .eliminar( c );
	}*/


	
	public List<Prestamo> traerClienteYPrestamos(Cliente cliente) throws Exception {
		return dao.traer(cliente);
	}
	
	
	
	
}