package com.example.movies.backendController;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.backendResponseDto.PeliculaResponseDto;
import com.example.movies.backendResponseDto.PeliculasResponseDto;
import com.example.movies.backendService.IPeliculaService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/movies")
@Slf4j
public class PeliculasController {

    @Autowired
    private  IPeliculaService peliculaService;


       @Operation(summary = "Obtener lista de directores")
        @GetMapping("/directores")
        public List<String> getDirectores() {
        return peliculaService.getDirectores();
    }

}
