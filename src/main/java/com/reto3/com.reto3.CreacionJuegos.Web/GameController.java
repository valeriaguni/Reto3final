package com.reto3.com.reto3.CreacionJuegos.Web;

import com.reto3.com.reto3.CreacionJuegos.Service.GameService;
import com.reto3.com.reto3.CreacionJuegos.modelo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Game")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/all")
    public List<Game> getGame(){
        return gameService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Game> getGame(@PathVariable("id") int id){
        return gameService.getGame(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game game){
        return gameService.save(game);
    }
    @PutMapping("/update")
    public Game update(@RequestBody Game game){
        return gameService.update(game);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return gameService.delete(id);
    }
}