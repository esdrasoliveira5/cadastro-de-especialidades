package app.trybe.specialityapp.config;

import javax.ws.rs.ApplicationPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import app.trybe.specialityapp.SpecialityAppApplication;

/**
 * Configuration.
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

  private Logger logger = LogManager.getLogger(JerseyConfig.class);

  /**
   * Construtor para o JerseyConfig.
   *
   */
  public JerseyConfig() {
    packages(SpecialityAppApplication.class.getPackageName());
    register(new AbstractBinder() {

      @Override
      protected void configure() {
        logger.info("Configurando binder");
      }
    });
  }
}
