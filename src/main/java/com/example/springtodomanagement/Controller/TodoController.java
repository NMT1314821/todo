package com.example.springtodomanagement.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtodomanagement.Dto.TodoDto;
import com.example.springtodomanagement.Service.TodoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/todo")
@AllArgsConstructor
public class TodoController
{
	
	private TodoService tSer;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<TodoDto> crateTodo(@RequestBody TodoDto todoDto)
	{
		TodoDto savetodo=tSer.createTodo(todoDto);
		return new ResponseEntity<>(savetodo,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TodoDto> getByTodo(@PathVariable("id") long todoid)
	{
		TodoDto savedtodo=tSer.getByTodo(todoid);
		return new ResponseEntity<>(savedtodo,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<TodoDto>> getAllTodos()
	{
		List<TodoDto> savedto=tSer.getAllTodos();
		
		return new ResponseEntity<>(savedto,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") long todoid, @RequestBody TodoDto todoDto)
	{
		TodoDto upsav=tSer.updateTodo(todoid, todoDto);
		
		return new ResponseEntity<>(upsav,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> todoDel(@PathVariable("id") long todoid)
	{
		tSer.todoDel(todoid);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
}
