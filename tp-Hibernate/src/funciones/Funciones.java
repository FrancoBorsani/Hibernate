package funciones;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;


public class Funciones {

	//+ esBisiesto (int anio) : boolean
	//Serán bisiestos los años divisibles por 4, exceptuando los que son divisibles por 100 y no
	//divisibles por 400. Ejemplos: son bisiestos 1996, 2004, 2000, 1600; No son bisiestos 1700,
	//1800, 1900, 2100

	public static boolean esBisiesto(int anio){
		boolean resultado = false;
		if(anio % 4 == 0){
			if(anio % 100 ==0 && anio % 400 != 0){
				resultado = false;
			}resultado = true;


		} return resultado;

	}


	//+ esFechaValida (LocalDate fecha) : boolean
	//En el caso de ser bisiesto es válido el día 29/02

	/* 
	Meses con 30 días: Abril, Junio, Septiembre y Noviembre.
	Meses con 31 días: Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre.
	Meses con 28 días: Febrero (Menos cuando es bisiesto que tiene 29 días).
	 */

	public static boolean esFechaValida(LocalDate fecha){
		boolean resultado = false;		
		if(fecha.getYear() >= 0){
			if(fecha.getMonth().getValue() > 0 && fecha.getMonth().getValue() <= 12){

				if(fecha.getMonthValue() == 4 || fecha.getMonthValue() ==  6|| fecha.getMonthValue() == 9
						|| fecha.getMonthValue() == 11){
					if(fecha.getDayOfMonth() > 0 && fecha.getDayOfMonth() <= 30){
						resultado = true;
					}


				}

				if(fecha.getMonthValue() == 1 || fecha.getMonthValue() ==  3|| fecha.getMonthValue() == 5
						|| fecha.getMonthValue() == 7 || fecha.getMonthValue() == 8 || fecha.getMonthValue() == 10 || fecha.getMonthValue() == 12  ){
					if(fecha.getDayOfMonth() > 0 && fecha.getDayOfMonth() <= 31){
						resultado = true;

					}

					if(fecha.getMonthValue() == 2 ){ //FEBRERO
						if(esBisiesto(fecha.getYear())){ //ES BISIESTO
							if(fecha.getDayOfMonth() >0 && fecha.getDayOfMonth() <= 29){
								resultado = true;
							}
							if(!(esBisiesto(fecha.getYear()))){
								if(fecha.getDayOfMonth() > 0 && fecha.getDayOfMonth() <= 28){
									resultado = true;
								}
							}
						}

					}
				}

			}

		}//FIN IF AÑO.
		return resultado;
	}


	//+ traerFechaCorta (LocalDate fecha) : String
	//Retorna “dd/mm/aaaa”

	public static String traerFechaCorta(LocalDate fecha){
		DateTimeFormatter formateoDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String resultado = fecha.format(formateoDeFecha);
		return resultado;
	}
	
	
	public static String traerFechaCorta(GregorianCalendar fecha){
		SimpleDateFormat formateoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
	//	DateTimeFormatter formateoDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//	String resultado = fecha.format(formateoDeFecha);
	//	return resultado;
		formateoDeFecha.setCalendar(fecha);
		String resultado = formateoDeFecha.format(fecha.getTime());
		return resultado;
	}



	//+ traerHoraCorta (LocalTime hora) : String
	//Retorna “hh:mm”
	public static String traerHoraCorta(LocalTime hora){
		DateTimeFormatter formateoDeHora = DateTimeFormatter.ofPattern("HH:mm");
		String resultado = hora.format(formateoDeHora);

		return resultado;
	}

	//+ esDiaHabil (LocalDate fecha) : boolean
	//Consideramos hábil de lunes a viernes.

	public static boolean esDiaHabil(LocalDate fecha){
		int d = fecha.getDayOfWeek().getValue();
		return (( d >=1) && ( d <=5));
	}

