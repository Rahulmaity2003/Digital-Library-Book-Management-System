import model.Book;
import service.BookService;
import exception.BookNotFoundException;
import java.util.Scanner;

/**
 * Main entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookService service = new BookService();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Status (Available/Checked Out): ");
                    String status = sc.nextLine();

                    Book book = new Book(id, title, author, genre, status);
                    service.addBook(book);
                    break;

                case 2:
                    service.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID or Title: ");
                    String search = sc.nextLine();
                    try {
                        System.out.println(service.searchBook(search));
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to Update: ");
                    String updateId = sc.nextLine();
                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New Author: ");
                    String newAuthor = sc.nextLine();
                    System.out.print("New Status: ");
                    String newStatus = sc.nextLine();
                    service.updateBook(updateId, newTitle, newAuthor, newStatus);
                    break;

                case 5:
                    System.out.print("Enter Book ID to Delete: ");
                    String deleteId = sc.nextLine();
                    service.deleteBook(deleteId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
