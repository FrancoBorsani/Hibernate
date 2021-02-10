package datos;

public abstract class Persona {
	protected int id;
	protected String nroCuenta;
	
	
	public Persona() {
		
	}
	
	public Persona(String nroCuenta) {
		super();
		this.nroCuenta = nroCuenta;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nroCuenta=" + nroCuenta + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
