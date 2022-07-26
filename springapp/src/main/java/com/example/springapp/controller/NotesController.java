package com.example.springapp.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.entity.NOTE;
import com.example.springapp.entity.USER;
//import com.example.springapp.service.FirebaseInitializer;
import com.example.springapp.service.Noteservice;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NotesController {

    @Autowired
    private Noteservice noteservice;
/* 
    @Autowired
	FirebaseInitializer db;

	
	@GetMapping("/getallusers")
	public List<USER> getAllUSERs() throws InterruptedException, ExecutionException {
		List<USER> userList = new ArrayList<USER>();
		CollectionReference USER= db.getFirebase().collection("users");
		ApiFuture<QuerySnapshot> querySnapshot= USER.get();
		for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
			USER user = doc.toObject(USER.class);
			userList.add(user);
		}
		return userList;
	}

	
	
	@PostMapping("/saveUSER")
	public String saveUSER(@RequestBody USER USER) {
		CollectionReference USERCR= db.getFirebase().collection("users");
		USERCR.document(String.valueOf(USER.getuId())).set(USER);
		return USER.getuId();
	}*/

    @GetMapping("/notes")
    public List<NOTE> getAllNotes() {
        return noteservice.getAllNotes();
    }

	@GetMapping("/notes/{uid}")
	public ResponseEntity<List<NOTE>> getAllNotesByUser(@PathVariable String uid) {
		
		return ResponseEntity.ok( noteservice.getAllNotesbyUser(uid));
	}
	@GetMapping("/note/{nid}")
	public ResponseEntity<NOTE> getNote(@PathVariable int nid) {
		
		return ResponseEntity.ok( noteservice.getNote(nid));
	}

    @PostMapping("/createnote")
    public NOTE createNote(@RequestBody NOTE note) {
        return noteservice.createNote(note);
    }

	@PutMapping("/updatenote/{nid}")
	public NOTE updateNote(@PathVariable int nid, @RequestBody NOTE note) {
		return noteservice.updateNote(nid, note);
	}

	@DeleteMapping("/deletenote/{nid}")
	public ResponseEntity<Map<String,Boolean>> deletenote(@PathVariable int nid) {
	
		 noteservice.deleteNote(nid);
		 Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		 return ResponseEntity.ok(response);
	}
}
