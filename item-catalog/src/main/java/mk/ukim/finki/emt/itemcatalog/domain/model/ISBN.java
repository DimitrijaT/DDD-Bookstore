package mk.ukim.finki.emt.itemcatalog.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class ISBN extends DomainObjectId {
    public ISBN() {
        super(ISBN.randomId(ISBN.class).getId());
    }

    public ISBN(@NonNull String uuid) {
        super(uuid);
    }

    public static ISBN of(String uuid) {
        ISBN p = new ISBN(uuid);
        return p;
    }
}
