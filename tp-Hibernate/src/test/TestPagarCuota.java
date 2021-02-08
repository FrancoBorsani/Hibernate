package test;

import java.time.LocalDate;

import datos.Cuota;
import datos.Prestamo;
import negocio.CuotaABM;
import negocio.PrestamoABM;

public class TestPagarCuota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * En el caso de que un cliente venga a pagar una cuota se invocará al método traerCuota de
CuotaABM se “setearán” los atributos: cancelada, fechaDePago, punitorios y por último modificarCuota
de CuotaABM.
		 * 
		 * 
		 * 
		 */
		
		PrestamoABM prestamos = new PrestamoABM();
		CuotaABM cuota = new CuotaABM();
	
		int nroCuota = 1;		
	
		Cuota cuotaV = cuota.traer(nroCuota);
				cuotaV.setCancelada(true);
		cuotaV.setFechaDePago(LocalDate.of(2020, 8, 1));
		cuotaV.setPunitorios(cuota.calcularPunitorios(cuotaV, 0.02));
		

		
		try{
			cuota.modificar(cuotaV);			
			System.out.println("\nCuota pagada: " + cuotaV);
			
			
		}catch(Exception e){
			
			System.out.println("Error al actualizar la cuota: " + e.getMessage());
		}
		
		
		try {
		
		//	Prestamo p = prestamos.traerPrestamoParaLista(cuotaV.getPrestamo().getIdPrestamo());
			Prestamo p = prestamos.traerPrestamo(cuotaV.getPrestamo().getIdPrestamo());		
		//	System.out.println("Prestamo: " + p);
			int cantPagadas = 0;
			
			for (Cuota c : p.getCuotas()){
				if(c.isCancelada())
				{
					cantPagadas++;
				}
				
				
			}
			
			
			if(cantPagadas == p.getCantCuotas()){
			p.setCancelado(true);
			prestamos.modificar(p);
			}
			
			
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

	


