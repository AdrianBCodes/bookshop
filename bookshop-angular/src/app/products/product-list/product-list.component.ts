import { Component, EventEmitter, Input, Output} from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/cart/cart.service';
import { Product } from '../product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  @Input() products: Product[] = [];
  @Input() headerTitle: string = '';
  @Input() isShowMoreActive: boolean = false;
  @Input() showMoreLink: string = '';
  @Input() isPageNavActive: boolean = false;
  @Output() nextPage: EventEmitter<void> = new EventEmitter<void>();
  @Output() previousPage: EventEmitter<void> = new EventEmitter<void>();

  constructor(
    private cartService: CartService,
    private router: Router) { }

  navigateToProductDetails(id: string){
    if(id.startsWith('Bk'))
      this.router.navigate(['books', id]);
  }

  addToCart(id: string) {
    this.cartService.addToCart(id).subscribe();
  }

  showMoreNavigation(){
    if(this.isShowMoreActive && this.showMoreLink != ''){
      this.router.navigate([this.showMoreLink]);
    }
  }

}
