package com.todolist.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.todolist.demo.model.Todo;
import com.todolist.demo.service.ITodoService;

import java.util.Optional;

/**
 * This class manages the API used by the user in the main view.
 * For this class are needed to add the Starters: [Spring web]
 * RestController: The RestController is a specialized version of the controller. (Spring web)
 * Autowired : allows to resolve and inject collaborating beans into our bean, introduced to perform the annotations-driven Dependency Injection.
 * Dependency Injection : a design pattern in which an object or function receive objects or functions that it depends on, in order to separate the concerns of constructing objects and using them.
 * Bean :  are classes that encapsulate one or more objects into a single standardized object.
 * Qualifier : indicate which bean needs to be injected
 * @version 0.0.1
 * @author Carlo Tacchella
 * @since 22/09/07
 */
@RestController
public class TodoController {

	@Autowired
	@Qualifier("mainTodoService")
	private ITodoService todoService;

	public TodoController() {
		
	}
	
	/**
	 * get All the todos
	 * @return all the todos in db
	 */
	@RequestMapping("/api/todos")
	public Iterable<Todo> getAll(){
		return todoService.getAll();
	}

	/**
	 * get the selected todo
	 * @param id the selected id
	 * @return a Todo object not null
	 * @throws ResponseStatusException if founds no item
	 */
	@RequestMapping("/api/todos/{id}")
	public Todo getById(@PathVariable int id){
		Optional<Todo> todo = todoService.getById(id);
		if(todo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		return todo.get();
	}
	
}
