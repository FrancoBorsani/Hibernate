package dao;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;
import datos.Rodado;
import datos.Telepeaje;

public class TelepeajeDao {
	private static Session session ;
	private Transaction tx ;
	private static TelepeajeDao instancia = null;
	
	
	protected TelepeajeDao() {
		
		
	}
	
	public static TelepeajeDao getInstancia() {
		if(instancia == null) {
			instancia = new TelepeajeDao();
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
	
	
	
	public List<Telepeaje> traerTelepeaje(Rodado rodado){
		List<Telepeaje> lista = null;

		try {
			iniciaOperacion();
			Query query = session.createQuery("from Telepeaje t where t.rodado.id= :rodado");
			query.setParameter("rodado", rodado.getId());
			lista = query.list();
		} finally {
			session.close();
		}

		return lista;
		
		
	}
	
	
	

	public List<Telepeaje> traerTelepeaje(LocalDate fecha) {
		List<Telepeaje> lista = null;

		try {
			iniciaOperacion();
			Query query = session.createQuery("from Telepeaje t where t.fecha= :fecha");
			query.setParameter("fecha", fecha);
			lista = query.list();
		} finally {
			session.close();
		}

		return lista;
	}
	
	

	public List<Telepeaje> traerTelepeaje(String dominio) {
		List<Telepeaje> lista = null;
		try {
			iniciaOperacion();
			Query query = session.createQuery("from Telepeaje t inner join fetch t.rodado r where r.dominio= :dominio");
			query.setParameter("dominio", dominio);
			lista = query.list();
		} finally {
			session.close();
		}

		return lista;
	}
	
	
	}