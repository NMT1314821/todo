package com.example.springtodomanagement.Service;

import java.util.List;

import com.example.springtodomanagement.Dto.TodoDto;

public interface TodoService 
{
	TodoDto createTodo(TodoDto todoDto);
	
	TodoDto getByTodo(long todoid);
	
	List<TodoDto> getAllTodos();
	
	TodoDto updateTodo(long id,TodoDto todoDto);
	
	void todoDel(long todoid);

}
