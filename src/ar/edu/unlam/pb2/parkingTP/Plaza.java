package ar.edu.unlam.pb2.parkingTP;

import java.util.Objects;

public class Plaza {
	private Integer nroDePlaza;
	private String seccion;
	private Boolean estaOcupado;
	private TipoDeVehiculo tipo;
	
	public Plaza(Integer nroDePlaza, String seccion, Boolean estaOcupado, TipoDeVehiculo tipo) {
		
		this.nroDePlaza = nroDePlaza;
		this.seccion = seccion;
		this.estaOcupado = estaOcupado;
		this.tipo = tipo;
	}

	public Integer getNroDePlaza() {
		return nroDePlaza;
	}

	public String getSeccion() {
		return seccion;
	}

	public Boolean getEstaOcupado() {
		return estaOcupado;
	}

	public void setEstaOcupado(Boolean estaOcupado) {
		this.estaOcupado = estaOcupado;
	}

	public TipoDeVehiculo getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nroDePlaza, seccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plaza other = (Plaza) obj;
		return Objects.equals(nroDePlaza, other.nroDePlaza) && Objects.equals(seccion, other.seccion);
	}
		
}
