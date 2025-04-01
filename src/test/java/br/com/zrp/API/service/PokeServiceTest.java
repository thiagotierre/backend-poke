package br.com.zrp.API.service;

import br.com.zrp.API.controller.PokeController;
import br.com.zrp.API.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PokeServiceTest {

    @InjectMocks
    private PokeController pokeController;

    @Mock
    private PokeService pokeService;

//    @Test
//    void getPokeByName_ExistingPokemon_ReturnsOkAndPokemon() throws IOException {
//        // Arrange
//        String pokemonName = "Pikachu";
//        Pokemon mockPokemon = new Pokemon();
//        mockPokemon.setName(pokemonName);
//        // Simulate the behavior of the PokeService
//        when(pokeService.getPokeByName(pokemonName)).thenReturn(Optional.of(mockPokemon));
//
//        // Act
//        ResponseEntity<Pokemon> responseEntity = pokeController.getPokeByName(pokemonName);
//
//        // Assert
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//        assertEquals(pokemonName, responseEntity.getBody().getName());
//    }

//    @Test
//    void getPokeByName_NonExistingPokemon_ReturnsNotFound() throws IOException {
//        // Arrange
//        String pokemonName = "NonExistentPokemon";
//        // Simulate the behavior of the PokeService to return null or throw an exception
//        when(pokeService.getPokeByName(pokemonName)).thenReturn(null);
//
//        // Act
//        ResponseEntity<Pokemon> responseEntity = pokeController.getPokeByName(pokemonName);
//
//        // Assert
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertNull(responseEntity.getBody());
//    }
//
//    @Test
//    void getPokeByName_ServiceThrowsIOException_ReturnsNotFound() throws IOException {
//        // Arrange
//        String pokemonName = "ErrorPokemon";
//        // Simulate the PokeService throwing an IOException
//        when(pokeService.getPokeByName(pokemonName)).thenThrow(new IOException("Simulated IO Exception"));
//
//        // Act
//        ResponseEntity<Pokemon> responseEntity = pokeController.getPokeByName(pokemonName);
//
//        // Assert
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertNull(responseEntity.getBody());
//    }
}