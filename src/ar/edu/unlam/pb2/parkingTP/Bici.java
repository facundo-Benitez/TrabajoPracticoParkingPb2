package ar.edu.unlam.pb2.parkingTP;

public class Bici extends Vehiculo {
	private final double HORA_BICI = 500.0;
	
	public Bici(String patente, TipoDeVehiculo tipo, Tickets tickets) {
		super(patente, tipo, tickets);
		
	}

	@Override
	public Double calcularCosto() {
		Double costo=0.0;
		Double tiempoEstadiaEnHoras=((double)(super.getTickets().calculoTiempoEstadiaEnMinutos()))/60;
		if(super.getTickets().getFechaHoraSalida()!=null) {
		   costo=tiempoEstadiaEnHoras*HORA_BICI;	
		}	
		return costo;
	}



}
