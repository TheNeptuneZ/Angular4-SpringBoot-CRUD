package com.TheNeptuneZ.SpringBoot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TheNeptuneZ.SpringBoot.model.User;
import com.TheNeptuneZ.SpringBoot.repository.UserRepo;
/**
 * 
 * @author TheNeptuneZ
 *
 * TheNeptuneZ.github.io
 */
@RestController
public class UserController {

	@Autowired
	UserRepo userRepo;

	@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		Iterable<User> users = userRepo.findAll();

		users.forEach(list::add);
		return list;
	}

	@PostMapping(value = "/postuser")
	public User postUser(@RequestBody User user) {

		userRepo.save(new User(user.getFirstName(), user.getLastName()));
		return user;
	}

	@GetMapping(value = "/findbylastname/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findByLastName(@PathVariable String lastName) {

		List<User> users = userRepo.findByLastName(lastName);
		return users;
	}

	@DeleteMapping(value = "/user/{id}")
	public void deleteUser(@PathVariable long id) {

		userRepo.delete(id);
	}
}
