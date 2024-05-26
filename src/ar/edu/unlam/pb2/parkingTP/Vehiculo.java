package ar.edu.unlam.pb2.parkingTP;

import java.util.Objects;

public abstract class Vehiculo {
	private String patente;
	private TipoDeVehiculo tipo;
	
	public Vehiculo(String patente,TipoDeVehiculo tipo) {
		this.patente = patente;
		this.tipo=tipo;
	}

	public String getPatente() {
		return patente;
	}
	
	public TipoDeVehiculo getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(patente, other.patente);
	}

}
