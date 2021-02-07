package datos;

public class PersonaJuridica extends Cliente {
	private long idPersonaJuridica;
	private String razonSocial;
	private String cuit;
	
	
	
	public PersonaJuridica() {
		
	}
	
	public PersonaJuridica(String nroCliente, String razonSocial, String cuit) {
		super(nroCliente);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}
	
	
	
	
	
	

	public long getIdPersonaJuridica() {
		return idPersonaJuridica;
	}

	protected void setIdPersonaJuridica(long idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	@Override
	public String toString() {
		return "PersonaJuridica [idCliente= " + this.getIdCliente() + ", nroCliente=" + this.getNroCliente() + "razonSocial=" + razonSocial + ", cuit=" + cuit + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
