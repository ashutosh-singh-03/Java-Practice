package model;

import java.time.LocalDate;

public class Transaction {
    private final String transactionId;
    private final Book book;
    private final Member member;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean isReturned;

    public Transaction(String transactionId, Book book, Member member, LocalDate issueDate) {
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.returnDate = null;
        this.isReturned = false;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return """
                ----------------------------------------
                Transaction ID : %s
                Book           : %s
                Member         : %s
                Issue Date     : %s
                Return Date    : %s
                Status         : %s
                ----------------------------------------
                """.formatted(
                transactionId,
                book.getTitle() + " (" + book.getBookId() + ")",
                member.getName() + " (" + member.getMemberId() + ")",
                issueDate,
                returnDate == null ? "Not Returned" : returnDate,
                isReturned ? "Returned" : "Issued"
        );
    }
}
