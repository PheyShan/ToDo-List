package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> all();
    Todo save (Todo todo);
    void delete (int todoId);
    Todo findById (int todoId);

}
