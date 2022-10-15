package com.reto3.com.reto3.CreacionJuegos.Service;

import com.reto3.Repository.GameRepository;
import com.reto3.com.reto3.CreacionJuegos.modelo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll(){
        return gameRepository.getAll();
    }
    public Optional<Game>getGame(int id){
        return gameRepository.getGame(id);
    }
    public Game save(Game game){
        if(game.getId() == null){
            return gameRepository.save(game);
        }else{
            Optional<Game> aux = gameRepository.getGame(game.getId());
            if (aux.isPresent()){
                return game;
            }else{
                return gameRepository.save(game);
            }
        }
    }
    public Game update(Game game){
        if (game.getId() != null){
            Optional<Game> c = gameRepository.getGame(game.getId());
            if(c.isPresent()){
                if (game.getName() != null){
                    c.get().setName(game.getName());
                }
                if(game.getDeveloper() != null){
                    c.get().setDeveloper(game.getDeveloper());
                }
                if(game.getYear() != null){
                    c.get().setYear(game.getYear());
                }
                if(game.getDescription() != null){
                    c.get().setDescription(game.getDescription());
                }
                if(game.getCategory() != null){
                    c.get().setCategory(game.getCategory());
                }
                if(game.getMessages() != null){
                    c.get().setMessages(game.getMessages());
                }
                if(game.getReservations() != null){
                    c.get().setReservations(game.getReservations());
                }
                gameRepository.save(c.get());
                return c.get();
            }else{
                return game;
            }
        }else{
            return game;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Game> c = gameRepository.getGame(id);
        if (c.isPresent()){
            gameRepository.delete(c.get());
        }
        return flag;
    }
}