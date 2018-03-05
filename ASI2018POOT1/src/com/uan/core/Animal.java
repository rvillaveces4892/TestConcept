package com.uan.core;

import com.uan.workshop.IAnimal;

public abstract class Animal implements IAnimal {

	private int edad;
	private String nombre;
	
	
	public Animal() {}
	
	public Animal(int edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
	}
	
	
	public abstract void tipoAnimal();

	@Override
	public String toString() {
		return "Animal [edad=" + edad + ", nombre=" + nombre + "]";
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
