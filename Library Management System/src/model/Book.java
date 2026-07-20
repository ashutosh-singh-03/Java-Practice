package model;

public class Book {
    private final String bookId;
    private final String title;
    private final String author;
    private final String category;
    private boolean isAvailable;

    public Book(String bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return """
                ----------------------------------------
                Book ID      : %s
                Title        : %s
                Author       : %s
                Category     : %s
                Available    : %s
                ----------------------------------------
                """.formatted(
                bookId,
                title,
                author,
                category,
                isAvailable ? "Yes" : "No"
        );
    }
}
