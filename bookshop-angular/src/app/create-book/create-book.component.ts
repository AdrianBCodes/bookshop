import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Action } from 'rxjs/internal/scheduler/Action';
import { Book, BookCategory } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book();
  bookCategory = BookCategory;
  
  constructor(private bookService: BookService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveBook(){
    this.bookService.createBook(this.book).subscribe(data => {
      console.log(data);
      this.goToBookList();
    },
    error => console.error(error));
  }

  goToBookList(){
    this.router.navigate(['/books'])
  }

  onSubmit(){
      console.log(this.book);
      this.saveBook();
  }

}
