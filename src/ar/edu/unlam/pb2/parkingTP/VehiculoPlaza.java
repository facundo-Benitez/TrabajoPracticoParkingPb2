package ar.edu.unlam.pb2.parkingTP;

import java.util.Objects;

public class VehiculoPlaza {
	private Plaza PlazaDeVehiculo;
	private Vehiculo vehiculoEnPlaza;
	
	public VehiculoPlaza(Plaza PlazaDeVehiculo,Vehiculo vehiculoEnPlaza) {
		this.PlazaDeVehiculo =PlazaDeVehiculo;
		this.vehiculoEnPlaza = vehiculoEnPlaza;
		
	}

	public Plaza getPlazaDeVehiculo() {
		return PlazaDeVehiculo;
	}

	public void setPlazaDeVehiculo(Plaza plazaDeVehiculo) {
		PlazaDeVehiculo = plazaDeVehiculo;
	}

	public Vehiculo getVehiculoEnPlaza() {
		return vehiculoEnPlaza;
	}

	public void setVehiculoEnPlaza(Vehiculo vehiculoEnPlaza) {
		this.vehiculoEnPlaza = vehiculoEnPlaza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PlazaDeVehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiculoPlaza other = (VehiculoPlaza) obj;
		return Objects.equals(PlazaDeVehiculo, other.PlazaDeVehiculo);
	}

}
