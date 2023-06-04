export class CartItemWriteModel{
    private cartId:string;
    private productId: string;
    private quantity: number;
    constructor(cartId: string, productId: string, quantity: number){
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }
}