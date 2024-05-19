package com.keatnis.mod;

public record Pelicula(
        String title,
        int episode,
        String opening_crawl,
        String director,
        String producer,
        String release_date
        ) {

}