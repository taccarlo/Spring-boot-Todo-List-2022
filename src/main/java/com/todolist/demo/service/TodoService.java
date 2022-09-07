package com.todolist.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todolist.demo.model.Todo;

/**
 * Service indicate that the class is used to hold the business logic
 */
@Service("mainTodoService")
public class TodoService implements ITodoService{

	private List<Todo> list = new ArrayList<Todo>();
	@Override
	public Iterable<Todo> getAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Optional<Todo> getById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
