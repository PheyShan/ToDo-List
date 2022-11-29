package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.TodoRepository;
import org.generation.SpringAssessment.repository.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceMySQL implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceMySQL(@Autowired TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo save (Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete (int todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public List<Todo> all() {
        List<Todo> result = new ArrayList<>();
        todoRepository.findAll().forEach(result :: add);
        return result;
    }

    @Override
    public Todo findById(int todoId) {
        Optional<Todo> todo = todoRepository.findById(todoId);
        Todo todoRepository = todo.get(); //If a value is present, isPresent() will return true and get() will return the value.
        return todoRepository;
    }



}
