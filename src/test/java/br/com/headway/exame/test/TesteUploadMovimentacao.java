package br.com.headway.exame.test;

import br.com.headway.exame.dao.MovimentacaoDao;
import br.com.headway.exame.dao.MovimentacaoDaoImpl;
import br.com.headway.exame.model.Movimentacao;

public class TesteUploadMovimentacao {

	public static void main(String[] args) {
			
		MovimentacaoDao dao = new MovimentacaoDaoImpl();
		Movimentacao mov = dao.getArquivoMovimentacao();
		
		System.out.println(dao.filialMaiorFaturamentoPeriodo(mov).getNome());
		System.out.println(dao.filialMenorFaturamentoPeriodo(mov).getNome());
		System.out.println(dao.mesMaiorFaturamento(mov));

	}

}
