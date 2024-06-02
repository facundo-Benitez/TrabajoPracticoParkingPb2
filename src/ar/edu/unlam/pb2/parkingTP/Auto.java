package ar.edu.unlam.pb2.parkingTP;

public class Auto extends Vehiculo {
	Double precioAutoHora = 1000.00;

	public Auto(Cliente cliente, String marca, String color, String patente, Double basePrecio) {
		super(marca, color, patente, basePrecio, cliente);
		
	}

	@Override
	public Double obtenerPrecioPorHora(Double basePrecio) {
	
		return basePrecio + precioAutoHora;
	}


}
