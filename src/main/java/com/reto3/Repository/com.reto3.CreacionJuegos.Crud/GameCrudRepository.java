package com.reto3.Repository.com.reto3.CreacionJuegos.Crud;

import com.reto3.com.reto3.CreacionJuegos.modelo.Game;
import org.springframework.data.repository.CrudRepository;


public interface GameCrudRepository extends CrudRepository<Game, Integer> {
}