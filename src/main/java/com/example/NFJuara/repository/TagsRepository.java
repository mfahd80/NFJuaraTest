package com.example.NFJuara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.NFJuara.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {

	@Query(value = "select ta from Tags ta where ta.id = :id")
	Tags getById(@Param("id") Long id);
}
