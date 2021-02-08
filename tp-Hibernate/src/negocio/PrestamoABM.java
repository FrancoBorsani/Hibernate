package negocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.CuotaDao;
import dao.PrestamoDao;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import funciones.Funciones;
public class PrestamoABM {

	private PrestamoDao dao = new PrestamoDao();


	public Prestamo traerPrestamo( long idPrestamo ) throws Exception{
		// Implementar : si no existe el prestamo lanzar la excepción
		Prestamo p = dao .traer( idPrestamo );
		if(p == null){
			throw new Exception ("El prestamo no existe");
		}
		
		return p ;
	}

	
	
	public Prestamo traerPrestamoParaLista( long idPrestamo ) throws Exception{
		// Implementar : si no existe el prestamo lanzar la excepción
		Prestamo p = dao .traerParaLista( idPrestamo );
		if(p == null){
			throw new Exception ("El prestamo no existe");
		}
		
		return p ;
	}
	
	public List<Prestamo> traerPrestamo(Cliente c ) 
	{
		return dao .traer( c );
		
	}
	/* Pendiente implementar
	 * Alta , Modificar
	 */

	public int agregarPrestamo(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente){
		List<Cuota> listaCuotas = new ArrayList<Cuota>();
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		double amortizacion = 0;
		double saldoPendiente = monto;
		double interesCuota = 0;
		double cuota = 0;
		boolean cancelada = false;
		LocalDate fechaDePago = null;
		double punitorios = 0;
		double deuda = 0;
		int nroCuota = 1;
		LocalDate fechaVencimiento = null;
		int fechaValidar = 0;
		for(int i = 0 ; i <p.getCantCuotas(); i++){
		fechaValidar = i;
		fechaValidar ++;
		amortizacion = (saldoPendiente * interes)/ (Math.pow(1+interes   , cantCuotas - (double) i) -1);
		interesCuota = saldoPendiente*interes;
		cuota =  amortizacion + interesCuota;
		deuda = saldoPendiente-amortizacion;	
		saldoPendiente = saldoPendiente - amortizacion;
		
		if(Funciones.esDiaHabil(fecha.plusMonths(fechaValidar)) == true){
			fechaVencimiento = fecha.plusMonths(fechaValidar);
		}
		if(Funciones.esDiaHabil(fecha.plusMonths(fechaValidar)) != true){
			if(fecha.getDayOfWeek().getValue() == 6){
				fechaVencimiento = fecha.plusMonths(fechaValidar).plusDays(2);
			}else if(fecha.getDayOfWeek().getValue() == 7){
				fechaVencimiento = fecha.plusMonths(fechaValidar).plusDays(1);
			}	
	}
		listaCuotas.add(new Cuota(nroCuota, fechaVencimiento, saldoPendiente, amortizacion, interesCuota, cuota, 
				deuda, cancelada, fechaDePago, punitorios, p));
		 p.getCuotas().add(listaCuotas.get(i));
		 nroCuota++;
		}
		
		return dao.agregarPrestamo(p);
		
	}


	public void modificar (Prestamo p){
		
		dao.modificar(p);
	}



	
	
	
	
	public void eliminar(long idPrestamo) throws Exception {
		Prestamo p = dao.traer(idPrestamo);
		
		if(p == null) {
			throw new Exception ("El prestamo que desea eliminar no existe.");
			
		}
		
		CuotaABM cuotas = new CuotaABM();
		
		for (Cuota c: p.getCuotas()) {
			cuotas.eliminar(c);
		}
		
		
		p.getCuotas().clear();

		dao.eliminar(p);
				
	}
	
	
	
}