package ruszkowski89.springmvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext){

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebMvcConfig.class);

        DispatcherServlet dispatcher = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", dispatcher);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }
}
