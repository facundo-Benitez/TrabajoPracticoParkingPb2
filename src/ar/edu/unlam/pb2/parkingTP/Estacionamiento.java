package ar.edu.unlam.pb2.parkingTP;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estacionamiento implements IEstacionamiento {
    private String nombreEstacionamiento;
    private Set<Tickets> tickets;
    private List<HistorialDelEstacionamiento> historiales;

    public Estacionamiento() {
        this.tickets = new HashSet<>();
    }

    public Estacionamiento(String nombreEstacionamiento) {
        this.nombreEstacionamiento = nombreEstacionamiento;
        this.tickets = new HashSet<>();
        this.historiales=new ArrayList<>();
    }

    public void agregarTicket(Tickets ticket) {
        tickets.add(ticket);
    }

    public double getGananciaTotal() {
        double total = 0.0;
        for (Tickets ticket : tickets) {
            total += ticket.getCosto();
        }
        return total;
    }

    public String getNombreEstacionamiento() {
        return nombreEstacionamiento;
    }
    
    public List<Vehiculo> obtenerVehiculosEstacionadosOrdenados() {
        List<Ticket> listaTickets = new ArrayList<>(tickets);
        listaTickets.sort(Comparator.comparingInt(Ticket::getNroPlaza));
        
        List<Vehiculo> vehiculosOrdenados = new ArrayList<>();
        for (Ticket ticket : listaTickets) {
            vehiculosOrdenados.add(ticket.getVehiculo());
        }
        
        return vehiculosOrdenados;
    }

	   public Set<Tickets> getTickets() {
        return tickets;
    }

	   public String obtenerDatosVehiculoPorNumeroPlaza(int numeroPlaza) {
		    for (Ticket ticket : tickets) {
		        if (ticket.getNroPlaza() == numeroPlaza) {
		            Vehiculo vehiculo = ticket.getVehiculo();
		            String tipoVehiculo = vehiculo.getClass().getSimpleName();
		            return tipoVehiculo + ", Plaza: " + numeroPlaza;
		        }
		    }
		    return "Vehículo no encontrado en la plaza: " + numeroPlaza;
		}

	  public Auto buscarAutoPorPatente(String patente) {
        for (Ticket ticket : tickets) {
            Vehiculo vehiculo = ticket.getVehiculo();
            if (vehiculo instanceof Auto) {
                Auto auto = (Auto) vehiculo;
                if (auto.getPatente().equals(patente)) {
                    return auto;
                }
            }
        }
        return null;
    }

	public HistorialDelEstacionamiento generarHistorial(Integer idHistorial,Tickets ticketClient,VehiculoPlaza plazaDeEstacionamiento,Vehiculo auto,
				Cliente cliente) {
			HistorialDelEstacionamiento nuevoHistorial=new HistorialDelEstacionamiento(idHistorial,ticketClient,plazaDeEstacionamiento,auto,cliente);
			historiales.add(nuevoHistorial);
			return nuevoHistorial;
	}
	
}
