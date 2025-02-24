package com.example.movies.backendResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto {

    @JsonProperty("Title")  // Mapea "Title" del JSON a "title" en la clase
    private String title;

    @JsonProperty("Year")   // Mapea "Year" del JSON a "year" en la clase
    private String year;

    @JsonProperty("Rated")  // Mapea "Rated" del JSON a "rated" en la clase
    private String rated;

    @JsonProperty("Released")  // Mapea "Released" del JSON a "released" en la clase
    private String released;

    @JsonProperty("Runtime")  // Mapea "Runtime" del JSON a "runtime" en la clase
    private String runtime;

    @JsonProperty("Genre")  // Mapea "Genre" del JSON a "genre" en la clase
    private String genre;

    @JsonProperty("Director")  // Mapea "Director" del JSON a "director" en la clase
    private String director;

    @JsonProperty("Writer")  // Mapea "Writer" del JSON a "writer" en la clase
    private String writer;

    @JsonProperty("Actors")  // Mapea "Actors" del JSON a "actors" en la clase
    private String actors;
}


