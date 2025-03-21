package br.com.zrp.API.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "pokemon", url = "https://pokeapi.co/api/v2/")
public interface FeignClientInterface {

    @GetMapping("/pokemon/{name}")
    Object getPokeByName(@PathVariable("name") String name);
}
