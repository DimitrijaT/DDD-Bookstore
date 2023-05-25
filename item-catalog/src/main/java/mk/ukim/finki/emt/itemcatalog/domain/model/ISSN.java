package mk.ukim.finki.emt.itemcatalog.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class ISSN extends DomainObjectId {
    public ISSN() {
        super(ISSN.randomId(ISSN.class).getId());
    }

    public ISSN(@NonNull String uuid) {
        super(uuid);
    }

    public static ISSN of(String uuid) {
        ISSN p = new ISSN(uuid);
        return p;
    }
}
