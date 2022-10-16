package com.reto3.reto3.Controlador;

import com.reto3.reto3.Entidad.Category;
import com.reto3.reto3.Servicio.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<Category> getCategories(){
        return service.getCategories();
    }

    @PostMapping("/save")
    public ResponseEntity saveCategory(@RequestBody Category category){
        service.saveCategory(category);
        return ResponseEntity.status(201).build();
    }

    /* @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.updateCategory(category);
        return ResponseEntity.status(201).build();
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id){
        service.deleteCategory(id);
        return ResponseEntity.status(204).build();
    }
}
