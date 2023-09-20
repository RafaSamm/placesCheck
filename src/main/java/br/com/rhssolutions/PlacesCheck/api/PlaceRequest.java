package br.com.rhssolutions.PlacesCheck.api;


import jakarta.validation.constraints.NotBlank;

public record PlaceRequest(
         @NotBlank String name,
         @NotBlank String state){

}



