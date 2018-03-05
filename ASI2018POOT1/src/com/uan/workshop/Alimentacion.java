package com.uan.workshop;

public class Alimentacion {
	
	private String tipoAlimentacion;
	
	
	public Alimentacion() {}
	
	
	public Alimentacion(String tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}

	
	public String getTipoAlimentacion() {
		return tipoAlimentacion;
	}

	
	public void setTipoAlimentacion(String tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}

	
	@Override
	public String toString() {
		return "Alimentacion [tipoAlimentacion=" + tipoAlimentacion + "]";
	}
	

}
