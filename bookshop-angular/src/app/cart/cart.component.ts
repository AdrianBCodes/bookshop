import { Component, OnInit } from '@angular/core';
import { Cart } from './cart';
import { CartItem } from './cartItem/cartItem';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  
  cart: Cart = new Cart();

  constructor(private cartService: CartService) {
  }
  
  
  ngOnInit(): void {
      this.cartService.getCart('000000000000000000000001')
      .subscribe(data =>{
        this.cart = new Cart(data)
      });
 
        
  }

  minusQuantity(item: CartItem){
    if(item.quantity <= 1)
      return;
    item.quantity-= 1;
    item.totalPrice = this.calculateCartItemTotalPrice(item.quantity, Number(item.product.price));
    this.cart.updateTotalPrice()
    this.cartService.editCartItem(item).subscribe();

  }

  plusQuantity(item: CartItem){
    if(item.quantity < 1)
      return
    item.quantity+= 1;
    item.totalPrice = this.calculateCartItemTotalPrice(item.quantity, Number(item.product.price));
    this.cart.updateTotalPrice()
    this.cartService.editCartItem(item).subscribe();
  }

  calculateCartItemTotalPrice(quantity: number, price: number): number {
    return price * quantity;
  }

  isQuantityButtonDisabled(quantity: number): boolean{
    if(quantity <= 1)
      return true;
    return false;
  }

  verifyQuantity(item: CartItem): void {
    if(item.quantity < 1)
      item.quantity = 1;
  }

  onInputQuantityChange(event: Event, item: CartItem): void{
    const inputElement = event.target as HTMLInputElement;
    const inputValue = parseInt(inputElement.value, 10);
    
    console.log(inputElement);
    console.log(inputValue);

    if(inputElement.value=='')
      return;


    if(isNaN(inputValue) || inputValue < 1) {
      item.quantity = 1;
      inputElement.value = '1';
    }
    if(inputValue > 99){
      item.quantity = 99;
      inputElement.value = '99';
    }

    item.totalPrice = this.calculateCartItemTotalPrice(item.quantity, Number(item.product.price));
    this.cart.updateTotalPrice()
    this.cartService.editCartItem(item).subscribe();
  }
}
