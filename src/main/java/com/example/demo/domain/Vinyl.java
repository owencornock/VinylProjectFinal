package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vinyl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String artist;
	
	@Column(nullable = false)
	private String album;
	
	@Column(nullable = false)
	private Integer size;

	public Vinyl(Integer id, String artist, String album, Integer size) {
		super();
		this.id = id;
		this.artist = artist;
		this.album = album;
		this.size = size;
	}

	public Vinyl() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Vinyl [id=" + id + ", artist=" + artist + ", album=" + album + ", size=" + size + "]";
	}

}
