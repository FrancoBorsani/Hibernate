package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empresa;

public class EmpresaDao {
	private static Session session ;
	private Transaction tx ;
	private static EmpresaDao instancia = null;
	
	
	protected EmpresaDao() {
		
		
	}
	
	public static EmpresaDao getInstancia() {
		if(instancia == null) {
			instancia = new EmpresaDao();
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

	public List<Empresa> traerEmpresa() throws HibernateException{
		List<Empresa> lista = null ;
		try {
			iniciaOperacion();
			String hQL = "from Empresa e";
			lista = session .createQuery( hQL ).list();
		} finally {
			session .close();
		}
		return lista ;
		
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