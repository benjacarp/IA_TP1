package com.javainuse.model;

public class Pareja {

	private Emprendedor empA;
	private Emprendedor empB;
	private int afinidad = 0;

	public int getAfinidad() {
		return afinidad;
	}

	public void incrementAfinidad(int afinidad) {
		this.afinidad += afinidad;
	}

	public Emprendedor getEmpA() {
		return empA;
	}

	public void setEmpA(Emprendedor empA) {
		this.empA = empA;
	}

	public Emprendedor getEmpB() {
		return empB;
	}

	public void setEmpB(Emprendedor empB) {
		this.empB = empB;
	}
}