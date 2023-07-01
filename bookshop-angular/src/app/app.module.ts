import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './products/book/book-list/book-list.component';
import { FormsModule } from '@angular/forms';
import { BookDetailsComponent } from './products/book/book-details/book-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatPaginatorModule } from '@angular/material/paginator';
import { CartComponent } from './cart/cart.component';
import { ButtonCustomComponent } from './shared/components/button-custom/button-custom.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProductListComponent } from './products/product-list/product-list.component';
import { BookListingPageComponent } from './pages/book-listing-page/book-listing-page.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookDetailsComponent,
    CartComponent,
    ButtonCustomComponent,
    HomePageComponent,
    ProductListComponent,
    BookListingPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
