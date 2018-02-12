package ruszkowski89.springmvc.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ruszkowski89.springmvc.dao.UserDaoImpl;
import ruszkowski89.springmvc.model.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements org.springframework.web.WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext){

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        DispatcherServlet dispatcher = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", dispatcher);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");

    }
}
