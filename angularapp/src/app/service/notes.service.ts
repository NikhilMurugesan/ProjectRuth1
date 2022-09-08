import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Note } from '../models/note';
@Injectable({
  providedIn: 'root'
})
export class NotesService {

  private baseURl1 = 'http://localhost:9090/notes';
  private baseURl2 = 'http://localhost:9090/createnote';
  private baseURl3 = 'http://localhost:9090/deletenote';
  private baseURl4 = 'http://localhost:9090/updatenote';
  private baseURl6 = 'http://localhost:9090/note';

  constructor(private httpClient: HttpClient) { }

  createNote(note: Note): Observable<Object> {
    return this.httpClient.post(this.baseURl2, note);
  }
  getNotes(): Observable<Note[]> {
    return this.httpClient.get<Note[]>(this.baseURl1);
  }
  getNote(id:number): Observable<Note> {
    return this.httpClient.get<Note>(`${this.baseURl6}/${id}`);
  }
  deleteNote(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURl3}/${id}`);
  }
  editnote(id: number,note:Note): Observable<any> {
    return this.httpClient.put(`${this.baseURl4}/${id}`,note);
  }
  getusersNotes(uid: string): Observable<Note[]> {
    return this.httpClient.get<Note[]>(`${this.baseURl1}/${uid}`);
  }
}
