import { Injectable } from '@angular/core';
import { Cart } from './cart';
import { CartItem } from './cartItem';
import Big from 'big.js';
import { Product } from '../interfaces/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: Cart = {
    id: '1',
    userId: '1',
    items: [{
      product: {
        id: '1',
        name: 'productName1',
        price: new Big(100.98)
      },
      quantity: 10
    }]
  };

  constructor() { }

  getCart(){
    return this.cart;
  }

  addToCart(productToAdd: Product){
    this.cart.items.push({
      product: productToAdd,
      quantity: 1
    });
  }
}
