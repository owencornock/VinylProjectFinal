package com.example.demo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.domain.Vinyl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:vinyl-schema.sql", "classpath:vinyl-data.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class VinylControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Test
	void testCreate() throws Exception {
		Vinyl testVinyl = new Vinyl (null, "X Ambassadors", "VHS", 12);
		String testVinylAsJSON = this.mapper.writeValueAsString(testVinyl);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testVinylAsJSON);
		
		Vinyl testCreatedVinyl = new Vinyl(3, "X Ambassadors", "VHS", 12);
		String testCreatedVinylAsJSON = this.mapper.writeValueAsString(testCreatedVinyl);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedVinylAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAll");
		
		List<Vinyl> testVinyl = List.of(new Vinyl(1, "Red Hot Chili Peppers", "Unlimited Love", 12), new Vinyl(2, "Dave", "Psychodrama", 12));
		String json = this.mapper.writeValueAsString(testVinyl);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	@Test
	void toStringTest() throws Exception {
		Vinyl vinyl = new Vinyl(1, "Red Hot Chili Peppers", "Unlimited Love", 12);
		vinyl.toString();
	
}
	@Test
	void getIdTest() throws Exception {
		RequestBuilder req = get("/get/1");
		Vinyl testCreatedVinyl = new Vinyl(1, "Red Hot Chili Peppers", "Unlimited Love", 12);
		String testCreatedVinylAsJSON = this.mapper.writeValueAsString(testCreatedVinyl);
				
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testCreatedVinylAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	@Test
	void replaceTest() throws Exception {
		Vinyl testVinyl = new Vinyl(null, "Red Hot Chili Peppers", "Californication", 12);
		String testVinylAsJSON = this.mapper.writeValueAsString(testVinyl);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testVinylAsJSON);
		
		Vinyl createVinyl = new Vinyl(1, "Red Hot Chili Peppers", "Californication", 12);
		String testCreatedVinylAsJSON = this.mapper.writeValueAsString(createVinyl);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testCreatedVinylAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	@Test
	void removeTest() throws Exception {
		RequestBuilder req = delete("/remove/1");
		
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(req).andExpect(checkStatus);
	}

@Test
void getArtistTest() throws Exception {
	RequestBuilder req = get("/getByArtist/Red Hot Chili Peppers");
	
	List<Vinyl> testVinyl = List.of(new Vinyl(1, "Red Hot Chili Peppers", "Unlimited Love", 12));
	String json = this.mapper.writeValueAsString(testVinyl);
	
			
	
	ResultMatcher checkStatus = status().isOk();
	ResultMatcher checkBody = content().json(json);
	
	this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
}
@Test 
void getAlbumTest() throws Exception {
	RequestBuilder req = get("/getByAlbum/Unlimited Love");
	
	List<Vinyl> testVinyl = List.of(new Vinyl(1, "Red Hot Chili Peppers", "Unlimited Love", 12));
	String json = this.mapper.writeValueAsString(testVinyl);
	
			
	
	ResultMatcher checkStatus = status().isOk();
	ResultMatcher checkBody = content().json(json);
	
	this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
}
@Test
void getSizeTest() throws Exception {
	RequestBuilder req = get("/getBySize/12");
	
	List<Vinyl> testVinyl = List.of(new Vinyl(1, "Red Hot Chili Peppers", "Unlimited Love", 12), new Vinyl(2, "Dave", "Psychodrama", 12));
	String json = this.mapper.writeValueAsString(testVinyl);
	
			
	
	ResultMatcher checkStatus = status().isOk();
	ResultMatcher checkBody = content().json(json);
	
	this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
}
}
