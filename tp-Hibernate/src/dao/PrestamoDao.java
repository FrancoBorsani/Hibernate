package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Prestamo;
public class PrestamoDao {
	private static Session session ;
	private Transaction tx ;
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	private void manejaExcepcion(HibernateException he ) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he );
	}
	public Prestamo traer( long idPrestamo ) throws HibernateException {
		Prestamo obj = null ;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where p.idPrestamo=" + idPrestamo ;
			obj = (Prestamo) session.createQuery( hQL ).uniqueResult();
			Hibernate.initialize(obj.getCuotas());
		} finally {
			session .close();
		}
		return obj ;
	}
	
	public Prestamo traerParaLista( long idPrestamo ) throws HibernateException {
		Prestamo obj = null ;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where p.idPrestamo=" + idPrestamo ;
			obj = (Prestamo) session.createQuery( hQL ).uniqueResult();
		//	Hibernate.initialize(obj); AGREGADO POR TEST
		} finally {
			
		}
		return obj ;
	}
	
	
	
	
	
	
	@SuppressWarnings ( "unchecked" )
	public List<Prestamo> traer(Cliente c ) throws HibernateException {
		List<Prestamo> lista = null ;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where c.idCliente=" + c .getIdCliente();
			lista = session .createQuery( hQL ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
	

	public int agregarPrestamo(Prestamo prestamo){
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer. parseInt ( session .save( prestamo ).toString());
			tx .commit();
		} catch (HibernateException he ) {
			manejaExcepcion( he );
			throw he ;
		} finally {
			session .close();

		
		
	}
	
	return id;

	}
	
	
	public void modificar(Prestamo objeto){
		try {
		//	cerrarSesion();
			iniciaOperacion();
			session .update( objeto );
			tx .commit();
		} catch (HibernateException he ) {
			manejaExcepcion( he );
			throw he ;
		} finally {
			session .close();
		}
	}
	
	public void cerrarSesion(){
		session .close();
		
	}
	
	
	
	
	

	public void eliminar(Prestamo objeto){
		try {
		//	cerrarSesion();
			iniciaOperacion();
			session.delete(objeto);
			tx .commit();
		} catch (HibernateException he ) {
			manejaExcepcion( he );
			throw he ;
		} finally {
			session .close();
		}
	}
	
	
	
	

}
