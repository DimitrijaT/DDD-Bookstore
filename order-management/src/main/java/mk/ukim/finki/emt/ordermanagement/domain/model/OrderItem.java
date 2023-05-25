package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.ISBN;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "product_id"))
    private ISBN isbn;

    public OrderItem() {
    }

    public Money subtotal() {
        return itemPrice.multiply(quantity);
    }

    public OrderItem(@NonNull ISBN isbn, @NonNull Money itemPrice, int qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.isbn = isbn;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

}

