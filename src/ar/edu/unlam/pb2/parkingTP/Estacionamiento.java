package ar.edu.unlam.pb2.parkingTP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Estacionamiento implements IEstacionamiento {
	private String nombre;
	private List<Vehiculo> vehiculos;
	private Set<Plaza> plazas;
	private ArrayList<PlazaVehiculo> AsignacionVehiculosplazas;
	private Map<Vehiculo, Plaza>AsignacionVehiculosplazas;

	public Estacionamiento(String nombre) {
		this.nombre = nombre;
		this.vehiculos = new ArrayList<>();
		this.plazas = new TreeSet<>();
		 this.AsignacionVehiculosplazas  = new HashMap<>();
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean agregarVehiculo(Vehiculo vehiculo) {
		return vehiculos.add(vehiculo);
	}

	public Cliente queSePuedeVincularElClienteConLaPatente(String patente) {
		for (Vehiculo vehiculo : vehiculos) {
			if (patente.equals(vehiculo.getPatente())) {
			}
			return vehiculo.getCliente();
		}
		return null;
	}

	public Plaza crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo( Integer nuevaPlaza) {
		Plaza nuevoLugar = new Plaza(nuevaPlaza, null);
		return nuevoLugar;
	}

	/*public Boolean agregarUnLugarDeEstacionamientoAlSistema(Integer nuevoLugar) {
		return this.AsignacionVehiculosplazas.add(nuevoLugar);
	}*/

	/*
	 * @Override public Boolean
	 * asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(Vehiculo
	 * vehiculo, Plaza plazaSeleccionada) { Boolean seAsigno=false; for (Plaza
	 * vehiculoPlazaEstacionamiento : AsignacionVehiculosplazas) {
	 * if(vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().equals(plazaSeleccionada
	 * )&&vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getEstaOcupado()==false)
	 * { if(vehiculoPlazaEstacionamiento.getVehiculoEnPlaza()==null &&
	 * plazaSeleccionada.getTipo().equals(vehiculo.getTipo())) {
	 * vehiculoPlazaEstacionamiento.setVehiculoEnPlaza(vehiculo);
	 * vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().setEstaOcupado(true);
	 * return seAsigno=true; } } } return seAsigno; }
	 */
    public boolean asignarUnVehiculoAUnaPlazaLibre(Vehiculo vehiculo, Plaza numeroEstacionamiento) {
        for (Entry<Vehiculo, Plaza> entrada : AsignacionVehiculosplazas.entrySet()) {
            if (entrada.getValue().equals(numeroEstacionamiento) && entrada.getKey() == null) {
                // Asignar el veh�culo a la plaza libre
                AsignacionVehiculosplazas.put(vehiculo, numeroEstacionamiento);
                numeroEstacionamiento.ocupar();
                return true;
            }
        }
       
        return false;
    }
    
    public Plaza obtenerEstacionamientoDeAutoPorPatente2(String patente) {
        for (Entry<Vehiculo, Plaza> entrada : AsignacionVehiculosplazas.entrySet()) {
            if (entrada.getKey() != null && entrada.getKey().getPatente().equals(patente)) {
                return entrada.getValue();
            }
        }
        return null;
    }


	public boolean agregarVehiculoAUnaPlazaLibre(Vehiculo vehiculo, TipoDeVehiculo tipo)
			throws sobreCargaDePlazasExcepcion {
		for (Plaza plaza : plazas) {
			if (plaza.estaLibre() && ((vehiculo instanceof Auto && plaza.getTipo() == TipoDeVehiculo.AUTO)
					|| (vehiculo instanceof Moto && plaza.getTipo() == TipoDeVehiculo.MOTO)
					|| (vehiculo instanceof Camioneta && plaza.getTipo() == TipoDeVehiculo.CAMIONETA)
					|| (vehiculo instanceof Bici && plaza.getTipo() == TipoDeVehiculo.BICI))) {

				return this.agregarVehiculo(vehiculo);
			}
		}
		throw new sobreCargaDePlazasExcepcion("lleno");
	}

	public String obtenerEstacionamientoDeAutoPorPatente(String patente) {
		for (Vehiculo vehiculo : vehiculos) {
			if (patente.equals(vehiculo.getPatente()))
				return vehiculo.getPatente();
		}

		return null;
	}

	public String buscarBici(String marca, String color) {
		for (Vehiculo vehiculo : vehiculos) {

			if (vehiculo.getMarca() == marca && vehiculo.getColor() == color) {
				return vehiculo.getPatente();
			}
		}
		return null;
	}

	public boolean retirarVehiculo(String patente) {

		for (Plaza plaza : plazas) {
			if (plaza.getVehiculo() != null && plaza.getVehiculo().getPatente().equals(patente)) {
				plaza.liberarPlaza();
				return true;
			}
		}
		return false;
	}

	public boolean agregarUnaPlazaAlEstacionamiento(Plaza plaza) {
		return this.plazas.add(plaza);

	}

}
