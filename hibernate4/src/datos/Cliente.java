package datos;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Cliente {
	private long idCliente ;
	private String apellido ;
	private String nombre ;
	private int dni ;
	private LocalDate fechaDeNacimiento ;
	private boolean baja ;
	private Set<Evento> eventos;
	
	
	public Cliente(){} // siempre hay que implementar el constructor vacio
	// nunca va el id en el constructor por ser autoincrementable
	public Cliente(String apellido , String nombre , int dni ,
			LocalDate fechaDeNacimiento ) {
		super ();
		this . apellido = apellido ;
		this . nombre = nombre ;
		this . dni = dni ;
		this . fechaDeNacimiento = fechaDeNacimiento ;
		this . baja = false ;
		this.eventos = new LinkedHashSet<Evento>();
	}
	public long getIdCliente() {
		return idCliente ;
	}
	// siempre va protected, para que no sea modificado
	protected void setIdCliente( long idCliente ) {
		this . idCliente = idCliente ;
	}
	public String getApellido() {
		return apellido ;
	}
	public void setApellido(String apellido ) {
		this . apellido = apellido ;
	}
	public String getNombre() {

		return nombre ;
	}
	public void setNombre(String nombre ) {
		this . nombre = nombre ;
	}
	public int getDni() {
		return dni ;
	}
	public void setDni( int dni ) {
		this . dni = dni ;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento ;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento ) {
		this . fechaDeNacimiento = fechaDeNacimiento ;
	}
	public boolean isBaja() {
		return baja ;
	}
	public void setBaja( boolean baja ) {
		this . baja = baja ;
	}
	
	
	
	

	public Set<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}
	

	public boolean equals(Cliente obj) {
		if (dni != obj.dni)
			return false;
		return true;
	}
	public void agregar(Evento evento) {
		this.getEventos().add(evento);
	}
	
	public void eliminar(Evento evento) {
		this.getEventos().remove(evento);
	}
	
	
	
	
	public String toString(){
		return ( idCliente + " " + apellido + " " + nombre + " DNI: " + dni + "" + baja );
	}
}