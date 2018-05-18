package com.example.test01.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test01.dao.NoteDao;
import com.example.test01.domain.Note;
import com.example.test01.exception.ForbiddenException;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;
	
	@Override
	public Note findNoteById(long id) {
		return noteDao.findById(id);
	}

	@Override
	@Transactional
	public Note findNote(long id, String email) {
		Note note = noteDao.findById(id);
		if(note.getUser().getEmail().equals(email))
			return note;
		else 
			return null;
	}
	
	@Override
	@Transactional
	public void deleteById(long noteId) {
		Note note = noteDao.findById(noteId);
		noteDao.deleteNote(note);

	}

	@Override
	@Transactional
	public Note saveOrUpdate(Note note, String userEmail) {
		return noteDao.saveOrUpadte(note, userEmail);
	}

	@Override
	@Transactional
	public Note updateNote(Note note) {
		return noteDao.update(note);
	}

}
