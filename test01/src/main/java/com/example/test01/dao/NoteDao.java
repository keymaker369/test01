package com.example.test01.dao;

import com.example.test01.domain.Note;

public interface NoteDao {

	Note findById(long id);

	void deleteNote(Note note);

	Note saveOrUpadte(Note note, String userEmail);

	Note update(Note note);

}
