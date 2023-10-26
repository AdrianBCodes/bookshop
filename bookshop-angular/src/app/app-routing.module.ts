import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookDetailsComponent } from './products/book/book-details/book-details.component';
import { CartComponent } from './cart/cart.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { BookListingPageComponent } from './pages/book-listing-page/book-listing-page.component';

const routes: Routes = [
  {path: 'books', component: BookListingPageComponent},
  {path: '', component: HomePageComponent},
  {path: 'books/:id', component: BookDetailsComponent},
  {path: 'cart', component: CartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
