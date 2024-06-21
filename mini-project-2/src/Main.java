import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Book> books = new ArrayList<>();

    public static Scanner lmsScanner = new Scanner(System.in);

    public static void addBook() {
        System.out.println("\nAdding a Book");
        System.out.print("Enter the book's title: ");
        String bookTitle = lmsScanner.nextLine();
        System.out.print("Enter the book's author: ");
        String bookAuthor = lmsScanner.nextLine();
        System.out.print("Enter the book's ISBN: ");
        String bookISBN = lmsScanner.nextLine();
        Book bookObject = new Book(bookTitle, bookAuthor, bookISBN);
        books.add(bookObject);
        System.out.println("\nBook Added. Press any key to continue...");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }

    public static void removeBook() {
        System.out.println("\nRemove Books");
        System.out.print("Enter the book's Title/Author/ISBN: ");
        String toDelete = lmsScanner.nextLine();
        List<Book> matchingBooks = books.stream()
                .filter(e -> toDelete.equalsIgnoreCase(e.getAuthor()) ||
                        toDelete.equalsIgnoreCase(e.getISBN()) ||
                        toDelete.equalsIgnoreCase(e.getTitle()))
                .toList();
        if (matchingBooks.isEmpty()) {
            System.out.println("\nNo books found with the provided search criteria.");
        } else {
            System.out.println("\nThe following books are removed:");
            for (Book book : matchingBooks) {
                book.getInfo();
            }
        }
        books = books.stream()
                .filter(e -> !toDelete.equalsIgnoreCase(e.getAuthor()) &&
                        !toDelete.equalsIgnoreCase(e.getISBN()) &&
                        !toDelete.equalsIgnoreCase(e.getTitle()))
                .toList();
        System.out.println("Book(s) Removed. Press any key to continue...");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }

    public static void searchBooks() {
        System.out.println("\nSearch Books");
        System.out.print("Enter the book's title/author/ISBN: ");
        String toSearch = lmsScanner.nextLine();
        List<Book> matchingBooks = books.stream()
                .filter(e -> toSearch.equalsIgnoreCase(e.getAuthor()) ||
                        toSearch.equalsIgnoreCase(e.getISBN()) ||
                        toSearch.equalsIgnoreCase(e.getTitle()))
                .toList();

        if (matchingBooks.isEmpty()) {
            System.out.println("\nNo books found with the provided search criteria.");
        } else {
            System.out.println("\nMatching books found:");
            for (Book book : matchingBooks) {
                book.getInfo();
            }
        }
        System.out.println("Press any key to continue...");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }


    }

    public static void showBooks() {
        if (books.isEmpty()) {
            System.out.println("\nNo books found");
        } else {
            System.out.println("\nShowing All Books");
            for (Book book : books) {
               book.getInfo();
            }
        }
        System.out.println("Press any key to continue...");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }


    }

    public static void main(String[] args) {
        Book book1 = new Book("Book Title", "Book Author", "123123123");

        try {
            System.out.println("Welcome to this Library Management System");
            System.out.println("-----------------------------------------");

            while (true) {
                System.out.println("\n[1] Add Book");
                System.out.println("[2] Remove Book");
                System.out.println("[3] Search Book");
                System.out.println("[4] Show All Books");
                System.out.println("[5] Exit");
                System.out.print("Enter Action Number: ");
                String action = lmsScanner.nextLine();

                switch (action) {
                    case "1":
                        addBook();
                        break;
                    case "2":
                        removeBook();
                        break;
                    case "3":
                        searchBooks();
                        break;
                    case "4":
                        showBooks();
                        break;
                    case "5":
                        return;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(books.get(0).getTitle());


    }
}