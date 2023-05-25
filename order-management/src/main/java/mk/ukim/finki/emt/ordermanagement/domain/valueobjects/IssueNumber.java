package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

public class IssueNumber implements ValueObject {

    private final Long issueNumber;

    public IssueNumber(Long issueNumber) {
        this.issueNumber = issueNumber;
    }

    public static IssueNumber of(Long issueNumber) {
        return new IssueNumber(issueNumber);
    }
}
