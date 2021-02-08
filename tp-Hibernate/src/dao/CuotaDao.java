package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
public class CuotaDao {
	private static Session session ;
	private Transaction tx ;
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session .beginTransaction();
	}
	private void manejaExcepcion(HibernateException he ) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he );
	}
		public int agregar(Cuota objeto ) {
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
	
	
	public void actualizar(Cuota objeto ) throws HibernateException {
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
	}
	
	
	
	public void eliminar(Cuota objeto ) throws HibernateException {
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
	}
	
	public Cuota traer(int nroCuota) throws HibernateException {
		Cuota objeto = null ;
		try {
			iniciaOperacion();
			String hQL = "from Cuota c inner join fetch c.prestamo p where c.nroCuota=" + nroCuota;
			objeto = (Cuota) session.createQuery( hQL ).uniqueResult();
		//	Hibernate.initialize(objeto); AGREGADO POR TESTEO
		} finally {
			session .close();
		}
		return objeto ;
	}
	
	


	
	public Prestamo traerCuotas(Prestamo prestamo) {
		Prestamo objeto = null ;
		try {
			iniciaOperacion();
		//	lista = session .createQuery( "from Prestamo p inner join fetch p.cuotas c where p.idPrestamo=" + prestamo.getIdPrestamo() ).list();
		//	Hibernate.initialize(lista);
			String hql = "from Prestamo p where p.idCliente =" + prestamo.getIdPrestamo() ;
			objeto =(Prestamo) session .createQuery( hql ).uniqueResult();
		    Hibernate. initialize ( objeto.getCuotas());
		} finally {
			session .close();
		}
		return objeto ;
		
		
	}
	
	

}
