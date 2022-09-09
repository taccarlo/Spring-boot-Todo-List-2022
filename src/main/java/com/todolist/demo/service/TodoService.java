package com.todolist.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.todolist.demo.model.Todo;

@Service()
public class TodoService implements ITodoService {

	private List<Todo> list = new ArrayList<Todo>();
	private int lastId;

	public TodoService() {
		list.add(new Todo(1, "titolo 1", "todo 1"));
		list.add(new Todo(2, "titolo 2", "todo 2"));
		list.add(new Todo(3, "titolo 3", "todo 3"));
		lastId = 3;
	}

	@Override
	public Iterable<Todo> getAll() {
		return list;
	}

	@Override
	public Todo create(@RequestBody Todo item) {
		lastId++;
		item.setId(lastId);
		list.add(item);
		return item;
	}

	@Override
	public Optional<Todo> getById(int id) {
		Optional<Todo> todo = list.stream().filter(item -> item.getId() == id).findFirst();
		return todo;
	}

	@Override
	public Optional<Todo> update(int id, Todo todo) {
		Optional<Todo> foundItem = list.stream().filter(item -> item.getId() == id).findFirst();
		if (foundItem.isEmpty()) {
			return Optional.empty();
		}
		foundItem.get().setTitle(todo.getTitle());
		foundItem.get().setSubtitle(todo.getSubtitle());
		return foundItem;
	}

	@Override
	public boolean delete(int id) {
		Optional<Todo> foundItem = list.stream().filter(item -> item.getId() == id).findFirst();
		if (foundItem.isEmpty()) {
			return false;
		}
		list.remove(foundItem.get());
		return true;
	}

}
