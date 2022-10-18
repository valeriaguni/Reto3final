package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Score;
import com.reto3.reto3.Entidad.Score;
import com.reto3.reto3.Repositorio.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Score updateScore(Score score) {



        if (score.getIdScore() != null) {
            Optional<Score> scoreU = repository.findById(score.getIdScore());



            if (!scoreU.isEmpty()) {



                for (Field f : score.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value;
                    try {
                        value = f.get(score);
                        if (value != null) {
                            System.out.println("entro");
                            f.set(scoreU.get(), value);
                        }
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return repository.save(scoreU.get());
        }
        return score;
    }

    public boolean deleteScore(int id) {
        Optional<Score> scored = repository.findById(id);
        if (scored.isEmpty()) {
            return false;
        } else {
            repository.delete(scored.get());
            return true;
        }
    }

}