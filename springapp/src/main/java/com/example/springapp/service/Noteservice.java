package com.example.springapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springapp.entity.NOTE;
import com.example.springapp.repository.NotesRepository;

@Service
public class Noteservice {

    @Autowired
    NotesRepository notesRepository;
    
    
    public List<NOTE> getAllNotes() {
        return notesRepository.findAll();
    }
    /* 
    public NOTE getNote(int nid) {
        Optional<NOTE> note = notesRepository.findById(nid);
        if(note.isPresent()) {
            return note.get();
        }
        return null;
    }*/
    
    
    public NOTE createNote(NOTE note) {
        return notesRepository.save(note);
    }
    
    
    public String deleteNote(int nid) {
        notesRepository.deleteById(nid);
        return "Note deleted successfully";
    }
    public List<NOTE> getAllNotesbyUser(String uid) {
        return notesRepository.findAllByUid(uid);

    }
    
}
