import { CartItem } from "./cartItem/cartItem";

export class Cart {
    userId: string;
    items: CartItem[];
    totalPrice: number;

    constructor(fields?: {
        userId: string,
        items: CartItem[],
        totalPrice: number
    }) {
        this.userId = fields ? fields.userId : '';
        this.items = fields ? fields.items : [];
        this.totalPrice = fields ? fields.totalPrice : 0;
    }

    updateTotalPrice(): void {
        this.totalPrice = this.items.reduce((total, item) => total + item.totalPrice, 0);
    }
    
}