package br.com.headway.exame.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.headway.exame.dao.MovimentacaoDao;
import br.com.headway.exame.model.FileUpload;
import br.com.headway.exame.model.Filial;
import br.com.headway.exame.model.Movimentacao;

@Controller
public class FileUploadController {
    
	
    @RequestMapping(value={"/upload"}, method = RequestMethod.GET)
    public String getHomePage(ModelMap model) {
    	model.addAttribute("uploadFile", new FileUpload());
        return "fileUpload";
    }
	
    @RequestMapping(value="/uploadFile", method = RequestMethod.POST)
    public String singleFileUpload(FileUpload uploadFile, ModelMap model) throws IOException {
     
        MovimentacaoDao dao = new MovimentacaoDao();
    	Movimentacao movimentacao = dao.parseToMovimentacaoBean(uploadFile.getFile().getInputStream());
    	
    	Filial f1 = dao.filialMaiorFaturamentoPeriodo(movimentacao);
    	Filial f2 = dao.filialMenorFaturamentoPeriodo(movimentacao);
    	String mes = dao.mesMaiorFaturamento(movimentacao);
    	
        model.addAttribute("uploadFile", uploadFile);
        model.addAttribute("filialMaiorFat", f1);
        model.addAttribute("filialMenorFat", f2);
        model.addAttribute("mes", mes);
        
        return "fileUpload";
        
    }
    
}
