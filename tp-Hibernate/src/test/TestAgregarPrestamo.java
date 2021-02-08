package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregarPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM prestamo = new PrestamoABM();
		ClienteABM cliente = new ClienteABM();
		LocalDate fecha = LocalDate.now();
		double monto = 15000;
		double interes = 0.15;
		int cantCuotas = 4;
		Cliente cliente1 = null;
		try {
			cliente1 = cliente.traer(42000001);
			prestamo.agregarPrestamo(fecha, monto, interes, cantCuotas, cliente1);
			System.out.println("Prestamo generado con exito.");
		} catch (Exception e) {
			System.out.println("Error al agregar el prestamo: " + e.getMessage());
		}
	}

}
