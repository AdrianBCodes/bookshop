import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookDetailsComponent } from './book/book-details/book-details.component';
import { BookListComponent } from './book/book-list/book-list.component';
import { CartComponent } from './cart/cart.component';

const routes: Routes = [
  {path: 'books', component: BookListComponent},
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  {path: 'books/:id', component: BookDetailsComponent},
  {path: 'cart', component: CartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
