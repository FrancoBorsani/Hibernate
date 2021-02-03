package test;
import java.time.LocalDate;

import datos.Contacto;
import negocio.ClienteABM;
import negocio.ContactoABM;
public class TestAgregarCliente {
public static void main(String[] args ) {
String apellido = "Tomas" ;
String nombre = "Cambos" ;
int documento = 42000000;
// tu fecha de nacimiento
LocalDate fechaDeNacimiento = LocalDate.of(1999, 9, 11);
ClienteABM abm = new ClienteABM();
ContactoABM abmContacto = new ContactoABM();
Contacto contacto = abmContacto.traer(1); 

try {
long ultimoIdCliente = abm .agregar( apellido , nombre , documento ,
fechaDeNacimiento, contacto );}
catch(Exception e) {
	System.out.println(""+ e.getMessage());
	
}



}
}