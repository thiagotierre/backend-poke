package br.com.zrp.API.controller;

import br.com.zrp.API.model.Pokemon;
import br.com.zrp.API.service.PokeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class PokeController {

    @Autowired
    private PokeService service;

    @GetMapping("/pokemon/{name}")
    public ResponseEntity<Pokemon> getPokeByName(@PathVariable("name") String name) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Pokemon> pokemonOptional = Optional.empty();

        try{
            pokemonOptional = Optional.of(Optional
                    .of(Pokemon.fromJson(mapper
                            .writeValueAsString(service.getPokeByName(name))))
                    .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND)));

        } catch (HttpClientErrorException e) {
            throw new RuntimeException(HttpStatus.NOT_FOUND.toString());
        } catch (Exception e) {
          throw new RuntimeException(e);
        }

        return pokemonOptional
                .map(pokemon -> ResponseEntity.ok().body(pokemon))
                .orElse(ResponseEntity.notFound().build());
    }

}
