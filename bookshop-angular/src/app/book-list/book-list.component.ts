import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';
import { PageEvent } from '@angular/material/paginator';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  public books: Book[];
  public totalElements: number = 0;
  public request = {};

  constructor(private bookService: BookService,
    private router: Router) { }

  ngOnInit(): void {
    this.getBooks({ page: "0", size: "3" });
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

  bookDetails(id: number){
    this.router.navigate(['book-details', id]);
  }

  updateBook(id: number){
    this.router.navigate(['update-book', id]);
  }

  deleteBook(id:number){
      this.bookService.deleteBook(id).subscribe(data => {
        console.log(data);
        this.getBooks(this.request);
      });
  }


}
