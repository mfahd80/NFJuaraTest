package com.example.NFJuara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.NFJuara.model.TodosTags;


public interface TodosTagsRepository extends JpaRepository<TodosTags, Long> {

	@Query(value = "select tt from TodosTags tt where tt.id = :id")
	TodosTags getById(@Param("id") Long id);
	
	@Query(value = "select tt from TodosTags tt where tt.todo.isActive = 0 ")
	List<TodosTags> getByAllActive();
}
