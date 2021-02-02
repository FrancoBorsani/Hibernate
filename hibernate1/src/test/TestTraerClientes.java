package test;

import negocio.ClienteABM;

public class TestTraerClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ClienteABM cTraer = new ClienteABM();
			
			
			System.out.println("Clientes traidos: " + cTraer.traer());
			
			
	}

}
