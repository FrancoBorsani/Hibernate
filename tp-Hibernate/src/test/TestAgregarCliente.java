package test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.Cliente;
import negocio.ClienteABM;
public class TestAgregarCliente {
public static void main(String[] args ) {
String apellido = "YEAH" ;
String nombre = "CHULU" ;
int documento = 42000001;
//Contacto contacto = null;
// tu fecha de nacimiento
// LocalDate fechaDeNacimiento = LocalDate.of(1999, 07, 27);
LocalDate fechaDeNacimiento = LocalDate.now();
ClienteABM abm = new ClienteABM();
try{
long ultimoIdCliente = abm .agregar( apellido , nombre , documento ,
fechaDeNacimiento);
System.out.println("Cliente agregado con éxito.");}
catch(Exception e){
	System.out.println("Error al agregar un cliente: " + e.getMessage());
}

}
}