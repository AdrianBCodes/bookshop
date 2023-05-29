import { CartItem } from "./cartItem";

export class Cart {
    id: string;
    userId: string;
    items: CartItem[];

    constructor(fields: {
        id: string,
        userId: string,
        items: CartItem[]
    }) {
        this.id = fields.id;
        this.userId = fields.userId;
        this.items = fields.items;
    }
    
}