package br.com.rhssolutions.PlacesCheck;

import br.com.rhssolutions.PlacesCheck.api.PlaceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlacesCheckApplicationTests {
	@Autowired
	private WebTestClient client;
	@Test
	public void testCreatePlaceSuccess(){
		var name = "Valid name";
		var state = "Valid state";
		var slug = "valid-name";

		client.post().uri("/places").bodyValue(new PlaceRequest(name, state))
				.exchange()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
                .jsonPath("state").isEqualTo(state)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("createdAt").isNotEmpty()
                .jsonPath("updatedAt").isNotEmpty();
	}

	@Test
	public void testCreatePlaceBadRequest(){
		var name = "";
		var state = "";

		client.post()
				.uri("/places")
				.bodyValue(new PlaceRequest(name, state))
                .exchange()
                .expectStatus().isBadRequest();
	}

}
