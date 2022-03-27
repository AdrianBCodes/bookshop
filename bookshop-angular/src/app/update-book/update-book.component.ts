import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book, BookCategory } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  id: number;
  book: Book = new Book();
  bookCategory = BookCategory;

  constructor(private bookService: BookService,
    private route: ActivatedRoute,
    private router: Router) {
   }

  ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];

      this.bookService.getBookById(this.id).subscribe({
        next: (data) => this.book = data,
        error: (error) => console.error()
      })
  }

  onSubmit(){
    this.bookService.updateBook(this.id, this.book).subscribe(data =>{
    this.goToBookList();
    }, error => console.error(error));
  }

  goToBookList(){
    this.router.navigate(['/books']);
  }

}
