package datos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Telepeaje {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private double precio;
	private Rodado rodado;



	public Telepeaje() {


	}


	public Telepeaje(LocalDate fecha, LocalTime hora, double precio, Rodado rodado) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.rodado = rodado;


	}


	public int getId() {
		return id;
	}


	protected void setId(int id) {
		this.id = id;
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


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Rodado getRodado() {
		return rodado;
	}


	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}


	@Override
	public String toString() {
		return "Telepeaje [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio + "]";
	}




	public double calcularRecargo(double porcentajeRecargo) {
		double recargo = 0;

		if(!this.getFecha().getDayOfWeek().equals(DayOfWeek.SATURDAY) && 
				!this.getFecha().getDayOfWeek().equals(DayOfWeek.SUNDAY)){
				System.out.println("----------------------------------------");
					if(this.getHora().isAfter(LocalTime.of(7, 00)) && this.getHora().isBefore(LocalTime.of(11, 00))) {
						System.out.println("----------------------------------------");
						recargo = (this.precio * porcentajeRecargo)/100;
					}else if(this.getHora().isAfter(LocalTime.of(17, 00))
							&& this.getHora().isBefore(LocalTime.of(19, 00))) {
						
						recargo = (this.precio * porcentajeRecargo)/100;
					}


		}

			
		
		return recargo;

	}


}
