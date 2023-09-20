package br.com.rhssolutions.PlacesCheck.web;

import br.com.rhssolutions.PlacesCheck.api.PlaceResponse;
import br.com.rhssolutions.PlacesCheck.domain.Place;

public class PlaceMapper {

    public static PlaceResponse toResponse(Place place) {
        return new PlaceResponse( place.name(), place.slug(), place.state(),
                place.createdAt(), place.updatedAt());
    }
}
