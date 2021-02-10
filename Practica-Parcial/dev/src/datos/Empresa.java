package datos;

public class Empresa extends Persona{
	private String razonSocial;
	
	
	
	public Empresa() {
		
		
	}
	
	public Empresa(String nroCuenta, String razonSocial) {
		super(nroCuenta);
		this.razonSocial = razonSocial;
		
		
	}


	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "Empresa [razonSocial=" + razonSocial + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
