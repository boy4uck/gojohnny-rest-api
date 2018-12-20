package co.gojohnny.config;

import co.gojohnny.model.Place;
import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class WebConfig extends RepositoryRestConfigurerAdapter {

    /**
     * This bean will be used by {@link com.fasterxml.jackson.databind.ObjectMapper}
     * to convert {@link com.vividsolutions.jts.geom.Geometry} into GeoJson and vice versa
     *
     * @return JtsModule instance
     */
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Place.class);
    }
}
