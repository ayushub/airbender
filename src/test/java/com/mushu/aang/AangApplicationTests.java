package com.mushu.aang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import sun.jvm.hotspot.utilities.Assert;

@SpringBootTest
class AangApplicationTests {

	@Autowired
	private Sokka aangController;

	@Test
	void contextLoads() {
		Assert.that(aangController != null, "Controller initialised");
	}

}

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetNotesTests {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void contextLoads() {
		Assert.that(this.restTemplate.getForObject("http://localhost:"+ port +"/notes", String.class).contains("Third"), "Get all notes");
	}
}

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetNoteByIdTests {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void contextLoads() {
		Assert.that(this.restTemplate.getForObject("http://localhost:"+ port +"/notes/3", String.class).contains("Third"), "Get note by id");
	}
}

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddNoteTests {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void contextLoads() {
		Assert.that(this.restTemplate.getForObject("http://localhost:"+ port +"/notes/3", String.class).contains("Third"), "Get note by id");
	}
}
