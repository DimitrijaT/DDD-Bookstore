package mk.ukim.finki.emt.ordermanagement.service.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;

//import javax.validation.Valid;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


//Може да ни биде анемичен.
@Data
@Getter
public class OrderForm {

    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty //Секоја нарачка мора да има барем една ставка!
    private List<OrderItemForm> books = new ArrayList<>();

}