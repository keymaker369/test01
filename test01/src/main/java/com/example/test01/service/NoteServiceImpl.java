package com.example.test01.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.test01.dao.NoteDao;
import com.example.test01.domain.Note;

@Service
public class NoteServiceImpl implements NoteService {

	private NoteDao noteDao;
	
	@Override
	public Note findNoteById(long id) {
		return noteDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteById(long noteId) {
		Note note = noteDao.findById(noteId);
		noteDao.deleteNote(note);

	}

	@Override
	@Transactional
	public Note saveOrUpdate(Note note) {
		return noteDao.saveOrUpadte(note);
	}

	@Override
	@Transactional
	public Note updateNote(Note note) {
		return noteDao.update(note);
	}

}
