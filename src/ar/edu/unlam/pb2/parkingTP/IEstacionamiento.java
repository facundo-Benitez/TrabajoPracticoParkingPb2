package ar.edu.unlam.pb2.parkingTP;

import java.util.HashSet;

public interface IEstacionamiento {
	
	HashSet<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistema();
	HashSet<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistemaPorUnTipoDeVehiculo(TipoDeVehiculo tipo);
	HashSet<VehiculoPlaza> MostrarTodasLasPlazasDelEstacionamientoDelSistemaQueEstenOcupadas();
	Boolean asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(Vehiculo vehiculo, Plaza plazaSeleccionada);
	Boolean habilitarPlazaUnaVesDesocupada(VehiculoPlaza plazaAHabilitar);
	
}
