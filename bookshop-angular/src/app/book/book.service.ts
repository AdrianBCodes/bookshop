import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseURL = environment.baseUrl + "/books";

  constructor(private httpClient: HttpClient){}

  getBooksList(request): Observable<Book[]>{
    const params = request;
    return this.httpClient.get<Book[]>(this.baseURL, {params});
  }

  getBookById(id: string): Observable<Book>{
    return this.httpClient.get<Book>(this.baseURL + '/' + id)
  }

}
