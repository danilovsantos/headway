package br.com.headway.exame.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Movimentacao {

	private List<Filial> filiais =  new ArrayList<Filial>();
	
	public List<Filial> getFiliais() {
		return filiais;
	}

	public void addPeriodo(String mes, String nomeFilial, BigDecimal valor){

		if(this.getFiliais().contains(new Filial(nomeFilial))){

			for(Filial fil : this.getFiliais()){
				if(fil.getNome().equals(nomeFilial)){
					fil.addPeriodo(new Periodo(mes, valor));
				}

			}

		}else{
			Filial filial = new Filial(nomeFilial);
			filial.addPeriodo(new Periodo(mes, valor));
			this.filiais.add(filial);
		}

	}




}
