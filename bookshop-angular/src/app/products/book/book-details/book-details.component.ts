import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';
import { CartService } from 'src/app/cart/cart.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  id: string;
  book: Book;

  constructor(private route: ActivatedRoute,
    private bookService: BookService,
    private cartService: CartService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.bookService.getBookById(this.id).subscribe(data => {
      this.book = data;
    })
  }

  addToCart(id: string) {
    this.cartService.addToCart(id).subscribe();
  }

}
