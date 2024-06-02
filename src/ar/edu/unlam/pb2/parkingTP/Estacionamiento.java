package ar.edu.unlam.pb2.parkingTP;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Estacionamiento {
    private String nombre;
    private List<Vehiculo> vehiculos;
    private Set<Plaza> plazas;

    public Estacionamiento(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
        this.plazas = new TreeSet<>();
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
		return vehiculos.add(vehiculo) ;
	}
    
	public Cliente queSePuedeVincularElClienteConLaPatente(String patente) {
		for (Vehiculo vehiculo : vehiculos) {
			if (patente.equals(vehiculo.getPatente())) {				
			}
			return vehiculo.getCliente();
		}
		return null;	
	}

    public boolean agregarVehiculoAUnaPlazaLibre(Vehiculo vehiculo, TipoPlaza tipo) {
        for (Plaza plaza : plazas) {
            if (plaza.estaLibre() /*&& ((vehiculo instanceof Auto && plaza.getTipo() == TipoPlaza.AUTO) ||
                                       	(vehiculo instanceof Moto && plaza.getTipo() == TipoPlaza.MOTO) ||
                                       (vehiculo instanceof Camioneta && plaza.getTipo() == TipoPlaza.CAMIONETA) ||
                                       (vehiculo instanceof Bici && plaza.getTipo() == TipoPlaza.BICI))*/) {
                plaza.asignarVehiculo(vehiculo, tipo);
                plaza.asignarUnNumeroAPlaza(plaza);
              
                return true;
            }
        }
		return false;       
    }
   
	public Integer obtenerEstacionamientoDeAutoPorPatente(String patente) {
			for (Plaza numeroDePlaza : plazas) {	
			Vehiculo vehiculo = numeroDePlaza.getVehiculo();
			if(patente.equals(vehiculo.getPatente()))			
				return numeroDePlaza.getNumero();
			}
		
		return null;
	}
	
	public Integer buscarBici(String marca, String color) {
		for (Plaza plaza : plazas) {
			Vehiculo vehiculo = plaza.getVehiculo();
			if((vehiculo instanceof Bici && plaza.getTipo()== TipoPlaza.BICI)&& vehiculo.getMarca()== marca && vehiculo.getColor()== color) {
				return plaza.getNumero();	
			}	
		}	
		return null;
	}

/*
    public boolean retirarVehiculo(String patente) {
        for (Plaza plaza : plazas) {
            if (plaza.getVehiculo() != null && plaza.getVehiculo().getPatente().equals(patente)) {
                plaza.liberarPlaza();
                return true;
            }
        }
        return false;
    }




	public Integer obtenerEstacionamientoDeAutoPorPatente(String patente) {
		
		for (Plaza  numeroDePlaza: plazas) {
			Vehiculo vehiculo = numeroDePlaza.getVehiculo();
			if(vehiculo.getPatente()== patente)
				return numeroDePlaza.getNumero();
		}
		return null;
	}

	public Integer buscarBici(String marca, String color) {
		for (Plaza plaza : plazas) {
			Vehiculo vehiculo = plaza.getVehiculo();
			if((vehiculo instanceof Bici && plaza.getTipo()== TipoPlaza.BICI)&& vehiculo.getMarca()== marca && vehiculo.getColor()== color) {
				return plaza.getNumero();	
			}	
		}	
		return null;
	}*/
	
	/*
	public boolean agegarUnaPlazaDeMotoAlEstacionamiento(Plaza plazaDeMoto) {
		if (plazas.size()!=30) {
		plazas.add(plazaDeMoto);		
	}
	return true;
	}


	public boolean agregarUnaMotoAUnaPlazaLibre(Moto patente) {
		
		for (Plaza plazaLibre : plazas) {
			if(	plazaLibre.estaLibbreMoto()) {
			plazaLibre.asignarMoto(patente);
			return true;
			}
	
		}
		return false;
		
	}
	public Integer obtenerEstacionamientoDeMotoPorPatente(String patente) {
		
		for (Plaza  numeroDePlaza: plazas) {
			Moto moto = numeroDePlaza.getMoto();
			if(moto.getPatente()==patente)
				return numeroDePlaza.getNumero();
		}
		return null;
	}
	public boolean agregarVehiculoAUnaPlazaLibre(Vehiculo vehiculo) throws sobreCargaDePlazasExcepcion {
	    for (Plaza plaza : plazas) {
	        if (plaza.estaLibre() && vehiculo instanceof Auto && plaza.getTipo() == TipoPlaza.AUTO) {
	            plaza.asignarVehiculo(vehiculo);
	            return true;
	        } else if (plaza.estaLibre() && vehiculo instanceof Moto && plaza.getTipo() == TipoPlaza.MOTO) {
	            plaza.asignarVehiculo(vehiculo);
	            return true;
	        } else if (plaza.estaLibre() && vehiculo instanceof Bici && plaza.getTipo() == TipoPlaza.BICI) {
	            plaza.asignarVehiculo(vehiculo);
	            return true;
	        }
	    }
	    throw new sobreCargaDePlazasExcepcion();
	}
*/	
	public boolean retirarVehiculo(String patente) {
	    for (Plaza plaza : plazas) {
	        if (plaza.getVehiculo() != null && plaza.getVehiculo().getPatente().equals(patente)) {
	            plaza.liberarPlaza();
	            return true;
	        }
	    }
	    return false;
	}
	
}
	
