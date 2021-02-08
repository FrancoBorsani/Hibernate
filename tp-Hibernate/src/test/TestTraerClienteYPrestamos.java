package test;
import java.util.ArrayList;
import java.util.Set;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
public class TestTraerClienteYPrestamos {
public static void main(String[] args ) {
long idCliente =2;
ClienteABM cliAbm = new ClienteABM();
try{
Cliente c = cliAbm . traerClienteYPrestamos ( idCliente );
System. out .println( "\n---> Traer Cliente y Prestamos idCliente=" + idCliente );
System. out .println( "\n" + c );

//implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
if(c.getPrestamos().size() == 0){
	System.out.println("El cliente no tiene prestamos pendientes.");
}else{
for (Prestamo p : c .getPrestamos()) System. out .println( "\n" + p );}
}

catch(Exception e){
	System.out.println("Error al traer el cliente: " + e.getMessage());
}


}
}