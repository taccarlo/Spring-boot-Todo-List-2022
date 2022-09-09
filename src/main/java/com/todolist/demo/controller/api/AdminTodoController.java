package com.todolist.demo.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.todolist.demo.model.Todo;
import com.todolist.demo.service.ITodoService;

@RestController
public class AdminTodoController{


	@Autowired
	@Qualifier("mainTodoService")
	private ITodoService todoService;
	
	public AdminTodoController() {
	}
	
	@RequestMapping("/admin/api/todos")
	public Iterable<Todo> getAll(){
		return todoService.getAll();
	}
	@RequestMapping("/admin/api/todos/{id}")
	public Todo getById(@PathVariable int id) {
		Optional<Todo> todo = todoService.getById(id);
		if(todo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		return todo.get();
	}
	
	@RequestMapping(value = "/admin/api/todos", method = RequestMethod.POST)
	public Todo create(@RequestBody Todo todo) {
		return todoService.create(todo);
	}
	
	@RequestMapping(value = "/admin/api/todos/{id}", method = RequestMethod.PUT)
	public Todo update(@PathVariable int id, @RequestBody Todo todo) {
		Optional<Todo> foundTodo = todoService.update(id, todo);
		if(foundTodo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		foundTodo.get().setUrl(todo.getUrl());
		return foundTodo.get();
	}
	
	@RequestMapping(value = "/admin/api/todos/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		boolean isDeleted = todoService.delete(id);
		if(!isDeleted) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
	}
	
	
}
