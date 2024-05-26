package ar.edu.unlam.pb2.parkingTP;

import java.util.ArrayList;

public interface IEstacionamiento {
	
	ArrayList<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistema();
	ArrayList<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistemaPorTipoDeVehiculo(TipoDeVehiculo tipo);
	ArrayList<VehiculoPlaza> MostrarTodasLasPlazasDelEstacionamientoDelSistemaQueEstenOcupadas();
	
}
