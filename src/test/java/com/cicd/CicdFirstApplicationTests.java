package com.cicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class CicdFirstApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGreetingEndPoint() throws Exception{

		String name = "Rashmi Ranjan Swain";
		mockMvc.perform(MockMvcRequestBuilders.get("/greetings/{name}", name))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello " + name + " Congratulations you have successfully completed Jenkins CI/CD demo !"));

	}

}
