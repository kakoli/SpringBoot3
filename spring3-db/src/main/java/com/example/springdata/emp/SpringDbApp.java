package com.example.springdata.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan(basePackages = "com.example.*")
/* SpringBootServletInitializer implements the WebApplicationInitializer interface, which is new in Servlet 3.0+
 Implementation of this interface will automatically configure the ServletContext and communicate with the
 Servlet Container. Can run in standalone Tomcat.
 */
public class SpringDbApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringDbApp.class, args);
        System.out.println("Started Springboot3 Server");
    }
}
