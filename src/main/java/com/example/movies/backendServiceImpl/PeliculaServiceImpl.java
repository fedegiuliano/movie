package com.example.movies.backendServiceImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.movies.backendResponseDto.PeliculasResponseDto;
import com.example.movies.backendResponseDto.DirectoresResponseDto;
import com.example.movies.backendResponseDto.MovieDto;
import com.example.movies.backendResponseDto.PeliculaResponseDto;
import com.example.movies.backendResponseDto.PeliculasResponseDto;
import com.example.movies.backendService.IPeliculaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpMethod;


import lombok.extern.slf4j.Slf4j;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;




@Service
@Slf4j
public class PeliculaServiceImpl implements IPeliculaService {

    @Value("${api.url1}")
    private String url1;

    @Value("${api.url2}")
    private String url2;

    @Value("${api.url3}")
    private String url3;
    


    private  List<String> urls;

   

      public List<String> getDirectores() {
        Map<String, Long> conteoDirectores = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        this.urls = Arrays.asList(url1, url2, url3);
       
                for (String urlStr : urls) {
            String jsonResponse = fetchJsonFromUrl(urlStr);
            if (jsonResponse != null) {
                try {
                    PeliculasResponseDto response = objectMapper.readValue(jsonResponse, PeliculasResponseDto.class);
                    List<MovieDto> movies = response.getData();
                    
                    for (MovieDto movie : movies) {
                        
                      //   directores.add(movie.getDirector());
                       conteoDirectores.put(movie.getDirector(), conteoDirectores.getOrDefault(movie.getDirector(), 0L) + 1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return conteoDirectores.entrySet().stream()
        .filter(entry -> entry.getValue() > 4) // Filtrar directores con más de 4 películas
        .sorted(Map.Entry.comparingByKey()) 
        .map(Map.Entry::getKey) // Obtener solo el nombre del director
        .collect(Collectors.toList()); 
    }

    private String fetchJsonFromUrl(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Error HTTP: " + conn.getResponseCode());
            }

            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder json = new StringBuilder();
            while (scanner.hasNext()) {
                json.append(scanner.nextLine());
            }
            scanner.close();
            return json.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
