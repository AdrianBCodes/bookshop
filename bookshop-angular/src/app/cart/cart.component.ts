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
  
  cart: Cart = new Cart({ id: '', userId: '', items: [] });

  constructor(private cartService: CartService) {
  }
  
  
  ngOnInit(): void {
      this.cartService.getCart('000000000000000000000001')
      .subscribe(data => 
        this.cart = data);
  }

  minusQuantity(item: CartItem){
    item.quantity-= 1;
  }

  plusQuantity(item: CartItem){
    item.quantity+= 1;
  }
}
