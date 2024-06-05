package ar.edu.unlam.pb2.parkingTP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Estacionamiento implements EstacionamientoInter {
	private String nombre;
	private List<Vehiculo> vehiculos;
	private Set<Plaza> plazas;
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

	@Override
	public boolean asignarUnVehiculoAUnaPlazaLibre(Vehiculo vehiculo, Plaza numeroEstacionamiento,TipoDeVehiculo tipo) {
    	for (Plaza plaza : plazas) {
    	if(plaza.estaLibre()&& ((vehiculo instanceof Auto && plaza.getTipo() == TipoDeVehiculo.AUTO)
				|| (vehiculo instanceof Moto && plaza.getTipo() == TipoDeVehiculo.MOTO)
				|| (vehiculo instanceof Camioneta && plaza.getTipo() == TipoDeVehiculo.CAMIONETA)
				|| (vehiculo instanceof Bici && plaza.getTipo() == TipoDeVehiculo.BICI))) {
    		this.AsignacionVehiculosplazas.put(vehiculo, numeroEstacionamiento);
                return true;
            }
        }
       
        return false;
    }
    
    public Plaza obtenerEstacionamientoDeAutoPorPatente2(String patente) {
        for (Map.Entry<Vehiculo, Plaza> entry : this.AsignacionVehiculosplazas.entrySet()) {
            Vehiculo vehiculo = entry.getKey();
            if (vehiculo.getPatente().equals(patente)) {
            	for (Plaza plaza : plazas) {					
                return plaza;
            }
        }
      }
        return null;
    }
   
	public Plaza buscarBici(String marca, String color, TipoDeVehiculo tipo) {
		for (Map.Entry<Vehiculo, Plaza> entry : this.AsignacionVehiculosplazas.entrySet()) {
            Vehiculo vehiculo = entry.getKey();
            for (Plaza plaza : plazas) {
            if (vehiculo.getMarca().equals(marca)&&vehiculo.getColor().equals(color)&&(vehiculo instanceof Bici && plaza.getTipo() == TipoDeVehiculo.BICI)) {
            						
                return plaza;
            }
        }
      }
        return null;
    }

	public boolean retirarVehiculo(String patente) {
	    for (Map.Entry<Vehiculo, Plaza> entry : this.AsignacionVehiculosplazas.entrySet()) {
	        Vehiculo vehiculo = entry.getKey();
	        if (vehiculo.getPatente().equals(patente)) {
	            Plaza plaza = entry.getValue();
	            plaza.liberarPlaza(); // Suponiendo que este método actualiza el estado de la plaza a libre.
	            this.AsignacionVehiculosplazas.remove(vehiculo); // Eliminar la asignación del vehículo
	            return true;
	        }
	    }
	    return false;
	}

	public boolean agregarUnaPlazaAlEstacionamiento(Plaza plaza) {
		return this.plazas.add(plaza);

	}



}
