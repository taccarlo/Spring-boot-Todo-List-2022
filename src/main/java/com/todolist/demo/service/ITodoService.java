package com.todolist.demo.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.todolist.demo.model.Todo;

public interface ITodoService {

	public Iterable<Todo> getAll();
	public Todo create(@RequestBody Todo todo);
	public  Optional<Todo>  getById(int id);
	public Optional<Todo> update(int id, Todo todo);
	public boolean delete(int id);

}
