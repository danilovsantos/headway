package br.com.headway.exame.model;

import java.util.ArrayList;
import java.util.List;

public class Filial {
	
	private String nome;
	private List<Periodo> periodos = new ArrayList<Periodo>();
	
	public Filial(){}
	
	public Filial(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	public void addPeriodo(Periodo periodo){
		this.periodos.add(periodo);
	}

	@Override
	public boolean equals(Object obj) {
		
		Filial filial = (Filial)obj;
		
		if(filial.nome.equals(this.nome)){
			return true;
		}
		
		return false;
	}
	



}
