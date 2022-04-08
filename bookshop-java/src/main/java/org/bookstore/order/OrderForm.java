package org.bookstore.order;

import org.bookstore.order.DTO.OrderBookDTO;

import java.util.List;

public class OrderForm {

    private List<OrderBookDTO> bookOrders;

    public List<OrderBookDTO> getProductOrders() {
        return bookOrders;
    }

    public void setProductOrders(List<OrderBookDTO> bookOrders) {
        this.bookOrders = bookOrders;
    }
}