import Big from "big.js";
import { CartItem } from "./cartItem/cartItem";

export class Cart {
    userId: string;
    items: CartItem[];
    totalPrice: number;

    constructor(fields: {
        userId: string,
        items: CartItem[],
        totalPrice: number
    }) {
        this.userId = fields.userId;
        this.items = fields.items;
        this.totalPrice = fields.totalPrice
    }

    updateTotalPrice(): void {
        this.totalPrice = this.items.reduce((total, item) => total + item.totalPrice, 0);
    }
    
}