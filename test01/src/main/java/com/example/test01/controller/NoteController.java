package com.example.test01.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.test01.domain.Note;
import com.example.test01.exception.ForbiddenException;
import com.example.test01.service.NoteService;
import com.example.test01.service.UserService;

@RestController
@RequestMapping(value = "/note")
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Note getNoteById(@PathVariable Integer id, Principal principal) {
		Note note = noteService.findNote(id, principal.getName());
		if (note != null)
			return note;
		else
			throw new ForbiddenException("User not alowed for this note.");
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public Note updateNote(@RequestBody Note note, Principal principal) {
		return noteService.updateNote(note);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public Note createNote(@Valid @RequestBody Note note, Principal principal ) {
		return noteService.saveOrUpdate(note, principal.getName());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<?> deleteNote(@PathVariable long id, Principal principal) {
		noteService.deleteById(id);
		return new ResponseEntity<Note>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.PATCH, consumes = "application/json")
	public Note partialUpdateNote(@RequestBody Note note, Principal principal) {
		
		Note updatedNote = noteService.findNote(note.getId(), principal.getName());
		if (updatedNote == null)
			throw new ForbiddenException("User not alowed for this note.");
		
		if(note.getTitle() != null) 
			updatedNote.setTitle(note.getTitle());
		
		if(note.getNote() != null)
			updatedNote.setNote(note.getNote());
		
		if(note.getCreateTime()!= null)
			updatedNote.setCreateTime(note.getCreateTime());
		
		if(note.getLastUpadteTime() != null)
			updatedNote.setLastUpadteTime(note.getLastUpadteTime());
		
		return noteService.updateNote(updatedNote);
	}
	
	
}
