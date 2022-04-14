package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Vinyl;
import com.example.demo.service.VinylService;

@RestController
@CrossOrigin


public class VinylController {

	private VinylService service;
	
	@Autowired
	public VinylController(VinylService service) {
		super();
		this.service = service;
	}
	@PostMapping("/create")
	public ResponseEntity<Vinyl> createVinyl(@RequestBody Vinyl v) {
		Vinyl created = this.service.create(v);
		ResponseEntity<Vinyl> response = new ResponseEntity<Vinyl>(created, HttpStatus.CREATED);
		return response;

	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Vinyl>> getAllVinyl() {
		return ResponseEntity.ok(this.service.getAll());

	}
	@GetMapping("/get/{id}")
	public Vinyl getVinyl(@PathVariable Integer id) {
		return this.service.getOne(id);
	}
	@PutMapping("/replace/{id}")
	public ResponseEntity<Vinyl> replaceVinyl(@PathVariable Integer id, @RequestBody Vinyl newVinyl) {
		Vinyl body = this.service.replace(id, newVinyl);
		ResponseEntity<Vinyl> response = new ResponseEntity<Vinyl>(body, HttpStatus.ACCEPTED);
		return response;
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeVinyl(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/getByArtist/{artist}")
	public ResponseEntity<List<Vinyl>> getVinylByArtist(@PathVariable String artist) {
		List<Vinyl> found = this.service.getVinylByArtist(artist);
		return ResponseEntity.ok(found);
	}
	@GetMapping("/getByAlbum/{album}")
	public ResponseEntity<List<Vinyl>> getVinylByAlbum(@PathVariable String album) {
		List<Vinyl> found = this.service.getVinylByAlbum(album);
		return ResponseEntity.ok(found);
	}
	@GetMapping("/getBySize/{size}")
	public ResponseEntity<List<Vinyl>> getVinylBySize(@PathVariable Integer size) {
		List<Vinyl> found = this.service.getVinylBySize(size);
		return ResponseEntity.ok(found);
	}

}
