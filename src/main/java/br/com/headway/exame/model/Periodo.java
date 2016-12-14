package br.com.headway.exame.model;

import java.math.BigDecimal;

public class Periodo {
	
	private String mes;
	private BigDecimal valor;
	
	public Periodo(){}
	
	public Periodo(String mes){
		this.mes = mes;
	}
	
	public Periodo(String mes, BigDecimal valor){
		this.mes = mes;
		this.valor = valor;
	}
	
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Periodo periodo = (Periodo)obj;
		
		if(periodo.mes.equals(this.mes)){
			return true;
		}
		
		return false;
	}
	

}
