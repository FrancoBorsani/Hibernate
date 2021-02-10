package negocio;

import java.util.List;

import dao.AbonadoDao;
import datos.Abonado;

public class AbonadoABM {
	private static AbonadoABM instancia = null;
	
	protected AbonadoABM() {
		
	}
	
	
	public static AbonadoABM getInstancia() {
		if(instancia == null) {
			instancia = new AbonadoABM();
		}
		
		return instancia;
		
	}
	
	
	public List<Abonado> traerAbonado(){
		return AbonadoDao.getInstancia().traerAbonado();
		
	}
	
	public List<Abonado> traerAbonado(String apellido){
		
		return AbonadoDao.getInstancia().traerAbonado(apellido);
	}
	
	
	
	public Abonado traerAbonado ( long dni) {
		
		return AbonadoDao.getInstancia().traerAbonado(dni);
		
	}
	
	
	
	
	
	
	
	
	
}
