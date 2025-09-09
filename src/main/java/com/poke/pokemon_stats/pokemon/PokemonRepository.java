package com.poke.pokemon_stats.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    void deleteByNumber(Integer number);
    Optional<Pokemon> findByNumber(Integer number);
}
