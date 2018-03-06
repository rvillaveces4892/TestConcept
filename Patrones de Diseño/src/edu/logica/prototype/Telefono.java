package edu.logica.prototype;

public class Telefono implements Copiable{

	private String tipo;
	private String extension;
	private String numero;
	
	public Telefono() {
		super();
	}

	public Telefono(String tipo, String extension, String numero) {
		super();
		this.tipo = tipo;
		this.extension = extension;
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Telefono [tipo=" + tipo + ", extension=" + extension + ", numero=" + numero + "]";
	}

	@Override
	public Object copiar() {
		try {
			return clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
