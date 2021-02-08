package negocio;

import java.util.List;

import dao.CuotaDao;
import datos.Cuota;
import datos.Prestamo;

public class CuotaABM {
CuotaDao dao = new CuotaDao();

public Cuota traer(int nroCuota) {
Cuota c = dao .traer( nroCuota );

return c ;
}


public void modificar(Cuota cuota) {
	dao .actualizar( cuota );

}


public double calcularPunitorios(Cuota cuotaV, double interesMora){

	if(cuotaV.getFechaDePago().isAfter(cuotaV.getFechaVencimiento())){
		
		cuotaV.setPunitorios(cuotaV.getCuota()*interesMora);
	}
	
	return cuotaV.getPunitorios();
	
}



public Prestamo traerCuotas(Prestamo prestamo) {

return dao.traerCuotas(prestamo) ;
}



public void eliminar(Cuota cuota) {
	dao.eliminar(cuota);
	
}




}
