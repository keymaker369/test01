package com.example.test01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test01.domain.Note;
import com.example.test01.service.NoteService;

@RestController
@RequestMapping(value = "/note")
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	public Note getNoteById(@PathVariable Integer id) {
		return null;
	}
	
	public Note updateNote(@RequestBody Note note ) {
		return null;
	}
	
	public Note createNote(@RequestBody Note note ) {
		return null;
	}
	
	public void deleteNote(@RequestBody long noteId) {
		
	}
	
	
	
}
