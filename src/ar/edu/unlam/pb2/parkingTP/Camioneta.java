package ar.edu.unlam.pb2.parkingTP;

public class Camioneta extends Vehiculo {

	Double precioCamionetaHora= 1500.00;
	
	public Camioneta(Cliente cliente, String marca, String color, String patente, Double basePrecio) {
		super(marca, color, patente, basePrecio, cliente);
		
	}
	
	@Override
	public Double obtenerPrecioPorHora(Double basePrecio) {
		
		return basePrecio + precioCamionetaHora;
	}

}
