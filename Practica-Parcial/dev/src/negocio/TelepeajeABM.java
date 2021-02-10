package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.TelepeajeDao;
import datos.Rodado;
import datos.Telepeaje;

public class TelepeajeABM {
	private static TelepeajeABM instancia = null;
	
	
	protected TelepeajeABM() {
		
		
	}
	
	public static TelepeajeABM getInstancia() {
		if(instancia == null) {
			instancia = new TelepeajeABM();
		}
		
		return instancia;
		
	}
	
	
	
	
	// Calcula el total de lo recaudado en telepeajes
	
	public double cerrarCaja(LocalDate fecha) {
		List<Telepeaje> lista = TelepeajeDao.getInstancia().traerTelepeaje(fecha);
		double total = 0;
		for(Telepeaje t : lista) {
			total = total + t.getPrecio();
			
		}
		
		return total;
		
	}
	
	
	
	
	public List<Telepeaje> traerTelepeaje (Rodado rodado){
		return TelepeajeDao.getInstancia().traerTelepeaje(rodado);
		
	}
	
	
	
	public List<Telepeaje> traerTelepeaje(String dominio){
		
		return TelepeajeDao.getInstancia().traerTelepeaje(dominio);
		
	}
	
	
	
}
