package br.com.headway.exame.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.headway.exame.model.FileUpload;

@Component
public class FileValidator implements Validator {
     
    public boolean supports(Class<?> clazz) {
        return FileUpload.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object obj, Errors errors) {
    	FileUpload file = (FileUpload) obj;
         
        if(file.getFile()!=null){
            if (file.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }
    }
}