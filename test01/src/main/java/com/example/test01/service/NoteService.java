package com.example.test01.service;

import com.example.test01.domain.Note;

public interface NoteService {

	Note findNoteById();

	void deleteById(long noteId);

	Note saveOrUpdate(Note note);

	Note updateNote(Note note);

}
