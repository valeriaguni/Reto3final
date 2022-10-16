package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Score;
import com.reto3.reto3.Repositorio.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;

    public List<Score> getScores() {
        return repository.findAll();
    }

    public Score saveScore(Score score){
        return repository.save(score);
    }

}