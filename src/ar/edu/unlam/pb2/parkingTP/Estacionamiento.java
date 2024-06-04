package ar.edu.unlam.pb2.parkingTP;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estacionamiento implements IEstacionamiento{
	private String nombreEstacionamiento;
	private ArrayList <Cliente> clientes;
	private ArrayList <Vehiculo> vehiculos;
	private HashSet <Plaza>plazas;
	private HashSet <VehiculoPlaza>AsignacionVehiculosplazas;
    private List<Tickets> tickets;
    private Set<HistorialDelEstacionamiento> historiales;
	private List<ReservaPlaza> reservasPlaza;
	private List<ComprobanteDePago> comprobantes;

	public Estacionamiento(String nombreEstacionamiento) {
		this.nombreEstacionamiento = nombreEstacionamiento;
		this.vehiculos = new ArrayList<>();		
		this.plazas= new HashSet<>();
		this.AsignacionVehiculosplazas= new HashSet<>();
		this.tickets=new ArrayList<>();
        this.historiales=new HashSet<>();
		this.reservasPlaza = new ArrayList<>();
		this.clientes= new ArrayList<>();
		this.comprobantes= new ArrayList<>();

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
	
    public void agregarTicket(Tickets ticket) {
        tickets.add(ticket);
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
	public HashSet<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistema() {
		HashSet<VehiculoPlaza> plazaDisponibles = new HashSet<>();    
		for (VehiculoPlaza vehiculoPlazaEstacionamiento : AsignacionVehiculosplazas) {			
            if(vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getEstaOcupado()==false) {
            	plazaDisponibles.add(vehiculoPlazaEstacionamiento);
            }
        }
        return plazaDisponibles;
    }
	
	@Override
	public HashSet<VehiculoPlaza> MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistemaPorUnTipoDeVehiculo(TipoDeVehiculo tipo) {
		HashSet<VehiculoPlaza> plazaDisponiblesPorTipo = new HashSet<>();    
		for (VehiculoPlaza vehiculoPlazaEstacionamiento : AsignacionVehiculosplazas) {			
            if(vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getEstaOcupado()==false && vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getTipo().equals(tipo) && vehiculoPlazaEstacionamiento.getVehiculoEnPlaza()==null) {
            	plazaDisponiblesPorTipo.add(vehiculoPlazaEstacionamiento);
            }
        }
        return plazaDisponiblesPorTipo;
    }
	
	@Override
	public Boolean asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(Vehiculo vehiculo, Plaza plazaSeleccionada) {
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
	public HashSet<VehiculoPlaza> MostrarTodasLasPlazasDelEstacionamientoDelSistemaQueEstenOcupadas() {
		HashSet<VehiculoPlaza> plazaOcupadas = new HashSet<>();    
		for (VehiculoPlaza vehiculoPlazaEstacionamiento : AsignacionVehiculosplazas) {			
            if(vehiculoPlazaEstacionamiento.getPlazaDeVehiculo().getEstaOcupado()==true && vehiculoPlazaEstacionamiento.getVehiculoEnPlaza()!=null) {
            	plazaOcupadas.add(vehiculoPlazaEstacionamiento);
            }
        }
        return plazaOcupadas;
    }

	@Override
	public Boolean habilitarPlazaUnaVesDesocupada(VehiculoPlaza plazaAHabilitar) {
		Boolean seLibero=false;
		for (VehiculoPlaza vehiculoPlazaActual : this.AsignacionVehiculosplazas) {
			if(vehiculoPlazaActual.equals(plazaAHabilitar)&& vehiculoPlazaActual.getVehiculoEnPlaza().getTickets().getFechaHoraSalida()!=null) {
				vehiculoPlazaActual.getPlazaDeVehiculo().setEstaOcupado(false);
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
		this.clientes.add(cliente);
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
		ReservaPlaza reservaPlazaARemover = null;

		for (ReservaPlaza reserva : reservasPlaza) {
			if (reserva.getPlaza().getNroDePlaza() == numeroDePlaza && reserva.getSaldoTotalAdeudado() == 0.0) {
				reservaPlazaARemover = reserva;
			}
		}

		if (reservaPlazaARemover != null) {
			reservasPlaza.remove(reservaPlazaARemover);
			for (Plaza plaza : plazas) {
				if (plaza.getNroDePlaza() == numeroDePlaza) {
					plaza.setEstaOcupado(false);
					return true;
				}
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
	
	public HistorialDelEstacionamiento generarHistorial(Integer idHistorial,Tickets ticketClient,VehiculoPlaza plazaDeEstacionamiento,Vehiculo auto,
			Cliente cliente) {
		HistorialDelEstacionamiento nuevoHistorial=new HistorialDelEstacionamiento(idHistorial,ticketClient,plazaDeEstacionamiento,auto,cliente);
		historiales.add(nuevoHistorial);
		return nuevoHistorial;
    }
	
	//aca calculo la ganancia por un rango entre fecha y hora
    public Double obtenerGananciaDelEstacionamiento(LocalDateTime fechaHoraInicio,LocalDateTime fechaHoraFin) {
		Double montoFinal = 0.0;
		
		for(HistorialDelEstacionamiento HistorialActual : historiales) {
			LocalDateTime Entrada=HistorialActual.getVehiculoEstacionado().getTickets().getFechaHoraEntrada();
			LocalDateTime Salida=HistorialActual.getVehiculoEstacionado().getTickets().getFechaHoraSalida();
			if ((Entrada.isAfter(fechaHoraInicio) || Entrada.isEqual(fechaHoraInicio))&&(Salida.isBefore(fechaHoraFin) || Salida.isEqual(fechaHoraFin))) {
				montoFinal +=HistorialActual.getVehiculoEstacionado().calcularCosto();
			}	
		}
		return montoFinal;
    }
    
	public Tickets generarTickets(Integer id, LocalDateTime fechaHoraEntrada, Integer nroDePlaza) {
		Tickets nuevoTicket=new Tickets(id, fechaHoraEntrada, nroDePlaza);
		this.tickets.add(nuevoTicket);
		return nuevoTicket;
	}
	
	public Vehiculo buscarVehiculoPorPatente(String patente) throws VehiculoNoEncontradoException {
		Vehiculo vehiculoEncontrado=null;
		for (Vehiculo vehiculo : vehiculos) {
			if(vehiculo.getPatente().equalsIgnoreCase(patente)) {
				vehiculoEncontrado=vehiculo;
				return vehiculoEncontrado;
			}
		}
		throw new VehiculoNoEncontradoException("El vehiculo no fue encontrado intente nuevamente con la patente");
	}
	
	public Boolean asignarUnTicketAUnVehiculo(String patente, Tickets ticketCliente) throws VehiculoNoEncontradoException {
		Boolean seAsigno=false;
		Vehiculo vehiculoEncontrado=this.buscarVehiculoPorPatente(patente);
		if(vehiculoEncontrado.getTickets()==null) {
			vehiculoEncontrado.setTickets(ticketCliente);
			return seAsigno=true;
		}
		return seAsigno;
	}
	
	public Vehiculo buscarUnVehiculoPorElNroDePlaza(Integer nroDePlaza) throws PlazaNoEncontradaException {
		Vehiculo encontrado=null;
		for (VehiculoPlaza vehiculoPlaza : AsignacionVehiculosplazas) {
			 if(vehiculoPlaza.getPlazaDeVehiculo().getNroDePlaza().equals(nroDePlaza)) {
				 encontrado=vehiculoPlaza.getVehiculoEnPlaza();
				 return  encontrado;
			}
		}
		throw new PlazaNoEncontradaException("La plaza no fue encontrada intente nuevamente");
	} 
	
	public Plaza buscarUnVehiculoPorPatenteParaVerSuUbicacion(String patente) throws VehiculoNoEncontradoException {
		Plaza encontrada=null;
		for (VehiculoPlaza vehiculoPlaza : AsignacionVehiculosplazas) {
			 if(vehiculoPlaza.getVehiculoEnPlaza().getPatente().equals(patente)) {
				 encontrada=vehiculoPlaza.getPlazaDeVehiculo();
				 return  encontrada;
			}
		}
		throw new VehiculoNoEncontradoException("El vehiculo no fue encontrado intente nuevamente con la patente");
	}

	public Integer cantidadDeHistorialesAgregados() {
		return this.historiales.size();
	}
	
	public Boolean guardarComprobante(ComprobanteDePago nuevo) {
		return this.comprobantes.add(nuevo);
	}
	
}
