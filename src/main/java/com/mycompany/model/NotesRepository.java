package com.mycompany.model;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface NotesRepository  extends CrudRepository<Notes, Long>{
	Collection<Notes> findByUserUsername(String username);

}
