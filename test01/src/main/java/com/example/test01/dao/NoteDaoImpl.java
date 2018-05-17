package com.example.test01.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.test01.domain.Note;

@Repository
public class NoteDaoImpl implements NoteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Note findById(long id) {
		return entityManager.find(Note.class, new Long(id));
	}

	@Override
	public void deleteNote(Note note) {
		entityManager.remove(note);
	}

	@Override
	public Note saveOrUpadte(Note note) {
		if(findById(note.getId()) == null) {
			entityManager.persist(note);
			return note;
		} else {
			entityManager.merge(note);
			return note;
		}
	}

	@Override
	public Note update(Note note) {
		return entityManager.merge(note);
	}
	
	
}
