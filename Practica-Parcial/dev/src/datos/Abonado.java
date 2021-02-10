package datos;

public class Abonado extends Persona {
	private int id;
	private String apellido;
	private String nombres;
	private long dni;
	
	
	
	public Abonado() {
		
	}
	
	public Abonado(String nroCuenta, String apellido, String nombres, long dni) {
		super(nroCuenta);
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
		
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Abonado [id=" + id + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
