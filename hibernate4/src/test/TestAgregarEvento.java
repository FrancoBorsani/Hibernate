package test;

import java.time.LocalDate;
import java.time.LocalTime;

import negocio.EventoABM;

public class TestAgregarEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventoABM eventos = new EventoABM();
		String nombreEvento = "Club Media Fest";
		LocalDate fecha = LocalDate.of(2021, 8, 1);
		LocalTime hora = LocalTime.of(17, 0);
		
		
		try {
			eventos.agregar(nombreEvento, fecha, hora);
			System.out.println("Evento agregado exitosamente.");
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		
		
		
	}

}
