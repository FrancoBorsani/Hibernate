package negocio;

import dao.RodadoDao;
import datos.Rodado;

public class RodadoABM {
	private static RodadoABM instancia = null;


	protected RodadoABM() {

	}

	public static RodadoABM getInstancia() {
		if(instancia == null) {	
			instancia = new RodadoABM();
		}

		return instancia;


	}


	
	
	public Rodado traerRodado(String dominio) {
		
		return RodadoDao.getInstancia().traerRodado(dominio);
		
		
	}
	
	
	
	
	
}
