package service;

import model.Book;
import exception.BookNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Book book) {
        // Check for duplicate Book ID
        for (Book b : books) {
            if (b.getBookId().equals(book.getBookId())) {
                System.out.println("Book with ID " + book.getBookId() + " already exists.");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // View all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Search book by ID or title
    public Book searchBook(String idOrTitle) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(idOrTitle) ||
                    book.getTitle().equalsIgnoreCase(idOrTitle)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found.");
    }

    // Update book details
    public void updateBook(String bookId, String newTitle, String newAuthor, String newStatus) {
        boolean updated = false;

        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                if (newTitle != null && !newTitle.isEmpty()) book.setTitle(newTitle);
                if (newAuthor != null && !newAuthor.isEmpty()) book.setAuthor(newAuthor);
                if (newStatus != null && !newStatus.isEmpty()) book.setStatus(newStatus);
                updated = true;
                System.out.println("Book updated successfully.");
                break;
            }
        }

        if (!updated) {
            System.out.println("Book not found.");
        }
    }

    // Delete a book
    public void deleteBook(String bookId) {
        boolean deleted = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(bookId)) {
                books.remove(i);
                deleted = true;
                System.out.println("Book deleted successfully.");
                break;
            }
        }

        if (!deleted) {
            System.out.println("Book not found.");
        }
    }
}
