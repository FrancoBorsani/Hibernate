package negocio;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
public class ClienteABM {
	private static ClienteABM instancia = null;
	
	
	protected ClienteABM() {}
	
	public static ClienteABM getInstance() {
		if(instancia == null) instancia = new ClienteABM();
		return instancia;
		
	}

	
	public Cliente traer( int idCliente ) throws Exception {
		return ClienteDao.getInstance().traer(idCliente);
	}
	
	
	public List<Cliente> traer() {
		return ClienteDao.getInstance().traer();
	}
	
		
		
	
	
}