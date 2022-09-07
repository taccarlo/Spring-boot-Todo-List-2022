package com.todolist.demo.service;

import java.util.Optional;

import com.todolist.demo.model.Todo;

public interface ITodoService {

	Iterable<Todo> getAll();
	Optional<Todo> getById(int id);

}
