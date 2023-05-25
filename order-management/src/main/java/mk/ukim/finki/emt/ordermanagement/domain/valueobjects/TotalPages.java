package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

public class TotalPages implements ValueObject {
    private Long totalPages;

    public TotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public static TotalPages of(Long totalPages) {
        return new TotalPages(totalPages);
    }

}
