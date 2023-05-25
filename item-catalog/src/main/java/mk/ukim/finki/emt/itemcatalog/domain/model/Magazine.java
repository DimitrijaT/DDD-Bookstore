package mk.ukim.finki.emt.itemcatalog.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.emt.itemcatalog.domain.valueobjects.IssueNumber;
import mk.ukim.finki.emt.itemcatalog.domain.valueobjects.ItemTitle;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Getter
public class Magazine extends AbstractEntity<ISSN> implements Item {

    @AttributeOverride(name = "title", column = @Column(name = "magazine_title"))
    protected ItemTitle title;

    protected int sales;

    @AttributeOverride(name = "issueNumber", column = @Column(name = "issue_number"))
    private IssueNumber issueNumber;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    protected Money price;

    public Magazine(IssueNumber issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Magazine() {
        super(ISSN.randomId(ISSN.class));
    }
}
