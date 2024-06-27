package com.example.controller;

import com.example.dto.MovieCinemaDTO;
import com.example.service.GenreService;
import com.example.service.MovieCinemaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Consume_WebClient {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    private final MovieCinemaService movieCinemaService;
    private final GenreService genreService;

    public Consume_WebClient(MovieCinemaService movieCinemaService, GenreService genreService) {
        this.movieCinemaService = movieCinemaService;
        this.genreService = genreService;
    }

    @GetMapping("/flux-movie-cinemas")  //localhost:8080/flux-movie-cinemas
    public Flux<MovieCinemaDTO> readAllCinemaFlux(){

        return Flux.fromIterable(movieCinemaService.findAll());

    }

}
