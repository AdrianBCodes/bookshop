import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';
import { PageEvent } from '@angular/material/paginator';
import { CartService } from 'src/app/cart/cart.service';
import { lastValueFrom } from 'rxjs';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  public books: Book[] = [];
  public totalElements: number = 0;
  public request = {};

  constructor(private bookService: BookService,
    private cartService: CartService,
    private router: Router) { }

  ngOnInit(): void {
    this.getBooks({ page: "1", size: "5" });
  }

  private getBooks(request){
    this.bookService.getBooksList(request).subscribe(data => {
      this.books = data['content'];
      this.totalElements = data['totalElements'];
    })
  }

  nextPage(event: PageEvent) {
    this.request['page'] = event.pageIndex.toString();
    this.request['size'] = event.pageSize.toString();
    this.getBooks(this.request);
}

  navigateToBook(id: string){
    this.router.navigate(['books', id]);
  }

  addToCart(id: string) {
    this.cartService.addToCart(id).subscribe();
  }
}
