package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class AuthorId extends DomainObjectId {
    public AuthorId() {
        super(AuthorId.randomId(AuthorId.class).getId());
    }

    public AuthorId(@NonNull String uuid) {
        super(uuid);
    }

    public static AuthorId of(String uuid) {
        AuthorId p = new AuthorId(uuid);
        return p;
    }
}
