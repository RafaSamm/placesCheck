package br.com.rhssolutions.PlacesCheck.config;


import br.com.rhssolutions.PlacesCheck.domain.PlaceRepository;
import br.com.rhssolutions.PlacesCheck.domain.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {
    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);
    }

}
