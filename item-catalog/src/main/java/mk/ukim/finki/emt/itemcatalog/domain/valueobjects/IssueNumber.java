package mk.ukim.finki.emt.itemcatalog.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

public class IssueNumber implements ValueObject {

        private final String issueNumber;

        public IssueNumber(String issueNumber) {
            this.issueNumber = issueNumber;
        }

        public String getIssueNumber() {
            return issueNumber;
        }
}
