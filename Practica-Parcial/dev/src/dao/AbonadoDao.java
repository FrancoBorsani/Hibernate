package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;

public class AbonadoDao {
	private static Session session ;
	private Transaction tx ;
	private static AbonadoDao instancia = null;
	
	
	protected AbonadoDao() {
		
		
	}
	
	public static AbonadoDao getInstancia() {
		if(instancia == null) {
			instancia = new AbonadoDao();
		}
		return instancia;
		
	}
	
	
	
	
	
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	private void manejaExcepcion(HibernateException he ) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he );
	}

	public List<Abonado> traerAbonado() throws HibernateException{
		List<Abonado> lista = null ;
		try {
			iniciaOperacion();
			String hQL = "from Abonado a";
			lista = session .createQuery( hQL ).list();
		} finally {
			session .close();
		}
		return lista ;
		
	}
	
	

	public List<Abonado> traerAbonado(String apellido) {
		List<Abonado> manuales = null;

		try {
			iniciaOperacion();
			Query query = session.createQuery("from Abonado a where a.apellido= :apellido");
			query.setParameter("apellido", apellido);
			manuales = query.list();
		} finally {
			session.close();
		}

		return manuales;
	}
	
	

	public Abonado traerAbonado( long dni ) throws HibernateException {
		Abonado objeto = null ;
		try {
		iniciaOperacion();
		objeto = (Abonado) session .createQuery( "from Abonado a where a.dni="
		+ dni ).uniqueResult();
		} finally {
		session .close();
		}
		return objeto ;
		}

	
	/*
	
	public Prestamo traer( long idPrestamo ) throws HibernateException {
		Prestamo obj = null ;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where
					p.idPrestamo=" + idPrestamo ;
					obj = (Prestamo) session .createQuery( hQL ).uniqueResult();
		} finally {
			session .close();
		}
		return obj ;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Prestamo> traer(Cliente c ) throws HibernateException {
		List<Prestamo> lista = null ;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where
					c.idCliente=" + c .getIdCliente();
					lista = session .createQuery( hQL ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
	*/
	
	
	}