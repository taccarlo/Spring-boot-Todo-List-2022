package com.todolist.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoListApplicationTests {

	@Test
	void helloWorld() {
		assertEquals(1,1);
	}

	@Test
	void helloWorld2() {
		assertNotEquals(1,2);
	}

}
