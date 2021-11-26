package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void shouldReturnCorrectSum() throws Exception {
		this.mvc.perform(
					post("/sum")
					.contentType(APPLICATION_JSON)
					.content("{\"values\": [6.0, 5.0, 4.0]}")
				).andExpect(status().isOk())
				.andExpect(content().json("{\"result\": 15.0}"));
	}

	@Test
	public void shouldReturnCorrectMultiplication() throws Exception {
		this.mvc.perform(
						post("/multiply")
								.contentType(APPLICATION_JSON)
								.content("{\"value1\": 10.0, \"value2\": 10.0}")
				).andExpect(status().isOk())
				.andExpect(content().json("{\"result\": 100.0}"));
	}

	@Test
	public void shouldReturnAnErrorOnSumWithoutValues() throws Exception {
		this.mvc.perform(
						post("/sum")
								.contentType(APPLICATION_JSON)
								.content("{}")
				).andExpect(status().isBadRequest());

	}

	@Test
	public void shouldReturnAnErrorOnMultiplyWithoutValues() throws Exception {
		this.mvc.perform(
				post("/multiply")
						.contentType(APPLICATION_JSON)
						.content("{}")
		).andExpect(status().isBadRequest());

	}

	@Test
	public void shouldReturnAnErrorOnMultiplyWithOnlyOneValue() throws Exception {
		this.mvc.perform(
				post("/multiply")
						.contentType(APPLICATION_JSON)
						.content("{\"value1\": 10.0}")
		).andExpect(status().isBadRequest());

	}

}
