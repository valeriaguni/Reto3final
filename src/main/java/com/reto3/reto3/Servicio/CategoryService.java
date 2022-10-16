package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Category;
import com.reto3.reto3.Repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    public void deleteCategory(long id){
        repository.deleteById(id);
    }


}
