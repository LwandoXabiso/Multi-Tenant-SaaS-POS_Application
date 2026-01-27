package com.lwando.pos.system.repository;

import com.lwando.pos.system.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByStoreId(long storeId);
}
