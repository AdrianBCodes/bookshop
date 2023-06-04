export class CartItemWriteModel{
    quantity: number;
    
    constructor(private cartId:string, private productId: string){
        this.quantity = 1;
    }
}