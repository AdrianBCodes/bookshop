import { Component, OnInit } from '@angular/core';
import { Cart } from './cart';
import { CartItem } from './cartItem/cartItem';
import { CartService } from './cart.service';
import Big from 'big.js';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  
  cart: Cart = new Cart({ userId: '', items: [], totalPrice: 0 });

  constructor(private cartService: CartService) {
  }
  
  
  ngOnInit(): void {
      this.cartService.getCart('000000000000000000000001')
      .subscribe(data =>{
        this.cart = new Cart(data)
      });
 
        
  }

  minusQuantity(item: CartItem){
    if(item.quantity > 1){
      item.quantity-= 1;
      item.totalPrice = this.calculateCartItemTotalPrice(item.quantity, Number(item.product.price));
      this.cart.updateTotalPrice()
      this.cartService.editCartItem(item).subscribe();
    }

  }

  plusQuantity(item: CartItem){
    item.quantity+= 1;
    item.totalPrice = this.calculateCartItemTotalPrice(item.quantity, Number(item.product.price));
    this.cart.updateTotalPrice()
    this.cartService.editCartItem(item).subscribe();
  }

  calculateCartItemTotalPrice(quantity: number, price: number): number {
    return price * quantity;
  }
}
