package com.reto3.Repository;

import com.reto3.Repository.com.reto3.CreacionJuegos.Crud.GameCrudRepository;
import com.reto3.com.reto3.CreacionJuegos.modelo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {

    @Autowired
    private GameCrudRepository gameCrudRepository;

    public List<Game> getAll(){

        return (List<Game>) gameCrudRepository.findAll();
    }

    public Optional<Game> getGame(int id){

        return gameCrudRepository.findById(id);
    }

    public Game save(Game game){
        return gameCrudRepository.save(game);
    }

    public void delete(Game game){

        gameCrudRepository.delete(game);
    }

}