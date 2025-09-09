package com.poke.pokemon_stats.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="pokemon")
@CrossOrigin
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemon(
            // ? is used to enter param in url
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Boolean legendary) {

        if( number != null ) {
            return pokemonService.getPokemonsByNumber(number);
        }
        else if( name != null ) {
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
