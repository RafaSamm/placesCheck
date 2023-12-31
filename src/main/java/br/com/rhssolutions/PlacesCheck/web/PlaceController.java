package br.com.rhssolutions.PlacesCheck.web;

import br.com.rhssolutions.PlacesCheck.api.PlaceRequest;
import br.com.rhssolutions.PlacesCheck.api.PlaceResponse;
import br.com.rhssolutions.PlacesCheck.domain.Place;
import br.com.rhssolutions.PlacesCheck.domain.PlaceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> createPlace(@Valid @RequestBody PlaceRequest request) {
        var response = placeService.createPlace(request).map(PlaceMapper::toResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
