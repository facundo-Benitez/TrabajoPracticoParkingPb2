package ar.edu.unlam.pb2.parkingTP;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Tickets {
	
	private Integer id;
	private LocalDateTime fechaHoraEntrada;
	private LocalDateTime fechaHoraSalida;
	private Integer nroPlaza;
	
	// en realidad se hace un ticket a la entrada ya a la salida se cierra el fechaHoraSalida pero esto es modelo de practica, lo mismo con el costo.
	public Tickets(Integer id, LocalDateTime fechaHoraEntrada, Integer nroPlaza) {
		this.id = id;
		this.fechaHoraEntrada = fechaHoraEntrada;
		this.nroPlaza = nroPlaza;
	}
	
	public Tickets(Integer id, LocalDateTime fechaHoraEntrada, LocalDateTime fechaHoraSalida, Integer nroPlaza) {
		this.id = id;
		this.fechaHoraEntrada = fechaHoraEntrada;
		this.fechaHoraSalida=fechaHoraSalida;
		this.nroPlaza = nroPlaza;
	}
	
	public Boolean registrarSalida(LocalDateTime retiro){
		setFechaHoraSalida(retiro);
		return true;
	}
	
	public Integer calculoTiempoEstadiaEnMinutos(){
		Duration tiempoEstadia = Duration.between(this.fechaHoraEntrada, this.fechaHoraSalida);
		Integer estadiaEnMinutos =(int) tiempoEstadia.toMinutes();
		return estadiaEnMinutos;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getNroPlaza() {
		return nroPlaza;
	}



	public void setNroPlaza(Integer nroPlaza) {
		this.nroPlaza = nroPlaza;
	}



	public LocalDateTime getFechaHoraEntrada() {
		return fechaHoraEntrada;
	}

	public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
		this.fechaHoraEntrada = fechaHoraEntrada;
	}

	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tickets other = (Tickets) obj;
		return Objects.equals(id, other.id);
	}

	public void imprimirTicket() {
		System.out.print(toString());
	}

	@Override
	public String toString() {
		return "Tickets [id=" + id + ", fechaHoraEntrada=" + fechaHoraEntrada + ", fechaHoraSalida=" + fechaHoraSalida
				+ ", nroPlaza=" + nroPlaza + "]";
	}

}
	
