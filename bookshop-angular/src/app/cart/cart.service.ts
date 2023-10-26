import { Injectable } from '@angular/core';
import { Cart } from './cart';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { CartItemWriteModel } from './cartItem/cartItemWriteModel';
import { CartItem } from './cartItem/cartItem';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private baseURL = environment.baseUrl + "/cart";

  constructor(private httpClient: HttpClient) { }

  getCart(id: string): Observable<Cart> {
    return this.httpClient.get<Cart>(`${this.baseURL}/${id}`).pipe(
      catchError((error: HttpErrorResponse) => {
        const errorMessage = `Error occurred while retrieving cart. Request: ${this.baseURL}/${id}`;
        return throwError(() => new Error(errorMessage));
      })
    );
  }

  addToCart(productId: string): Observable<void> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    // TODO - change UserId when users are added
    const body = new CartItemWriteModel('000000000000000000000001', productId, 1);
    return this.httpClient.post<void>(this.baseURL, body, httpOptions).pipe(
      catchError((error: HttpErrorResponse) => {
        const errorMessage = `Error occurred while adding item to cart. Request: ${this.baseURL}`;
        return throwError(() => new Error(errorMessage));
      })
    );
  }

  editCartItem(item : CartItem): Observable<void> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    // TODO - change UserId when users are added
    const body = new CartItemWriteModel('000000000000000000000001', item.product.id, item.quantity);
    return this.httpClient.put<void>(this.baseURL, body, httpOptions).pipe(
      catchError((error: HttpErrorResponse) => {
        const errorMessage = `Error occurred while editing cart item. Request: ${this.baseURL}`;
        return throwError(() => new Error(errorMessage));
      })
    );
  }
}
