package org.bookshop.cart.cartItem;

public class CartItem {
    private String productId;
    private int quantity;

    public CartItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public void plusQuantity(){
//        quantity += 1;
//    }
//
//    public void minusQuantity(){
//        quantity -= 1;
//    }
//
//    public BigDecimal getTotalPrice(){
//        return productId.getPrice().multiply(BigDecimal.valueOf(quantity));
//    }
}
