package dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Contacto;
public class ContactoDao {
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
	public int agregar(Contacto objeto ) {
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
	public void actualizar(Contacto objeto ) throws HibernateException {
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
	public void eliminar(Contacto objeto ) throws HibernateException {
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
	public Contacto traer( long idContacto ) throws HibernateException {
		Contacto objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Contacto) session .get(Contacto. class , idContacto );
		} finally {
			session .close();
		}
		return objeto ;
	}

	
	//SE REALIZA CON UNA HIBERNATE NATIVE QUERY PARA EVITAR CONFLICTOS CON CARACTERES ESPECIALES
	public Contacto traer( String email ) throws HibernateException {
		Contacto objeto = null ;
		try {
		iniciaOperacion();
		String sql = "SELECT * FROM CONTACTO WHERE email = :email";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Contacto.class);
		query.setParameter("email", email);
		objeto = (Contacto)query.uniqueResult();
		} finally {
		session .close();
		}
		return objeto ;
		}
	
	
	@SuppressWarnings ( "unchecked" )
	public List<Contacto> traerContactos() throws HibernateException {
		List<Contacto> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from Contacto" ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
	
	
	
	
	

}