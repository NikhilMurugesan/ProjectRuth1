package com.example.springapp.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.backend.model.USER;
import com.example.springapp.backend.service.FirebaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@RestController
public class controller {
	@Autowired
	FirebaseInitializer db;
	
	@GetMapping("/getAllUSERs")
	public List<USER> getAllUSERs() throws InterruptedException, ExecutionException {
		List<USER> userList = new ArrayList<USER>();
		CollectionReference USER= db.getFirebase().collection("userlogin");
		ApiFuture<QuerySnapshot> querySnapshot= USER.get();
		for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
			USER user = doc.toObject(USER.class);
			userList.add(user);
		}
		return userList;
	}
	
	@PostMapping("/saveUSER")
	public int saveUSER(@RequestBody USER USER) {
		CollectionReference USERCR= db.getFirebase().collection("userlogin");
		USERCR.document(String.valueOf(USER.getId())).set(USER);
		return USER.getId();
	}
}