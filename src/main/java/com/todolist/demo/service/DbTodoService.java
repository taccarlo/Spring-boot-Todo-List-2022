package com.todolist.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.todolist.demo.model.Todo;
import com.todolist.demo.repository.ITodoRepository;

@Service("mainTodoService")
public class DbTodoService  implements ITodoService {

	@Autowired
	private ITodoRepository todoRepository;
	
	@Override
	public Iterable<Todo> getAll(){
		return todoRepository.findAll();
	}

	@Override
	public Todo create(@RequestBody Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Optional<Todo> getById(int id) {
		return todoRepository.findById(id);
	}

	@Override
	public Optional<Todo> update(int id, Todo todo) {
		Optional<Todo> foundTodo = todoRepository.findById(id);
		if(foundTodo.isEmpty()) {
			return Optional.empty();
		}
		foundTodo.get().setTitle(todo.getTitle());
		foundTodo.get().setSubtitle(todo.getSubtitle());
		todoRepository.save(foundTodo.get());
		return foundTodo;
	}

	@Override
	public boolean delete(int id) {

		Optional<Todo> foundTodo = todoRepository.findById(id);
		if(foundTodo.isEmpty()) {
			return false;
		}
		todoRepository.delete(foundTodo.get());
		return true;
	}
	
}
