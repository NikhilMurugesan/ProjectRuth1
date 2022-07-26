import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
//import { UsersService } from 'src/app/service/users.service';
@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {

  user$ = this.authService.currentUser$;

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
  }

}
