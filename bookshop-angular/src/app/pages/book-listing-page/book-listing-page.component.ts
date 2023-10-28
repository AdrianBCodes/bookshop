import { Component } from '@angular/core';
import { Book } from 'src/app/products/book/book';
import { BookService } from 'src/app/products/book/book.service';
import { PageParams } from 'src/app/shared/interfaces/PageParams';

@Component({
  selector: 'app-book-listing-page',
  templateUrl: './book-listing-page.component.html',
  styleUrls: ['./book-listing-page.component.css']
})
export class BookListingPageComponent {
  books: Book[] = [];
  totalElements: number = 0;
  totalPages: number = 0;
  params: PageParams = { page: 0, size: 20 };
  categoriesMap: Map<String, Number> = new Map()

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
