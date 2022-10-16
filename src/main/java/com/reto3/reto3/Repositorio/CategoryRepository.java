package com.reto3.reto3.Repositorio;

import com.reto3.reto3.Entidad.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
