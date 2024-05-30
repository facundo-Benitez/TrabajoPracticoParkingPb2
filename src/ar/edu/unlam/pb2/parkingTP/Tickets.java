package ar.edu.unlam.pb2.parkingTP;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Tickets {
	
	private Integer id;
	private LocalDateTime fechaHoraEntrada;
	private LocalDateTime fechaHoraSalida;
	private Integer nroPlaza;
	private Double costo;
	private static final double HORA_COCHE = 2000.0;
    private static final double HORA_MOTO = 1000.0;
	private static final double HORA_BICI = 500.0
	private static final double HORA_CAMIONETA =2500.0
	
	// en realidad se hace un ticket a la entrada ya a la salida se cierra el fechaHoraSalida pero esto es modelo de practica, lo mismo con el costo.
	public Tickets(Integer id, LocalDateTime fechaHoraEntrada, Integer nroPlaza) {
		this.id = id;
		this.fechaHoraEntrada = fechaHoraEntrada;
		this.nroPlaza = nroPlaza;
	}
	
	public Boolean registrarSalida(LocalDateTime retiro){
		setFechaHoraSalida(retiro);
		return true;
	}


	public double calcularCosto(Vehiculo vehiculo){
		Double valorVehiculo=getValorVehiculo(vehiculo);
		Double tiempoEstadiaEnHoras= ((double)calculoTiempoEstadiaEnMinutos()/60); //ponemos el double adelante para que cuente los minutos tambien, sino se come los numeros detras de la coma
		Double valorTotal=valorVehiculo*tiempoEstadiaEnHoras;
		setCosto(valorTotal);
		return valorTotal;
	}
	
	public Double getValorVehiculo(Vehiculo vehiculo){
		TipoDeVehiculo tipoVehiculo =vehiculo.getTipo();
		Double valorDependiendoDeVehiculo=0.0;
		switch(tipoVehiculo) {
			case CAMIONETA:
				valorDependiendoDeVehiculo=HORA_CAMIONETA;
				break;

			case AUTO:
				valorDependiendoDeVehiculo=HORA_COCHE;
				break;
				
			case MOTO:
				valorDependiendoDeVehiculo=HORA_MOTO;
				break;

			case BICI:
				valorDependiendoDeVehiculo=HORA_BICI;
				break;
		}
		return valorDependiendoDeVehiculo;
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

	public Double getCosto(){
		return costo;
	}

	public void setCosto(Double costoNuevo){
		this.costo=costoNuevo;
	}

		@Override
	public int hashCode() {
		return Objects.hash(costo, fechaHoraEntrada, fechaHoraSalida, id, nroPlaza);
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

}
	
