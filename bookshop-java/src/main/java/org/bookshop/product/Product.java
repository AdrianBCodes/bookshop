package org.bookshop.product;

import java.math.BigDecimal;

public interface Product {
    String getId();
    String getName();
    BigDecimal getPrice();
}
