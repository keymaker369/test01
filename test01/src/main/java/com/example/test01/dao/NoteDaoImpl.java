package com.example.test01.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.test01.domain.Note;
import com.example.test01.domain.User;
import com.example.test01.exception.ForbiddenException;

@Repository
public class NoteDaoImpl implements NoteDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Note findById(long id) {
		return entityManager.find(Note.class, new Long(id));
	}

	@Override
	public void deleteNote(Note note) {
		entityManager.remove(note);
	}

	@Override
	public Note saveOrUpadte(Note note, String userEmail) {
		Note dbNote = findById(note.getId());
		if(dbNote == null) {
			User tempUser = userDao.findUserByEmail(userEmail);
			note.setUser(tempUser);
			entityManager.persist(note);
			return note;
		} else {
			
			if(!dbNote.getUser().getEmail().equals(userEmail))
				throw new ForbiddenException("User not alowed for this note.");
			
			note.setUser(dbNote.getUser());
			entityManager.merge(note);
			return note;
		}
	}

	@Override
	public Note update(Note note) {
		Note dbNote = findById(note.getId());
		note.setUser(dbNote.getUser());
		return entityManager.merge(note);
	}
	
	
}
