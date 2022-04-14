package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Vinyl;
import com.example.demo.repo.VinylRepo;

@Service

public class VinylService implements ServiceIF<Vinyl> {

	private VinylRepo repo;

	@Autowired
	public VinylService(VinylRepo repo) {
		super();
		this.repo = repo;
	}

	public Vinyl create(Vinyl v) {
		Vinyl created = this.repo.save(v);
		return created;
	}

	public List<Vinyl> getAll() {
		return this.repo.findAll();
	}

	public Vinyl getOne(Integer id) {
		Optional<Vinyl> found = this.repo.findById(id);
		return found.get();
	}

	public Vinyl replace(Integer id, Vinyl newVinyl) {
		Vinyl existing = this.repo.findById(id).get();
		existing.setArtist(newVinyl.getArtist());
		existing.setAlbum(newVinyl.getAlbum());
		existing.setSize(newVinyl.getSize());
		Vinyl updated = this.repo.save(existing);
		return updated;
	}

	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id);
	}

	public List<Vinyl> getVinylByArtist(String artist) {
		List<Vinyl> found = this.repo.findByArtistIgnoreCase(artist);
		return found;
	}

	public List<Vinyl> getVinylByAlbum(String album) {
		List<Vinyl> found = this.repo.findByAlbumIgnoreCase(album);
		return found;
	}

	public List<Vinyl> getVinylBySize(Integer size) {
		List<Vinyl> found = this.repo.findBySize(size);
		return found;
	}
}
