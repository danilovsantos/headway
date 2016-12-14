package br.com.headway.exame.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import br.com.headway.exame.model.Filial;
import br.com.headway.exame.model.Movimentacao;
import br.com.headway.exame.model.Periodo;



/**
 * Classe de acesso á fonte de dados de movimentações.
 * @author Danilo Valente
 *
 */
public class MovimentacaoDao {


	/**
	 * Obtem arquivo local para testes unitários.
	 * @return
	 */

	public Movimentacao getArquivoMovimentacao() {

		try {

			Stream<String> stream = Files.lines(Paths.get("src/main/resources/movimentacoes.txt"), Charset.forName("Cp1252"));
			return this.parseToMovimentacaoBean(stream);

		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo em src/main/resources/movimentacoes.txt");
		}

		return new Movimentacao();
	}


	
	
	/**
	 * Realiza parse para objeto Movimentacao
	 * @param stream
	 * @return
	 */
	public Movimentacao parseToMovimentacaoBean(Stream<String> stream){

		Iterator<String> itr = stream.iterator();

		Movimentacao movimentacao = new Movimentacao();

		itr.next();

		while(itr.hasNext()){

			String line = itr.next();

			if(line.trim().length() > 0){

				String[] columns = line.split("	");

				String filial = columns[0];
				String mes    = columns[1];
				String valor  = columns[2].trim().replace(".", "").replace(",", ".");

				movimentacao.addPeriodo(mes, filial, new BigDecimal(valor).setScale(2));

			}

		}

		return movimentacao;

	}


	
	
	/**
	 * Realiza parse para objeto Movimentacao
	 * @param stream
	 * @return
	 */
	public Movimentacao parseToMovimentacaoBean(InputStream stream){

		try {

			BufferedReader br = new BufferedReader( new InputStreamReader(stream));

			Movimentacao movimentacao = new Movimentacao();

			br.readLine();

			String line;

			while( (line = br.readLine()) != null ){ 

				String[] columns = line.split("	");

				String filial = columns[0];
				String mes    = columns[1];
				String valor  = columns[2].trim().replace(".", "").replace(",", ".");

				movimentacao.addPeriodo(mes, filial, new BigDecimal(valor).setScale(2));

			}

			return movimentacao;

		} catch (IOException e) {
			e.printStackTrace();
		} 

		return new Movimentacao();

	}


	
	/**
	 * Obtem filial com maior faturamento no período.
	 * @param movimentacao
	 * @return
	 */
	public Filial filialMaiorFaturamentoPeriodo(Movimentacao movimentacao){

		Filial filial = new Filial();
		double faturamento = 0;

		for(Filial fil : movimentacao.getFiliais()){

			double fatfil = 0;

			for(Periodo p : fil.getPeriodos()){
				fatfil += p.getValor().doubleValue();
			}

			if(fatfil > faturamento){
				faturamento = fatfil;
				filial = fil;
			}

		}

		return filial;

	}


	
	
	/**
	 * Obtem filial com menor faturamento no período.
	 * @param movimentacao
	 * @return
	 */
	public Filial filialMenorFaturamentoPeriodo(Movimentacao movimentacao){

		Filial filial = new Filial();
		double faturamento = 0;

		for(Filial fil : movimentacao.getFiliais()){

			double fatfil = 0;

			for(Periodo p : fil.getPeriodos()){
				fatfil += p.getValor().doubleValue();
			}

			if(faturamento == 0){
				faturamento += fatfil;
			}
			
			if(fatfil < faturamento){
				faturamento = fatfil;
				filial = fil;
			}

		}

		return filial;

	}


	
	
	
	/**
	 * Obtem mês de maior faturamento no período.
	 * @param movimentacao
	 * @return
	 */
	
	public String mesMaiorFaturamento(Movimentacao movimentacao){

		Map<String, Periodo> meses = new HashMap<String, Periodo>();
		String mes = null;
		double faturamento = 0.0;

		for(Filial filial : movimentacao.getFiliais()){

			for(Periodo p : filial.getPeriodos()){

				if(meses.containsKey(p.getMes())){
					Periodo per = meses.get(p.getMes());
					per.setValor(per.getValor().add(p.getValor()));
					meses.put(per.getMes(), per);
				}else{
					meses.put(p.getMes(), p);
				}
			}

		}

		for(Periodo pe : meses.values()){
			if(faturamento < pe.getValor().doubleValue()){
				faturamento = pe.getValor().doubleValue();
				mes = pe.getMes();
			}
		}

		return mes;

	}



}
