package com.reto3.reto3.Controlador;

import com.reto3.reto3.Entidad.Score;
import com.reto3.reto3.Entidad.Score;
import com.reto3.reto3.Servicio.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score/")
@CrossOrigin(origins = "*")

public class ScoreController {

    @Autowired
    private ScoreService service;

    @GetMapping("/all")
    public List<Score> getScores(){
        return service.getScores();
    }

    @PostMapping("/save")
    public ResponseEntity saveScore (@RequestBody Score score){
        service.saveScore(score);
        return ResponseEntity.status(201).build();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteScore(@PathVariable int id){
        return service.deleteScore(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score updateScore(@RequestBody Score Score){
        return service.updateScore(Score);
    }
}
