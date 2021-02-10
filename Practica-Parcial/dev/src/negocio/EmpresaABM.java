package negocio;

import java.util.List;

import dao.EmpresaDao;
import datos.Empresa;

public class EmpresaABM {
	private static EmpresaABM instancia = null;
	
	protected EmpresaABM() {
		
	}
	
	public static EmpresaABM getInstancia() {
		if(instancia == null) {
			instancia = new EmpresaABM();
		}
		return instancia;
		
		
	}
	
	
	public List<Empresa> traerEmpresa(){
		
		return EmpresaDao.getInstancia().traerEmpresa();
		}
	
	
	
	
	
}
