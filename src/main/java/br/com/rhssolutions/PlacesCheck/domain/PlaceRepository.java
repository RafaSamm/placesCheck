package br.com.rhssolutions.PlacesCheck.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {
}
