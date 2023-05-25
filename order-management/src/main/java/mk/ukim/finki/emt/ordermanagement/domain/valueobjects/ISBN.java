package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ISBN extends DomainObjectId {
    private ISBN() {
        super(ISBN.randomId(ISBN.class).getId());
    }

    public ISBN(String uuid) {
        super(uuid);
    }
}
