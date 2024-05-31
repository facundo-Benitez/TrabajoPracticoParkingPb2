package ar.edu.unlam.pb2.parkingTP;

import java.util.ArrayList;

public interface IEstacionamiento {
	
	ArrayList<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistema();
	ArrayList<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistemaPorUnTipoDeVehiculo(TipoDeVehiculo tipo);
	ArrayList<VehiculoPlaza> MostrarTodasLasPlazasDelEstacionamientoDelSistemaQueEstenOcupadas();
	Boolean asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(Vehiculo vehiculo, Plaza plazaSeleccionada);
	Boolean habilitarPlazaUnaVesDesocupada(VehiculoPlaza plazaAHabilitar);
	
}
