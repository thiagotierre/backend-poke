package br.com.zrp.API.service;

import br.com.zrp.API.http.FeignClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokeService {

    @Autowired
    private FeignClientInterface feignClientInterface;

    public Optional<Object> getPokeByName(String name) {
        try {
            Optional<Object> opt = Optional.of(feignClientInterface.getPokeByName(name));
            return Optional.ofNullable(Optional.of(opt.get()).orElseThrow(() -> new RuntimeException("Pokemon not found")));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
}
