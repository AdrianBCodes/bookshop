import { Component, OnInit} from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { PageParams} from 'src/app/shared/interfaces/PageParams';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[] = [];
  totalElements: number = 0;
  totalPages: number = 0;
  params: PageParams = { page: 0, size: 5 };

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.getBooks(this.params)
  }

  private getBooks(params: PageParams){
    this.bookService.getBooksList(params).subscribe(data => {
      this.books = data['content'];
      this.totalElements = data['totalElements'];
      this.totalPages = data['totalPages'];
    })
  }

  nextPage() {
    if(this.params.page + 1 >= this.totalPages){
      return;
    }
    this.params.page += 1;
    this.getBooks(this.params);
  }

  previousPage() {
    if(this.params.page < 1)
      return;
    this.params.page -= 1;
    this.getBooks(this.params);
  }
}
