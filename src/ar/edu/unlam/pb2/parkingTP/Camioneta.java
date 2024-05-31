package ar.edu.unlam.pb2.parkingTP;

public class Camioneta extends Vehiculo {
	private final Double HORA_CAMIONETA =2500.0;
	
	public Camioneta(String patente, TipoDeVehiculo tipo, Tickets tickets) {
		super(patente, tipo, tickets);
		
	}

	@Override
	public Double calcularCosto() {
		Double costo=0.0;
		Double tiempoEstadiaEnHoras=((double)(super.getTickets().calculoTiempoEstadiaEnMinutos()))/60;
		if(super.getTickets().getFechaHoraSalida()!=null) {
	       costo=tiempoEstadiaEnHoras*HORA_CAMIONETA;
		
		}
		return costo;
	}



}
