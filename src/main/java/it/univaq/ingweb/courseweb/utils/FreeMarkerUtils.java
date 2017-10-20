package it.univaq.ingweb.courseweb.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtils {
	
	private static Configuration cfg;
    
    /**
     * 
     * @param data              dati da inserire nel template          
     * @param path_template     pathname del template da caricare
     * @param response          
     * @param servlet_context
     * @throws IOException
     */
	
	@SuppressWarnings("deprecation")
	public static void initConfiguration() {
		
		cfg = new Configuration();
		
	}
	
    public static void process(String path_template, Map data, HttpServletResponse response, ServletContext servlet_context) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");        
        // Configurazione freemarker
        
        cfg.setDefaultEncoding("UTF-8");
            
        cfg.setServletContextForTemplateLoading(servlet_context, "/template");

        Template template = cfg.getTemplate(path_template);
        
        PrintWriter out = response.getWriter();
        
        try{
            template.process(data, out);
            
        } catch (TemplateException ex) {     
            
        } finally{
            out.flush();
            out.close(); 
        }
        
        

    }

    
    
}