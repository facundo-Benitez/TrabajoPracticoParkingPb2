package ar.edu.unlam.pb2.parkingTP;

public class Estacionamiento implements IEstacionamiento{
	private String nombreEstacionamiento;

	public Estacionamiento(String nombreEstacionamiento) {
		this.nombreEstacionamiento = nombreEstacionamiento;
	}

	public String getNombreEstacionamiento() {
		return nombreEstacionamiento;
	}
	
}
