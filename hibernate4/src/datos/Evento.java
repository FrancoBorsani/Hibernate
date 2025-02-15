package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class Evento {
	private long idEvento;
	private String evento;
	private LocalDate fecha;
	private LocalTime hora;
	private Set<Cliente> clientes;
	
	public Evento() {
		
		
	}
	
	public Evento(String evento, LocalDate fecha, LocalTime hora) {
		this.evento = evento;
		this.fecha = fecha;
		this.hora = hora;
		this.clientes = new LinkedHashSet<Cliente>();
		
	}

	public long getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	
	
	
	
	
	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	

	public boolean equals(Evento obj) {
		if(!evento.equalsIgnoreCase(obj.getEvento())) {
			return false;
			
		}
		return true;
		
	}
	
	public void agregar(Cliente cliente) {
		this.getClientes().add(cliente);
	}
	
	public boolean eliminar (Cliente cliente) {
		return clientes.remove(cliente);
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", evento=" + evento + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
	
	
	
	
	
	
}
