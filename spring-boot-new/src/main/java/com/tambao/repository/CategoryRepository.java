package com.tambao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tambao.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
