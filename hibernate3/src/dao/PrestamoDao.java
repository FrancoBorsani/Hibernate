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
	public int agregar(Prestamo objeto ) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer. parseInt ( session .save( objeto ).toString());
			tx .commit();
		} catch (HibernateException he ) {
			manejaExcepcion( he );
			throw he ;
		} finally {
			session .close();
		}
		return id ;
	}
	public void actualizar(Prestamo objeto ) throws HibernateException {
		try {
			iniciaOperacion();
			session .update( objeto );
			tx .commit();
		} catch (HibernateException he ) {
			manejaExcepcion( he );
			throw he ;
		} finally {
			session .close();
		}
	}/*
	public void eliminar(Cliente objeto ) throws HibernateException {
		try {
			iniciaOperacion();
			session .delete( objeto );
			tx .commit();
		} catch (HibernateException he ) {
			manejaExcepcion( he );
			throw he ;
		} finally {
			session .close();
		}
	}*/

	
	public Prestamo traer( long idPrestamo ) throws HibernateException {

		Prestamo objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Prestamo) session .createQuery( "from Prestamo p inner join fetch p.cliente where p.idPrestamo="+idPrestamo).uniqueResult();
		} finally {
			session .close();
		}
		return objeto ;
	}
	
	
	
	
	public List<Prestamo> traer( Cliente cliente ) throws HibernateException {

		List<Prestamo> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from Prestamo p inner join fetch p.cliente c where c.idCliente="+cliente.getIdCliente() ).list();
		} finally {
			session .close();
		}
		return lista ;
	}/*
	@SuppressWarnings ( "unchecked" )
	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from Cliente c order by c.apellido asc,	c.nombre asc" ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
	
	
	public Cliente traerClienteYContacto( long idCliente ) throws HibernateException {
		Cliente objeto = null ;
		try {
		iniciaOperacion();
		String hql = "from Cliente c inner join fetch c.contacto where c.idCliente =" + idCliente ;
		objeto = (Cliente) session .createQuery( hql ).uniqueResult();
		} finally {
		session .close();
		}
		return objeto ;
		}
	*/
	

	
	
	
	
	
	
	
	
}