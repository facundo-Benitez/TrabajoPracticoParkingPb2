package ar.edu.unlam.pb2.parkingTP;

public class Bici extends Vehiculo {
	Double precioBiciHora = 100.00;

	public Bici( Cliente cliente, String marca, String color, String patente, Double basePrecio) {
		super(marca, color, patente, basePrecio, cliente);
		
	}

	@Override
	public Double obtenerPrecioPorHora(Double basePrecio) {
	
		return basePrecio + precioBiciHora;
	}
}