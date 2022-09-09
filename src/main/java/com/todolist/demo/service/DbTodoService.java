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
	public Todo create(@RequestBody Todo photo) {
		return todoRepository.save(photo);
	}

	@Override
	public Optional<Todo> getById(int id) {
		return todoRepository.findById(id);
	}

	@Override
	public Optional<Todo> update(int id, Todo photo) {
		Optional<Todo> foundPhoto = todoRepository.findById(id);
		if(foundPhoto.isEmpty()) {
			return Optional.empty();
		}
		foundPhoto.get().setUrl(photo.getUrl());
		todoRepository.save(foundPhoto.get());
		return foundPhoto;
	}

	@Override
	public boolean delete(int id) {

		Optional<Todo> foundPhoto = todoRepository.findById(id);
		if(foundPhoto.isEmpty()) {
			return false;
		}
		todoRepository.delete(foundPhoto.get());
		return true;
	}
	
}
