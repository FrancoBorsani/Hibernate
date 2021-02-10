package test;

import java.time.LocalDate;
import java.util.List;

import datos.Telepeaje;
import negocio.AbonadoABM;
import negocio.EmpresaABM;
import negocio.RodadoABM;
import negocio.TelepeajeABM;

public class TestOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// PUNTO 1
		
			System.out.println(EmpresaABM.getInstancia().traerEmpresa());
			
			
		// PUNTO 2
			
			System.out.println(AbonadoABM.getInstancia().traerAbonado());
			
			
		// PUNTO 3
			
			System.out.println(AbonadoABM.getInstancia().traerAbonado("Gonzalez"));
			
			
			
		// PUNTO 4
			
			System.out.println(TelepeajeABM.getInstancia().cerrarCaja(LocalDate.of(2020, 11, 1)));
			
			
		// PUNTO 5
			
			System.out.println(RodadoABM.getInstancia().traerRodado("BBB222"));
			
			
		// PUNTO 6
			System.out.println(TelepeajeABM.getInstancia().traerTelepeaje(RodadoABM.getInstancia().traerRodado("BBB222")));
			System.out.println("///////////////////////////////////////////////");
			List<Telepeaje> telepeajesXRodado = TelepeajeABM.getInstancia().traerTelepeaje(RodadoABM.getInstancia().traerRodado("BBB222"));
			double recargo = 0;
			for(Telepeaje t : telepeajesXRodado) {
				
				recargo = t.calcularRecargo(10);
				t.setPrecio(t.getPrecio() + recargo);
				recargo = 0;
				
			}
			
			System.out.println(telepeajesXRodado);
			
			
			
		// PUNTO 7
			
			
			System.out.println(AbonadoABM.getInstancia().traerAbonado(55555555));
			
			
			
		// PUNTO 8
			
			System.out.println(TelepeajeABM.getInstancia().traerTelepeaje("CCC333"));
			
			
			
			
			
			
			
	}

}
