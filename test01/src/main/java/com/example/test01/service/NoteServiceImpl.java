package com.example.test01.service;

import org.springframework.stereotype.Service;

import com.example.test01.domain.Note;

@Service
public class NoteServiceImpl implements NoteService {

	@Override
	public Note findNoteById() {
		System.out.println("find note");
		return new Note();
	}

	@Override
	public void deleteById(long noteId) {
		System.out.println("delete note");

	}

	@Override
	public Note saveOrUpdate(Note note) {
		System.out.println("save or update");
		return new Note();
	}

	@Override
	public Note updateNote(Note note) {
		System.out.println("update note");
		return new Note();
	}

}
