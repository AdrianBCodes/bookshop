import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Book } from './book';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseURL = environment.baseUrl + "/books";

  constructor(private httpClient: HttpClient){}

  getBooksList(request): Observable<Book[]> {
    const params = new HttpParams({ fromObject: request });
    return this.httpClient.get<Book[]>(this.baseURL, { params }).pipe(
      catchError((error: HttpErrorResponse) => {
        const errorMessage = `Error occurred while retrieving books. Request: ${this.baseURL}?${params.toString()}`;
        return throwError(() => new Error(errorMessage));
      })
    );
  }

  getBookById(id: string): Observable<Book> {
    return this.httpClient.get<Book>(`${this.baseURL}/${id}`).pipe(
      catchError((error: HttpErrorResponse) => {
        const errorMessage = `Error occurred while retrieving the book. Request: ${this.baseURL}/${id}`;
        return throwError(() => new Error(errorMessage));
      })
    );
  }

}
