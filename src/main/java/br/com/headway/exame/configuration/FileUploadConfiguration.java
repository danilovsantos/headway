package br.com.headway.exame.configuration;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.headway.exame.controller")
public class FileUploadConfiguration extends WebMvcConfigurerAdapter{

	 @Bean(name="multipartResolver") 
	    public CommonsMultipartResolver getResolver() throws IOException{
	        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	         
	        //Set the maximum allowed size (in bytes) for each individual file.
	        resolver.setMaxUploadSizePerFile(5242880);//5MB
	         
	        //You may also set other available properties.
	         
	        return resolver;
	    }
	 
	    @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        registry.viewResolver(viewResolver);
	    }
	
}
