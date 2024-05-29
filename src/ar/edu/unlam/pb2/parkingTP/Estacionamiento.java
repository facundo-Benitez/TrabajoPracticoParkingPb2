package ar.edu.unlam.pb2.parkingTP;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estacionamiento implements IEstacionamiento{
	private String nombreEstacionamiento;
	private ArrayList <Vehiculo> vehiculos;
	private ArrayList <Plaza>plazas;
	private ArrayList <VehiculoPlaza>AsignacionVehiculosplazas;
	private List<ReservaPlaza> reservasPlaza;

	public Estacionamiento(String nombreEstacionamiento) {
		this.nombreEstacionamiento = nombreEstacionamiento;
		this.vehiculos = new ArrayList<>();		
		this.plazas= new ArrayList<>();
		this.AsignacionVehiculosplazas= new ArrayList<>();
		this.reservasPlaza = new ArrayList<>();
	}

	public String getNombreEstacionamiento() {
		return nombreEstacionamiento;
	}
	
	public Boolean agregarVehiculo(Vehiculo vehiculo) {	
		return vehiculos.add(vehiculo) ;
	}

	public Boolean agregarPlazasAlEstacionamiento(Plaza plazaDelEstacionamiento) {
		return this.plazas.add(plazaDelEstacionamiento);
	}
	
	public VehiculoPlaza crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(Plaza nuevaPlaza) {
		VehiculoPlaza nuevoLugar=new VehiculoPlaza(nuevaPlaza,null);	
		return nuevoLugar;
	}

	public Boolean agregarUnLugarDeEstacionamientoAlSistema(VehiculoPlaza nuevoLugar) {
		return this.AsignacionVehiculosplazas.add(nuevoLugar);
	}
	
	public Boolean eliminarUnaPlazaDelEstacionamiento(Plaza plazaAEliminar) {
		Boolean seElimino=false;
		for (Plaza plazaEstacionamiento : plazas) {
			if(plazaEstacionamiento.equals(plazaAEliminar)) {
				this.plazas.remove(plazaEstacionamiento);
				return seElimino=true;
			}
		}
		return seElimino;
	}
	
	public Integer ObtenerCantidadDePlazas() {
		return this.plazas.size();
	}
	
	public Integer ObtenerCantidadDeLugaresTotalesHabilitadasParaEstacionar() {
		return this.AsignacionVehiculosplazas.size();
	}
	
	public Boolean darDeBajaUnaPlazaVehiculoDelSistema(VehiculoPlaza plazaADesabilitar) {
		Boolean seElimino=false;
		for (VehiculoPlaza vehiculoPlazaActual : this.AsignacionVehiculosplazas) {
			if(vehiculoPlazaActual.equals(plazaADesabilitar)) {
				this.AsignacionVehiculosplazas.remove(vehiculoPlazaActual);
				return seElimino=true;
			}
		}
		return seElimino;
	}
	
	@Override
	public ArrayList<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistema() {
		ArrayList<VehiculoPlaza> plazaDisponibles = new ArrayList<>();    
		for (VehiculoPlaza vehiculoPlazaEstacionamiento : AsignacionVehiculosplazas) {			
            if(vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getEstaOcupado()==false) {
            	plazaDisponibles.add(vehiculoPlazaEstacionamiento);
            }
        }
        return plazaDisponibles;
    }
	
	@Override
	public ArrayList<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistemaPorTipoDeVehiculo(TipoDeVehiculo tipo) {
		ArrayList<VehiculoPlaza> plazaDisponiblesPorTipo = new ArrayList<>();    
		for (VehiculoPlaza vehiculoPlazaEstacionamiento : AsignacionVehiculosplazas) {			
            if(vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getEstaOcupado()==false && vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getTipo().equals(tipo) && vehiculoPlazaEstacionamiento.getVehiculoEnPlaza()==null) {
            	plazaDisponiblesPorTipo.add(vehiculoPlazaEstacionamiento);
            }
        }
        return plazaDisponiblesPorTipo;
    }
	
	public Boolean asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(Vehiculo vehiculo, Plaza plazaSeleccionada) {
		Boolean seAsigno=false;
		for (VehiculoPlaza vehiculoPlazaEstacionamiento : AsignacionVehiculosplazas) {
			if(vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().equals(plazaSeleccionada)&&vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getEstaOcupado()==false) {
			   if(vehiculoPlazaEstacionamiento.getVehiculoEnPlaza()==null && plazaSeleccionada.getTipo().equals(vehiculo.getTipo())) {
					vehiculoPlazaEstacionamiento.setVehiculoEnPlaza(vehiculo);
					vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().setEstaOcupado(true);
					return seAsigno=true;
			   }	
			}
		}
		return seAsigno;
	}
	
	@Override
	public ArrayList<VehiculoPlaza> MostrarTodasLasPlazasDelEstacionamientoDelSistemaQueEstenOcupadas() {
		ArrayList<VehiculoPlaza> plazaOcupadas = new ArrayList<>();    
		for (VehiculoPlaza vehiculoPlazaEstacionamiento : AsignacionVehiculosplazas) {			
            if(vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getEstaOcupado()==true && vehiculoPlazaEstacionamiento.getVehiculoEnPlaza()!=null) {
            	plazaOcupadas.add(vehiculoPlazaEstacionamiento);
            }
        }
        return plazaOcupadas;
    }

	public Boolean habilitarPlazaUnaVesDesocupada(VehiculoPlaza plazaAHabilitar) {
		Boolean seLibero=false;
		for (VehiculoPlaza vehiculoPlazaEActual : this.AsignacionVehiculosplazas) {
			if(vehiculoPlazaEActual.equals(plazaAHabilitar)) {
				vehiculoPlazaEActual.getPlazaDeVehiculo().setEstaOcupado(false);
				return seLibero=true;
			}
		}
		return seLibero;
	}

	public boolean verificarSiPlazaEstaOcupada(int numero) {
		for (Plaza plaza : plazas) {
			if (plaza != null && plaza.getNroDePlaza() == numero) {
				return plaza.getEstaOcupado();
			}
		}
		return false;
	}

	public Cliente registrarCliente(String nombre, String telefono) {
		Cliente cliente = new Cliente(nombre, telefono);
		return cliente;
	}

	public boolean asignarPlazaACliente(Cliente cliente) {
		for (Plaza plaza : plazas) {
			if (!plaza.getEstaOcupado() && plaza.getTipo().equals(TipoDeVehiculo.AUTO)) {
				reservasPlaza.add(new ReservaPlaza(plaza, cliente));
				plaza.setEstaOcupado(true);
				return true;
			}
		}

		return false;
	}

	public boolean darDeBajaReserva(int numeroDePlaza) {
		for (ReservaPlaza reserva : reservasPlaza) {
			if (reserva.getSaldoTotalAdeudado() == 0.0) {
				reservasPlaza.remove(reserva);
				for (Plaza plaza : plazas) {
					if (plaza.getNroDePlaza() == numeroDePlaza) {
						plaza.setEstaOcupado(false);
					}
					return true;
				}
			} else {
				// ToDo
			}
		}
		return false;
	}

	public ReservaPlaza getReservaPlazaPorNumeroDePlaza(int numeroDePlaza) {
		for (ReservaPlaza reservaPlaza : reservasPlaza) {
			if (reservaPlaza.getPlaza().getNroDePlaza() == numeroDePlaza) {
				return reservaPlaza;
			}
		}

		return null;
	}

	public boolean debitarDeudaMensualPorFecha(LocalDate fecha) {
		if (fecha.getDayOfMonth() == 1) {
			for (ReservaPlaza reserva : reservasPlaza) {
				reserva.debitarDeuda(fecha.getMonthValue());
			}
			return true;
		}
		return false;
	}
	
}