	//+ traerDiaDeLaSemana (LocalDate) : String
	public static String traerDiaDeLaSemana(LocalDate fecha){
		String resultado = "";

		if(fecha.getDayOfWeek().getValue() == 1){
			resultado = "LUNES";
		}

		if(fecha.getDayOfWeek().getValue() == 2){
			resultado = "MARTES";
		}
		if(fecha.getDayOfWeek().getValue() == 3){
			resultado = "MIÉRCOLES";
		}
		if(fecha.getDayOfWeek().getValue() == 4){
			resultado = "JUEVES";
		}

		if(fecha.getDayOfWeek().getValue() == 5){
			resultado = "VIERNES";
		}

		if(fecha.getDayOfWeek().getValue() == 6){
			resultado = "SÁBADO";
		}
		if(fecha.getDayOfWeek().getValue() == 7){
			resultado = "DOMINGO";
		}

		return resultado;
	}


	//+ traerMesEnLetras (LocalDate fecha) : String
	public static String traerMesEnLetras(LocalDate fecha){
		String mes = "";
		if(fecha.getMonth().getValue() == 1){
			mes = "ENERO";
		}
		if(fecha.getMonth().getValue() == 2){
			mes = "FEBRERO";
		}
		if(fecha.getMonth().getValue() == 3){
			mes = "MARZO";
		}
		if(fecha.getMonth().getValue() == 4){
			mes = "ABRIL";
		}
		if(fecha.getMonth().getValue() == 5){
			mes = "MAYO";
		}
		if(fecha.getMonth().getValue() == 6){
			mes = "JUNIO";
		}
		if(fecha.getMonth().getValue() == 7){
			mes = "JULIO";
		}
		if(fecha.getMonth().getValue() == 8){
			mes = "AGOSTO";
		}if(fecha.getMonth().getValue() == 9){
			mes =  "SEPTIEMBRE";
		}
		if(fecha.getMonth().getValue() == 10){
			mes =  "OCTUBRE";
		}
		if(fecha.getMonth().getValue() == 11){
			mes =  "NOVIEMBRE";
		}
		if(fecha.getMonth().getValue() == 12){
			mes =  "DICIEMBRE";
		}
		return mes;

	}

	//+ traerFechaLarga (LocalDate fecha) : String
	//Ejemplo: “Sábado 20 de Agosto del 2016”

	public static String traerFechaLarga(LocalDate fecha){
		return (traerDiaDeLaSemana(fecha) + " " + fecha.getDayOfMonth() + " de " + traerMesEnLetras(fecha) + " del " + fecha.getYear());
	}


	//+ traerCantDiasDeUnMes (int anio, int mes) : int
	public static int traerCantDiasDeUnMes (int anio, int mes){
		int cantidad = 0;
		if(mes == 4 || mes ==  6|| mes == 9 || mes == 11){
			cantidad = 30;
		}
		if(mes == 1 || mes ==  3|| mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12  ){
			cantidad = 31;
		}
		if(mes == 2 ){ //FEBRERO
			if(esBisiesto(anio)){ //ES BISIESTO
				cantidad = 29;
			}
			if(!(esBisiesto(anio))){
				cantidad = 28;
			}
		}
		return cantidad;
	}




	//+ aproximar2Decimal (double valor) : double
	// Si el tercer decimal es mayor o igual 5, suma 1 al segundo decimal.
	public static double aproximar2Decimal(double valor){
		String numeroEnString = String.valueOf(valor);
		BigDecimal numero = new BigDecimal(numeroEnString).round(new MathContext(3, RoundingMode.HALF_UP));
		double resultado = numero.doubleValue();
		return resultado;
	}




	//+ esNumero(char c) : boolean
	public static boolean esNumero(char c){
		boolean resultado = 	Character.isDigit(c);
		return resultado;
	}



	//+ esLetra(char c) : boolean
	public static boolean esLetra(char c){
		boolean resultado = 	Character.isLetter(c);

		return resultado;
	}


	//+ esCadenaNros(String cadena) : boolean
	public static boolean esCadenaNros(String cadena) throws Exception{
		boolean resultado = false;
		try{
			Integer.parseInt(cadena);
			resultado = true;}
		catch(Exception e){
			resultado = false;
			return resultado;			
		}


		return resultado;


	}


	//+ esCandenaLetras(String cadena) : boolean

	public static boolean esCadenaLetras(String cadena){
		char[] vect = cadena.toCharArray();
		boolean resultado = true;
		for(int i=0;i<vect.length;i++){
			if(Character.isDigit(vect[i])){
				resultado = false;


			}


		}
		return resultado;


	}


}



