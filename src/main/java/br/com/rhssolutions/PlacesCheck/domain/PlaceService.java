package br.com.rhssolutions.PlacesCheck.domain;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


public class PlaceService {

    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
    public Mono<Place> createPlace(Place place) {
        return placeRepository.save(place);
    }
}
