import { Component, OnInit } from '@angular/core';
import { Cart } from './cart';
import { CartItem } from './cartItem';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  
  cart: Cart;

  constructor(private cartService: CartService) {
  }
  
  
  ngOnInit(): void {
    if(this.cart == undefined){
      this.cart = this.cartService.getCart();
    }
  }

  minusQuantity(item: CartItem){
    item.quantity-= 1;
  }

  plusQuantity(item: CartItem){
    item.quantity+= 1;
  }
}
