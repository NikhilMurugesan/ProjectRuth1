import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Note } from '../models/note';
import { NotesService } from '../service/notes.service';

@Component({
  selector: 'app-editnote',
  templateUrl: './editnote.component.html',
  styleUrls: ['./editnote.component.css']
})
export class EditnoteComponent implements OnInit {
 
  nid: number;
  note : Note = new Note();
  constructor(private noteservice:NotesService,private router: Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.nid = this.route.snapshot.params['id'];
    this.noteservice.getNote(this.nid).subscribe(data=>{
      this.note=data},error => console.log(error));
  }
  onSubmit()
  {
    this.noteservice.editnote(this.nid,this.note).subscribe(data=>
      {
        this.gonotes();
      },error => console.log(error));
  }

  gonotes()
  {
    this.router.navigate(['/notes'])
  }

}
