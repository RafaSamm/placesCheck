package br.com.rhssolutions.PlacesCheck.domain;

import br.com.rhssolutions.PlacesCheck.api.PlaceRequest;
import com.github.slugify.Slugify;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


public class PlaceService {

    private PlaceRepository placeRepository;
    private Slugify slugify;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slugify = Slugify.builder().build();
    }

    public Mono<Place> createPlace(PlaceRequest placerequest) {
        var place = new Place(null, placerequest.name(),
                slugify.slugify(placerequest.name()), placerequest.state(), null, null);
        return placeRepository.save(place);
    }
}
