package com.example.NFJuara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.NFJuara.model.Todos;

public interface TodosRepository extends JpaRepository<Todos, Long> {

	@Query(value = "select to from Todos to where to.id = :id")
	Todos getById(@Param("id") Long id);
}
