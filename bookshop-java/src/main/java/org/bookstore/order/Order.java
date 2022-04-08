package org.bookstore.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    private String status;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order")
    private List<OrderBook> orderBooks = new ArrayList<>();

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public List<OrderBook> getOrderBooks() {
        return orderBooks;
    }

    @Transient
    public BigDecimal getTotalOrderPrice() {
        BigDecimal sum = BigDecimal.ZERO;
        List<OrderBook> orderProducts = getOrderBooks();
        for (OrderBook op : orderProducts) {
            sum = op.getTotalPrice().add(sum);
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderBooks.size();
    }
}
