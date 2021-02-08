package test;

import negocio.PrestamoABM;

public class TestEliminarPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM prestamos = new PrestamoABM();
		
		long idPrestamo = 4;
		
		try {
			prestamos.eliminar(idPrestamo);
			System.out.println("Prestamo eliminado correctamente.");
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		
		
	}

}
