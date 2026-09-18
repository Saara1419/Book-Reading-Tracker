import java.util.List;
import java.util.Scanner;

/**
 * Entry point for the Book Reading Tracker console application.
 * Lets a user add books, remove them, log reading progress,
 * and view an overall reading report.
 */
public class BookTrackerMain {

    private static BookService bookService = new BookService();
    private static ReportService reportService = new ReportService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("======================================");
        System.out.println(" Welcome to the Book Reading Tracker");
        System.out.println("======================================");

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    viewAllBooks();
                    break;
                case 4:
                    logProgress();
                    break;
                case 5:
                    reportService.printSummary(bookService.getAllBooks());
                    break;
                case 6:
                    running = false;
                    System.out.println("Happy reading! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("---- Menu ----");
        System.out.println("1. Add a book");
        System.out.println("2. Delete a book");
        System.out.println("3. View all books");
        System.out.println("4. Log reading progress");
        System.out.println("5. View report");
        System.out.println("6. Exit");
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        int totalPages = readInt("Enter total number of pages: ");

        Book book = bookService.addBook(title, author, totalPages);
        System.out.println("Book added successfully with ID " + book.getId() + ".");
    }

    private static void deleteBook() {
        if (bookService.isEmpty()) {
            System.out.println("No books to delete.");
            return;
        }
        int id = readInt("Enter the ID of the book to delete: ");
        boolean removed = bookService.deleteBook(id);
        System.out.println(removed ? "Book deleted successfully." : "No book found with that ID.");
    }

    private static void viewAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books added yet.");
            return;
        }
        System.out.println("---- Your Books ----");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static void logProgress() {
        if (bookService.isEmpty()) {
            System.out.println("No books to update.");
            return;
        }
        int id = readInt("Enter the ID of the book you read: ");
        int pages = readInt("Enter number of pages read: ");
        boolean updated = bookService.updateProgress(id, pages);
        if (updated) {
            Book book = bookService.findById(id);
            System.out.println("Progress updated: " + book);
            if (book.isCompleted()) {
                System.out.println("Congratulations! You finished \"" + book.getTitle() + "\".");
            }
        } else {
            System.out.println("No book found with that ID.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
