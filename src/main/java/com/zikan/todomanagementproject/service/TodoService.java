package com.zikan.todomanagementproject.service;

import com.zikan.todomanagementproject.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

   List <TodoDto> getAllTodos();

   TodoDto updateTodo(TodoDto todoDto, Long id);










}
