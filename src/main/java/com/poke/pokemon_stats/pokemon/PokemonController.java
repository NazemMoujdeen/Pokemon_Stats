package com.poke.pokemon_stats.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="pokemon")
//allows connections from all, industry standard requires a cors file that has specific permissions
@CrossOrigin(origins = "${FRONTEND_URL:http://localhost:5173}")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemon(
            // ? is used to enter param in url
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Boolean legendary) {


        if( name != null ) {
            return pokemonService.getPokemonsByName(name);

        }
        else if( type != null ) {
            return pokemonService.getPokemonsByType(type);
        }
        else if( legendary != null ) {
            return pokemonService.getIfLegendary(legendary);
        }
        else  {
            return pokemonService.getPokemons();
        }
    }
    @GetMapping("/{pokemonNumber}")
    public ResponseEntity<Pokemon> getPokemonByNumber(@PathVariable Integer pokemonNumber) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonByNumber(pokemonNumber);
        return pokemon.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
     public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon pokemon) {
        Pokemon createdPokemon = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon) {
        Pokemon updatedPokemon = pokemonService.updatePokemon(pokemon);
        if( updatedPokemon != null ) {
            return new ResponseEntity<>(updatedPokemon, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{pokemonNumber}")
    public ResponseEntity<String> deletePokemon(@PathVariable Integer pokemonNumber) {
        pokemonService.deletePokemon(pokemonNumber);
        return new ResponseEntity<>("Pokemon deleted successfully",HttpStatus.OK);
    }

}
