package org.bookstore.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bookstore.book.Book;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Entity
public class OrderBook {

    @EmbeddedId
    @JsonIgnore
    private OrderBookPK pk;

    @Column(nullable = false)
    private Integer quantity;

    public OrderBook() {
    }

    public OrderBook(Order order, Book book, Integer quantity) {
        pk = new OrderBookPK();
        pk.setOrder(order);
        pk.setBook(book);
        this.quantity = quantity;
    }

    public OrderBookPK getPk() {
        return pk;
    }

    public void setPk(OrderBookPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Transient
    public Book getBook() {
        return this.pk.getBook();
    }

    @Transient
    public BigDecimal getTotalPrice() {
        return getBook().getPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }
}