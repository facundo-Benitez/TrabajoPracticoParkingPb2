package ar.edu.unlam.pb2.parkingTP;

import java.time.Duration;
import java.time.LocalDateTime;

public class Tickets {
	
	private Integer id;
	private LocalDateTime fechaHoraEntrada;
	private LocalDateTime fechaHoraSalida;
	private Integer nroPlaza;
	private Double costo;
	private static final double HORA_COCHE = 2000.0;
    private static final double HORA_MOTO = 1000;
	
	// en realidad se hace un ticket a la entrada ya a la salida se cierra el fechaHoraSalida pero esto es modelo de practica, lo mismo con el costo.
	public Tickets(Integer id, LocalDateTime fechaHoraEntrada,LocalDateTime fechaHoraSalida, Integer nroPlaza, Double costo) {
		this.id = id;
		this.fechaHoraEntrada = fechaHoraEntrada;
		this.fechaHoraSalida= fechaHoraSalida;
		this.nroPlaza = nroPlaza;
		this.costo = costo;
	}
	
	
	public double calcularCosto(Vehiculo vehiculo){
		Double valorVehiculo=getValorVehiculo(vehiculo);
		Double tiempoEstadiaEnHoras= ((double)calculoTiempoEstadiaEnMinutos()/60); //ponemos el double adelante para que cuente los minutos tambien, sino se come los numeros detras de la coma
		Double valorTotal=valorVehiculo*tiempoEstadiaEnHoras;
		setCosto(valorTotal);
		return valorTotal;
	}
	
	public Double getValorVehiculo(Vehiculo vehiculo){
		String tipoVehiculo =vehiculo.getClass().getSimpleName();
		Double valorDependiendoDeVehiculo=0.0;
		switch(tipoVehiculo) {
			case "Auto":
				valorDependiendoDeVehiculo=HORA_COCHE;
				break;
				
			case "Bici":
				valorDependiendoDeVehiculo=HORA_MOTO;
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
}
	
