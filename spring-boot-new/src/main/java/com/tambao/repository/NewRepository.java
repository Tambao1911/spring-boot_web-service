package com.tambao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tambao.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{
	
}
