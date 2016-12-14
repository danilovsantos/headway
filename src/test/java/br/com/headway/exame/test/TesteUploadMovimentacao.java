package br.com.headway.exame.test;

import br.com.headway.exame.dao.MovimentacaoDao;
import br.com.headway.exame.model.Movimentacao;

public class TesteUploadMovimentacao {

	public static void main(String[] args) {
			
		MovimentacaoDao dao = new MovimentacaoDao();
		Movimentacao mov = dao.getArquivoMovimentacao();
		
		System.out.println(dao.filialMaiorFaturamentoPeriodo(mov));
		System.out.println(dao.filialMenorFaturamentoPeriodo(mov));
		System.out.println(dao.mesMaiorFaturamento(mov));

	}

}
