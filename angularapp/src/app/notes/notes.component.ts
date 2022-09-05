import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { NotesService } from 'src/app/service/notes.service';
import { Note } from 'src/app/models/note';
import { Router,RouterModule } from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { switchMap, tap } from 'rxjs';
import { ImageUploadService } from 'src/app/service/image-upload.service';
import { UsersService } from 'src/app/service/users.service';

import { updateCurrentUser, User } from 'firebase/auth';
import { async, Observable } from 'rxjs';
import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import {
  doc,
  docData,
  Firestore,
  getDoc,
  setDoc,
  updateDoc,
} from '@angular/fire/firestore';
import 'firebase/compat/database';
import { collection, getDocs } from 'firebase/firestore';
import { user } from '@angular/fire/auth';
import { ProfileUser } from '../models/user';
//import { UsersService } from 'src/app/service/users.service';
@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {

  user$ = this.authService.currentUser$;
 // user$ = this.userservice.currentUserProfile$;
  
  x:any;
  z:any;
  p: any;
  y:any = [];
  q: Note= new Note();
  note : Note = new Note();
  notes: Note[]|undefined;
 // userprofile : any = UsersService.currentUserProfile$;
  constructor(public firestore: Firestore,private authService:AuthService,private noteservice:NotesService,private router: Router,private userservice:UsersService) { }
  
  addnote(){
    this.x =document.getElementById("note_inputt");
    if (this.x.style.display === "none") {
      this.x.style.display = "block";
    }
    else {
      this.x.style.display = "none";
    }
  }

  
 
  private getNote()
  {
    this.noteservice.getusersNotes(this.z).subscribe(notes => this.notes = notes);
    this.getuserData();
  }
 
  getuid(){
    this.user$.pipe().subscribe(data => {
      console.log(data?.uid);
      this.z=data?.uid;
    this.note.uid = data?.uid;
    });
  }
  getnotebycurrentuser()
  {
    this.getNote();
        this.noteservice.getusersNotes(this.z).subscribe(notes =>
      {
       console.log( this.notes = notes);
      });
    
  }
  
 
  getuserData() {
    const dbInstance = collection(this.firestore, 'users');
    getDocs(dbInstance).then((response)=>{
      this.y = [...response.docs.map((item) => {
        return { ...item.data(), id: item.id }
      })]
    })
  }
   
    
  
  createNote(){

    this.noteservice.createNote(this.note).subscribe(data => {
      this.getNote();
    },
    error => console.log(error)
    
    );
  }
  onrefresh()
  {
    this.getuid();
    this.getNote();
    this.getnotebycurrentuser();
  }
  onSubmit(){
    this.createNote();
  }

  ngOnInit(): void {
    this.getuid();
    this.getNote();
    this.getnotebycurrentuser();
    
  }

  deleteNote(nid: number){
    this.noteservice.deleteNote(nid).subscribe(data => {
      console.log(data);
      this.getNote();
      
    }
    )
  }
  editnote(nid:number)
  {
    
  }
  
  
logout(){
  sessionStorage.clear();
  this.router.navigate(['/login']);
}
}
