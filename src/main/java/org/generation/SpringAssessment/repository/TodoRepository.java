package org.generation.SpringAssessment.repository;

import org.generation.SpringAssessment.repository.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
