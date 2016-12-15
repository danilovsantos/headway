package br.com.headway.exame.dao;

import java.io.InputStream;
import java.util.stream.Stream;

import br.com.headway.exame.model.Filial;
import br.com.headway.exame.model.Movimentacao;

public interface MovimentacaoDao {
	
	
	
	/**
	 * Obtem arquivo local para testes unitários.
	 * @return
	 */

	public Movimentacao getArquivoMovimentacao();

	
	/**
	 * Realiza parse para objeto Movimentacao
	 * @param stream
	 * @return
	 */
	public Movimentacao parseToMovimentacaoBean(Stream<String> stream);
	
	
	/**
	 * Realiza parse para objeto Movimentacao
	 * @param stream
	 * @return
	 */
	public Movimentacao parseToMovimentacaoBean(InputStream stream);

	
	/**
	 * Obtem filial com maior faturamento no período.
	 * @param movimentacao
	 * @return
	 */
	public Filial filialMaiorFaturamentoPeriodo(Movimentacao movimentacao);
	
	
	/**
	 * Obtem filial com menor faturamento no período.
	 * @param movimentacao
	 * @return
	 */
	public Filial filialMenorFaturamentoPeriodo(Movimentacao movimentacao);
	
	
	
	/**
	 * Obtem mês de maior faturamento no período.
	 * @param movimentacao
	 * @return
	 */
	
	public String mesMaiorFaturamento(Movimentacao movimentacao);

}
