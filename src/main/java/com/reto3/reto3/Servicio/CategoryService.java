package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Category;
import com.reto3.reto3.Entidad.Category;
import com.reto3.reto3.Entidad.Category;
import com.reto3.reto3.Repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getCategories(){
        return repository.findAll();
    }

    public Category saveCategory(Category category){
        return repository.save(category);
    }

    public Category updateCategory(Category category) {



        if (category.getId() != null) {
            Optional<Category> categoryU = repository.findById(category.getId());



            if (!categoryU.isEmpty()) {



                for (Field f : category.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value;
                    try {
                        value = f.get(category);
                        if (value != null) {
                            System.out.println("entro");
                            f.set(categoryU.get(), value);
                        }
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return repository.save(categoryU.get());
        }
        return category;
    }

    public boolean deleteCategory(int id) {
        Optional<Category> categoryd = repository.findById(id);
        if (categoryd.isEmpty()) {
            return false;
        } else {
            repository.delete(categoryd.get());
            return true;
        }
    }
}
