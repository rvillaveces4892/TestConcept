
package com.uan.workshop;

public class Estructura {
	
	private String tipoEstructura;
	
	
	public Estructura() {}
	
	
	public Estructura(String tipoEstructura) {
		this.tipoEstructura = tipoEstructura;
	}


	public String getTipoEstructura() {
		return tipoEstructura;
	}


	public void setTipoEstructura(String tipoEstructura) {
		this.tipoEstructura = tipoEstructura;
	}


	@Override
	public String toString() {
		return "Estructura [tipoEstructura=" + tipoEstructura + "]";
	}
	

}
