package br.com.zrp.API.controller;

import br.com.zrp.API.model.Pokemon;
import br.com.zrp.API.service.PokeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class PokeController {

    @Autowired
    private PokeService service;

    @GetMapping("/pokemon/{name}")
    public ResponseEntity<Pokemon> getPokeByName(@PathVariable("name") String name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Object> opt = Optional.of(service.getPokeByName(name))
                .orElseGet(Optional::empty);
        Optional<Pokemon> pokemonOptional = Optional
                .of(Pokemon.fromJson(mapper.writeValueAsString(opt.get())));

        return pokemonOptional
                .map(pokemon -> ResponseEntity.ok().body(pokemon))
                .orElse(ResponseEntity.notFound().build());
    }

}
