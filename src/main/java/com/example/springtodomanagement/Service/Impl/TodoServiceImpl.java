package com.example.springtodomanagement.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.springtodomanagement.Dto.TodoDto;
import com.example.springtodomanagement.Model.Todo;
import com.example.springtodomanagement.Repository.TodoRepository;
import com.example.springtodomanagement.Service.TodoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService
{

	private TodoRepository tRes;
	
	private ModelMapper modelMapper;
	@Override
	public TodoDto createTodo(TodoDto todoDto) 
	{
		//convertin dto to jpa
		
		Todo todo=modelMapper.map(todoDto,Todo.class);
		
		Todo savedtodo=tRes.save(todo);
		
		//convert dto to jpa
		
		return modelMapper.map(savedtodo,TodoDto.class);
	}
	@Override
	public TodoDto getByTodo(long todoid) 
	{
		Todo tos=tRes.findById(todoid).get();
		return modelMapper.map(tos, TodoDto.class);
	}
	@Override
	public List<TodoDto> getAllTodos() 
	{
		List<Todo> alltodo=tRes.findAll();
		return alltodo.stream().map((todo)->modelMapper.map(todo,TodoDto.class)).collect(Collectors.toList());
	}
	@Override
	public TodoDto updateTodo(long id, TodoDto todoDto) 
	{
		
		Todo todo=tRes.findById(id).get();
		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());
		todo.setCompleted(todoDto.isCompleted());
		
		Todo uptodo=tRes.save(todo);
		return modelMapper.map(uptodo, TodoDto.class);
	}
	@Override
	public void todoDel(long todoid) 
	{
		tRes.deleteById(todoid);
	;
		
	}

} 
