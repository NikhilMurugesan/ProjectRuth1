package com.example.springapp.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.springapp.Exception.ResourceNotFoundException;
import com.example.springapp.entity.NOTE;
import com.example.springapp.repository.*;

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
       
        return notesRepository.findAllnotesByUid(uid);
         
    }


    public NOTE updateNote(int id, NOTE note) {
        NOTE note1 = notesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Note not found"));
        note1.setNote(note.getNote());
        return notesRepository.save(note1);
    }
    
}
