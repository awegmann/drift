package de.codeshelf.drift;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
@ImportResource("classpath:development-config.xml")
public class DriftApplication {


  static Log log = LogFactory.getLog(DriftApplication.class.getName());

  public static void main(String[] args) {
    AuthenticationManager authenticationManager;

    ConfigurableApplicationContext applicationContext = SpringApplication.run(DriftApplication.class, args);

    authenticationManager = applicationContext.getBean(AuthenticationManager.class);
    log.info("after init ");

    SecurityContext context = SecurityContextHolder.getContext();
    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken("user1","user2");

    authenticationManager.authenticate(authenticationToken);
  }
}