import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookListingPageComponent } from './book-listing-page.component';

describe('BookListingPageComponent', () => {
  let component: BookListingPageComponent;
  let fixture: ComponentFixture<BookListingPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookListingPageComponent]
    });
    fixture = TestBed.createComponent(BookListingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
