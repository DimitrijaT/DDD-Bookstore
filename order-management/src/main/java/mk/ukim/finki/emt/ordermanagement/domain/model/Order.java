package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.*;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Book;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();

//    private Order() {
//        super(OrderId.randomId(OrderId.class));
//    }

    public Order(Instant now, Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency = currency;
    }

    public Order() {

    }

    public Money total() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Book book, int qty) {
        Objects.requireNonNull(book, "product must not be null");
        var orderItem = new OrderItem(book.getId(), book.getPrice(), qty);
        orderItemList.add(orderItem);
        return orderItem;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId, "Order Item must not be null");
        orderItemList.removeIf(v -> v.getId().equals(orderItemId));
    }
}
