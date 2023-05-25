package mk.ukim.finki.emt.itemcatalog.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

public class ItemTitle implements ValueObject {
    private final String title;

    public ItemTitle(String title) {
        this.title = title;
    }
    public static ItemTitle of(String title) {
        return new ItemTitle(title);
    }
}
