package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.*;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderItemForm;
import mk.ukim.finki.emt.ordermanagement.xport.BookClient;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookClient bookClient;


    private static Book newBook(
            ItemTitle title,
            Money price,
            TotalPages totalPages,
            List<Author> authorList) {
        Book b = new Book(ISBN.randomId(ISBN.class), title, price, totalPages, authorList);
        return b;
    }

    @Test
    public void testPlaceOrder() {

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setBook(newBook(ItemTitle.of("BOOk1"), Money.valueOf(Currency.MKD, 1500), TotalPages.of(100L), Arrays.asList(new Author("Author1", "Surname1"))));
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setBook(newBook(ItemTitle.of("BOOK2"), Money.valueOf(Currency.MKD, 1500), TotalPages.of(100L), Arrays.asList(new Author("Author2", "Surname2"))));
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setBooks(Arrays.asList(oi1, oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);
        Assertions.assertEquals(newOrder.total(), Money.valueOf(Currency.MKD, 2500));

    }

    @Test
    public void testPlaceOrderWithRealData() {
//        List<Book> BookList = BookClient.findAll();
//        Book p1 = BookList.get(0);
//        Book p2 = BookList.get(1);
//
//        OrderItemForm oi1 = new OrderItemForm();
//        oi1.setBook(p1);
//        oi1.setQuantity(1);
//
//        OrderItemForm oi2 = new OrderItemForm();
//        oi2.setBook(p2);
//        oi2.setQuantity(2);
//
//        OrderForm orderForm = new OrderForm();
//        orderForm.setCurrency(Currency.MKD);
//        orderForm.setItems(Arrays.asList(oi1, oi2));
//
//        OrderId newOrderId = orderService.placeOrder(orderForm);
//        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);
//
//        Money outMoney = p1.getPrice().multiply(oi1.getQuantity()).add(p2.getPrice().multiply(oi2.getQuantity()));
//        Assertions.assertEquals(newOrder.total(), outMoney);
    }


}