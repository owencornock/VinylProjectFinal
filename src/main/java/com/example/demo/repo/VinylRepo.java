package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Vinyl;

@Repository
public interface VinylRepo extends JpaRepository<Vinyl, Integer> {

	List<Vinyl> findByArtistIgnoreCase(String artist);
	
	List<Vinyl> findByAlbumIgnoreCase(String album);
	
	List<Vinyl> findBySize(Integer size);
}
