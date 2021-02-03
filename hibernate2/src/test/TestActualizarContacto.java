package test;
import datos.Cliente;
import datos.Contacto;
import negocio.ClienteABM;
import negocio.ContactoABM;
public class TestActualizarContacto {
public static void main(String[] args ) {
ContactoABM abm = new ContactoABM();
ClienteABM abmCliente = new ClienteABM();
long id = 5;
// traer el obj a modificar
Contacto c = abm .traer( id );
System. out .println( "Contacto a Modificar -->" + c );
Cliente cliente = abmCliente.traer(6);
// modificar por set los atributos
//c .setEmail("mdbcrew@gmail.com");
c.setCliente(cliente);
try {
abm .modificar( c ); // update del objeto
int idTraer = 5;
Contacto cModif = abm.traer(idTraer);
System. out .println( "Contacto Modificado -->" + cModif );}
catch(Exception e) {
	System.out.println("" + e.getMessage());
}

}
}