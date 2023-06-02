import { Product } from "../interfaces/product";

export class CartItem{
    id: string;
    cartId: string;
    product: Product;
    quantity: number;
}