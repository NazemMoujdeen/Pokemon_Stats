package com.poke.pokemon_stats.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getPokemons() {
        return pokemonRepository.findAll();

    }
    //filters pokemon by their number
    public Optional<Pokemon> getPokemonByNumber(Integer pokemonNumber) {
        return pokemonRepository.findById(pokemonNumber);
    }
    //filters pokemon by their types
    public List<Pokemon> getPokemonsByType(String type) {
        return pokemonRepository.findAll().stream()
                .filter(pokemon -> type.equalsIgnoreCase(pokemon.getType1())
                        ||(pokemon.getType2() != null && type.equalsIgnoreCase(pokemon.getType2())))
                .collect(Collectors.toList());
    }
    //useful for searchbar
    public List<Pokemon> getPokemonsByName(String searchText){
        return pokemonRepository.findAll().stream()
                .filter(pokemon -> pokemon.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Pokemon> getIfLegendary(Boolean isLegendary) {
        int legendaryValue;
        if (isLegendary) {
            legendaryValue = 1;
        } else {
            legendaryValue = 0;
        }

        return pokemonRepository.findAll().stream()
                .filter(pokemon -> pokemon.getLegendary().equals(legendaryValue))
                .collect(Collectors.toList());
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
    public Pokemon updatePokemon(Pokemon pokemon) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findByNumber(pokemon.getNumber());
        if (pokemonOptional.isPresent()) {
            Pokemon updatedPokemon = pokemonOptional.get();
            updatedPokemon.setName(pokemon.getName());
            pokemonRepository.save(updatedPokemon);
            return updatedPokemon;
        }
        return null;
    }
    @Transient
    public void deletePokemon(Integer number) {
        pokemonRepository.deleteByNumber(number);
    }


}
