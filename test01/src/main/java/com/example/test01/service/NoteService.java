package com.example.test01.service;

import com.example.test01.domain.Note;

public interface NoteService {

	Note findNoteById(long id);
	
	Note findNote(long id, String email);

	void deleteById(long noteId);

	Note saveOrUpdate(Note note, String userEmail);

	Note updateNote(Note note);

}
