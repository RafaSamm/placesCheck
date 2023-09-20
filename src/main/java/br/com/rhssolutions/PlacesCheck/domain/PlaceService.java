package br.com.rhssolutions.PlacesCheck.domain;

import br.com.rhssolutions.PlacesCheck.api.PlaceRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


public class PlaceService {

    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Mono<Place> createPlace(PlaceRequest placerequest) {
        var place = new Place(null, placerequest.name(),
                placerequest.slug(), placerequest.state(), placerequest.createdAt(), placerequest.updatedAt());
        return placeRepository.save(place);
    }
}
