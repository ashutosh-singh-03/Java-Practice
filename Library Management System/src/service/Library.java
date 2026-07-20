package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import model.Book;
import model.Member;
import model.Transaction;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Transaction> transactions;
    private Scanner sc;

    private int transactionCounter = 1;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        transactions = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public boolean addBook(Book book) {
        if (book == null) return false;
        if (findBookById(book.getBookId()) != null) return false;
        books.add(book);
        return true;
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) System.out.println(book);
    }

    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(id)) return book;
        }
        return null;
    }

    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) list.add(book);
        }
        return list;
    }

    public ArrayList<Book> searchBooksByAuthor(String author) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) list.add(book);
        }
        return list;
    }

    public void showAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) System.out.println(book);
        }
    }

    public boolean addMember(Member member) {
        if (member == null) return false;
        if (findMemberById(member.getMemberId()) != null) return false;
        members.add(member);
        return true;
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        for (Member member : members) System.out.println(member);
    }

    public Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(id)) return member;
        }
        return null;
    }

    public boolean issueBook(String bookId, String memberId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Book already issued.");
            return false;
        }

        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(transactionId, book, member, LocalDate.now());
        transactions.add(transaction);

        book.setAvailable(false);

        System.out.println("Book issued successfully.");
        return true;
    }

    public void displayIssuedBooks() {
        boolean found = false;

        for (Transaction transaction : transactions) {
            if (!transaction.isReturned()) {
                System.out.println(transaction);
                found = true;
            }
        }

        if (!found)
            System.out.println("No issued books.");
    }

    public void displayReturnedBooks() {
        boolean found = false;

        for (Transaction transaction : transactions) {
            if (transaction.isReturned()) {
                System.out.println(transaction);
                found = true;
            }
        }

        if (!found) System.out.println("No returned books.");
    }

    private String generateTransactionId() {
        return "T" + transactionCounter++;
    }

    public boolean returnBook(String id) {
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        Transaction transaction = findActiveTransaction(book);
        if (transaction == null) {
            System.out.println("Book is not currently issued.");
            return false;
        }
        transaction.setReturned(true);
        transaction.setReturnDate(LocalDate.now());

        book.setAvailable(true);
        System.out.println("Book returned successfully.");
        return true;
    }

    private Transaction findActiveTransaction(Book book) {
        for (Transaction transaction : transactions) {
            if (transaction.getBook().equals(book) && !transaction.isReturned()) return transaction;
        }
        return null;
    }

    public void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private void addBookMenu() {
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Book Category: ");
        String category = sc.nextLine();

        Book book = new Book(bookId, title, author, category);

        if (addBook(book)) System.out.println("Book added successfully");
        else System.out.println("Book not added or already exist.");
    }

    private void addMemberMenu() {
        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();
        System.out.print("Enter Name of the member: ");
        String name = sc.nextLine();
        System.out.print("Enter 10 Digit Phone Number: ");
        String phone = sc.nextLine();
        if (phone.length() != 10) {
            System.out.println("Enter 10 digits number.");
            return;
        }

        Member member = new Member(memberId, name, phone);
        if (addMember(member)) System.out.println("Member added successfully");
        else System.out.println("Member not added or already exist.");
    }

    private void searchBookByAuthorMenu() {

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        ArrayList<Book> booksFound = searchBooksByAuthor(author);

        if (booksFound.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : booksFound) {
                System.out.println(book);
            }
        }
    }

    private void searchBookByIdMenu() {

        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        Book book = findBookById(bookId);

        if (book == null)
            System.out.println("Book not found.");
        else
            System.out.println(book);
    }

    private void searchMemberMenu() {

        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();

        Member member = findMemberById(memberId);

        if (member == null)
            System.out.println("Book not found.");
        else
            System.out.println(member);
    }

    private void searchBookByTitleMenu() {

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        ArrayList<Book> booksFound = searchBooksByTitle(title);

        if (booksFound.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book book : booksFound)
            System.out.println(book);
    }

    private void issueBookMenu() {

        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();

        issueBook(bookId, memberId);
    }

    private void returnBookMenu() {

        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        returnBook(bookId);
    }

    private void pause() {
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }

    public void start() {
        while (true) {
            System.out.println("\n==========================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1.  Add Book");
            System.out.println("2.  Add Member");
            System.out.println("3.  Display All Books");
            System.out.println("4.  Display All Members");
            System.out.println("5.  Search Book by ID");
            System.out.println("6.  Search Book by Title");
            System.out.println("7.  Search Book by Author");
            System.out.println("8.  Search Member by ID");
            System.out.println("9.  Issue Book");
            System.out.println("10. Return Book");
            System.out.println("11. Show Available Books");
            System.out.println("12. Display Transactions");
            System.out.println("13. Display Issued Books");
            System.out.println("14. Display Returned Books");
            System.out.println("0.  Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    addBookMenu();
                    pause();
                }
                case 2 -> {
                    addMemberMenu();
                    pause();
                }
                case 3 -> {
                    displayBooks();
                    pause();
                }
                case 4 -> {
                    displayMembers();
                    pause();
                }
                case 5 -> {
                    searchBookByIdMenu();
                    pause();
                }
                case 6 -> {
                    searchBookByTitleMenu();
                    pause();
                }
                case 7 -> {
                    searchBookByAuthorMenu();
                    pause();
                }
                case 8 -> {
                    searchMemberMenu();
                    pause();
                }
                case 9 -> {
                    issueBookMenu();
                    pause();
                }
                case 10 -> {
                    returnBookMenu();
                    pause();
                }
                case 11 -> {
                    showAvailableBooks();
                    pause();
                }
                case 12 -> {
                    displayTransactions();
                    pause();
                }
                case 13 -> {
                    displayIssuedBooks();
                    pause();
                }
                case 14 -> {
                    displayReturnedBooks();
                    pause();
                }
                case 0 -> {
                    System.out.println("Thank You for Visiting Library.");
                    return;
                }
                default -> System.out.println("Enter a valid choice.");
            }
        }
    }

}
