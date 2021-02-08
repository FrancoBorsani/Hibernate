package test;

import java.net.SocketTimeoutException;

import datos.Cliente;
import datos.Prestamo;
import negocio.PrestamoABM;

public class TestActualizarPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM abm = new PrestamoABM();
		long id = 3;
		// traer el obj a modificar
		Prestamo p = null;
		try{
		p = abm.traerPrestamo(id);
		System. out .println( "Prestamo a Modificar -->" + p );}
		catch(Exception e){
			System.out.println("Error al traer el prestamo: " + e.getMessage());
			
			
		}
		// modificar por set los atributos
		p.setMonto(30000);
		
		try{
		abm .modificar( p ); // update del objeto}
		Prestamo pModif = abm.traerPrestamo(id);
		System. out .println( "Prestamo Modificado -->" + pModif);}
		catch(Exception e){
			System.out.println("Error al modificar un cliente: " + e.getMessage());
			
		}
		
		//int dni = 14000000;
		
		
	}

}
