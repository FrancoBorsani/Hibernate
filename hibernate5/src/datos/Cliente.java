package datos;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Cliente {
	private long idCliente ;
	private String nroCliente;
	
	
	public Cliente(){} 
	public Cliente(String nroCliente) {
		super ();
		this.nroCliente = nroCliente;
	}
	public long getIdCliente() {
		return idCliente;
	}
	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNroCliente() {
		return nroCliente;
	}
	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nroCliente=" + nroCliente + "]";
	}
	
	
	
	
	
	
	
}