package com.mycompany;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.model.NotesRepository;
import com.mycompany.model.Notes;
import com.mycompany.model.User;
import com.mycompany.model.UserRepository;

@RestController
@RequestMapping("{username}/notes")
public class NotesController {
	@Autowired
	NotesRepository notesRepository;
	@Autowired
	UserRepository userRepository;
	@RequestMapping
	public Collection<Notes> readNotes(@PathVariable String username){	
		return notesRepository.findByUserUsername(username);
	}
	@RequestMapping(method = RequestMethod.POST)
	public void addNotes(@PathVariable String username, @RequestBody Notes note){
		User user = 	userRepository.findByUsername(username);
		note.setUser(user);
		notesRepository.save(note);
	}
}
