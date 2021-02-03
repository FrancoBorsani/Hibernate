package datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Funciones {
	
	
	public static String traerFechaCorta(LocalDate fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY"); 
	    return formatter.format(fecha);
	}
	
	
	
	
}
