package com.example.movies.backendResponseDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PeliculasResponseDto {

    private Integer page;
    @JsonProperty("per_page") // Esta anotación es clave
    private Integer perPage;
   
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    private List<MovieDto> data;
}

