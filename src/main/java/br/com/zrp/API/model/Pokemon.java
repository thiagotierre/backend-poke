package br.com.zrp.API.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pokemon {

    private String name;
    private String sprite;
    private List<String> abilities;
    private List<String> types;

    public static Pokemon fromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.readTree(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonNode rootNode = objectMapper.readTree(json);

        Pokemon pokemon = new Pokemon();
        pokemon.setName(rootNode.path("name").asText());
        pokemon.setSprite(rootNode.path("sprites").path("front_default").asText());

        List<String> abilities = new ArrayList<>();
        rootNode.path("abilities").forEach(abilityNode ->
                abilities.add(abilityNode.path("ability").path("name").asText())
        );
        pokemon.setAbilities(abilities);

        List<String> types = new ArrayList<>();
        rootNode.path("types").forEach(typeNode ->
                types.add(typeNode.path("type").path("name").asText())
        );
        pokemon.setTypes(types);

        return pokemon;
    }
}
